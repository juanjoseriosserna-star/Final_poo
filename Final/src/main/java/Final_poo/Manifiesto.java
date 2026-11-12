package Final_poo;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Manifiesto{
    private static int consecutivo = 1;
    private final String codigo;
    private final String mensajero;
    private final List<Paquete> paquetes;
    public Manifiesto(String mensajero) {
        if (mensajero == null || mensajero.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del mensajero es obligatorio."
            );
        }
        this.codigo = "D-" + consecutivo++;
        this.mensajero = mensajero;
        this.paquetes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensajero() {
        return mensajero;
    }

    public List<Paquete> getPaquetes() {
        return Collections.unmodifiableList(paquetes);
    }

    public double calcularPesoTotal() {

        double total = 0;

        for (Paquete paquete : paquetes) {
            total += paquete.getPeso();
        }

        return total;
    }

    public void registrarPaquete(Paquete paquete)
            throws GuiaDuplicadaException,
            CapacidadExcedidaException {

        if (paquete == null) {
            throw new IllegalArgumentException(
                    "No se puede registrar un paquete nulo."
            );
        }
        for (Paquete existente : paquetes) {
            if (existente.equals(paquete)) {

                throw new GuiaDuplicadaException(
                        "La guía " + paquete.getGuia() +
                                " ya está registrada en el despacho."
                );
            }
        }
        double nuevoPeso =
                calcularPesoTotal() + paquete.getPeso();

        if (nuevoPeso > 30) {

            throw new CapacidadExcedidaException(
                    "El paquete " + paquete.getGuia() +
                            " no se agregó. El despacho alcanzaría " +
                            nuevoPeso + " kg y el máximo es 30 kg."
            );
        }

        paquetes.add(paquete);

        System.out.println(
                "Paquete " + paquete.getGuia() +
                        " registrado correctamente."
        );
    }

    public double liquidarRuta() {

        double total = 0;

        for (Paquete paquete : paquetes) {
            total += paquete.calcularCosto();
        }

        return total;
    }

    private String dinero(double valor) {

        return "$" +
                String.format("%,.0f", valor).replace(',', '.');
    }

    public void imprimirManifiesto() {

        List<Paquete> ordenados =
                new ArrayList<>(paquetes);

        ordenados.sort(
                ComparadorPaquetes.crearComparador()
        );

        System.out.println("\n========================================");
        System.out.println(
                "Despacho " + codigo +
                        " - Mensajero: " + mensajero
        );
        System.out.println("========================================");

        System.out.printf(
                "%-9s %-22s %-10s %-9s %-13s %-10s %-13s%n",
                "Guía", "Servicio", "Zona", "Peso",
                "Costo base", "Ajuste", "Costo envío"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (Paquete paquete : ordenados) {

            System.out.printf(
                    "%-9s %-22s %-10s %-9s %-13s %-10s %-13s%n",

                    paquete.getGuia(),

                    paquete.getNombreServicio(),

                    paquete.getZona(),

                    paquete.getPeso() + " kg",

                    dinero(paquete.calcularBase()),

                    paquete.getAjuste(),

                    dinero(paquete.calcularCosto())
            );
        }

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        System.out.println(
                "Peso total: " + calcularPesoTotal() + " kg"
        );

        System.out.println(
                "Costo total del despacho: " +
                        dinero(liquidarRuta())
        );

        System.out.println("\nADVERTENCIAS:");

        boolean tieneAdvertencias = false;

        for (Paquete paquete : ordenados) {

            if (paquete instanceof ManejoEspecial) {

                ManejoEspecial especial =
                        (ManejoEspecial) paquete;

                System.out.println(
                        paquete.getGuia() + " - " +
                                especial.obtenerAdvertencia()
                );

                tieneAdvertencias = true;
            }
        }

        if (!tieneAdvertencias) {
            System.out.println("No hay advertencias.");
        }

        System.out.println("========================================\n");
    }
}

