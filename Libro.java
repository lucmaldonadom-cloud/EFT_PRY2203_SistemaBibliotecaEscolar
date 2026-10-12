package modelo;

public class Libro {
    private int id;
    private String titulo;
    private int stock;

    public Libro(int id, String titulo, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getStock() { return stock; }
}

