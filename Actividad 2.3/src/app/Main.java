package app;

import modelo.Bodega;
import vista.Consola;
import controlador.controladorInventario;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando sistema de gestión de inventario...");
        System.out.println("Abriendo interfaz gráfica...\n");
        
    
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // creación de modelo, vista y controlador
                Bodega bodega = new Bodega();
                Consola vista = new Consola();
                controladorInventario controlador = new controladorInventario(bodega, vista);
                
                // mostrar la ventana
                vista.setVisible(true);
            }
        });
    }
}