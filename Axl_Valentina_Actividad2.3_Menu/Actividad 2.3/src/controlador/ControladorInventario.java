package controlador;

import modelo.Bodega;
import modelo.Producto;
import vista.Consola;


// controlador principal que conecta la bodega y el sistema
public class ControladorInventario {
    private final Bodega bodega;
    private final Consola vista; 

    // recibe modelo y vista, configurando la interfaz
    public ControladorInventario(Bodega bodega, Consola vista) {
        this.bodega = bodega;
        this.vista = vista;
        configurarListeners();
        System.out.println("GESTIÓN DE INVENTARIO");
    }

    // asocia los botones con el método del controlador
    private void configurarListeners() {
        vista.setAgregarProductoListener(e -> agregarProducto());
        vista.setAgregarStockListener(e -> agregarStock());
        vista.setRestarStockListener(e -> restarStock());
        vista.setReporteInventarioListener(e -> generarReporteInventario());
        vista.setSalirListener(e -> {
            System.out.println("SALIENDO DEL SISTEMA");
            System.exit(0);
        });
    }
    // agregar un producto o suma stock si ya existe
    private void agregarProducto() {
        System.out.println("AGREGAR PRODUCTO ");
        String nombre = vista.mostrarInputDialog("Ingrese el producto:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            int stock = vista.mostrarInputDialogEntero("Ingrese el stock:");
            if (stock >= 0) {
                Producto productoExistente = bodega.buscarProducto(nombre);
                if (productoExistente != null) {
                    int stockAnterior = productoExistente.getStock();
                    bodega.agregarStock(nombre, stock);
                    int stockNuevo = productoExistente.getStock();
                    System.out.println(" Producto '" + nombre + "' Stock actualizado:");
                    System.out.println(" Stock anterior: " + stockAnterior);
                    System.out.println(" Stock agregado: " + stock);
                    System.out.println(" Stock nuevo: " + stockNuevo);
                } else {
                    // si no existe, crea un nuevo producto y lo agrega a la bodega
                    bodega.agregarProducto(nombre, stock);
                    System.out.println(" Nuevo producto '" + nombre + "' agregado con stock: " + stock);
                }
            } else {
                System.out.println(" Error: El stock no puede ser negativo");
            }
        } else {
            System.out.println(" Error: Debe ingresar el nombre del producto");
        }
    }
    // agrega stock o lo actualiza si ya existe
    private void agregarStock() {
        System.out.println(" AGREGAR STOCK ");
        String nombre = vista.mostrarInputDialog("Ingresar el nombre del producto:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            int cantidad = vista.mostrarInputDialogEntero("Ingrese la cantidad a agregar:");
            if (cantidad > 0) {
                boolean exito = bodega.agregarStock(nombre, cantidad);
                if (exito) {
                    System.out.println(" Stock agregado: " + cantidad + " unidades a '" + nombre + "'");
                    Producto producto = bodega.buscarProducto(nombre);
                    if (producto != null) {
                        System.out.println(" Stock actual: " + producto.getStock());
                    }
                } else {
                    System.out.println(" Error: Producto '" + nombre + "' no encontrado");
                }
            } else {
                System.out.println(" Error: La cantidad debe ser mayor a 0");
            }
        }
    }
    // resta stock de un producto, validando su cantidad
    private void restarStock() {
        System.out.println("RESTAR STOCK");
        String nombre = vista.mostrarInputDialog("Ingrese el nombre del producto:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            int cantidad = vista.mostrarInputDialogEntero("Ingrese la cantidad a restar:");
            if (cantidad > 0) {
                boolean exito = bodega.restarStock(nombre, cantidad);
                if (exito) {
                    System.out.println(" Stock restado: " + cantidad + " unidades de '" + nombre + "'");
                    Producto producto = bodega.buscarProducto(nombre);
                    if (producto != null) {
                        System.out.println(" Stock actual: " + producto.getStock());
                    }
                } else {
                    // si el producto no existe o no hay suficiente stock, muestra un mensaje con el error
                    System.out.println(" Error: No se pudo restar stock.");
                }
            } else {
                System.out.println(" Error: La cantidad debe ser mayor a 0");
            }
        }
    }
    // muestra en consola el reporte de inventario
    private void generarReporteInventario() {
        System.out.println("\n" + bodega.generarReporteInventario());
    }

}
