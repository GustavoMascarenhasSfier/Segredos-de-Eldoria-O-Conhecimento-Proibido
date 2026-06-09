package jogoBiblioteca.cenarios;

import java.awt.Rectangle;

public class Cenario1 extends CenarioBase {

    // Matriz de tiles estrutural do Cenário 1
    public static final int[][] MAPA = {
            {12, 23, 23, 12, 23, 12, 23, 23, 23, 12, 12, 23, 23, 12, 23, 12},

            {23, 10,  9,  8, 10,  9,  9,  6, 10,  8,  9, 10,  8,  8,  9, 12},
            {23,  6,  8,  19,  14,  14,  14,  14,  20,  8,  8, 10,  1, 10,  9, 23},
            {12,  8, 10,  13,  1,  1,  1,  1,  1,  20,  8,  19,  15,  9,  8, 23},
            {12,  6,  9,  13,  1,  5,  1,  1,  1,  1,  14,  1,  1,  20,  8, 12},
            {12,  9,  8,  13,  1,  1,  1,  1,  1,  1,  1,  1,  16,  16,  17,  17 },
            {23,  8,  9,  21,  16,  16,  1,  1,  1,  16,  16, 22, 10,  8,  8, 23},

            {23,  9,  8,  9,  8, 10,  13,  1,  15, 10,  8,  8, 10, 10,  6, 23},
            {12, 10,  8, 10,  9,  8,  21,  16,  22,  9, 10,  9,  8,  9,  8, 12},

            {23, 23, 12, 12, 23, 12, 12, 23, 12, 23, 12, 23, 23, 23, 12, 12}
    };

    public Cenario1() {
        inicializarHitboxes();
    }

    @Override
    protected void inicializarHitboxes() {
        // ---------------- ÁRVORES PEQUENAS ----------------
        hitboxesObjetos.add(new Rectangle(40, 280, 40, 30));    // árvore inferior esquerda
        hitboxesObjetos.add(new Rectangle(365, 90, 80, 25));    // árvore superior central
        hitboxesObjetos.add(new Rectangle(630, 390, 0, 0));  // árvore inferior direita

        // ---------------- ÁRVORES GRANDES ----------------
        hitboxesObjetos.add(new Rectangle(220, 400, 70, 30));   // Primeira árvore inferior esquerda
        hitboxesObjetos.add(new Rectangle(460, 340, 60, 40));   // Primeira árvore inferior direita
        hitboxesObjetos.add(new Rectangle(70, 150, 50, 50));    // Árvore superior esquerda
        hitboxesObjetos.add(new Rectangle(640, 150, 80, 50));   // Árvore superior direita
        hitboxesObjetos.add(new Rectangle(240, 20, 50, 50));    // Árvore atrás do baú

        // ---------------- OBJETOS ----------------
        hitboxesObjetos.add(new Rectangle(480, 40, 170, 90));   // Casa
        hitboxesObjetos.add(new Rectangle(300, 35, 800, 50));   // Baú
        hitboxesObjetos.add(new Rectangle(215, 210, 80, 40));   // Estátua
        hitboxesObjetos.add(new Rectangle(180, 80, 60, 30));    // Banco 0 (Superior esquerdo)
        hitboxesObjetos.add(new Rectangle(410, 360, 20, 45));   // Banco 1 (Inferior central)
    }
}