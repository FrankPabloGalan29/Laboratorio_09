/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio09;

import Entidades.CoordenadaEntidad;
import Entidades.EnemigoDiseño;
import Entidades.TanqueDiseño;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Frank
 */
public class Laboratorio09 {

    
    public static int Aleatorio(int Max, int Min){
        return (int)(Math.random()*(Max-Min));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ventana pantallaJuego = new Ventana("El ultimo Tanque");
        ArrayList ArregloDeObjetos = new ArrayList();

        CoordenadaEntidad esq1Tanque = new CoordenadaEntidad(375, 450);
        float ladTanque = 50;
        CoordenadaEntidad esq2Tanque = new CoordenadaEntidad(375, 450);

        TanqueDiseño tan = new TanqueDiseño(esq1Tanque, ladTanque, esq2Tanque, Color.GREEN);
        
        TextoDiseño Vidas = new TextoDiseño("Vidas", Color.BLACK,1700,50 );
        Vidas.setSize(35);
        ArregloDeObjetos.add(Vidas);
        TextoDiseño Score = new TextoDiseño("Puntos", Color.BLACK,1700,250 );
        Score.setSize(35);
        ArregloDeObjetos.add(Score);
        
        TextoDiseño Puntaje = new TextoDiseño("0", Color.RED,1700,350);
        Puntaje.setSize(40);
        ArregloDeObjetos.add(Puntaje);
        TextoDiseño numVidas= new TextoDiseño("3", Color.RED, 1700,150);
        numVidas.setSize(40);
        ArregloDeObjetos.add(numVidas);
        TextoDiseño textFin= new TextoDiseño("!FIN DEL JUEGO!", Color.RED, 900,200);
        textFin.setSize(100);
        
        int rangoy = Aleatorio(800,50);
        CoordenadaEntidad Salida1 = new CoordenadaEntidad(rangoy,-40);
        EnemigoDiseño Enemigo1 = new EnemigoDiseño(Salida1,30,30,Color.blue);
        int rangoy2 = Aleatorio(800,50);
        CoordenadaEntidad Salida2 = new CoordenadaEntidad(rangoy2,-40);
        EnemigoDiseño Enemigo2 = new EnemigoDiseño(Salida2,30,30,Color.blue);
        int rangoy3 = Aleatorio(800,50);
        CoordenadaEntidad Salida3 = new CoordenadaEntidad(rangoy3,-40);
        EnemigoDiseño Enemigo3 = new EnemigoDiseño(Salida3,30,30,Color.blue);        
        int rangoy4 = Aleatorio(800,50);
        CoordenadaEntidad Salida4 = new CoordenadaEntidad(rangoy4,-40);
        EnemigoDiseño Enemigo4 = new EnemigoDiseño(Salida4,30,30,Color.blue);
        int rangoy5 = Aleatorio(800,50);
        CoordenadaEntidad Salida5 = new CoordenadaEntidad(rangoy5,-40);
        EnemigoDiseño Enemigo5 = new EnemigoDiseño(Salida5,30,30,Color.blue);
        ArregloDeObjetos.add(Enemigo1);
        ArregloDeObjetos.add(Enemigo2);
        ArregloDeObjetos.add(Enemigo3);
        ArregloDeObjetos.add(Enemigo4);
        ArregloDeObjetos.add(Enemigo5);
        ArregloDeObjetos.add(tan);
        
        PanelJuego panel = new PanelJuego(ArregloDeObjetos);
        panel.refTanque(tan);
        panel.refEne(Enemigo1, Enemigo2, Enemigo3, Enemigo4, Enemigo5);
        panel.RefFinal(textFin);
        panel.RefVida(numVidas);
        panel.RefPuntos(Puntaje);
        pantallaJuego.add(panel);
        pantallaJuego.setSize(1000,600);
        pantallaJuego.setVisible(true);
        panel.iniciar();
    }
    
}
