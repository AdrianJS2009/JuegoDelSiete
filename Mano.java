/**
 * Explica tu código aquí
 * 
 * @author Adrián Jiménez Santiago
 */

public class Mano {

  // Atributos
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

  // Método para obtener la puntuación de la mano
  public double getPuntuacion() {
    double puntuacion = 0;
    for (int i = 0; i < contadorCartas; i++) {
      puntuacion += mano[i].getPuntuacion();
    }
    return puntuacion;
  }

  // Método para mostrar la mano
  public void mostrarMano() {
    System.out.print("Tu mano es: ");
    for (int i = 0; i < contadorCartas; i++) {
      System.out.print(mano[i] + " ");
    }
    System.out.println();
  }
}
