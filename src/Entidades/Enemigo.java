/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Frank
 */
public class Enemigo extends CoordenadaEntidad{
    private float ladox;
    private float ladoy;
    
    public Enemigo(){
        super();
        this.ladox =0;
        this.ladoy=0;
    }
    public Enemigo(CoordenadaEntidad coordenada, float x, float y){
        super(coordenada);
        this.ladox = x;
        this.ladoy = y;
    }
    public Enemigo(Enemigo nvo){
        super(nvo.getX(), nvo.getY());
        this.ladox = nvo.ladox;
        this.ladoy = nvo.ladoy;
    }
    public float Getlado(int lado){
        if(lado ==1){
            return this.ladox;
        }
        if(lado ==2){
            return this.ladoy;
        }
        if(lado !=1 && lado !=2){
            return 0;
        }
        return 0;
    }
}
