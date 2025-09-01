package com.aparecida.mercadoLivre.controller;

import com.aparecida.mercadoLivre.model.Item;
import com.aparecida.mercadoLivre.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelos endpoints da API REST
 * Define as rotas que os clientes podem acessar
 */
@RestController
@RequestMapping("/api/itens")
public class ItemController {

    private final ItemService itemService;

    // Injeção de dependência do serviço
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * Endpoint para buscar detalhes de um item específico
     * GET /api/itens/{id}
     * @param id ID do item (ex: MLA123456789)
     * @return Detalhes completos do item
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarItem(@PathVariable String id) {
        Item item = itemService.buscarItemPorId(id);
        return ResponseEntity.ok(item); // Retorna 200 OK com o item
    }

    /**
     * Endpoint para buscar apenas a descrição de um item
     * GET /api/itens/{id}/descricao
     * @param id ID do item
     * @return Apenas a descrição do item
     */
    @GetMapping("/{id}/descricao")
    public ResponseEntity<String> buscarDescricao(@PathVariable String id) {
        String descricao = itemService.buscarDescricaoItem(id);
        return ResponseEntity.ok(descricao);
    }

    /**
     * Endpoint para listar todos os itens disponíveis
     * GET /api/itens
     * @return Lista de todos os itens
     */
    @GetMapping
    public ResponseEntity<List<Item>> listarTodosItens() {
        List<Item> itens = itemService.buscarTodosItens();
        return ResponseEntity.ok(itens);
    }

    /**
     * Endpoint para verificar disponibilidade de um item
     * GET /api/itens/{id}/disponibilidade
     * @param id ID do item
     * @return true se disponível, false se esgotado
     */
    @GetMapping("/{id}/disponibilidade")
    public ResponseEntity<Boolean> verificarDisponibilidade(@PathVariable String id) {
        boolean disponivel = itemService.verificarDisponibilidade(id);
        return ResponseEntity.ok(disponivel);
    }

    /**
     * Cadastra um novo item
     * POST /api/itens
     * @param item Dados do item a ser cadastrado
     * @return Item cadastrado
     */
    @PostMapping
    public ResponseEntity<Item> cadastrarItem(@RequestBody Item item) {
        Item itemSalvo = itemService.cadastrarItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemSalvo);
    }

    /**
     * Atualiza um item existente
     * PUT /api/itens/{id}
     * @param id ID do item
     * @param item Novos dados do item
     * @return Item atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizarItem(
            @PathVariable String id,
            @RequestBody Item item) {

        Item itemAtualizado = itemService.atualizarItem(id, item);
        return ResponseEntity.ok(itemAtualizado);
    }

    /**
     * Remove um item
     * DELETE /api/itens/{id}
     * @param id ID do item a ser removido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable String id) {
        itemService.deletarItem(id);
        return ResponseEntity.noContent().build();
    }
}