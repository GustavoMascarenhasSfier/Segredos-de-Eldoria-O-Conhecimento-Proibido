package jogoBiblioteca;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import jogoBiblioteca.cenarios.*;
import jogoBiblioteca.cenarios.desenho.*;

public class tileMap {

    Tiles pecaDoCenario;
    GerenciadorSprites sprites;
    int[][] cenarioValido;

    // Referências para os mapas de tiles (usadas para trocar de cenário)
    public final int[][] cenario1DoJogo = Cenario1.MAPA;
    public final int[][] cenario2DoJogo = Cenario2.MAPA;
    public final int[][] cenario3DoJogo = Cenario3.MAPA;
    public final int[][] cenario4DoJogo = Cenario4.MAPA;
    public final int[][] cenario5DoJogo = Cenario5.MAPA;
    public final int[][] cenario6DoJogo = Cenario6.MAPA;
    public final int[][] cenario7DoJogo = Cenario7.MAPA;

    // Mapa de desenhistas: cada int[][] aponta para seu desenhista
    private final Map<int[][], DesenhistaCenario> desenhistas = new HashMap<>();

    public tileMap() {
        this.cenarioValido = this.cenario1DoJogo;
        this.sprites = new GerenciadorSprites();
        this.pecaDoCenario = new Tiles();

        // Registra um desenhista para cada cenário
        desenhistas.put(cenario1DoJogo, new DesenhistaCenario1());
        desenhistas.put(cenario2DoJogo, new DesenhistaCenario2());
        desenhistas.put(cenario3DoJogo, new DesenhistaCenario3());
        desenhistas.put(cenario4DoJogo, new DesenhistaCenario4());
        desenhistas.put(cenario5DoJogo, new DesenhistaCenario5());
        desenhistas.put(cenario6DoJogo, new DesenhistaCenario6());
        desenhistas.put(cenario7DoJogo, new DesenhistaCenario7());
    }

    /** Desenha os tiles do mapa + elementos de fundo do cenário atual. */
    public void desenharChaoECasas(Graphics2D d2) {
        // 1. Tiles da matriz
        for (int lin = 0; lin < cenarioValido.length; lin++) {
            for (int col = 0; col < cenarioValido[0].length; col++) {
                pecaDoCenario.carregaPecaDaMatriz(cenarioValido[lin][col]);
                pecaDoCenario.desenhaTile(d2, lin, col);
            }
        }

        // 2. Elementos extras de fundo do cenário atual
        DesenhistaCenario desenhista = desenhistas.get(cenarioValido);
        if (desenhista != null) {
            desenhista.desenharFundo(d2, sprites);
        }
    }

    /** Desenha elementos que ficam na frente do player (ex: topos de árvore). */
    public void desenharArvoresDoTopo(Graphics2D d2) {
        // Mantido por compatibilidade com o Painel.
        // O topo (fundo) já é desenhado em desenharChaoECasas().
    }

    /** Desenha elementos sobrepostos ao player. */
    public void desenharArvoresDeBaixo(Graphics2D d2) {
        DesenhistaCenario desenhista = desenhistas.get(cenarioValido);
        if (desenhista != null) {
            desenhista.desenharFrente(d2, sprites);
        }
    }
}
