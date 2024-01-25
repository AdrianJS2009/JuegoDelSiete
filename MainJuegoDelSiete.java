import java.util.Scanner;

public class MainJuegoDelSiete {

  // Colores ANSI b(sacados de internete)
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_BOLD = "\u001B[1m";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Baraja baraja = new Baraja();
    Jugador jugador = new Jugador(100.00);

    while (true) {
      System.out.println(ANSI_BLUE + ANSI_BOLD + "########## JUEGO DEL SIETE ##########" + ANSI_RESET);
      System.out.println("Tu saldo actual es de: " + ANSI_GREEN + jugador.getSaldo() + ANSI_RESET);
      System.out.println("¿Cuánto quieres apostar? (Pulse 0 para salir)");
      double apuesta = scanner.nextDouble();

      if (apuesta == 0) {
        System.out.println("Gracias por jugar. Tu saldo final es: " + jugador.getSaldo());
        break;
      }

      if (apuesta > 0 && apuesta <= jugador.getSaldo()) {
        baraja.barajar();
        jugador.resetearMano();
        jugador.realizarApuesta(apuesta);

        // Turno del jugador
        while (true) {
          Carta carta = baraja.repartir();
          jugador.recibirCarta(carta);

          jugador.mostrarMano();
          System.out.println("Tu puntuación actual es de: " + jugador.getPuntuacion());
          System.out.println("¿Quieres robar otra carta? (SI/NO)");
          String respuesta = scanner.next();

          if (respuesta.equalsIgnoreCase("NO") || jugador.getPuntuacion() >= 7.5) {
            System.out.println(ANSI_RED + "Terminando turno...." + ANSI_RESET);
            break;
          }
        }

        // Turno de la banca
        double puntuacionBanca = 0;
        while (puntuacionBanca < 7.5) {
          Carta carta = baraja.repartir();
          puntuacionBanca += carta.getPuntuacion();
        }

        // Determinar ganador
        double puntuacionJugador = jugador.getPuntuacion();

        System.out.println("Puntuación del jugador: " + puntuacionJugador);
        System.out.println("Puntuación de la banca: " + puntuacionBanca);

        if (puntuacionJugador > 7.5 || (puntuacionBanca <= 7.5 && puntuacionBanca > puntuacionJugador)) {
          System.out.println(ANSI_RED + "¡Has perdido! Pierdes " + jugador.getApuesta() + " unidades." + ANSI_RESET);
          jugador.perderApuesta();
        } else {
          double ganancias = jugador.getApuesta() * 2;
          System.out.println(ANSI_GREEN + "¡Has ganado! Ganancias: " + ganancias + " unidades." + ANSI_RESET);
          jugador.incrementarSaldo(ganancias);
        }

        jugador.resetearMano();

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

    scanner.close();
  }
}
