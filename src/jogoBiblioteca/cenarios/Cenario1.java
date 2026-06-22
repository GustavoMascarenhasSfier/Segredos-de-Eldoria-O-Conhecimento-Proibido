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

    public static final int ESTATUA_X       = 200;
    public static final int ESTATUA_Y       = 90;
    public static final int ESTATUA_W       = 110;
    public static final int ESTATUA_H       = 170;
    public static final int ESTATUA_LINHA_Y = ESTATUA_Y + ESTATUA_H - 25;

    public Cenario1() {
        inicializarHitboxes();
    }

  @Override
    protected void inicializarHitboxes() {

        // ---------------- ÁRVORE ----------------
        hitboxesObjetos.add(new Rectangle(240, 50, 80, 30));

        // ---------------- ÁRVORES DA FRENTE ----------------
        // sup esq
        hitboxesObjetos.add(new Rectangle(65, 140, 80, 30));
        // sup dir
        hitboxesObjetos.add(new Rectangle(660, 170, 80, 30));

        // inf dir
        hitboxesObjetos.add(new Rectangle(450, 355, 90, 30));

        // central topo
        hitboxesObjetos.add(new Rectangle(385, 85, 80, 30));
        // canto inf esq
        hitboxesObjetos.add(new Rectangle(20, 335, 90, 40));

        // ---------------- OBJETOS ----------------
        hitboxesObjetos.add(new Rectangle(480,  40, 170, 90));  // Casa

        // ---------------- ESTÁTUA ----------------
        hitboxesObjetos.add(new Rectangle(215, 190,  90, 40));

        // ---------------- BANCOS ----------------
        hitboxesObjetos.add(new Rectangle(180,  80,  60, 30));  // Banco 0
        hitboxesObjetos.add(new Rectangle(410, 360,  20, 45));  // Banco 1
    }
}