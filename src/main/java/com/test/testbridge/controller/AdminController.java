package com.test.testbridge.controller;

import com.test.testbridge.models.ProduitModel;
import com.test.testbridge.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ProduitModel ajouterProduit(@RequestParam("file") MultipartFile file,
                                       @RequestParam("name") String name,
                                       @RequestParam("prix") String prix) {
        ProduitModel produit = new ProduitModel();
        produit.setName(name);
        produit.setPrix(prix);
        return adminService.addProduit(produit, file);
    }

    @GetMapping
    public List<ProduitModel> recupererAllProduits() {
        return adminService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ProduitModel recupererOneProduit(@PathVariable Long id) {
        return adminService.getProduitById(id);
    }

    @PutMapping
    public ProduitModel editerProduit(@RequestParam("file") MultipartFile file,
                                      @RequestParam("name") String name,
                                      @RequestParam("prix") String prix,
                                      @RequestParam("id") Long id) {
        ProduitModel produit = new ProduitModel();
        produit.setId(id);
        produit.setName(name);
        produit.setPrix(prix);

        return adminService.updateProduit(produit, file);
    }

    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        adminService.deleteProduitById(id);
    }
}
