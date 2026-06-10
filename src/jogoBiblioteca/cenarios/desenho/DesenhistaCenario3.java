package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import java.awt.Color;
import jogoBiblioteca.GerenciadorSprites;
import jogoBiblioteca.cenarios.Cenario3;

/**
 * Cenário 3 — Interior da Biblioteca.
 *
 * Lógica de profundidade:
 *   pé visual da estante = y + altura
 *   peJogador < pé visual  → jogador ATRÁS  → estante redesenhada em desenharFrente() (cobre o jogador)
 *   peJogador >= pé visual → jogador NA FRENTE → estante já visível no fundo, não precisa redesenhar
 */
public class DesenhistaCenario3 implements DesenhistaCenario {

    private static final int T = 48;

    // Pés visuais de cada estante (y + h)
    private static final int PE_EST_ESQ     = 166 + 90; // = 256  (estante esquerda)
    private static final int PE_EST_DIR_MID = 200 + 90; // = 290  (estantes direita meio)
    private static final int PE_EST_DIR_LOW = 350 + 90; // = 440  (estantes direita baixo)

    private Cenario3 cenario3ref;

    public void setCenario3(Cenario3 c3) { this.cenario3ref = c3; }

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {
        desenharChao(d2, sprites);
        desenharParedes(d2, sprites);
        desenharDecoracao(d2, sprites);
        desenharMesas(d2, sprites);
        desenharTapetes(d2, sprites);
        desenharPassagem(d2, sprites);
    }

    /**
     * Redesenha as estantes POR CIMA do jogador quando ele está atrás delas.
     * As estantes também são desenhadas no fundo em desenharDecoracao(),
     * garantindo que nunca sumam independente da posição do jogador.
     */
    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {
        if (sprites.imgEstante == null) return;

        // Estante esquerda — cobre o jogador quando ele está acima de y=256
        if (peJogador < PE_EST_ESQ)
            d2.drawImage(sprites.imgEstante, 96, 166, 96, 90, null);

        // Estantes direita meio — cobrem o jogador quando ele está acima de y=290
        if (peJogador < PE_EST_DIR_MID) {
            d2.drawImage(sprites.imgEstante, 510, 200, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 590, 200, 96, 90, null);
        }

        // Estantes direita baixo — cobrem o jogador quando ele está acima de y=440
        if (peJogador < PE_EST_DIR_LOW) {
            d2.drawImage(sprites.imgEstante, 510, 350, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 590, 350, 96, 90, null);
        }
    }

    // -------------------------------------------------------------------------

    private void desenharChao(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgChaoBiblioteca == null) return;
        for (int lin = 0; lin <= 9; lin++)
            for (int col = 0; col <= 14; col++)
                d2.drawImage(sprites.imgChaoBiblioteca, col * T, lin * T, T, T, null);
    }

    private void desenharParedes(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgParede != null) {
            d2.drawImage(sprites.imgParede,   0, 0, 288, 96, null);
            d2.drawImage(sprites.imgParede, 286, 0, 288, 96, null);
            d2.drawImage(sprites.imgParede, 565, 0, 288, 96, null);
        }
        if (sprites.imgEstanteLateral != null) {
            d2.drawImage(sprites.imgEstanteLateral, -10, 110, 48, 150, null);
            d2.drawImage(sprites.imgEstanteLateral, -10, 300, 48, 150, null);
        }
    }

    private void desenharDecoracao(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgLareira != null)
            d2.drawImage(sprites.imgLareira, 312, -20, 144, 148, null);

        if (sprites.imgBandeira != null) {
            d2.drawImage(sprites.imgBandeira,   8, 20, 38, 72, null);
            d2.drawImage(sprites.imgBandeira, 722, 20, 38, 72, null);
        }

        if (sprites.imgBicho1 != null && sprites.imgBicho2 != null) {
            d2.drawImage(sprites.imgBicho1,  50, 20, 48, 48, null);
            d2.drawImage(sprites.imgBicho2, 670, 20, 48, 48, null);
        }

        if (sprites.imgPiano != null)
            d2.drawImage(sprites.imgPiano, 88, 42, 126, 90, null);

        if (sprites.imgQuadro != null)
            d2.drawImage(sprites.imgQuadro, 105, 0, 100, 50, null);

        if (sprites.imgEstanteCheia != null) {
            // Parede norte — sempre atrás do jogador, ficam só no fundo
            d2.drawImage(sprites.imgEstanteCheia, 550, 50, 96, 90, null);
            d2.drawImage(sprites.imgEstanteCheia, 470, 50, 96, 90, null);
        }

        if (sprites.imgEstante != null) {
            // Desenhadas SEMPRE no fundo.
            // Quando o jogador estiver ACIMA delas, desenharFrente() as redesenha
            // por cima do jogador — criando o efeito de profundidade correto.
            // Nunca somem porque estão sempre aqui no fundo.
            d2.drawImage(sprites.imgEstante,  96, 166, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 510, 200, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 590, 200, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 510, 350, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 590, 350, 96, 90, null);
        }

        if (sprites.imgMesaLivro != null)
            d2.drawImage(sprites.imgMesaLivro, 127, 420, 126, 60, null);
    }

    private void desenharMesas(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgTapete != null)
            d2.drawImage(sprites.imgTapete, 288, 195, 192, 124, null);

        if (sprites.imgMesaCentro != null)
            d2.drawImage(sprites.imgMesaCentro, 332, 200, 100, 90, null);

        if (sprites.imgVelas != null)
            d2.drawImage(sprites.imgVelas, 359, 210, 44, 40, null);

        if (sprites.imgLivroAberto != null && (cenario3ref == null || !cenario3ref.isLivroColetado()))
            d2.drawImage(sprites.imgLivroAberto, 365, 250, 30, 20, null);

        if (sprites.imgCadeiraCima != null) {
            d2.drawImage(sprites.imgCadeiraCima, 340, 178, 31, 42, null);
            d2.drawImage(sprites.imgCadeiraCima, 390, 178, 31, 42, null);
        }
        if (sprites.imgCadeiraBaixo != null) {
            d2.drawImage(sprites.imgCadeiraBaixo, 335, 276, 41, 44, null);
            d2.drawImage(sprites.imgCadeiraBaixo, 382, 276, 41, 44, null);
        }
        if (sprites.imgCadeiraEsquerda != null)
            d2.drawImage(sprites.imgCadeiraEsquerda, 300, 220, 44, 54, null);
        if (sprites.imgCadeiraDireita != null)
            d2.drawImage(sprites.imgCadeiraDireita, 420, 220, 44, 50, null);

        if (sprites.imgTapete2 != null)
            d2.drawImage(sprites.imgTapete2, 100, 320, 96, 62, null);

        if (sprites.imgMesaCentro != null)
            d2.drawImage(sprites.imgMesaCentro, 105, 305, 80, 72, null);

        if (sprites.imgLivroFechado != null && (cenario3ref == null || !cenario3ref.isLivro2Coletado()))
            d2.drawImage(sprites.imgLivroFechado, 130, 320, 30, 30, null);

        if (sprites.imgCadeiraCima != null)
            d2.drawImage(sprites.imgCadeiraCima, 127, 275, 36, 44, null);
        if (sprites.imgCadeiraBaixo != null)
            d2.drawImage(sprites.imgCadeiraBaixo, 127, 360, 36, 38, null);
        if (sprites.imgCadeiraEsquerda != null)
            d2.drawImage(sprites.imgCadeiraEsquerda, 80, 320, 38, 48, null);
        if (sprites.imgCadeiraDireita != null)
            d2.drawImage(sprites.imgCadeiraDireita, 170, 320, 38, 48, null);
    }

    private void desenharTapetes(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgTapeteInferior != null)
            d2.drawImage(sprites.imgTapeteInferior, 310, 400, 150, 80, null);

        if (sprites.imgTapeteLateral != null) {
            d2.drawImage(sprites.imgTapeteLateral, -20, 239, 100, 80, null);
            d2.drawImage(sprites.imgTapeteLateral, 660,  85,  60, 70, null);
        }
    }

    private void desenharPassagem(Graphics2D d2, GerenciadorSprites sprites) {
        if (cenario3ref == null || !cenario3ref.isPassagemAberta()) return;
        if (sprites.imgChaoBiblioteca != null)
            d2.drawImage(sprites.imgChaoBiblioteca, 720, 98, 48, 48, null);
        d2.setColor(new Color(255, 215, 0, 180));
        d2.setStroke(new java.awt.BasicStroke(2));
        d2.drawRect(720, 98, 46, 46);
    }
}
