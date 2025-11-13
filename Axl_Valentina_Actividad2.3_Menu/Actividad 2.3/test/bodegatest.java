package test; 
import modelo.Bodega;
import controlador.ControladorInventario;
import org.junit.Before;    
import org.junit.Test;      
import static org.junit.Assert.*;  

public class bodegatest {  
    
    private Bodega bodega; 
    @Before 
    public void setUp() {
        bodega = new Bodega();  
    }
    
    @Test  
    public void pruebaAgregarStock() {  
        bodega.agregarProducto("Producto Test", 7);  
        boolean resultado = bodega.agregarStock("Producto Test", 5);  
        assertTrue("Debería agregar stock exitosamente", resultado);  
        assertEquals("La suma de stock debería ser 12", 12, bodega.buscarProducto("Producto Test").getStock());  
    }
    
    @Test
    public void pruebaRestarStockExito() {  
        bodega.agregarProducto("Producto Test", 10);  
        boolean resultado = bodega.restarStock("Producto Test", 3);  
        assertTrue("Debería restar stock exitosamente", resultado); 
        assertEquals("La resta de stock debería ser 7", 7, bodega.buscarProducto("Producto Test").getStock()); 
    }
    
    @Test
    public void pruebaRestarStockSinNegativos() {  
        bodega.agregarProducto("Producto Test", 10);  
        boolean resultado = bodega.restarStock("Producto Test", 11);  
        assertFalse("No debería permitir restar más stock del disponible", resultado);  
        assertEquals("El stock debería mantenerse en 10", 10, bodega.buscarProducto("Producto Test").getStock());  
    }
}
