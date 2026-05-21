package jogoBiblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SpriteLoop extends Thread implements Runnable, ActionListener{
    private int FPS = 5;
    private Timer ControleDoTempoDoJogo;
    private long contadorDeFPS;
    private Painel cenaDoJogo;
    private EscutadorTeclado ET;

    public SpriteLoop(Painel P, EscutadorTeclado eT) {
        System.out.println("Sprite Instanciado");
        this.cenaDoJogo = P;
        this.ET = eT;

    }

    public void run() {

        this.contadorDeFPS = 0;
        this.ControleDoTempoDoJogo = new Timer(1000, this);
        this.ControleDoTempoDoJogo.start();

        double frameRate = 1000000000.0 / this.FPS;
        double tempoDecorrido = 0;

        long tempoUltimaMedidaDoLoop = System.nanoTime();
        long tempoAtualDoLoop;

        while (this.isAlive()) {

            tempoAtualDoLoop = System.nanoTime();
            tempoDecorrido += (tempoAtualDoLoop - tempoUltimaMedidaDoLoop) / frameRate;
            tempoUltimaMedidaDoLoop = tempoAtualDoLoop;

            if (tempoDecorrido >= 1) {
                cenaDoJogo.repaint();
                contadorDeFPS++;
                tempoDecorrido = 0;
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("FPS Sprite:" + this.contadorDeFPS);
        this.contadorDeFPS = 0;
    }

}

