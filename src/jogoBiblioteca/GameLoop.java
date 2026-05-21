package jogoBiblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameLoop extends Thread implements Runnable, ActionListener {

    private int FPS = 60;
    private Timer controleDoTempoDoJogo;
    private long contadorDeFPS;

    private Painel cenaDoJogo;
    private EscutadorTeclado et;

    public GameLoop(Painel cenaDoJogo, EscutadorTeclado eT) {
        System.out.println("GameLoop instanciado!");
        this.cenaDoJogo = cenaDoJogo;
        this.et = eT;
    }

    @Override
    public void run() {

        this.contadorDeFPS = 0;
        this.controleDoTempoDoJogo = new Timer(1000, this);
        this.controleDoTempoDoJogo.start();

        double frameRate = 1000000000.0 / this.FPS;
        double tempoDecorrido = 0;

        long tempoUltimaMedidaDoLoop = System.nanoTime();
        long tempoAtualDoLoop;

        while (this.isAlive()) {

            tempoAtualDoLoop = System.nanoTime();
            tempoDecorrido += (tempoAtualDoLoop - tempoUltimaMedidaDoLoop) / frameRate;
            tempoUltimaMedidaDoLoop = tempoAtualDoLoop;

            if (tempoDecorrido >= 1) {

                String direcao = "";
                if (et.moverPraCima)       direcao = "cima";
                else if (et.moverPraBaixo) direcao = "baixo";
                else if (et.moverPraDir)   direcao = "direita";
                else if (et.moverPraEsq)   direcao = "esquerda";

                VerificadorDeColisao colisao = new VerificadorDeColisao();
                boolean bateu = colisao.OcorreuDeColisao(this.cenaDoJogo.jogador, this.cenaDoJogo.cenario,direcao);
                System.out.println("colisao " + bateu);

                if (bateu == false) {
                    cenaDoJogo.jogador.atualizaPosicaoJogador(et.moverPraEsq,et.moverPraCima,et.moverPraDir, et.moverPraBaixo);
                }

                cenaDoJogo.repaint();
                this.contadorDeFPS++;
                tempoDecorrido = 0;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("FPS GameLoop: " + this.contadorDeFPS);
        contadorDeFPS = 0;
    }
}
