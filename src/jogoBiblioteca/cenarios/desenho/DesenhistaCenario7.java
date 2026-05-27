package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/** Cenário 7 — Mapa de rio / exterior aberto. */
public class DesenhistaCenario7 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {}

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.arvores != null)
            d2.drawImage(sprites.arvores[2], 500, 250, 96, 144, null);
    }
}
