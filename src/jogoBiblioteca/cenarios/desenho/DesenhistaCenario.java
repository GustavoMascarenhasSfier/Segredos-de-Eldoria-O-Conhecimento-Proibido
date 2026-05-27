package jogoBiblioteca.cenarios.desenho;

import java.awt.Graphics2D;
import jogoBiblioteca.GerenciadorSprites;

/**
 * Interface que todo "desenhista de cenário" deve implementar.
 * Cada cenário que precisar de sprites/objetos extras além dos tiles
 * terá sua própria classe aqui.
 */
public interface DesenhistaCenario {

    /**
     * Desenha elementos do cenário que ficam ATRÁS do player
     * (chão, móveis, decoração de fundo).
     */
    void desenharFundo(Graphics2D d2, GerenciadorSprites sprites);

    /**
     * Desenha elementos do cenário que ficam NA FRENTE do player
     * (topos de árvores, elementos sobrepostos).
     */
    void desenharFrente(Graphics2D d2, GerenciadorSprites sprites);
}
