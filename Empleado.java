public class Empleado extends Persona {

    protected String idEmpleado;
    protected double salarioBase;

    public Empleado(String nombre, int edad, String idEmpleado, double salarioBase) {
        super(nombre, edad);                  // Reutiliza el constructor de Persona
        this.idEmpleado = idEmpleado;
        this.salarioBase = salarioBase;
    }

    // Calcula el salario neto aplicando 10% de retencion
    public double calcularSalarioNeto() {
        double retencion = salarioBase * 0.10;
        return salarioBase - retencion;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();           // Reutiliza la version de Persona
        System.out.println("ID Empleado: " + idEmpleado);
        System.out.println("Salario Base: $" + salarioBase);
        System.out.println("Salario Neto: $" + calcularSalarioNeto());
    }
}
