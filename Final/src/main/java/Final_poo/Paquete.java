package Final_poo;

public abstract class Paquete{
    private final String guia;
    private final double peso;
    private final Zona zona;

    public Paquete(String guia, double peso, Zona zona) {
        this.guia = guia;
        this.peso = peso;
        this.zona = zona;
    }
    public String getGuia() {
        return guia;
    }
    public double getPeso() {
        return peso;
    }
    public Zona getZona() {
        return zona;
    }
    public double calcularBase() {
        return zona.getTarifa() + peso * 1000;
    }
    public abstract double calcularCosto();
    public abstract String getNombreServicio();
    public String getAjuste() {
        return "—";
    }
    @Override public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paquete)) {
            return false;
        }

        Paquete otro = (Paquete) obj;

        return guia.equals(otro.guia);
    }
    @Override public int hashCode() {
        return guia.hashCode();
    }
    @Override public String toString() {
        return "Guía: " + guia + " | Servicio: " + getNombreServicio()
                + " | Zona: " + zona + " | Peso: " + peso + " kg";
    }
}
