package jogoBiblioteca.cenarios;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class CenarioBase {
    protected List<Rectangle> hitboxesObjetos = new ArrayList<>();

    public List<Rectangle> getHitboxesObjetos() {
        return hitboxesObjetos;
    }

    // Metodo que obriga cada cenário a definir seus próprios hitboxes
    protected abstract void inicializarHitboxes();

    // Percorre a lista de hitboxes para ver se o jogador encostou em algo
    public boolean colideComObjetos(Rectangle proximaAreaJogador) {
        for (Rectangle hitbox : hitboxesObjetos) {
            if (proximaAreaJogador.intersects(hitbox)) {
                return true;
            }
        }
        return false;
    }
}