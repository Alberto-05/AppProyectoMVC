/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.proyecto.controller;

import com.gf.app.proyecto.entities.Dietas;
import com.gf.app.proyecto.ln.DietasLN;
import com.gf.app.proyecto.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class Controller implements ActionListener {

    private final Dietas dietas;
    private final View vista;

    public Controller(Dietas d, View vista) throws SQLException {
        dietas = d;
        this.vista = vista;
        this.vista.getInsertar().addActionListener(this);
        this.vista.getBorrar().addActionListener(this);
        this.vista.getActualizar().addActionListener(this);
        this.vista.getConsultar().addActionListener(this);

    }

    public void setFrame() {
        vista.setTitle("App Dietas");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        dietas.setId(vista.getId());

        if (vista.getBlanda().isSelected()) {
            dietas.setBlanda(true);
        } else {
            dietas.setBlanda(false);
        }

        if (vista.getAstringente().isSelected()) {
            dietas.setAstringente(true);
        } else {
            dietas.setAstringente(false);
        }

        if (vista.getAyuno().isSelected()) {
            dietas.setAyuno(true);
        } else {
            dietas.setAyuno(false);
        }

        if (vista.getSonda().isSelected()) {
            dietas.setSonda(true);
        } else {
            dietas.setSonda(false);
        }

        if (evento.getSource() == vista.getInsertar()) {

            insertarDieta();
        } else if (evento.getSource() == vista.getBorrar()) {

            borrarDieta();
        } else if (evento.getSource() == vista.getActualizar()) {

            actualizarDieta();
        } else if (evento.getSource() == vista.getConsultar()) {

            consultarDieta();
        }

    }

    public void insertarDieta() {

        try {
            String nota = DietasLN.insert(dietas);
            JOptionPane.showMessageDialog(null, nota + "\n ");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void borrarDieta() {

        try {
            String nota = DietasLN.delete(dietas);
            JOptionPane.showMessageDialog(null, nota + "\n ");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarDieta() {

        try {
            String nota = DietasLN.update(dietas);
            JOptionPane.showMessageDialog(null, nota + "\n ");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void consultarDieta() {

        try {
            Set<Dietas> lista = DietasLN.select(dietas);

            for (Dietas d : lista) {
                JOptionPane.showMessageDialog(null, d.toString() + "\n ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
