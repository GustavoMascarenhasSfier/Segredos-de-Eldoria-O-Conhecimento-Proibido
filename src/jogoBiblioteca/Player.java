package jogoBiblioteca;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player {

    private Color CorFundo;

    private Image[] imgPlayerDown = new Image[3];
    private Image[] imgPlayerRight = new Image[3];
    private Image[] imgPlayerLeft = new Image[3];
    private Image[] imgPlayerUp = new Image[3];

    private Image imgPlayer;
    private int frameJogador = 0;
    private long lastnow = 0;
    private String lastDirection = "";

    Rectangle AreaColisao;
    private int posX, posY;
    private int Larg, Altu;
    public int passo = 2;

    public Player() {
        this.posX = 352;
        this.posY = 382;
        this.Larg = 48;
        this.Altu = 48;

        AreaColisao = new Rectangle();

        this.AreaColisao.width = 20;
        this.AreaColisao.height = 18;

        this.AreaColisao.x = this.posX + (this.Larg - this.AreaColisao.width) / 2;
        this.AreaColisao.y = this.posY + this.Altu - this.AreaColisao.height - 2;

        CorFundo = new Color(0,0,0,0);

        for (int i = 0; i < 3; i++) {
            this.imgPlayerDown[i] = new ImageIcon("res/PLAYERS/down" + (i + 1) + ".png").getImage();
            this.imgPlayerRight[i] = new ImageIcon("res/PLAYERS/right" + (i + 1) + ".png").getImage();
            this.imgPlayerLeft[i] = new ImageIcon("res/PLAYERS/left" + (i + 1) + ".png").getImage();
            this.imgPlayerUp[i] = new ImageIcon("res/PLAYERS/up" + (i + 1) + ".png").getImage();
        }

        this.imgPlayer = this.imgPlayerDown[0];
    }

    public void atualizaSprite(String direcao) {

        //Tempo Atual//
        long now = System.currentTimeMillis();

        //Se a animação for para uma direção diferente ele reseta o cooldown na hora//
        if (!direcao.equals(lastDirection)) {
            lastDirection = direcao;
            lastnow = 0;
            frameJogador = 0;
        }
        //Verifica se tem cooldown para atualizar o frame
        if (now - lastnow > (200/passo)) {
            lastnow = now;
        } else return;

        this.frameJogador++;

        switch (direcao) {
            case "esquerda" -> {
                if (frameJogador >= this.imgPlayerLeft.length)
                    frameJogador = 0;

                this.imgPlayer = this.imgPlayerLeft[frameJogador];
            }
            case "direita" -> {
                if (frameJogador >= this.imgPlayerRight.length)
                    frameJogador = 0;

                this.imgPlayer = this.imgPlayerRight[frameJogador];
            }
            case "cima" -> {
                if (frameJogador >= this.imgPlayerUp.length)
                    frameJogador = 0;

                this.imgPlayer = this.imgPlayerUp[frameJogador];
            }
            case "baixo" -> {
                if (frameJogador >= this.imgPlayerDown.length)
                    frameJogador = 0;

                this.imgPlayer = this.imgPlayerDown[frameJogador];
            }
        }
    }

    public void DesenharPlayer(Graphics2D d2) {
        d2.setColor(this.CorFundo);
        d2.fillRect(this.AreaColisao.x, this.AreaColisao.y,
                this.AreaColisao.width, this.AreaColisao.height);

        d2.drawImage(imgPlayer, posX, posY, Larg, Altu, null);
    }

    public void atualizaPosicaoJogador(String direcao) {

        if (direcao.equals("cima"))
            this.posY -= passo;
        else if (direcao.equals("direita"))
            this.posX += passo;
        else if (direcao.equals("esquerda"))
            this.posX -= passo;
        else if (direcao.equals("baixo"))
            this.posY += passo;

        this.AreaColisao.x = this.posX + (this.Larg - this.AreaColisao.width) / 2;
        this.AreaColisao.y = this.posY + this.Altu - this.AreaColisao.height - 2;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public Rectangle getAreaColisao() {
        return AreaColisao;
    }

    public void teleportar(int x, int y) {

        this.posX = x;
        this.posY = y;

        this.AreaColisao.x = this.posX + (this.Larg - this.AreaColisao.width) / 2;
        this.AreaColisao.y = this.posY + this.Altu - this.AreaColisao.height - 2;
    }
}