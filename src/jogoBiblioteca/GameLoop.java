package jogoBiblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameLoop extends Thread implements Runnable, ActionListener {

    final int FPS = 60;
    private Timer controleDoTempoDoJogo;
    private long contadorDeFPS;

    private Painel cenaDoJogo;
    private PainelSul painelSul;
    private EscutadorTeclado et;

    // Debounce — impede que segurar a tecla navegue vários slots por segundo
    private boolean anteriorProcessado = false;
    private boolean proximoProcessado  = false;
    private boolean usarProcessado     = false;

    public GameLoop(Painel cenaDoJogo, PainelSul painelSul, EscutadorTeclado eT) {
        System.out.println("GameLoop instanciado!");
        this.cenaDoJogo = cenaDoJogo;
        this.painelSul  = painelSul;
        this.et         = eT;
    }

    public void setPainelSul(PainelSul ps) {
        this.painelSul = ps;
    }

    @Override
    public void run() {
        this.contadorDeFPS = 0;
        this.controleDoTempoDoJogo = new Timer(1000, this);
        this.controleDoTempoDoJogo.start();

        double frameRate = 1000000000.0 / this.FPS;
        double tempoDecorrido = 0;
        long tempoUltimaMedida = System.nanoTime();

        while (this.isAlive()) {
            long agora = System.nanoTime();
            tempoDecorrido += (agora - tempoUltimaMedida) / frameRate;
            tempoUltimaMedida = agora;

            if (tempoDecorrido >= 1) {

                if (cenaDoJogo == null || cenaDoJogo.jogador == null || cenaDoJogo.cenario == null) {
                    tempoDecorrido = 0;
                    continue;
                }

                // ── MOVIMENTO ─────────────────────────────────────────────
                String direcao = "";
                if (et.moverPraCima)       direcao = "cima";
                else if (et.moverPraBaixo) direcao = "baixo";
                else if (et.moverPraDir)   direcao = "direita";
                else if (et.moverPraEsq)   direcao = "esquerda";
                cenaDoJogo.jogador.atualizaSprite(direcao);
                VerificadorDeColisao colisao = new VerificadorDeColisao();
                boolean bateu = colisao.OcorreuDeColisao(
                        cenaDoJogo.jogador,
                        cenaDoJogo.cenario,
                        direcao
                );
                if (!bateu) {
                    cenaDoJogo.jogador.atualizaPosicaoJogador(direcao);

                    // ✔️ AQUI É ONDE A TRANSIÇÃO ACONTECE
                    cenaDoJogo.cenario.verificarTransicao(cenaDoJogo.jogador);
                }

                // ── INVENTÁRIO ────────────────────────────────────────────
                Inventario inv = cenaDoJogo.inventario;
                boolean mudouInventario = false;

                if (et.inventarioAnterior && !anteriorProcessado) {
                    inv.selecionarAnterior();
                    anteriorProcessado = true;
                    mudouInventario = true;
                }
                if (!et.inventarioAnterior) anteriorProcessado = false;

                if (et.inventarioProximo && !proximoProcessado) {
                    inv.selecionarProximo();
                    proximoProcessado = true;
                    mudouInventario = true;
                }
                if (!et.inventarioProximo) proximoProcessado = false;

                if (et.inventarioUsar && !usarProcessado) {
                    inv.removerItem(inv.getSlotSelecionado());
                    usarProcessado = true;
                    mudouInventario = true;
                }
                if (!et.inventarioUsar) usarProcessado = false;

                // ── INTERAGIR (tecla R) — pegar/depositar item no cenário ─────
                if (et.interagir && !cenaDoJogo.cenario.isInteracaoProcessada()) {
                    cenaDoJogo.cenario.processarInteracao(cenaDoJogo.jogador, inv);
                    cenaDoJogo.cenario.setInteracaoProcessada(true);
                    mudouInventario = true;
                }
                if (!et.interagir) cenaDoJogo.cenario.setInteracaoProcessada(false);

                if (mudouInventario && painelSul != null)
                    painelSul.repaint();

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