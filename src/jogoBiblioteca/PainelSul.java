package jogoBiblioteca;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class PainelSul extends JPanel {

    private static final int LARGURA   = 768;
    private static final int ALTURA    = 100;
    private static final int CELL_SIZE = 72;
    private static final int CELL_GAP  = 10;
    private static final int NUM_SLOTS = 5;

    private static final Color BG_DARK     = new Color(14, 10, 6);
    private static final Color SLOT_FILL   = new Color(38, 28, 16);
    private static final Color SLOT_BORDER = new Color(80, 58, 30);
    private static final Color SEL_GLOW    = new Color(230, 180, 60);
    private static final Color SEL_FILL    = new Color(55, 42, 15);
    private static final Color GOLD        = new Color(230, 180, 60);
    private static final Color GOLD_DIM    = new Color(160, 120, 40);
    private static final Color WHITE       = new Color(235, 225, 210);
    private static final Color GRAY_DIM    = new Color(100, 85, 65);
    private static final Color QTY_COLOR   = new Color(255, 210, 80);
    private static final Color DIVIDER     = new Color(50, 38, 20);
    private static final Color HINT_COLOR  = new Color(90, 70, 40);

    private final Inventario inventario;

    public PainelSul(Inventario inventario) {
        this.inventario = inventario;
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        setBackground(BG_DARK);
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,      RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        desenharFundo(g2);
        desenharSlots(g2);
        desenharDicas(g2);
    }

    private void desenharFundo(Graphics2D g2) {
        GradientPaint gp = new GradientPaint(0, 0, new Color(22, 16, 10), 0, ALTURA, BG_DARK);
        g2.setPaint(gp);
        g2.fillRect(0, 0, LARGURA, ALTURA);
        g2.setColor(DIVIDER);
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawLine(0, 0, LARGURA, 0);
        g2.setStroke(new BasicStroke(1f));
    }

    private void desenharSlots(Graphics2D g2) {
        int totalW  = NUM_SLOTS * CELL_SIZE + (NUM_SLOTS - 1) * CELL_GAP;
        int offsetX = (LARGURA - totalW) / 2;
        int offsetY = (ALTURA - CELL_SIZE) / 2;

        for (int i = 0; i < NUM_SLOTS; i++) {
            int x   = offsetX + i * (CELL_SIZE + CELL_GAP);
            int y   = offsetY;
            boolean sel  = (i == inventario.getSlotSelecionado());
            Item    item = inventario.getItem(i);
            desenharSlot(g2, x, y, sel, item, i + 1);
        }
    }

    private void desenharSlot(Graphics2D g2, int x, int y, boolean sel, Item item, int numero) {
        int arc = 10;

        // Glow externo no slot selecionado
        if (sel) {
            for (int d = 4; d >= 1; d--) {
                int alpha = (int)(0.06f * (5 - d) * 255);
                g2.setColor(new Color(SEL_GLOW.getRed(), SEL_GLOW.getGreen(), SEL_GLOW.getBlue(), alpha));
                g2.fill(new RoundRectangle2D.Float(x - d, y - d, CELL_SIZE + d*2, CELL_SIZE + d*2, arc+d, arc+d));
            }
        }

        // Fundo gradiente
        GradientPaint gp = sel
                ? new GradientPaint(x, y, SEL_FILL,  x, y + CELL_SIZE, new Color(28, 20, 8))
                : new GradientPaint(x, y, SLOT_FILL, x, y + CELL_SIZE, new Color(22, 15, 8));
        g2.setPaint(gp);
        g2.fill(new RoundRectangle2D.Float(x, y, CELL_SIZE, CELL_SIZE, arc, arc));

        // Borda
        g2.setStroke(new BasicStroke(sel ? 2f : 1f));
        g2.setColor(sel ? SEL_GLOW : SLOT_BORDER);
        g2.draw(new RoundRectangle2D.Float(x, y, CELL_SIZE, CELL_SIZE, arc, arc));
        g2.setStroke(new BasicStroke(1f));

        // Reflexo no topo
        if (sel) {
            g2.setColor(new Color(255, 240, 160, 60));
            g2.drawLine(x + arc/2, y + 2, x + CELL_SIZE - arc/2, y + 2);
        }

        // Número do slot
        g2.setFont(new Font("Arial", Font.BOLD, 9));
        g2.setColor(sel ? GOLD_DIM : GRAY_DIM);
        g2.drawString(String.valueOf(numero), x + 5, y + 13);

        if (item != null) {
            // Ícone emoji
            String icone = iconePorNome(item.getNome());
            g2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
            FontMetrics fmI = g2.getFontMetrics();
            g2.setColor(sel ? WHITE : new Color(200, 185, 165));
            g2.drawString(icone, x + (CELL_SIZE - fmI.stringWidth(icone)) / 2, y + CELL_SIZE / 2 + 6);

            // Nome abreviado
            String nome = item.getNome().length() > 6 ? item.getNome().substring(0, 5) + "." : item.getNome();
            g2.setFont(new Font("Arial", Font.PLAIN, 9));
            g2.setColor(sel ? GOLD : GRAY_DIM);
            FontMetrics fmN = g2.getFontMetrics();
            g2.drawString(nome, x + (CELL_SIZE - fmN.stringWidth(nome)) / 2, y + CELL_SIZE - 14);

            // Quantidade (canto inf. dir.)
            String qtd = "×" + item.getQuantidade();
            g2.setFont(new Font("Arial", Font.BOLD, 9));
            g2.setColor(QTY_COLOR);
            FontMetrics fmQ = g2.getFontMetrics();
            g2.drawString(qtd, x + CELL_SIZE - fmQ.stringWidth(qtd) - 4, y + CELL_SIZE - 4);
        } else {
            // Slot vazio — pontilhado
            g2.setColor(new Color(50, 38, 20, 100));
            float[] dash = {3f, 4f};
            g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, dash, 0f));
            g2.draw(new RoundRectangle2D.Float(x + 8, y + 8, CELL_SIZE - 16, CELL_SIZE - 16, 6, 6));
            g2.setStroke(new BasicStroke(1f));
        }
    }

    private String iconePorNome(String nome) {
        String n = nome.toLowerCase();
        if (n.contains("livro") || n.contains("tomo"))                           return "📖";

        return "◆";
    }

    private void desenharDicas(Graphics2D g2) {
        g2.setFont(new Font("Arial", Font.PLAIN, 9));
        g2.setColor(HINT_COLOR);
        String dica = "Q ← anterior    E → próximo    F Pegar ";
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(dica, LARGURA - fm.stringWidth(dica) - 10, ALTURA - 5);
    }
}
