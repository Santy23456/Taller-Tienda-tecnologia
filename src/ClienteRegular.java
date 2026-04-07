public class ClienteRegular extends Cliente {
    public ClienteRegular(String nombre, String identificacion, double valorCompra) {
        super(nombre, identificacion, valorCompra);
    }
    @Override
    public double calcularTotalPagar() {
        if (valorCompra > 300000) return valorCompra - descontar(8);
        if (valorCompra > 150000) return valorCompra - descontar(5);
        if (valorCompra < 60000) return valorCompra + aumentar(6);
        return valorCompra;
    }
}