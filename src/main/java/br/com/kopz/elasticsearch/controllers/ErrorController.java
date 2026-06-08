package br.com.kopz.elasticsearch.controllers;

import br.com.kopz.elasticsearch.domain.dtos.ErrorDto;
import br.com.kopz.elasticsearch.exceptions.BaseException;
import br.com.kopz.elasticsearch.exceptions.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class ErrorController {

  @ExceptionHandler(StorageException.class)
  public ResponseEntity<ErrorDto> handleStorageException(StorageException ex) {
    log.error("Caught StorageException", ex);

    var errorDto = ErrorDto.builder()
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message("Unable to save or retrieve resources at this time")
        .build();

    return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorDto> handleBaseException(BaseException ex) {
    log.error("Caught StorageException", ex);

    var errorDto = ErrorDto.builder()
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message("An unexpected error occurred")
        .build();

    return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDto> handleException(Exception ex) {
    log.error("Caught unexpected exception", ex);

    var errorDto = ErrorDto.builder()
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message("An unexpected error ocurred")
        .build();

    return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
