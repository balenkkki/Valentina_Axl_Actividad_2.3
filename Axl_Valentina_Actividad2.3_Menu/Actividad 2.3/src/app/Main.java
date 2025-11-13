package app;

import modelo.Bodega;
import vista.Consola;
import controlador.ControladorInventario;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // mensaje de inicio del sistema
        System.out.println("Iniciando Sistema");

        // ejecuta la interfaz gráfica
        SwingUtilities.invokeLater(() -> {

            // crea instancia del modelo (Bodega) y instancia de la vista (Consola)
            Bodega bodega = new Bodega();
            
            Consola vista = new Consola();
            
            // crea el controlador y conectar modelo y vista
            ControladorInventario controlador = new ControladorInventario(bodega, vista);

            // hace visible la ventana principal
            vista.setVisible(true);
        });
    }

}
