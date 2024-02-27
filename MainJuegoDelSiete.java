
/** 
 * Main para la ejecución del juego
 * 
* @author Adrián Jiménez Santiago
*/

import java.util.Scanner;

public class MainJuegoDelSiete {
  // Gracias GPT
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_BOLD = "\u001B[1m";
  public static final String ANSI_UNDERLINE = "\u001B[4m";
  public static final String ANSI_ITALIC = "\u001B[3m";

  public static void main(String[] args) throws InterruptedException { // Excepción para Thread.sleep

    Scanner sc = new Scanner(System.in);
    Baraja baraja = new Baraja();
    Jugador jugador = new Jugador(100.00); // Saldo con el que comienza el player

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
        baraja.barajar();
        jugador.resetearMano();
        jugador.realizarApuesta(apuesta);

        // Turno del jugador
        while (true) {
          Carta carta = baraja.repartir();
          jugador.recibirCarta(carta);
          jugador.mostrarMano();
          System.out.println("Tu puntuación actual es de: " + ANSI_GREEN + jugador.getPuntuacion() + ANSI_RESET);
          System.out.println("¿Quieres robar otra carta? (" + ANSI_ITALIC + "SI/NO" + ANSI_RESET + ")");
          String respuesta = sc.next();

          if (respuesta.equalsIgnoreCase("NO") || jugador.getPuntuacion() >= 7.5) {
            System.out.print(ANSI_RED + "Terminando turno" + ANSI_RESET);

            for (int i = 0; i < 3; i++) {
              Thread.sleep(300); // tiempo de espera entre punto y punto
              System.out.print(".");
            }

            System.out.print(" ⌛");
            System.out.println();
            break;
          }
        }

        // Turno de la banca
        double puntuacionBanca = 0;
        while (puntuacionBanca < 7.5) {
          Carta carta = baraja.repartir();
          puntuacionBanca += carta.getPuntuacion();
        }

        // Determinar quien ha ganado
        double puntuacionJugador = jugador.getPuntuacion();

        System.out.println("\n" + ANSI_UNDERLINE + "--- Resultados ---" + ANSI_RESET);
        System.out.println("Puntuación del jugador: " + ANSI_GREEN + puntuacionJugador + ANSI_RESET);
        System.out.println("Puntuación de la banca: " + ANSI_GREEN + puntuacionBanca + ANSI_RESET);

        if (puntuacionJugador > 7.5 || (puntuacionBanca <= 7.5 && puntuacionBanca > puntuacionJugador)) {
          System.out.println(ANSI_RED + "¡Has perdido! Pierdes " + jugador.getApuesta() + " créditos. 😞" + ANSI_RESET);
          jugador.perderApuesta();
        } else {
          double ganancias = jugador.getApuesta() * 2;
          System.out.println(ANSI_GREEN + "¡Has ganado! Has recibido: " + ganancias + " créditos. 🏆" + ANSI_RESET);
          jugador.incrementarSaldo(ganancias);
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
  }
}
