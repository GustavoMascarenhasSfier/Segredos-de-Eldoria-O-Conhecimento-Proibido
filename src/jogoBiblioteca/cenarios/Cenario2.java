package jogoBiblioteca.cenarios;

import java.awt.*;

public class Cenario2 extends CenarioBase{
    public static final int[][] MAPA = {

            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

            {0,8,8,8,9,11,8,12,3,11,8,8,8,8,8,0},

            {0,8,8,8,11,11,19,14,14,20,3,8,8,8,8,0},

            {0,8,18,11,11,3,13,1,1,15,11,11,3,18,9,0},

            {0,8,18,11,11,3,13,1,1,15,11,11,3,18,9,0},

            {17,17,1,17,17,17,1,1,1,1,17,17,17,1,17,17},

            {0,3,18,9,11,11,13,1,1,15,3,8,9,1,9,0},

            {0,8,8,8,3,8,21,16,16,22,9,3,8,8,8,0},

            {0,8,8,8,8,9,11,8,9,8,11,11,8,8,8,0},

            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}

    };

    public Cenario2() {inicializarHitboxes();};

    @Override
    protected void inicializarHitboxes() {


        hitboxesObjetos.add(new Rectangle(48, 48, 230, 100));// Casa superior esquerda
        hitboxesObjetos.add(new Rectangle(550, 48, 170, 100));// Casa superior direita
        hitboxesObjetos.add(new Rectangle(48, 330, 130, 100));// Casa inferior esquerda
        hitboxesObjetos.add(new Rectangle(500, 330, 220, 110));// Casa inferior direita

        // FONTE //
        hitboxesObjetos.add(new Rectangle(332, 170, 85, 70));// Fonte - centro
        hitboxesObjetos.add(new Rectangle(318, 205, 115, 60));// Base inferior

        // Poste //
        hitboxesObjetos.add(new Rectangle(210, 290, 70, 60));//
        hitboxesObjetos.add(new Rectangle(476, 40, 70, 150));

        // Arvore //
        hitboxesObjetos.add(new Rectangle(276, 40, 200, 50));//

        // Cerca //
        hitboxesObjetos.add(new Rectangle(176, 110, 100, 60));//



    }
};

