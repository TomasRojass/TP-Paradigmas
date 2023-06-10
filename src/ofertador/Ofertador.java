package ofertador;

import java.util.ArrayList;

import usuario.Usuario;

public class Ofertador {

	private ArrayList<Ofertable> ofertables;

	public Ofertador(ArrayList<Ofertable> ofertables) {
		this.ofertables = ofertables;
	}

	public ArrayList<Ofertable> ofertar(Usuario usuario){
//		ArrayList<Ofertable> visits = new ArrayList<Ofertable>();
		
		return ofertables;
	}
	
	public void ordenar(Usuario usuario){
		ofertables.sort(new OfertableComparator(usuario.getPreferencia()));
	}
	
	public OfertableIterator getIterator(Usuario usuario, ArrayList<Ofertable> ofertables) {
		return new OfertableIterator(usuario, ofertables);
	}

}
