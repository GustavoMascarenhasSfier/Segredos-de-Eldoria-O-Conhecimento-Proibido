package jogoBiblioteca;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Escuta eventos de teclado para movimento do jogador E controle do inventário. *
 * Teclas de movimento: W A S D
 * Teclas de inventário:
 *   Q  → seleciona slot anterior
 *   E  → seleciona próximo slot
 *   F  → "usa" o item selecionado (log no console; implemente a lógica desejada)
 *   Del / Backspace → descarta o item selecionado
 *
 * Itens de teste são adicionados automaticamente (remova quando tiver itens reais):
 *   1-8 → adiciona item de exemplo no inventário
 */
public class EscutadorTeclado implements KeyListener {

    public boolean moverPraBaixo, moverPraCima, moverPraEsq, moverPraDir;

    private Inventario inventario;
    private Painel painel; // para forçar repaint do painel Sul

    public EscutadorTeclado(Inventario inventario, Painel painel) {
        this.inventario = inventario;
        this.painel     = painel;
    }

    // ── Getters de movimento ──
    public boolean getMoverPraEsq()  { return moverPraEsq; }
    public boolean getMoverPraDir()  { return moverPraDir; }
    public boolean getMoverPraCima() { return moverPraCima; }
    public boolean getMoverPraBaixo(){ return moverPraBaixo; }

    @Override public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        switch (k) {
            // ── Movimento ──
            case KeyEvent.VK_A:
                moverPraEsq = true;
                break;
            case KeyEvent.VK_W:
                moverPraCima = true;
                break;
            case KeyEvent.VK_D:
                moverPraDir = true;
                break;
            case KeyEvent.VK_S:
                moverPraBaixo = true;
                break;

            // ── Navegação no inventário ──
            case KeyEvent.VK_Q:
                inventario.selecionarAnterior();
                Painel.atualizarPainelSul();
                break;
            case KeyEvent.VK_E:
                inventario.selecionarProximo();
                Painel.atualizarPainelSul();
                break;

            // ── Usar item ──
            case KeyEvent.VK_F:
                Inventario.Item sel = inventario.getItemSelecionado();
                if (sel != null) {
                    System.out.println("Usando item: " + sel.nome);
                    // TODO: implemente o efeito do item aqui
                }
                break;

            // ── Descartar item ──
            case KeyEvent.VK_DELETE:
            case KeyEvent.VK_BACK_SPACE:
                inventario.removerItem(inventario.getSlotSelecionado());
                Painel.atualizarPainelSul();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        switch (k) {
            case KeyEvent.VK_A: moverPraEsq  = false; break;
            case KeyEvent.VK_W: moverPraCima = false; break;
            case KeyEvent.VK_D: moverPraDir  = false; break;
            case KeyEvent.VK_S: moverPraBaixo= false; break;
        }
    }

}
