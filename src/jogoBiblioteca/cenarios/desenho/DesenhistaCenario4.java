package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;
import jogoBiblioteca.cenarios.Cenario4;

/** Cenário 4 — Labirinto cruzado. */
public class DesenhistaCenario4 implements DesenhistaCenario {
    private Cenario4 cenario4ref;
    public void setCenario4(Cenario4 c4) { this.cenario4ref = c4; }

    // ── Pés visuais para Y-sorting (y + height do sprite) ──────────────────
    // Estantes de cima:  y=100 + h=90 = 190
    // Estantes de baixo: y=300 + h=90 = 390
    // Lustre esquerdo:   y=120 + h=80 = 200
    // ArvoreDecoracao:   y=310 + h=80 = 390
    // ArvoreDecoracao1:  y=100 + h=80 = 180
    private static final int PE_ESTANTE_CIMA  = 190;
    private static final int PE_ESTANTE_BAIXO = 390;
    private static final int PE_LUSTRE_ESQ    = 200;
    private static final int PE_ARVORE_DIR    = 390;
    private static final int PE_ARVORE1       = 180;

    // =========================================================================
    // FUNDO
    // =========================================================================
    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {
        desenharParedes(d2, sprites);
        desenharParedeDeCimaDecoracao(d2, sprites);
        desenharLuzes(d2, sprites);
        desenharMobiliarioDireito(d2, sprites);
        desenharEstantesDoMeio(d2, sprites);

        if (sprites.imgArvoreDecoracao != null)
            d2.drawImage(sprites.imgArvoreDecoracao, 340, 310, 40, 80, null);
        if (sprites.imgArvoreDecoracao1 != null)
            d2.drawImage(sprites.imgArvoreDecoracao1, 530, 100, 40, 80, null);

    }

    // =========================================================================
    // PAREDES
    // =========================================================================
    private void desenharParedes(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgParede != null) {
            d2.drawImage(sprites.imgParede,   0, 0, 288, 96, null);
            d2.drawImage(sprites.imgParede, 286, 0, 288, 96, null);
            d2.drawImage(sprites.imgParede, 565, 0, 288, 96, null);
        }
        if (sprites.imgEstanteLateral != null) {
            d2.drawImage(sprites.imgEstanteLateral, 730,  50, 48, 100, null);
            d2.drawImage(sprites.imgEstanteLateral, 730, 100, 48, 100, null);
            d2.drawImage(sprites.imgEstanteLateral, 730, 150, 48, 100, null);
        }
    }

    // =========================================================================
    // DECORAÇÃO DA PAREDE DE CIMA — quadros + troféu
    // =========================================================================
    private void desenharParedeDeCimaDecoracao(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgQuadro      != null) d2.drawImage(sprites.imgQuadro,      290, -20, 200, 140, null); // central
        if (sprites.imgQuadro1C4   != null) d2.drawImage(sprites.imgQuadro1C4,   500,  20,  56,  70, null); // lateral direita
        if (sprites.imgQuadro2C4   != null) d2.drawImage(sprites.imgQuadro2C4,   220,  20,  56,  70, null); // meio
        if (sprites.imgQuadro3C4   != null) d2.drawImage(sprites.imgQuadro3C4,   130,  20,  56,  70, null); // lateral esquerda
        if (sprites.imgTrofeuDeCervo != null) d2.drawImage(sprites.imgTrofeuDeCervo, 20, 20,  80,  60, null); // canto esquerdo
    }

    // =========================================================================
    // LUZES — lustre direito (fixo) + lustre esquerdo (Y-sorting em desenharFrente)
    // =========================================================================
    private void desenharLuzes(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgLustre1 != null) {
            d2.drawImage(sprites.imgLustre1, 730, 180, 40, 80, null); // lustre direito — fixo
            d2.drawImage(sprites.imgLustre1, 110, 110, 40, 80, null); // lustre esquerdo — redesenhado em desenharFrente
        }
    }

    // =========================================================================
    // MOBILIÁRIO DO LADO DIREITO — mesa lateral, estantes cheias, mesas
    // redondas com cadeiras, chave
    // =========================================================================
    private void desenharMobiliarioDireito(Graphics2D d2, GerenciadorSprites sprites) {
        // MESA LATERAL
        if (sprites.imgMesaLateral != null)
            d2.drawImage(sprites.imgMesaLateral, 735, 250, 35, 60, null);

        // ESTANTES LATERAIS DIREITAS
        d2.drawImage(sprites.imgEstanteLateral, 730, 290, 48, 100, null);
        d2.drawImage(sprites.imgEstanteLateral, 730, 340, 48, 100, null);
        d2.drawImage(sprites.imgEstanteLateral, 730, 410, 48, 100, null);

        if (sprites.imgEstanteCheia != null) {
            // ESTANTES DE CIMA (cheias)
            d2.drawImage(sprites.imgEstanteCheia, 650, 40, 96, 90, null);
            d2.drawImage(sprites.imgEstanteCheia, 570, 40, 96, 90, null);

            // MESA E CADEIRAS — TOPO DIREITA
            if (sprites.imgCadeiraL    != null) d2.drawImage(sprites.imgCadeiraL,    580, 170, 20, 50, null);
            if (sprites.imgCadeiraD    != null) d2.drawImage(sprites.imgCadeiraD,    620, 230, 30, 30, null);
            if (sprites.imgCadeiraT    != null) d2.drawImage(sprites.imgCadeiraT,    620, 130, 25, 50, null);
            if (sprites.imgCadeiraR    != null) d2.drawImage(sprites.imgCadeiraR,    670, 170, 25, 50, null);
            if (sprites.imgMesaRedonda != null) d2.drawImage(sprites.imgMesaRedonda, 600, 160, 70, 70, null);
            if (sprites.imgLivro       != null) {
                d2.drawImage(sprites.imgLivro, 615, 162, 15, 18, null);
                d2.drawImage(sprites.imgLivro, 622, 200, 15, 18, null);
            }
            if (sprites.imgLustre2 != null) d2.drawImage(sprites.imgLustre2, 624, 168, 22, 30, null); // vela

            // MESA E CADEIRAS — DIREITA INFERIOR
            if (sprites.imgCadeiraL    != null) d2.drawImage(sprites.imgCadeiraL,    580, 360, 20, 50, null);
            if (sprites.imgCadeiraD    != null) d2.drawImage(sprites.imgCadeiraD,    620, 420, 30, 30, null);
            if (sprites.imgCadeiraT    != null) d2.drawImage(sprites.imgCadeiraT,    620, 320, 25, 50, null);
            if (sprites.imgCadeiraR    != null) d2.drawImage(sprites.imgCadeiraR,    670, 360, 25, 50, null);
            if (sprites.imgMesaRedonda != null) d2.drawImage(sprites.imgMesaRedonda, 600, 350, 70, 70, null);
            if (sprites.imgLivro       != null) {
                d2.drawImage(sprites.imgLivro, 620, 352, 15, 18, null);
                d2.drawImage(sprites.imgLivro, 650, 365, 15, 18, null);
            }
            if (sprites.imgLustre2 != null) d2.drawImage(sprites.imgLustre2, 624, 358, 22, 30, null); // vela

            // CHAVE (se não coletada)
            if (sprites.imgChaveItem != null && (cenario4ref == null || !cenario4ref.isChaveColetada()))
                d2.drawImage(sprites.imgChaveItem, 735, 270, 35, 20, null);
        }
    }

    // =========================================================================
    // ESTANTES DO MEIO — desenhadas SEMPRE no fundo (Y-sorting feito em
    // desenharFrente, que as redesenha por cima do jogador quando ele
    // estiver atrás delas)
    // =========================================================================
    private void desenharEstantesDoMeio(Graphics2D d2, GerenciadorSprites sprites) {
        // ESTANTES DE CIMA
        d2.drawImage(sprites.imgEstante, 240, 100, 96, 90, null);
        d2.drawImage(sprites.imgEstante, 150, 100, 96, 90, null);
        d2.drawImage(sprites.imgEstante, 430, 100, 96, 90, null);

        // ESTANTES DE BAIXO
        d2.drawImage(sprites.imgEstante, 240, 300, 96, 90, null);
        d2.drawImage(sprites.imgEstante, 150, 300, 96, 90, null);
        d2.drawImage(sprites.imgEstante, 430, 300, 96, 90, null);
    }

    // =========================================================================
    // TEIAS DE ARANHA — sempre por cima, após escurecimento
    // =========================================================================
    private void desenharTeiasEstantes(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgTeia1 == null) return;

        // Estantes do meio — cima
        d2.drawImage(sprites.imgTeia1, 170, 100, 60, 60, null);
        d2.drawImage(sprites.imgTeia2, 380, 220, 40, 40, null);
        d2.drawImage(sprites.imgTeia3, 470, 100, 50, 50, null);

        // Estantes do meio — baixo
        d2.drawImage(sprites.imgTeia2, 162, 300, 40, 40, null);
        d2.drawImage(sprites.imgTeia5, 240, 330, 90, 40, null);
        d2.drawImage(sprites.imgTeia4, 450, 308, 50, 40, null);

        // Estantes laterais direitas
        d2.drawImage(sprites.imgTeia3, 700, 285, 36, 36, null);
        d2.drawImage(sprites.imgTeia1, 700, 460, 36, 36, null);

        // Cantos da sala
        d2.drawImage(sprites.imgTeia2,  -20, -20, 80, 80, null);
        d2.drawImage(sprites.imgTeia3,  240,  10, 80, 40, null);
        d2.drawImage(sprites.imgTeia4,  690,   0, 50, 50, null);
    }

    // =========================================================================
    // FRENTE — elementos desenhados por cima do jogador + Y-sorting
    // =========================================================================
    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {
        // BALCÃO — sempre na frente
        if (sprites.imgBalcao != null)
            d2.drawImage(sprites.imgBalcao, 45, 345, 130, 90, null);

        // MESA REDONDA E GLOBO — sempre na frente
        if (sprites.imgMesaRedonda != null)
            d2.drawImage(sprites.imgMesaRedonda, 350, 220, 70, 70, null);
        if (sprites.imgGlobo != null) {
            d2.drawImage(sprites.imgGlobo, 365, 210, 20, 30, null);
            d2.drawImage(sprites.imgGlobo, 360, 205, 40, 50, null);
        }
        if (sprites.imgLivro != null)
            d2.drawImage(sprites.imgLivro, 370, 255, 15, 18, null);

        // Y-SORTING — árvores
        if (sprites.imgArvoreDecoracao  != null && peJogador < PE_ARVORE_DIR)
            d2.drawImage(sprites.imgArvoreDecoracao,  340, 310, 40, 80, null);
        if (sprites.imgArvoreDecoracao1 != null && peJogador < PE_ARVORE1)
            d2.drawImage(sprites.imgArvoreDecoracao1, 530, 100, 40, 80, null);

        // Y-SORTING — estantes de cima
        if (peJogador < PE_ESTANTE_CIMA) {
            d2.drawImage(sprites.imgEstante, 240, 100, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 150, 100, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 430, 100, 96, 90, null);
        }

        // Y-SORTING — estantes de baixo
        if (peJogador < PE_ESTANTE_BAIXO) {
            d2.drawImage(sprites.imgEstante, 240, 300, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 150, 300, 96, 90, null);
            d2.drawImage(sprites.imgEstante, 430, 300, 96, 90, null);
        }

        // Y-SORTING — lustre esquerdo
        if (sprites.imgLustre1 != null && peJogador < PE_LUSTRE_ESQ)
            d2.drawImage(sprites.imgLustre1, 110, 110, 40, 80, null);

        // TEIAS DE ARANHA — sempre por cima (sem Y-sorting)
        desenharTeiasEstantes(d2, sprites);

    }
}