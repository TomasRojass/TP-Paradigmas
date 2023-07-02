package ofertador;

import java.util.ArrayList;

import usuario.Usuario;

public class Ofertador {

	private ArrayList<Ofertable> ofertables;

	public Ofertador(ArrayList<Ofertable> ofertables) {
		this.ofertables = ofertables;
	}
	
	public void ordenarPorUsuario(Usuario usuario) {
		ofertables.sort(new OfertableComparator(usuario.getPreferencia()));		
	}
	
	public OfertableIterator getIterator(Usuario usuario, ArrayList<Ofertable> ofertables) {
		return new OfertableIterator(usuario, ofertables);
	}

}
