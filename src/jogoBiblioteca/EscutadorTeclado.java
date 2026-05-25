package jogoBiblioteca;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EscutadorTeclado implements KeyListener {
    public boolean moverPraBaixo, moverPraCima, moverPraEsq, moverPraDir;

    public boolean getMoverPraEsq() {
        return moverPraEsq;
    }

    public boolean getMoverPraDir() {
        return moverPraDir;
    }

    public boolean getMoverPraCima() {
        return moverPraCima;
    }

    public boolean getMoverPraBaixo() {
        return moverPraBaixo;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int numTecla = e.getKeyCode();

        switch(numTecla) {
            case KeyEvent.VK_A: // Tecla A (esquerda)
                this.moverPraEsq = true;
                break;
            case KeyEvent.VK_W: // Tecla W (cima)
                this.moverPraCima = true;
                break;
            case KeyEvent.VK_D: // Tecla D (direita)
                this.moverPraDir = true;
                break;
            case KeyEvent.VK_S: // Tecla S (baixo)
                this.moverPraBaixo = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int numTecla = e.getKeyCode();

        switch(numTecla) {
            case KeyEvent.VK_A: // Tecla A (esquerda)
                this.moverPraEsq = false;
                break;
            case KeyEvent.VK_W: // Tecla W (cima)
                this.moverPraCima = false;
                break;
            case KeyEvent.VK_D: // Tecla D (direita)
                this.moverPraDir = false;
                break;
            case KeyEvent.VK_S: // Tecla S (baixo)
                this.moverPraBaixo = false;
                break;
        }
    }
}