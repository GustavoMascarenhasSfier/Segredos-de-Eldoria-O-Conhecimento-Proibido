package jogoBiblioteca.cenarios;

import java.awt.*;

/**
 * Cenário 5 — "O Caminho Correto"
 *
 * O mapa tem tiles 0 nas colunas das 3 portas (row 9),
 * criando aberturas reais na parede sul.
 * Hitboxes de objeto cobrem essas aberturas e bloqueiam o jogador.
 * Quando o jogador acerta a charada, a hitbox da porta do Sol é removida.
 */
public class Cenario5 extends CenarioBase {

    private static final int TILE = 48;
    private static final int ALTURA_TELA = 480;

    // Colunas das portas
    public static final int COL_LUA     = 2;
    public static final int COL_SOL     = 7;
    public static final int COL_ESTRELA = 12;


    // Linha e posição Y das portas (parede sul)
    public static final int ROW_PORTAS = 9;
    public static final int Y_PORTA    = ROW_PORTAS * TILE;

    // Y a partir do qual ativamos a checagem de porta/transição (perto do chão)
    public static final int Y_ZONA_PORTA = ALTURA_TELA - TILE * 3;

    // Placa com a charada (parede leste)
    public static final int PLACA_X = 558;  // W - 210
    public static final int PLACA_Y = 180;  // H/2 - 60
    public static final int PLACA_W = 190;
    public static final int PLACA_H = 120;

    // Estátua (mesma posição do DesenhistaCenario5)
    public static final int ESTATUA_X = 310;
    public static final int ESTATUA_Y = 130;
    public static final int ESTATUA_W = 110;
    public static final int ESTATUA_H = 170;

    // Linha dos pés da estátua no chão
    public static final int ESTATUA_PE_Y = ESTATUA_Y + ESTATUA_H;

    // Linha de profundidade: pés do jogador acima disso → passa por trás da estátua
    public static final int ESTATUA_LINHA_Y = ESTATUA_Y + 145;

    /*
     * MAPA — tile 0 = parede (sem colisão de tile, mas visualmente parede)
     *        tile 4 = chão branco (passável)
     *        tile 5 = gray (colisão de tile = true)
     *
     * Nas colunas COL_LUA, COL_SOL, COL_ESTRELA da row 9
     * usamos tile 0 (sem colisão de tile) para abrir o vão.
     * A colisão real das portas é feita por hitboxesObjetos.a
     */
    public static final int[][] MAPA = {
            //  0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15
            {   0,   0,   0,   0,   0,   0,   0,   24,   24,   0,   0,   0,   0,   0,   0,   0 }, // row 0 norte
            {   0,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   0 }, // row 1
            {   0,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   0 }, // row 2
            {   0,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   0 }, // row 3
            {   0,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   0 }, // row 4
            {   0,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   0 }, // row 5 saída esq
            {   0,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   0 }, // row 6
            {   0,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   0 }, // row 7
            {   0,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   0 }, // row 8
            {   0,   5,   0,   5,   5,   5,   5,   0,   5,   5,   5,   5,   0,   5,   5,   0 }, // row 9 sul: 3 vãos
    };

    // Hitboxes individuais para podermos remover a do Sol quando o jogador acertar
    private Rectangle hitboxLua;
    private Rectangle hitboxSol;
    private Rectangle hitboxEstrela;

    private boolean solDesbloqueada = false;

    public Cenario5() {
        inicializarHitboxes();
    }

    @Override
    protected void inicializarHitboxes() {

        //  parede superior ESQUERDA
        hitboxesObjetos.add(new Rectangle(  0,   0, 335,  48));
        //  parede superior DIREITA
        hitboxesObjetos.add(new Rectangle(  430,   0, 335,  48));

        // PAREDE ESQUERDA
        hitboxesObjetos.add(new Rectangle(  0, 0,  48, 480));  // Parede esq

        // PAREDE DIREITA
        hitboxesObjetos.add(new Rectangle(720,  0,  48, 480));  // PAREDE DIREITA

        // PAREDE INFERIOR — segmentos entre as portas
        hitboxesObjetos.add(new Rectangle( 48, 432,  48, 48)); //  (esq → Lua)
        hitboxesObjetos.add(new Rectangle(144, 432, 192, 48)); //  (entre Lua e Sol)
        hitboxesObjetos.add(new Rectangle(384, 432, 192, 48)); //  (entre Sol e Estrela)
        hitboxesObjetos.add(new Rectangle(624, 432,  96, 48)); // (após Estrela)

        hitboxLua     = new Rectangle(96,  432, 48, 48);
        hitboxSol     = new Rectangle(336, 432, 48, 48);
        hitboxEstrela = new Rectangle(576, 432, 48, 48);

        hitboxesObjetos.add(hitboxLua);
        hitboxesObjetos.add(hitboxSol);
        hitboxesObjetos.add(hitboxEstrela);

        hitboxesObjetos.add(new Rectangle(558, 180, 190, 120)); // Placa "Leia a Charada"

        hitboxesObjetos.add(new Rectangle(330, 230, 80, 60));    // Estátua
        hitboxesObjetos.add(new Rectangle(48,  44, 96, 50));   // Estante Norte Esq
        hitboxesObjetos.add(new Rectangle(192, 44, 96, 50));   // Estante Norte Centro-Esq
        hitboxesObjetos.add(new Rectangle(432, 44, 96, 50));   // Estante Norte Centro-Dir
        hitboxesObjetos.add(new Rectangle(624, 44, 96, 50));   // Estante Norte Dir
        hitboxesObjetos.add(new Rectangle(190, 342, 96, 50));  // Estante Inferior Esq
        hitboxesObjetos.add(new Rectangle(430, 342, 96, 50));  // Estante Inferior Dir
    }

    /** Remove a hitbox do Sol — jogador pode passar */
    public void desbloquearPortaSol() {
        hitboxesObjetos.remove(hitboxSol);
        solDesbloqueada = true;
        System.out.println("[Cenario5] Porta do Sol desbloqueada!");
    }

    public boolean isSolDesbloqueada() { return solDesbloqueada; }
}
