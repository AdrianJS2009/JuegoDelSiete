/**
 * Clase Jugador que se encarga de la logica de las apuestas y cartas.
 * 
 * @author Adrián Jiménez Santiago
 */

public class Jugador {
  private Carta[] mano;
  private int contadorCartas;
  private double saldo;
  private double apuesta;

  public Jugador(double saldoInicial) {
    mano = new Carta[40]; // Un tamaño suficientemente grande para evitar quedarse sin espacio
    contadorCartas = 0;
    saldo = saldoInicial;
  }

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
      System.out.println("Apuesta no válida. No tienes suficiente saldo.");
      apuesta = 0;
    }
  }

  public void ganarApuesta() {
    saldo += apuesta * 2; // El jugador recupera su apuesta y gana una cantidad igual
  }

  public void perderApuesta() {

  }

  public void resetearMano() {
    contadorCartas = 0;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public void incrementarSaldo(double monto) {
    saldo += monto;
  }

  public double getApuesta() {
    return apuesta;
  }

  public void setApuesta(double apuesta) {
    this.apuesta = apuesta;
  }

  public void mostrarMano() {
    System.out.print("Tus cartas son: ");
    for (int i = 0; i < contadorCartas; i++) {
      System.out.print(mano[i] + " ");
    }
    System.out.println();
  }
}
