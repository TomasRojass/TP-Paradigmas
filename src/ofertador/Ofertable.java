package ofertador;

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
}
