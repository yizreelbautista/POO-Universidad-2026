public class CuentaBancaria {
	private String numeroCuenta;
	private double saldo;

	public CuentaBancaria(String numeroCuenta, double saldoInicial) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldoInicial;
	}

	// Firma del método que delega la responsabilidad de manejo mediante 'throws'
	public void retirar(double monto) throws SaldoInsuficienteException {
		System.out.println("Procesando solicitud de retiro por: $" + monto);

		// Validación de regla de entrada (Unchecked Exception)
		if (monto <= 0) {
			throw new IllegalArgumentException("Error: El monto del retiro debe ser una cantidad positiva.");
		}

		// Validación de regla de negocio (Checked Exception Personalizada)
		if (monto > this.saldo) {
			throw new SaldoInsuficienteException(this.saldo, monto);
		}

		// Si pasa las validaciones, se reduce el saldo
		this.saldo -= monto;
		System.out.println("-> Retiro exitoso. Por favor tome su dinero.");
	}

	public double getSaldo() {
		return saldo;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
}

