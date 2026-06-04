package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/**
 * Cenário 1 — Mundo exterior.
 * Contém: casa, baú, árvores de topo e de baixo.
 */
public class DesenhistaCenario1 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {
        // ---------------- CASA ----------------
        if (sprites.imgCasa != null) {
            d2.drawImage(sprites.imgCasa, 467, -60, 200, 200, null);
        }

        // ---------------- ÁRVORE ATRÁS DO BAÚ ----------------
        if (sprites.arvores != null && sprites.arvores[2] != null) {
            d2.drawImage(sprites.arvores[2], 180, -170, 200, 250, null);
        }

        // ---------------- BAÚ ----------------
        if (sprites.baus != null && sprites.baus[0] != null) {
            d2.drawImage(sprites.baus[0], 270, 35, 140, 50, null);
        }

        // ---------------- GIRASSOL ----------------
        if (sprites.imgGirassol != null) {
            d2.drawImage(sprites.imgGirassol, 150, 350, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 150, 40, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 500, 380, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 490, 130, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 700, 140, 40, 50, null);
        }

        // ---------------- BANCOS ----------------
        if (sprites.bancos != null) {
            if (sprites.bancos[0] != null) {
                d2.drawImage(sprites.bancos[0], 170, 50, 80, 60, null);
            }
            if (sprites.bancos[1] != null) {
                d2.drawImage(sprites.bancos[1], 397, 350, 50, 60, null);
            }
        }
    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {
        // sempre desenha tudo, sem condição de sumir

        // ------------------ ESTÁTUA ------------------
        if (sprites.imgEstatua != null) {
            d2.drawImage(sprites.imgEstatua, 200, 90, 110, 170, null);
        }

        if (sprites.arvores != null) {
            // Árvore canto superior esquerdo
            if (sprites.arvores[2] != null) {
                d2.drawImage(sprites.arvores[2], -20, -40, 200, 250, null);
            }

            // Árvore canto superior direito
            if (sprites.arvores[2] != null) {
                d2.drawImage(sprites.arvores[2], 600, 0, 170, 200, null);
            }

            // Árvore central do topo
            if (sprites.arvores[1] != null) {
                d2.drawImage(sprites.arvores[1], 280, -120, 250, 250, null);
            }

            // ---------------- ÁRVORES INFERIORES ESQUERDA ----------------
            if (sprites.arvores[2] != null) {
                // Primeira árvore inferior esquerda
                d2.drawImage(sprites.arvores[2], 180, 250, 150, 180, null);
            }

            if (sprites.arvores[1] != null) {
                // Árvore meio esquerda
                d2.drawImage(sprites.arvores[1], -60, 80, 200, 250, null);
                // Árvore canto inferior esquerdo
                d2.drawImage(sprites.arvores[1], -60, 200, 250, 300, null);
            }

            // ---------------- ÁRVORES INFERIORES DIREITA ----------------
            if (sprites.arvores[2] != null) {
                // Primeira árvore inferior direita
                d2.drawImage(sprites.arvores[2], 420, 180, 150, 200, null);
            }

            if (sprites.arvores[1] != null) {
                // Segunda árvore inferior direita
                d2.drawImage(sprites.arvores[1], 560, 190, 250, 300, null);
            }
            // ---------------- PILAR ----------------
            if (sprites.imgPilar != null) {
                d2.drawImage(sprites.imgPilar, 650, 180, 60, 60, null);
            }
        }
    }
}