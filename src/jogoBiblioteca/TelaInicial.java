package jogoBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class TelaInicial extends JFrame {

    private static final int W = 768;
    private static final int H = 540;

    public TelaInicial() {
        setTitle("Segredos de Eldoria - O Conhecimento Proibido");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(true);
        add(new PainelTitulo(() -> { dispose(); new Moldura(); }));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // =========================================================
    //  PAINEL
    // =========================================================
    private static class PainelTitulo extends JPanel {

        private static final Color BG_DARK     = new Color(13, 11, 8);// fundo quase preto
        private static final Color GOLD        = new Color(201, 148, 58); // dourado principal dos textos
        private static final Color GOLD_BRIGHT = new Color(232, 200, 122);// dourado mais claro (hover e brilho)
        private static final Color GOLD_DIM    = new Color(138, 98, 40);// dourado escuro (bordas)
        private static final Color PARCHMENT   = new Color(240, 232, 208);// bege claro (texto da história)
        private static final Color BTN_FILL    = new Color(22, 16, 8);// fundo escuro dos botões
        private static final Color BTN_HOVER   = new Color(60, 42, 12);// fundo do botão quando o mouse está em cima

        // valor entre 0.82 e 1.0 que oscila — controla o brilho do título
        private float flickerAlpha = 1f;
        private float flickerTimer = 0f;

        // vai de 0 a 1 ao abrir a tela (tela surge do preto)
        private float fadeIn       = 0f;
        // vira true quando jogador clica em Jogar
        private boolean fadingOut  = false;
        // vai de 0 a 1 durante o fade de saída (tela some no preto)
        private float fadeOut      = 0f;

        private boolean mostrandoHistoria = false;
        private int     paginaHistoria    = 0;

        private static final String[][] PAGINAS = {
                {
                        "Em uma antiga regiao esquecida pelo tempo, existia uma",
                        "biblioteca cercada por historias proibidas e misterios que",
                        "jamais deveriam ser descobertos. Diziam que em suas salas",
                        "escondidas estava guardado um livro capaz de revelar verdades",
                        "sobre o passado, o presente e ate o destino das pessoas",
                        "que ousassem procura-lo."
                },
                {
                        "O protagonista cresce ouvindo esses rumores, mas nunca imaginou",
                        "ter alguma ligacao com eles. Apos encontrar simbolos estranhos",
                        "na praca de sua vila, percebe que algo o guia ate a biblioteca",
                        "esquecida. Movido pela curiosidade, decide iniciar uma jornada",
                        "em busca da verdade."
                },
                {
                        "Na cidade medieval, encontra um sabio que guarda segredos",
                        "sobre a biblioteca. Porem, nenhum conhecimento e entregue",
                        "facilmente - o jogador deve provar sua inteligencia resolvendo",
                        "enigmas deixados pelos antigos guardioes. Apenas assim",
                        "descobrira onde esta a chave da biblioteca antiga."
                },
                {
                        "Dentro da biblioteca, corredores silenciosos e estantes",
                        "interminaveis escondem mecanismos secretos. O lugar foi criado",
                        "nao apenas para guardar livros, mas para esconder conhecimentos",
                        "considerados perigosos demais para o mundo."
                },
                {
                        "Uma passagem secreta leva a uma sala oculta ha seculos.",
                        "Nela repousa um artefato ligado aos segredos da biblioteca.",
                        "Ao coleta-lo, novos caminhos se abrem - revelando que existe",
                        "algo ainda mais importante escondido nas profundezas do lugar."
                },
                {
                        "O guardiao da biblioteca desafia o jogador com perguntas,",
                        "enigmas e testes de sabedoria, colocando a prova tudo que",
                        "foi aprendido durante a jornada. Nao ha batalha com espadas -",
                        "apenas a mente pode abrir o caminho."
                },
                {
                        "Apos superar o guardiao, um artefato especial ilumina a sala",
                        "final, onde repousa o Livro do Conhecimento Proibido.",
                        "",
                        "No silencio daquele lugar, o protagonista entende que sua",
                        "jornada nunca foi apenas sobre encontrar um livro - mas",
                        "descobrir verdades esquecidas sobre o mundo e sobre si mesmo."
                }
        };

        // -- botoes menu principal --
        private final Rectangle retJogar    = new Rectangle();
        private final Rectangle retHistoria = new Rectangle();
        private final Rectangle retSair     = new Rectangle();
        private int hoverMenu = -1; // 0=jogar, 1=historia, 2=sair

        // -- botoes da historia --
        private final Rectangle retAnterior = new Rectangle();
        private final Rectangle retFechar   = new Rectangle();
        private final Rectangle retProximo  = new Rectangle();
        private int hoverNav = -1; // 0=anterior, 1=fechar, 2=proximo
                                    // -1 = mouse não está em cima de nenhum botão
        private final Runnable onJogar;
        public  final Timer timer;

        PainelTitulo(Runnable onJogar) {
            this.onJogar = onJogar;
            setPreferredSize(new Dimension(W, H));
            setBackground(BG_DARK);

            timer = new Timer(16, e -> tick());
            timer.start();

            addMouseListener(new MouseAdapter() {
                @Override public void mouseClicked(MouseEvent e) { handleClick(e.getX(), e.getY()); }
            });
            addMouseMotionListener(new MouseAdapter() {
                @Override public void mouseMoved(MouseEvent e) { handleHover(e.getX(), e.getY()); }
            });
        }

        private void tick() {
            if (fadeIn < 1f) fadeIn = Math.min(1f, fadeIn + 0.018f); // aumenta até 1 (leva ~55 frames = ~0.9s)
            if (fadingOut) {
                fadeOut = Math.min(1f, fadeOut + 0.035f);
                if (fadeOut >= 1f) { timer.stop(); onJogar.run(); return; }// aí lança o jogo
            }
            repaint();
        }

        private void handleClick(int mx, int my) {
            if (fadingOut || fadeIn < 0.8f) return;
            if (mostrandoHistoria) {
                if (retAnterior.contains(mx, my) && paginaHistoria > 0)               { paginaHistoria--; }
                else if (retProximo.contains(mx, my) && paginaHistoria < PAGINAS.length-1) { paginaHistoria++; }
                else if (retFechar.contains(mx, my))  { mostrandoHistoria = false; }
                return;
            }
            if (retJogar.contains(mx, my))    { fadingOut = true; }
            if (retHistoria.contains(mx, my)) { mostrandoHistoria = true; paginaHistoria = 0; }
            if (retSair.contains(mx, my))     { System.exit(0); }
        }

        private void handleHover(int mx, int my) {
            if (mostrandoHistoria) {
                if      (retAnterior.contains(mx, my)) hoverNav = 0;
                else if (retFechar.contains(mx, my))   hoverNav = 1;
                else if (retProximo.contains(mx, my))  hoverNav = 2;
                else                                   hoverNav = -1;
            } else {
                if      (retJogar.contains(mx, my))    hoverMenu = 0;
                else if (retHistoria.contains(mx, my)) hoverMenu = 1;
                else if (retSair.contains(mx, my))     hoverMenu = 2;
                else                                   hoverMenu = -1;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,      RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            drawBackground(g2);
            drawVignette(g2);

            if (mostrandoHistoria) {
                drawHistoria(g2);
            } else {
                drawDecoLine(g2, 130);
                drawDecoLine(g2, 325);
                drawTitle(g2);
                drawSubtitle(g2);
                drawMenuBotoes(g2);
                g2.setFont(new Font("Serif", Font.ITALIC, 12));
                g2.setColor(new Color(90, 72, 40, 160));
                String cr = "Uma aventura de misterio e sabedoria";
                g2.drawString(cr, (W - g2.getFontMetrics().stringWidth(cr)) / 2, H - 18);
            }

            if (fadeIn < 1f) {
                g2.setColor(new Color(0, 0, 0, (int)((1f - fadeIn) * 255)));
                g2.fillRect(0, 0, W, H);
            }
            if (fadingOut && fadeOut > 0f) {
                g2.setColor(new Color(13, 11, 8, (int)(fadeOut * 255)));
                g2.fillRect(0, 0, W, H);
            }
        }

        // ── tela de historia ──────────────────────────────────────────────
        private void drawHistoria(Graphics2D g2) {
            // caixa do pergaminho
            int px = 40, py = 30, pw = W - 80, ph = H - 60;
            g2.setColor(new Color(20, 15, 7, 245));
            g2.fillRect(px, py, pw, ph);// caixa principal
            g2.setColor(GOLD_DIM);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRect(px, py, pw, ph);
            g2.setColor(new Color(138, 98, 40, 50));
            g2.drawRect(px + 8, py + 8, pw - 16, ph - 16); // borda interna decorativa
            g2.setStroke(new BasicStroke(1f));

            // pagina
            g2.setFont(new Font("Serif", Font.ITALIC, 12));
            g2.setColor(new Color(138, 98, 40, 180));
            String pagStr = "Parte " + (paginaHistoria + 1) + " de " + PAGINAS.length;
            g2.drawString(pagStr, (W - g2.getFontMetrics().stringWidth(pagStr)) / 2, py + 30);

            // titulo
            g2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
            g2.setColor(GOLD);
            String tit = "- A Lenda de Eldoria -";
            g2.drawString(tit, (W - g2.getFontMetrics().stringWidth(tit)) / 2, py + 56);

            // separador
            g2.setColor(new Color(138, 98, 40, 100));
            g2.drawLine(px + 60, py + 66, px + pw - 60, py + 66);

            // texto
            g2.setFont(new Font("Serif", Font.ITALIC, 15));
            g2.setColor(new Color(240, 232, 208, 220));
            FontMetrics fm = g2.getFontMetrics();
            int ly = py + 100;
            for (String linha : PAGINAS[paginaHistoria]) {
                if (!linha.isEmpty())
                    g2.drawString(linha, (W - fm.stringWidth(linha)) / 2, ly);
                ly += 28;
            }

            // botoes de navegacao
            // calcula dentro do pergaminho: btnY = py + ph - 56
            int btnW = 160, btnH = 36;
            int btnY = py + ph - 56;
            int gap  = 20;
            int totalW = btnW * 3 + gap * 2;
            int startX = (W - totalW) / 2;

            // anterior
            retAnterior.setBounds(startX, btnY, btnW, btnH);
            // fechar (centro)
            retFechar.setBounds(startX + btnW + gap, btnY, btnW, btnH);
            // proximo
            retProximo.setBounds(startX + (btnW + gap) * 2, btnY, btnW, btnH);

            if (paginaHistoria > 0)
                desenharBotaoRect(g2, retAnterior, "<< VOLTAR", hoverNav == 0);
            else {
                // botao desabilitado (cinza)
                desenharBotaoRect(g2, retAnterior, "<< VOLTAR", false, true);
            }

            desenharBotaoRect(g2, retFechar, "FECHAR", hoverNav == 1);

            if (paginaHistoria < PAGINAS.length - 1)
                desenharBotaoRect(g2, retProximo, "PROXIMO >>", hoverNav == 2);
            else {
                desenharBotaoRect(g2, retProximo, "PROXIMO >>", false, true);
            }
        }

        private void desenharBotaoRect(Graphics2D g2, Rectangle r, String label, boolean hover) {
            desenharBotaoRect(g2, r, label, hover, false);
        }

        private void desenharBotaoRect(Graphics2D g2, Rectangle r, String label, boolean hover, boolean disabled) {
            // sombra
            g2.setColor(new Color(0, 0, 0, 70));
            g2.fillRect(r.x + 3, r.y + 3, r.width, r.height);

            // fundo
            if (disabled) {
                g2.setColor(new Color(20, 16, 10, 180));
            } else if (hover) {
                GradientPaint gp = new GradientPaint(r.x, r.y, BTN_HOVER, r.x, r.y + r.height, new Color(40, 28, 8));
                g2.setPaint(gp);
            } else {
                g2.setColor(BTN_FILL);
            }
            g2.fillRect(r.x, r.y, r.width, r.height);

            // borda
            g2.setColor(disabled ? new Color(80, 64, 30, 80) : (hover ? GOLD : GOLD_DIM));
            g2.setStroke(new BasicStroke(hover ? 1.8f : 1f));
            g2.drawRect(r.x, r.y, r.width, r.height);
            g2.setStroke(new BasicStroke(1f));

            // cantos decorativos
            int m = 5;
            g2.setColor(hover ? GOLD : GOLD_DIM);
            if (!disabled) {
                g2.drawLine(r.x,           r.y,           r.x+m,         r.y          );
                g2.drawLine(r.x,           r.y,           r.x,           r.y+m        );
                g2.drawLine(r.x+r.width-m, r.y,           r.x+r.width,   r.y          );
                g2.drawLine(r.x+r.width,   r.y,           r.x+r.width,   r.y+m        );
                g2.drawLine(r.x,           r.y+r.height-m,r.x,           r.y+r.height );
                g2.drawLine(r.x,           r.y+r.height,  r.x+m,         r.y+r.height );
                g2.drawLine(r.x+r.width,   r.y+r.height-m,r.x+r.width,   r.y+r.height );
                g2.drawLine(r.x+r.width-m, r.y+r.height,  r.x+r.width,   r.y+r.height );
            }

            // texto
            g2.setFont(new Font("Serif", Font.BOLD, 14));
            FontMetrics fm = g2.getFontMetrics();
            g2.setColor(disabled ? new Color(100, 80, 40, 100) : (hover ? GOLD_BRIGHT : GOLD));
            g2.drawString(label,
                    r.x + (r.width  - fm.stringWidth(label)) / 2,
                    r.y + (r.height + fm.getAscent() - fm.getDescent()) / 2);
        }

        // ── menu principal ────────────────────────────────────────────────
        private void drawMenuBotoes(Graphics2D g2) {
            int bw = 200, bh = 44, gap = 20;
            int startX = (W - bw) / 2;

            retJogar   .setBounds(startX, 348, bw, bh);
            retHistoria.setBounds(startX, 348 + bh + gap, bw, bh);
            retSair    .setBounds(startX, 348 + (bh + gap) * 2, bw, bh);

            desenharBotaoRect(g2, retJogar,    "JOGAR",    hoverMenu == 0);
            desenharBotaoRect(g2, retHistoria, "HISTORIA", hoverMenu == 1);
            desenharBotaoRect(g2, retSair,     "SAIR",     hoverMenu == 2);
        }

        // ── fundo ─────────────────────────────────────────────────────────
        private void drawBackground(Graphics2D g2) {
            RadialGradientPaint radial = new RadialGradientPaint(
                    new Point2D.Float(W/2f, H/2f), W*0.7f,
                    new float[]{0f, 0.45f, 1f},
                    new Color[]{ new Color(42,26,8), new Color(20,15,6), BG_DARK }
            );
            g2.setPaint(radial);
            g2.fillRect(0, 0, W, H);
            g2.setColor(new Color(255,255,255,5));
            g2.setStroke(new BasicStroke(1f));
            for (int y = 0; y < H; y += 48) g2.drawLine(0, y, W, y);
            for (int x = 0; x < W; x += 64) g2.drawLine(x, 0, x, H);
        }

        private void drawVignette(Graphics2D g2) {
            RadialGradientPaint vig = new RadialGradientPaint(
                    new Point2D.Float(W/2f, H/2f), W*0.75f,
                    new float[]{0.4f, 1f},
                    new Color[]{ new Color(0,0,0,0), new Color(0,0,0,200) }
            );
            g2.setPaint(vig);
            g2.fillRect(0, 0, W, H);
        }

        private void drawDecoLine(Graphics2D g2, int y) {
            GradientPaint gp = new GradientPaint(W*0.1f, y, new Color(0,0,0,0), W*0.3f, y, GOLD_DIM, true);
            g2.setPaint(gp);
            g2.setStroke(new BasicStroke(1f));
            g2.drawLine(W/2-200, y, W/2+200, y);
            g2.setColor(GOLD_DIM);
            int[] px2 = {W/2, W/2+6, W/2, W/2-6};
            int[] py2 = {y-5, y, y+5, y};
            g2.fillPolygon(px2, py2, 4);
        }

        private void drawTitle(Graphics2D g2) {
            Font f = new Font("Serif", Font.BOLD, 52);
            g2.setFont(f);
            FontMetrics fm = g2.getFontMetrics();
            String titulo = "Segredos de Eldoria";
            int tx = (W - fm.stringWidth(titulo)) / 2, ty = 200; //calcula a posição X e Y para centralizar o texto na tela.
            g2.setColor(blend(GOLD, GOLD_BRIGHT, flickerAlpha * 0.6f));
            g2.drawString(titulo, tx, ty);
        }

        private void drawSubtitle(Graphics2D g2) {
            g2.setFont(new Font("Serif", Font.ITALIC, 22));
            FontMetrics fm = g2.getFontMetrics();
            String sub = "O Conhecimento Proibido";
            g2.setColor(new Color(PARCHMENT.getRed(), PARCHMENT.getGreen(), PARCHMENT.getBlue(), 200));
            g2.drawString(sub, (W - fm.stringWidth(sub)) / 2, 232);//calcula a posição X e Y para centralizar o texto na tela.
        }

        private Color blend(Color a, Color b, float t) {
            return new Color(
                    (int)(a.getRed()   + (b.getRed()   - a.getRed())   * t),
                    (int)(a.getGreen() + (b.getGreen() - a.getGreen()) * t),
                    (int)(a.getBlue()  + (b.getBlue()  - a.getBlue())  * t)
            );
        }
    }
}
