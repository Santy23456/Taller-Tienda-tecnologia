import java.util.*;

public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("GESTIÓN DE VENTAS TIENDA TECNOLOGICA");
            System.out.println("1.Registrar Cliente Regular");
            System.out.println("2.Registrar Cliente Frecuente");
            System.out.println("3.Registrar Cliente Mayorista");
            System.out.println("4.Buscar Cliente por ID");
            System.out.println("5.Mostrar Todo");
            System.out.println("6.Calcular Total de Compra");
            System.out.println("7.Mostrar Compras Altas");
            System.out.println("8.Cliente con Mayor Pago");
            System.out.println("0.Salir");
            System.out.print("INGRESE EL NUMERO DE LA OPCION: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> registrarRegular();
                case 2 -> registrarFrecuente();
                case 3 -> registrarMayorista();
                case 4 -> buscarCliente();
                case 5 -> mostrarClientes();
                case 6 -> calcularTotal();
                case 7 -> mostrarComprasAltas();
                case 8 -> clienteMayorPago();
            }
        } while (opcion != 0);
    }

    private static void registrarRegular() {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Valor Compra: "); double v = sc.nextDouble();
        clientes.add(new ClienteRegular(n, id, v));
    }

    private static void registrarFrecuente() {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Valor Compra: "); double v = sc.nextDouble();
        System.out.print("Número de Compras: "); int num = sc.nextInt();
        clientes.add(new ClienteFrecuente(n, id, v, num));
    }

    private static void registrarMayorista() {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Valor Compra: "); double v = sc.nextDouble();
        System.out.print("Cantidad Productos: "); int cant = sc.nextInt();
        clientes.add(new ClienteMayorista(n, id, v, cant));
    }

    private static void buscarCliente() {
        System.out.print("Ingrese ID: ");
        String id = sc.nextLine();
        for (Cliente c : clientes) {
            if (c.getIdentificacion().equals(id)) {
                c.imprimirResumen(c.calcularTotalPagar());
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    private static void mostrarClientes() {
        for (Cliente c : clientes) {
            c.imprimirResumen(c.calcularTotalPagar());
        }
    }

    private static void mostrarComprasAltas() {
        System.out.println("Compras mayores a (>300.000)");
        for (Cliente c : clientes) {
            if (c.compraAlta()) {
                System.out.println(c.getNombre() + " - " + c.getIdentificacion());
            }
        }
    }

    private static void clienteMayorPago() {
        if (clientes.isEmpty()) return;
        Cliente mayor = clientes.get(0);
        for (Cliente c : clientes) {
            if (c.calcularTotalPagar() > mayor.calcularTotalPagar()) {
                mayor = c;
            }
        }
        System.out.print("El cliente con mayor pago es:");
        mayor.imprimirResumen(mayor.calcularTotalPagar());
    }

    private static void calcularTotal() {
        double global = 0;
        for (Cliente c : clientes) {
            global += c.calcularTotalPagar();
        }
        System.out.println("Total de todas las ventas: $" + global);
    }
}
