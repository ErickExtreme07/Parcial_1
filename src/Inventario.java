import java.util.Scanner;

public class Inventario {

    private static String[] nombresProductos = new String[10]; // Tamaño del inventario
    private static int[] cantiProduct = new int[10];
    private static int cantiProducts = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTIÓN DE INVENTARIO ZAPATOS GALA ---");
            System.out.println("1. Ingresar nombre de producto");
            System.out.println("2. Vender un producto");
            System.out.println("3. Duplicar inventario de un producto vendido");
            System.out.println("4. Mostrar el inventario Actual");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción(numero) deseado: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            switch (opcion) {
                case 1:
                    ingresarProducto(scanner);
                    break;
                case 2:
                    venderProducto(scanner);
                    break;
                case 3:
                    duplicarInventario(scanner);
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Por favor, escribir el numero de la opción deseada");
            }
        }
        scanner.close();
    }

    private static void ingresarProducto(Scanner scanner) {
        if (cantiProducts < nombresProductos.length) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la cantidad inicial en inventario: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiamos
            nombresProductos[cantiProducts] = nombre;
            cantiProduct[cantiProducts] = cantidad;
            cantiProducts++;
            System.out.println("Producto registrado");
        } else {
            System.out.println("Inventario lleno (Maximo 10 Productos)");
        }
    }

    private static void venderProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto que desea vender: ");
        String nombre = scanner.nextLine();
        int indice = encontrarProducto(nombre);
        if (indice != -1) {
            System.out.print("Ingrese la cantidad a vender: ");
            int cantidadVenta = scanner.nextInt();
            scanner.nextLine(); // Limpiar
            if (cantidadVenta <= cantiProduct[indice]) {
                cantiProduct[indice] -= cantidadVenta;
                System.out.println("Venta realizada");
            } else {
                System.out.println("No hay suficiente Inventario para realizar la venta");
            }
        } else {
            System.out.println("No existe en inventario");
        }
    }

    private static void duplicarInventario(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a duplicar: ");
        String nombre = scanner.nextLine();
        int indice = encontrarProducto(nombre);
        if (indice != -1) {
            cantiProduct[indice] *= 2;
            System.out.println("Se ha duplicado el Inventario");
        } else {
            System.out.println("No existe en el inventario");
        }
    }

    private static void mostrarInventario() {
        System.out.println("--- INVENTARIO ACTUAL ---");
        for (int i = 0; i < cantiProducts; i++) {
            System.out.println(nombresProductos[i] + ": " + cantiProduct[i]);
        }
    }

    private static int encontrarProducto(String nombre) {
        for (int i = 0; i < cantiProducts; i++) {
            if (nombresProductos[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }
}