package jogoBiblioteca;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class OverlayCharada {

    private static final int W = 768;
    private static final int H = 480;

    private static final Color BG_OVERLAY   = new Color(0, 0, 0, 160);
    private static final Color PANEL_FILL   = new Color(22, 16, 10);
    private static final Color PANEL_BORDER = new Color(160, 120, 50);

    private static final Color TITLE_COLOR  = new Color(230, 180, 60);
    private static final Color TEXT_COLOR   = new Color(220, 190, 110);

    private static final Color BTN_FILL     = new Color(38, 28, 16);
    private static final Color BTN_BORDER   = new Color(80, 58, 30);
    private static final Color BTN_HOVER    = new Color(55, 42, 15);

    private static final String[] ROTULOS = {
            "☀ Sol",
            "🌙 Lua",
            "⭐ Estrela"
    };

    private final Rectangle[] botoes = new Rectangle[3];
    private int hoverIndex = -1;

    public void desenhar(Graphics2D g2) {

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Overlay escuro
        g2.setColor(BG_OVERLAY);
        g2.fillRect(0, 0, W, H);

        int pw = 420;
        int ph = 280;
        int px = (W - pw) / 2;
        int py = (H - ph) / 2;
        int arc = 12;

        // Sombra
        g2.setColor(new Color(0, 0, 0, 100));
        g2.fillRoundRect(px + 4, py + 4, pw, ph, arc, arc);

        // Fundo do painel
        GradientPaint gp = new GradientPaint(
                px,
                py,
                PANEL_FILL,
                px,
                py + ph,
                new Color(14, 10, 6));

        g2.setPaint(gp);
        g2.fillRoundRect(px, py, pw, ph, arc, arc);

        // Borda
        g2.setColor(PANEL_BORDER);
        g2.setStroke(new BasicStroke(2f));
        g2.drawRoundRect(px, py, pw, ph, arc, arc);
        g2.setStroke(new BasicStroke(1f));

        // Título
        g2.setFont(new Font("SansSerif", Font.BOLD, 14));
        g2.setColor(TITLE_COLOR);

        String titulo = "─ Leia a Charada ─";

        FontMetrics fmT = g2.getFontMetrics();

        g2.drawString(
                titulo,
                px + (pw - fmT.stringWidth(titulo)) / 2,
                py + 28);

        // Linha decorativa
        g2.setColor(PANEL_BORDER);
        g2.drawLine(px + 20, py + 36, px + pw - 20, py + 36);

        // Texto da charada
        g2.setFont(new Font("SansSerif", Font.ITALIC, 13));
        g2.setColor(TEXT_COLOR);

        String[] linhas = {
                "\"A sabedoria não está na força,",
                "mas na observação.",
                "",
                "Brilho durante o dia,",
                "desapareço à noite.\"",
                "",
                "Qual porta você deve cruzar?"
        };

        int lY = py + 58;

        for (String linha : linhas) {

            FontMetrics fmL = g2.getFontMetrics();

            g2.drawString(
                    linha,
                    px + (pw - fmL.stringWidth(linha)) / 2,
                    lY);

            lY += 18;
        }

        // Dica de fechamento
        g2.setFont(new Font("SansSerif", Font.PLAIN, 11));
        g2.setColor(new Color(180, 150, 90));

        String dica = "[ESC] Fechar";

        FontMetrics fmD = g2.getFontMetrics();

        g2.drawString(
                dica,
                px + (pw - fmD.stringWidth(dica)) / 2,
                py + ph - 75);

        // Botões
        int btnW = 110;
        int btnH = 36;
        int gap = 16;

        int totalBtnW = 3 * btnW + 2 * gap;
        int btnY = py + ph - 56;
        int btnStartX = px + (pw - totalBtnW) / 2;

        for (int i = 0; i < 3; i++) {

            int bx = btnStartX + i * (btnW + gap);

            botoes[i] = new Rectangle(
                    bx,
                    btnY,
                    btnW,
                    btnH);

            desenharBotao(
                    g2,
                    botoes[i],
                    ROTULOS[i],
                    i == hoverIndex);
        }
    }

    private void desenharBotao(
            Graphics2D g2,
            Rectangle r,
            String rotulo,
            boolean hover) {

        int arc = 8;

        Color fill = hover ? BTN_HOVER : BTN_FILL;

        g2.setColor(fill);

        g2.fill(new RoundRectangle2D.Float(
                r.x,
                r.y,
                r.width,
                r.height,
                arc,
                arc));

        g2.setColor(hover ? TITLE_COLOR : BTN_BORDER);

        g2.setStroke(new BasicStroke(
                hover ? 2f : 1f));

        g2.draw(new RoundRectangle2D.Float(
                r.x,
                r.y,
                r.width,
                r.height,
                arc,
                arc));

        g2.setStroke(new BasicStroke(1f));

        g2.setFont(new Font("SansSerif", Font.BOLD, 13));
        g2.setColor(hover ? Color.WHITE : TEXT_COLOR);

        FontMetrics fm = g2.getFontMetrics();

        g2.drawString(
                rotulo,
                r.x + (r.width - fm.stringWidth(rotulo)) / 2,
                r.y + (r.height + fm.getAscent() - fm.getDescent()) / 2);
    }

    public void atualizarHover(int x, int y) {

        hoverIndex = -1;

        for (int i = 0; i < botoes.length; i++) {

            if (botoes[i] != null &&
                    botoes[i].contains(x, y)) {

                hoverIndex = i;
                return;
            }
        }
    }

    /**
     * Retorna:
     * 0 = Sol
     * 1 = Lua
     * 2 = Estrela
     * -1 = Nenhum botão clicado
     */
    public int processarClique(int x, int y) {

        for (int i = 0; i < botoes.length; i++) {

            if (botoes[i] != null &&
                    botoes[i].contains(x, y)) {

                return i;
            }
        }

        return -1;
    }
}