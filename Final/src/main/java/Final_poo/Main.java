package Final_poo;

public class Main {
    public static void main(String[] args) {
        Estandar p1 = new Estandar("EY2001", 5, Zona.ORIENTE);
        Express p2 = new Express("EY2002", 1.5, Zona.NORTE);
        Fragil p3 = new Fragil("EY2003", 2, Zona.CENTRO, "vajilla");
        Estandar p4 = new Estandar("EY2004", 8, Zona.CENTRO);
        Express p5 = new Express("EY2005", 6, Zona.ORIENTE);
        Fragil p6 = new Fragil("EY2006", 3.5, Zona.SUR, "televisor");

        System.out.println(p1.calcularCosto());
        System.out.println(p2.calcularCosto());
        System.out.println(p3.calcularCosto());

        System.out.println(p3.obtenerAdvertencia());
        System.out.println(p4.calcularCosto());
        System.out.println(p5.calcularCosto());
        System.out.println(p6.calcularCosto());

        System.out.println(p6.obtenerAdvertencia());
    }
}
