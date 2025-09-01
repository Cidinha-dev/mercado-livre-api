package com.aparecida.mercadoLivre.exception;

import com.aparecida.mercadoLivre.exception.ItemNaoEncontradoException;
import com.aparecida.mercadoLivre.model.RespostaErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ManipuladorExcecoes {

  /**
   * Este método JÁ captura ItemNaoEncontradoException automaticamente
   * porque ela é uma RuntimeException (e RuntimeException herda de Exception)
   */
  @ExceptionHandler(ItemNaoEncontradoException.class)
  public ResponseEntity<RespostaErro> handleItemNaoEncontrado(
          ItemNaoEncontradoException ex, WebRequest request) {

    RespostaErro erro = new RespostaErro(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Item Não Encontrado",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
    );

    return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
  }

  /**
   * Este método captura TODAS as outras exceções não tratadas
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<RespostaErro> handleExceptionGeral(
          Exception ex, WebRequest request) {

    RespostaErro erro = new RespostaErro(
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Erro Interno do Servidor",
            "Ocorreu um erro inesperado: " + ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
    );

    return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}