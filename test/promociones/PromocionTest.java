package promociones;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import ofertador.Atraccion;
import ofertador.PromocionAbsoluta;
import ofertador.PromocionAxB;
import ofertador.PromocionPorcentual;

public class PromocionTest {
    
    @Test
    public void promocionPackAventura_CalculoCorrectoDelPrecio() {
        Atraccion bosqueNegro = new Atraccion("Bosque Negro", "Aventura", 10, 2, 20);
        Atraccion mordor = new Atraccion("Mordor", "Aventura", 15, 3, 15);
        ArrayList<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(bosqueNegro);
        atracciones.add(mordor);
        
        PromocionPorcentual packAventura = new PromocionPorcentual("Pack Aventura", "Aventura", atracciones, 20);
        
        double precioEsperado = (bosqueNegro.getPrecio() + mordor.getPrecio()) * 0.8;
        double precioObtenido = packAventura.getPrecio();
        
        Assert.assertEquals(precioEsperado, precioObtenido, 0.0001);
    }
    
    @Test
    public void promocionPackDegustacion_CalculoCorrectoDelPrecio() {
        Atraccion lothlorien = new Atraccion("Lothlórien", "Degustación", 10, 2, 20);
        Atraccion laComarca = new Atraccion("La Comarca", "Degustación", 15, 3, 15);
        ArrayList<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(lothlorien);
        atracciones.add(laComarca);
        
        PromocionAbsoluta packDegustacion = new PromocionAbsoluta("Pack Degustación", "Degustación", atracciones, 36);
        
        double precioEsperado = 36;
        double precioObtenido = packDegustacion.getPrecio();
        
        Assert.assertEquals(precioEsperado, precioObtenido, 0.0001);
    }
    
    @Test
    public void promocionPackPaisajes_CalculoCorrectoDelPrecio() {
        Atraccion minasTirith = new Atraccion("Minas Tirith", "Paisaje", 10, 2, 20);
        Atraccion abismoHelm = new Atraccion("Abismo de Helm", "Paisaje", 15, 3, 15);
        Atraccion erebor = new Atraccion("Erebor", "Paisaje", 12, 2, 10);
        ArrayList<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(minasTirith);
        atracciones.add(abismoHelm);
        //atracciones.add(erebor);
        
        ArrayList<Atraccion> atraccionesGratis = new ArrayList<>();
        atraccionesGratis.add(erebor);
        
        PromocionAxB packPaisajes = new PromocionAxB("Pack Paisajes", "Paisaje", atracciones, atraccionesGratis);
        
        double precioEsperado = minasTirith.getPrecio() + abismoHelm.getPrecio();
        double precioObtenido = packPaisajes.getPrecio();
        
        Assert.assertEquals(precioEsperado, precioObtenido, 0.0001);
        
    }
    

    
} 
