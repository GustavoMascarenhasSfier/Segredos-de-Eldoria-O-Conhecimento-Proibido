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

        if (Direcao.equals("cima"))          proximaAreaJogador.y -= Jogador.passo;
        else if (Direcao.equals("baixo"))    proximaAreaJogador.y += Jogador.passo;
        else if (Direcao.equals("direita"))  proximaAreaJogador.x += Jogador.passo;
        else if (Direcao.equals("esquerda")) proximaAreaJogador.x -= Jogador.passo;

        // ==================== CENÁRIO 1 ====================
        if (CenaDoJogo.cenarioValido == CenaDoJogo.cenario1DoJogo) {
            Rectangle tronco1          = new Rectangle(85, 280, 40, 30);
            Rectangle tronco3          = new Rectangle(50, 390, 60, 40);
            Rectangle tronco4          = new Rectangle(610, 390, 100, 50);
            Rectangle tronco2          = new Rectangle(365, 80, 50, 25);
            Rectangle troncoNovaArvore = new Rectangle(435, 130, 42, 25);
            Rectangle troncoGrande1    = new Rectangle(215, 340, 40, 30);
            Rectangle troncoGrande2    = new Rectangle(475, 370, 50, 40);
            Rectangle troncoGrande3    = new Rectangle(100, 160, 50, 34);
            Rectangle troncoGrande4    = new Rectangle(640, 170, 90, 40);
            Rectangle hitboxCasa       = new Rectangle(480, 40, 170, 90);
            Rectangle hitboxBau        = new Rectangle(300, 35, 800, 50);

            if (proximaAreaJogador.intersects(tronco1)           ||
                    proximaAreaJogador.intersects(tronco2)           ||
                    proximaAreaJogador.intersects(troncoNovaArvore)  ||
                    proximaAreaJogador.intersects(tronco3)           ||
                    proximaAreaJogador.intersects(tronco4)           ||
                    proximaAreaJogador.intersects(troncoGrande1)     ||
                    proximaAreaJogador.intersects(troncoGrande2)     ||
                    proximaAreaJogador.intersects(troncoGrande3)     ||
                    proximaAreaJogador.intersects(troncoGrande4)     ||
                    proximaAreaJogador.intersects(hitboxCasa)         ||
                    proximaAreaJogador.intersects(hitboxBau)) {
                this.colidiu = true;
                return colidiu;
            }
        }

        // ==================== CENÁRIO 3 — BIBLIOTECA ====================

        if (CenaDoJogo.cenarioValido == CenaDoJogo.cenario3DoJogo) {

            Rectangle hitboxLareira = new Rectangle(320, 88, 108, 48);

            Rectangle hitboxPiano = new Rectangle(106, 72, 74, 52);

            Rectangle hitboxQuadro = new Rectangle(158, 58, 42, 21);

            Rectangle estanteEsqTopo = new Rectangle(103, 183, 82, 60);

            Rectangle estanteEsqBaixo = new Rectangle(103, 328, 82, 60);

            Rectangle estanteDirTopo = new Rectangle(505, 183, 82, 60);

            Rectangle estanteDirBaixo = new Rectangle(505, 328, 82, 60);

            Rectangle estanteTopoDireita = new Rectangle(455, 90, 105, 52);

            Rectangle hitboxMesaCentral = new Rectangle(343, 232, 81, 70);

            Rectangle hitboxMesaPequena = new Rectangle(121, 292, 61, 47);

            if (
                    proximaAreaJogador.intersects(hitboxLareira) ||
                            proximaAreaJogador.intersects(hitboxPiano) ||
                            proximaAreaJogador.intersects(hitboxQuadro) ||
                            proximaAreaJogador.intersects(estanteEsqTopo) ||
                            proximaAreaJogador.intersects(estanteEsqBaixo) ||
                            proximaAreaJogador.intersects(estanteDirTopo) ||
                            proximaAreaJogador.intersects(estanteDirBaixo) ||
                            proximaAreaJogador.intersects(estanteTopoDireita) ||
                            proximaAreaJogador.intersects(hitboxMesaCentral) ||
                            proximaAreaJogador.intersects(hitboxMesaPequena)
            ) {

                this.colidiu = true;
                return colidiu;
            }
        }

        // ==================== COLISÃO POR TILE (todos os cenários) ====================
        int tamanhoTile = 48;

        if (Direcao.equals("cima")) {
            int colEsq  = Jogador.AreaColisao.x / tamanhoTile;
            int colDir  = (Jogador.AreaColisao.x + Jogador.AreaColisao.width - 1) / tamanhoTile;
            int rowTopo = (Jogador.AreaColisao.y - Jogador.passo) / tamanhoTile;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopo][colEsq]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopo][colDir]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }
        else if (Direcao.equals("baixo")) {
            int colEsq  = Jogador.AreaColisao.x / tamanhoTile;
            int colDir  = (Jogador.AreaColisao.x + Jogador.AreaColisao.width - 1) / tamanhoTile;
            int rowBase = (Jogador.AreaColisao.y + Jogador.AreaColisao.height + Jogador.passo) / tamanhoTile;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBase][colEsq]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBase][colDir]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }
        else if (Direcao.equals("direita")) {
            int colDir  = (Jogador.AreaColisao.x + Jogador.AreaColisao.width + Jogador.passo) / tamanhoTile;
            int rowTopo = Jogador.AreaColisao.y / tamanhoTile;
            int rowBase = (Jogador.AreaColisao.y + Jogador.AreaColisao.height - 1) / tamanhoTile;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopo][colDir]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBase][colDir]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }
        else if (Direcao.equals("esquerda")) {
            int colEsq  = (Jogador.AreaColisao.x - Jogador.passo) / tamanhoTile;
            int rowTopo = Jogador.AreaColisao.y / tamanhoTile;
            int rowBase = (Jogador.AreaColisao.y + Jogador.AreaColisao.height - 1) / tamanhoTile;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopo][colEsq]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBase][colEsq]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }

        return colidiu;
    }
}
