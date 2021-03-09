/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import com.sun.javafx.scene.control.skin.TextFieldSkin;
import edu.esprit.entities.coach;
import edu.esprit.services.CoachCRUD;
import edu.esprit.gui.ModifiercoachController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;


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
    private ComboBox tfgenre;
    @FXML
    private TextField tfdisponabilité;
    @FXML
    private TextField tftype;
    @FXML
    private ComboBox tflocalisation;
    @FXML
    private Button btnajouter;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> genrelist = FXCollections.observableArrayList("homme","femme");
        tfgenre.setItems(genrelist);
        tfgenre.setPromptText("indiquez le genre");
        ObservableList<String> localist = FXCollections.observableArrayList("ariana","béja","ben arous"
        ,"bizerte","gabes","gafsa","jendouba","kairouan","kasserine","kébilli","le kef","mahdia","la manouba","médenine"
        ,"mnastir","nabeul","sfax","sid bouzid","siliana","sousse","tataouine","tozeur","tunis","zagouane");
        tflocalisation.setItems(localist);
        tflocalisation.setPromptText("indiquez la localisation");
        String[] possiblewords ={"lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"};
        String[] noms ={"mokhtar","mouin","mouhib","mondher","mo","mon","ahmed","amani","asma","aroua"};
        String[] prenoms={"bechaib","bech","taib","Abbée",	"Aïcha","Aliseto","Amele","Annah","Aria","Audréanne",
 "Abby","Aïda",	"Alison","Ameli","Annaïc","Ariana","Audrée",
"Abélia","Aidana","Alisonne","Amélia","Annaïck","Ariane","Audrena"};
        String[] type={"zo","zoom","zoomba","ca","car","caraté","te","tek","tekwa","tekwando","bo","box","cr","cra","craf","crafma"
                ,"crafmaga"};


        TextFields.bindAutoCompletion(tfdisponabilité, possiblewords);
        TextFields.bindAutoCompletion(tfnom, noms);
        TextFields.bindAutoCompletion(tfprenom, prenoms);
        TextFields.bindAutoCompletion(tftype, type);
        
        
        
        // TODO
    }    

    @FXML
    private void ajoutercoach(ActionEvent event) throws IOException {
        //1- SAVE COACH IN DATABASE
            String rNom= tfnom.getText();
            String rPrenom= tfprenom.getText();
            String rGenre= (String)tfgenre.getSelectionModel().getSelectedItem();
            String rDisponabilté= tfdisponabilité.getText();
            String rType= tftype.getText();
            String rLocalisation= (String)tflocalisation.getSelectionModel().getSelectedItem();
            coach c = new coach(123, rNom, rPrenom, rGenre, rDisponabilté, rType, rLocalisation);
            CoachCRUD ccd =new CoachCRUD();
            
            if(tfnom.getText().trim().isEmpty()||tfprenom.getText().trim().isEmpty()||
                    tfdisponabilité.getText().trim().isEmpty()||tftype.getText().trim().isEmpty())
            {
        Alert fail= new Alert(AlertType.ERROR);
        fail.setHeaderText("failure");
        fail.setContentText("Vous devez saisir tous les données!");
        fail.showAndWait();}
            
            else{
              ccd.addCoach(c);   
            JOptionPane.showMessageDialog(null, "coach ajouter", "ajout",1 );
       Parent loader = FXMLLoader.load(getClass().getResource("CoachDetails.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
            window.setTitle("Admin page");
            window.setScene(scene);
            window.show(); }    
    /*        //2- REDIRECTION
            
            
            
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
            
      }*/
    
    
}}
