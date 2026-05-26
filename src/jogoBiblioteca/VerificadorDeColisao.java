package jogoBiblioteca;

import java.awt.Rectangle;

public class VerificadorDeColisao {

    private boolean colidiu;

    public VerificadorDeColisao() {
    }

    public boolean OcorreuDeColisao(Player Jogador, tileMap CenaDoJogo, String Direcao) {
        colidiu = false;

        Rectangle proximaAreaJogador = new Rectangle(
                Jogador.AreaColisao.x,
                Jogador.AreaColisao.y,
                Jogador.AreaColisao.width,
                Jogador.AreaColisao.height
        );

        if (Direcao.equals("cima"))         proximaAreaJogador.y -= Jogador.passo;
        else if (Direcao.equals("baixo"))   proximaAreaJogador.y += Jogador.passo;
        else if (Direcao.equals("direita"))  proximaAreaJogador.x += Jogador.passo;
        else if (Direcao.equals("esquerda")) proximaAreaJogador.x -= Jogador.passo;

        if (CenaDoJogo.cenarioValido == CenaDoJogo.cenario1DoJogo) {

            // ---------------- ÁRVORES PEQUENAS ----------------

            // Árvore inferior esquerda
            Rectangle tronco1 = new Rectangle(40, 280, 40, 30);

            // Árvore inutilizada
            Rectangle tronco3 = new Rectangle(0, 0, 0, 0);

            // Árvore inferior direita
            Rectangle tronco4 = new Rectangle(630, 390, 100, 50);

            // Árvore superior central
            Rectangle tronco2 = new Rectangle(365, 90, 80, 25);


            // ---------------- ÁRVORES GRANDES ----------------

            // Primeira árvore inferior esquerda
            Rectangle troncoGrande1 = new Rectangle(220, 400, 70, 30);

            // Primeira árvore inferior direita
            Rectangle troncoGrande2 = new Rectangle(460, 340, 60, 40);

            // Árvore superior esquerda
            Rectangle troncoGrande3 = new Rectangle(70, 150, 50, 50);

            // Árvore atrás do baú
            Rectangle troncoGrande5 = new Rectangle(240, 20, 50, 50);

            // Árvore superior direita
            Rectangle troncoGrande4 = new Rectangle(640, 170, 40, 40);


            // ---------------- OBJETOS ----------------

            // Casa
            Rectangle hitboxCasa = new Rectangle(480, 40, 170, 90);

            // Baú
            Rectangle hitboxBau = new Rectangle(300, 35, 800, 50);

            // Estátua
            Rectangle hitboxEstatua = new Rectangle(215, 210, 80, 40);


            // ---------------- COLISÃO ----------------

            if (proximaAreaJogador.intersects(tronco1) ||
                    proximaAreaJogador.intersects(tronco2) ||
                    proximaAreaJogador.intersects(tronco3) ||
                    proximaAreaJogador.intersects(tronco4) ||
                    proximaAreaJogador.intersects(troncoGrande5) ||
                    proximaAreaJogador.intersects(troncoGrande1) ||
                    proximaAreaJogador.intersects(troncoGrande2) ||
                    proximaAreaJogador.intersects(troncoGrande3) ||
                    proximaAreaJogador.intersects(troncoGrande4) ||
                    proximaAreaJogador.intersects(hitboxCasa) ||
                    proximaAreaJogador.intersects(hitboxBau) ||
                    proximaAreaJogador.intersects(hitboxEstatua)
            ) {

                this.colidiu = true;

                return colidiu;
            }
        }

        int tamanhoTile = 48;
        if (Direcao.equals("cima")) {
            int bordaEsqX = Jogador.AreaColisao.x;
            int bordaDirX = Jogador.AreaColisao.x + Jogador.AreaColisao.width - 1;
            int bordaTopoY = Jogador.AreaColisao.y - Jogador.passo;

            int colEsq = bordaEsqX / tamanhoTile;
            int colDir = bordaDirX / tamanhoTile;
            int rowTopo = bordaTopoY / tamanhoTile;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopo][colEsq]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopo][colDir]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }
        else if (Direcao.equals("baixo")) {
            int bordaEsqX = Jogador.AreaColisao.x;
            int bordaDirX = Jogador.AreaColisao.x + Jogador.AreaColisao.width - 1;
            int bordaBaseY = Jogador.AreaColisao.y + Jogador.AreaColisao.height + Jogador.passo;

            int colEsq = bordaEsqX / tamanhoTile;
            int colDir = bordaDirX / tamanhoTile;
            int rowBase = bordaBaseY / tamanhoTile;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBase][colEsq]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBase][colDir]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }
        else if (Direcao.equals("direita")) {
            int bordaDirX = Jogador.AreaColisao.x + Jogador.AreaColisao.width + Jogador.passo;
            int bordaTopoY = Jogador.AreaColisao.y;
            int bordaBaseY = Jogador.AreaColisao.y + Jogador.AreaColisao.height - 1;

            int colDir = bordaDirX / tamanhoTile;
            int rowTopo = bordaTopoY / tamanhoTile;
            int rowBase = bordaBaseY / tamanhoTile;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopo][colDir]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBase][colDir]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }
        else if (Direcao.equals("esquerda")) {
            int bordaEsqX = Jogador.AreaColisao.x - Jogador.passo;
            int bordaTopoY = Jogador.AreaColisao.y;
            int bordaBaseY = Jogador.AreaColisao.y + Jogador.AreaColisao.height - 1;

            int colEsq = bordaEsqX / tamanhoTile;
            int rowTopo = bordaTopoY / tamanhoTile;
            int rowBase = bordaBaseY / tamanhoTile;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopo][colEsq]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBase][colEsq]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }

        return colidiu;
    }
}