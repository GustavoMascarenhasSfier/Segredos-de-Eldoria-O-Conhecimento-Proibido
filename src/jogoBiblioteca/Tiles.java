package jogoBiblioteca;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tiles {

    private final int largura = 48, altura = 48;
    private int posX, posY;

    private Image imgAtual;
    private Image imgGrass, imgSand,imgSandL,imgSandR,imgSandT,
            imgSandD,imgSandSL,imgSandSR,imgSandIL,imgSandIR,
            imgSandH,imgSandV, imgWall, imgWater, imgWhite, imgGray,
            imgGrass1, imgGrass2, imgGrass3, imgGrass4, imgGrass5,
            imgGrass6, imgGrass7, imgGrass8, imgGrass9, imgChao4;

    private boolean colisao;

    public Tiles() {
        carregaImagemTile();
    }

    private void carregaImagemTile() {

        // SAND
        imgSand  = new ImageIcon("res/TILES/sand1.png").getImage();
        imgSandR  = new ImageIcon("res/TILES/sandR.png").getImage();
        imgSandL  = new ImageIcon("res/TILES/sandL.png").getImage();
        imgSandT  = new ImageIcon("res/TILES/sandT.png").getImage();
        imgSandD  = new ImageIcon("res/TILES/sandD.png").getImage();
        imgSandH  = new ImageIcon("res/TILES/sandH.png").getImage();
        imgSandV  = new ImageIcon("res/TILES/sandV.png").getImage();
        imgSandSL  = new ImageIcon("res/TILES/sandSL.png").getImage();
        imgSandSR  = new ImageIcon("res/TILES/sandSR.png").getImage();
        imgSandIL  = new ImageIcon("res/TILES/sandIL.png").getImage();
        imgSandIR  = new ImageIcon("res/TILES/sandIR.png").getImage();

        imgWater = new ImageIcon("res/TILES/water1.png").getImage();
        imgWall  = new ImageIcon("res/TILES/wall1.png").getImage();
        imgWhite = new ImageIcon("res/TILES/white.png").getImage();
        imgGray  = new ImageIcon("res/TILES/gray.png").getImage();

        imgGrass = new ImageIcon("res/TILES/grass1.png").getImage();
        imgGrass1  = new ImageIcon("res/TILES/GrassDecoration1.png").getImage();
        imgGrass2  = new ImageIcon("res/TILES/GrassDecoration2.png").getImage();
        imgGrass3  = new ImageIcon("res/TILES/grass2.png").getImage();
        imgGrass4  = new ImageIcon("res/TILES/grass3.png").getImage();
        imgGrass5  = new ImageIcon("res/TILES/grass4.png").getImage();
        imgGrass6  = new ImageIcon("res/TILES/grass5.png").getImage();
        imgGrass7  = new ImageIcon("res/TILES/grass6.png").getImage();
        imgGrass8 = new ImageIcon("res/TILES/MuroMundo1.png").getImage(); //Grama
        imgGrass9 = new ImageIcon("res/TILES/MuroMundo2.png").getImage(); //Grama

        imgChao4 = new ImageIcon("res/cenarios/cenario4/chao.png").getImage();

    }

    public void carregaPecaDaMatriz(int valor) {
        if (valor == 0) { imgAtual = imgWall; colisao = false; }
        // SAND
        else if (valor == 1) { imgAtual = imgSand; colisao = false; }
        else if (valor == 13) { imgAtual = imgSandL; colisao = false; }
        else if (valor == 14) { imgAtual = imgSandT; colisao = false; }
        else if (valor == 15) { imgAtual = imgSandR; colisao = false; }
        else if (valor == 16) { imgAtual = imgSandD; colisao = false; }
        else if (valor == 17) { imgAtual = imgSandH; colisao = false; }
        else if (valor == 18) { imgAtual = imgSandV; colisao = false; }
        else if (valor == 19) { imgAtual = imgSandSL; colisao = false; }
        else if (valor == 20) { imgAtual = imgSandSR; colisao = false; }
        else if (valor == 21) { imgAtual = imgSandIL; colisao = false; }
        else if (valor == 22) { imgAtual = imgSandIR; colisao = false; }


        else if (valor == 2) { imgAtual = imgWater; colisao = true; }
        else if (valor == 3) { imgAtual = imgGrass; colisao = false; }
        else if (valor == 4) { imgAtual = imgWhite; colisao = false; }
        else if (valor == 5) { imgAtual = imgGray; colisao = true; }

        else if (valor == 6) { imgAtual = imgGrass1; colisao = false; } // DECORAÇÃO
        else if (valor == 7) { imgAtual = imgGrass2; colisao = false; } // DECORAÇÃO
        else if (valor == 8) { imgAtual = imgGrass3; colisao = false; }
        else if (valor == 9) { imgAtual = imgGrass4; colisao = false; }
        else if (valor == 10) { imgAtual = imgGrass5; colisao = false; }
        else if (valor == 11) { imgAtual = imgGrass6; colisao = false;}
        else if (valor == 12) { imgAtual = imgGrass8; colisao = true;} // Muro1
        else if (valor == 23) { imgAtual = imgGrass9; colisao = true;} // Muro2

        else if (valor == 24) { imgAtual = imgChao4; colisao = false;}
    }

    public boolean isColisao() { return colisao; }

    public void desenhaTile(Graphics2D desenho, int linha, int coluna) {
        posX = coluna * largura;
        posY = linha * altura;
        desenho.drawImage(imgAtual, posX, posY, largura, altura, null);
    }
}