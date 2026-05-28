package jogoBiblioteca;

import java.awt.Graphics2D;

public class RenderizadorCena {

    public void renderizar(Graphics2D g2, tileMap cenario, Player jogador) {
        // Calcula a base do jogador (linha do pé)
        int pe = jogador.AreaColisao.y + jogador.AreaColisao.height;

        // 1. Renderiza o chão e estruturas básicas de fundo (casas, bancos, baús)
        cenario.desenharChaoECasas(g2);

        // 2. Desenha o Jogador
        jogador.DesenharPlayer(g2);

        // 3. Renderiza os elementos da frente (Estátua, árvores e pilares)
        cenario.desenharElementosFrente(g2, pe);
    }
}