package com.aparecida.mercadoLivre.repository;

import com.aparecida.mercadoLivre.exception.ItemNaoEncontradoException;
import com.aparecida.mercadoLivre.model.Item;
import com.aparecida.mercadoLivre.model.Vendedor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.*;

/**
 * Repositório responsável por acessar e manipular os dados dos itens
 * Simula um banco de dados usando arquivos JSON
 */
@Repository
public class ItemRepository {

    // Lista em memória para armazenar os itens (simula banco de dados)
    private final Map<String, Item> itens = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Método executado automaticamente após a inicialização do repositorio
     * Carrega os dados dos arquivos JSON para a memória
     */
    @PostConstruct
    public void inicializar() {
        try {
            // Carrega itens do arquivo JSON
            Item[] itensArray = objectMapper.readValue(
                    Paths.get("src/main/resources/data/itens.json").toFile(),
                    Item[].class
            );

            // Adiciona todos os itens no mapa em memória
            for (Item item : itensArray) {
                itens.put(item.getId(), item);
            }

            System.out.println("SUCESSO" + itens.size() + " itens carregados com sucesso!");

        } catch (IOException e) {
            System.err.println("ERRO ao carregar dados: " + e.getMessage());
            // Inicializa com dados de exemplo em caso de erro
            inicializarDadosExemplo();
        }
    }

    /**
     * Busca um item pelo ID
     * @param id ID do item a ser buscado
     * @return Item encontrado
     * @throws ItemNaoEncontradoException se o item não existir
     */
    public Item buscarPorId(String id) throws Throwable {
        Item item = itens.get(id);
        if (item == null) {
            throw new Throwable("Item com ID " + id + " não encontrado");
        }
        return item;
    }

    /**
     * Busca todos os itens disponíveis
     * @return Lista de todos os itens
     */
    public List<Item> buscarTodos() {
        return new ArrayList<>(itens.values());
    }


    /**
     * Inicializa com dados de exemplo caso o arquivo JSON não exista
     */
    private void inicializarDadosExemplo() {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(12345L);
        vendedor.setApelido("loja_oficial");
        vendedor.setReputacao("verde");
        vendedor.setTotalTransacoes(1500);
        vendedor.setDataRegistro("2020-05-15");

        Item item = new Item();
        item.setId("MLA123456789");
        item.setTitulo("iPhone 13 Pro Max 256GB");
        item.setPreco(new BigDecimal("4500.00"));
        item.setMoeda("BRL");
        item.setCondicao("novo");
        item.setFreteGratis(true);
        item.setQuantidadeVendida(150);
        item.setQuantidadeDisponivel(25);
        item.setFotos(Arrays.asList(
                "https://example.com/foto1.jpg",
                "https://example.com/foto2.jpg"
        ));
        item.setDescricao("iPhone 13 Pro Max 256GB, cor grafite, com garantia de 1 ano");
        item.setVendedor(vendedor);

        itens.put(item.getId(), item);
        System.out.println("Dados de exemplo carregados");
    }


    /**
     * Salva um novo item no repositório
     * @param item Item a ser salvo
     * @return Item salvo
     */
    public Item salvar(Item item) {
        // Gera ID único se não tiver
        if (item.getId() == null || item.getId().isEmpty()) {
            item.setId("MLA" + System.currentTimeMillis());
        }

        itens.put(item.getId(), item);
        salvarNoArquivo(); // Salva no JSON
        return item;
    }

    /**
     * Atualiza um item existente
     * @param id ID do item
     * @param item Novos dados do item
     * @return Item atualizado
     */
    public Item atualizar(String id, Item item) {
        if (!itens.containsKey(id)) {
            throw new ItemNaoEncontradoException("Item com ID " + id + " não encontrado para atualização");
        }

        item.setId(id); // Garante que o ID não seja alterado
        itens.put(id, item);
        salvarNoArquivo();
        return item;
    }

    /**
     * Remove um item
     * @param id ID do item a ser removido
     */
    public void deletar(String id) {
        if (!itens.containsKey(id)) {
            throw new ItemNaoEncontradoException("Item com ID " + id + " não encontrado para exclusão");
        }

        itens.remove(id);
        salvarNoArquivo();
    }

    /**
     * Salva os dados no arquivo JSON
     */
    private void salvarNoArquivo() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    Paths.get("src/main/resources/data/itens.json").toFile(),
                    itens.values() // Pega todos os valores do mapa
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar dados no arquivo", e);
        }
    }
}