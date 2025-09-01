package com.aparecida.mercadoLivre.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Modelo para padronizar respostas de erro da API
 */
@Data
@AllArgsConstructor
public class RespostaErro {
    private LocalDateTime timestamp;    // Quando o erro ocorreu
    private Integer status;             // Código HTTP do erro
    private String erro;                // Tipo do erro
    private String mensagem;            // Mensagem detalhada
    private String caminho;             // URL onde ocorreu o erro
}
