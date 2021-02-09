package org.formation.repository;

import org.formation.model.Fournisseur;
import org.formation.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByFournisseur(Fournisseur fournisseur);

    Optional<Produit> findByReferenceAndFournisseurReference(String reference, String fournisseurReference);
}
