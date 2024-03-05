import java.util.Scanner;

public class MainJuegoDelSiete {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_BOLD = "\u001B[1m";
  public static final String ANSI_UNDERLINE = "\u001B[4m";
  public static final String ANSI_ITALIC = "\u001B[3m";

  public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    Baraja baraja = new Baraja();
    Jugador jugador = new Jugador(100.00); // Saldo inicial del jugador

    while (true) {
      System.out.println(
          ANSI_BLUE + ANSI_BOLD + "########## " + ANSI_UNDERLINE + "JUEGO DEL SIETE" + " ##########" + ANSI_RESET);
      System.out.println("Tu saldo actual es de: " + ANSI_GREEN + jugador.getSaldo() + ANSI_RESET);
      System.out.println("¿Cuánto quieres apostar? (" + ANSI_ITALIC + "Pulse 0 para salir" + ANSI_RESET + ")");
      double apuesta = sc.nextDouble();

      if (apuesta == 0) {
        System.out.println("Gracias por jugar. Tu saldo final es: " + ANSI_GREEN + jugador.getSaldo() + ANSI_RESET);
        break;
      }

      if (apuesta > 0 && apuesta <= jugador.getSaldo()) {
        jugador.resetearMano();
        baraja.barajar();
        jugador.realizarApuesta(apuesta);

        // Turno del jugador
        while (true) {
          Carta carta = baraja.repartir();
          if (carta != null) {
            jugador.recibirCarta(carta);
            jugador.mostrarMano();
            System.out.println("Tu puntuación actual es de: " + ANSI_GREEN + jugador.getPuntuacion() + ANSI_RESET);

            if (jugador.getPuntuacion() >= 7.5) {
              break;
            }

            System.out.println("¿Quieres robar otra carta? (" + ANSI_ITALIC + "SI/NO" + ANSI_RESET + ")");
            String respuesta = sc.next();

            if (respuesta.equalsIgnoreCase("NO")) {
              break;
            }
          } else {
            break;
          }
        }

        // Turno de la banca
        double puntuacionBanca = 0;
        while (puntuacionBanca <= 7.5) {
          Carta carta = baraja.repartir();
          if (carta != null) {
            puntuacionBanca += carta.getPuntuacion();
          } else {
            break;
          }
        }

        // Determinar y anunciar el ganador
        System.out.println("\n" + ANSI_UNDERLINE + "--- Resultados ---" + ANSI_RESET);
        System.out.println("Puntuación del jugador: " + ANSI_GREEN + jugador.getPuntuacion() + ANSI_RESET);
        System.out.println("Puntuación de la banca: " + ANSI_GREEN + puntuacionBanca + ANSI_RESET);

        if (jugador.getPuntuacion() <= 7.5 && (jugador.getPuntuacion() > puntuacionBanca || puntuacionBanca > 7.5)) {
          System.out.println(
              ANSI_GREEN + "¡Has ganado! Has recibido: " + (2 * jugador.getApuesta()) + " créditos. 🏆" + ANSI_RESET);
          jugador.ganarApuesta();
        } else {S
          System.out.println(ANSI_RED + "¡Has perdido! Pierdes " + jugador.getApuesta() + " créditos. 😞" + ANSI_RESET);
          jugador.perderApuesta();
        }

        jugador.resetearMano();

        // Preguntar si quiere seguir jugando
        System.out.print("\n¿Quieres seguir jugando? (" + ANSI_ITALIC + "S/N" + ANSI_RESET + "): ");
        char continuar = sc.next().charAt(0);
        if (continuar == 'N' || continuar == 'n') {
          System.out.println("Gracias por jugar. Tu saldo final es: " + ANSI_GREEN + jugador.getSaldo() + ANSI_RESET);
          break;
        }
      } else {
        System.out
            .println(ANSI_RED + "Apuesta no válida. Ingresa un monto entre 1 y " + jugador.getSaldo() + ANSI_RESET);
      }
    }
    sc.close();
  }
}