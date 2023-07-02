package main;

import interfazUsuario.InterfazUsuario;

public class Main {

	public static void main(String[] args) {
		InterfazUsuario interfaz = new InterfazUsuario("casos de prueba/");
		interfaz.comenzarOfertas("usuarios.in", "atracciones.in", "promociones.in");
	}

}
