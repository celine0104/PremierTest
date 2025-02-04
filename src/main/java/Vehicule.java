/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2417127
 */
public class Vehicule {
    private int id;
    private String marque;
    private String modele;
    private int annee;
    private String proprietaire;

    // Constructeur
    public Vehicule(int id, String marque, String modele, int annee, String proprietaire) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.proprietaire = proprietaire;
    }

    // Getter et Setter pour l'attribut id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter et Setter pour l'attribut marque
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    // Getter et Setter pour l'attribut modele
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    // Getter et Setter pour l'attribut annee
    public double getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    // Getter et Setter pour l'attribut proprietaire
     public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    // Méthode pour afficher les détails du vehicule
    public void afficherDetails() {
        System.out.println("ID: " + id + ", Marque: " + marque + ", Modele: " + modele + ", Annee: " + annee + ", Proprietaire: " + proprietaire );
    }
}
