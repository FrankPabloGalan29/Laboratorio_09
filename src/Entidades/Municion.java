/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Frank
 */
public class Municion extends CoordenadaEntidad{
    
    private float radio;
    
    public Municion(){
        super();
        this.radio = 0;
    }
    public Municion(CoordenadaEntidad nvo, float r){
        super(nvo);
        this.radio = r;
    }
    public Municion(Municion muni){
        super(muni);
        this.radio = muni.radio;
    }
    
    public float getRadio(){
        return this.radio;
    }
    public void setRadio(float r){
        this.radio = r;
    }
    public CoordenadaEntidad getCentro(){
        CoordenadaEntidad nva = new CoordenadaEntidad
        (this.getX(), this.getY());
        return nva;
    }
}
