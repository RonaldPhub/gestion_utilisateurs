/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe UserDAO représent les actions qu'on peut faire sur la base de
 * donnée
 *
 * @author r.pina
 */
public class UserDAO {

    private Connection connexion;

    /**
     * Le constructeur de la classe UserDAO Instanciation de la connexion de
     * base
     */
    public UserDAO() {
        this.connexion = Connexion.getConnexion();
    }

    /**
     * Méthode de récupération de la liste d'utilisateurs
     */
    public ArrayList<UserModel> getAllUser() {
        try {
            String query = "SELECT * FROM users";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ResultSet res = ps.executeQuery();

            ArrayList<UserModel> userList = new ArrayList<UserModel>();

            while (res.next()) {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String adresse = res.getString("adresse");
                String pseudo = res.getString("pseudo");
                String mdp = res.getString("mot_de_passe");

                userList.add(new UserModel(id, nom, prenom, adresse, pseudo, mdp));
            }
            return userList;

        } catch (SQLException ex) {
            System.out.print(ex.toString());
            return null;
        }

    }

    /**
     * Méthode de modification d'un utilisateur
     *
     * @param user l'objet user
     */
    public void updateUser(UserModel user) {
        try {
            String query = "UPDATE users SET nom = ?, prenom = ?, adresse = ? , pseudo = ?, mot_de_passe = ? WHERE id = ?";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getAdresse());
            ps.setString(4, user.getPseudo());
            ps.setString(5, user.getMotDePasse());
            ps.setInt(6, user.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Méthode d'insertion d'un utilisateur
     *
     * @param user l'objet user
     */
    public UserModel addUser(UserModel user) {
        try {
            String query = "INSERT INTO users (nom, prenom, adresse, pseudo, mot_de_passe) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getAdresse());
            ps.setString(4, user.getPseudo());
            ps.setString(5, user.getMotDePasse());

            int generatedId = ps.executeUpdate();

            user.setId(generatedId);

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;

    }

    /**
     * Méthode de suppression d'un utilisateur
     *
     * @param userId Représent l'id de l'utilisateur
     */
    public void deleteUser(int userId) {
        try {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
