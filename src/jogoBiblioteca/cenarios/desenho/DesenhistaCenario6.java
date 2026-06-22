package jogoBiblioteca.cenarios.desenho;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import jogoBiblioteca.GerenciadorSprites;
import jogoBiblioteca.cenarios.Cenario3;
import jogoBiblioteca.cenarios.Cenario6;

/** Cenário 6 — Labirinto escuro com lanterna. */
public class DesenhistaCenario6 implements DesenhistaCenario {

    private Cenario6 cenario6ref;
    private Cenario3 cenario3ref;

    public void setCenario6(Cenario6 c6) {
        this.cenario6ref = c6;
    }

    public void setCenario3(Cenario3 c3) {
        this.cenario3ref = c3;
    }

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {
        if (cenario6ref == null) return;

        if (!cenario6ref.isLivro1Coletado()) {
            d2.drawImage(sprites.imgLivro1, 250, 402, 20, 20, null);
        }

        if (!cenario6ref.isLivro2Coletado()) {
            d2.drawImage(sprites.imgLivro2, 586, 154, 20, 20, null);
        }

        if (!cenario6ref.isLivro3Coletado()) {
            d2.drawImage(sprites.imgLivro3, 538, 402, 20, 20, null);
        }

        if (!cenario6ref.isLivro4Coletado()) {
            d2.drawImage(sprites.imgLivro4, 684, 402, 20, 20, null);
        }
    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador) {

    }

    public void desenharLanterna(Graphics2D d2, int centroX, int centroY) {
        if (cenario6ref == null) return;

        //Tela do jogador
        int largura = 768;
        int altura = 480;
        int raio = 120;
        int alpha = 255;

        // Cria uma imagem transparente, que sera a sombra
        BufferedImage sombra = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = sombra.createGraphics();

        // Cor do cenário
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, largura, altura);

        // Define os pontos do gradient da lanterna.
        // 0f é o centro da luz --> até 1f a borda da luz
        float[] distancias = {0f, 0.45f, 0.78f, 1f};

        // Define como a luz vai "furar" a escuridão.
        Color[] transparencia = {
                new Color(0, 0, 0, 255),
                new Color(0, 0, 0, 220),
                new Color(0, 0, 0, 80),
                new Color(0, 0, 0, 0)
        };

        if (cenario3ref != null && cenario3ref.isLanternaColetada()) {
            // Muda o modo de desenho para recortar a sombra.
            g.setComposite(AlphaComposite.DstOut);
            // Cria um gradient radial na posição do jogador.
            g.setPaint(new RadialGradientPaint(new Point2D.Float(centroX, centroY), raio, distancias, transparencia));
            g.fillOval(centroX - raio, centroY - raio, raio * 2, raio * 2);

        }
        d2.drawImage(sombra, 0, 0, null);
    }
}