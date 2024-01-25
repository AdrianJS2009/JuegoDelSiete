/**
 * Carta
 */
import java.util.Arrays;
import java.util.Random;

class Carta {
    private String palo;
    private String valor;

    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public double getPuntuacion() {
      double numero = 0.0;
      switch (valor) {
          case "1":
          case "2":
          case "3":
          case "4":
          case "5":
          case "6":
          case "7":
              numero = Integer.parseInt(valor);
              break;
          case "J":
          case "Q":
          case "K":
              numero = 0.5;
              break;
          default:
              System.out.println("Valor de carta desconocido: " + valor);
      }
      return numero;
  }

  @Override
  public String toString() {
      return valor + " de " + palo;
  }
}