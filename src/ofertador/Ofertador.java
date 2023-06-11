package ofertador;

import java.util.ArrayList;
import java.util.Scanner;

import usuario.Usuario;

public class Ofertador {

	private ArrayList<Ofertable> ofertables;

	public Ofertador(ArrayList<Ofertable> ofertables) {
		this.ofertables = ofertables;
	}

	public boolean ofertar(Ofertable ofertable){
		System.out.println(ofertable);
		System.out.println("Desea aceptar esta oferta? Ingrese S o N");
		Scanner reader = new Scanner(System.in);
		Character c = reader.next().charAt(0);
		while(!c.equals('S') && !c.equals('N')) {
			c = reader.next().charAt(0);
		}
		return c.equals('S');
	}
	
	public void ordenarPorUsuario(Usuario usuario) {
		ofertables.sort(new OfertableComparator(usuario.getPreferencia()));		
	}
	
	public OfertableIterator getIterator(Usuario usuario, ArrayList<Ofertable> ofertables) {
		return new OfertableIterator(usuario, ofertables);
	}

}
