package jogoBiblioteca.cenarios;

import java.awt.*;

public class Cenario2 extends CenarioBase {

    public static final int[][] MAPA = {
            {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            {0,  8,  8,  8,  9, 11,  8, 12,  25, 12,  25,  8,  8,  8,  8,  0},
            {0,  8,  8,  8, 11, 11, 19, 14, 14, 20,  3,  8,  8,  8,  8,  0},
            {0,  8, 18, 11, 11,  3, 13,  1,  1, 15, 11, 11,  3, 18,  9,  0},
            {0,  8, 18, 11, 11,  3, 13,  1,  1, 15, 11, 11,  3, 18,  9,  0},
            {17, 17,  1, 17, 17, 17,  1,  1,  1,  1, 17, 17, 17,  1, 17, 17},
            {0,  3, 18,  9, 11, 11, 13,  1,  1, 15,  3,  8,  9,  1,  9,  0},
            {0,  8,  8,  8,  3,  8, 21, 16, 16, 22,  9,  3,  8,  8,  8,  0},
            {0,  8,  8,  8,  8,  9, 11,  8,  9,  8, 11, 11,  8,  8,  8,  0},
            {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}
    };

    public Cenario2() { inicializarHitboxes(); }

    @Override
    protected void inicializarHitboxes() {

        // CASAS
        hitboxesObjetos.add(new Rectangle(48, 48, 200, 100));// Casa superior esquerda
        hitboxesObjetos.add(new Rectangle(550, 48, 140, 100));// Casa superior direita
        hitboxesObjetos.add(new Rectangle(48, 330, 130, 100));// Casa inferior esquerda
        hitboxesObjetos.add(new Rectangle(550, 330, 160, 110));// Casa inferior direita

        // FONTE
        hitboxesObjetos.add(new Rectangle(320, 185,  95,  50)); // Fonte centro
        hitboxesObjetos.add(new Rectangle(305, 220, 125,  40)); // Base inferior

        // POSTES
        hitboxesObjetos.add(new Rectangle(235, 280,  10,  10)); // Poste esquerdo
        hitboxesObjetos.add(new Rectangle(490, 150,  30,  30)); // Poste direito

        // ARVORES
        hitboxesObjetos.add(new Rectangle(195, 180,  55,  25)); // Arvore superior esquerda
        hitboxesObjetos.add(new Rectangle(540, 190,  50,  25)); // Arvore superior direita
        hitboxesObjetos.add(new Rectangle(480, 400,  80,  30)); // Arvore inferior direita

        // CERCA
        hitboxesObjetos.add(new Rectangle(170, 155,  90,  30)); // Cerca

        // MOITAS SUPERIORES
        hitboxesObjetos.add(new Rectangle(205, 45, 50, 25));   // moita casa esq
        hitboxesObjetos.add(new Rectangle(315, 55, 55, 25));   // moita centro
        hitboxesObjetos.add(new Rectangle(470, 95, 95, 40));   // moita casa dir
        hitboxesObjetos.add(new Rectangle(40, 195, 55, 30));   // moita lateral esq
        hitboxesObjetos.add(new Rectangle(565, 145, 65, 35));  // moita lateral dir

        // MOITAS INFERIORES
        hitboxesObjetos.add(new Rectangle(145, 295, 80, 40));
        hitboxesObjetos.add(new Rectangle(215, 280, 55, 30));
        hitboxesObjetos.add(new Rectangle(180, 330, 110, 60));

    }
}