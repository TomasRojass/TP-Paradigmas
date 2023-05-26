package ofertador;

import java.util.Comparator;

import usuario.Usuario;

public class OfertableComparator implements Comparator<Ofertable> {

	private String preferencia;

	public OfertableComparator(String preferencia) {
		super();
		this.preferencia = preferencia;
	}

	@Override
	public int compare(Ofertable o1, Ofertable o2) {
		if(o1.getTipo() == preferencia && o2.getTipo() != preferencia)
			return -1;
		return 1;
	}

}
