package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Consola extends JFrame {
    private JButton btnAgregar_Producto;
    private JButton btnAgregar_Stock;
    private JButton btnRestar_Stock;
    private JButton btnReporte_Inventario;
    private JButton btnSalir;
    
    public Consola() {
        inicializarComponentes();
        configurarVentana();
    }
    
    private void inicializarComponentes() {
        // creación de botones
        btnAgregar_Producto = new JButton("1. Añadir producto");
        btnAgregar_Stock = new JButton("2. Añadir stock");
        btnRestar_Stock = new JButton("3. Restar stock");
        btnReporte_Inventario = new JButton("4. Reporte inventario");
        btnSalir = new JButton("5. Salir");
        

        
        // panel para botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        
        panelBotones.add(btnAgregar_Producto);
        panelBotones.add(btnAgregar_Stock);
        panelBotones.add(btnRestar_Stock);
        panelBotones.add(btnReporte_Inventario);
        panelBotones.add(btnSalir);
        
        // configuración del layout y título
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.CENTER);
        
        JLabel titulo = new JLabel("SISTEMA DE GESTIÓN DE INVENTARIO", JLabel.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titulo, BorderLayout.NORTH);
    }
    
    private void configurarVentana() {
        setTitle("Sistema de gestión de inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    // métodos para agregar listeners y mostrar diálogos de entrada

    public void setAgregarProductoListener(ActionListener listener) {
        btnAgregar_Producto.addActionListener(listener);
    }
    
    public void setAgregarStockListener(ActionListener listener) {
        btnAgregar_Stock.addActionListener(listener);
    }
    
    public void setRestarStockListener(ActionListener listener) {
        btnRestar_Stock.addActionListener(listener);
    }
    
    public void setReporteInventarioListener(ActionListener listener) {
        btnReporte_Inventario.addActionListener(listener);
    }
    
    public void setSalirListener(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }

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