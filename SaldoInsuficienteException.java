public class SaldoInsuficienteException extends Exception {
    private double saldoActual;
    private double montoSolicitado;

    public SaldoInsuficienteException(
double saldoActual,
double montoSolicitado) {
super("Fondos insuficientes: para complementar el retiro");
this.saldoActual = saldoActual;
this.montoSolicitado = montoSolicitado;
}

public double getSaldoActual() {
return saldoActual;
}
public double getMontoSolicitado() {
return montoSolicitado;
}
}