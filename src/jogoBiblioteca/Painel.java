package jogoBiblioteca;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Painel extends JPanel {

    private String posicao;
    public Player jogador = new Player();
    private GameLoop loopDoJogo;
    private EscutadorTeclado escutTeclado;
    private SpriteLoop SpriteLoop;
    tileMap cenario;

    public Painel(String posicao) {
        this.posicao = posicao;

        if (posicao.equals("Centro")) {
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(768, 480));

            jogador = new Player();

            escutTeclado = new EscutadorTeclado();
            this.addKeyListener(escutTeclado);


            this.cenario = new tileMap();

            loopDoJogo = new GameLoop(this, escutTeclado);
            loopDoJogo.start();

            SpriteLoop = new SpriteLoop(this, escutTeclado);
            SpriteLoop.start();

            this.setFocusable(true);
            this.requestFocusInWindow();

        } else if (posicao.equals("Sul")) {
            setBackground(Color.YELLOW);
            setPreferredSize(new Dimension(768, 100));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        switch (posicao) {

            case "Centro":

                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());

                // ---------------- MAPA BASE ----------------

                this.cenario.desenharCenario(g2);

                // ---------------- CONDIÇÕES ----------------

                boolean atrasArvoreSuperiorEsquerda =
                        jogador.AreaColisao.getMaxY() < 150;

                boolean atrasArvoreSuperiorDireita =
                        jogador.AreaColisao.getMaxY() < 170;

                boolean atrasArvoreSuperiorCentral =
                        jogador.AreaColisao.getMaxY() < 90;

                boolean atrasEstatua =
                        jogador.AreaColisao.getMaxY() < 210;

                boolean atrasArvoreInferiorDireita =
                        jogador.AreaColisao.getMaxY() < 340;


                // ---------------- ÁRVORES ATRÁS DO PLAYER ----------------

                if (!atrasArvoreSuperiorCentral) {

                    g2.drawImage(cenario.sprites.arvores[1],
                            280, -120, 250, 250, null);
                }

                if (!atrasArvoreSuperiorEsquerda) {

                    g2.drawImage(cenario.sprites.arvores[2],
                            -20, -40, 200, 250, null);
                }

                if (!atrasArvoreSuperiorDireita) {

                    g2.drawImage(cenario.sprites.arvores[2],
                            600, 10, 170, 200, null);
                }

                // Árvore atrás do baú
                g2.drawImage(cenario.sprites.arvores[2],
                        180, -170, 200, 250, null);

                if (!atrasEstatua) {

                    g2.drawImage(cenario.sprites.imgEstatua,
                            200, 90, 110, 170, null);
                }

                if (!atrasArvoreInferiorDireita) {

                    g2.drawImage(cenario.sprites.arvores[2],
                            420, 180, 150, 200, null);
                }

                // ---------------- PLAYER ----------------

                jogador.DesenharPlayer(g2);


                // ---------------- ESTÁTUA NA FRENTE ----------------

                if (atrasEstatua) {

                    // player atrás da estátua
                    g2.drawImage(cenario.sprites.imgEstatua,
                            200, 90, 110, 170, null);
                }


                // ---------------- ÁRVORES NA FRENTE DO PLAYER ----------------

                if (atrasArvoreSuperiorCentral) {

                    g2.drawImage(cenario.sprites.arvores[1],
                            280, -120, 250, 250, null);
                }

                if (atrasArvoreSuperiorEsquerda) {

                    g2.drawImage(cenario.sprites.arvores[2],
                            -20, -40, 200, 250, null);
                }

                if (atrasArvoreSuperiorDireita) {

                    g2.drawImage(cenario.sprites.arvores[2],
                            600, 10, 170, 200, null);
                }

                if (atrasArvoreInferiorDireita) {

                    g2.drawImage(cenario.sprites.arvores[2],
                            420, 180, 150, 200, null);
                }

                // ---------------- ÁRVORES INFERIORES ----------------

                // Primeira árvore inferior esquerda
                g2.drawImage(cenario.sprites.arvores[2],
                        180, 250, 150, 180, null);

                // Árvore meio esquerda
                g2.drawImage(cenario.sprites.arvores[1],
                        -60, 80, 200, 250, null);

                // Árvore canto inferior esquerdo
                g2.drawImage(cenario.sprites.arvores[1],
                        -60, 200, 250, 300, null);

                // Segunda árvore inferior direita
                g2.drawImage(cenario.sprites.arvores[1],
                        560, 190, 200, 250, null);

                // ---------------- PILAR ----------------

                g2.drawImage(cenario.sprites.imgPilar,
                        650, 180, 60, 60, null);

                break;


            case "Sul":

                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());

                break;
        }
    }
}
