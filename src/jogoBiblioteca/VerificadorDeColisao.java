package jogoBiblioteca;

public class VerificadorDeColisao {

    private int colEsqX;
    private int colDirX;
    private int rowTopoY;
    private int rowBaseY;
    private boolean colidiu;

    public VerificadorDeColisao() {
    }

    public boolean OcorreuDeColisao(Player Jogador, tileMap CenaDoJogo, String Direcao) {
        colidiu = false;

        int bordaEsqX = (int)Jogador.AreaColisao.getX();
        int bordaDirX = (int)Jogador.AreaColisao.getX() + (int)Jogador.AreaColisao.getWidth();
        int bordaTopoY = (int)Jogador.AreaColisao.getY();
        int bordaBaseY = (int)Jogador.AreaColisao.getY() + (int)Jogador.AreaColisao.getHeight();

        this.colEsqX = (int)bordaEsqX/48;
        this.colDirX = (int)bordaDirX/48;
        this.rowTopoY = (int)bordaTopoY/48;
        this.rowBaseY = (int)bordaBaseY/48;

        if (Direcao.equals("cima")) {
            int prox_rowTopoY = (bordaTopoY - Jogador.passo)/48;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[prox_rowTopoY][colEsqX]);
            if (CenaDoJogo.pecaDoCenario.isColisao())
                this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[prox_rowTopoY][colDirX]);
            if (CenaDoJogo.pecaDoCenario.isColisao())
                this.colidiu = true;
        }
        else if (Direcao.equals("baixo")) {
            int prox_rowBaseY = (bordaBaseY + Jogador.passo)/48;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[prox_rowBaseY][colEsqX]);
            if (CenaDoJogo.pecaDoCenario.isColisao())
                this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[prox_rowBaseY][colDirX]);
            if (CenaDoJogo.pecaDoCenario.isColisao())
                this.colidiu = true;
        }
        else if (Direcao == "direita") {
            int prox_colDirX = (bordaDirX + Jogador.passo)/48;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopoY][prox_colDirX]);
            if (CenaDoJogo.pecaDoCenario.isColisao())
                this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBaseY][prox_colDirX]);
            if (CenaDoJogo.pecaDoCenario.isColisao())
                this.colidiu = true;
        }
        else if (Direcao == "esquerda") {
            int prox_colEsqX = (bordaEsqX - Jogador.passo)/48;
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopoY][prox_colEsqX]);
            if (CenaDoJogo.pecaDoCenario.isColisao())
                this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBaseY][prox_colEsqX]);
            if (CenaDoJogo.pecaDoCenario.isColisao())
                this.colidiu = true;
        } else {
            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowTopoY][colEsqX]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;

            CenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(CenaDoJogo.cenarioValido[rowBaseY][colDirX]);
            if (CenaDoJogo.pecaDoCenario.isColisao()) this.colidiu = true;
        }

        return colidiu;
    }
}