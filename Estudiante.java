package modelo;

public class Estudiante extends Persona {
    private String curso;

    public Estudiante(int id, String nombre, String rut, String curso) {
        super(id, nombre, rut);
        this.curso = curso;
    }

    public String getCurso() { return curso; }
}
