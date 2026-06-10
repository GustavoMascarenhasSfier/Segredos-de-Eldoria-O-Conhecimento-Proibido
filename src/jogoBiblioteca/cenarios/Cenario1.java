package jogoBiblioteca.cenarios;

import java.awt.Rectangle;

public class Cenario1 extends CenarioBase {

    public static final int[][] MAPA = {
            {12, 25, 25, 12, 25, 12, 25, 25, 25, 12, 12, 25, 25, 12, 25, 12},
            {25, 10,  9,  8, 10,  9,  9,  6, 10,  8,  9, 10,  8,  8,  9, 12},
            {25,  6,  8,  19,  14,  14,  14,  14,  20,  8,  8, 10,  1, 10,  9, 25},
            {12,  8, 10,  13,  1,  1,  1,  1,  1,  20,  8,  19,  15,  9,  8, 25},
            {12,  6,  9,  13,  1,  5,  1,  1,  1,  1,  14,  1,  1,  20,  8, 12},
            {12,  9,  8,  13,  1,  1,  1,  1,  1,  1,  1,  1,  16,  16,  17,  17},
            {25,  8,  9,  21,  16,  16,  1,  1,  1,  16,  16, 22, 10,  8,  8, 25},
            {25,  9,  8,  9,  8, 10,  13,  1,  15, 10,  8,  8, 10, 10,  6, 25},
            {12, 10,  8, 10,  9,  8,  21,  16,  22,  9, 10,  9,  8,  9,  8, 12},
            {25, 25, 12, 12, 25, 12, 12, 25, 12, 25, 12, 25, 25, 25, 12, 12}
    };

    // Estátua — constantes usadas no DesenhistaCenario1
    // Sprite: x=200, y=90, w=110, h=170
    public static final int ESTATUA_X       = 200;
    public static final int ESTATUA_Y       = 90;
    public static final int ESTATUA_W       = 110;
    public static final int ESTATUA_H       = 170;

    // Linha de profundidade: pé do jogador abaixo disso → estátua fica atrás
    public static final int ESTATUA_LINHA_Y = ESTATUA_Y + ESTATUA_H - 25; // ≈ 235

    public Cenario1() {
        inicializarHitboxes();
    }

    @Override
    protected void inicializarHitboxes() {

        // ---------------- ÁRVORES PEQUENAS ----------------
        hitboxesObjetos.add(new Rectangle( 40, 280, 40, 30));   // árvore inferior esquerda
        hitboxesObjetos.add(new Rectangle(365,  90, 80, 25));   // árvore superior central
        hitboxesObjetos.add(new Rectangle(630, 390,  0,  0));   // árvore inferior direita (sem colisão)

        // ---------------- ÁRVORES GRANDES — topo ----------------
        hitboxesObjetos.add(new Rectangle( 70, 150, 50, 50));   // árvore superior esquerda
        hitboxesObjetos.add(new Rectangle(640, 150, 80, 50));   // árvore superior direita
        hitboxesObjetos.add(new Rectangle(240,  20, 50, 50));   // árvore atrás do baú

        // ---------------- ÁRVORES INFERIORES — ESQUERDA ----------------
        // arvores[2] em (180, 250, 150, 180) → base ≈ y=430, x=180..330
        hitboxesObjetos.add(new Rectangle(200, 390, 110, 40));  // primeira árvore inf esquerda
        // arvores[1] em (-60, 80, 200, 250) → base ≈ y=330, x=0..140
        hitboxesObjetos.add(new Rectangle(  0, 300,  90, 40));  // árvore meio esquerda
        // arvores[1] em (-60, 200, 250, 300) → base ≈ y=500 (fora da tela)
        hitboxesObjetos.add(new Rectangle(  0, 440, 130, 40));  // árvore canto inf esquerdo

        // ---------------- ÁRVORES INFERIORES — DIREITA ----------------
        // arvores[2] em (420, 180, 150, 200) → base ≈ y=380, x=420..570
        hitboxesObjetos.add(new Rectangle(440, 340, 110, 40));  // primeira árvore inf direita
        // arvores[1] em (560, 190, 250, 300) → base ≈ y=490, x=560..810
        hitboxesObjetos.add(new Rectangle(580, 430, 150, 40));  // segunda árvore inf direita

        // ---------------- OBJETOS ----------------
        hitboxesObjetos.add(new Rectangle(480,  40, 170, 90));  // Casa
        hitboxesObjetos.add(new Rectangle(300,  35, 800, 50));  // Baú

        // ESTÁTUA — hitbox na base do pedestal
        hitboxesObjetos.add(new Rectangle(215, 190, 90, 40));   // Estátua


        hitboxesObjetos.add(new Rectangle(180,  80,  60, 30));  // Banco 0 (superior esquerdo)
        hitboxesObjetos.add(new Rectangle(410, 360,  20, 45));  // Banco 1 (inferior central)
    }
}
