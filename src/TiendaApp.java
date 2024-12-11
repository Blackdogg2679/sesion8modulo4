import java.util.ArrayList;
import java.util.Scanner;

public class TiendaApp {
    private static ArrayList<Producto> inventario = new ArrayList<>();
    private static ArrayList<Producto> carrito = new ArrayList<>();
    private static Vendedor vendedor;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarInventario();
        inicializarVendedor();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    agregarAlCarrito();
                    break;
                case 3:
                    listarCarrito();
                    break;
                case 4:
                    realizarPago();
                    break;
                case 5:
                    System.out.println("Gracias por usar la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void inicializarInventario() {
        inventario.add(new Vegetal("Tomate", "V001", 2000, "2023-06-01", "2023-06-10"));
        inventario.add(new Vegetal("Lechuga", "V002", 1000, "2023-06-02", "2023-06-08"));
        inventario.add(new Vestuario("Camiseta", "R001", 15000, "M", "Azul"));
        inventario.add(new Vestuario("Pantalón", "R002", 29000, "L", "Negro"));
    }

    private static void inicializarVendedor() {
        vendedor = new Vendedor("Juan Pérez", "12345678-9");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Listar productos en el carrito");
        System.out.println("4. Pagar");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void listarProductos() {
        System.out.println("\n--- Productos disponibles ---");
        for (Producto p : inventario) {
            System.out.println(p.getCodigo() + " - " + p.getNombre() + " - $" + p.getPrecio());
        }
    }

    private static void agregarAlCarrito() {
        if (carrito.size() >= 10) {
            System.out.println("El carrito está lleno. No se pueden agregar más productos.");
            return;
        }

        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        for (Producto p : inventario) {
            if (p.getCodigo().equals(codigo)) {
                carrito.add(p);
                System.out.println("Producto agregado al carrito.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    private static void listarCarrito() {
        System.out.println("\n--- Productos en el carrito ---");
        for (Producto p : carrito) {
            System.out.println(p.getCodigo() + " - " + p.getNombre() + " - $" + p.getPrecio());
        }
    }

    private static void realizarPago() {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío. No hay nada que pagar.");
            return;
        }

        double total = 0;
        for (Producto p : carrito) {
            total += p.getPrecio();
        }

        Venta venta = new Venta(vendedor);
        venta.setGanancia(total);

        System.out.println("\n--- Resumen de la venta ---");
        System.out.println("Total a pagar: $" + total);
        System.out.println("Vendedor: " + vendedor.getNombre());
        System.out.println("RUT del vendedor: " + vendedor.getRut());

        carrito.clear();
        System.out.println("Pago realizado. ¡Gracias por su compra!");
    }
}