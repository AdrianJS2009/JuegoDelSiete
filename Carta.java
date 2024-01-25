/**
 * Carta
 */

class Carta {
    private String palo;
    private String valor;

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
            case "J": // Para Jota, que asumimos es equivalente a Sota
            case "Q": // Para Queen, que asumimos es equivalente a Caballo
            case "K": // Para King, que asumimos es equivalente a Rey
                return 0.5;
            default:
                System.out.println("Valor de carta desconocido: " + valor);
                return 0;
        }
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}