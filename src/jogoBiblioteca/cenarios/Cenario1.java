package jogoBiblioteca.cenarios;

import java.awt.Rectangle;

public class Cenario1 extends CenarioBase {

    // Matriz de tiles estrutural do Cenário 1
    public static final int[][] MAPA = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,10,9,8,10,9,9,6,10,8,9,10,8,8,9,0},
            {0,6,8,1,1,1,1,10,8,8,8,10,1,10,9,0},
            {0,8,10,1,1,1,1,1,1,1,8,1,1,9,8,0},
            {0,6,9,1,1,5,1,1,1,1,1,1,1,1,8,0},
            {0,9,8,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,8,9,1,1,1,1,1,1,1,1,1,10,1,8,0},
            {0,9,8,9,8,10,8,1,1,10,8,8,10,10,6,0},
            {0,10,8,10,9,8,1,1,1,9,10,9,8,9,8,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    public Cenario1() {
        inicializarHitboxes();
    }

    @Override
    protected void inicializarHitboxes() {
        // ---------------- ÁRVORES PEQUENAS ----------------
        hitboxesObjetos.add(new Rectangle(40, 280, 40, 30));    // árvore inferior esquerda
        hitboxesObjetos.add(new Rectangle(365, 90, 80, 25));    // árvore superior central
        hitboxesObjetos.add(new Rectangle(630, 390, 100, 50));  // árvore inferior direita

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
    }
}