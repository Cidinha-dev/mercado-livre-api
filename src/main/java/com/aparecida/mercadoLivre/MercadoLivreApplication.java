package com.aparecida.mercadoLivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal
 * Porta de entrada da aplicacao
 */
@SpringBootApplication
public class MercadoLivreApplication {

	public static void main(String[] args) {
		// Inicia aplicacao Spring
		SpringApplication.run(MercadoLivreApplication.class, args);

		System.out.println("Aplicação Mercado Livre iniciada com sucesso!!!");
		System.out.println("Acesse: http://localhost:8080");
	}

}
