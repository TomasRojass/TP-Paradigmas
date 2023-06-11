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

	public double getPrecioOriginal() {
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

	@Override
	public ArrayList<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	@Override
	public String toString() {
		String nombres = "";
		for (Atraccion atraccion : atracciones) {
			nombres += atraccion.getNombre() + ", ";
		}
		return "Promocion \n"
				+"Nombre: " + nombre + "\n"
				+"Tipo: " + tipo + "\n"
				+"Atraciones incluidas: " + nombres + "\n"
				+"Tiempo:" + getTiempo() + "\n"
				+"Precio original:" + getPrecioOriginal() + "\n"
				+"Precio con descuento:" + getPrecio() + "\n";
	}

	@Override
	public TipoOfertable getTipoOfertable() {
		return TipoOfertable.PROMOCION;
	}
}
