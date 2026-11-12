package Final_poo;

public class Express extends Paquete {
    public Express(String guia, double peso, Zona zona) {
        super(guia, peso, zona);
    }
    @Override
    public double calcularCosto() {
        return calcularBase() * 1.5;
    }
    @Override
    public String getNombreServicio() {
        return "Express";
    }
    @Override
    public String getAjuste() {
        return "+50%";
    }
}
