package jogoBiblioteca.cenarios;

import java.awt.*;

// Cenário 3 — Interior da Biblioteca
public class Cenario3 extends CenarioBase {

    // ── Estado da mecânica de inventário ──
    private boolean lanternaColetada = false;
    private boolean livroColetado = false;
    private boolean livro2Coletado = false;
    private boolean passagemAberta = false;
    public static final Rectangle ZONA_PIANO_LANTERNA = new Rectangle(90, 50, 120, 80);
    public static final Rectangle ZONA_MESA_LIVRO = new Rectangle(310, 195, 160, 100);
    public static final Rectangle ZONA_MESA_LIVRO2 = new Rectangle(80, 300, 120, 90);
    public static final Rectangle ZONA_JAVALI = new Rectangle(648, 10, 100, 80);// javali x=670 y=20
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
    public boolean isLanternaColetada() {return lanternaColetada; }
    public boolean isLivroColetado()  { return livroColetado; }
    public boolean isLivro2Coletado() { return livro2Coletado; }
    public boolean isPassagemAberta() { return passagemAberta; }

    // ── Ações chamadas pelo tileMap ────────────────────────────────────────────
    /** Jogador coleta o livro da mesa central. */
    public void coletarLivro() {
        livroColetado = true;
    }

    public  void coletarLanterna() {lanternaColetada = true;}

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
        hitboxesObjetos.add(new Rectangle(720,  0, 48, 95));   // Parede direita
        hitboxesObjetos.add(new Rectangle(720,  98, 48, 48));   // Parede direita passagem secreta
        hitboxesObjetos.add(new Rectangle(720,  142, 48, 480));   // Parede direita
        hitboxesObjetos.add(new Rectangle(432,  0, 240, 48));   // Parede sup direita (lin0, cols 9-13)
        hitboxesObjetos.add(new Rectangle(432, 48, 240, 48));   // Parede lin1, cols 9-13
        hitboxesObjetos.add(new Rectangle(  0,  0, 288, 48));   // Parede sup esquerda (lin0, cols 0-5)
        hitboxesObjetos.add(new Rectangle(  0, 48,  48, 48));   // Parede lin1 col0
        hitboxesObjetos.add(new Rectangle(144, 48, 144, 48));   // Parede lin1 cols 3-5
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
        hitboxesObjetos.add(new Rectangle(96, 190, 96, 60));    // Estante Esq Topo
        hitboxesObjetos.add(new Rectangle(470, 90, 96, 50));    // Estante Topo Dir Esq
        hitboxesObjetos.add(new Rectangle(550, 90, 96, 50));    // Estante Topo Dir Dir
        hitboxesObjetos.add(new Rectangle(510, 230, 96, 50));   // Estante  Meio Esq lado direito do cenario
        hitboxesObjetos.add(new Rectangle(590, 230, 96, 50));   // Estante Dir Meio Dir
        hitboxesObjetos.add(new Rectangle(510, 378, 96, 50));   // Estante Dir Baixo Esq
        hitboxesObjetos.add(new Rectangle(590, 378, 96, 50));   // Estante Dir Baixo Dir
        hitboxesObjetos.add(new Rectangle(337, 215, 90, 65));   // Mesa Central
        hitboxesObjetos.add(new Rectangle(108, 318, 72, 52));   // Mesa Pequena
        hitboxesObjetos.add(new Rectangle(140, 450, 105, 60));   // Mesa com livro em cima

        hitboxesObjetos.add(HITBOX_PASSAGEM);                   // Passagem fechada (canto sup dir)
    }
}

