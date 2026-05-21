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
                this.cenario.desenhar(g2);
                jogador.DesenharPlayer(g2);

                break;

            case "Sul":

                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());

                break;
        }
    }
}
