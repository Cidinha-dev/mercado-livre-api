package com.aparecida.mercadoLivre.exception;

/**
 * Exceção não verificada (unchecked) para itens não encontrados
 * Não precisa declarar 'throws' nos métodos
 */
public class ItemNaoEncontradoException extends RuntimeException {

    public ItemNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}