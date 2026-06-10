package jogoBiblioteca.cenarios.desenho;

import java.awt.*;
import java.awt.geom.*;
import jogoBiblioteca.GerenciadorSprites;
import jogoBiblioteca.cenarios.Cenario5;

public class DesenhistaCenario5 implements DesenhistaCenario {

    // ── Paleta ───────────────────────────────────────────────────────────────
    private static final Color COR_PAREDE      = new Color(55, 45, 35);
    private static final Color COR_PAREDE_BDA  = new Color(80, 65, 48);
    private static final Color COR_CHAO        = new Color(70, 60, 50);
    private static final Color COR_CHAO_PEDRA  = new Color(85, 72, 58);

    private static final Color COR_SOL_ARC     = new Color(255, 200, 50);
    private static final Color COR_SOL_GLOW    = new Color(255, 200, 50, 60);

    private static final Color COR_LUA_ARC     = new Color(100, 140, 210);
    private static final Color COR_LUA_GLOW    = new Color(100, 140, 210, 50);

    private static final Color COR_ESTRELA_ARC = new Color(200, 200, 230);
    private static final Color COR_ESTRELA_GLW = new Color(200, 200, 230, 50);

    private static final Color COR_PLACA_FUNDO = new Color(40, 30, 20);
    private static final Color COR_PLACA_BORDA = new Color(160, 120, 50);
    private static final Color COR_PLACA_TEXTO = new Color(220, 190, 110);
    private static final Color COR_ROTULO      = new Color(230, 220, 200);

    // ── Geometria ─────────────────────────────────────────────────────────────
    private static final int TILE  = 48;
    private static final int W     = 768;
    private static final int H     = 480;

    private static final int CX_LUA     =  2 * TILE + TILE / 2;
    private static final int CX_SOL     =  7 * TILE + TILE / 2;
    private static final int CX_ESTRELA = 12 * TILE + TILE / 2;

    private static final int Y_PORTA_BASE = H - TILE;

    // Pé visual das estantes inferiores: y=312 + h=90 = 402
    private static final int PE_ESTANTE_INF = 402;

    @Override
    public void desenharFundo(Graphics2D g2, GerenciadorSprites sprites) {
        configurarAntialiasing(g2);

        desenharChaoDecorado(g2);
        desenharParedeSul(g2);
        desenharEstantes(g2, sprites);

        desenharEstatua(g2, sprites);

        desenharArco(g2, CX_LUA,     COR_LUA_ARC,     COR_LUA_GLOW,     "🌙 Lua");
        desenharArco(g2, CX_SOL,     COR_SOL_ARC,     COR_SOL_GLOW,     "☀ Sol");
        desenharArco(g2, CX_ESTRELA, COR_ESTRELA_ARC, COR_ESTRELA_GLW,  "⭐ Estrela");

        desenharPlacaCharada(g2);
    }

    @Override
    public void desenharFrente(Graphics2D g2, GerenciadorSprites sprites, int peJogador) {
        // Estátua — cobre o jogador quando ele está acima da linha de profundidade
        if (peJogador < Cenario5.ESTATUA_LINHA_Y) {
            desenharEstatua(g2, sprites);
        }

        // Estantes inferiores — cobrem o jogador quando ele está acima delas
        if (sprites.imgEstante != null && peJogador < PE_ESTANTE_INF) {
            g2.drawImage(sprites.imgEstante, 190, 312, 96, 90, null); // esquerda
            g2.drawImage(sprites.imgEstante, 430, 312, 96, 90, null); // direita
        }
    }

    private void desenharEstantes(Graphics2D g2, GerenciadorSprites sprites) {
        // ---------------- CHEIAS — parede norte ----------------
        if (sprites.imgEstanteCheia != null) {
            g2.drawImage(sprites.imgEstanteCheia,  48, 4, 96, 90, null);
            g2.drawImage(sprites.imgEstanteCheia, 192, 4, 96, 90, null);
            g2.drawImage(sprites.imgEstanteCheia, 432, 4, 96, 90, null);
            g2.drawImage(sprites.imgEstanteCheia, 624, 4, 96, 90, null);
        }

        // ---------------- NORMAIS — inferiores (sempre no fundo) ----------------
        // CORREÇÃO: ambas desenhadas aqui no fundo para não sumirem.
        // O desenharFrente as redesenha na frente quando o jogador está acima delas.
        if (sprites.imgEstante != null) {
            g2.drawImage(sprites.imgEstante, 190, 312, 96, 90, null); // esquerda
            g2.drawImage(sprites.imgEstante, 430, 312, 96, 90, null); // direita
        }
    }

    private void desenharEstatua(Graphics2D g2, GerenciadorSprites sprites) {
        if (sprites.imgEstatua == null) return;
        g2.drawImage(
                sprites.imgEstatua,
                Cenario5.ESTATUA_X,
                Cenario5.ESTATUA_Y,
                Cenario5.ESTATUA_W,
                Cenario5.ESTATUA_H,
                null
        );
    }

    // ── PAREDE SUL ───────────────────────────────────────────────────────────
    private void desenharParedeSul(Graphics2D g2) {
        g2.setColor(COR_PAREDE);
        g2.fillRect(0, H - TILE, W, TILE);

        g2.setColor(COR_PAREDE_BDA);
        g2.setStroke(new BasicStroke(1f));

        for (int x = 0; x < W; x += TILE) {
            g2.drawLine(x, H - TILE, x, H);
        }
        g2.drawLine(0, H - TILE / 2, W, H - TILE / 2);

        int[] centros = {CX_LUA, CX_SOL, CX_ESTRELA};
        for (int cx : centros) {
            g2.setColor(new Color(20, 15, 10));
            g2.fillRect(cx - 20, H - TILE, 40, TILE + 10);
        }
    }

    // ── CHÃO ────────────────────────────────────────────────────────────────
    private void desenharChaoDecorado(Graphics2D g2) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 16; col++) {
                int tile = Cenario5.MAPA[row][col];
                if (tile != 4 && tile != 24) continue;

                int x = col * TILE;
                int y = row * TILE;

                Color base = ((row + col) % 2 == 0) ? COR_CHAO : COR_CHAO_PEDRA;
                g2.setColor(base);
                g2.fillRect(x, y, TILE, TILE);

                g2.setColor(new Color(0, 0, 0, 40));
                g2.drawRect(x, y, TILE, TILE);
            }
        }
    }

    // ── ARCO ────────────────────────────────────────────────────────────────
    private void desenharArco(Graphics2D g2, int cx, Color cor, Color glow, String rotulo) {
        int arcW = 44;
        int arcH = 56;
        int arcX = cx - arcW / 2;
        int arcY = Y_PORTA_BASE - arcH / 2;

        g2.setColor(cor);
        g2.setStroke(new BasicStroke(3f));
        g2.drawArc(arcX, arcY, arcW, arcH, 180, 180);

        g2.setColor(cor.darker());
        g2.setStroke(new BasicStroke(4f));
        g2.drawLine(arcX,        arcY + arcH / 2, arcX,        Y_PORTA_BASE);
        g2.drawLine(arcX + arcW, arcY + arcH / 2, arcX + arcW, Y_PORTA_BASE);

        g2.setFont(new Font("SansSerif", Font.BOLD, 13));
        FontMetrics fm = g2.getFontMetrics();
        g2.setColor(COR_ROTULO);
        g2.drawString(rotulo, cx - fm.stringWidth(rotulo) / 2, Y_PORTA_BASE - 10);

        g2.setStroke(new BasicStroke(1f));
    }

    // ── PLACA ───────────────────────────────────────────────────────────────
    private void desenharPlacaCharada(Graphics2D g2) {
        int px = W - 210;
        int py = H / 2 - 60;
        int pw = 190;
        int ph = 120;
        int arc = 8;

        g2.setColor(new Color(0, 0, 0, 80));
        g2.fillRoundRect(px + 3, py + 3, pw, ph, arc, arc);

        g2.setColor(COR_PLACA_FUNDO);
        g2.fillRoundRect(px, py, pw, ph, arc, arc);

        g2.setColor(COR_PLACA_BORDA);
        g2.setStroke(new BasicStroke(2f));
        g2.drawRoundRect(px, py, pw, ph, arc, arc);

        g2.setFont(new Font("SansSerif", Font.BOLD, 11));
        g2.setColor(COR_PLACA_BORDA);
        String titulo = "─ LEIA A CHARADA ─";
        FontMetrics fmT = g2.getFontMetrics();
        g2.drawString(titulo, px + (pw - fmT.stringWidth(titulo)) / 2, py + 18);

        g2.setColor(COR_PLACA_TEXTO);
        g2.setFont(new Font("SansSerif", Font.ITALIC, 12));
        String[] linhas = {
                "A sabedoria não",
                "está na força,",
                "mas na observação.",
                "",
                "Brilho durante o dia,",
                "desapareço à noite."
        };
        int y = py + 40;
        for (String s : linhas) {
            g2.drawString(s, px + 20, y);
            y += 14;
        }
    }

    private void configurarAntialiasing(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
}