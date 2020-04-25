package com.algaworks.osworks.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.algaworks.osworks.domain.exception.NegocioException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = { "id" })
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;
	
	@OneToMany(mappedBy = "ordemServico")
	private List<Comentario> comentarios = new ArrayList<>();
	
	private String descricao;
	private BigDecimal preco;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;
	
	public void finalizar() {
		if (naoPodeSerFinalizada())
			throw new NegocioException("Ordem de serviço não pode ser finalizada.");
		
		setStatus(StatusOrdemServico.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
	}
	
	public void cancelar() {
		if (naoPodeSerFinalizada())
			throw new NegocioException("Ordem de serviço não pode ser cancelada.");
		
		setStatus(StatusOrdemServico.CANCELADA);
		setDataFinalizacao(OffsetDateTime.now());
	}
	
	private boolean podeSerFinalizada() {
		return StatusOrdemServico.ABERTA.equals(getStatus());
	}
	
	private boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}
	
}
