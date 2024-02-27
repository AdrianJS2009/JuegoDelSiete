/**
 * Explica tu código aquí
 * 
 * @author Adrián Jiménez Santiago
 */

public class Mano {

  // Atributos

  // Mantengo el array ya que nos interesa que no se puedan añadir más de 40
  // cartas
  private Carta[] mano;
  private int contadorCartas;

  // Constructor
  public Mano() {
    mano = new Carta[40]; // 40 cartas
    contadorCartas = 0;
  }

  // Métodos

  public void agregarCarta(Carta carta) {
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

  public void mostrarMano() {
    System.out.print("Tu mano es: ");
    for (int i = 0; i < contadorCartas; i++) {
      System.out.print(mano[i] + " ");
    }
    System.out.println();
  }
}
