package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/** Cenário 4 — Labirinto cruzado. */
public class DesenhistaCenario4 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {

        desenharParedes(d2, sprites);

        // ------------------ Mesa lateral ------------------
        if (sprites.imgMesaLateral != null) {
            d2.drawImage(sprites.imgMesaLateral, 670, 280, 50, 100, null);
        }

        // ------------------  LUZ ------------------
        if (sprites.imgLustre1 != null) {
            d2.drawImage(sprites.imgLustre1, 700, 300, 50, 100, null);
        }

        if (sprites.imgEstanteCheia != null) {
            // ------------------- ESTANTES DE CIMA --------------------
            d2.drawImage(sprites.imgEstanteCheia, 650, 40,  96, 90, null);
            d2.drawImage(sprites.imgEstanteCheia, 570, 40,  96, 90, null);

            // ESTANTES DA ESQUERDA MEIO
            d2.drawImage(sprites.imgEstante,      240, 100, 96, 90, null);
            d2.drawImage(sprites.imgEstante,      240, 300, 96, 90, null);

            d2.drawImage(sprites.imgEstante,      160, 100, 96, 90, null);
            d2.drawImage(sprites.imgEstante,      160, 300, 96, 90, null);

            // ESTANTES DA DIREITA

            d2.drawImage(sprites.imgEstante,      430, 100, 96, 90, null);
            d2.drawImage(sprites.imgEstante,      430, 300, 96, 90, null);


        }

    }


    private void desenharParedes(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgParede != null) {
            d2.drawImage(sprites.imgParede,   0, 0, 288, 96, null);
            d2.drawImage(sprites.imgParede, 286, 0, 288, 96, null);
            d2.drawImage(sprites.imgParede, 565, 0, 288, 96, null);
        }


        // ESTANTES
        if (sprites.imgEstanteLateral != null) {
            d2.drawImage(sprites.imgEstanteLateral, 730, 40, 48, 170, null);
            d2.drawImage(sprites.imgEstanteLateral, 730, 100, 48, 170, null);
            d2.drawImage(sprites.imgEstanteLateral, 700, 220, 100, 170, null);
        }
    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {
        // ------------------ BALCAO ------------------
        if (sprites.imgBalcao != null) {
            d2.drawImage(sprites.imgBalcao, 45, 345, 130, 90, null);
        }

        // ------------------ Mesa ------------------
        if (sprites.imgMesaRedonda != null) {
            d2.drawImage(sprites.imgMesaRedonda, 350, 220, 70, 70, null);
        }

        // ------------------ Globo ------------------
        if (sprites.imgGlobo != null) {
            d2.drawImage(sprites.imgGlobo, 365, 210, 20, 30, null);
        }

        if (sprites.imgGlobo != null) {
            d2.drawImage(sprites.imgGlobo, 360, 205, 40, 50, null);
        }

    }
}