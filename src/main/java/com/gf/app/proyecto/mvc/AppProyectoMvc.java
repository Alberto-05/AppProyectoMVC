/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gf.app.proyecto.mvc;

import com.gf.app.proyecto.controller.Controller;
import com.gf.app.proyecto.entities.Dietas;
import com.gf.app.proyecto.view.View;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alber
 */
public class AppProyectoMvc {

    public static void main(String[] args) {
        System.out.println("prueba");
        
        Dietas dietas = new Dietas();
        View vista = new View();
        Controller controlador;
        try {
            controlador = new Controller(dietas, vista);
            controlador.setFrame();
        } catch (SQLException ex) {
            Logger.getLogger(AppProyectoMvc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("prueba exitosa");
    
    }
}
