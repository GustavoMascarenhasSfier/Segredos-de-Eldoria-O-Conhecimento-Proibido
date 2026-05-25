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

            this.cenario = new tileMap();

            this.setFocusable(true);
            this.requestFocusInWindow();

        } else if (posicao.equals("Sul")) {
            setBackground(Color.YELLOW);
            setPreferredSize(new Dimension(768, 100));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        switch (posicao) {
            case "Centro":
                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());

                // 1. Desenha o fundo, chão, baú e casa básica
                this.cenario.desenharChaoECasas(g2);

                // 2. Y-Sorting das árvores superiores com base na linha do baú/árvore (Y = 110)
                if (jogador.AreaColisao.y < 110) {
                    // Jogador atrás das árvores do topo
                    jogador.DesenharPlayer(g2);
                    this.cenario.desenharArvoresDoTopo(g2);
                } else {
                    // Jogador na frente das árvores do topo
                    this.cenario.desenharArvoresDoTopo(g2);
                    jogador.DesenharPlayer(g2);
                }

                // 3. Desenha as árvores de baixo por último (sempre cobrindo quem está acima)
                // Caso o jogador ande para baixo, ele passará naturalmente por trás das folhas delas
                this.cenario.desenharArvoresDeBaixo(g2);
                break;

            case "Sul":
                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());
                break;
        }
    }
}
