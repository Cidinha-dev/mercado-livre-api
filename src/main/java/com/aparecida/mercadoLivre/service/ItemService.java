package com.aparecida.mercadoLivre.service;

import com.aparecida.mercadoLivre.model.Item;
import com.aparecida.mercadoLivre.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pela lógica de negócio dos itens
 * Aqui ficam as regras e processamentos complexos
 */
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    // Injeção de dependência via construtor (melhor prática)
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * Busca um item pelo ID
     * @param id ID do item a ser buscado
     * @return Item encontrado
     */
    public Item buscarItemPorId(String id) {
        try {
            return itemRepository.buscarPorId(id);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca a descrição de um item específico
     * @param id ID do item
     * @return Descrição do item
     */
    public String buscarDescricaoItem(String id) {
        Item item = null;
        try {
            item = itemRepository.buscarPorId(id);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return item.getDescricao();
    }

    /**
     * Busca todos os itens disponíveis
     * @return Lista de todos os itens
     */
    public List<Item> buscarTodosItens() {
        return itemRepository.buscarTodos();
    }

    /**
     * Verifica se um item está disponível para compra
     * @param id ID do item
     * @return true se estiver disponível, false caso contrário
     */
    public boolean verificarDisponibilidade(String id) {
        Item item = null;
        try {
            item = itemRepository.buscarPorId(id);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return item.getQuantidadeDisponivel() > 0;
    }


    /**
     * Cadastra um novo item
     * @param item Item a ser cadastrado
     * @return Item cadastrado
     */
    public Item cadastrarItem(Item item) {
        return itemRepository.salvar(item);
    }

    /**
     * Atualiza um item existente
     * @param id ID do item
     * @param item Novos dados do item
     * @return Item atualizado
     */
    public Item atualizarItem(String id, Item item) {
        return itemRepository.atualizar(id, item);
    }

    /**
     * Remove um item
     * @param id ID do item a ser removido
     */
    public void deletarItem(String id) {
        itemRepository.deletar(id);
    }
}