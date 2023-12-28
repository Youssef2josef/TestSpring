package com.test.testbridge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produit")
public class ProduitModel {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name_produit")
    private String name;
    @Column(name = "prix")
    private String prix;
    @Lob
    private byte[] image;
    private String name_img;
    private String contentType;

}
