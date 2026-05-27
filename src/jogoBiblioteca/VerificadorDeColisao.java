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

        // ==================== CENÁRIO 3 — BIBLIOTECA ====================
        if (CenaDoJogo.cenarioValido == CenaDoJogo.cenario3DoJogo) {

            // Lareira — sprite: x=312, y=-20, w=144, h=148 → parte visível começa em y=0
            Rectangle hitboxLareira = new Rectangle(318, 0, 132, 110);

            // Piano — sprite: x=88, y=42, w=126, h=90
            Rectangle hitboxPiano = new Rectangle(90, 70, 120, 60);

            // Estante lateral esquerda — sprite: x=-10, y=110, w=48, h=150
            Rectangle estanteLateralCima  = new Rectangle(0, 110, 20, 150);

             // Estante lateral esquerda — sprite: x=-10, y=300, w=48, h=150
            Rectangle estanteLateralBaixo = new Rectangle(0, 300, 20, 150);

            // Estante esquerda topo — sprite: x=96, y=166, w=96, h=90
            Rectangle estanteEsqTopo = new Rectangle(96, 185, 96, 34);

            // Estantes superiores direita — sprites: x=470,y=50 e x=550,y=50, w=96, h=90
            Rectangle estanteTopoDirEsq  = new Rectangle(470, 90, 96, 50);
            Rectangle estanteTopoDirDir  = new Rectangle(550, 90, 96, 50);

            // Estantes direita meio — sprites: x=510,y=200 e x=590,y=200, w=96, h=90
            Rectangle estanteDirMeioEsq  = new Rectangle(510, 220, 96, 34);
            Rectangle estanteDirMeioDir  = new Rectangle(590, 220, 96, 34);

            // Estantes direita baixo — sprites: x=510,y=350 e x=590,y=350, w=96, h=90
            Rectangle estanteDirBaixoEsq = new Rectangle(510, 368, 96, 34);
            Rectangle estanteDirBaixoDir = new Rectangle(590, 368, 96, 34);

            // Mesa central redonda — sprite: x=332, y=200, w=100, h=90
            Rectangle hitboxMesaCentral = new Rectangle(337, 215, 90, 65);

            // Mesinha pequena — sprite: x=105, y=305, w=80, h=72
            Rectangle hitboxMesaPequena = new Rectangle(108, 318, 72, 52);

            if (
                    proximaAreaJogador.intersects(hitboxLareira)     ||
                            proximaAreaJogador.intersects(hitboxPiano)       ||
                            proximaAreaJogador.intersects(estanteLateralCima)  ||
                            proximaAreaJogador.intersects(estanteLateralBaixo)||
                            proximaAreaJogador.intersects(estanteEsqTopo)    ||
                            proximaAreaJogador.intersects(hitboxPiano)       ||
                            proximaAreaJogador.intersects(estanteTopoDirEsq) ||
                            proximaAreaJogador.intersects(estanteTopoDirDir) ||
                            proximaAreaJogador.intersects(estanteDirMeioEsq) ||
                            proximaAreaJogador.intersects(estanteDirMeioDir) ||
                            proximaAreaJogador.intersects(estanteDirBaixoEsq)||
                            proximaAreaJogador.intersects(estanteDirBaixoDir)||
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