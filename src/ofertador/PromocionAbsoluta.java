package ofertador;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {

	private double monto;
	
	public PromocionAbsoluta(String nombre, String tipo, ArrayList<Atraccion> atracciones, double monto) {
		super(nombre, tipo, atracciones);
		this.monto = monto;
	}

	@Override
	public double getPrecio() {
		return monto;
	}

}
