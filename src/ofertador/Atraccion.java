package ofertador;

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

}
