package Final_poo;

public class Fragil extends Paquete implements ManejoEspecial {
    private final String contenido;
    public Fragil(String guia, double peso,
                  Zona zona, String contenido) {
        super(guia, peso, zona);
        this.contenido = contenido;
    }
    public String getContenido() {
        return contenido;
    }
    @Override
    public double calcularCosto() {
        return calcularBase() + 5000;
    }
    @Override
    public String getNombreServicio() {
        return "Frágil";
    }
    @Override
    public String getAjuste() {
        return "+5.000";
    }
    @Override
    public String obtenerAdvertencia() {
        return "FRÁGIL (" + contenido + ")";
    }
}

