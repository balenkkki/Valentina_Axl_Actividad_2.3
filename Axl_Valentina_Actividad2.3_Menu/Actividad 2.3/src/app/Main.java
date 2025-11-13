package app;

import modelo.Bodega;
import vista.Consola;
import controlador.ControladorInventario;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Mensaje de inicio del sistema
        System.out.println("Iniciando Sistema");

        // Ejecutar la interfaz gráfica en el hilo de eventos de Swing  
        SwingUtilities.invokeLater(() -> {

            // Crear instancia del modelo (Bodega),instancia de la vista (Consola)
            Bodega bodega = new Bodega();
            
            Consola vista = new Consola();
            
            // Crear el controlador y conectar modelo y vista
            ControladorInventario controlador = new ControladorInventario(bodega, vista);

            // Hacer visible la ventana principal
            vista.setVisible(true);
        });
    }
}