package ofertador;

import java.util.ArrayList;

public abstract class Promocion extends Ofertable {

	protected ArrayList<Atraccion> atracciones;

	public Promocion(String nombre, String tipo, ArrayList<Atraccion> atracciones) {
		super(nombre, tipo);
		this.atracciones = atracciones;
	}

	@Override
	public boolean isLleno() {
		boolean anyLleno = false;
		for (Atraccion atraccion : atracciones) {
			anyLleno = anyLleno && atraccion.isLleno();
		}
		return anyLleno;
	}

	@Override
	public double getPrecio() {
		double total = 0;
		for (Atraccion atraccion : atracciones) {
			total += atraccion.getPrecio();
		}
		return total;
	}

	@Override
	public double getTiempo() {
		double tiempo = 0;
		for (Atraccion atraccion : atracciones) {
			tiempo += atraccion.getTiempo();
		}
		return tiempo;
	}

	@Override
	public boolean tomarCupo() {
		for (Atraccion atraccion : atracciones) {
			atraccion.tomarCupo();
		}
		// TODO: ver la logica para cuando uno esta lleno y no se puede tomar
		return true;
	}

}