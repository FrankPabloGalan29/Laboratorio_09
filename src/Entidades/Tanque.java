/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Frank
 */
public class Tanque extends CoordenadaEntidad{
    private float lado;
    private CoordenadaEntidad esquina;
    public ArrayList balas = new ArrayList();

    public Tanque() {
        super();
        this.lado = 0;
        this.esquina = new CoordenadaEntidad();
    }

    public Tanque(CoordenadaEntidad coordenada, 
            float lado, CoordenadaEntidad esquina) {
        super(coordenada);
        this.lado = lado;
        this.esquina = new CoordenadaEntidad(esquina);
    }

    public Tanque(Tanque nvo) {
        super(nvo);
        this.lado = nvo.lado;
        this.esquina = new CoordenadaEntidad(nvo.esquina);
    }

    public float getLado() {
        return this.lado;
    }

    public CoordenadaEntidad getEsquina() {
        return this.esquina;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }

    public void setEsquina(CoordenadaEntidad esquina) {
        this.esquina = new CoordenadaEntidad(esquina);
    }

    public void mover(CoordenadaEntidad nuevaEsquina) {
        setEsquina(this.esquina.Suma(nuevaEsquina));
    }
}
