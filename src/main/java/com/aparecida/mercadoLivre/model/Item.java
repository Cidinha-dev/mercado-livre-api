package com.aparecida.mercadoLivre.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

/**
 * Modelo de Dados - Entities
 * Representa um item/produto do Mercado Livre
 * Lombok gera automaticamente os getters, setters, equals, hashCode, toString
 */
@Data
public class Item {
    private String id;
    private String titulo;
    private BigDecimal preco;
    private String moeda;
    private String condicao;
    private Boolean freteGratis;
    private Integer quantidadeVendida;
    private Integer quantidadeDisponivel;
    private List<String> fotos;
    private String descricao;
    private Vendedor vendedor;
}
