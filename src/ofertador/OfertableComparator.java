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
		if(o1.getTipo().equals(preferencia) && !o2.getTipo().equals(preferencia)) {
			return -1;
		}
		if(!o1.getTipo().equals(preferencia) && o2.getTipo().equals(preferencia)) {
			return 1;
		}
		if(o1 instanceof Promocion && o2 instanceof Atraccion) {
			return -1;
		}
		if(o1 instanceof Atraccion && o2 instanceof Promocion) {
			return 1;
		}
		if(o1.getPrecio() > o2.getPrecio()) {
			return -1;
		}
		if(o1.getPrecio() < o2.getPrecio()) {
			return 1;
		}
		return (int) (o2.getTiempo() - o1.getTiempo());
	}

}
