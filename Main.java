import vista.LoginJFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginJFrame().setVisible(true);
        });
    }
}
