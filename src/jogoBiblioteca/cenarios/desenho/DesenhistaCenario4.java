package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/** Cenário 4 — Labirinto cruzado. */
public class DesenhistaCenario4 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {}

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {
        if (sprites.arvores != null)
            d2.drawImage(sprites.arvores[2], 600, 200, 96, 144, null);
    }
}