/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.proyecto.entities;

/**
 *
 * @author alber
 */
public class Dietas {
    
    private Integer id=0;
    private boolean blanda=false;
    private boolean astringente=false;
    private boolean ayuno=false;
    private boolean sonda=false;

    public Dietas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    public boolean isBlanda() {
        return blanda;
    }

    public void setBlanda(boolean blanda) {
        this.blanda = blanda;
    }

    public boolean isAstringente() {
        return astringente;
    }

    public void setAstringente(boolean astringente) {
        this.astringente = astringente;
    }

    public boolean isAyuno() {
        return ayuno;
    }

    public void setAyuno(boolean ayuno) {
        this.ayuno = ayuno;
    }

    public boolean isSonda() {
        return sonda;
    }

    public void setSonda(boolean sonda) {
        this.sonda = sonda;
    }

    @Override
    public String toString() {
        return "Dietas{" + "id=" + id + ", blanda=" + blanda + ", astringente=" + astringente + ", ayuno=" + ayuno + ", sonda=" + sonda + '}';
    }
    
    
    
    
}
