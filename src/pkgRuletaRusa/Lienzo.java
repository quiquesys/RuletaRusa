/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgRuletaRusa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 30210069
 */
public class Lienzo extends javax.swing.JPanel implements Runnable {

    public Thread hiloRuleta;
    Ruleta ruleta;
    int puntoCentralX;
    int puntoCentralY;

    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        ruleta = new Ruleta();
        ruleta.getLstItemsRuleta().add(new ItemRuleta(1, 0.0, "Guatemala", "", false, Color.BLUE));
        ruleta.getLstItemsRuleta().add(new ItemRuleta(2, 0.0, "El Salvador", "", false, Color.YELLOW));
        ruleta.getLstItemsRuleta().add(new ItemRuleta(3, 0.0, "Honduras", "", false, Color.GREEN));
        ruleta.getLstItemsRuleta().add(new ItemRuleta(4, 0.0, "Costar Rica", "", false, Color.ORANGE));
        ruleta.getLstItemsRuleta().add(new ItemRuleta(5, 0.0, "Panama", "", true, Color.GRAY));
        ruleta.inicializarValores();
        this.hiloRuleta = new Thread(this);
    }

    public void IniciarGiro() {
                    this.hiloRuleta.start();
    }

    public void PausarGiro() {
        this.hiloRuleta.suspend();
    }

    public void ContinuarGiro() {
        this.hiloRuleta.resume();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        //g.setColor(Color.BLACK);
        //g.fillRect(getWidth() / 2, 0, 10, 40);
        
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("2619.png")), getWidth()/2-25, 0,50,50, this);
        
        Iterator<ItemRuleta> it = this.ruleta.getLstItemsRuleta().iterator();
        int anguloArco = 100 / this.ruleta.getLstItemsRuleta().size() * 360 / 100;
        int anguloInicial = 0;
        int anguloFinal = 0;
        while (it.hasNext()) {
            ItemRuleta next = it.next();
            //if (next.getPosicion()==1)
            {
                g.setColor(next.getColor());
                //System.out.println(next.getColor().toString());
                anguloInicial = (((next.getPosicion() - 1) * (int) next.getValor()) * 360 / 100);
                if (next.getPosicion() == 1) {
                    anguloInicial = 0;
                }
                anguloFinal = (next.getPosicion() * (int) next.getValor()) * 360 / 100;
                //System.out.println("puntoCentralX="+puntoCentralX);
                //System.out.println("puntoCentralY="+puntoCentralY);
                //System.out.println((int)next.getValor());
                //System.out.println(anguloInicial);
                //System.out.println(anguloFinal);
                g.fillArc(getWidth() / 2 - 100, getHeight() / 4, 200, 200, anguloInicial, anguloArco);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        {
            try {
                int time = 10; //(int) (Math.random() * 20) + 1;
                int posicionActual =this.ruleta.getPosicionInicial();
                System.out.println("PosicionInicial:"+this.ruleta.getPosicionInicial());
                System.out.println("Time:"+time);
                System.out.println("GanadorRuleta:"+this.ruleta.getGanadorRuleta());
                int vuelta = 1;
                int speed = 50;
                while (time >0) {
                    System.out.println("Vuelta "+vuelta++);
                    System.out.println("PosicionActual:"+posicionActual);
                    System.out.println("ItemEnPosicion:"+this.ruleta.getLstItemsRuleta().get(posicionActual-1).getPosicion());
                    System.out.println("ItemEnPosicion:"+this.ruleta.getLstItemsRuleta().get(posicionActual-1).getTexto());
                    Thread.sleep(speed+=10);
                    repaint();
                    time--;
                    if (time==0 && this.ruleta.getLstItemsRuleta().get(4).getPosicion()!=1){
                        System.out.println("En time1:"+this.ruleta.getLstItemsRuleta().get(4).getTexto());
                        System.out.println("En time1:"+this.ruleta.getLstItemsRuleta().get(4).getPosicion());
                        time++;
                        //time=Math.abs(6-posicionActual);
                        System.out.println("Vueltas extras:"+time);
                    }
                    this.ruleta.girar();                    
                    
                    posicionActual++;
                    if (posicionActual==6){
                        posicionActual=1;
                    }                    
                }
                //JOptionPane.showMessageDialog(this, this.ruleta.getLstItemsRuleta().get(4).getTexto(),"Ganador",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Gano!!!");
                PausarGiro();

            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
