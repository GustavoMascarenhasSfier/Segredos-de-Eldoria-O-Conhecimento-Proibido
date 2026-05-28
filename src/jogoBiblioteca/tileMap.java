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

    // Armazena o cenário lógico atual para o VerificadorDeColisao consultar
    public CenarioBase cenarioAtualInstancia;

    // Referências para os mapas de tiles
    public final int[][] cenario1DoJogo = Cenario1.MAPA;
    public final int[][] cenario2DoJogo = Cenario2.MAPA;
    public final int[][] cenario3DoJogo = Cenario3.MAPA;
    public final int[][] cenario4DoJogo = Cenario4.MAPA;
    public final int[][] cenario5DoJogo = Cenario5.MAPA;
    public final int[][] cenario6DoJogo = Cenario6.MAPA;
    public final int[][] cenario7DoJogo = Cenario7.MAPA;

    // Mapa de desenhistas
    private final Map<int[][], DesenhistaCenario> desenhistas = new HashMap<>();

    public tileMap() {
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

        // Inicializa o jogo no cenário 1
        mudarCenario(3);
    }

    public DesenhistaCenario getDesenhistaAtual() {
        return desenhistas.get(cenarioValido);
    }

    public void mudarCenario(int numeroCenario) {
        switch (numeroCenario) {
            case 1:
                this.cenarioValido = this.cenario1DoJogo;
                this.cenarioAtualInstancia = new Cenario1();
                break;
            case 2:
                this.cenarioValido = this.cenario2DoJogo;
                break;
            case 3:
                this.cenarioValido = this.cenario3DoJogo;
                this.cenarioAtualInstancia = new Cenario3();
                break;
            case 4:
                this.cenarioValido = this.cenario4DoJogo;
                break;
            case 5:
                this.cenarioValido = this.cenario5DoJogo;
                break;
            case 6:
                this.cenarioValido = this.cenario6DoJogo;
                break;
            case 7:
                this.cenarioValido = this.cenario7DoJogo;
                break;
            default:
                System.out.println("Cenário inválido!");
                break;
        }
    }

    /** Desenha os tiles do mapa + elementos de fundo do cenário atual. */
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

    /** Desenha os elementos que ficam por cima ou na frente (Árvores, estátuas, etc). */
    public void desenharElementosFrente(Graphics2D d2, int peJogador) {
        DesenhistaCenario desenhista = desenhistas.get(cenarioValido);
        if (desenhista != null) {
            // AQUI: Chama o método correto existente na Interface e no DesenhistaCenario1
            desenhista.desenharFrente(d2, sprites, peJogador);
        }
    }
}