
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
      System.out.println("¿Cúanto quieres apostar? (Pulse 0 para salir)");
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

          if (respuesta "NO" || respuesta == "no" || jugador.getMano().calcularPuntuacion() >= 7.5) {
            break;
          }
        }
      }

      // Turno de la banca
        Mano manoBanca = new Mano();
        while (manoBanca.calcularPuntuacion() < 7.5) {
          Carta carta = baraja.repartir();
          manoBanca.recibirCarta(carta);
        }

        // Determinar ganador
        double puntuacionJugador = jugador.getMano().calcularPuntuacion();
        double puntuacionBanca = manoBanca.calcularPuntuacion();

        System.out.println("Puntuación del jugador: " + puntuacionJugador);
        System.out.println("Puntuación de la banca: " + puntuacionBanca);

        if (puntuacionJugador > 7.5 || (puntuacionBanca <= 7.5 && puntuacionBanca > puntuacionJugador)) {
          System.out.println("¡Has perdido! Pierdes " + jugador.getApuesta() + " unidades.");
          jugador.reiniciarMano();
        } else {
          double ganancias = jugador.getApuesta() * 2;
          System.out.println("¡Has ganado! Ganancias: " + ganancias + " unidades.");
          jugador.incrementarSaldo(ganancias);
          jugador.reiniciarMano();
        }

        // Preguntar si quiere seguir jugando
        System.out.print("¿Quieres seguir jugando? (S/N): ");
        char continuar = scanner.next().charAt(0);
        if (continuar == 'N' || continuar == 'n') {
          System.out.println("Gracias por jugar. Tu saldo final es: " + jugador.getSaldo());
          break;
        }
      } else {
        System.out.println("Apuesta no válida. Ingresa un monto entre 1 y " + jugador.getSaldo());
      }
    }
}