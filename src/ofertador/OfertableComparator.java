package ofertador;

import java.util.Comparator;

public class OfertableComparator implements Comparator<Ofertable> {

	private String preferencia;

	public OfertableComparator(String preferencia) {
		super();
		this.preferencia = preferencia;
	}

	@Override
	public int compare(Ofertable o1, Ofertable o2) {
		if (o1.getTipo().equals(preferencia) && o2.getTipo().equals(preferencia))
			return compararTipo(o1, o2);
		else if (o1.getTipo().equals(preferencia))
			return -1;
		else
			return 1;
	}

	public int compararTipo(Ofertable o1, Ofertable o2) {
		if( o1.compareTo(o2) >= 1 )
			return 1;
		if( o1.compareTo(o2) <= -1 )
			return -1;
		return compararPrecio(o1, o2);	
	}
	
	public int compararPrecio(Ofertable o1, Ofertable o2) {
		if( o1.getPrecio() > o2.getPrecio() )
			return -1;
		else if ( o1.getPrecio() < o2.getPrecio() )
			return 1;
		else
			return compararTiempo(o1, o2);
	}
	
	public int compararTiempo(Ofertable o1, Ofertable o2) {
		if( o1.getTiempo() > o2.getTiempo() )
			return -1;
		else if ( o1.getTiempo() < o2.getTiempo() )
			return 1;
		else
			return 0;
	}
}