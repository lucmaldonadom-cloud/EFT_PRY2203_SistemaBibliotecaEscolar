package modelo;

public abstract class Persona {
    protected int id;
    protected String nombre;
    protected String rut;

    public Persona(int id, String nombre, String rut) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
}
