package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;
import jogoBiblioteca.cenarios.Cenario4;

/** Cenário 4 — Labirinto cruzado. */
public class DesenhistaCenario4 implements DesenhistaCenario {
    private Cenario4 cenario4ref;
    public void setCenario4(Cenario4 c4) { this.cenario4ref = c4; }

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {

        desenharParedes(d2, sprites);

        // ------------------  LUZ ------------------
        if (sprites.imgLustre1 != null) {
            d2.drawImage(sprites.imgLustre1, 730, 180, 40, 80, null);
        }


        // ------------------ Mesa lateral ------------------
        if (sprites.imgMesaLateral != null) {
            d2.drawImage(sprites.imgMesaLateral, 735, 250, 35, 60, null);
        }

        // -------------------- ESTANTES -----------------

        d2.drawImage(sprites.imgEstanteLateral, 730, 290, 48, 100, null);
        d2.drawImage(sprites.imgEstanteLateral, 730, 340, 48, 100, null);
        d2.drawImage(sprites.imgEstanteLateral, 730, 410, 48, 100, null);


        if (sprites.imgEstanteCheia != null) {
            // ------------------- ESTANTES DE CIMA --------------------
            d2.drawImage(sprites.imgEstanteCheia, 650, 40,  96, 90, null);
            d2.drawImage(sprites.imgEstanteCheia, 570, 40,  96, 90, null);

            // ESTANTES DA ESQUERDA MEIO
            d2.drawImage(sprites.imgEstante,      240, 100, 96, 90, null);
            d2.drawImage(sprites.imgEstante,      240, 300, 96, 90, null);

            d2.drawImage(sprites.imgEstante,      150, 100, 96, 90, null);
            d2.drawImage(sprites.imgEstante,      150, 300, 96, 90, null);

            // ESTANTES DA DIREITA

            d2.drawImage(sprites.imgEstante,      430, 100, 96, 90, null);
            d2.drawImage(sprites.imgEstante,      430, 300, 96, 90, null);

            // ----------------- CADEIRA MESA TOP DIREITA--------------------

            if (sprites.imgCadeiraL != null) {
                d2.drawImage(sprites.imgCadeiraL, 580, 170, 20, 50, null);
            }

            if (sprites.imgCadeiraD != null) {
                d2.drawImage(sprites.imgCadeiraD, 620, 230, 30, 30, null);
            }

            if (sprites.imgCadeiraT != null) {
                d2.drawImage(sprites.imgCadeiraT, 620, 130, 25, 50, null);
            }

            if (sprites.imgCadeiraR != null) {
                d2.drawImage(sprites.imgCadeiraR, 670, 170, 25, 50, null);
            }

            // ----------------- MESA --------------------

            if (sprites.imgMesaRedonda != null) {
                d2.drawImage(sprites.imgMesaRedonda, 600, 160, 70, 70, null);
            }

            // ----------------- CADEIRA MESA DIREITA INFERIOR--------------------

            if (sprites.imgCadeiraL != null) {
                d2.drawImage(sprites.imgCadeiraL, 580, 360, 20, 50, null);
            }

            if (sprites.imgCadeiraD != null) {
                d2.drawImage(sprites.imgCadeiraD, 620, 420, 30, 30, null);
            }

            if (sprites.imgCadeiraT != null) {
                d2.drawImage(sprites.imgCadeiraT, 620, 320, 25, 50, null);
            }

            if (sprites.imgCadeiraR != null) {
                d2.drawImage(sprites.imgCadeiraR, 670, 360, 25, 50, null);
            }

            // ----------------- MESA --------------------

            if (sprites.imgMesaRedonda != null) {
                d2.drawImage(sprites.imgMesaRedonda, 600, 350, 70, 70, null);
            }

            // -------------------- CHAVE ITEM -----------------------

            if (sprites.imgChaveItem != null && (cenario4ref == null || !cenario4ref.isChaveColetada()))
                d2.drawImage(sprites.imgChaveItem, 735, 270, 35, 20, null);

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
            d2.drawImage(sprites.imgEstanteLateral, 730, 50, 48, 100, null);
            d2.drawImage(sprites.imgEstanteLateral, 730, 100, 48, 100, null);
            d2.drawImage(sprites.imgEstanteLateral, 730, 150, 48, 100, null);
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