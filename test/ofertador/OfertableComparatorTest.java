package ofertador;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import usuario.Usuario;

public class OfertableComparatorTest {

	@Test
    public void testOrdenarPorUsuario() {      
        // Crear atracciones
        Atraccion atraccion1 = new Atraccion("Atraccion1", "Aventura", 50, 5, 3);
        Atraccion atraccion2 = new Atraccion("Atraccion2", "Degustación", 80, 3, 2);
        Atraccion atraccion3 = new Atraccion("Atraccion3", "Aventura", 70, 4, 1);
        Atraccion atraccion4 = new Atraccion("Atraccion4", "Degustación", 60, 2, 4);

        // Crear promociones
        ArrayList<Atraccion> atraccionesPromo1 = new ArrayList<>();
        atraccionesPromo1.add(atraccion1);
        atraccionesPromo1.add(atraccion3);
        Promocion promocion1 = new PromocionAxB("Promocion1", "Aventura", atraccionesPromo1, atraccionesPromo1);

        ArrayList<Atraccion> atraccionesPromo2 = new ArrayList<>();
        atraccionesPromo2.add(atraccion2);
        atraccionesPromo2.add(atraccion4);
        Promocion promocion2 = new PromocionPorcentual("Promocion2", "Degustación", atraccionesPromo2, 20);

        // Crear lista de ofertables
        ArrayList<Ofertable> ofertables = new ArrayList<>();
        ofertables.add(atraccion1);
        ofertables.add(atraccion2);
        ofertables.add(atraccion3);
        ofertables.add(atraccion4);
        ofertables.add(promocion1);
        ofertables.add(promocion2);
        
        ArrayList<Ofertable> ofertablesEsperados = new ArrayList<>();
        ofertablesEsperados.add(promocion1);
        ofertablesEsperados.add(atraccion3);
        ofertablesEsperados.add(atraccion1);
        ofertablesEsperados.add(promocion2);
        ofertablesEsperados.add(atraccion2);
        ofertablesEsperados.add(atraccion4);

        OfertableComparator comparator = new OfertableComparator("Aventura");
        
        ofertables.sort(comparator);
        
        assertEquals("Promocion1", ofertables.get(0).getNombre());
        assertEquals("Atraccion3", ofertables.get(1).getNombre());
        assertEquals("Atraccion1", ofertables.get(2).getNombre());
        assertEquals("Promocion2", ofertables.get(3).getNombre());
        assertEquals("Atraccion2", ofertables.get(4).getNombre());
        assertEquals("Atraccion4", ofertables.get(5).getNombre());
        
    }

}
