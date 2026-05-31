package jogoBiblioteca;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Sistema de Inventário do jogador.
 * Gerencia os itens coletados e desenha o painel Sul com slots de inventário.
 */
public class Inventario {

    // --- Estrutura de um item ---
    public static class Item {
        public String nome;
        public Color cor;        // cor representando o item (caso não haja imagem)
        public String emoji;     // símbolo/emoji exibido no slot (opcional)

        public Item(String nome, Color cor, String emoji) {
            this.nome = nome;
            this.cor  = cor;
            this.emoji = emoji;
        }
    }

    // --- Configurações visuais ---
    private static final int MAX_SLOTS    = 5;    // quantidade de slots visíveis
    private static final int SLOT_SIZE    = 50;   // tamanho (px) de cada slot
    private static final int SLOT_PADDING = 10;   // espaço entre slots
    private static final int PAINEL_H     = 100;  // altura do painel Sul

    // Paleta RPG retrô
    private static final Color COR_FUNDO_PAINEL  = new Color(30, 20, 10);
    private static final Color COR_BORDA_PAINEL  = new Color(180, 130, 50);
    private static final Color COR_SLOT_VAZIO    = new Color(50, 35, 15);
    private static final Color COR_SLOT_BORDA    = new Color(100, 75, 30);
    private static final Color COR_SLOT_CHEIO    = new Color(60, 45, 20);
    private static final Color COR_SLOT_SEL_BG   = new Color(200, 160, 60, 80);
    private static final Color COR_TEXTO         = new Color(230, 200, 120);
    private static final Color COR_TEXTO_TITULO  = new Color(255, 220, 100);

    // --- Estado ---
    private List<Item> itens = new ArrayList<>();
    private int slotSelecionado = 0;   // índice do slot destacado (0-7)

    // --- Construtores de itens de exemplo para testes ---
    public Inventario() {
        // Começa com inventário vazio – adicione itens via adicionarItem()
    }

    /** Adiciona um item ao inventário (até MAX_SLOTS). */
    public boolean adicionarItem(Item item) {
        if (itens.size() >= MAX_SLOTS) return false;
        itens.add(item);
        return true;
    }

    /** Remove o item no índice informado (se existir). */
    public boolean removerItem(int indice) {
        if (indice < 0 || indice >= itens.size()) return false;
        itens.remove(indice);
        return true;
    }

    /** Retorna o item no slot selecionado, ou null se vazio. */
    public Item getItemSelecionado() {
        if (slotSelecionado < itens.size()) return itens.get(slotSelecionado);
        return null;
    }

    /** Move a seleção para a esquerda (tecla Q). */
    public void selecionarAnterior() {
        slotSelecionado = (slotSelecionado - 1 + MAX_SLOTS) % MAX_SLOTS;
    }

    /** Move a seleção para a direita (tecla E). */
    public void selecionarProximo() {
        slotSelecionado = (slotSelecionado + 1) % MAX_SLOTS;
    }

    public int getSlotSelecionado() { return slotSelecionado; }
    public List<Item> getItens()    { return itens; }

    // -------------------------------------------------------
    // Desenho — chamado pelo paintComponent do Painel Sul
    // -------------------------------------------------------

    /**
     * Desenha o inventário completo dentro do painel Sul.
     * @param g2    contexto gráfico já configurado
     * @param larguraPainel largura total do painel (normalmente 768)
     */
    public void desenhar(Graphics2D g2, int larguraPainel) {
        // Fundo geral do painel
        g2.setColor(COR_FUNDO_PAINEL);
        g2.fillRect(0, 0, larguraPainel, PAINEL_H);

        // Borda superior dourada
        g2.setColor(COR_BORDA_PAINEL);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(0, 0, larguraPainel, 0);
        g2.drawLine(0, PAINEL_H - 1, larguraPainel, PAINEL_H - 1);

        // Título "INVENTÁRIO"
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(COR_TEXTO_TITULO);
        g2.setFont(new Font("Serif", Font.BOLD, 13));
        g2.drawString("INVENTÁRIO", 10, 18);

        // Dica de uso
        g2.setColor(COR_TEXTO.darker());
        g2.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g2.drawString("[Q] ◄  [E] ►  [F] usar", 20, 30);

        // Calcular posição inicial dos slots (centralizados)
        int totalLarg = MAX_SLOTS * SLOT_SIZE + (MAX_SLOTS - 1) * SLOT_PADDING;
        int startX    = (larguraPainel - totalLarg) / 2;
        int startY    = (PAINEL_H - SLOT_SIZE) / 2 + 8; // ligeiramente mais baixo

        // Desenhar cada slot
        for (int i = 0; i < MAX_SLOTS; i++) {
            int x = startX + i * (SLOT_SIZE + SLOT_PADDING);
            int y = startY;

            boolean selecionado = (i == slotSelecionado);
            Item item = (i < itens.size()) ? itens.get(i) : null;

            desenharSlot(g2, x, y, SLOT_SIZE, item, selecionado, i + 1);
        }

        // Nome do item selecionado
        Item sel = getItemSelecionado();
        if (sel != null) {
            g2.setColor(COR_TEXTO);
            g2.setFont(new Font("Serif", Font.ITALIC, 12));
            String label = "► " + sel.nome;
            FontMetrics fm = g2.getFontMetrics();
            int tx = larguraPainel - fm.stringWidth(label) - 12;
            g2.drawString(label, tx, 20);
        }
    }

    /** Desenha um único slot. */
    private void desenharSlot(Graphics2D g2, int x, int y, int size,
                              Item item, boolean selecionado, int numero) {

        // Sombra
        g2.setColor(new Color(0, 0, 0, 120));
        g2.fillRoundRect(x + 3, y + 3, size, size, 8, 8);

        // Fundo do slot
        g2.setColor(item != null ? COR_SLOT_CHEIO : COR_SLOT_VAZIO);
        g2.fillRoundRect(x, y, size, size, 8, 8);

        // Destaque de seleção
        if (selecionado) {
            g2.setColor(COR_SLOT_SEL_BG);
            g2.fillRoundRect(x, y, size, size, 8, 8);
        }

        // Borda
        g2.setStroke(new BasicStroke(selecionado ? 2.5f : 1.5f));
        g2.setColor(selecionado ? COR_BORDA_PAINEL : COR_SLOT_BORDA);
        g2.drawRoundRect(x, y, size, size, 8, 8);

        // Conteúdo do slot
        if (item != null) {
            // Círculo colorido representando o item
            g2.setColor(item.cor);
            int margin = 10;
            g2.fillOval(x + margin, y + margin, size - margin * 2, size - margin * 2);

            // Borda do ícone
            g2.setColor(item.cor.darker());
            g2.setStroke(new BasicStroke(1f));
            g2.drawOval(x + margin, y + margin, size - margin * 2, size - margin * 2);

            // Emoji / símbolo
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Serif", Font.BOLD, 18));
            FontMetrics fm = g2.getFontMetrics();
            int tw = fm.stringWidth(item.emoji);
            g2.drawString(item.emoji, x + (size - tw) / 2, y + size / 2 + 6);
        } else {
            // Slot vazio: número do slot bem discreto
            g2.setColor(COR_SLOT_BORDA.darker());
            g2.setFont(new Font("Monospaced", Font.PLAIN, 10));
            g2.drawString(String.valueOf(numero), x + size - 13, y + size - 5);
        }

        // Indicador de seleção (triângulo abaixo do slot)
        if (selecionado) {
            int[] px = { x + size / 2 - 5, x + size / 2 + 5, x + size / 2 };
            int[] py = { y + size + 4,      y + size + 4,      y + size + 10 };
            g2.setColor(COR_BORDA_PAINEL);
            g2.fillPolygon(px, py, 3);
        }
    }
}
