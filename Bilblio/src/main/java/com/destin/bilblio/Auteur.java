package com.destin.bilblio;

import jakarta.persistence.*;
@Entity

@NamedQueries({@NamedQuery(name="rqt",query ="DELETE FROM Auteur auteur WHERE auteur.prenom=:prenom"),
        @NamedQuery(name="aff",query ="SELECT x FROM Auteur x")})


public class Auteur {


    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Prenom")

    private String prenom;

    @Column(name = "Nom")

    private String nom;

    public Auteur() {
    }

    public Auteur(Integer id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
