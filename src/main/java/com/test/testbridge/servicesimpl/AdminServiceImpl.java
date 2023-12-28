package com.test.testbridge.servicesimpl;

import com.test.testbridge.models.ProduitModel;
import com.test.testbridge.repositories.ProduitRepository;
import com.test.testbridge.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    ProduitRepository produitRepo;

    @Override
    public List<ProduitModel> getAllProduits() {
        return produitRepo.findAll();
    }

    @Override
    public ProduitModel getProduitById(Long id) {
        Optional<ProduitModel> p = produitRepo.findById(id);
        return p.orElse(null);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepo.deleteById(id);
    }

    @Override
    public ProduitModel addProduit(ProduitModel p, MultipartFile imageFile) {
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                p.setImage(imageFile.getBytes());
                p.setContentType(imageFile.getContentType());
                p.setName_img(imageFile.getOriginalFilename());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Gérez les erreurs d'upload d'image ici
        }

        return produitRepo.save(p);
    }

    @Override
    public ProduitModel updateProduit(ProduitModel p, MultipartFile imageFile) {
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                p.setImage(imageFile.getBytes());
                p.setContentType(imageFile.getContentType());
                p.setName_img(imageFile.getOriginalFilename());
            }

        } catch (IOException e) {
            e.printStackTrace(); // Gérez les erreurs d'upload d'image ici
        }

        return produitRepo.save(p);
    }
}
