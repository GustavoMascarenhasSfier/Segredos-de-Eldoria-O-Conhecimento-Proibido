package jogoBiblioteca;

/**
 * Representa um item do inventário do jogador.
 */
public class Item {

    private String nome;
    private String descricao;
    private int quantidade;

    public Item(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = 1;
    }

    public Item(String nome, String descricao, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public String getNome()        { return nome; }
    public String getDescricao()   { return descricao; }
    public int    getQuantidade()  { return quantidade; }

    public void adicionarQuantidade(int n) {
        this.quantidade += n;
    }

    public void removerQuantidade(int n) {
        this.quantidade = Math.max(0, this.quantidade - n);
    }

    @Override
    public String toString() {
        return nome + " (x" + quantidade + ")";
    }
}
