/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * La classe UserListModel représent la modèle, une des trois composant de
 * l'architecture MVC.
 *
 * @author r.pina
 */
public class UserListModel extends AbstractTableModel {

    private ArrayList<UserModel> userList;
    private final String[] nomColumn = {"id", "Last name", "name", "Adresse", "Pseudo", "Mot de passe"};
    private UserDAO userDao;

    /**
     * Constructeur de la classe userListModel
     */
    public UserListModel() {
        this.userList = new ArrayList<>();
        this.userDao = new UserDAO();
        this.userList = this.userDao.getAllUser();
    }

    /**
     * Méthode de récupérer un colonne selon son index
     *
     * @param column Index du colonne
     */
    public String getColumnName(int column) {
        return this.nomColumn[column];
    }

    /**
     * Méthode de récupérer le nombre de ligne dans la liste
     */
    public int getRowCount() {
        return this.userList.size();
    }

    /**
     * Méthode de récupérer le nombre de colonne dans la liste
     */
    public int getColumnCount() {
        return this.nomColumn.length;
    }

    /**
     * Méthode de récupérer un cellule dans la liste
     *
     * @param rowIndex L'index du ligne
     * @param columnIndex L'index du colonne
     */
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return this.userList.get(rowIndex).getId();
            case 1:
                return this.userList.get(rowIndex).getNom();
            case 2:
                return this.userList.get(rowIndex).getPrenom();
            case 3:
                return this.userList.get(rowIndex).getAdresse();
            case 4:
                return this.userList.get(rowIndex).getPseudo();
            case 5:
                return this.userList.get(rowIndex).getMotDePasse();
        }
        return "ND";
    }

    /**
     * Méthode de modification d'un utilisateur
     *
     * @param userId L'id de l'utilisateur
     * @param userNom Nom de l'utilisateur
     * @param userPrenom Prénom de l'utilisateur
     * @param userAdresse Adresse de l'utilisateur
     * @param userPseudo Pseudo de l'utilisateur
     * @param userMdp Mot de passes de l'utilisateur
     */
    public void updateUser(int userId, String userNom, String userPrenom, String userAdresse, String userPseudo, String userMdp) {
        UserModel user = new UserModel(userId, userNom, userPrenom, userAdresse, userPseudo, userMdp);

        this.userDao.updateUser(user);

        this.userList = this.userDao.getAllUser();

        this.fireTableDataChanged();
    }

    /**
     * Méthode d'insertion d'un utilisateur
     *
     * @param userNom Nom de l'utilisateur
     * @param userPrenom Prénom de l'utilisateur
     * @param userAdresse Adresse de l'utilisateur
     * @param userPseudo Pseudo de l'utilisateur
     * @param userMdp Mot de passes de l'utilisateur
     */
    public void addUser(String userNom, String userPrenom, String userAdresse, String userPseudo, String userMdp) {
        UserModel user = new UserModel(userNom, userPrenom, userAdresse, userPseudo, userMdp);

        this.userDao.addUser(user);

        this.userList = this.userDao.getAllUser();

        this.fireTableDataChanged();
    }

    /**
     * Méthode de suppression d'un utilisateur
     *
     * @param userId L'id de l'utilisateur
     */
    public void deleteUser(int userId) {
        this.userDao.deleteUser(userId);

        this.userList = this.userDao.getAllUser();

        this.fireTableDataChanged();
    }

}
