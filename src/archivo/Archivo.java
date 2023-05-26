package archivo;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import usuario.Usuario;

public class Archivo {
	private String path;

	public Archivo(String path) {
		this.path = path;
	}

	public ArrayList<Usuario> leerUsuarios(String nombre) {
		Scanner scanner = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			File file = new File(path + nombre);
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			while (scanner.hasNextLine()) {
				String[] atributos = scanner.nextLine().split(";");
				Usuario usuario = new Usuario(atributos[0], Double.parseDouble(atributos[1]),
						Double.parseDouble(atributos[2]), atributos[3]);
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return usuarios;
	}
}