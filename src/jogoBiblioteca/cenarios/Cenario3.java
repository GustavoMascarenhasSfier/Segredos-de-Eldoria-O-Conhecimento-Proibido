package jogoBiblioteca.cenarios;

import java.awt.*;

// Cenário 3 — Interior da Biblioteca
// Tile 48x48px | 16 cols (0-15) x 10 linhas (0-9)
// 0=parede(colisão) 1=areia(passável) 4=piso branco(passável) 5=cinza(colisão)
public class Cenario3 extends CenarioBase {

    // ── Estado da mecânica de inventário ─────────────────────────────────────
    /** true depois que o jogador pegou o livro da mesa central */
    private boolean livroColetado = false;

    private boolean livro2Coletado = false;

    /** true depois que o livro foi depositado no javali — tile de passagem abre */
    private boolean passagemAberta = false;

    // Zona de interação: mesa central (livro aberto em cima)
    public static final Rectangle ZONA_MESA_LIVRO = new Rectangle(310, 195, 160, 100);

    // Zona de interação: mesa pequena (canto inferior esquerdo)
    public static final Rectangle ZONA_MESA_LIVRO2 = new Rectangle(80, 300, 120, 90);


    // Zona de interação: javali (bicho2) desenhado em (670, 20) tamanho 48x48
    public static final Rectangle ZONA_JAVALI = new Rectangle(648, 10, 100, 80);// javali x=670 y=20

    // Ao abrir, removemos a hitbox e marcamos passagemAberta para desenho
    public static final Rectangle HITBOX_PASSAGEM = new Rectangle(672, 48, 48, 48);  // tile [1][14] embaixo da bandeira direita

    // --------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------ PORTA PARA O CENARIO 5 --------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------

    public static final Rectangle ZONA_PORTA_C5 = new Rectangle(288, 420, 144, 60);

    private boolean portaC5Aberta = false;
    public boolean isPortaC5Aberta() { return portaC5Aberta; }
    public void abrirPortaC5() {
        portaC5Aberta = true;
        hitboxesObjetos.remove(hitboxPortaCentral);
    }


    // Campo para referenciar a hitbox da porta
    private final Rectangle hitboxPortaCentral = new Rectangle(330, 470, 100, 20);


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
            /* 9*/ {0, 4, 4, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
    };

    public Cenario3() {
        inicializarHitboxes();
    }

    // ── Getters de estado ──────────────────────────────────────────────────────
    public boolean isLivroColetado()  { return livroColetado; }
    public boolean isLivro2Coletado() { return livro2Coletado; }
    public boolean isPassagemAberta() { return passagemAberta; }

    // ── Ações chamadas pelo tileMap ────────────────────────────────────────────
    /** Jogador coleta o livro da mesa central. */
    public void coletarLivro() {
        livroColetado = true;
    }

    /** Jogador deposita o livro no javali → abre a passagem. */
    public void depositarLivroNoJavali() {
        passagemAberta = true;
        // Remove a hitbox da passagem para o jogador poder passar
        hitboxesObjetos.removeIf(r -> r.x == 720 && r.y == 98 && r.width == 48 && r.height == 48);
    }

    /** Jogador coleta o segundo livro da mesa pequena. */
    public void coletarLivro2() {
        livro2Coletado = true;
    }

    @Override
    protected void inicializarHitboxes() {
        // ── Paredes ────────────────────────────────────────────────────────────
        hitboxesObjetos.add(new Rectangle(0,  0, 800, 94));   // Parede direita


        // -- PAREDE INFERIOR -----------------------------------------------------

        hitboxesObjetos.add(new Rectangle(430, 470, 300, 20)); // PAREDE INFERIOR DIREITA
        hitboxesObjetos.add(new Rectangle(0, 470, 330, 20)); // PAREDE INFERIOR ESQUERDA
        hitboxesObjetos.add(hitboxPortaCentral);   // PAREDE INFERIOR CENTRAL

        // ── Objetos ────────────────────────────────────────────────────────────
        hitboxesObjetos.add(new Rectangle(318, 0, 132, 110));   // Lareira
        hitboxesObjetos.add(new Rectangle(90, 50, 120, 80));    // Piano
        hitboxesObjetos.add(new Rectangle(0, 100, 20, 150));    // Estante Lateral Cima
        hitboxesObjetos.add(new Rectangle(0, 300, 20, 170));    // Estante Lateral Baixo
        hitboxesObjetos.add(new Rectangle(96, 185, 96, 34));    // Estante Esq Topo
        hitboxesObjetos.add(new Rectangle(470, 90, 96, 50));    // Estante Topo Dir Esq
        hitboxesObjetos.add(new Rectangle(550, 90, 96, 50));    // Estante Topo Dir Dir
        hitboxesObjetos.add(new Rectangle(510, 220, 96, 34));   // Estante Dir Meio Esq
        hitboxesObjetos.add(new Rectangle(590, 220, 96, 34));   // Estante Dir Meio Dir
        hitboxesObjetos.add(new Rectangle(510, 368, 96, 34));   // Estante Dir Baixo Esq
        hitboxesObjetos.add(new Rectangle(590, 368, 96, 34));   // Estante Dir Baixo Dir
        hitboxesObjetos.add(new Rectangle(337, 215, 90, 65));   // Mesa Central
        hitboxesObjetos.add(new Rectangle(108, 318, 72, 52));   // Mesa Pequena
        hitboxesObjetos.add(HITBOX_PASSAGEM);                   // Passagem fechada (canto sup dir)
    }
}
