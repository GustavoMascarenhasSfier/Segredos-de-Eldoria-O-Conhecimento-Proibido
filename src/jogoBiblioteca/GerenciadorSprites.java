package jogoBiblioteca;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GerenciadorSprites {

    // Cenário 1 — Mundo exterior (Constantes de Caminho)
    private static final String CAMINHO_ARVORES  = "res/cenarios/cenario1/Trees.png";
    private static final String CAMINHO_CASA     = "res/cenarios/cenario1/House.png";
    private static final String CAMINHO_BAU      = "res/cenarios/cenario1/chest.png";
    private static final String CAMINHO_PLANTAS  = "res/cenarios/cenario1/Plants.png";
    private static final String CAMINHO_DECOR    = "res/cenarios/cenario1/BancoEstatua.png";

    // Cenário 3 — Biblioteca (Constantes de Caminho)
    private static final String CAMINHO_ESTANTE         = "res/cenarios/cenario3_biblioteca/estante.png";
    private static final String CAMINHO_ESTANTE_LATERAL = "res/cenarios/cenario3_biblioteca/estante-lateral.png";
    private static final String CAMINHO_ESTANTE_CHEIA   = "res/cenarios/cenario3_biblioteca/estante-cheia.png";
    private static final String CAMINHO_LAREIRA         = "res/cenarios/cenario3_biblioteca/lareira.png";
    private static final String CAMINHO_CHAO_BIB        = "res/cenarios/cenario3_biblioteca/chao.png";
    private static final String CAMINHO_PIANO           = "res/cenarios/cenario3_biblioteca/piano.png";
    private static final String CAMINHO_QUADRO          = "res/cenarios/cenario3_biblioteca/quadro.png";
    private static final String CAMINHO_MESA_CENTRO     = "res/cenarios/cenario3_biblioteca/mesa-centro.png";
    private static final String CAMINHO_VELAS           = "res/cenarios/cenario3_biblioteca/velas.png";
    private static final String CAMINHO_MESA_LIVRO      = "res/cenarios/cenario3_biblioteca/mesaLivro.png";
    private static final String CAMINHO_LIVRO_FECHADO   = "res/cenarios/cenario3_biblioteca/livroFechado.png";
    private static final String CAMINHO_LIVRO_ABERTO    = "res/cenarios/cenario3_biblioteca/livroAberto.png";
    private static final String CAMINHO_CADEIRA_BAIXO   = "res/cenarios/cenario3_biblioteca/cadeira-baixo.png";
    private static final String CAMINHO_CADEIRA_CIMA    = "res/cenarios/cenario3_biblioteca/cadeira-cima.png";
    private static final String CAMINHO_CADEIRA_DIR     = "res/cenarios/cenario3_biblioteca/cadeira-direita.png";
    private static final String CAMINHO_CADEIRA_ESQ     = "res/cenarios/cenario3_biblioteca/cadeira-esquerda.png";
    private static final String CAMINHO_BANDEIRA        = "res/cenarios/cenario3_biblioteca/bandeira.png";
    private static final String CAMINHO_BICHO1          = "res/cenarios/cenario3_biblioteca/bicho1.png";
    private static final String CAMINHO_BICHO2          = "res/cenarios/cenario3_biblioteca/bicho2.png";
    private static final String CAMINHO_PAREDE          = "res/cenarios/cenario3_biblioteca/parede.png";
    private static final String CAMINHO_PAREDE2         = "res/cenarios/cenario3_biblioteca/parede2.png";
    private static final String CAMINHO_TAPETE          = "res/cenarios/cenario3_biblioteca/tapete.png";
    private static final String CAMINHO_TAPETE2         = "res/cenarios/cenario3_biblioteca/tapete2.png";
    private static final String CAMINHO_TAPETE_INFERIOR = "res/cenarios/cenario3_biblioteca/tapeteInferior.png";
    private static final String CAMINHO_TAPETE_LATERAL  = "res/cenarios/cenario3_biblioteca/tapeteLateral.png";

    // Sprites do cenário 1
    public BufferedImage[] arvores;
    public BufferedImage   imgCasa;
    public BufferedImage[] baus;
    public BufferedImage   imgGirassol;
    public BufferedImage[] bancos;
    public BufferedImage   imgEstatua;
    public BufferedImage   imgPilar;

    // Sprites do cenário 3
    public BufferedImage imgEstante;
    public BufferedImage imgEstanteLateral;
    public BufferedImage imgEstanteCheia;
    public BufferedImage imgLareira;
    public BufferedImage imgChaoBiblioteca;
    public BufferedImage imgPiano;
    public BufferedImage imgQuadro;
    public BufferedImage imgMesaCentro;
    public BufferedImage imgMesaLivro;
    public BufferedImage imgVelas;
    public BufferedImage imgLivroFechado;
    public BufferedImage imgLivroAberto;
    public BufferedImage imgCadeiraBaixo;
    public BufferedImage imgCadeiraCima;
    public BufferedImage imgCadeiraDireita;
    public BufferedImage imgCadeiraEsquerda;
    public BufferedImage imgBandeira;
    public BufferedImage imgBicho1;
    public BufferedImage imgBicho2;
    public BufferedImage imgParede;
    public BufferedImage imgParede2;
    public BufferedImage imgTapete;
    public BufferedImage imgTapete2;
    public BufferedImage imgTapeteInferior;
    public BufferedImage imgTapeteLateral;

    public GerenciadorSprites() {
        carregaImagensMundoExterior();
        carregaImagensBiblioteca();
    }

    private void carregaImagensMundoExterior() {
        // 1. ÁRVORES
        try {
            BufferedImage sheet = ImageIO.read(new File(CAMINHO_ARVORES));
            arvores = new BufferedImage[3];
            arvores[0] = sheet.getSubimage(32, 0, 32, 48);  // Pequena
            arvores[1] = sheet.getSubimage(64, 0, 32, 48);  // Média
            arvores[2] = sheet.getSubimage(96, 0, 32, 48);  // Grande
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo de árvores: " + e.getMessage());
        }

        // 2. CASA
        try {
            BufferedImage sheetCasa = ImageIO.read(new File(CAMINHO_CASA));
            imgCasa = sheetCasa.getSubimage(144, 16, 80, 80);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo da casa: " + e.getMessage());
        }

        // 3. BAÚS
        try {
            BufferedImage sheetBau = ImageIO.read(new File(CAMINHO_BAU));
            baus = new BufferedImage[2];
            baus[0] = sheetBau.getSubimage(0, 0, 32, 16);
            baus[1] = sheetBau.getSubimage(0, 16, 32, 16);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo do baú: " + e.getMessage());
        }

        // 4. GIRASSOL
        try {
            BufferedImage sheetPlantas = ImageIO.read(new File(CAMINHO_PLANTAS));
            imgGirassol = sheetPlantas.getSubimage(125, 10, 20, 24);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo de plantas: " + e.getMessage());
        }

        // 5. DECORAÇÕES
        try {
            BufferedImage sheetDecor = ImageIO.read(new File(CAMINHO_DECOR));
            bancos = new BufferedImage[2];
            bancos[0] = sheetDecor.getSubimage(0, 0, 80, 60);    // Banco horizontal
            bancos[1] = sheetDecor.getSubimage(100, 0, 40, 60);  // Banco vertical
            imgEstatua = sheetDecor.getSubimage(156, 20, 50, 80);
            imgPilar = sheetDecor.getSubimage(166, 112, 42, 42);
        } catch (IOException e) {
            System.err.println("Erro ao carregar decorações: " + e.getMessage());
        }
    }

    private void carregaImagensBiblioteca() {
        imgEstante         = carregarSheet(CAMINHO_ESTANTE);
        imgEstanteLateral  = carregarSheet(CAMINHO_ESTANTE_LATERAL);
        imgEstanteCheia    = carregarSheet(CAMINHO_ESTANTE_CHEIA);
        imgLareira         = carregarSheet(CAMINHO_LAREIRA);
        imgChaoBiblioteca  = carregarSheet(CAMINHO_CHAO_BIB);
        imgPiano           = carregarSheet(CAMINHO_PIANO);
        imgQuadro          = carregarSheet(CAMINHO_QUADRO);
        imgMesaCentro      = carregarSheet(CAMINHO_MESA_CENTRO);
        imgMesaLivro       = carregarSheet(CAMINHO_MESA_LIVRO);
        imgVelas           = carregarSheet(CAMINHO_VELAS);
        imgLivroFechado    = carregarSheet(CAMINHO_LIVRO_FECHADO);
        imgLivroAberto     = carregarSheet(CAMINHO_LIVRO_ABERTO);
        imgCadeiraBaixo    = carregarSheet(CAMINHO_CADEIRA_BAIXO);
        imgCadeiraCima     = carregarSheet(CAMINHO_CADEIRA_CIMA);
        imgCadeiraDireita  = carregarSheet(CAMINHO_CADEIRA_DIR);
        imgCadeiraEsquerda = carregarSheet(CAMINHO_CADEIRA_ESQ);
        imgBandeira        = carregarSheet(CAMINHO_BANDEIRA);
        imgBicho1          = carregarSheet(CAMINHO_BICHO1);
        imgBicho2          = carregarSheet(CAMINHO_BICHO2);
        imgParede          = carregarSheet(CAMINHO_PAREDE);
        imgParede2         = carregarSheet(CAMINHO_PAREDE2);
        imgTapete          = carregarSheet(CAMINHO_TAPETE);
        imgTapete2         = carregarSheet(CAMINHO_TAPETE2);
        imgTapeteLateral   = carregarSheet(CAMINHO_TAPETE_LATERAL);
        imgTapeteInferior  = carregarSheet(CAMINHO_TAPETE_INFERIOR);
    }

    // Método utilitário caso precise recortar vetores de uma mesma folha futuramente
    private BufferedImage[] carregarSprites(String caminho, int[][] regioes) {
        BufferedImage sheet = carregarSheet(caminho);
        if (sheet == null) return null;
        BufferedImage[] sprites = new BufferedImage[regioes.length];
        for (int i = 0; i < regioes.length; i++) {
            int[] r = regioes[i];
            sprites[i] = sheet.getSubimage(r[0], r[1], r[2], r[3]);
        }
        return sprites;
    }

    private BufferedImage carregarSheet(String caminho) {
        try {
            return ImageIO.read(new File(caminho));
        } catch (IOException e) {
            System.err.printf("Erro ao carregar sprite: %s — %s%n", caminho, e.getMessage());
            return null;
        }
    }
}