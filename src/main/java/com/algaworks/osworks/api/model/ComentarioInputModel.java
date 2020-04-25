package com.algaworks.osworks.api.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ComentarioInputModel {
	
	@NotBlank
	private String descricao;

}
