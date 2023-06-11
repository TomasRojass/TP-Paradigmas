package main;

import java.util.ArrayList;

import archivo.Archivo;
import ofertador.Atraccion;
import ofertador.Ofertable;
import ofertador.OfertableIterator;
import ofertador.Ofertador;
import ofertador.Promocion;
import usuario.Usuario;

public class Main {

	public static void main(String[] args) {
		Archivo archivo = new Archivo("casos de prueba/");
		ArrayList<Usuario> usuarios = archivo.leerUsuarios("usuarios.in");
		ArrayList<Atraccion> atracciones = archivo.leerAtracciones("atracciones.in");
		ArrayList<Promocion> promociones = archivo.leerPromociones("promociones.in", atracciones);
		ArrayList<Ofertable> ofertables = new ArrayList<Ofertable>();
		ofertables.addAll(atracciones);
		ofertables.addAll(promociones);
		
		Ofertador ofertador = new Ofertador(ofertables);

		for (Usuario usuario : usuarios) {
			ofertador.ordenarPorUsuario(usuario);
			System.out.println(usuario);
			System.out.println("Elija sus atracciones/promociones: \n");
				
			for (OfertableIterator iterator = ofertador.getIterator(usuario, ofertables);iterator.hasNext();){
				Ofertable current = iterator.next();
				System.out.println("------------------------------------");
				boolean elegido = ofertador.ofertar(current);
				if(elegido) {
					current.tomarCupo();
					usuario.elegir(current);
				}
			}
			System.out.println("No hay mas opciones para ofertar");
			System.out.println("Itinerario generado en: " + usuario.getNombre() + ".out");
			System.out.println("\n#####################################\n");
			archivo.guardarVisitas(usuario.getNombre(), usuario);
		}
		
	}

}
