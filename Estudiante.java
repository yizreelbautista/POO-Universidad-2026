package sistema.persistencia;

import java.io.Serializable;

public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    private String matricula;
    private String nombre;
    private double promedio;

    public Estudiante(String matricula, String nombre, double promedio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getMatricula() { return matricula; }
    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }

    @Override
    public String toString() {
        return "Estudiante [Matrícula: " + matricula + ", Nombre: " + nombre + ", Promedio: " + promedio + "]";
    }
}
