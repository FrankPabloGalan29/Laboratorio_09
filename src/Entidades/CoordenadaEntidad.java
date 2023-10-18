/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Frank
 */
public class CoordenadaEntidad {
    private float x;
    private float y;
    
    public CoordenadaEntidad(){
        this.x=0;
        this.y=0;
    }
    public CoordenadaEntidad(float x, float y){
        this.x=x;
        this.y=y;
    }
    
    public CoordenadaEntidad(CoordenadaEntidad nva){
        this.x=nva.x;
        this.y=nva.y;
    }
    
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public void setX(float x){
        this.x=x;
    }    
    public void setY(float y){
        this.y=y;
    }
    
    public CoordenadaEntidad Suma(CoordenadaEntidad S){
        float Sumx  = this.x +S.getX();
        float Sumy = this.y + S.getY();
        
        CoordenadaEntidad Cor = new CoordenadaEntidad(Sumx, Sumy);
        return Cor;
    }
}
