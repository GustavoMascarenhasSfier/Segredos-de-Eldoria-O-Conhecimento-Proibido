package jogoBiblioteca;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import jogoBiblioteca.cenarios.*;
import jogoBiblioteca.cenarios.desenho.*;

public class tileMap {

    Tiles pecaDoCenario;
    GerenciadorSprites sprites;
    int[][] cenarioValido;

    public static boolean MOSTRAR_HITBOXES = false;

    public CenarioBase cenarioAtualInstancia;

    // SPAWN DO PLAYER
    private int spawnX = 0;
    private int spawnY = 0;

    // MAPAS
    public final int[][] cenario1DoJogo = Cenario1.MAPA;
    public final int[][] cenario2DoJogo = Cenario2.MAPA;
    public final int[][] cenario3DoJogo = Cenario3.MAPA;
    public final int[][] cenario4DoJogo = Cenario4.MAPA;
    public final int[][] cenario5DoJogo = Cenario5.MAPA;
    public final int[][] cenario6DoJogo = Cenario6.MAPA;
    public final int[][] cenario7DoJogo = Cenario7.MAPA;

    private final Map<int[][], DesenhistaCenario> desenhistas = new HashMap<>();

    public tileMap() {

        this.sprites = new GerenciadorSprites();
        this.pecaDoCenario = new Tiles();

        desenhistas.put(cenario1DoJogo, new DesenhistaCenario1());
        desenhistas.put(cenario2DoJogo, new DesenhistaCenario2());
        desenhistas.put(cenario3DoJogo, new DesenhistaCenario3());
        desenhistas.put(cenario4DoJogo, new DesenhistaCenario4());
        desenhistas.put(cenario5DoJogo, new DesenhistaCenario5());
        desenhistas.put(cenario6DoJogo, new DesenhistaCenario6());
        desenhistas.put(cenario7DoJogo, new DesenhistaCenario7());

        // CENÁRIO INICIAL
        mudarCenario(2);
    }

    // =========================
    // TROCA DE CENÁRIO
    // =========================
    public void mudarCenario(int numeroCenario) {

        switch (numeroCenario) {

            case 1:
                cenarioValido = cenario1DoJogo;
                cenarioAtualInstancia = new Cenario1();

                spawnX = 700;//posiocao fixa de cada cenario para verificar passagem
                spawnY = 220;//posiocao fixa de cada cenario para verificar passagem
                break;

            case 2:
                cenarioValido = cenario2DoJogo;
                cenarioAtualInstancia = new Cenario2();

                spawnX = 20;
                spawnY = 190;
                break;

            case 3:
                cenarioValido = cenario3DoJogo;
                cenarioAtualInstancia = new Cenario3();

                spawnX = 100;
                spawnY = 200;
                break;

            case 4:
                cenarioValido = cenario4DoJogo;

                spawnX = 200;
                spawnY = 200;
                break;

            case 5:
                cenarioValido = cenario5DoJogo;

                spawnX = 200;
                spawnY = 200;
                break;

            case 6:
                cenarioValido = cenario6DoJogo;

                spawnX = 200;
                spawnY = 200;
                break;

            case 7:
                cenarioValido = cenario7DoJogo;

                spawnX = 200;
                spawnY = 200;
                break;
        }
    }

    // =========================
    // TRANSIÇÃO
    // =========================
    public void verificarTransicao(Player jogador) {

        if (cenarioAtualInstancia instanceof Cenario1) {

            if (jogador.getX() >= 720) {

                mudarCenario(2);
                jogador.teleportar(spawnX, spawnY);
            }

            // volta do CENÁRIO 2
            if (jogador.getY() >= 432) {

                mudarCenario(2);
                jogador.teleportar(spawnX, spawnY);
            }
        }

        else if (cenarioAtualInstancia instanceof Cenario2) {

            // volta pro CENÁRIO 1 (esquerda)
            if (jogador.getX() <= 0) {

                mudarCenario(1);
                jogador.teleportar(spawnX, spawnY);
            }

            if (jogador.getY() >= 432) {

                mudarCenario(1);
                jogador.teleportar(spawnX, spawnY);
            }
        }
    }

    // =========================
    // HITBOX
    // =========================
    public void desenharHitboxes(Graphics2D g2) {

        if (!MOSTRAR_HITBOXES || cenarioAtualInstancia == null)
            return;

        g2.setColor(new Color(255, 0, 0, 100));

        for (Rectangle r : cenarioAtualInstancia.getHitboxesObjetos()) {
            g2.fillRect(r.x, r.y, r.width, r.height);
        }

        g2.setColor(Color.RED);

        for (Rectangle r : cenarioAtualInstancia.getHitboxesObjetos()) {
            g2.drawRect(r.x, r.y, r.width, r.height);
        }
    }

    public DesenhistaCenario getDesenhistaAtual() {
        return desenhistas.get(cenarioValido);
    }

    // =========================
    // DESENHO
    // =========================
    public void desenharChaoECasas(Graphics2D d2) {

        for (int lin = 0; lin < cenarioValido.length; lin++) {
            for (int col = 0; col < cenarioValido[0].length; col++) {

                pecaDoCenario.carregaPecaDaMatriz(cenarioValido[lin][col]);
                pecaDoCenario.desenhaTile(d2, lin, col);
            }
        }

        DesenhistaCenario desenhista = desenhistas.get(cenarioValido);
        if (desenhista != null) {
            desenhista.desenharFundo(d2, sprites);
        }
    }

    public void desenharElementosFrente(Graphics2D d2, int peJogador) {

        DesenhistaCenario desenhista = desenhistas.get(cenarioValido);

        if (desenhista != null) {
            desenhista.desenharFrente(d2, sprites, peJogador);
        }
    }
}