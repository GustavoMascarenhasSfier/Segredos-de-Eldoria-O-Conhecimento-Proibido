package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

public class DesenhistaCenario2 implements DesenhistaCenario {

    private static final int PE_ARV2_TOPO = -100 + 220;
    private static final int PE_ARV1_TOPO =  -40 + 240;
    private static final int PE_ARV2_DIR  =  100 + 140;
    private static final int PE_ARV1_INF  =  240 + 200;

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {

        if (sprites.imgGirassol != null) {
            d2.drawImage(sprites.imgGirassol, 300, 370, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 150, 160, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 680, 160, 40, 50, null);
        }

        // ARVORE — gramado superior centro
        if (sprites.imgArvore2 != null)
            d2.drawImage(sprites.imgArvore2, 400, -100, 180, 220, null);

        // CHAFARIZ — centro do mapa
        d2.drawImage(sprites.imgChafariz1, 295, 115, 170, 170, null);

        // MOITA — canteiro superior esquerdo
        d2.drawImage(sprites.imgMoita,  195,  25,  70,  50, null);
        // MOITA — canteiro superior centro
        d2.drawImage(sprites.imgMoita2, 295,  35,  90,  70, null);
        // MOITA — canteiro superior direito
        d2.drawImage(sprites.imgMoita3, 445,  55, 145, 105, null);
        // MOITA — gramado esquerdo meio
        d2.drawImage(sprites.imgMoita3,  30, 180,  80,  60, null);

        // CASA 1 — canto superior esquerdo
        d2.drawImage(sprites.imgCasa1,   0, -20, 250, 180, null);
        // CASA 2 — canto superior direito
        d2.drawImage(sprites.imgCasa2, 510, -20, 220, 180, null);



        // MOITA — gramado direito meio
        d2.drawImage(sprites.imgMoita2, 550, 130, 100,  70, null);
        // POSTE — cruzamento superior direito
        d2.drawImage(sprites.imgPoste2, 445,  50, 110, 150, null);

        // ARVORE — gramado superior esquerdo
        if (sprites.imgArvore1 != null)
            d2.drawImage(sprites.imgArvore1, 125,  -40, 220, 240, null);
        // ARVORE — gramado direito
        if (sprites.imgArvore2 != null)
            d2.drawImage(sprites.imgArvore2, 500,  100, 120, 140, null);
        // ARVORE — inferior direita
        if (sprites.imgArvore1 != null)
            d2.drawImage(sprites.imgArvore1, 420,  240, 190, 200, null);

        // CERCA — calçada superior esquerda
        d2.drawImage(sprites.imgCerca,  165, 120, 140,  80, null);

    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {

        // CERCA
        d2.drawImage(sprites.imgCerca, 465, 268, 140, 80, null);

        // MOITA
        d2.drawImage(sprites.imgMoita3, 125, 270, 130,  90, null);

        // CASA 3
        d2.drawImage(sprites.imgCasa3,   5, 283, 210, 180, null);
        // CASA 4
        d2.drawImage(sprites.imgCasa4, 520, 253, 230, 180, null);

        // ARVORE — superior centro
        if (sprites.imgArvore2 != null && peJogador < PE_ARV2_TOPO)
            d2.drawImage(sprites.imgArvore2, 400, -100, 180, 220, null);
        // ARVORE — superior esquerda
        if (sprites.imgArvore1 != null && peJogador < PE_ARV1_TOPO)
            d2.drawImage(sprites.imgArvore1, 125,  -40, 220, 240, null);
        // ARVORE — direita
        if (sprites.imgArvore2 != null && peJogador < PE_ARV2_DIR)
            d2.drawImage(sprites.imgArvore2, 500,  100, 120, 140, null);
        // ARVORE — inferior direita
        if (sprites.imgArvore1 != null && peJogador < PE_ARV1_INF)
            d2.drawImage(sprites.imgArvore1, 420,  240, 190, 200, null);

        // POSTE
        d2.drawImage(sprites.imgPoste, 195, 150, 110, 150, null);
        // MOITA
        d2.drawImage(sprites.imgMoita,  195, 260, 100,  70, null);
        d2.drawImage(sprites.imgMoita2, 155, 300, 170, 140, null);
    }
}