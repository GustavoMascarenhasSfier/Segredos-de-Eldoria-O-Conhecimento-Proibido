package jogoBiblioteca;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import jogoBiblioteca.cenarios.*;
import jogoBiblioteca.cenarios.desenho.*;

import javax.swing.*;

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

    private final Cenario1 cenario1 = new Cenario1();
    private final Cenario2 cenario2 = new Cenario2();
    private final Cenario3 cenario3 = new Cenario3();
    private final Cenario4 cenario4 = new Cenario4();
    private final Cenario5 cenario5 = new Cenario5();
    private final Cenario6 cenario6 = new Cenario6();

    private final Map<int[][], DesenhistaCenario> desenhistas = new HashMap<>();

    private boolean perguntaEmAndamento = false;
    private boolean aguardandoSairDaZonaPorta = false;
    private boolean interacaoProcessada = false;

    private Player jogadorPendente;
    private Cenario5 cenario5Pendente;

    private Painel painel = null;
    private EscutadorTeclado teclado = null;

    // ── Mensagem de feedback ao jogador ──────────────────────────────────────
    private String mensagemFeedback = null;
    private long   mensagemExpira   = 0;
    private boolean mensagemC3Exibida = false;

    /** Retorna a mensagem ativa, ou null se já expirou. */
    public String getMensagemFeedback() {
        if (mensagemFeedback != null && System.currentTimeMillis() > mensagemExpira) {
            mensagemFeedback = null;
        }
        return mensagemFeedback;
    }

    /** Exibe uma mensagem na tela por 3 segundos. */
    private void mostrarMensagem(String texto) {
        mensagemFeedback = texto;
        mensagemExpira   = System.currentTimeMillis() + 3000;
    }

    /** Exibe uma mensagem na tela por tempo customizado (em ms). */
    private void mostrarMensagem(String texto, long duracaoMs) {
        mensagemFeedback = texto;
        mensagemExpira   = System.currentTimeMillis() + duracaoMs;
    }

    public tileMap() {
        this.sprites = new GerenciadorSprites();
        this.pecaDoCenario = new Tiles();

        desenhistas.put(cenario1DoJogo, new DesenhistaCenario1());

        desenhistas.put(cenario2DoJogo, new DesenhistaCenario2());

        DesenhistaCenario3 d3 = new DesenhistaCenario3();
        d3.setCenario3(cenario3);
        desenhistas.put(cenario3DoJogo, d3);

        DesenhistaCenario4 d4 = new DesenhistaCenario4();
        d4.setCenario4(cenario4);
        desenhistas.put(cenario4DoJogo, d4);

        desenhistas.put(cenario5DoJogo, new DesenhistaCenario5());

        DesenhistaCenario6 d6 = new DesenhistaCenario6();
        d6.setCenario6(cenario6);
        desenhistas.put(cenario6DoJogo, d6);

        desenhistas.put(cenario7DoJogo, new DesenhistaCenario7());

        // CENÁRIO INICIAL
        mudarCenario(1);
    }

    /** Chamado pelo Painel logo após construção */
    public void setContexto(Component pai, EscutadorTeclado et) {
        if (pai instanceof Painel p) this.painel = p;
        this.teclado = et;
    }

    public boolean isPerguntaEmAndamento() {
        return perguntaEmAndamento;
    }

    // =========================================================================
    // TROCA DE CENÁRIO
    // spawn1 = ponto de entrada vindo do cenário ANTERIOR (esquerda / cima)
    // spawn2 = ponto de entrada vindo do cenário SEGUINTE (direita / baixo)
    // =========================================================================
    public void mudarCenario(int numeroCenario) {
        perguntaEmAndamento = false;
        aguardandoSairDaZonaPorta = false;

        switch (numeroCenario) {

            case 1: // ── Vilarejo de Entrada ──────────────────────────────────
                cenarioValido = cenario1DoJogo;
                cenarioAtualInstancia = cenario1;
                spawnX1 = 352; spawnY1 = 300; // spawn1: centro do mapa (início do jogo)
                spawnX2 = 700; spawnY2 = 230; // spawn2: borda DIREITA (voltando do cenário 2)
                break;

            case 2: // ── Praça da Cidade ──────────────────────────────────────
                cenarioValido = cenario2DoJogo;
                cenarioAtualInstancia = cenario2;
                spawnX1 = 20;  spawnY1 = 230; // spawn1: borda ESQUERDA (vindo do cenário 1)
                spawnX2 = 700; spawnY2 = 230; // spawn2: borda DIREITA  (voltando do cenário 3)
                break;

            case 3:
                cenarioValido = cenario3DoJogo;
                cenarioAtualInstancia = cenario3;
                spawnX1 = 20;  spawnY1 = 230;
                spawnX2 = 660; spawnY2 = 72;

                if (!mensagemC3Exibida) {
                    mensagemC3Exibida = true;
                    mostrarMensagem("Bem-vindo à biblioteca! Procure os livros proibidos...", 3500);
                    javax.swing.Timer t = new javax.swing.Timer(4000, e -> {
                        mostrarMensagem("Entregue os livros ao javali para abrir a passagem secreta!", 4000);
                    });
                    t.setRepeats(false);
                    t.start();
                }
                break;

            case 4: // ── Sala Secreta ─────────────────────────────────────────
                cenarioValido = cenario4DoJogo;
                cenarioAtualInstancia = cenario4;
                spawnX1 = 20;  spawnY1 = 80;  // spawn1: borda ESQUERDA, Y=72    (vindo do cenário 3, altura da passagem secreta)
                spawnX2 = 700; spawnY2 = 240; // spawn2: borda DIREITA            (voltando do cenário 5)
                break;

            case 5: // ── Câmara do Sol ─────────────────────────────────────────
                cenarioValido = cenario5DoJogo;
                cenarioAtualInstancia = cenario5;
                spawnX1 = 360; spawnY1 = 20;  // spawn1: TOPO centro (vindo do cenário 3 pela porta inferior)
                spawnX2 = 336;  spawnY2 = 380; // spawn2: borda ESQUERDA (voltando do cenário 4)
                break;

            case 6: // ── SALA FINAL ───────────────────────────────────────────
                cenarioValido = cenario6DoJogo;
                cenarioAtualInstancia = cenario6;
                spawnX1 = 335; spawnY1 = 20;  // spawn1: TOPO centro  (vindo do cenário 5 pela porta do Sol)
                spawnX2 = 700; spawnY2 = 240; // spawn2: borda DIREITA (voltando do cenário 7)
                break;

            case 7: // ── Sala Final ───────────────────────────────────────────
                cenarioValido = cenario7DoJogo;
                spawnX1 = 20;  spawnY1 = 190; // spawn1: borda ESQUERDA (vindo do cenário 6)
                spawnX2 = 700; spawnY2 = 240; // spawn2: borda DIREITA  (reservado para cenário futuro)
                break;
        }
    }

    // =========================================================================
    // TRANSIÇÃO ENTRE CENÁRIOS
    // =========================================================================

    public void verificarTransicao(Player jogador) {

        // ── CENÁRIO 1 → 2 ────────────────────────────────────────────────────
        if (cenarioAtualInstancia instanceof Cenario1) {
            if (jogador.getX() >= 720) {
                mudarCenario(2);
                jogador.teleportar(spawnX1, spawnY1);
            }
        }

        // ── CENÁRIO 2 ↔ 1 / 2 → 3 ───────────────────────────────────────────
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

        // ── CENÁRIO 3 ↔ 2 / 3 → 4 (passagem) / 3 → 5 (porta) ───────────────
        else if (cenarioAtualInstancia instanceof Cenario3 c3) {

            // Passagem secreta → Cenário 4 (borda direita, Y < 120)
            if (c3.isPassagemAberta() && jogador.getX() >= 720 && jogador.getY() < 120) {
                mudarCenario(4);
                jogador.teleportar(spawnX1, spawnY1);
                return;
            }
            if (!c3.isPassagemAberta() && jogador.getX() >= 700 && jogador.getY() < 120) {
                mostrarMensagem("A passagem está bloqueada. Encontre os dois livros!");
                return;
            }

            // Porta inferior → Cenário 5 (borda sul, cols 6-8)
            if (jogador.getY() >= 415 && jogador.getX() >= 288 && jogador.getX() <= 432) {
                if (c3.isPortaC5Aberta()) {
                    mudarCenario(5);
                    jogador.teleportar(spawnX1, spawnY1);
                    return;
                } else {
                    mostrarMensagem("A porta está trancada. Use a chave!");
                    return;
                }
            }
            // Borda esquerda → Cenário 2
            if (jogador.getX() <= 0) {
                mudarCenario(2);
                jogador.teleportar(spawnX2, spawnY2);
            }
        }

        // ── CENÁRIO 4 ↔ 3 ────────────────────────────────────────────────────
        else if (cenarioAtualInstancia instanceof Cenario4) {
            // Borda esquerda, Y < 120 → volta pro Cenário 3 (passagem secreta)
            if (jogador.getX() <= 0 && jogador.getY() < 120) {
                mudarCenario(3);
                jogador.teleportar(spawnX2, spawnY2);
            }
        }

        // ── CENÁRIO 5 ↔ 3 / 5 → 6 (porta do Sol) ────────────────────────────
        else if (cenarioAtualInstancia instanceof Cenario5) {
            Cenario5 c5 = (Cenario5) cenarioAtualInstancia;
            final int TILE = 48;

            // Borda superior → volta pro Cenário 3 (pela porta inferior do C3)
            if (jogador.getY() <= 0) {
                mudarCenario(3);
                jogador.teleportar(336, 410);
                return;
            }

            // Borda sul → porta do Sol → Cenário 6
            if (jogador.getY() >= Cenario5.Y_PORTA - TILE) {
                int centroJog = jogador.getX() + 24;
                int colJog    = centroJog / TILE;

                if (colJog == Cenario5.COL_SOL && c5.isSolDesbloqueada()) {
                    mudarCenario(6);
                    jogador.teleportar(spawnX1, spawnY1);
                    return;
                }
            }

            if (aguardandoSairDaZonaPorta && jogador.getY() < Cenario5.Y_ZONA_PORTA) {
                aguardandoSairDaZonaPorta = false;
            }

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

        // ── CENÁRIO 6 ← 5 ────────────────────────────────────────────────────
        else if (cenarioValido == cenario6DoJogo) {
            if (jogador.getY() <= 0) {
                mudarCenario(5);
                jogador.teleportar(spawnX2, spawnY2);
            }
        }
    }

    // =========================================================================
    // CHARADA — CENÁRIO 5
    // =========================================================================
    public void solicitarCharada(Player jogador) {
        if (perguntaEmAndamento || painel == null) return;
        if (!(cenarioAtualInstancia instanceof Cenario5 c5)) return;
        if (c5.isSolDesbloqueada()) return;
        System.out.println(c5.isSolDesbloqueada());

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

    // =========================================================================
    // HITBOX
    // =========================================================================
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

    // =========================================================================
    // DESENHO
    // =========================================================================
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

    // =========================================================================
    // MECÂNICA DE INVENTÁRIO — CENÁRIO 3
    // =========================================================================
    public void processarInteracao(Player jogador, Inventario inventario) {

        java.awt.Rectangle areaJogador = jogador.getAreaColisao();
        java.awt.Rectangle alcance = new java.awt.Rectangle(
                areaJogador.x - 32, areaJogador.y - 32,
                areaJogador.width + 64, areaJogador.height + 64
        );

        // ── CENÁRIO 3 ─────── ──────────────────────────────────────────────────
        if (cenarioAtualInstancia instanceof jogoBiblioteca.cenarios.Cenario3 c3) {

            // ── Livro 1 — mesa central ─────────────────────────────────────────
            if (!c3.isLivroColetado() && alcance.intersects(jogoBiblioteca.cenarios.Cenario3.ZONA_MESA_LIVRO)) {
                c3.coletarLivro();
                inventario.adicionarItem(new Item("livro_proibido1", "Livro proibido "));
                mostrarMensagem("Livro proibido coletado!");
                if (painel != null) painel.repaint();
                return;
            }

            // ── Livro 2 — mesa pequena ─────────────────────────────────────────
            if (!c3.isLivro2Coletado() && alcance.intersects(jogoBiblioteca.cenarios.Cenario3.ZONA_MESA_LIVRO2)) {
                c3.coletarLivro2();
                inventario.adicionarItem(new Item("livro_proibido2", "Livro proibido 2"));
                mostrarMensagem("Livro proibido 2 coletado!");
                if (painel != null) painel.repaint();
                return;
            }

            // ── Item para ir pro cenário 4 — javali (passagem secreta) ────────
            if (!c3.isPassagemAberta() && alcance.intersects(jogoBiblioteca.cenarios.Cenario3.ZONA_JAVALI)) {

                boolean temLivro1 = false;
                boolean temLivro2 = false;

                for (int i = 0; i < inventario.getQuantidade(); i++) {
                    Item it = inventario.getItem(i);
                    if (it != null && it.getNome().equalsIgnoreCase("livro_proibido1")) temLivro1 = true;
                    if (it != null && it.getNome().equalsIgnoreCase("livro_proibido2")) temLivro2 = true;
                }

                if (temLivro1 && temLivro2) {
                    for (int i = inventario.getQuantidade() - 1; i >= 0; i--) {
                        Item it = inventario.getItem(i);
                        if (it != null && (it.getNome().equalsIgnoreCase("livro_proibido1")
                                || it.getNome().equalsIgnoreCase("livro_proibido2"))) {
                            inventario.removerItem(i);
                        }
                    }
                    c3.depositarLivroNoJavali();
                    mostrarMensagem("A passagem secreta foi aberta!");
                    if (painel != null) {
                        painel.repaint();
                        if (painel.painelSul != null) painel.painelSul.repaint();
                    }
                } else if (!temLivro1 && !temLivro2) {
                    mostrarMensagem("O javali aguarda... Procure os livros na biblioteca.");
                } else if (!temLivro1) {
                    mostrarMensagem("Ainda falta o livro proibido 1!");
                } else {
                    mostrarMensagem("Ainda falta o livro proibido 2!");
                }
                return;
            }

            // ── Item para ir pro cenário 5 — porta com chave ───────────────────
            if (alcance.intersects(jogoBiblioteca.cenarios.Cenario3.ZONA_PORTA_C5)) {

                boolean temChave = false;
                for (int i = 0; i < inventario.getQuantidade(); i++) {
                    Item it = inventario.getItem(i);
                    if (it != null && it.getNome().equalsIgnoreCase("chave")) {
                        temChave = true;
                        break;
                    }
                }

                if (temChave) {
                    for (int i = inventario.getQuantidade() - 1; i >= 0; i--) {
                        Item it = inventario.getItem(i);
                        if (it != null && it.getNome().equalsIgnoreCase("chave")) {
                            inventario.removerItem(i);
                            break;
                        }
                    }
                    c3.abrirPortaC5();
                    mostrarMensagem("A porta foi aberta com a chave!");
                    if (painel != null) painel.repaint();
                } else {
                    mostrarMensagem("A porta está trancada. Você precisa de uma chave!");
                }
                return;
            }

            return;
        }

        // ── CENÁRIO 4 ─────────────────────────────────────────────────────────
        if (cenarioAtualInstancia instanceof Cenario4 c4) {

            if (!c4.isChaveColetada() && alcance.intersects(Cenario4.ZONA_MESA_CHAVE)) {
                c4.coletarChave();
                inventario.adicionarItem(new Item("chave", "Chave"));
                mostrarMensagem("Chave coletada!");
                if (painel != null) painel.repaint();
                return;
            }
        }

        // ---- CENÁRIO 6 ---------------------
        if (cenarioAtualInstancia instanceof Cenario6 c6) {

            if (!c6.isLivro1Coletado() && alcance.intersects(Cenario6.ZONA_LIVRO_1)) {

                c6.coletarLivro1();
                mostrarMensagem("MEU DEUS, O QUE É ISSO???????????????");

                fecharJogoDepois(3000);
            }

            if (!c6.isLivro2Coletado()
                    && alcance.intersects(Cenario6.ZONA_LIVRO_2)) {

                c6.coletarLivro2();
                mostrarMensagem("Livro 2 encontrado! Parece importante... ou é só uma lista de compras.");

                if (painel != null) painel.repaint();
                return;
            }

            if (!c6.isLivro3Coletado()
                    && alcance.intersects(Cenario6.ZONA_LIVRO_3)) {

                c6.coletarLivro3();
                mostrarMensagem("Livro 3 encontrado! Finalmente um livro com figuras.");

                if (painel != null) painel.repaint();
                return;
            }

            if (!c6.isLivro4Coletado()
                    && alcance.intersects(Cenario6.ZONA_LIVRO_4)) {

                c6.coletarLivro4();
                mostrarMensagem("Livro 4 encontrado! Parabéns, você leu mais que muita gente este ano.");

                if (painel != null) painel.repaint();
                return;
            }
        }
    }

    private void fecharJogoDepois (int tempo) {
        Timer timer = new Timer(tempo, e -> {

            Window janelaAtual = SwingUtilities.getWindowAncestor(painel);

            if (janelaAtual != null) {
                janelaAtual.dispose();
            }

            new Final();
        });

        timer.setRepeats(false);
        timer.start();
    }

    public boolean isInteracaoProcessada() { return interacaoProcessada; }
    public void setInteracaoProcessada(boolean v) { interacaoProcessada = v; }

}
