/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import model.UserListModel;
import view.AjoutDialog;
import view.MainView;
import view.ModifDialog;

/**
 * La classe MainControl représent une des trois composant de l'architecture MVC
 *
 * @author r.pina
 */
public class MainControl implements PropertyChangeListener {

    private MainView view;
    private UserListModel userListModel;
    private ModifDialog modifDialog;
    private AjoutDialog ajoutDialog;

    /**
     * Constructeur de la classe MainControl
     *
     * @param view
     */
    public MainControl(MainView view) {
        this.view = view;
        this.view.addPropertyChangeListener(this);

        this.userListModel = new UserListModel();
        this.view.setTableModel(this.userListModel);

        this.modifDialog = new ModifDialog(this.view, true);
        this.modifDialog.addPropertyChangeListener(this);

        this.ajoutDialog = new AjoutDialog(this.view, true);
        this.ajoutDialog.addPropertyChangeListener(this);
    }

    /**
     * Méthode qui "écoute" et agit selon les actions venant des vues
     *
     * @param evt
     */
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            //Affichage de la modification modale
            case "openModifDialog":
                //Affectation des données de l'utilisateur
                int userModifId = this.view.getSelectedId();
                String userModifNom = this.view.getSelectedNom();
                String userModifPrenom = this.view.getSelectedPrenom();
                String userModifAdresse = this.view.getSelectedAdresse();
                String userModifPseudo = this.view.getSelectedPseudo();
                String userModifMdp = this.view.getSelectedMdp();

                //Affichage des données de l'utilisateur
                this.modifDialog.setUserModifId(userModifId);
                this.modifDialog.setUserModifNom(userModifNom);
                this.modifDialog.setUserModifPrenom(userModifPrenom);
                this.modifDialog.setUserModifAdresse(userModifAdresse);
                this.modifDialog.setUserModifPseudo(userModifPseudo);
                this.modifDialog.setUserModifMdp(userModifMdp);

                this.modifDialog.setVisible(true);
                break;

            //Ferméture de la modification modale
            case "closeModifDialog":
                this.modifDialog.setVisible(false);
                break;

            //Validation de la modification de l'utilisateur
            case "validModifUser":
                this.userListModel.updateUser(
                        this.modifDialog.getUserModifId(),
                        this.modifDialog.getUserModifNom(),
                        this.modifDialog.getUserModifPrenom(),
                        this.modifDialog.getUserModifAdresse(),
                        this.modifDialog.getUserModifPseudo(),
                        this.modifDialog.getUserModifMdp());

                this.modifDialog.setVisible(false);
                break;

            //Affichage de l'ajout modale
            case "openAddDialog":
                //Mettre les champs de textes vide par défaut
                this.ajoutDialog.setUserAddNom("");
                this.ajoutDialog.setUserAddPrenom("");
                this.ajoutDialog.setUserAddAdresse("");
                this.ajoutDialog.setUserAddPseudo("");
                this.ajoutDialog.setUserAddMdp("");

                this.ajoutDialog.setVisible(true);
                break;

            //Ferméture de l'ajout modale
            case "closeAddDialog":
                this.ajoutDialog.setVisible(false);
                break;

            //Validation de l'insertion de l'utilisateur
            case "validNouvelUser":
                //Récupération des données de l'utilisateur à inserée
                String userAddNom = this.ajoutDialog.getUserAddNom();
                String userAddPrenom = this.ajoutDialog.getUserAddPrenom();
                String userAddAdresse = this.ajoutDialog.getUserAddAdresse();
                String userAddPseudo = this.ajoutDialog.getUserAddPseudo();
                String userAddMdp = this.ajoutDialog.getUserAddMdp();

                //L'ajouter dans la liste de l'utilisateur
                this.userListModel.addUser(
                        userAddNom,
                        userAddPrenom,
                        userAddAdresse,
                        userAddPseudo,
                        userAddMdp);

                this.ajoutDialog.setVisible(false);
                break;

            //Suppression d'un utilisateur
            case "validSupprimeUser":
                int userSupprimeId = this.view.getSelectedId();

                this.userListModel.deleteUser(userSupprimeId);
                break;

        }
    }

}
