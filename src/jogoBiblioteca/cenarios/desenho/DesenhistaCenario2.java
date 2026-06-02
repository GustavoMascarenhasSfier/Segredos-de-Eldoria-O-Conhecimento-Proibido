package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

public class DesenhistaCenario2 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {



        // CHAFARIZ
        d2.drawImage(sprites.imgChafariz1, 295, 115, 170, 170, null);

        //Moita
        d2.drawImage(sprites.imgMoita, 195, 25, 70, 50, null);
        d2.drawImage(sprites.imgMoita2, 295, 35, 90, 70, null);
        d2.drawImage(sprites.imgMoita3, 445, 55, 145, 105, null);
        d2.drawImage(sprites.imgMoita2, 395, 310, 80, 60, null);
        d2.drawImage(sprites.imgMoita3, 30, 220, 80, 60, null);

        // CASAS
        d2.drawImage(sprites.imgCasa1, 0, -20, 250, 180, null);
        d2.drawImage(sprites.imgCasa2, 510, -20, 220, 180, null);

        if (sprites.arvores[1] != null) {
            d2.drawImage(sprites.arvores[1], 340, -70, 150, 180, null);
            d2.drawImage(sprites.arvores[2], 165, -30, 150, 180, null);
        }

        //Moita
        d2.drawImage(sprites.imgMoita3, 525, 130, 100, 60, null);
        //Cerca
        d2.drawImage(sprites.imgCerca, 165, 120, 140, 80, null);
        //Poste
        d2.drawImage(sprites.imgPoste2, 445, 50, 110, 150, null);

    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {

        //Cerca
        d2.drawImage(sprites.imgCerca, 465, 220, 140, 80, null);

        //Casa
        d2.drawImage(sprites.imgCasa3, 5, 235, 210, 180, null);
        d2.drawImage(sprites.imgCasa4, 520, 205, 230, 180, null);

        if (sprites.arvores[1] != null) {
            d2.drawImage(sprites.arvores[2], 465, 240, 120, 140, null);
        }

        //Poste
        d2.drawImage(sprites.imgPoste, 195, 130, 110, 150, null);
        //Moita
        d2.drawImage(sprites.imgMoita, 195, 240, 100, 70, null);
    }
}