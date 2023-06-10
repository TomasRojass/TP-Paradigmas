package ofertador;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import usuario.Usuario;

public class OfertableIteratorTest {

	@Test
	public void presupuestoFueraDeRango() {
		Usuario usuario = new Usuario("user", 700, 5, "preferencia");
		ArrayList<Ofertable> ofertables = new ArrayList<Ofertable>();
		ofertables.add(new Atraccion("atraccion cara", "tipo", 800, 4, 1));
		ofertables.add(new Atraccion("atraccion", "tipo", 500, 4, 1));
		OfertableIterator iterator = new OfertableIterator(usuario, ofertables);

		Ofertable result = iterator.next();
		boolean next = iterator.hasNext();
		
		
		Assert.assertEquals("atraccion", result.getNombre());
		Assert.assertFalse(next);
	}
	
	@Test
	public void tiempoFueraDeRango() {
		Usuario usuario = new Usuario("user", 1000, 5, "preferencia");
		ArrayList<Ofertable> ofertables = new ArrayList<Ofertable>();
		ofertables.add(new Atraccion("atraccion muy larga", "tipo", 800, 40, 1));
		ofertables.add(new Atraccion("atraccion", "tipo", 500, 4, 1));
		OfertableIterator iterator = new OfertableIterator(usuario, ofertables);

		Ofertable result = iterator.next();
		boolean next = iterator.hasNext();
		
		
		Assert.assertEquals("atraccion", result.getNombre());
		Assert.assertFalse(next);
	}
	
	@Test
	public void ofertableLleno() {
		Usuario usuario = new Usuario("user", 1000, 5, "preferencia");
		ArrayList<Ofertable> ofertables = new ArrayList<Ofertable>();
		ofertables.add(new Atraccion("atraccion llena", "tipo", 800, 4, 0));
		ofertables.add(new Atraccion("atraccion", "tipo", 500, 4, 1));
		OfertableIterator iterator = new OfertableIterator(usuario, ofertables);

		Ofertable result = iterator.next();
		boolean next = iterator.hasNext();
		
		
		Assert.assertEquals("atraccion", result.getNombre());
		Assert.assertFalse(next);
	}
	
	@Test
	public void atraccionRepetida() {
		Usuario usuario = new Usuario("user", 1000, 5, "preferencia");
		Atraccion atraccion = new Atraccion("atraccion", "tipo", 1, 1, 0);
		usuario.elegir(atraccion);
		ArrayList<Ofertable> ofertables = new ArrayList<Ofertable>();
		ofertables.add(atraccion);
		OfertableIterator iterator = new OfertableIterator(usuario, ofertables);

		boolean next = iterator.hasNext();
		
		Assert.assertFalse(next);
	}
}