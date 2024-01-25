/**
 * Clase de Jugador
 * 
 * @author Adrián Jiménez Santiago
 */

class Jugador {

  // Atributos

  private Carta[] mano;
  private int contadorCartas;
  private double saldo;
  private double apuesta;

  // Constructor

  public Jugador(double saldoInicial) {
    mano = new Carta[40]; // 40 para asegurarme de que nunca nos quedamos cortos.
    contadorCartas = 0;
    saldo = saldoInicial;
  }

  // Métodos

  public void recibirCarta(Carta carta) {
    if (contadorCartas < mano.length) {
      mano[contadorCartas++] = carta;
    }
  }

  public double getPuntuacion() {
    double puntuacion = 0;
    for (int i = 0; i < contadorCartas; i++) {
      puntuacion += mano[i].getPuntuacion();
    }
    return puntuacion;
  }

  public void realizarApuesta(double cantidad) {
    if (cantidad <= saldo) {
      apuesta = cantidad;
      saldo -= cantidad;
    } else {
      System.out.println("Apuesta no válida. No tienes suficientes creditos.");
      apuesta = 0;
    }
  }

  public void ganarApuesta() {
    saldo += apuesta * 2;
  }

  public void perderApuesta() {
    saldo -= apuesta;
    if (saldo < 0) {
      saldo = 0;
    }
    apuesta = 0;
  }

  public void resetearMano() {
    contadorCartas = 0;
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
    System.out.print("Tus cartas son: ");
    for (int i = 0; i < contadorCartas; i++) {
      System.out.print(mano[i] + " ");
    }
    System.out.println();
  }
}