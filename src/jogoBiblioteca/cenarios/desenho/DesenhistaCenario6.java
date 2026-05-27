package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/** Cenário 6 — Salão com câmaras laterais. */
public class DesenhistaCenario6 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {}

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.arvores != null)
            d2.drawImage(sprites.arvores[0], 350, 120, 48, 72, null);
    }
}
