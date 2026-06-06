package jogoBiblioteca;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Overlay de confirmação exibido ao acertar a charada do Cenário 5.
 */
public class OverlayMensagemSucesso {

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

    private Rectangle botaoOk;
    private boolean hoverOk = false;

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

        int pw = 400;
        int ph = 200;
        int px = (W - pw) / 2;
        int py = (H - ph) / 2;
        int arc = 12;

        // Sombra do painel
        g2.setColor(new Color(0, 0, 0, 100));
        g2.fillRoundRect(px + 4, py + 4, pw, ph, arc, arc);

        // Fundo com gradiente
        GradientPaint gp = new GradientPaint(
                px, py,
                PANEL_FILL,
                px, py + ph,
                new Color(14, 10, 6));

        g2.setPaint(gp);
        g2.fillRoundRect(px, py, pw, ph, arc, arc);

        // Borda
        g2.setColor(PANEL_BORDER);
        g2.setStroke(new BasicStroke(2f));
        g2.drawRoundRect(px, py, pw, ph, arc, arc);

        g2.setStroke(new BasicStroke(1f));

        // Título
        g2.setFont(new Font("SansSerif", Font.BOLD, 15));
        g2.setColor(TITLE_COLOR);

        String titulo = "☀ Porta Liberada!";
        FontMetrics fmT = g2.getFontMetrics();

        g2.drawString(
                titulo,
                px + (pw - fmT.stringWidth(titulo)) / 2,
                py + 36);

        // Linha decorativa
        g2.setColor(PANEL_BORDER);
        g2.drawLine(px + 20, py + 46, px + pw - 20, py + 46);

        // Texto
        g2.setFont(new Font("SansSerif", Font.PLAIN, 13));
        g2.setColor(TEXT_COLOR);

        String[] linhas = {
                "A porta do Sol foi liberada!",
                "Agora você poderá passar por ela."
        };

        int lY = py + 82;

        for (String linha : linhas) {
            FontMetrics fmL = g2.getFontMetrics();

            g2.drawString(
                    linha,
                    px + (pw - fmL.stringWidth(linha)) / 2,
                    lY);

            lY += 22;
        }

        // Botão
        int btnW = 120;
        int btnH = 34;

        int btnX = px + (pw - btnW) / 2;
        int btnY = py + ph - 52;

        botaoOk = new Rectangle(btnX, btnY, btnW, btnH);

        desenharBotao(
                g2,
                botaoOk,
                "Continuar",
                hoverOk);
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
                r.x, r.y,
                r.width, r.height,
                arc, arc));

        g2.setColor(hover ? TITLE_COLOR : BTN_BORDER);
        g2.setStroke(new BasicStroke(hover ? 2f : 1f));

        g2.draw(new RoundRectangle2D.Float(
                r.x, r.y,
                r.width, r.height,
                arc, arc));

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
        hoverOk = botaoOk != null && botaoOk.contains(x, y);
    }

    public boolean processarClique(int x, int y) {
        return botaoOk != null && botaoOk.contains(x, y);
    }
}