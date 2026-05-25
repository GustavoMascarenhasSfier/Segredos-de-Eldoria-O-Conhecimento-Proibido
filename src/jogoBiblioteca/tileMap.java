package jogoBiblioteca;

import java.awt.Graphics2D;

public class tileMap {

    Tiles pecaDoCenario;
    GerenciadorSprites sprites;
    int[][] cenarioValido;

    int [][] cenario1DoJogo = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,10,9,8,10,9,9,6,10,8,9,10,8,8,9,0},
            {0,6,8,1,1,1,1,1,1,8,8,10,1,10,9,0},
            {0,8,10,1,4,4,4,1,1,1,8,1,1,9,8,0},
            {0,6,9,1,4,5,4,1,1,1,1,1,1,1,8,0},
            {0,9,8,1,4,4,4,1,1,1,1,1,1,1,1,1},
            {0,8,9,1,1,1,1,1,1,1,1,1,10,1,8,0},
            {0,9,8,9,8,10,8,1,1,10,8,8,10,10,6,0},
            {0,10,8,10,9,8,1,1,1,9,10,9,8,9,8,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    int [][] cenario2DoJogo = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,5,5,5,3,3,3,3,3,3,3,3,5,5,5,0},
            {0,5,4,5,3,3,1,4,4,1,3,3,5,4,5,0},
            {0,5,5,5,3,3,1,1,1,1,3,3,5,5,5,0},
            {0,3,3,3,3,3,1,4,4,1,3,3,3,3,3,0},
            {1,1,1,1,1,1,1,4,4,1,3,3,3,3,3,0},
            {0,3,3,3,3,3,1,1,1,1,3,3,3,3,3,0},
            {0,5,5,5,3,3,1,4,4,1,3,3,5,5,5,0},
            {0,3,3,3,3,3,1,1,1,1,3,3,3,3,3,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}
    };
    int [][] cenario3DoJogo = {
            {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
            {0,4,4,4,4,4,4,1,1,4,4,4,4,4,4,0},
            {0,4,5,5,5,4,1,1,1,1,4,5,5,5,4,0},
            {0,4,5,4,5,4,1,4,4,1,4,5,4,5,4,1},
            {0,4,5,5,5,4,1,4,4,1,4,5,5,5,4,0},
            {0,4,4,4,4,4,1,1,1,1,4,4,4,4,4,0},
            {0,4,5,5,5,4,1,4,4,1,4,5,5,5,4,0},
            {0,4,4,4,4,4,1,1,1,1,4,4,4,4,4,0},
            {0,4,4,4,4,4,4,1,1,4,4,4,4,4,4,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}
    };
    int [][] cenario4DoJogo = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,4,4,4,1,1,1,0,0,1,1,1,4,4,4,0},
            {0,4,5,4,1,4,1,1,1,1,4,1,4,5,4,0},
            {1,1,1,1,1,4,4,0,0,4,4,1,1,1,1,0},
            {0,0,0,1,4,4,1,1,1,1,4,4,1,0,0,0},
            {0,1,1,1,4,5,1,4,4,1,5,4,1,1,1,0},
            {0,4,5,4,1,4,1,1,1,1,4,1,4,5,4,0},
            {0,4,4,4,1,1,1,0,0,1,1,1,4,4,4,0},
            {0,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    int [][] cenario5DoJogo = {
            {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
            {0,4,4,4,4,4,4,1,1,4,4,4,4,4,4,0},
            {0,4,5,5,5,5,5,1,1,5,5,5,5,5,4,0},
            {0,4,5,1,1,1,1,1,1,1,1,1,5,5,4,0},
            {0,4,5,1,4,4,4,4,4,4,4,1,1,1,1,1},
            {0,4,5,1,1,1,1,1,1,1,1,1,5,5,4,0},
            {0,4,5,5,5,5,5,5,5,5,5,5,5,5,4,0},
            {0,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0},
            {0,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    int [][] cenario6DoJogo = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0},
            {0,4,5,5,5,5,5,1,1,5,5,5,5,5,4,0},
            {0,4,5,4,4,4,1,1,1,1,4,4,4,5,4,0},
            {1,1,1,1,1,1,1,4,4,1,1,1,4,5,4,0},
            {0,4,5,4,1,4,4,5,5,4,4,1,4,5,4,0},
            {0,4,5,4,1,1,1,4,4,1,1,1,4,5,4,0},
            {0,4,5,5,5,5,1,1,1,1,5,5,5,5,4,0},
            {0,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    int [][] cenario7DoJogo = {
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1},
            {0,1,1,1,1,1,1,1,1,2,2,2,1,1,0,0},
            {1,1,1,1,1,1,1,1,1,0,3,3,3,2,2,0},
            {0,1,0,0,1,1,1,1,1,1,3,3,3,3,1,0},
            {0,1,1,1,1,1,1,1,1,3,3,3,3,3,1,0},
            {0,1,1,1,1,3,3,2,3,2,2,2,1,1,1,0},
            {0,1,1,1,1,3,3,2,3,2,2,2,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,0,3,3,3,2,2,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,3,0,0,0}
    };

    public tileMap() {
        this.cenarioValido = this.cenario1DoJogo;
        this.sprites = new GerenciadorSprites();
        this.pecaDoCenario = new Tiles();
    }

    public void desenharChaoECasas(Graphics2D d2) {
        int pecaDaMatriz;

        for (int lin = 0; lin < this.cenarioValido.length; lin++) {
            for (int col = 0; col < this.cenarioValido[0].length; col++) {
                pecaDaMatriz = this.cenarioValido[lin][col];
                this.pecaDoCenario.carregaPecaDaMatriz(pecaDaMatriz);
                this.pecaDoCenario.desenhaTile(d2, lin, col);
            }
        }

        if (cenarioValido == cenario1DoJogo && sprites != null) {

            // -------------------------- CASA -------------------------------------
            if (sprites.imgCasa != null) {
                d2.drawImage(sprites.imgCasa, 467, -60, 200, 200, null);
            }

            // -------------------------- BAÚ ------------------
            if (sprites.baus != null && sprites.baus[0] != null) {
                // Desenha o baú com tamanho 48x48 para caber certinho em um bloco do cenário
                d2.drawImage(sprites.baus[0], 270, 35, 140, 50, null);
            }
        }
    }

    // Subistitua na sua classe tileMap:
    public void desenharArvoresDoTopo(Graphics2D d2) {
        if (cenarioValido == cenario1DoJogo && sprites != null) {
            // Apenas as árvores que ficam na parte de cima da tela (Y menor que 150)
            d2.drawImage(sprites.arvores[1], 290, -80, 200, 200, null);
            d2.drawImage(sprites.arvores[1], 370, -10, 170, 170, null);
            d2.drawImage(sprites.arvores[2], 79, 50, 96, 144, null);
            d2.drawImage(sprites.arvores[2], 600, 10, 170, 200, null);
        }
    }

    public void desenharArvoresDeBaixo(Graphics2D d2) {
        if (cenarioValido == cenario1DoJogo && sprites != null) {
            // Todas as outras árvores que ficam no meio/inferior da tela
            d2.drawImage(sprites.arvores[1], 70, 210, 70, 100, null);
            d2.drawImage(sprites.arvores[1], 30, 260, 100, 170, null);
            d2.drawImage(sprites.arvores[1], 560, 190, 200, 250, null);
            d2.drawImage(sprites.arvores[2], 200, 270, 70, 100, null);
            d2.drawImage(sprites.arvores[2], 450, 270, 100, 140, null);
        }
        // Mantém a renderização padrão dos outros cenários que você já tinha:
        else if (cenarioValido == cenario2DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[1], 300, 150, 72, 108, null);
        }
        else if (cenarioValido == cenario3DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[0], 100, 250, 48, 72, null);
            d2.drawImage(sprites.arvores[2], 400, 100, 96, 144, null);
        }
        else if (cenarioValido == cenario4DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[2], 600, 200, 96, 144, null);
        }
        else if (cenarioValido == cenario5DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[1], 250, 300, 72, 108, null);
        }
        else if (cenarioValido == cenario6DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[0], 350, 120, 48, 72, null);
        }
        else if (cenarioValido == cenario7DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[2], 500, 250, 96, 144, null);
        }
    }
}