
/**
 * Explica tu código aquí
 * 
 * @author Giovanni Giove
*/

import java.util.Random;

class Baraja {

    // Atributos

    private Carta[] cartas;
    private int index;

    // Constructor

    public Baraja() {
        cartas = new Carta[40];
        index = 0; // usaremos index a la hora de repartir las cartas

        String[] palos = { "Copas", "Bastos", "Oros", "Espadas" };
        String[] valores = { "1", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" };

        int i = 0;
        for (int paloIndex = 0; paloIndex < palos.length; paloIndex++) {
            for (int valorIndex = 0; valorIndex < valores.length; valorIndex++) {
                cartas[i] = new Carta(palos[paloIndex], valores[valorIndex]);
                i++;
            }
        }
    }

    // Métodos

    public void barajar() {
        Random numAzar = new Random(); // Utilizo la clase Random para generar números random
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = numAzar.nextInt(i + 1); // j es numero random entre 0 y i
            // Barajamos las cartas
            Carta aux = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = aux;
        }
        index = 0; // Si ponemos indice 0 se reparten las cartas desde el primer objeto
    }

    public Carta repartir() {
        if (index < cartas.length) {
            return cartas[index++];
        } else {
            System.out.println("No quedan cartas en la baraja."); // No deberia de ocurrir pero por si acaso.

            return null;
        }
    }
}