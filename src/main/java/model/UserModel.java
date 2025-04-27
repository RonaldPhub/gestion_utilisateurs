/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * La classe UserModel représent le modèle d'un utilisateur
 *
 * @author r.pina
 */
public class UserModel {

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String pseudo;
    private String motDePasse;

    /**
     * Constructeur de la classe UserModel
     */
    public UserModel() {
    }

    /**
     * Constructeur de la classe UserModel
     *
     * @param nom Le nom de l'utilisateur
     * @param prenom Le prénom de l'utilisateur
     * @param adresse L'adresse de l'utilisateur
     * @param pseudo Le pseudo de l'utilisateur
     * @param mdp Le mot de passe de l'utilisateur
     */
    public UserModel(String nom, String prenom, String adresse, String pseudo, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.pseudo = pseudo;
        this.motDePasse = mdp;
    }

    /**
     * Constructeur de la classe UserModel
     *
     * @param id L'id de l'utilisateur
     * @param nom Le nom de l'utilisateur
     * @param prenom Le prénom de l'utilisateur
     * @param adresse L'adresse de l'utilisateur
     */
    public UserModel(int id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    /**
     * Constructeur de la classe UserModel
     *
     * @param id L'id de l'utilisateur
     * @param nom Le nom de l'utilisateur
     * @param prenom Le prénom de l'utilisateur
     * @param adresse L'adresse de l'utilisateur
     * @param pseudo Le pseudo de l'utilisateur
     * @param mdp Le mot de passe de l'utilisateur
     */
    public UserModel(int id, String nom, String prenom, String adresse, String pseudo, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.pseudo = pseudo;
        this.motDePasse = mdp;
    }

    /**
     * Méthode qui récupère l'id d'un utilisateur
     *
     * @return integer
     */
    public int getId() {
        return this.id;
    }

    /**
     * Méthode qui va affecter un id d'un utilisateur
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode qui récupère le nom d'un utilisateur
     *
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Méthode qui va affecter un nom d'un utilisateur
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode qui récupère le prenom d'un utilisateur
     *
     * @return String
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Méthode qui va affecter un prénom d'un utilisateur
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Méthode qui récupère l'adresse d'un utilisateur
     *
     * @return String
     */
    public String getAdresse() {
        return this.adresse;
    }

    /**
     * Méthode qui va affecter l'adresse d'un utilisateur
     *
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Méthode qui récupère le pseudo d'un utilisateur
     *
     * @return String
     */
    public String getPseudo() {
        return this.pseudo;
    }

    /**
     * Méthode qui va affecter le pseudo d'un utilisateur
     *
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Méthode qui récupère le mot de passe d'un utilisateur
     *
     * @return String
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Méthode qui va affecter le mot de passe d'un utilisateur
     *
     * @param motDePasse
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
