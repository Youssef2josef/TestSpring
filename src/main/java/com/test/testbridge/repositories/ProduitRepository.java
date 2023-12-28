package com.test.testbridge.repositories;

import com.test.testbridge.models.ProduitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitModel,Long> {

    @Override
    Optional<ProduitModel> findById(Long id);

}
