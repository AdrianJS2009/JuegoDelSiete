/**
 * Clase de Jugador
 * 
 * @author Adrián Jiménez Santiago
 */

class Jugador {

  // Atributos

  private Mano mano;
  private double saldo;
  private double apuesta;
  private double saldoInicial;

  // Constructor

  public Jugador(double saldoInicial) {
    mano = new Mano();
    saldo = saldoInicial;
    this.saldoInicial = saldoInicial;
  }

  // Métodos

  public void recibirCarta(Carta carta) {
    mano.agregarCarta(carta);
  }

  public double getPuntuacion() {
    return mano.getPuntuacion();
  }

  public void realizarApuesta(double cantidad) {
    if (cantidad <= saldo) {
      apuesta = cantidad;
      saldo -= cantidad;
    } else {
      System.out.println("No tienes suficiente saldo para realizar esa apuesta");

    }

    saldoInicial = saldo;
  }

  public void ganarApuesta() {
    saldo = apuesta * 2;
    saldoInicial = saldo;
  }

  public void perderApuesta() {
    saldo -= apuesta;
    if (saldo < 0) {
      saldo = 0;
    }
    apuesta = 0;
  }

  public void resetearMano() {
    mano = new Mano();
  }

  public double getSaldo() {
    return saldo;
  }

  public void incrementarSaldo(double monto) {
    saldo += monto;
  }

  public double getApuesta() {
    return apuesta;
  }

  public void mostrarMano() {
    mano.mostrarMano();
  }

  public double getSaldoInicial() {
    return saldoInicial;
  }

}