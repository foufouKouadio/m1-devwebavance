package org.m1.web.rest.example.presentation;

import org.m1.web.rest.example.errors.EtudiantNonTrouveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class EtudiantsControllerAdvice {
  
    @ExceptionHandler(EtudiantNonTrouveException.class)
    protected ResponseEntity<Object> gererLesEtudiantsNonTrouves(RuntimeException e, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'étudiant n'a pas été trouvé");
    }
    
}
