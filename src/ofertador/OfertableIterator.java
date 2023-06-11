package ofertador;

import java.util.ArrayList;
import java.util.Iterator;

import usuario.Usuario;

public class OfertableIterator implements Iterator<Ofertable> {

	private int currentPosition;
	private Usuario usuario;
	private ArrayList<Ofertable> ofertables;

	public OfertableIterator(Usuario usuario, ArrayList<Ofertable> ofertables) {
		this.usuario = usuario;
		this.ofertables = ofertables;
		this.currentPosition = getValidPosition(0);
	}

	@Override
	public boolean hasNext() {
		currentPosition = getValidPosition(currentPosition);
		return currentPosition < ofertables.size();
	}

	@Override
	public Ofertable next() {
		if (!hasNext()) {
			return null;
		}
		Ofertable ofertable = ofertables.get(currentPosition);
		currentPosition = getValidPosition(currentPosition + 1);
		return ofertable;
	}

	private int getValidPosition(int position) {
		boolean isValidPosition = false;
		while (!isValidPosition && position < ofertables.size()) {
			Ofertable ofertable = ofertables.get(position);
			if (ofertable.getPrecio() > usuario.getPresupuesto()
				|| ofertable.getTiempo() > usuario.getTiempoDisponible()
				|| ofertable.isLleno()
				|| atraccionRepetida(ofertable)) {
				position++;
			} else {
				isValidPosition = true;
			}
		}
		return position;
	}
	
	private boolean atraccionRepetida(Ofertable ofertable) {
		for (Ofertable ofertableUsuario : usuario.getOfertablesElegidos()) {
			if(ofertableUsuario.atraccionRepetida(ofertable)) {
				return true;
			}
		}
		return false;
	}

}
