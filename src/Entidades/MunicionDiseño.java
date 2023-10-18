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
public class MunicionDiseño extends Municion implements Dibujable{
    Color color;
    public MunicionDiseño(CoordenadaEntidad cor, float radio, Color color){
        super(cor, radio);
        this.color = color;
    }
    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.fillOval((int)(this.getX()-this.getRadio()), 
                (int)(this.getY()-this.getRadio()), 
                (int)(2*this.getRadio()), (int)(2*this.getRadio()));
    }
    
    public void pintar(Color c){
        this.color = c;
    }
}
