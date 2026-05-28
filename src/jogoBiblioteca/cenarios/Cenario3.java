package jogoBiblioteca.cenarios;

import java.awt.*;

// Cenário 3 — Interior da Biblioteca
// Tile 48x48px | 16 cols (0-15) x 10 linhas (0-9)
// 0=parede(colisão) 1=areia(passável) 4=piso branco(passável) 5=cinza(colisão)
public class Cenario3 extends CenarioBase {
    public static final int[][] MAPA = {
            //  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
            /* 0*/ {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            /* 1*/ {0, 4, 4, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 4, 0},
            /* 2*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 3*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 4*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 5*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 6*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 7*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 8*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 9*/ {0, 4, 4, 4, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
    };

    public Cenario3() {
        inicializarHitboxes();
    }

    @Override
    protected void inicializarHitboxes() {
        hitboxesObjetos.add(new Rectangle(318, 0, 132, 110));   // Lareira
        hitboxesObjetos.add(new Rectangle(90, 70, 120, 60));    // Piano
        hitboxesObjetos.add(new Rectangle(0, 110, 20, 150));    // Estante Lateral Cima
        hitboxesObjetos.add(new Rectangle(0, 300, 20, 150));    // Estante Lateral Baixo
        hitboxesObjetos.add(new Rectangle(96, 185, 96, 34));    // Estante Esq Topo
        hitboxesObjetos.add(new Rectangle(470, 90, 96, 50));    // Estante Topo Dir Esq
        hitboxesObjetos.add(new Rectangle(550, 90, 96, 50));    // Estante Topo Dir Dir
        hitboxesObjetos.add(new Rectangle(510, 220, 96, 34));   // Estante Dir Meio Esq
        hitboxesObjetos.add(new Rectangle(590, 220, 96, 34));   // Estante Dir Meio Dir
        hitboxesObjetos.add(new Rectangle(510, 368, 96, 34));   // Estante Dir Baixo Esq
        hitboxesObjetos.add(new Rectangle(590, 368, 96, 34));   // Estante Dir Baixo Dir
        hitboxesObjetos.add(new Rectangle(337, 215, 90, 65));   // Mesa Central
        hitboxesObjetos.add(new Rectangle(108, 318, 72, 52));   // Mesa Pequena
    }
}
