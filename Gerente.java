public class Gerente extends Empleado {

    private String departamento;
    private double bonoEstrategico;

    public Gerente(String nombre, int edad, String idEmpleado,
                   double salarioBase, String departamento, double bonoEstrategico) {
        super(nombre, edad, idEmpleado, salarioBase);   // Constructor de Empleado
        this.departamento = departamento;
        this.bonoEstrategico = bonoEstrategico;
    }

    // Sobrescribe reutilizando la logica de Empleado y suma el bono
    @Override
    public double calcularSalarioNeto() {
        double salarioEmpleado = super.calcularSalarioNeto();  // Reusa la formula base
        return salarioEmpleado + bonoEstrategico;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();            // Complementa, no sobreescribe
        System.out.println("Departamento: " + departamento);
        System.out.println("Bono Estrategico: $" + bonoEstrategico);
        System.out.println("Ingreso Neto Total: $" + calcularSalarioNeto());
    }
}
