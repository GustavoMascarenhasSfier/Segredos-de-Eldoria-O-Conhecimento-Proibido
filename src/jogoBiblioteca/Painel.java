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
    private RenderizadorCena renderizador;  // <- novo

    public Painel(String posicao) {
        this.posicao = posicao;

        if (posicao.equals("Centro")) {
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(768, 480));

            jogador = new Player();

            escutTeclado = new EscutadorTeclado();
            this.addKeyListener(escutTeclado);

            this.cenario = new tileMap();
            this.renderizador = new RenderizadorCena();  // <- novo


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
        Graphics2D g2 = (Graphics2D) g;

        switch (posicao) {
            case "Centro":
                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());
                renderizador.renderizar(g2, cenario, jogador);  // <- novo
                break;

            case "Sul":
                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());
                break;
        }
    }
}