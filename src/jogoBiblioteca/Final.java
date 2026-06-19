package jogoBiblioteca;

import javax.swing.*;
import java.awt.*;

public class Final extends JFrame {

    public Final() {
        setTitle("FIM!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(true);

        add(new PainelFinal());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static class PainelFinal extends JPanel {

        public PainelFinal() {
            setPreferredSize(new Dimension(768, 540));
            setBackground(Color.BLACK);

        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(getBackground());
            g2.fillRect(0, 0, getWidth(), getHeight());
            desenharContinua(g2);
        }

        private void desenharContinua(Graphics2D g2) {
            g2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 80));

            g2.setColor(new Color(232, 200, 122));
            g2.drawString("Continua...", 190, 260);

            g2.setFont(new Font("Serif", Font.ITALIC, 20));

            g2.setColor(new Color(190, 160, 100));
            g2.drawString("Os segredos de Eldoria ainda não terminaram...", 180, 320);
        }
    }
}