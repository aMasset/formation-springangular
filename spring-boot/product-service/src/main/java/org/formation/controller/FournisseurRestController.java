package org.formation.controller;

import org.formation.model.Fournisseur;
import org.formation.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurRestController {

    @Autowired
    FournisseurRepository fournisseurRepository;

    @GetMapping("/search")
    public List<Fournisseur> findByReference(@RequestParam String q) {
        return fournisseurRepository.findByNomContainingIgnoreCase(q);
    }

    @PostMapping
    ResponseEntity<Fournisseur> createFournisseur(@Valid @RequestBody Fournisseur fournisseur) {

        fournisseur = fournisseurRepository.save(fournisseur);

        return new ResponseEntity<>(fournisseur, HttpStatus.CREATED);

    }
}
