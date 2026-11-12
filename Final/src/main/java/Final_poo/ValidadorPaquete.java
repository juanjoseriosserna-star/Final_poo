package Final_poo;

public class ValidadorPaquete {
    public static void validarGuia(String guia)
            throws GuiaInvalidaException {
        if (guia == null || !guia.matches("EY[0-9]{4}")) {
            throw new GuiaInvalidaException("La guía " + guia +
                            " debe tener el formato EY seguido de cuatro números."
            );
        }
    }

    public static void validarPeso(double peso)
            throws PesoInvalidoException {

        if (peso <= 0) {
            throw new PesoInvalidoException(
                    "El peso debe ser mayor que cero."
            );
        }
    }

    public static void validarPesoMoto(double peso)
            throws PesoNoPermitidoException {

        if (peso > 20) {
            throw new PesoNoPermitidoException(
                    "El paquete pesa " + peso +
                            " kg y supera el límite individual de 20 kg."
            );
        }
    }
    public static void validarContenido(String contenido)
            throws ContenidoInvalidoException {

        if (contenido == null || contenido.trim().isEmpty()) {
            throw new ContenidoInvalidoException(
                    "El paquete frágil necesita indicar su contenido."
            );
        }
    }
}