public class ClienteFrecuente extends Cliente {
    private int numeroCompras;
    public ClienteFrecuente(String nombre, String id, double valor, int numeroCompras) {
        super(nombre, id, valor);
        this.numeroCompras = numeroCompras;
    }
    @Override
    public double calcularTotalPagar() {
        double descuento;
        if (numeroCompras > 20) descuento = 30;
        else if (numeroCompras > 10) descuento = 20;
        else descuento = 10;
        double total = valorCompra - descontar(descuento);
        if (compraAlta()) {
            total -= descontar(5);
        }
        return total;
    }
}
