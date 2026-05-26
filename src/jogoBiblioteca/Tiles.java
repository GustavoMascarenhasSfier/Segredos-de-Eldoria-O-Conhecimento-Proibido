package jogoBiblioteca;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tiles {

    private final int largura = 48, altura = 48;
    private int posX, posY;

    private Image imgAtual;
    private Image imgGrass, imgSand1, imgSandH, imgSandCDS, imgSandCDI, imgSandD, imgWall, imgWater, imgWhite, imgGray, imgGrassDecoration1, imgGrassDecoration2, imgGrass1, imgGrass2, imgGrass3, imgGrass4, imgGrass5, imgWall1, imgWall2;
    private boolean colisao;

    public Tiles() {
        carregaImagemTile();
    }

    private void carregaImagemTile() {

        // SAND
        imgSand1  = new ImageIcon("res/TILES/sand1.png").getImage();
        imgSandH  = new ImageIcon("res/TILES/sand2.png").getImage();

        imgSandCDS = new ImageIcon("res/TILES/SandDireitoSuperior.png").getImage();
        imgSandCDI  = new ImageIcon("res/TILES/SandDireitoInferior.png").getImage();
        imgSandD  = new ImageIcon("res/TILES/SandDireita.png").getImage();

        //OTHERS
        imgWater = new ImageIcon("res/TILES/water1.png").getImage();
        imgWall  = new ImageIcon("res/TILES/wall1.png").getImage();
        imgWhite = new ImageIcon("res/TILES/white.png").getImage();
        imgGray  = new ImageIcon("res/TILES/gray.png").getImage();


        imgGrassDecoration1 = new ImageIcon("res/TILES/GrassDecoration1.png").getImage();
        imgGrassDecoration2  = new ImageIcon("res/TILES/GrassDecoration2.png").getImage();
        imgGrass = new ImageIcon("res/TILES/grass1.png").getImage();
        imgGrass1 = new ImageIcon("res/TILES/grass1.png").getImage();
        imgGrass2 = new ImageIcon("res/TILES/grass2.png").getImage();
        imgGrass3  = new ImageIcon("res/TILES/grass3.png").getImage();

        imgWall1 = new ImageIcon("res/TILES/MuroDoMundo1.png").getImage();
        imgWall2 = new ImageIcon("res/TILES/MuroDoMundo2.png").getImage();

    }

    public void carregaPecaDaMatriz(int valor) {
        if (valor == 0) { imgAtual = imgWall1; colisao = true; }
        else if (valor == 2) { imgAtual = imgWater; colisao = true; }
        else if (valor == 3) { imgAtual = imgWall2; colisao = true; }
        else if (valor == 4) { imgAtual = imgWhite; colisao = false; }
        else if (valor == 5) { imgAtual = imgGray; colisao = true; }

        //AREIA
        else if (valor == 1) { imgAtual = imgSand1; colisao = false; }
        else if (valor == 12) { imgAtual = imgSandH; colisao = false; }
        else if (valor == 13) { imgAtual = imgSandD; colisao = false; }
        else if (valor == 14) { imgAtual = imgSandCDS; colisao = false; }
        else if (valor == 15) { imgAtual = imgSandCDI; colisao = false; }

        else if (valor == 6) { imgAtual = imgGrassDecoration1; colisao = false; } // DECORAÇÃO
        else if (valor == 7) { imgAtual = imgGrassDecoration2; colisao = false; } // DECORAÇÃO
        else if (valor == 8) { imgAtual = imgGrass; colisao = false; }
        else if (valor == 9) { imgAtual = imgGrass1; colisao = false; }
        else if (valor == 10) { imgAtual = imgGrass2; colisao = false; }
        else if (valor == 11) { imgAtual = imgGrass3; colisao = false; }

    }

    public boolean isColisao() { return colisao; }

    public void desenhaTile(Graphics2D desenho, int linha, int coluna) {
        posX = coluna * largura;
        posY = linha * altura;
        desenho.drawImage(imgAtual, posX, posY, largura, altura, null);
    }
}