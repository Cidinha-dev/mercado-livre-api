package com.aparecida.mercadoLivre.model;

import lombok.Data;

/**
 * Representa um vendedor do Mercado Livre
 */
@Data
public class Vendedor {
    private Long id;                    // ID do vendedor
    private String apelido;             // Apelido/nickname do vendedor
    private String reputacao;           // Reputação (ex: "verde", "amarela")
    private Integer totalTransacoes;    // Total de transações realizadas
    private String dataRegistro;        // Data de registro no Mercado Livre
}
