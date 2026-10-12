package vista;

import javax.swing.*;
import java.awt.*;

public class MenuJFrame extends JFrame {
    public MenuJFrame(String rol) {
        setTitle("Sistema de Gestión de Biblioteca - Menú");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnLibros = new JButton("Gestión de Libros");
        JButton btnEstudiantes = new JButton("Gestión de Estudiantes");
        JButton btnPrestamos = new JButton("Préstamos y Devoluciones");
        JButton btnReportes = new JButton("Reportes");


        if ("estudiante".equalsIgnoreCase(rol)) {
            btnLibros.setEnabled(false);
            btnEstudiantes.setEnabled(false);
        }

        add(btnLibros);
        add(btnEstudiantes);
        add(btnPrestamos);
        add(btnReportes);


        btnPrestamos.addActionListener(e -> {
            new PrestamoJFrame().setVisible(true);
        });
    }
}
