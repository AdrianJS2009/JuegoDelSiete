
/**
 * Explica tu código aquí
 * 
 * @author Giovanni Giove
 * 
 * Adrián se ha encargado de refactorizar el código a ArrayLists (git reset --hard si queremos volver a la version con Arrays)
*/

import java.util.ArrayList;
import java.util.Collections;

class Baraja {

    // Atributos

    private ArrayList<Carta> cartas;
    private int index;

    // Constructor

    public Baraja() {
        cartas = new ArrayList<>();
        index = 0; // usaremos index a la hora de repartir las cartas

        String[] palos = { "Copas", "Bastos", "Oros", "Espadas" };
        String[] valores = { "1", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" };

        for (String palo : palos) {
            for (String valor : valores) {

                cartas.add(new Carta(palo, valor));
            }
        }
    }

    // Métodos

    public void barajar() {
        Collections.shuffle(cartas);
        index = 0; // Si ponemos indice 0 se reparten las cartas desde el primer objeto
    }

    public Carta repartir() {
        if (index < cartas.size()) {
            return cartas.get(index++);
        } else {
            System.out.println("No quedan cartas en la baraja."); // No deberia de ocurrir pero por si acaso.

            return null;
        }
    }
}