
/**
 * MainJuegoDelSiete
 */

import java.util.Scanner;

public class MainJuegoDelSiete {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Baraja baraja = new Baraja();
    Jugador jugador = new Jugador(100.00);

    while (true) {
      System.out.println("########## JUEGO DEL SIETE ##########");
      System.out.println("Tu sueldo actual es de: " + jugador.getSaldo());
      System.out.println("¿Cúantos quieres apostar? (Pulse 0 para salir)");
      double apuesta = sc.nextDouble();

    }
  }
}