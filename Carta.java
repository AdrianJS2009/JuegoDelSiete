/**
 * Clase Carta
 * 
 * @author Giovanni Giove
 */
class Carta {

    // Atributos
    private String palo;
    private String valor;

    // Constructor
    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public double getPuntuacion() {
        switch (valor) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
                return Double.parseDouble(valor);
            case "Sota":
            case "Caballo":
            case "Rey":
                return 0.5;
            default:
                System.out.println("El valor de la carta es desconocido: " + valor);
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}