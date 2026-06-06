public class Main {

    public static void main(String[] args) {

        System.out.println("===== EMPLEADO =====");
        Empleado emp = new Empleado("Ana Torres", 30, "E-001", 20000.0);
        emp.mostrarInformacion();
        System.out.println("Nomina Neta Estimada: $" + emp.calcularSalarioNeto());

        System.out.println();
        System.out.println("===== GERENTE =====");
        Gerente ger = new Gerente("Luis Perez", 45, "G-010", 40000.0,
                                  "Operaciones", 8000.0);
        ger.mostrarInformacion();
        System.out.println("Nomina Neta Estimada: $" + ger.calcularSalarioNeto());
    }
}
