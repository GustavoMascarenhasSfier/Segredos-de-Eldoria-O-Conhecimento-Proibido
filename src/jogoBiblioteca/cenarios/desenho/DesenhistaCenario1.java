package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/**
 * Cenário 1 — Mundo exterior.
 * Contém: casa, baú, árvores de topo e de baixo.
 */
public class DesenhistaCenario1 implements DesenhistaCenario {

    @Override
    public void desenharFundo(Graphics2D d2, GerenciadorSprites sprites) {
        if (sprites.imgCasa != null)
            d2.drawImage(sprites.imgCasa, 467, -60, 200, 200, null);

        if (sprites.baus != null && sprites.baus[0] != null)
            d2.drawImage(sprites.baus[0], 270, 35, 140, 50, null);

        // Árvores que ficam atrás do player (topo da tela)
        if (sprites.arvores != null) {
            d2.drawImage(sprites.arvores[1], 290, -80, 200, 200, null);
            d2.drawImage(sprites.arvores[1], 370, -10, 170, 170, null);
            d2.drawImage(sprites.arvores[2],  79,  50,  96, 144, null);
            d2.drawImage(sprites.arvores[2], 600,  10, 170, 200, null);
        }
    }

    @Override
    public void desenharFrente(Graphics2D d2, GerenciadorSprites sprites) {
        // Árvores que ficam na frente do player (parte inferior)
        if (sprites.arvores != null) {
            d2.drawImage(sprites.arvores[1],  70, 210,  70, 100, null);
            d2.drawImage(sprites.arvores[1],  30, 260, 100, 170, null);
            d2.drawImage(sprites.arvores[1], 560, 190, 200, 250, null);
            d2.drawImage(sprites.arvores[2], 200, 270,  70, 100, null);
            d2.drawImage(sprites.arvores[2], 450, 270, 100, 140, null);
        }
    }
}
