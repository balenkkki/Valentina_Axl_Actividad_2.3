package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;



// botones en consola
public class Consola extends JFrame {    
    private JButton btnAgregarProducto;  
    private JButton btnAgregarStock;  
    private JButton btnRestarStock;  
    private JButton btnReporteInventario; 
    private JButton btnSalir;

    // inicializa la ventana 
    public Consola() {
        inicializarComponentes(); 
        configurarVentana();      
    }

    
    private void inicializarComponentes() {
        btnAgregarProducto = new JButton(" Agregar Producto");
        btnAgregarStock = new JButton(" Agregar Stock");
        btnRestarStock = new JButton(" Restar Stock");
        btnReporteInventario = new JButton(" Reporte Inventario");
        btnSalir = new JButton(" Salir");

        Font fontBotones = new Font("Elizeth", Font.BOLD, 15);
        btnAgregarProducto.setFont(fontBotones);
        btnAgregarStock.setFont(fontBotones);
        btnRestarStock.setFont(fontBotones);
        btnReporteInventario.setFont(fontBotones);
        btnSalir.setFont(fontBotones);

        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    
        panelBotones.add(btnAgregarProducto);
        panelBotones.add(btnAgregarStock);
        panelBotones.add(btnRestarStock);
        panelBotones.add(btnReporteInventario);
        panelBotones.add(btnSalir);

        // setea el layout para organizar el panel
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.CENTER); 

        // crea y configura el titulo de la ventana
        JLabel titulo = new JLabel("SISTEMA DE GESTIÓN DE INVENTARIO", JLabel.CENTER);
        titulo.setFont(new Font("Elizeth", Font.BOLD, 15));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titulo, BorderLayout.NORTH); 
    }
    // define titulo, tamaño, cierre, posición y si es redimensionable
    private void configurarVentana() {
        setTitle("Sistema de Gestión de Inventario"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(800, 500); 
        setLocationRelativeTo(null); 
        setResizable(false); 
    }
    
    // métodos para asociar a los botones
    public void setAgregarProductoListener(ActionListener listener) {
        btnAgregarProducto.addActionListener(listener);
    }

    public void setAgregarStockListener(ActionListener listener) {
        btnAgregarStock.addActionListener(listener);
    }
    
    public void setRestarStockListener(ActionListener listener) {
        btnRestarStock.addActionListener(listener);
    }

    public void setReporteInventarioListener(ActionListener listener) {
        btnReporteInventario.addActionListener(listener);
    }

    public void setSalirListener(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }
    // métodos para mostrar diálogos en consola al usuario
    public String mostrarInputDialog(String mensaje) {
        return JOptionPane.showInputDialog(this, mensaje);
    }
    
    public int mostrarInputDialogEntero(String mensaje) {
        try {
            String input = JOptionPane.showInputDialog(this, mensaje);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarMensajeDialog(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

}
