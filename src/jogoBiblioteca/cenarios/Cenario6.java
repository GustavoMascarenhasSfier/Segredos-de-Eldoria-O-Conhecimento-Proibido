package jogoBiblioteca.cenarios;

import java.awt.*;

public class Cenario6 extends CenarioBase {

    public static final Rectangle ZONA_LIVRO_1 = new Rectangle(250, 402, 20, 20);
    public static final Rectangle ZONA_LIVRO_2 = new Rectangle(586, 154, 20, 20);
    public static final Rectangle ZONA_LIVRO_3 = new Rectangle(538, 402, 20, 20);
    public static final Rectangle ZONA_LIVRO_4 = new Rectangle(684, 402, 20, 20);

    private boolean livro1Coletado = false;
    private boolean livro2Coletado = false;
    private boolean livro3Coletado = false;
    private boolean livro4Coletado = false;

    public boolean isLivro1Coletado() { return livro1Coletado; }
    public void coletarLivro1() {
        livro1Coletado = true;
    }

    public boolean isLivro2Coletado() { return livro2Coletado; }
    public void coletarLivro2() {
        livro2Coletado = true;
    }

    public boolean isLivro3Coletado() { return livro3Coletado; }
    public void coletarLivro3() {livro3Coletado = true;}

    public boolean isLivro4Coletado() { return livro4Coletado; }
    public void coletarLivro4() {
        livro4Coletado = true;
    }

    public static final int[][] MAPA = {
            {26,26,26,26,26,26,26,23,26,26,26,26,26,26,26,26},
            {26,23,23,23,23,23,26,23,26,23,23,23,23,23,23,26},
            {26,23,26,26,26,23,26,23,26,23,26,26,26,26,23,26},
            {26,23,26,23,23,23,26,23,23,23,26,23,23,26,23,26},
            {26,23,26,23,26,26,26,26,26,23,26,23,26,26,23,26},
            {26,23,26,23,23,23,23,23,26,23,26,23,23,23,23,26},
            {26,23,26,26,26,26,26,23,26,23,26,26,26,26,23,26},
            {26,23,23,23,23,23,26,23,23,23,26,23,23,23,23,26},
            {26,26,26,26,26,23,26,26,26,26,26,23,26,26,23,26},
            {26,26,26,26,26,26,26,26,26,26,26,26,26,26,26,26}
    };

    public Cenario6() {
        inicializarHitboxes();
    }

    protected void inicializarHitboxes() {

    };
}
