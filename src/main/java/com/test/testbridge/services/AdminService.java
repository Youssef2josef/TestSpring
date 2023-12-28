package com.test.testbridge.services;

import com.test.testbridge.models.ProduitModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminService {

    List<ProduitModel> getAllProduits();

    ProduitModel getProduitById(Long id);

    void deleteProduitById(Long id);

    ProduitModel addProduit(ProduitModel p, MultipartFile imageFile);

    ProduitModel updateProduit(ProduitModel p, MultipartFile imageFile);
}
