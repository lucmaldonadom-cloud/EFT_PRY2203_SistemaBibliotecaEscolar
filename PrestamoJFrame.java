package vista;

import dao.LibroDAO;
import javax.swing.*;
import java.awt.*;

public class PrestamoJFrame extends JFrame {
    private JTextField txtIdLibro = new JTextField();
    private JButton btnPrestar = new JButton("Registrar Préstamo");
    private LibroDAO libroDAO = new LibroDAO();

    public PrestamoJFrame() {
        setTitle("Sistema de Biblioteca - Préstamos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        add(new JLabel("ID del Libro a Prestar:"));
        add(txtIdLibro);
        add(new JLabel(""));
        add(btnPrestar);

        btnPrestar.addActionListener(e -> realizarPrestamo());
    }

    private void realizarPrestamo() {
        btnPrestar.setEnabled(false);
        btnPrestar.setText("Procesando en BD...");


        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(1500);
                int id = Integer.parseInt(txtIdLibro.getText());

                boolean exito = libroDAO.actualizarStock(id, -1);

                SwingUtilities.invokeLater(() -> {
                    if (exito) {
                        JOptionPane.showMessageDialog(null, "Préstamo exitoso. Stock descontado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al procesar el préstamo.");
                    }
                    btnPrestar.setEnabled(true);
                    btnPrestar.setText("Registrar Préstamo");
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        hilo.start();
    }
}
