package jogoBiblioteca;

import java.awt.Graphics2D;

public class tileMap {

    Tiles pecaDoCenario;
    GerenciadorSprites sprites;
    int[][] cenarioValido;

    int [][] cenario1DoJogo = {
            {0,0,3,3,0,0,3,0,3,0,0,3,0,0,3,0},
            {3,10,9,8,10,9,9,6,10,8,9,10,8,8,9,0},
            {0,6,8,1,1,1,1,1,14,8,8,10,1,10,9,3},
            {3,8,10,1,4,4,4,1,1,14,8,1,13,9,8,0},
            {3,6,9,1,4,5,4,1,1,1,1,1,1,14,8,3},
            {0,9,8,1,4,4,4,1,1,1,1,1,1,1,12,12},
            {0,8,9,1,1,1,1,1,1,1,1,15,10,15,8,0},
            {3,9,8,9,8,10,8,1,13,10,8,8,10,10,6,0},
            {0,10,8,10,9,8,1,1,15,9,10,9,8,9,8,3},
            {0,0,3,0,0,3,3,0,3,0,0,3,0,0,3,3}
    };
    int [][] cenario2DoJogo = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,5,5,5,8,9,10,11,8,9,10,5,5,5,5,0},
            {0,5,4,5,8,9,1,4,4,1,10,5,5,5,5,0},
            {0,5,5,5,8,9,1,1,1,1,10,5,5,5,5,0},
            {0,8,9,10,11,8,1,4,4,1,9,10,11,8,9,0},
            {1,1,1,1,1,1,1,4,4,1,10,11,8,9,10,0},
            {0,11,8,9,10,11,1,1,1,1,8,9,10,11,8,0},
            {0,5,5,5,9,10,1,4,4,1,11,8,5,5,5,0},
            {0,8,9,10,11,8,1,1,1,1,9,10,11,8,9,0},
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
                d2.drawImage(sprites.arvores[2], 180, -170, 200, 250, null); // Arvores esquerda superior
                d2.drawImage(sprites.baus[0], 270, 35, 140, 50, null);
            }
            // -------------------------- GIRASSOL------------------
            if (sprites.imgGirassol != null) {
                d2.drawImage(sprites.imgGirassol, 150, 350, 40, 50, null);
                d2.drawImage(sprites.imgGirassol, 150, 40, 40, 50, null);
                d2.drawImage(sprites.imgGirassol, 500, 380, 40, 50, null);
                d2.drawImage(sprites.imgGirassol, 490, 130, 40, 50, null);
                d2.drawImage(sprites.imgGirassol, 700, 140, 40, 50, null);

            }

        }
    }

    public void desenharArvoresDoTopo(Graphics2D d2) {
        if (cenarioValido == cenario1DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[1], 280, -120, 250, 250, null);
            d2.drawImage(sprites.arvores[2], -20, -40, 200, 250, null); // Arvores esquerda superior
            d2.drawImage(sprites.arvores[2], 600, 10, 170, 200, null);
        }

        //-------------------------------------------------------------
        // CENARIO 2
        //-------------------------------------------------------------


        else if (cenarioValido == cenario2DoJogo && sprites != null) {
            d2.drawImage(sprites.imgCasa1, 30, 10, 180, 180, null);
            d2.drawImage(sprites.imgCasa2, 530, 10, 180, 180, null);
        }
    }

    public void desenharArvoresDeBaixo(Graphics2D d2) {
        if (cenarioValido == cenario1DoJogo && sprites != null) {
            // ------------------------------- Esquerda ---------------------------------

            d2.drawImage(sprites.arvores[2], 180, 250, 150, 180, null); // Primeira arvore da Esquerda inferior
            d2.drawImage(sprites.arvores[1], -60, 80, 200, 250, null); // Arvore do meio esquerda
            d2.drawImage(sprites.arvores[1], -60, 200, 250, 300, null); // Arvore do canto esquero inferior

            // -------------------------------- DIREITA --------------------------------
            d2.drawImage(sprites.arvores[2], 420, 180, 150, 200, null); // Primeira arvore da Direita inferior
            d2.drawImage(sprites.arvores[1], 560, 190, 200, 250, null); // Segunda arvore da Direita inferior
        }
        //-------------------------------------------------------------
        // CENARIO 2
        //-------------------------------------------------------------

        else if (cenarioValido == cenario2DoJogo && sprites != null) {

        }

        //-------------------------------------------------------------
        // CENARIO 3
        //-------------------------------------------------------------


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