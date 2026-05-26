package jogoBiblioteca;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GerenciadorSprites {

    public BufferedImage[] arvores;
    public BufferedImage imgCasa;
    public BufferedImage imgCasa1;
    public BufferedImage imgCasa2;
    public BufferedImage[] baus;
    public BufferedImage imgGirassol;

    public GerenciadorSprites() {
        carregaImagensDoMundo();
    }

    private void carregaImagensDoMundo() {
        // 1. CARREGA AS ÁRVORES
        try {
            BufferedImage sheet = ImageIO.read(new File("res/OBJECTS/Trees.png"));
            arvores = new BufferedImage[3];
            arvores[0] = sheet.getSubimage(32, 0, 32, 48);  // Pequena
            arvores[1] = sheet.getSubimage(64, 0, 32, 48);  // Média
            arvores[2] = sheet.getSubimage(96, 0, 32, 48);  // Grande
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de árvores!");
            e.printStackTrace();
        }

        // 2. CARREGA A CASA
        try {
            BufferedImage sheetCasa1 = ImageIO.read(new File("res/OBJECTS/House1.png"));
            imgCasa1 = sheetCasa1;
            BufferedImage sheetCasa2 = ImageIO.read(new File("res/OBJECTS/House2.png"));
            imgCasa2 = sheetCasa2;

            BufferedImage sheetCasa = ImageIO.read(new File("res/OBJECTS/House.png"));
            imgCasa = sheetCasa.getSubimage(144, 16, 80, 80);
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo da casa!");
            e.printStackTrace();
        }


        // 3. CARREGA OS BAÚS
        try {
            BufferedImage sheetBau = ImageIO.read(new File("res/OBJECTS/chest.png"));
            baus = new BufferedImage[2];
            baus[0] = sheetBau.getSubimage(0, 0, 32, 16);
            baus[1] = sheetBau.getSubimage(0, 16, 32, 16);
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo do baú!");
            e.printStackTrace();
        }


        // 4. CARREGA O GIRASSOL
        try {
            BufferedImage sheetPlantas = ImageIO.read(new File("res/OBJECTS/Plants.png"));
            imgGirassol = sheetPlantas.getSubimage(125, 10, 20, 24);

        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de plantas!");
            e.printStackTrace();
        }
    }
}