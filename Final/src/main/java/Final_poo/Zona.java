package Final_poo;

public enum Zona {
    CENTRO(6000, 0),
    NORTE(8000, 1),
    SUR(8000, 2),
    ORIENTE(15000, 3);
    private final double tarifa;
    private final int ordenRuta;
    Zona(double tarifa, int ordenRuta) {
        this.tarifa = tarifa;
        this.ordenRuta = ordenRuta;
    }
    public double getTarifa() {
        return tarifa;
    }
    public int getOrdenRuta() {
        return ordenRuta;
    }
}
