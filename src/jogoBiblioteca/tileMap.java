package jogoBiblioteca;

import java.awt.Graphics2D;

public class tileMap {

    Tiles pecaDoCenario;
    GerenciadorSprites sprites;
    int[][] cenarioValido;

    // Tile 48x48px | Tela 768x480 | Grade 16 cols x 10 linhas
    // 0=parede(colisão) 1=areia(passável) 4=white/piso(passável) 5=cinza(colisão)

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

    // =========================================================
    //  CENÁRIO 3 — Interior da Biblioteca
    //  Tile 48x48px | 16 cols (0-15) x 10 linhas (0-9)
    //
    //  0 = parede (colisão)
    //  1 = areia  (passável — corredor entrada/saída)
    //  4 = piso branco (passável — interior)
    //  5 = cinza  (colisão — área de móvel)
    // =========================================================
    int [][] cenario3DoJogo = {
            //   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
            /* 0*/ {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            /* 1*/ {0, 4, 4, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 4, 0},
            /* 2*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 3*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 4*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 5*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 6*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 7*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 8*/ {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0},
            /* 9*/ {0, 4, 4, 4, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
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
        this.cenarioValido = this.cenario3DoJogo;
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
            if (sprites.imgCasa != null)
                d2.drawImage(sprites.imgCasa, 467, -60, 200, 200, null);
            if (sprites.baus != null && sprites.baus[0] != null)
                d2.drawImage(sprites.baus[0], 270, 35, 140, 50, null);
        }

        if (cenarioValido == cenario3DoJogo && sprites != null) {
            desenharInteriorBiblioteca(d2);
        }
    }

    // POSICIONAMENTO — cenário 3
    private void desenharInteriorBiblioteca(Graphics2D d2) {
        final int T = 48;

        // 1. CHÃO — tile chao.png repetido em todo o interior (linhas 1-7, cols 1-14)

        if (sprites.imgChaoBiblioteca != null) {
            for (int lin = 0; lin <= 9; lin++) {
                for (int col = 0; col <= 14; col++) {
                    d2.drawImage(sprites.imgChaoBiblioteca, col * T, lin * T, T, T, null);
                }
            }
        }

        // 2. PAREDE DECORADA — topo, atrás da lareira

        if (sprites.imgParede != null) {
            d2.drawImage(sprites.imgParede, 0, 0, 288, 96, null);
            d2.drawImage(sprites.imgParede, 286, 0, 288, 96, null);
            d2.drawImage(sprites.imgParede, 565, 0, 288, 96, null);

            d2.drawImage(sprites.imgEstanteLateral, -10, 110, 48, 150, null);
            d2.drawImage(sprites.imgEstanteLateral, -10, 300, 48, 150, null);


        }

        // 3. LAREIRA — topo-centro, sobre a parede decorada

        if (sprites.imgLareira != null) {
            d2.drawImage(sprites.imgLareira, 312, -20, 144, 148, null);
        }

        // 4. BANDEIRAS — nas paredes laterais (decoração)

        if (sprites.imgBandeira != null) {
            d2.drawImage(sprites.imgBandeira,   8, 20, 38, 72, null);  // parede esquerda
            d2.drawImage(sprites.imgBandeira, 722, 20, 38, 72, null);  // parede direita
        }

        if (sprites.imgBicho1 != null && sprites.imgBicho2 != null) {
            d2.drawImage(sprites.imgBicho1,   50, 20, 48, 48, null);
            d2.drawImage(sprites.imgBicho2, 670, 20, 48, 48, null);
        }


        // 5. PIANO — topo-esquerda (cols 1-2, linha 1-2)

        if (sprites.imgPiano != null) {
            d2.drawImage(sprites.imgPiano, 88, 42, 126, 90, null);
        }

        // 6. QUADRO — ao lado do piano (col 3, linha 1)

        if (sprites.imgQuadro != null) {
            d2.drawImage(sprites.imgQuadro, 105, 0, 100, 50, null);
        }

        // 7. ESTANTES CHEIAS — 4 unidades
        if (sprites.imgEstanteCheia != null) {
            d2.drawImage(sprites.imgEstante,  96, 166, 96, 90, null);
            d2.drawImage(sprites.imgEstanteCheia,  550, 50, 96, 90, null);
            d2.drawImage(sprites.imgEstanteCheia,  470, 50, 96, 90, null);

            d2.drawImage(sprites.imgEstante,  590, 350, 96, 90, null);
            d2.drawImage(sprites.imgEstante,  510, 350, 96, 90, null);

            d2.drawImage(sprites.imgEstante,  590, 200, 96, 90, null);
            d2.drawImage(sprites.imgEstante,  510, 200, 96, 90, null);



        }

        // 8. TAPETE DA MESA CENTRAL — embaixo da mesa redonda
        if (sprites.imgTapete != null) {
            d2.drawImage(sprites.imgTapete, 288, 195, 192, 124, null);
        }
        // 10. CADEIRAS — ao redor da mesa central
        if (sprites.imgCadeiraCima != null) {
            // Acima da mesa (desenhada antes para ficar atrás)
            d2.drawImage(sprites.imgCadeiraCima, 340, 178, 31, 42, null);
            d2.drawImage(sprites.imgCadeiraCima, 390, 178, 31, 42, null);
        }
        if (sprites.imgCadeiraBaixo != null) {
            // Abaixo da mesa
            d2.drawImage(sprites.imgCadeiraBaixo, 335, 276, 41, 44, null);
            d2.drawImage(sprites.imgCadeiraBaixo, 382, 276, 41, 44, null);
        }
        if (sprites.imgCadeiraEsquerda != null) {
            // À esquerda da mesa
            d2.drawImage(sprites.imgCadeiraEsquerda, 300, 220, 44, 54, null);
        }
        if (sprites.imgCadeiraDireita != null) {
            // À direita da mesa
            d2.drawImage(sprites.imgCadeiraDireita, 420, 220, 44, 50, null);
        }

        // 9. MESA CENTRAL REDONDA — centro da sala
        if (sprites.imgMesaCentro != null) {
            d2.drawImage(sprites.imgMesaCentro, 332, 200, 100, 90, null);
        }
        // 9. velas CENTRAL REDONDA — centro da sala

        if (sprites.imgVelas != null){
            d2.drawImage(sprites.imgVelas, 359, 210, 44, 40, null);

        }

        // 9. Livro Aberto da mesa  CENTRAL REDONDA — centro da sala

        if (sprites.imgLivroFechado != null){
            d2.drawImage(sprites.imgLivroAberto, 365, 250, 30, 20, null);

        }

        // 11. TAPETE DA MESINHA VERDE — canto inferior esquerdo
        if (sprites.imgTapete2 != null) {
            d2.drawImage(sprites.imgTapete2, 100, 320, 96, 62, null);
        }

        // 12. MESINHA VERDE + CADEIRAS — canto inferior esquerdo
        if (sprites.imgCadeiraCima != null) {
            d2.drawImage(sprites.imgCadeiraCima,    127, 275, 36, 44, null);
        }
        if (sprites.imgCadeiraBaixo != null) {
            d2.drawImage(sprites.imgCadeiraBaixo,   127, 360, 36, 38, null);
        }
        if (sprites.imgCadeiraEsquerda != null) {
            d2.drawImage(sprites.imgCadeiraEsquerda, 80, 320, 38, 48, null);
        }
        if (sprites.imgCadeiraDireita != null) {
            d2.drawImage(sprites.imgCadeiraDireita, 170, 320, 38, 48, null);
        }

        if (sprites.imgMesaCentro != null) {
            d2.drawImage(sprites.imgMesaCentro, 105, 305, 80, 72, null);
        }

        if (sprites.imgLivroFechado != null){
            d2.drawImage(sprites.imgLivroFechado, 130, 320, 30, 30, null);

        }

        // 12. MESINHA livro inferior
        if (sprites.imgMesaLivro != null) {
            d2.drawImage(sprites.imgMesaLivro,    127, 420, 126, 60, null);
        }
        // 12. tapetes entradas
        if (sprites.imgTapeteInferior != null) {
            d2.drawImage(sprites.imgTapeteInferior,    250, 400, 220, 80, null);
        }
        if (sprites.imgTapeteLateral != null) {
            d2.drawImage(sprites.imgTapeteLateral,    -20, 239, 100, 80, null);
            d2.drawImage(sprites.imgTapeteLateral,    660, 85, 60, 70, null);

        }


    }


    public void desenharArvoresDoTopo(Graphics2D d2) {
        if (cenarioValido == cenario1DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[1], 290, -80, 200, 200, null);
            d2.drawImage(sprites.arvores[1], 370, -10, 170, 170, null);
            d2.drawImage(sprites.arvores[2],  79,  50,  96, 144, null);
            d2.drawImage(sprites.arvores[2], 600,  10, 170, 200, null);
        }
    }

    public void desenharArvoresDeBaixo(Graphics2D d2) {
        if (cenarioValido == cenario1DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[1],  70, 210,  70, 100, null);
            d2.drawImage(sprites.arvores[1],  30, 260, 100, 170, null);
            d2.drawImage(sprites.arvores[1], 560, 190, 200, 250, null);
            d2.drawImage(sprites.arvores[2], 200, 270,  70, 100, null);
            d2.drawImage(sprites.arvores[2], 450, 270, 100, 140, null);
        }
        else if (cenarioValido == cenario2DoJogo && sprites != null) {
            d2.drawImage(sprites.arvores[1], 300, 150, 72, 108, null);
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
