package vista;

import config.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginJFrame extends JFrame {
    private JTextField txtCorreo = new JTextField();
    private JPasswordField txtPass = new JPasswordField();
    private JButton btnIngresar = new JButton("Iniciar Sesión");

    public LoginJFrame() {
        setTitle("Biblioteca - Autenticación");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Correo:"));
        add(txtCorreo);
        add(new JLabel("Contraseña:"));
        add(txtPass);
        add(new JLabel(""));
        add(btnIngresar);

        btnIngresar.addActionListener(e -> validarUsuario());
    }

    private void validarUsuario() {
        String correo = txtCorreo.getText();
        String pass = new String(txtPass.getPassword());

        try {
            Connection con = DatabaseConnection.getInstance().getConexion();
            String sql = "SELECT rol FROM usuarios WHERE correo = ? AND contraseña = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String rol = rs.getString("rol");
                JOptionPane.showMessageDialog(this, "Bienvenido. Rol: " + rol);


                new MenuJFrame(rol).setVisible(true);
                this.dispose(); // Cerrar ventana de login
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al autenticar: " + ex.getMessage());
        }
    }
}