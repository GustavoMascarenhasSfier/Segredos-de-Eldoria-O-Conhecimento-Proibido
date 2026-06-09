package jogoBiblioteca;

import jogoBiblioteca.cenarios.Cenario5;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Painel extends JPanel {

    public Player jogador = new Player();
    private GameLoop loopDoJogo;
    private EscutadorTeclado escutTeclado;
    private SpriteLoop SpriteLoop;
    tileMap cenario;
    private RenderizadorCena renderizador;

    public Inventario inventario = new Inventario();
    public PainelSul painelSul;
    public boolean charadaAtiva = false;
    public int respostaCharada = -1;
    public boolean mensagemSucessoAtiva = false;

    private final OverlayCharada overlayCharada = new OverlayCharada();
    private final OverlayMensagemSucesso overlaySucesso = new OverlayMensagemSucesso();

    public Painel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(768, 480));

        jogador = new Player();

        escutTeclado = new EscutadorTeclado();
        escutTeclado.setAcaoEsc(this::tratarEsc);
        this.addKeyListener(escutTeclado);

        this.cenario = new tileMap();
        jogador.teleportar(cenario.spawnX1, cenario.spawnY1);

        this.cenario.setContexto(this, escutTeclado);

        this.renderizador = new RenderizadorCena();

        loopDoJogo = new GameLoop(this, null, escutTeclado);
        loopDoJogo.start();

        SpriteLoop = new SpriteLoop(this, escutTeclado);
        SpriteLoop.start();

        // Timer para sumir a mensagem de feedback após ela expirar
        Timer timerFeedback = new Timer(100, e -> {
            if (cenario.getMensagemFeedback() == null) repaint();
        });
        timerFeedback.start();

        configurarMouse();

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    private void configurarMouse() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (mensagemSucessoAtiva) {
                    if (overlaySucesso.processarClique(e.getX(), e.getY())) {
                        fecharMensagemSucesso();
                    }
                    return;
                }

                if (charadaAtiva) {
                    int escolha = overlayCharada.processarClique(e.getX(), e.getY());
                    if (escolha >= 0) {
                        fecharCharada(escolha);
                    }
                    return;
                }

                if (podeAbrirCharadaPelaPlaca(e.getX(), e.getY())) {
                    cenario.solicitarCharada(jogador);
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (mensagemSucessoAtiva) {
                    overlaySucesso.atualizarHover(e.getX(), e.getY());
                    repaint();
                    return;
                }
                if (charadaAtiva) {
                    overlayCharada.atualizarHover(e.getX(), e.getY());
                    repaint();
                }
            }
        });
    }

    private boolean podeAbrirCharadaPelaPlaca(int x, int y) {
        if (!(cenario.cenarioAtualInstancia instanceof Cenario5 c5)) return false;
        if (c5.isSolDesbloqueada() || charadaAtiva || cenario.isPerguntaEmAndamento()) return false;

        Rectangle placa = new Rectangle(
                Cenario5.PLACA_X, Cenario5.PLACA_Y,
                Cenario5.PLACA_W, Cenario5.PLACA_H
        );
        return placa.contains(x, y);
    }

    public void ativarCharada() {
        charadaAtiva = true;
        respostaCharada = -1;
        repaint();
    }

    public void fecharCharada(int resposta) {
        respostaCharada = resposta;
        charadaAtiva = false;
        cenario.processarRespostaCharada(resposta);
        repaint();
    }

    private void tratarEsc() {
        if (mensagemSucessoAtiva) {
            fecharMensagemSucesso();
        } else if (charadaAtiva) {
            cancelarCharada();
        }
    }

    public void cancelarCharada() {
        charadaAtiva = false;
        respostaCharada = -1;
        cenario.cancelarCharada();
        repaint();
    }

    public void mostrarMensagemPortaSolLiberada() {
        mensagemSucessoAtiva = true;
        repaint();
    }

    public void fecharMensagemSucesso() {
        mensagemSucessoAtiva = false;
        cenario.finalizarMensagemSucesso();
        repaint();
    }

    public void setPainelSul(PainelSul ps) {
        this.painelSul = ps;
        loopDoJogo.setPainelSul(ps);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());
        renderizador.renderizar(g2, cenario, jogador);

        // Mensagem de feedback do cenário 3
        String msg = cenario.getMensagemFeedback();
        if (msg != null) {
            desenharMensagemFeedback(g2, msg);
        }

        if (charadaAtiva) {
            overlayCharada.desenhar(g2);
        } else if (mensagemSucessoAtiva) {
            overlaySucesso.desenhar(g2);
        }
    }

    /**
     * Desenha uma caixa de mensagem estilizada no centro inferior da tela.
     * Aparece por 3 segundos e some automaticamente.
     */
    private void desenharMensagemFeedback(Graphics2D g2, String texto) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,      RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Font fonte = new Font("Arial", Font.BOLD, 15);
        g2.setFont(fonte);
        FontMetrics fm = g2.getFontMetrics();

        int padding  = 18;
        int boxW     = fm.stringWidth(texto) + padding * 2;
        int boxH     = 38;
        int boxX     = (getWidth() - boxW) / 2;
        int boxY     = getHeight() - 70; // logo acima do PainelSul
        int arc      = 12;

        // Sombra leve
        g2.setColor(new Color(0, 0, 0, 80));
        g2.fillRoundRect(boxX + 3, boxY + 3, boxW, boxH, arc, arc);

        // Fundo escuro semi-transparente
        g2.setColor(new Color(10, 7, 3, 200));
        g2.fillRoundRect(boxX, boxY, boxW, boxH, arc, arc);

        // Borda dourada
        g2.setColor(new Color(230, 180, 60));
        g2.setStroke(new BasicStroke(1.8f));
        g2.drawRoundRect(boxX, boxY, boxW, boxH, arc, arc);
        g2.setStroke(new BasicStroke(1f));

        // Texto
        g2.setColor(new Color(255, 228, 140));
        int textX = boxX + padding;
        int textY = boxY + (boxH - fm.getHeight()) / 2 + fm.getAscent();
        g2.drawString(texto, textX, textY);
    }
}