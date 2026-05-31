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

    // Inventário compartilhado
    public static Inventario inventario = new Inventario();

    // Objetos do painel Centro
    public Player jogador = new Player();
    private GameLoop loopDoJogo;
    private EscutadorTeclado escutTeclado;
    private SpriteLoop spriteLoop;
    public tileMap cenario;
    private RenderizadorCena renderizador;

    // Referência ao painel Sul para forçar repaint quando o inventário muda
    private static Painel painelSul;

    public Painel(String posicao) {
        this.posicao = posicao;

        if (posicao.equals("Centro")) {

            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(768, 480));

            jogador = new Player();

            // Teclado
            escutTeclado = new EscutadorTeclado(inventario, this);
            addKeyListener(escutTeclado);

            // Cenário
            cenario = new tileMap();

            // Renderizador
            renderizador = new RenderizadorCena();

            // Loops
            loopDoJogo = new GameLoop(this, escutTeclado);
            loopDoJogo.start();

            spriteLoop = new SpriteLoop(this, escutTeclado);
            spriteLoop.start();

            setFocusable(true);
            requestFocusInWindow();

        } else if (posicao.equals("Sul")) {

            setBackground(new Color(30, 20, 10));
            setPreferredSize(new Dimension(768, 100));

            painelSul = this;
        }
    }

    /** Força o painel Sul a redesenhar */
    public static void atualizarPainelSul() {
        if (painelSul != null) {
            painelSul.repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        switch (posicao) {

            case "Centro":

                // Limpa a tela
                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Desenha o mapa e fundo
                cenario.desenharChaoECasas(g2);

                // Desenha o jogador
                jogador.DesenharPlayer(g2);

                // Calcula o pé do jogador para Y-Sorting
                int peJogador =
                        jogador.AreaColisao.y
                                + jogador.AreaColisao.height;

                // Desenha árvores, estátuas e objetos da frente
                cenario.desenharElementosFrente(g2, peJogador);

                // Mostra hitboxes (debug)
                cenario.desenharHitboxes(g2);

                // Renderizador adicional
                if (renderizador != null) {
                    renderizador.renderizar(g2, cenario, jogador);
                }

                break;

            case "Sul":

                inventario.desenhar(g2, getWidth());

                break;
        }
    }
}