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
    public int spawnX1 = 0;
    public int spawnY1 = 0;
    public int spawnX2 = 0;
    public int spawnY2 = 0;

    // MAPAS
    public final int[][] cenario1DoJogo = Cenario1.MAPA;
    public final int[][] cenario2DoJogo = Cenario2.MAPA;
    public final int[][] cenario3DoJogo = Cenario3.MAPA;
    public final int[][] cenario4DoJogo = Cenario4.MAPA;
    public final int[][] cenario5DoJogo = Cenario5.MAPA;
    public final int[][] cenario6DoJogo = Cenario6.MAPA;
    public final int[][] cenario7DoJogo = Cenario7.MAPA;

    private final Map<int[][], DesenhistaCenario> desenhistas = new HashMap<>();

    private boolean perguntaEmAndamento = false;
    private boolean aguardandoSairDaZonaPorta = false;

    private Player jogadorPendente;
    private Cenario5 cenario5Pendente;

    private Painel painel = null;
    private EscutadorTeclado teclado = null;

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

        mudarCenario(5);
    }


    /** Chamado pelo Painel logo após construção */
    public void setContexto(Component pai, EscutadorTeclado et) {
        if (pai instanceof Painel p) this.painel = p;
        this.teclado = et;
    }

    public boolean isPerguntaEmAndamento() {
        return perguntaEmAndamento;
    }

    // =========================
    // TROCA DE CENÁRIO
    // =========================
    public void mudarCenario(int numeroCenario) {
        perguntaEmAndamento = false;
        aguardandoSairDaZonaPorta = false;

        switch (numeroCenario) {
            case 1:
                cenarioValido = cenario1DoJogo;
                cenarioAtualInstancia = new Cenario1();
                spawnX2 = 700; spawnY2 = 230;
                break;
            case 2:
                cenarioValido = cenario2DoJogo;
                cenarioAtualInstancia = new Cenario2();
                spawnX1 = 20;  spawnY1 = 230;
                spawnX2 = 700; spawnY2 = 230;
                break;
            case 3:
                cenarioValido = cenario3DoJogo;
                cenarioAtualInstancia = new Cenario3();
                spawnX1 = 20;  spawnY1 = 230;
                spawnX2 = 700; spawnY2 = 220;
                break;
            case 4:
                cenarioValido = cenario4DoJogo;
                spawnX1 = 20;  spawnY1 = 220;
                spawnX2 = 700; spawnY2 = 240;
                break;
            case 5:
                cenarioValido = cenario5DoJogo;
                cenarioAtualInstancia = new Cenario5();
                spawnX1 = Cenario5.ENTRADA_X;  // 48
                spawnY1 = Cenario5.ENTRADA_Y;  // 240
                spawnX2 = 700; spawnY2 = 240;
                break;
            case 6:
                cenarioValido = cenario6DoJogo;
                spawnX1 = 20;  spawnY1 = 190;
                spawnX2 = 700; spawnY2 = 240;
                break;
            case 7:
                cenarioValido = cenario7DoJogo;
                spawnX1 = 20;  spawnY1 = 190;
                spawnX2 = 700; spawnY2 = 240;
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
                jogador.teleportar(spawnX1, spawnY1);
            }
        }

        else if (cenarioAtualInstancia instanceof Cenario2) {
            if (jogador.getX() <= 0) {
                mudarCenario(1);
                jogador.teleportar(spawnX2, spawnY2);
            }
            if (jogador.getX() >= 720) {
                mudarCenario(3);
                jogador.teleportar(spawnX1, spawnY1);
            }
        }

        else if (cenarioAtualInstancia instanceof Cenario3) {
            if (jogador.getX() >= 768) {
                mudarCenario(3);
                jogador.teleportar(spawnX1, spawnY1);
            }
            if (jogador.getX() <= 0) {
                mudarCenario(2);
                jogador.teleportar(spawnX2, spawnY2);
            }
        }

        else if (cenarioValido == cenario4DoJogo) {
            if (jogador.getX() >= 720) {
                mudarCenario(5);
                jogador.teleportar(spawnX1, spawnY1);

            }
        }

        else if (cenarioAtualInstancia instanceof Cenario5) {
            Cenario5 c5 = (Cenario5) cenarioAtualInstancia;
            final int TILE = 48;

            // Saída pela esquerda
            if (jogador.getX() <= 0) {
                mudarCenario(4);
                jogador.teleportar(spawnX2, spawnY2);
                return;
            }

            // Passagem pela porta do Sol após desbloqueio
            if (jogador.getY() >= Cenario5.Y_PORTA - TILE) {
                int centroJog = jogador.getX() + 24;
                int colJog    = centroJog / TILE;

                if (colJog == Cenario5.COL_SOL && c5.isSolDesbloqueada()) {
                    mudarCenario(6);
                    jogador.teleportar(spawnX1, spawnY1);
                    return;
                }
            }

            // Libera nova tentativa só depois que o jogador sair da zona das portas
            if (aguardandoSairDaZonaPorta && jogador.getY() < Cenario5.Y_ZONA_PORTA) {
                aguardandoSairDaZonaPorta = false;
            }

            // Ativar pergunta ao se aproximar de qualquer porta
            if (!perguntaEmAndamento && !aguardandoSairDaZonaPorta && !c5.isSolDesbloqueada()
                    && jogador.getY() >= Cenario5.Y_ZONA_PORTA) {

                int centroJog = jogador.getX() + 24;
                int colJog    = centroJog / TILE;

                if (colJog == Cenario5.COL_LUA
                        || colJog == Cenario5.COL_SOL
                        || colJog == Cenario5.COL_ESTRELA) {
                    solicitarCharada(jogador);
                }
            }
        }
    }

    // =========================
    // CHARADA
    // =========================
    public void solicitarCharada(Player jogador) {
        if (perguntaEmAndamento || painel == null) return;
        if (!(cenarioAtualInstancia instanceof Cenario5 c5)) return;
        if (c5.isSolDesbloqueada()) return;

        perguntaEmAndamento = true;
        jogadorPendente = jogador;
        cenario5Pendente = c5;

        if (teclado != null) teclado.pausar();
        painel.ativarCharada();
    }

    public void processarRespostaCharada(int escolha) {
        if (!perguntaEmAndamento || jogadorPendente == null || cenario5Pendente == null) return;

        if (escolha == 0) {
            cenario5Pendente.desbloquearPortaSol();
            painel.mostrarMensagemPortaSolLiberada();
        } else {
            // Mantém o jogador na posição em que parou
            aguardandoSairDaZonaPorta = true;
            if (teclado != null) teclado.retomar();
        }

        perguntaEmAndamento = false;
        jogadorPendente = null;
        cenario5Pendente = null;
    }

    public void finalizarMensagemSucesso() {
        if (teclado != null) teclado.retomar();
    }

    public void cancelarCharada() {
        if (!perguntaEmAndamento) return;

        aguardandoSairDaZonaPorta = true;
        perguntaEmAndamento = false;
        jogadorPendente = null;
        cenario5Pendente = null;

        if (teclado != null) teclado.retomar();
    }

    // =========================
    // HITBOX
    // =========================
    public void desenharHitboxes(Graphics2D g2) {
        if (!MOSTRAR_HITBOXES || cenarioAtualInstancia == null) return;

        g2.setColor(new Color(255, 0, 0, 100));
        for (Rectangle r : cenarioAtualInstancia.getHitboxesObjetos())
            g2.fillRect(r.x, r.y, r.width, r.height);

        g2.setColor(Color.RED);
        for (Rectangle r : cenarioAtualInstancia.getHitboxesObjetos())
            g2.drawRect(r.x, r.y, r.width, r.height);
    }

    public DesenhistaCenario getDesenhistaAtual() {
        return desenhistas.get(cenarioValido);
    }

    // =========================
    // DESENHO
    // =========================
    public void desenharChaoECasas(Graphics2D d2) {
        for (int lin = 0; lin < cenarioValido.length; lin++)
            for (int col = 0; col < cenarioValido[0].length; col++) {
                pecaDoCenario.carregaPecaDaMatriz(cenarioValido[lin][col]);
                pecaDoCenario.desenhaTile(d2, lin, col);
            }

        DesenhistaCenario desenhista = desenhistas.get(cenarioValido);
        if (desenhista != null) desenhista.desenharFundo(d2, sprites);
    }

    public void desenharElementosFrente(Graphics2D d2, int peJogador) {
        DesenhistaCenario desenhista = desenhistas.get(cenarioValido);
        if (desenhista != null) desenhista.desenharFrente(d2, sprites, peJogador);
    }
}
