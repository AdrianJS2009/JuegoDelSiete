/**
 * Explica tu código aquí
 * 
 * @author Adrián Jiménez Santiago
 */

class Jugador {

  // Attributos
  private Mano mano;
  private double saldo;
  private double apuesta;

  public Jugador(double saldoInicial) {
    mano = new Mano();
    saldo = saldoInicial;
    apuesta = 0;
  }

  // Métodos
  public void recibirCarta(Carta carta) {
    mano.recibirCarta(carta);
  }

  public double realizarApuesta(double monto) {
    if (monto <= saldo) {
      apuesta = monto;
      saldo -= apuesta;
      return apuesta;
    } else {
      System.out.println("No tienes tanto saldo como para apostar esa cantidad.");
      return 0;
    }
  }

  public void incrementarSaldo(double monto) {
    saldo += monto;
  }

  public void reiniciarMano() {
    mano.reiniciar();
    apuesta = 0;
  }

  // Getters
  public double getSaldo() {
    return saldo;
  }

  public double getApuesta() {
    return apuesta;
  }

  public Mano getMano() {
    return mano;
  }
}