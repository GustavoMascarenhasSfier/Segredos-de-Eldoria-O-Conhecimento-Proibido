package jogoBiblioteca;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EscutadorTeclado implements KeyListener {

    // Movimento
    public boolean moverPraBaixo, moverPraCima, moverPraEsq, moverPraDir;

    // Inventário — Q: anterior  |  E: próximo  |  F: usar
    public boolean inventarioAnterior;  // Q
    public boolean inventarioProximo;   // E
    public boolean inventarioUsar;      // F

    public boolean getMoverPraEsq()   { return moverPraEsq; }
    public boolean getMoverPraDir()   { return moverPraDir; }
    public boolean getMoverPraCima()  { return moverPraCima; }
    public boolean getMoverPraBaixo() { return moverPraBaixo; }

    @Override public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            // Movimento
            case KeyEvent.VK_A: moverPraEsq = true; break;
            case KeyEvent.VK_W: moverPraCima = true; break;
            case KeyEvent.VK_D: moverPraDir = true; break;
            case KeyEvent.VK_S: moverPraBaixo = true; break;

            // Inventário
            case KeyEvent.VK_Q: inventarioAnterior = true; break;
            case KeyEvent.VK_E: inventarioProximo = true; break;
            case KeyEvent.VK_F: inventarioUsar = true; break;

            // Hitboxes
            case KeyEvent.VK_V:
                tileMap.MOSTRAR_HITBOXES = !tileMap.MOSTRAR_HITBOXES;
                System.out.println("Hitboxes: " + tileMap.MOSTRAR_HITBOXES);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
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
