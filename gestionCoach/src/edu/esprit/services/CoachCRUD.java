/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.coach;
import edu.esprit.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mokhtar
 */
public class CoachCRUD {

    public void addCoach(coach c) {
        String requete = "INSERT INTO coach (Nomcoach,Prenomcoach,Genre,Disponabilite,Typesesport,Localisation)"
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pst =
                    new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, c.getNomcoach());
            pst.setString(2, c.getPrenomcoach());
            pst.setString(3, c.getGenre());
            pst.setString(4, c.getDisponabilite());
            pst.setString(5, c.getTypesesport());
            pst.setString(6, c.getLocalisation());
            pst.executeUpdate();
            System.out.println("coach ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(CoachCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
}
