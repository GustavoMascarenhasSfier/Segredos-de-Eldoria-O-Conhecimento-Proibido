package jogoBiblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia a lista de itens do jogador.
 * Capacidade padrão: 8 slots visíveis (um por célula no painel Sul).
 */
public class Inventario {

    public static final int CAPACIDADE = 5;

    private List<Item> itens;
    private int slotSelecionado = 0;

    public Inventario() {
        itens = new ArrayList<>();

        // Itens de exemplo — remova ou substitua conforme o jogo
        itens.add(new Item("livro",  "livro curta de ferro",     1));
    }

    // ── Acesso ────────────────────────────────────────────────────────────────

    public int getQuantidade()           { return itens.size(); }
    public Item getItem(int index)       { return (index >= 0 && index < itens.size()) ? itens.get(index) : null; }
    public int  getSlotSelecionado()     { return slotSelecionado; }
    public void setSlotSelecionado(int s){ if (s >= 0 && s < CAPACIDADE) slotSelecionado = s; }

    // ── Mutação ───────────────────────────────────────────────────────────────

    /**
     * Adiciona um item. Se já existir item de mesmo nome empilha a quantidade.
     * @return true se adicionado, false se inventário cheio
     */
    public boolean adicionarItem(Item novoItem) {
        for (Item i : itens) {
            if (i.getNome().equalsIgnoreCase(novoItem.getNome())) {
                i.adicionarQuantidade(novoItem.getQuantidade());
                return true;
            }
        }
        if (itens.size() >= CAPACIDADE) return false;
        itens.add(novoItem);
        return true;
    }

    /**
     * Remove uma unidade do item no slot informado.
     * Remove o item da lista quando chegar a 0.
     */
    public void removerItem(int index) {
        Item item = getItem(index);
        if (item == null) return;
        item.removerQuantidade(1);
        if (item.getQuantidade() <= 0) itens.remove(index);
    }

    // Navegar slots com teclas [ e ]
    public void selecionarAnterior() {
        slotSelecionado = Math.max(0, slotSelecionado - 1);
    }

    public void selecionarProximo() {
        slotSelecionado = Math.min(CAPACIDADE - 1, slotSelecionado + 1);
    }
}
