
/**
 * MainJuegoDelSiete
 */

import java.util.Arrays;
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

      if (apuesta == 0) {
        System.out.println("Gracias por jugar. Tu saldo final consta de: " + jugador.getSaldo());
        break;
      }

      if (apuesta > 0 && apuesta <= jugador.getSaldo()) {
        // Se inicia el juego
        // TODO: Método para barajar la baraja
        jugador.reiniciarMano();
        jugador.realizarApuesta(apuesta);

        // Turno del jugador
        while (true) {
          // TODO: Metodo para barajar las cartas Carta carta = baraja.repartir();
          // TODO: Metodo para recibir una carta jugador.recibirCarta(carta);

          System.out.println("Tus cartas son: " + Arrays.toString(jugador.getMano().getCartas()));
          System.out.println("Tú puntuación actual es de:" + jugador.getMano().calcularPuntuacion());
          System.out.println("Quieres robar otra carta?  (SI/NO)");
          char respuesta = sc.next().charAt(0);

          if (respuesta == "NO" || respuesta == "no" || jugador.getMano().calcularPuntuacion() >= 7.5) {
            break;
          }
        }
      }

    }
  }
}