package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/**
 * Interface que todo "desenhista de cenário" deve implementar.
 */
public interface DesenhistaCenario {

    /**
     * Desenha elementos do cenário que ficam no fundo.
     */
    void desenharFundo(Graphics2D d2, GerenciadorSprites sprites);

    /**
     * Desenha os elementos da frente utilizando a linha do pé do jogador.
     */
    void desenharFrente(Graphics2D d2, GerenciadorSprites sprites, int peJogador);
}