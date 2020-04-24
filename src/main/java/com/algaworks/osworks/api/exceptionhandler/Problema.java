package com.algaworks.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@JsonInclude(Include.NON_EMPTY)
@RequiredArgsConstructor
public class Problema {
	
	@NonNull
	@Getter @Setter
	private Integer status;
	
	@NonNull
	@Getter @Setter
	private LocalDateTime dataHora;
	
	@NonNull
	@Getter @Setter
	private String titulo;
	
	@NonNull
	@Getter @Setter
	private List<Campo> campos;
	
	@RequiredArgsConstructor
	public static class Campo {
		
		@NonNull
		@Getter @Setter
		private String nome;
		
		@NonNull
		@Getter @Setter
		private String mensagem;
		
	}

}
