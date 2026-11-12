package Final_poo;

public class Estandar extends Paquete {
    public Estandar(String guia, double peso, Zona zona) {
        super(guia, peso, zona);
    }
    @Override
    public double calcularCosto() {
        return calcularBase();
    }
    @Override
    public String getNombreServicio() {
        return "Estándar";
    }
}
