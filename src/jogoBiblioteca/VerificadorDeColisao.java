package jogoBiblioteca;

import java.awt.Rectangle;

public class VerificadorDeColisao {

    private boolean colidiu;

    public VerificadorDeColisao() {
    }

    public boolean OcorreuDeColisao(Player Jogador, tileMap CenaDoJogo, String Direcao) {
        colidiu = false;

        // --- 1. SEU SISTEMA DE RETÂNGULOS FIXOS ---
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
            // Árvores Médias
            Rectangle tronco1 = new Rectangle(85, 280, 40, 30);
            Rectangle tronco3 = new Rectangle(50, 390, 60, 40);
            Rectangle tronco4 = new Rectangle(610, 390, 100, 50);

            // ---  ÁRVORES GRANDES DO LADO DO BAÚ  ---
            Rectangle tronco2 = new Rectangle(365, 80, 50, 25);
            Rectangle troncoNovaArvore = new Rectangle(435, 130, 42, 25);


            // Outras Árvores Grandes
            Rectangle troncoGrande1 = new Rectangle(215, 340, 40, 30);
            Rectangle troncoGrande2 = new Rectangle(475, 370, 50, 40);
            Rectangle troncoGrande3 = new Rectangle(100, 160, 50, 34);
            Rectangle troncoGrande4 = new Rectangle(640, 170, 90, 40);

            // Estruturas
            Rectangle hitboxCasa = new Rectangle(480, 40, 170, 90);
            Rectangle hitboxBau = new Rectangle(300, 35, 800, 50);

            if (proximaAreaJogador.intersects(tronco1) ||
                    proximaAreaJogador.intersects(tronco2) ||
                    proximaAreaJogador.intersects(troncoNovaArvore) ||
                    proximaAreaJogador.intersects(tronco3) ||
                    proximaAreaJogador.intersects(tronco4) ||
                    proximaAreaJogador.intersects(troncoGrande1) ||
                    proximaAreaJogador.intersects(troncoGrande2) ||
                    proximaAreaJogador.intersects(troncoGrande3) ||
                    proximaAreaJogador.intersects(troncoGrande4) ||
                    proximaAreaJogador.intersects(hitboxCasa) ||
                    proximaAreaJogador.intersects(hitboxBau)) {

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