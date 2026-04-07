public class ClienteMayorista extends Cliente {
    private int cantidadProductos;
    public ClienteMayorista(String nombre, String id, double valor, int cantidad) {
        super(nombre, id, valor);
        this.cantidadProductos = cantidad;
    }
    @Override
    public double calcularTotalPagar() {
        double total;
        if (cantidadProductos > 50) total = valorCompra * 0.50;
        else if (cantidadProductos > 20) total = valorCompra * 0.65;
        else total = valorCompra * 0.80;
        return Math.min(total, 500000);
    }
}
