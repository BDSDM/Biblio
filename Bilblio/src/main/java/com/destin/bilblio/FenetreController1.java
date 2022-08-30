package com.destin.bilblio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FenetreController1 implements Initializable {
    @FXML
    private Button afficher;
    @FXML
    private Button menu;
    @FXML
    private TableColumn<Auteur, Integer> idb;



    @FXML
    private TableColumn<Auteur, String> nomb;

    @FXML
    private TableColumn<Auteur, String> prenomb;

    @FXML
    private TableView<Auteur> table;

    @FXML
    private Button supprimer;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private Button ajouter;

    public ObservableList<Auteur> data = FXCollections.observableArrayList();
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("toto");



    public void menu(ActionEvent actionEvent) {

        try {
            Node n = (Node) actionEvent.getSource();
            Stage stage1 = (Stage) n.getScene().getWindow();
            stage1.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fenetre0.fxml"));

            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch(Exception e){}



    }

    public void afficher(ActionEvent actionEvent) {





        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();



        Query query = entityManager.createNamedQuery("aff",Auteur.class);

        List<Auteur> resultList = query.getResultList();

        entityManager.getTransaction().commit();

        data.clear();

        data.addAll(resultList);




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idb.setCellValueFactory(new PropertyValueFactory<Auteur,Integer>("id"));
        prenomb.setCellValueFactory(new PropertyValueFactory<Auteur,String>("prenom"));
        nomb.setCellValueFactory(new PropertyValueFactory<Auteur,String>("nom"));
        table.setItems(data);
    }

    public void supprimer(ActionEvent actionEvent) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("toto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();



        Query query = entityManager.createNamedQuery("rqt");
        query.setParameter("prenom", prenom.getText());
        query.executeUpdate();

        entityManager.getTransaction().commit();
        JOptionPane.showMessageDialog(null,"Elément supprimé");
        prenom.setText("");

    }

    public void ajouter(ActionEvent actionEvent) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("toto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Auteur jean = new Auteur();
        jean.setNom(nom.getText());
        jean.setPrenom(prenom.getText());




        entityManager.persist(
                jean);



        entityManager.getTransaction().commit();

        JOptionPane.showMessageDialog(null,"Elément ajouté");
        prenom.setText("");
        nom.setText("");

    }
}
