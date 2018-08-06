/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgRuletaRusa;

import java.awt.Color;

/**
 *
 * @author 30210069
 */
public class ItemRuleta {
    private int posicion;
    private double valor;
    private String texto;
    private boolean ganador;
    private String direccionImagen;
    private Color color;
    
    ItemRuleta(int pPosicion,double pValor, String pTexto, String pDireccionImagen, boolean pGanador,Color pColor){
        this.posicion=pPosicion;
        this.valor=pValor;
        this.texto=pTexto;
        this.direccionImagen=pDireccionImagen;
        this.ganador=pGanador;
        this.color=pColor;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the ganador
     */
    public boolean isGanador() {
        return ganador;
    }

    /**
     * @param ganador the ganador to set
     */
    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    /**
     * @return the direccionImagen
     */
    public String getDireccionImagen() {
        return direccionImagen;
    }

    /**
     * @param direccionImagen the direccionImagen to set
     */
    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
