package ofertador;

import java.util.ArrayList;

public class Atraccion extends Ofertable {

	private double precio;
	private double tiempo;
	private int cupoDisponible;
	
	public Atraccion(String nombre, String tipo, double precio, double tiempo, int cupoDisponible) {
		super(nombre, tipo);
		this.precio = precio;
		this.tiempo = tiempo;
		this.cupoDisponible = cupoDisponible;
	}

	@Override
	public boolean isLleno() {
		return cupoDisponible == 0;
	}

	@Override
	public double getPrecio() {
		return precio;
	}

	@Override
	public double getTiempo() {
		return tiempo;
	}

	@Override
	public boolean tomarCupo() {
		if(isLleno()) {
			return false;
		}
		cupoDisponible--;
		return true;
	}

	public boolean equals(Atraccion atraccion) {
		return this.nombre == atraccion.nombre;
	}

	@Override
	public ArrayList<Atraccion> getAtracciones() {
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(this);
		return atracciones;
	}

	@Override
	public String toString() {
		return "Atraccion \n"
				+ "Nombre: " + nombre + "\n"
				+ "Tipo: " + tipo + "\n"
				+ "Precio: " + precio + "\n"
				+ "Tiempo: " + tiempo + "\n";
	}

	@Override
	public TipoOfertable getTipoOfertable() {
		return TipoOfertable.ATRACCION;
	}
}
