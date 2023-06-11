package ofertador;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private int descuento;
	public PromocionPorcentual(String nombre, String tipo, ArrayList<Atraccion> atracciones, int descuento) {
		super(nombre, tipo, atracciones);
		this.descuento = descuento;
	}

	@Override
	public double getPrecio() {
		return getPrecioOriginal()*(100-descuento)/100;
	}

}
