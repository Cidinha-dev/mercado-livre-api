package com.aparecida.mercadoLivre.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para a rota raiz e endpoints de saúde da aplicação
 */
@RestController
public class HomeController {

    /**
     * Endpoint principal da aplicação
     * GET http://localhost:8080/
     */
    @GetMapping("/")
    public ResponseEntity<String> home() {
        String mensagem = "API Mercado Livre - Detalhes de Itens\n\n" +
                " Endpoints disponíveis:\n" +
                "• GET /api/itens           - Lista todos os itens\n" +
                "• GET /api/itens/{id}      - Detalhes de um item específico\n" +
                "• GET /api/itens/{id}/descricao - Descrição do item\n" +
                "• GET /api/itens/{id}/disponibilidade - Verifica disponibilidade\n\n" +
                " Exemplo: http://localhost:8080/api/itens/MLA123456789";

        return ResponseEntity.ok(mensagem);
    }

    /**
     * Endpoint de saúde da aplicação
     * GET http://localhost:8080/health
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("API está funcionando corretamente!");
    }
}