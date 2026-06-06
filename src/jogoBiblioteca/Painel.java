package jogoBiblioteca;

import jogoBiblioteca.cenarios.Cenario5;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
        jogador.teleportar(cenario.spawnX1, cenario.spawnY1); // adiciona essa linha


        this.cenario.setContexto(this, escutTeclado);

        this.renderizador = new RenderizadorCena();

        loopDoJogo = new GameLoop(this, null, escutTeclado);
        loopDoJogo.start();

        SpriteLoop = new SpriteLoop(this, escutTeclado);
        SpriteLoop.start();

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

        if (charadaAtiva) {
            overlayCharada.desenhar(g2);
        } else if (mensagemSucessoAtiva) {
            overlaySucesso.desenhar(g2);
        }
    }
}
