package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

public class DesenhistaCenario2 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {

        // CASAS
        d2.drawImage(sprites.imgCasa1, 0, -20, 250, 180, null);
        d2.drawImage(sprites.imgCasa2, 510, -20, 220, 180, null);

        // CHAFARIZ
        d2.drawImage(sprites.imgChafariz1, 295, 115, 170, 170, null);

    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {
        if (sprites.imgCasa1 != null)
            d2.drawImage(sprites.imgCasa3, 5, 235, 210, 180, null);
            d2.drawImage(sprites.imgCasa4, 520, 205, 230, 180, null);
    }
}