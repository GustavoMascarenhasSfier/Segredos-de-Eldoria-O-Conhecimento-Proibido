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

    // ---------------------------------
    // CENARIO 2
    // ---------------------------------

    // CASAS
    private static final String CAMINHO_C2_House_1 = "res/cenarios/cenario2/house1.png";
    private static final String CAMINHO_C2_House_2 = "res/cenarios/cenario2/house2.png";
    private static final String CAMINHO_C2_House_3 = "res/cenarios/cenario2/house3.png";
    private static final String CAMINHO_C2_House_4 = "res/cenarios/cenario2/house4.png";

    // CHAFARIZ
    private static final String CAMINHO_C2_Chafariz_1 = "res/cenarios/cenario2/chafariz.png";

    // MOITA
    private static final String CAMINHO_C2_Moita = "res/cenarios/cenario2/moita.png";
    private static final String CAMINHO_C2_Moita2 = "res/cenarios/cenario2/moita2.png";
    private static final String CAMINHO_C2_Moita3 = "res/cenarios/cenario2/moita3.png";
    private static final String CAMINHO_C2_Moita4 = "res/cenarios/cenario2/moita4.png";
    // Cerca
    private static final String CAMINHO_C2_Cerca = "res/cenarios/cenario2/cerca.png";
    private static final String CAMINHO_C2_Poste = "res/cenarios/cenario2/poste.png";
    private static final String CAMINHO_C2_Poste2 = "res/cenarios/cenario2/poste2.png";



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

    //Cenario 4

    private static final String Balcao  = "res/cenarios/cenario4/Balcao.png";
    private static final String Lustre1  = "res/cenarios/cenario4/Luz.png";
    private static final String Lustre2 = "res/cenarios/cenario4/Luz1.png";
    private static final String Lustre3  = "res/cenarios/cenario4/Luz2.png";
    private static final String MesaRedonda  = "res/cenarios/cenario4/MesaRedonda.png";
    private static final String Globo  = "res/cenarios/cenario4/Globo.png";
    private static final String ArvoreDecoracao = "res/cenarios/cenario4/ArvoreDecoracao.png";
    private static final String CadeiraD = "res/cenarios/cenario4/CadeiraD.png";
    private static final String CadeiraL = "res/cenarios/cenario4/CadeiraL.png";
    private static final String CadeiraR = "res/cenarios/cenario4/CadeiraR.png";
    private static final String CadeiraT = "res/cenarios/cenario4/CadeiraT.png";
    private static final String MesaLateral = "res/cenarios/cenario4/MesaLateral.png";
    private static final String QuadroC4 = "res/cenarios/cenario4/Quadro.png";
    private static final String Quadro1C4 = "res/cenarios/cenario4/Quadro1.png";
    private static final String Teia1 = "res/cenarios/cenario4/Teia1.png";
    private static final String Teia2 = "res/cenarios/cenario4/Teia2.png";
    private static final String Teia3 = "res/cenarios/cenario4/Teia3.png";
    private static final String Teia4 = "res/cenarios/cenario4/Teia4.png";
    private static final String Teia5 = "res/cenarios/cenario4/Teia5.png";
    private static final String TrofeuDeCervo = "res/cenarios/cenario4/TrofeuDeCervo.png";
    private static final String ChaveItem = "res/cenarios/cenario4/Golden Key.png";


    //Cenario6
    private static final String Caminho_Livro1 = "res/cenarios/cenario6/livro1.png";
    private static final String Caminho_Livro2 = "res/cenarios/cenario6/livro2.png";
    private static final String Caminho_Livro3 = "res/cenarios/cenario6/livro3.png";
    private static final String Caminho_Livro4 = "res/cenarios/cenario6/livro4.png";



    // Sprites do cenário 1
    public BufferedImage[] arvores;
    public BufferedImage   imgCasa;
    public BufferedImage[] baus;
    public BufferedImage   imgGirassol;
    public BufferedImage[] bancos;
    public BufferedImage   imgEstatua;
    public BufferedImage   imgPilar;

    //-------------------------
    // Sprites
    //-------------------------

    // Casas
    public BufferedImage   imgCasa1;
    public BufferedImage   imgCasa2;
    public BufferedImage   imgCasa3;
    public BufferedImage   imgCasa4;

    //Chafariz
    public BufferedImage   imgChafariz1;

    //Moita
    public BufferedImage   imgMoita;
    public BufferedImage   imgMoita2;
    public BufferedImage   imgMoita3;
    public BufferedImage   imgMoita4;

    //Cerca
    public BufferedImage   imgCerca;
    public BufferedImage   imgPoste;
    public BufferedImage   imgPoste2;



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

    // Cenario 4

    public BufferedImage imgBalcao;
    public BufferedImage imgLustre1;
    public BufferedImage imgLustre2;
    public BufferedImage imgLustre3;
    public BufferedImage imgMesaRedonda;
    public BufferedImage imgGlobo;
    public BufferedImage imgArvoreDecoracao;
    public BufferedImage imgCadeiraD;
    public BufferedImage imgCadeiraL;
    public BufferedImage imgCadeiraR;
    public BufferedImage imgCadeiraT;
    public BufferedImage imgMesaLateral;
    public BufferedImage imgQuadroC4;
    public BufferedImage imgQuadro1C4;
    public BufferedImage imgTeia1;
    public BufferedImage imgTeia2;
    public BufferedImage imgTeia3;
    public BufferedImage imgTeia4;
    public BufferedImage imgTeia5;
    public BufferedImage imgTrofeuDeCervo;
    public BufferedImage imgChaveItem;

    //Cenario6
    public BufferedImage imgLivro1;
    public BufferedImage imgLivro2;
    public BufferedImage imgLivro3;
    public BufferedImage imgLivro4;



    public GerenciadorSprites() {
        carregaImagensMundoExterior();
        carregaImagensBiblioteca();
        carregaObjetos();
        carregaImagensBibliotecaCenario4();
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

    private void carregaObjetos() {
        // CASAS
        imgCasa1           = carregarSheet(CAMINHO_C2_House_1);
        imgCasa2           = carregarSheet(CAMINHO_C2_House_2);
        imgCasa3           = carregarSheet(CAMINHO_C2_House_3);
        imgCasa4           = carregarSheet(CAMINHO_C2_House_4);
        // CHAFARIZ
        imgChafariz1       = carregarSheet(CAMINHO_C2_Chafariz_1);
        // MOITA
        imgMoita           = carregarSheet(CAMINHO_C2_Moita);
        imgMoita2           = carregarSheet(CAMINHO_C2_Moita2);
        imgMoita3           = carregarSheet(CAMINHO_C2_Moita3);
        imgMoita4           = carregarSheet(CAMINHO_C2_Moita4);
        // Cerca
        imgCerca          = carregarSheet(CAMINHO_C2_Cerca);
        imgPoste          = carregarSheet(CAMINHO_C2_Poste);
        imgPoste2          = carregarSheet(CAMINHO_C2_Poste2);

        //Livros
        imgLivro1 = carregarSheet(Caminho_Livro1);
        imgLivro2 = carregarSheet(Caminho_Livro2);
        imgLivro3 = carregarSheet(Caminho_Livro3);
        imgLivro4 = carregarSheet(Caminho_Livro4);
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

    private void carregaImagensBibliotecaCenario4() {
        imgBalcao = carregarSheet(Balcao);
        imgLustre1 = carregarSheet(Lustre1);
        imgLustre2 = carregarSheet(Lustre2);
        imgLustre3 = carregarSheet(Lustre3);
        imgMesaRedonda = carregarSheet(MesaRedonda);
        imgGlobo = carregarSheet(Globo);
        imgArvoreDecoracao = carregarSheet(ArvoreDecoracao);
        imgCadeiraD = carregarSheet(CadeiraD);
        imgCadeiraL = carregarSheet(CadeiraL);
        imgCadeiraR = carregarSheet(CadeiraR);
        imgCadeiraT = carregarSheet(CadeiraT);
        imgMesaLateral = carregarSheet(MesaLateral);
        imgQuadroC4 = carregarSheet(QuadroC4);
        imgQuadro1C4 = carregarSheet(Quadro1C4);
        imgTeia1 = carregarSheet(Teia1);
        imgTeia2 = carregarSheet(Teia2);
        imgTeia3 = carregarSheet(Teia3);
        imgTeia4 = carregarSheet(Teia4);
        imgTeia5 = carregarSheet(Teia5);
        imgTrofeuDeCervo = carregarSheet(TrofeuDeCervo);
        imgChaveItem = carregarSheet(ChaveItem);

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