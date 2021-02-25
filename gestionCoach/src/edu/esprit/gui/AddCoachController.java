/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.coach;
import edu.esprit.services.CoachCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mokhtar
 */
public class AddCoachController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfgenre;
    @FXML
    private TextField tfdisponabilité;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tflocalisation;
    @FXML
    private Button btnajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutercoach(ActionEvent event) {
        //1- SAVE COACH IN DATABASE
            String rNom= tfnom.getText();
            String rPrenom= tfprenom.getText();
            String rGenre= tfgenre.getText();
            String rDisponabilté= tfdisponabilité.getText();
            String rType= tftype.getText();
            String rLocalisation= tflocalisation.getText();
            coach c = new coach(123, rNom, rPrenom, rGenre, rDisponabilté, rType, rLocalisation);
            CoachCRUD ccd =new CoachCRUD();
            ccd.addCoach(c);
            
            //2- REDIRECTION
            FXMLLoader loader=new FXMLLoader(
                    getClass().getResource("CoachDetails.fxml"));
        try {
            Parent root = loader.load();
            CoachDetailsController cdc = loader.getController();
            cdc.setContnom(rNom); // injecter les variables de première formulaire
            cdc.setContprenom(rPrenom);
            cdc.setContgenre(rGenre);
            cdc.setContdisponabilité(rDisponabilté);
            cdc.setConttype(rType);
            cdc.setContlocalisation(rLocalisation);
            tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            
      }
    
    
}
