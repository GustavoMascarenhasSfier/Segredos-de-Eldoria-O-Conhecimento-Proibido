package jogoBiblioteca;

import java.awt.Rectangle;

public class VerificadorDeColisao {

    private boolean colidiu;

    public VerificadorDeColisao() {
    }

    public boolean OcorreuDeColisao(Player Jogador, tileMap CenaDoJogo, String Direcao) {
        colidiu = false;

        // Cria a área de previsão de movimento do jogador
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
        else return true;

        // ==================== COLISÃO POR OBJETOS DO CENÁRIO ====================
        if (CenaDoJogo.cenarioAtualInstancia != null) {
            if (CenaDoJogo.cenarioAtualInstancia.colideComObjetos(proximaAreaJogador)) {
                this.colidiu = true;
                return colidiu;
            }
        }

        // ==================== COLISÃO POR TILE (Grid/Piso) ====================
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