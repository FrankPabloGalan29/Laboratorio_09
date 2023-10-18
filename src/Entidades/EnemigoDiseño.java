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
public class EnemigoDiseño extends Enemigo implements Dibujable{
    
    Color color;
    
    public EnemigoDiseño(CoordenadaEntidad coordenada, 
            float x, float y, Color color){
        super(coordenada, x, y);
        this.color = color;
    }
    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.fillRect((int)this.getX(),(int)this.getY(), 
                (int)this.Getlado(1), (int)this.Getlado(2));
    }
    
    public void Ciclo(int mov){
        float x = this.getY();
        this.setY(x+=mov);
    }
    public void pintar(Color c){
        this.color = c;
    }
}
