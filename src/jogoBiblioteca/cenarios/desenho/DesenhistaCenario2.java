package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/**
 * Cenário 2 — Sala de estoques.
 */
public class DesenhistaCenario2 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {
        // Adicione aqui elementos de fundo do cenário 2
    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.arvores != null)
            d2.drawImage(sprites.arvores[1], 300, 150, 72, 108, null);
    }
}
