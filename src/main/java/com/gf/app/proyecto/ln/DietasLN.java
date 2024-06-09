/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.proyecto.ln;

import com.gf.app.proyecto.dao.DietasDAO;
import com.gf.app.proyecto.entities.Dietas;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author alber
 */
public class DietasLN {
    
    public static String insert(Dietas d) throws SQLException, Exception {

        if (!DietasDAO.selectId(d)) {
            DietasDAO.insert(d);
            return "La dieta se ha asignado correctamente.";
        } else {
            return "Dieta ya asignada.";
        }

    }
    
    public static String delete(Dietas d) throws SQLException, Exception {

        if (DietasDAO.selectId(d)) {
            DietasDAO.delete(d);
            return "La dieta se ha eliminado correctamente.";
        } else {
            return "Dieta no existente.";
        }

    }
    
    public static String update(Dietas d) throws SQLException, Exception {

        if (DietasDAO.selectId(d)) {
            DietasDAO.update(d);
            return "La dieta se ha actualizado correctamente.";
        } else {
            return "Dieta no existente.";
        }

    }

    public static Set<Dietas> select(Dietas d) throws SQLException, Exception {
        Set<Dietas> list;
        list = DietasDAO.select(d);
        return list;

    }

    
}
