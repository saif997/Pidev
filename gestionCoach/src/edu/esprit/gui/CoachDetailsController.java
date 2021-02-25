/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mokhtar
 */
public class CoachDetailsController implements Initializable {

    @FXML
    private TextField contnom;
    @FXML
    private TextField contprenom;
    @FXML
    private TextField contgenre;
    @FXML
    private TextField contdisponabilité;
    @FXML
    private TextField conttype;
    @FXML
    private TextField contlocalisation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setContnom(String nom) {
        this.contnom.setText(nom);
   }

    public void setContprenom(String prenom) {
        this.contprenom.setText(prenom);
    }

    public void setContgenre(String genre) {
        this.contgenre.setText(genre);
    }

    public void setContdisponabilité(String disponabilité) {
        this.contdisponabilité.setText(disponabilité);
    }

    public void setConttype(String type) {
        this.conttype.setText(type);
    }

    public void setContlocalisation(String localisation) {
        this.contlocalisation.setText(localisation);
    }
    
}

