package jogoBiblioteca;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tiles {
    private final int largura = 48, altura = 48;
    private int posX, posY;
    private Image imgAtual;
    private Image imgGrass, imgSand, imgWall, imgWater, imgWhite, imgGray;
    private boolean colisao;

    public Tiles() {
        carregaImagemTile();
    }

    private void carregaImagemTile() {
        imgGrass = new ImageIcon("res/TILES/grass1.png").getImage();
        imgSand  = new ImageIcon("res/TILES/sand1.png").getImage();
        imgWater = new ImageIcon("res/TILES/water1.png").getImage();
        imgWall  = new ImageIcon("res/TILES/wall1.png").getImage();
        imgWhite = new ImageIcon("res/TILES/white.png").getImage();
        imgGray  = new ImageIcon("res/TILES/gray.png").getImage();
    }
    public void carregaPecaDaMatriz(int valor) {
        if (valor == 0) {
            imgAtual = imgWall;
            this.colisao = true;}
        else if (valor == 1) {
            imgAtual = imgSand;
            this.colisao = false;}
        else if (valor == 2) {
            imgAtual = imgWater;
            this.colisao = true;}
        else if (valor == 3) {
            imgAtual = imgGrass;
            this.colisao = false;}
        else if (valor == 4) {
            imgAtual = imgWhite;
            this.colisao = false;}
        else if (valor == 5) {
            imgAtual = imgGray;
            this.colisao = true;}
    }

    public boolean isColisao() {
        return colisao;
    }


    public void desenhaTile(Graphics2D desenho, int linha, int coluna) {
        this.posX = coluna * largura;
        this.posY = linha * altura;

        desenho.drawImage(imgAtual, posX, posY, largura, altura, null);
    }
}
