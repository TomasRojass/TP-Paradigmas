package ofertador;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {

	public ArrayList<Atraccion> atraccionesGratis;
	
	public PromocionAxB(String nombre, String tipo, ArrayList<Atraccion> atracciones, ArrayList<Atraccion> atraccionesGratis) {
		super(nombre, tipo, atracciones);
		this.atracciones.addAll(atraccionesGratis);
		this.atraccionesGratis = atraccionesGratis;
	}

	@Override
	public double getPrecio() {
		double descuento = 0;
		for (Atraccion atraccion : atraccionesGratis) {
			descuento += atraccion.getPrecio();
		}
		return getPrecioOriginal() - descuento;
	}

}
