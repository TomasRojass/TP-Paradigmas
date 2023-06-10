package ofertador;

import java.util.ArrayList;

public abstract class Ofertable {
	protected String nombre;
	protected String tipo;

	public Ofertable(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public abstract boolean isLleno();

	public abstract double getPrecio();

	public abstract double getTiempo();

	public abstract boolean tomarCupo();
	
	public abstract ArrayList<Atraccion> getAtracciones();
	
	public boolean atraccionRepetida(Ofertable ofertable) {
		for (Atraccion atraccion1 : this.getAtracciones()) {
			for(Atraccion atraccion2 : ofertable.getAtracciones()) {
				if(atraccion1.equals(atraccion2)) {
					return true;
				}
			}
		}
		return false;
	}
}
