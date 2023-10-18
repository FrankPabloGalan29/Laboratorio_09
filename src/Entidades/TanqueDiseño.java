/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Frank
 */
public class TanqueDiseño extends Tanque implements Dibujable{
    
    Color color;

    public TanqueDiseño(CoordenadaEntidad coordenada, 
            float lado, CoordenadaEntidad esquina, Color color) {
        super(coordenada, lado, esquina);
        this.color = color;
    }

    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.fillRect((int) getEsquina().getX(), (int) getEsquina().getY(), 
                (int) getLado(), (int) getLado());
    }

    public void pintar(Graphics dw, Color color) {
        dw.setColor(color);
        dw.fillRect((int) getEsquina().getX(), (int) getEsquina().getY(), 
                (int) getLado(), (int) getLado());
    }
    
    public MunicionDiseño Bala() {
        CoordenadaEntidad salida = new CoordenadaEntidad
        (this.getEsquina().getX(), this.getEsquina().getY());
        MunicionDiseño bala = 
                new MunicionDiseño(salida, 10, Color.RED);
        return bala;
    }
    public void Ciclo(){
        for(int i =0; i<this.balas.size();i++){
            MunicionDiseño y = (MunicionDiseño)this.balas.get(i);
            float x=y.getY();
            y.setY(x-=5);
        }
    }
    
}
