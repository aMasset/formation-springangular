package org.formation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FournisseurRepositoryTest {

    @Autowired
    FournisseurRepository fournisseurRepository;

    @Test
    public void testContaining() {
        assertEquals(1, fournisseurRepository.findByNomContainingIgnoreCase("BELLE").size());
        assertEquals(1, fournisseurRepository.findByNomContainingIgnoreCase("BRICB").size());
        assertEquals(0, fournisseurRepository.findByNomContainingIgnoreCase("LOL").size());
    }

    @Test
    public void testAvailibility() {
        assertEquals(3, fournisseurRepository.findFournisseurWithQuantityProduit(0).size());
        assertEquals(0, fournisseurRepository.findFournisseurWithQuantityProduit(1).size());
    }
}
