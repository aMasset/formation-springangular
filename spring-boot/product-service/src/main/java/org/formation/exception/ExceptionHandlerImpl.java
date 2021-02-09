package org.formation.exception;

import org.formation.records.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServlet;
import java.util.Date;

public class ExceptionHandlerImpl extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProduitNotFoundException.class, EntityNotFoundException.class})
    ResponseEntity<Object> handleNotFoundEception(HttpServlet request, Throwable ex) {
        ErrorDto error = new ErrorDto(ex.getMessage(), new Date());
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
