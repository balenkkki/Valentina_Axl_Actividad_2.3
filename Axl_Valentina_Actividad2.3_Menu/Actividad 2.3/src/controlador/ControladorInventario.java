package controlador;

import modelo.Bodega;
import modelo.Producto;
import vista.Consola;



public class ControladorInventario {
    private final Bodega bodega;
    private final Consola vista; 


    public ControladorInventario(Bodega bodega, Consola vista) {
        this.bodega = bodega;
        this.vista = vista;
        configurarListeners();
        System.out.println("GESTIÓN DE INVENTARIO");
    }

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
                    // Si no existe, crea un nuevo producto y lo agrega a la bodega
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
                    System.out.println(" Error: No se pudo restar stock.");
                }
            } else {
                System.out.println(" Error: La cantidad debe ser mayor a 0");
            }
        }
    }
    private void generarReporteInventario() {
        System.out.println("\n" + bodega.generarReporteInventario());
    }
}