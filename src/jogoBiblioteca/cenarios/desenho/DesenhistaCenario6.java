package jogoBiblioteca.cenarios.desenho;

import java.awt.*;

import jogoBiblioteca.GerenciadorSprites;
import jogoBiblioteca.cenarios.Cenario4;
import jogoBiblioteca.cenarios.Cenario6;

/** Cenário 6 — Salão com câmaras laterais. */
public class DesenhistaCenario6 implements DesenhistaCenario {

    private Cenario6 cenario6ref;

    public void setCenario6(Cenario6 c6) {
        this.cenario6ref = c6;
    }

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {

        if (!cenario6ref.isLivro1Coletado()) {
            d2.drawImage(sprites.imgLivro1, 250, 402, 20, 20, null);
        }
        if (!cenario6ref.isLivro2Coletado()) {
            d2.drawImage(sprites.imgLivro2, 586, 154, 20, 20, null);
        }
        if (!cenario6ref.isLivro3Coletado()) {
            d2.drawImage(sprites.imgLivro3, 538, 402, 20, 20, null);
        }
        if (!cenario6ref.isLivro4Coletado()) {
            d2.drawImage(sprites.imgLivro4, 684, 402, 20, 20, null);

        }
    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {

    }

}
