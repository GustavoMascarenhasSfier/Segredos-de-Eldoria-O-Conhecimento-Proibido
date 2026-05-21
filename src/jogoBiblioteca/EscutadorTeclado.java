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
            case 37: //esqueda
                this.moverPraEsq = true;
                break;
            case 38: //cima
                this.moverPraCima = true;
                break;
            case 39: //direita
                this.moverPraDir = true;
                break;
            case 40: //baixo
                this.moverPraBaixo = true;
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int numTecla = e.getKeyCode();

        switch(numTecla) {
            case 37:
                this.moverPraEsq = false;
                break;
            case 38:
                this.moverPraCima = false;
                break;
            case 39:
                this.moverPraDir = false;
                break;
            case 40:
                this.moverPraBaixo = false;
                break;
        }
    }

}
