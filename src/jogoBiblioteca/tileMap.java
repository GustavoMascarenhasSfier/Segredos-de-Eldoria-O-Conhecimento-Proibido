package jogoBiblioteca;

import java.awt.Graphics2D;

public class tileMap {

    Tiles pecaDoCenario;
    GerenciadorSprites sprites;
    int[][] cenarioValido;

    int [][] cenario1DoJogo = {
            {0,0,3,3,0,0,3,0,3,0,0,3,0,0,3,0},
            {3,10,9,8,10,9,9,6,10,8,9,10,8,8,9,0},
            {0,6,8,1,1,1,1,1,1,8,8,10,1,10,9,3},
            {3,8,10,1,1,1,1,1,1,1,8,1,1,9,8,0},
            {3,6,9,1,1,5,1,1,1,1,1,1,1,1,8,3},
            {0,9,8,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,8,9,1,1,1,1,1,1,1,1,1,10,1,8,0},
            {3,9,8,9,8,10,8,1,1,10,8,8,10,10,6,0},
            {0,10,8,10,9,8,1,1,1,9,10,9,8,9,8,3},
            {0,0,3,0,0,3,3,0,3,0,0,3,0,0,3,3}
    };

    public tileMap() {
        this.cenarioValido = this.cenario1DoJogo;
        this.sprites = new GerenciadorSprites();
        this.pecaDoCenario = new Tiles();
    }

    // ------------------------- MAPA BASE -------------------------

    public void desenharCenario(Graphics2D d2) {

        int pecaDaMatriz;

        for (int lin = 0; lin < this.cenarioValido.length; lin++) {

            for (int col = 0; col < this.cenarioValido[0].length; col++) {

                pecaDaMatriz = this.cenarioValido[lin][col];

                this.pecaDoCenario.carregaPecaDaMatriz(pecaDaMatriz);

                this.pecaDoCenario.desenhaTile(d2, lin, col);
            }
        }

        // ---------------- CASA ----------------

        if (sprites.imgCasa != null) {
            d2.drawImage(sprites.imgCasa, 467, -60, 200, 200, null);
        }

        // ---------------- ÁRVORE ATRÁS DO BAÚ ----------------

        d2.drawImage(sprites.arvores[2], 180, -170, 200, 250, null);

        // ---------------- BAÚ ----------------

        if (sprites.baus != null && sprites.baus[0] != null) {
            d2.drawImage(sprites.baus[0], 270, 35, 140, 50, null);
        }

        // ---------------- GIRASSOL ----------------

        if (sprites.imgGirassol != null) {

            d2.drawImage(sprites.imgGirassol, 150, 350, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 150, 40, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 500, 380, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 490, 130, 40, 50, null);
            d2.drawImage(sprites.imgGirassol, 700, 140, 40, 50, null);
        }

        // ---------------- BANCOS ----------------

        if (sprites.bancos != null) {

            if (sprites.bancos[0] != null) {
                d2.drawImage(sprites.bancos[0], 170, 50, 80, 60, null);
            }

            if (sprites.bancos[1] != null) {
                d2.drawImage(sprites.bancos[1], 397, 350, 50, 60, null);
            }
        }
    }

    // ------------------ ÁRVORES DO TOPO ------------------

    public void desenharArvoresTopo(Graphics2D d2) {

        if (sprites.arvores != null) {

            // Árvore central do topo
            d2.drawImage(sprites.arvores[1], 280, -120, 250, 250, null);

            // Árvore canto superior esquerdo
            d2.drawImage(sprites.arvores[2], -20, -40, 200, 250, null);

            // Árvore canto superior direito
            d2.drawImage(sprites.arvores[2], 600, 10, 170, 200, null);

        }
    }

    // ------------------ ESTÁTUA ------------------

    public void desenharEstatua(Graphics2D d2) {

        if (sprites.imgEstatua != null) {

            d2.drawImage(sprites.imgEstatua, 200, 90, 110, 170, null);
        }
    }

    // ------------------ DECORAÇÕES DA FRENTE ------------------

    public void desenharDecoracoesFrente(Graphics2D d2) {

        if (sprites.arvores != null) {

            // ---------------- ÁRVORES INFERIORES ESQUERDA ----------------

            // Primeira árvore inferior esquerda
            d2.drawImage(sprites.arvores[2], 180, 250, 150, 180, null);

            // Árvore meio esquerda
            d2.drawImage(sprites.arvores[1], -60, 80, 200, 250, null);

            // Árvore canto inferior esquerdo
            d2.drawImage(sprites.arvores[1], -60, 200, 250, 300, null);

            // ---------------- ÁRVORES INFERIORES DIREITA ----------------

            // Primeira árvore inferior direita
            d2.drawImage(sprites.arvores[2], 420, 180, 150, 200, null);

            // Segunda árvore inferior direita
            d2.drawImage(sprites.arvores[1], 560, 190, 200, 250, null);

            // PILAR

            if (sprites.imgPilar != null) {

                d2.drawImage(sprites.imgPilar, 650, 180, 60, 60, null);
            }
        }
    }
}