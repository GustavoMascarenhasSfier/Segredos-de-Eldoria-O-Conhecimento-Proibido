package jogoBiblioteca;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Moldura extends JFrame {

    public Moldura() {
        setTitle("CAP11 – SPRITES & TILES – parte1");
        setLayout(new BorderLayout());
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Painel painelCentro = new Painel();
        PainelSul painelSul = new PainelSul(painelCentro.inventario);

        // Injeta PainelSul no GameLoop para que ele possa repintá-lo
        painelCentro.setPainelSul(painelSul);

        add(painelCentro, BorderLayout.CENTER);
        add(painelSul,    BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
