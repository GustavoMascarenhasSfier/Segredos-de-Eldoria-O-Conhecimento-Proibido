package jogoBiblioteca.cenarios;

import java.awt.*;

public class Cenario2 extends CenarioBase{
    public static final int[][] MAPA = {

            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

            {0,8,8,8,9,11,8,12,3,11,8,8,8,8,8,0},

            {0,8,8,8,11,12,1,1,1,1,3,8,8,8,8,0},

            {0,8,1,11,12,3,1,1,1,1,11,12,3,1,9,0},

            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,12,0},

            {0,3,1,9,11,12,1,1,1,1,3,8,9,1,12,0},

            {0,8,8,8,3,8,1,1,1,1,12,3,8,8,8,0},

            {0,8,8,8,8,9,1,1,1,1,11,12,8,8,8,0},

            {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}

    };

    public Cenario2() {inicializarHitboxes();};

    @Override
    protected void inicializarHitboxes() {


        hitboxesObjetos.add(new Rectangle(48, 48, 160, 100));// Casa superior esquerda
        hitboxesObjetos.add(new Rectangle(550, 48, 170, 100));// Casa superior direita
        hitboxesObjetos.add(new Rectangle(48, 290, 130, 100));// Casa inferior esquerda
        hitboxesObjetos.add(new Rectangle(560, 280, 160, 110));// Casa inferior direita

        // FONTE //
        hitboxesObjetos.add(new Rectangle(332, 170, 85, 70));// Fonte - centro
        hitboxesObjetos.add(new Rectangle(318, 205, 115, 60));// Base inferior
    }
};

