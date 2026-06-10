package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;
import jogoBiblioteca.cenarios.Cenario1;

/**
 * Cenário 1 — Mundo exterior.
 * Padrão de desenho IGUAL ao Cenário 5:
 *   - desenharFundo: desenha a estátua SEMPRE (fica atrás do jogador por padrão)
 *   - desenharFrente: redesenha a estátua na frente SOMENTE se o jogador
 *     estiver acima da linha de profundidade (peJogador < ESTATUA_LINHA_Y)
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

        // ---------------- GIRASSÓIS ----------------
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

        // ---------------- ESTÁTUA (camada de fundo) ----------------
        // Sempre desenhada aqui. Quando o jogador estiver ABAIXO da linha,
        // ela não será redesenhada na frente → jogador aparece na frente dela.
        if (sprites.imgEstatua != null) {
            d2.drawImage(sprites.imgEstatua,
                    Cenario1.ESTATUA_X,
                    Cenario1.ESTATUA_Y,
                    Cenario1.ESTATUA_W,
                    Cenario1.ESTATUA_H,
                    null);
        }
    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {

        // ---------------- ESTÁTUA (camada de frente) ----------------
        // Mesmo padrão do Cenário 5:
        // Se o pé do jogador está ACIMA da linha de profundidade da estátua,
        // redesenha ela na frente para cobrir o jogador (ele está "atrás").
        if (sprites.imgEstatua != null && peJogador < Cenario1.ESTATUA_LINHA_Y) {
            d2.drawImage(sprites.imgEstatua,
                    Cenario1.ESTATUA_X,
                    Cenario1.ESTATUA_Y,
                    Cenario1.ESTATUA_W,
                    Cenario1.ESTATUA_H,
                    null);
        }

        // ---------------- ÁRVORES DA FRENTE ----------------
        if (sprites.arvores != null) {
            if (sprites.arvores[2] != null) {
                d2.drawImage(sprites.arvores[2], -20, -40, 200, 250, null);   // sup esq
                d2.drawImage(sprites.arvores[2], 600, -10, 170, 200, null);   // sup dir
                d2.drawImage(sprites.arvores[2], 180, 250, 150, 180, null);   // inf esq
                d2.drawImage(sprites.arvores[2], 420, 180, 150, 200, null);   // inf dir
            }
            if (sprites.arvores[1] != null) {
                d2.drawImage(sprites.arvores[1], 280, -120, 250, 250, null);  // central topo
                d2.drawImage(sprites.arvores[1], -60, 80, 200, 250, null);    // meio esq
                d2.drawImage(sprites.arvores[1], -60, 200, 250, 300, null);   // canto inf esq
                d2.drawImage(sprites.arvores[1], 560, 190, 250, 300, null);   // canto inf dir
            }
        }
    }
}