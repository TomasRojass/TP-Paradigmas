package Atracciones;

import org.junit.Assert;
import org.junit.Test;

import ofertador.Atraccion;

public class AtraccionTest {

    @Test
    public void cupoNoDisponible() {
        Atraccion atraccion = new Atraccion("Atraccion 1", "Tipo 1", 10.0, 2.0, 0);
        
        boolean estaLlena = atraccion.isLleno();
        
        Assert.assertTrue(estaLlena);
    }
    
    @Test
    public void cupoDisponible() {
        Atraccion atraccion = new Atraccion("Atraccion 1", "Tipo 1", 10.0, 2.0, 5);
        boolean tomoCupo = atraccion.tomarCupo();
        Assert.assertTrue(tomoCupo);
    }
    

    @Test
    public void atraccionesIguales() {
        Atraccion atraccion1 = new Atraccion("Atraccion 1", "Tipo 1", 10.0, 2.0, 5);
        Atraccion atraccion2 = new Atraccion("Atraccion 1", "Tipo 2", 15.0, 3.0, 3);
        
        boolean sonIguales = atraccion1.equals(atraccion2);
        
        Assert.assertTrue(sonIguales);
    }
}