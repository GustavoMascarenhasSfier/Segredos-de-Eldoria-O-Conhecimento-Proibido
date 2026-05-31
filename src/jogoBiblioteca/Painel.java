package jogoBiblioteca;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Painel extends JPanel {

    public Player jogador = new Player();
    private GameLoop loopDoJogo;
    private EscutadorTeclado escutTeclado;
    private SpriteLoop SpriteLoop;
    tileMap cenario;
    private RenderizadorCena renderizador;

    // Inventário compartilhado com PainelSul
    public Inventario inventario = new Inventario();

    // Referência ao PainelSul — preenchida pela Moldura depois do construtor
    public PainelSul painelSul;

    public Painel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(768, 480));

        jogador = new Player();

        escutTeclado = new EscutadorTeclado();
        this.addKeyListener(escutTeclado);

        this.cenario = new tileMap();
        this.renderizador = new RenderizadorCena();

        // GameLoop recebe painelSul depois via setPainelSul()
        loopDoJogo = new GameLoop(this, null, escutTeclado);
        loopDoJogo.start();

        SpriteLoop = new SpriteLoop(this, escutTeclado);
        SpriteLoop.start();

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /** Chamado pela Moldura logo após criar o PainelSul */
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
    }
}
