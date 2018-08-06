/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgRuletaRusa;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 30210069
 */
public class Ruleta {
    
    private int posicionInicial;
    private int ganadorRuleta;

    private ArrayList<ItemRuleta> lstItemsRuleta;
    Ruleta(){
        this.lstItemsRuleta=new ArrayList<ItemRuleta>();
    }
    
    public void inicializarValores(){
        Iterator<ItemRuleta> it = this.lstItemsRuleta.iterator();
        int TotalItems = this.lstItemsRuleta.size();        
        while (it.hasNext()) {
            //int R = (int)(Math.random()*256);
            //int G = (int)(Math.random()*256);
            //int B= (int)(Math.random()*256);
            ItemRuleta next = it.next();
            next.setValor(100/TotalItems);
            //next.setColor(new Color(R,G,B));
        }
        this.setPosicionInicial((int)(Math.random()*5+1));
    }

    /**
     * @return the lstItemsRuleta
     */
    public ArrayList<ItemRuleta> getLstItemsRuleta() {
        return lstItemsRuleta;
    }

    /**
     * @param lstItemsRuleta the lstItemsRuleta to set
     */
    public void setLstItemsRuleta(ArrayList<ItemRuleta> lstItemsRuleta) {
        this.lstItemsRuleta = lstItemsRuleta;
    }

    void girar() {
        Iterator<ItemRuleta> it = this.lstItemsRuleta.iterator(); 
        while (it.hasNext()) {
            ItemRuleta next = it.next();
            int posicionActual=next.getPosicion();
            int nuevaPosicion=posicionActual+1;
            if (nuevaPosicion>this.lstItemsRuleta.size()){
                nuevaPosicion=1;
            }
            next.setPosicion(nuevaPosicion);
        }
    }

    /**
     * @return the posicionInicial
     */
    public int getPosicionInicial() {
        return posicionInicial;
    }

    /**
     * @param posicionInicial the posicionInicial to set
     */
    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }

    /**
     * @return the ganadorRuleta
     */
    public int getGanadorRuleta() {
        return ganadorRuleta;
    }

    /**
     * @param ganadorRuleta the ganadorRuleta to set
     */
    public void setGanadorRuleta(int ganadorRuleta) {
        this.ganadorRuleta = ganadorRuleta;
    }
}
