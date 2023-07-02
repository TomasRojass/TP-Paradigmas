package interfazUsuario;

import java.util.ArrayList;
import java.util.Scanner;

import archivo.Archivo;
import ofertador.Atraccion;
import ofertador.Ofertable;
import ofertador.OfertableIterator;
import ofertador.Ofertador;
import ofertador.Promocion;
import usuario.Usuario;

public class InterfazUsuario {

	private Archivo archivo;
	
	public InterfazUsuario(String pathArchivo) {
		this.archivo = new Archivo(pathArchivo);
	}

	public void comenzarOfertas(String usuariosFile, String atraccionesFile, String promocionesFile) {
		ArrayList<Usuario> usuarios = archivo.leerUsuarios(usuariosFile);
		ArrayList<Atraccion> atracciones = archivo.leerAtracciones(atraccionesFile);
		ArrayList<Promocion> promociones = archivo.leerPromociones(promocionesFile);
		ArrayList<Ofertable> ofertables = new ArrayList<Ofertable>();
		ofertables.addAll(atracciones);
		ofertables.addAll(promociones);

		Ofertador ofertador = new Ofertador(ofertables);
		Scanner reader = new Scanner(System.in);

		for (Usuario usuario : usuarios) {
			ofertador.ordenarPorUsuario(usuario);
			System.out.println(usuario);
			System.out.println("Elija sus atracciones/promociones: \n");

			for (OfertableIterator iterator = ofertador.getIterator(usuario, ofertables); iterator.hasNext();) {
				Ofertable current = iterator.next();
				System.out.println("------------------------------------");
				boolean elegido = ofertar(current, reader);
				if (elegido) {
					current.tomarCupo();
					usuario.elegir(current);
				}
			}
			System.out.println("No hay mas opciones para ofertar");
			System.out.println("Itinerario generado en: " + usuario.getNombre() + ".out");
			System.out.println("\n#####################################\n");
			archivo.guardarVisitas(usuario.getNombre(), usuario);
		}
		reader.close();
	}
	
	private boolean ofertar(Ofertable ofertable, Scanner reader) {
		System.out.println(ofertable);
		System.out.println("Desea aceptar esta oferta? Ingrese S o N");
		Character c = reader.next().charAt(0);
		while(!c.equals('S') && !c.equals('N')) {
			c = reader.next().charAt(0);
		}
		return c.equals('S');
	}
}
