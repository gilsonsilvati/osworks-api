package com.algaworks.osworks.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Long id;
	
	@NonNull
	@NotBlank
	@Size(max = 60)
	@Getter @Setter
	private String nome;
	
	@NonNull
	@NotBlank
	@Email
	@Size(max = 255)
	@Getter @Setter
	private String email;
	
	@NonNull
	@NotBlank
	@Size(max = 20)
	@Getter @Setter
	private String telefone;

}
