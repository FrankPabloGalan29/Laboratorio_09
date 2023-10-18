/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio09;

import Entidades.MunicionDiseño;
import Entidades.CoordenadaEntidad;
import Entidades.Dibujable;
import Entidades.EnemigoDiseño;
import Entidades.TanqueDiseño;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import static laboratorio09.Laboratorio09.Aleatorio;

/**
 *
 * @author Frank
 */
public class PanelJuego extends JPanel implements KeyListener{
    
    ArrayList v;
    ArrayList enemi = new ArrayList();
    private final ImageIcon fondo;
    
    TanqueDiseño tanque;
    CoordenadaEntidad movimientoIzq = new CoordenadaEntidad(-25, 0);
    CoordenadaEntidad movimientoDer = new CoordenadaEntidad(25, 0);
    CoordenadaEntidad movimientoArr = new CoordenadaEntidad(0,-25);
    CoordenadaEntidad movimientoAba = new CoordenadaEntidad(0,25);
    CoordenadaEntidad movimientoNulo = new CoordenadaEntidad(0,0);
    
    Boolean FinDeJuego = true;
    int ContEnemigos = 5;
    int Score;
    int Vidas=3;
    int Movi = 3;
    int MaxEne = 5;

       
    TextoDiseño puntos;
    TextoDiseño vidas;
    TextoDiseño Final;

    public PanelJuego(ArrayList vectordeO) {
        this.v = vectordeO;
        this.addKeyListener(this);
        setFocusable(true);
        
        fondo = new ImageIcon(getClass().getResource("/Imagen/fondo3.png"));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Dimension d = getSize();
        Image Imagen = createImage(d.width, d.height);
        Graphics buff = Imagen.getGraphics();
        
        Dibujable dib;
        for (int i = 0; i < v.size(); i++) {
            dib = (Dibujable) v.get(i);
            dib.dibujar(buff);
        }
        
        g.drawImage(Imagen, 0, 0, null);
        g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    public void actualizar(Graphics g){
        paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        
        if (tecla == KeyEvent.VK_LEFT) {
            
            this.tanque.mover(movimientoIzq);
            
        } else if (tecla == KeyEvent.VK_RIGHT) {
            
            this.tanque.mover(movimientoDer);
            
        } else if (tecla == KeyEvent.VK_UP) {
            
            this.tanque.mover(movimientoArr);
        }
        else if (tecla == KeyEvent.VK_DOWN) {
            
            this.tanque.mover(movimientoAba);
        }
        else if(tecla == KeyEvent.VK_SPACE){
            MunicionDiseño bala = tanque.Bala();
            tanque.balas.add(bala);
            v.add(bala);
        }
    }
        
    @Override
    public void keyReleased(KeyEvent e) {
    
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_LEFT) {
            
            this.tanque.mover(movimientoNulo);
            
        } else if (tecla == KeyEvent.VK_RIGHT) {
            
            this.tanque.mover(movimientoNulo);
            
        }else if (tecla == KeyEvent.VK_UP) {
            
            this.tanque.mover(movimientoNulo);
            
        }
        else if (tecla == KeyEvent.VK_DOWN) {
            
            this.tanque.mover(movimientoNulo);
            
        }
        else if(tecla == KeyEvent.VK_SPACE){}
    }

    public void refTanque(TanqueDiseño n) {
        this.tanque = n;
    }
    public void refEne(EnemigoDiseño a, EnemigoDiseño b, 
            EnemigoDiseño c, EnemigoDiseño d, EnemigoDiseño e){
        
        enemi.add(a);
        enemi.add(b);
        enemi.add(c);
        enemi.add(d);
        enemi.add(e);    
    }
    public void RefPuntos(TextoDiseño a){
        this.puntos = a;
    }
    public void RefVida(TextoDiseño b){
        this.vidas = b;
    }
    public void RefFinal(TextoDiseño c){
        this.Final = c;
    }

    public void Colision() {
    int i, j;
    for (i = 0; i < tanque.balas.size(); i++) {
        MunicionDiseño bala = (MunicionDiseño) tanque.balas.get(i);
        for (j = 0; j < enemi.size(); j++) {
            EnemigoDiseño ene = (EnemigoDiseño) enemi.get(j);
            
            CoordenadaEntidad Cordbala = 
                    new CoordenadaEntidad(bala.getX(), bala.getY());
            CoordenadaEntidad centroTanque = new CoordenadaEntidad
        (tanque.getEsquina().getX() + tanque.getLado() / 2, 
                tanque.getEsquina().getY() + tanque.getLado() / 2);
            
            CoordenadaEntidad centroEnemigo = 
                    new CoordenadaEntidad(ene.getX() + ene.Getlado(1) / 2, 
                            ene.getY() + ene.Getlado(2) / 2);

            if (Math.abs(centroEnemigo.getX() - Cordbala.getX()) 
                    < ene.Getlado(1) / 2 &&
                Math.abs(centroEnemigo.getY() - Cordbala.getY()) 
                    < ene.Getlado(2) / 2) {
                ene.pintar(Color.WHITE);
                bala.pintar(Color.WHITE);
                v.remove(bala);
                enemi.remove(ene);
                bala.setY(2000);
                ene.setY(2000);
                tanque.balas.remove(bala);
                enemi.remove(ene);
                ContEnemigos--;
                Score += 5;
                puntos.SetColor(Color.WHITE);
                String NuevoScore = "" + Score;
                TextoDiseño Nrpuntos = new TextoDiseño(NuevoScore,
                        Color.RED, 1700, 350);
                Nrpuntos.setSize(40);
                puntos = Nrpuntos;
                v.add(puntos);
            }
            if (Math.abs(centroTanque.getX() - centroEnemigo.getX()) 
                    < (tanque.getLado() + ene.Getlado(1)) / 2 &&
                Math.abs(centroTanque.getY() - centroEnemigo.getY()) 
                    < (tanque.getLado() + ene.Getlado(2)) / 2) {
                Score = Score - 5;
                Vidas--;
                String NuevoScore = "" + Score;
                String NuevasVidas = "" + Vidas;
                vidas.SetColor(Color.WHITE);
                puntos.SetColor(Color.WHITE);
                TextoDiseño nVidas = new TextoDiseño(NuevasVidas, 
                        Color.RED, 1700, 150);
                nVidas.setSize(40);
                vidas = nVidas;
                TextoDiseño nPuntos = new TextoDiseño(NuevoScore, 
                        Color.RED, 1700, 350);
                nPuntos.setSize(40);
                puntos = nPuntos;
                v.add(vidas);
                v.add(puntos);

                enemi.remove(ene);
                ene.setY(2000);
                ContEnemigos--;
            }
        }
    }
}
    public void iniciar(){
        while(FinDeJuego){
            try{
                if(!tanque.balas.isEmpty()){
                    tanque.Ciclo();
                }
                int i;
                for(i=0;i<enemi.size();i++){
                    EnemigoDiseño en = (EnemigoDiseño) enemi.get(1);
                    en.Ciclo(Movi);
                    if(en.getY()>525){
                        int rango = Aleatorio(800,50);
                        en.setY(0);
                        en.setX(rango);
                    }
                }
                if(ContEnemigos<MaxEne)
                {
                    int rango = Aleatorio(800,50);
                    CoordenadaEntidad Inicio = new CoordenadaEntidad(rango,-40);
                    EnemigoDiseño nuevo = new EnemigoDiseño
        (Inicio,30,30,Color.BLUE);
                    enemi.add(nuevo);
                    v.add(nuevo);
                    nuevo.Ciclo(Movi);
                    ContEnemigos++;
                    
                }
                int Nivel = 1;
                String Niveles = ""+Nivel;
                TextoDiseño textNivel = new TextoDiseño
        ("NIVEL",Color.BLACK,1700,500);
                textNivel.setSize(50);
                TextoDiseño textnNivel = new TextoDiseño(Niveles,Color.BLUE,1700,600);
                textnNivel.setSize(50);
                v.add(textnNivel);
                v.add(textNivel);
                
                if(Score >=50 && Score<100){
                    Nivel = 2;
                    String NuevoNivel = ""+Nivel;
                    textnNivel.SetColor(Color.WHITE);
                    TextoDiseño nNivel = new TextoDiseño(NuevoNivel,Color.GREEN,1700,600);
                    nNivel.setSize(40);
                    textnNivel = nNivel;
                    v.add(textnNivel);
                    Movi = 5;
                    MaxEne = 7;
                    for(i=0;i<enemi.size();i++){
                        EnemigoDiseño edis = (EnemigoDiseño) enemi.get(1);
                        edis.pintar(Color.GREEN);
                    }
                }
                if(Score >=100 && Score<300){
                    Nivel = 3;
                    String NuevoNivel = ""+Nivel;
                    textnNivel.SetColor(Color.WHITE);
                    TextoDiseño nNivel = new TextoDiseño(NuevoNivel,Color.ORANGE,1700,600);
                    nNivel.setSize(40);
                    textnNivel = nNivel;
                    v.add(textnNivel);
                    Movi = 10;
                    MaxEne = 10;
                    for(i=0;i<enemi.size();i++){
                        EnemigoDiseño edis = (EnemigoDiseño) enemi.get(1);
                        edis.pintar(Color.ORANGE);
                    }
                }
                if(Vidas<=0){
                    FinDeJuego = false;
                    v.add(Final);
                }
                Colision();
                
                //Asteroide5.setY(200);
                Thread.sleep(50);
            }catch(InterruptedException err){System.out.println(err);}
            repaint(); 
        }
    }
}
