package jogoBiblioteca;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Painel principal do jogo.
 * Suporta posição "Centro" (área de jogo) e "Sul" (barra de inventário).
 *
 * O inventário é compartilhado entre os dois painéis via referência estática,
 * garantindo que apareça igual em qualquer cenário.
 */
public class Painel extends JPanel {

    private String posicao;

    // ── Inventário compartilhado (estático → mesmo objeto em todos os cenários) ──
    public static Inventario inventario = new Inventario();

    // ── Objetos do painel Centro ──
    public Player jogador = new Player();
    private GameLoop loopDoJogo;
    private EscutadorTeclado escutTeclado;
    private SpriteLoop SpriteLoop;
    tileMap cenario;

    // Referência ao painel Sul para forçar repaint quando o inventário muda
    private static Painel painelSul;

    public Painel(String posicao) {
        this.posicao = posicao;

        if (posicao.equals("Centro")) {
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(768, 480));

            jogador = new Player();

            escutTeclado = new EscutadorTeclado(inventario, this);
            this.addKeyListener(escutTeclado);

            this.cenario = new tileMap();

            loopDoJogo = new GameLoop(this, escutTeclado);
            loopDoJogo.start();

            SpriteLoop = new SpriteLoop(this, escutTeclado);
            SpriteLoop.start();

            this.cenario = new tileMap();

            this.setFocusable(true);
            this.requestFocusInWindow();

        } else if (posicao.equals("Sul")) {
            setBackground(new Color(30, 20, 10)); // fundo escuro RPG
            setPreferredSize(new Dimension(768, 100));
            painelSul = this; // guarda referência global
        }
    }

    /** Força o painel Sul a redesenhar (chamado ao mudar inventário). */
    public static void atualizarPainelSul() {
        if (painelSul != null) painelSul.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        switch (posicao) {
            case "Centro":
                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());

                // 1. Fundo, chão, baú e casa básica
                this.cenario.desenharChaoECasas(g2);

                // 2. Y-Sorting das árvores superiores
                if (jogador.AreaColisao.y < 110) {
                    jogador.DesenharPlayer(g2);
                    this.cenario.desenharArvoresDoTopo(g2);
                } else {
                    this.cenario.desenharArvoresDoTopo(g2);
                    jogador.DesenharPlayer(g2);
                }

                // 3. Árvores de baixo sempre por cima
                this.cenario.desenharArvoresDeBaixo(g2);
                break;

            case "Sul":
                // Delega todo o desenho para a classe Inventario
                inventario.desenhar(g2, getWidth());
                break;
        }
    }
}
