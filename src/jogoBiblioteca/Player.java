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

    Rectangle AreaColisao;
    private int posX, posY;
    private int Larg, Altu;
    public int passo = 3;

    public Player() {
        this.posX = 382;
        this.posY = 382;
        this.Larg = 48;
        this.Altu = 48;

        AreaColisao = new Rectangle();

        this.AreaColisao.x = this.posX + 3;
        this.AreaColisao.y = this.posY + this.Altu / 2;
        this.AreaColisao.width = this.Larg - 20;
        this.AreaColisao.height = this.Altu / 2;

        CorFundo = Color.white;

        for (int i = 0; i < 3; i++) {
            this.imgPlayerDown[i] = new ImageIcon("res/PLAYERS/down" + (i + 1) + ".png").getImage();
            this.imgPlayerRight[i] = new ImageIcon("res/PLAYERS/right" + (i + 1) + ".png").getImage();
            this.imgPlayerLeft[i] = new ImageIcon("res/PLAYERS/left" + (i + 1) + ".png").getImage();
            this.imgPlayerUp[i] = new ImageIcon("res/PLAYERS/up" + (i + 1) + ".png").getImage();
        }

        this.imgPlayer = this.imgPlayerDown[0];
    }

    public void atualizaSprite(boolean moveEsq, boolean moveCima, boolean moveDir, boolean moveBaixo) {

        this.frameJogador++;

        if (moveEsq) {
            if (frameJogador >= this.imgPlayerLeft.length)
                frameJogador = 0;

            this.imgPlayer = this.imgPlayerLeft[frameJogador];
        } else if (moveDir) {
            if (frameJogador >= this.imgPlayerRight.length)
                frameJogador = 0;

            this.imgPlayer = this.imgPlayerRight[frameJogador];
        } else if (moveCima) {
            if (frameJogador >= this.imgPlayerUp.length)
                frameJogador = 0;

            this.imgPlayer = this.imgPlayerUp[frameJogador];
        } else if (moveBaixo) {
            if (frameJogador >= this.imgPlayerDown.length)
                frameJogador = 0;

            this.imgPlayer = this.imgPlayerDown[frameJogador];
        }
    }

    public void DesenharPlayer(Graphics2D d2) {
        d2.setColor(this.CorFundo);
        d2.fillRect(this.AreaColisao.x, this.AreaColisao.y,
                this.AreaColisao.width, this.AreaColisao.height);

        d2.drawImage(imgPlayer, posX, posY, Larg, Altu, null);
    }

    public void atualizaPosicaoJogador(boolean ME, boolean MC, boolean MD, boolean MB) {

        if (ME)
            this.posX -= passo;
        else if (MD)
            this.posX += passo;
        else if (MC)
            this.posY -= passo;
        else if (MB)
            this.posY += passo;

        this.AreaColisao.x = this.posX + 3;
        this.AreaColisao.y = this.posY + this.Altu / 2;

        this.atualizaSprite(ME, MC, MD, MB);
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

        this.AreaColisao.x = this.posX + 3;
        this.AreaColisao.y = this.posY + this.Altu / 2;
    }
}