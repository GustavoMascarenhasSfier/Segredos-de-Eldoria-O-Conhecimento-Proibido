package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/** Cenário 5 — Sala com câmara interna. */
public class DesenhistaCenario5 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {}

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.arvores != null)
            d2.drawImage(sprites.arvores[1], 250, 300, 72, 108, null);
    }
}
