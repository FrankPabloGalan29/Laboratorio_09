/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio09;

import Entidades.Dibujable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Frank
 */
public class TextoDiseño implements Dibujable{
    
    String stri;
    Color color;
    int anchoTex;
    int altoTex;
    int size;
    
    public TextoDiseño(String stri, Color color, int anc, int alt){
        this.stri= stri;
        this.color=color;
        this.size=10;
        this.anchoTex=anc;
        this.altoTex = alt;
    }
    public void BorrarTexto(Graphics g, String txt){
        g.setColor(Color.WHITE);
        g.setFont(new Font ("Arial", Font.BOLD, this.getSize()));
        int ancho = (int)g.getFontMetrics()
                .getStringBounds(txt,g).getWidth();
        int alto =(int)g.getFontMetrics().getAscent();
        int x = this.anchoTex/2 - ancho/2;
        int y = this.altoTex/2 + alto/4;
        g.drawString(txt, x, y);
    }
    public void Plantartexto(Graphics g, String txt){
        g.setColor(Color.RED);
        g.setFont(new Font ("Arial", Font.BOLD, this.getSize()));
        int ancho = (int)g.getFontMetrics()
                .getStringBounds(txt,g).getWidth();
        int alto =(int)g.getFontMetrics().getAscent();
        int x = this.anchoTex/2 - ancho/2;
        int y = this.altoTex/2 + alto/4;
        g.drawString(txt, x, y);
    }
    
    public void dibujar(Graphics g){
        g.setColor(color);
        g.setFont(new Font ("Arial", Font.BOLD, this.getSize()));
        int ancho = (int)g.getFontMetrics()
                .getStringBounds(stri,g).getWidth();
        int alto =(int)g.getFontMetrics().getAscent();
        int x = this.anchoTex/2 - ancho/2;
        int y = this.altoTex/2 + alto/4;
        g.drawString(stri, x, y);
    }
    public void setSize(int nuevoSize){
        size = nuevoSize;
    }
    public int getSize(){
        return size;
    }
    public void SetColor(Color c){
        this.color = c;
    };
}
