package jogoBiblioteca;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EscutadorTeclado implements KeyListener {

    // Movimento
    public boolean moverPraBaixo, moverPraCima, moverPraEsq, moverPraDir;

    // Inventário — Q: anterior  |  E: próximo  |  F: usar
    public boolean inventarioAnterior;
    public boolean inventarioProximo;
    public boolean inventarioUsar;

    // Quando true, ignora todas as teclas (ex: durante um dialog)
    private boolean pausado = false;
    private Runnable acaoEsc;

    public void pausar() {
        pausado = true;
        // Zera tudo imediatamente para o personagem parar
        moverPraBaixo = false;
        moverPraCima  = false;
        moverPraEsq   = false;
        moverPraDir   = false;
    }

    public void retomar() {
        pausado = false;
    }

    public void setAcaoEsc(Runnable acao) {
        this.acaoEsc = acao;
    }

    public boolean getMoverPraEsq()   { return moverPraEsq; }
    public boolean getMoverPraDir()   { return moverPraDir; }
    public boolean getMoverPraCima()  { return moverPraCima; }
    public boolean getMoverPraBaixo() { return moverPraBaixo; }

    @Override public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && acaoEsc != null) {
            acaoEsc.run();
            return;
        }

        if (pausado) return;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_A: moverPraEsq = true; break;
            case KeyEvent.VK_W: moverPraCima = true; break;
            case KeyEvent.VK_D: moverPraDir = true; break;
            case KeyEvent.VK_S: moverPraBaixo = true; break;

            case KeyEvent.VK_Q: inventarioAnterior = true; break;
            case KeyEvent.VK_E: inventarioProximo  = true; break;
            case KeyEvent.VK_F: inventarioUsar     = true; break;

            case KeyEvent.VK_V:
                tileMap.MOSTRAR_HITBOXES = !tileMap.MOSTRAR_HITBOXES;
                System.out.println("Hitboxes: " + tileMap.MOSTRAR_HITBOXES);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (pausado) return;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_A: moverPraEsq   = false; break;
            case KeyEvent.VK_W: moverPraCima  = false; break;
            case KeyEvent.VK_D: moverPraDir   = false; break;
            case KeyEvent.VK_S: moverPraBaixo = false; break;

            case KeyEvent.VK_Q: inventarioAnterior = false; break;
            case KeyEvent.VK_E: inventarioProximo  = false; break;
        }
    }
}
