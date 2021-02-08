package org.formation.repository;

import org.formation.model.Dimension;
import org.formation.model.Fournisseur;
import org.formation.model.Produit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ProduitRespositoryTest {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Test
    public void testCreateProduit() {
        var produit = new Produit();
        var dimension = new Dimension();
        var fournisseur = new Fournisseur();
        produit.setAvailability(10);
        produit.setNom("Clef USB");
        produit.setReference("CLEFS");
        produit.setPrixUnitaire(2.5f);
        produit.setDescription("Les meilleures clefs du marché");

        dimension.setHauteur(2);
        dimension.setLargeur(2);
        dimension.setLongueur(2);
        produit.setDimension(dimension);

        fournisseur.setNom("Jo-Jo Paradis");
        fournisseur.setReference("JOJO");
        fournisseur = fournisseurRepository.save(fournisseur);
        produit.setFournisseur(fournisseur);

        produitRepository.save(produit);

        produitRepository.findAll()
                .forEach(f -> System.out.println(f.getId() + " " + f.getNom()));
    }

    @Test
    public void testUpdateProduit() {
        Produit produit = produitRepository.findById(1L).orElseThrow();
        assertEquals(359f, produit.getPrixUnitaire());
        produit.setPrixUnitaire(200000f);
        produitRepository.save(produit);

        Produit produit2 = produitRepository.findById(1L).orElseThrow();
        assertEquals(200000f, produit2.getPrixUnitaire());
    }
}
