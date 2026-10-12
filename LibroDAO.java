package dao;

import config.DatabaseConnection;
import modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LibroDAO implements ICrud<Libro> {
    private Connection con = DatabaseConnection.getInstance().getConexion();

    @Override
    public boolean crear(Libro objeto) { return true; }

    @Override
    public List<Libro> leerTodos() { return null; }


    public synchronized boolean actualizarStock(int idLibro, int cantidadModificar) {
        String sql = "UPDATE libros SET stock = stock + ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cantidadModificar);
            ps.setInt(2, idLibro);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
