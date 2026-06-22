package jogoBiblioteca.cenarios;

import java.awt.*;

// Cenário 4 — Labirinto Cruzado
// Tile 48x48px | 16 cols (0-15) x 10 linhas (0-9)
// 0=parede(colisão) 24=piso(passável)
public class Cenario4 extends CenarioBase {

    //------------------------ Estado da mecânica de inventário ---------------------------------------
    private boolean chaveColetada = false;

    public static final Rectangle ZONA_MESA_CHAVE = new Rectangle(718, 255, 70, 45);
    public static final Rectangle ZONA_MURO       = new Rectangle(430, 450, 300, 40); // mesma posição da hitbox do muro

    public boolean isChaveColetada() { return chaveColetada; }
    public void coletarChave() {
        chaveColetada = true;
    }


    public static final int[][] MAPA = {
            //  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
            /* 0*/ { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            /* 1*/ { 0, 24, 24, 24, 24, 24, 24,  0,  0, 24, 24, 24, 24, 24, 24, 24},
            /* 2*/ {24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24},
            /* 3*/ { 0, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24},
            /* 4*/ { 0, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24},
            /* 5*/ { 0, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24},
            /* 6*/ { 0, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24},
            /* 7*/ { 0, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24},
            /* 8*/ { 0, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24},
            /* 9*/ { 0,  0,  0,  0,  0,  0,  0,  0,  0, 24, 24, 24, 24, 24, 24, 24}
    };

    public Cenario4() {
        inicializarHitboxes();
    }

    @Override
    protected void inicializarHitboxes() {

        // ── Paredes derivadas do MAPA ──────────────────────────────────────────


        hitboxesObjetos.add(new Rectangle(  0,   0, 800,  96));  // Parede sup esq   (lin0-1, cols 0-5)
        hitboxesObjetos.add(new Rectangle(  0, 144,  48, 336));  // Parede esq lin3-9
        hitboxesObjetos.add(new Rectangle(  0, 432, 432,  48));  // Parede inf lin9 cols 0-8
        // ── Estantes laterais direitas ─────────────
        hitboxesObjetos.add(new Rectangle(730,  50,  48, 600));  // PAREDE DIREITA

        // ── Estantes de conteúdo ──────────────────────────────────────────────
        hitboxesObjetos.add(new Rectangle(650,  40,  96,  90));  // Estante topo dir direita
        hitboxesObjetos.add(new Rectangle(570,  40,  96,  90));  // Estante topo dir esquerda
        hitboxesObjetos.add(new Rectangle(150, 150,  96,  35));  // Estante esq cima esq
        hitboxesObjetos.add(new Rectangle(150, 350,  96,  35));  // Estante esq baixo esq
        hitboxesObjetos.add(new Rectangle(240, 150,  96,  35));  // Estante esq cima dir
        hitboxesObjetos.add(new Rectangle(240, 350,  96,  35));  // Estante esq baixo dir
        hitboxesObjetos.add(new Rectangle(430, 145,  96,  35));  // Estante dir cima
        hitboxesObjetos.add(new Rectangle(430, 345,  96,  35));  // Estante dir baixo

        // ── Mesas e móveis ────────────────────────────────────────────────────
        hitboxesObjetos.add(new Rectangle(600, 160, 70, 70));  // Mesa + cadeiras topo dir
        hitboxesObjetos.add(new Rectangle(600, 350, 70, 70));  // Mesa + cadeiras baixo dir
        hitboxesObjetos.add(new Rectangle(348, 218,  74,  74));  // Mesa redonda frente
        hitboxesObjetos.add(new Rectangle( 43, 415, 132,  20));  // Balcão
        hitboxesObjetos.add(new Rectangle( 43, 370, 30,  60));  // Balcão

        // ── Árvores decorativas ───────────────────────────────────────────────────
        hitboxesObjetos.add(new Rectangle(348, 370, 24, 20)); // ArvoreDecoracao — base do tronco
        hitboxesObjetos.add(new Rectangle(538, 155, 24, 20)); // ArvoreDecoracao1 — base do tronco

        // ── Lustres ───────────────────────────────────────────────────────────────
        hitboxesObjetos.add(new Rectangle(113, 170, 34, 20)); // Lustre esquerdo — bas
        //Muro

        hitboxesObjetos.add(new Rectangle( 430, 470, 300,  20));  // Balcão

    }
}