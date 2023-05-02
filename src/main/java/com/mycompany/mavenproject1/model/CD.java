/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author pc
 */
@Entity
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;
    private Float price;
    private String description;
    private String isbn;
    private Instant instant = Instant.now();
   
      @ElementCollection
    private Map<Integer, String> tracks = new HashMap<>();
     
    public Map<Integer, String> getTracks() {
        return tracks;
    }

    public void setTracks(Map<Integer, String> tracks) {
        this.tracks = tracks;
    }

   

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "CD{" + "id=" + id + ", title=" + title + ", price=" + price + ", description=" + description + ", isbn=" + isbn + ", instant=" + instant + ", tracks=" + tracks + '}';
    }

    
    
}
