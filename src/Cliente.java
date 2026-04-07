public class Cliente {
    protected String nombre;
    protected String identificacion;
    protected double valorCompra;

    public Cliente(String nombre, String identificacion, double valorCompra) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.valorCompra = valorCompra;
    }

    public double calcularTotalPagar() {
        return valorCompra;
    }

    public double descontar(double porcentaje) {
        return valorCompra * (porcentaje / 100);
    }

    public double aumentar(double porcentaje) {
        return valorCompra * (porcentaje / 100);
    }

    public boolean compraAlta() {
        return valorCompra > 300000;
    }

    public void imprimirResumen(double total) {

        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + identificacion);
        System.out.println("Valor Original: $" + valorCompra);
        System.out.println("Valor Final: $" + total);

    }

    public String getIdentificacion() { return identificacion; }
    public String getNombre() { return nombre; }
}