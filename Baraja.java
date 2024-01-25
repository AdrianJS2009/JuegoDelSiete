
/**
 * Baraja
 */
import java.util.Random;

class Baraja {
    private Carta[] cartas;
    private int index;

    public Baraja() {
        cartas = new Carta[40];
        index = 0;

        String[] palos = { "Oros", "Copas", "Espadas", "Bastos" };
        String[] valores = { "1", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" };

        int i = 0;
        for (String palo : palos) {
            for (String valor : valores) {
                cartas[i] = new Carta(palo, valor);
                i++;
            }
        }
    }

    public void barajar() {
        Random rand = new Random();
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Intercambio de cartas
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
        index = 0; // Reiniciar el índice después de barajar
    }

    public Carta repartir() {
        if (index < cartas.length) {
            return cartas[index++];
        } else {
            System.out.println("No quedan cartas en la baraja.");
            return null;
        }
    }
}