package org.formation.repository;

import org.formation.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    public List<Fournisseur> findByNomContainingIgnoreCase(String nom);

    @Query("SELECT p.fournisseur FROM Produit p WHERE p.availability > :quantity")
    public List<Fournisseur> findFournisseurWithQuantityProduit(@Param("quantity") Integer quantity);
}
