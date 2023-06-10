package ofertador;

public abstract class Ofertable implements Comparable<Ofertable>{
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
	
	@Override
	public int compareTo(Ofertable other) {
		int thisType = obtenerTipoOfertable();
        int otherType = other.obtenerTipoOfertable();
        if( thisType == otherType )
        	return 0;
        else if( thisType > otherType )
        	return 1;
        return -1;
	}

	public abstract boolean isLleno();

	public abstract double getPrecio();

	public abstract double getTiempo();

	public abstract boolean tomarCupo();
	
	public abstract int obtenerTipoOfertable();
}
