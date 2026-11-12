package Final_poo;

import java.util.Comparator;

public class ComparadorPaquetes {
    public static Comparator<Paquete> crearComparador() {
        return Comparator.comparingInt((Paquete p) -> p instanceof Express ? 0 : 1)
                .thenComparingInt(p -> p.getZona().ordinal()).thenComparing(Paquete::getGuia);
    }
}
