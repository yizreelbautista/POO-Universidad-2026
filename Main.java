public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE TRANSACCIONES ATM V2.0 ===\n");

        // Creamos una cuenta con un saldo inicial de $5,000.00
        CuentaBancaria cuenta = new CuentaBancaria("CTA-987654", 5000.0);

        // CASO DE PRUEBA 1: Intento de retiro que excede el saldo
        ejecutarTransaccionATM(cuenta, 6500.0);
        System.out.println("\n-----------------------------------------\n");

        // CASO DE PRUEBA 2: Intento de retiro con cantidad inválida (Negativa)
        ejecutarTransaccionATM(cuenta, -100.0);
    }

    public static void ejecutarTransaccionATM(CuentaBancaria c, double monto) {
        try {
            System.out.println("Abriendo sesión de usuario para la cuenta: " + c.getNumeroCuenta());
            c.retirar(monto); // Este código puede lanzar excepciones
            
        } catch (SaldoInsuficienteException e) {
            // Captura y tratamiento específico de laChecked Exception de negocio
            System.out.println("[ALERTA CAJERO] " + e.getMessage());
            System.out.println("Detalles técnicos:");
            System.out.println("  > Saldo disponible: $" + e.getSaldoActual());
            System.out.println("  > Monto solicitado: $" + e.getMontoSolicitado());
            System.out.println("  > Faltante: $" + (e.getMontoSolicitado() - e.getSaldoActual()));

        } catch (IllegalArgumentException e) {
            // Captura y tratamiento de la Unchecked Exception de formato
            System.out.println("[ALERTA SISTEMA] " + e.getMessage());

        } finally {
            // Cierre obligatorio de recursos / liberación de hardware
            System.out.println("Clasificando transacción... Imprimiendo recibo.");
            System.out.println("Saldo remanente en cuenta: $" + c.getSaldo());
            System.out.println("Cerrando sesión de forma segura. Retire su tarjeta de débito.");
        }
    }
}
