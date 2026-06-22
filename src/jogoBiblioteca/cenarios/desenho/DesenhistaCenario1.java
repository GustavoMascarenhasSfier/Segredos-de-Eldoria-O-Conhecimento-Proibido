package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;
import jogoBiblioteca.cenarios.Cenario1;

public class DesenhistaCenario1 implements DesenhistaCenario {

    private static final int PE_ARV1_SUP_ESQ = -80  + 250;
    private static final int PE_ARV1_SUP_DIR = -60  + 270;
    private static final int PE_ARV1_INF_ESQ =  230 + 240;
    private static final int PE_ARV1_INF_DIR =  150 + 240;
    private static final int PE_ARV2_CENTRAL = -120 + 250;
    private static final int PE_ARV2_INF_ESQ =  120 + 270;
    private static final int PE_ARV2_INF_DIR =  240 + 270;

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgCasa != null)
            d2.drawImage(sprites.imgCasa, 467, -60, 200, 200, null);

        if (sprites.imgArvore1 != null)
            d2.drawImage(sprites.imgArvore1, 180, -170, 200, 250, null);

        if (sprites.imgGirassol != null) {
            d2.drawImage(sprites.imgGirassol, 150, 350, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 150,  40, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 500, 380, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 490, 130, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 700, 140, 40, 50, null);
        }

        if (sprites.bancos != null) {
            if (sprites.bancos[0] != null)
                d2.drawImage(sprites.bancos[0], 170, 50, 80, 60, null);
            if (sprites.bancos[1] != null)
                d2.drawImage(sprites.bancos[1], 397, 350, 50, 60, null);
        }

        if (sprites.imgEstatua != null)
            d2.drawImage(sprites.imgEstatua,
                    Cenario1.ESTATUA_X, Cenario1.ESTATUA_Y,
                    Cenario1.ESTATUA_W, Cenario1.ESTATUA_H, null);

        if (sprites.imgArvore1 != null) {
            d2.drawImage(sprites.imgArvore1, -20, -80,  230, 250, null); // arv1_sup_esq
            d2.drawImage(sprites.imgArvore1, 600, -60,  200, 270, null); // arv1_sup_dir
            d2.drawImage(sprites.imgArvore1, 120,  230, 230, 240, null); // arv1_inf_esq
            d2.drawImage(sprites.imgArvore1, 380,  150, 220, 240, null); // arv1_inf_dir
        }
        if (sprites.imgArvore2 != null) {
            d2.drawImage(sprites.imgArvore2, 340, -120, 180, 250, null); // arv2_central
            d2.drawImage(sprites.imgArvore2, -60,  120, 220, 270, null); // arv2_inf_esq
            d2.drawImage(sprites.imgArvore2, 580,  240, 220, 270, null); // arv2_inf_dir
        }
    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {
        if (sprites.imgEstatua != null && peJogador < Cenario1.ESTATUA_LINHA_Y)
            d2.drawImage(sprites.imgEstatua,
                    Cenario1.ESTATUA_X, Cenario1.ESTATUA_Y,
                    Cenario1.ESTATUA_W, Cenario1.ESTATUA_H, null);

        if (sprites.imgArvore1 != null) {
            if (peJogador < PE_ARV1_SUP_ESQ)
                d2.drawImage(sprites.imgArvore1, -20, -80,  230, 250, null);
            if (peJogador < PE_ARV1_SUP_DIR)
                d2.drawImage(sprites.imgArvore1, 600, -60,  200, 270, null);
            if (peJogador < PE_ARV1_INF_ESQ)
                d2.drawImage(sprites.imgArvore1, 120,  230, 230, 240, null);
            if (peJogador < PE_ARV1_INF_DIR)
                d2.drawImage(sprites.imgArvore1, 380,  150, 220, 240, null);
        }
        if (sprites.imgArvore2 != null) {
            if (peJogador < PE_ARV2_CENTRAL)
                d2.drawImage(sprites.imgArvore2, 340, -120, 180, 250, null);
            if (peJogador < PE_ARV2_INF_ESQ)
                d2.drawImage(sprites.imgArvore2, -60,  120, 220, 270, null);
            if (peJogador < PE_ARV2_INF_DIR)
                d2.drawImage(sprites.imgArvore2, 580,  240, 220, 270, null);
        }
    }
}