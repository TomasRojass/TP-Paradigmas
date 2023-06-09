package archivo;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import ofertador.Atraccion;
import ofertador.Ofertable;
import ofertador.Promocion;
import ofertador.PromocionAbsoluta;
import ofertador.PromocionAxB;
import ofertador.PromocionPorcentual;
import usuario.Usuario;

public class Archivo {
	private String path;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	private ArrayList<Promocion> promocion = new ArrayList<Promocion>();

	public Archivo(String path) {
		this.path = path;
	}

	public ArrayList<Usuario> leerUsuarios(String nombre) {
		Scanner scanner = null;

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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return usuarios;
	}

	public ArrayList<Atraccion> leerAtracciones(String nombre) {
		Scanner scanner = null;
		try {
			File file = new File(path + nombre);
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			while (scanner.hasNextLine()) {
				String[] atributos = scanner.nextLine().split(";");
				Atraccion atraccion = new Atraccion(atributos[0], atributos[1], Double.parseDouble(atributos[2]),
						Double.parseDouble(atributos[3]), Integer.parseInt(atributos[4]));
				atracciones.add(atraccion);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return atracciones;
	}
	
	public ArrayList<Promocion> leerPromociones(String nombre) {
		Scanner scanner = null;
		try {
			File file = new File(path + nombre);
			if(atracciones.size() == 0) {
				throw new RuntimeException("Sin atracciones");
			}
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			while (scanner.hasNextLine()) {
				String[] atributos = scanner.nextLine().split(";");
				int cantidadDeAtracciones = Integer.parseInt(atributos[3]);
				int primeraAtraccion = 4;
				ArrayList<Atraccion> atraccionesEnPromocion = new ArrayList<Atraccion>();
				
				for (int i = primeraAtraccion; i < primeraAtraccion+cantidadDeAtracciones; i++) {
					for (Atraccion atraccion : atracciones) {
						if (atraccion.getNombre().equals(atributos[i])) {
			                atraccionesEnPromocion.add(atraccion);
			            }
					}
				}
				switch (atributos[0]) {
				case "a": {
					PromocionAbsoluta promo = new PromocionAbsoluta(atributos[1],atributos[2],atraccionesEnPromocion,Double.parseDouble(atributos[primeraAtraccion+cantidadDeAtracciones]));
					promocion.add(promo);
					break;
				}
				case "p":{
					PromocionPorcentual promo = new PromocionPorcentual(atributos[1], atributos[2], atraccionesEnPromocion,Integer.parseInt(atributos[primeraAtraccion+cantidadDeAtracciones]));
					promocion.add(promo);
					break;
				}
				case "x":{
					ArrayList<Atraccion> atraccionesGratis = new ArrayList<Atraccion>();
					int cantAtraccionesGratis = Integer.parseInt(atributos[2+cantidadDeAtracciones]);
					int primeraAtraccionGratis = primeraAtraccion+cantidadDeAtracciones+1;
					for (int i = primeraAtraccionGratis; i < primeraAtraccionGratis+cantAtraccionesGratis; i++) {
						for (Atraccion atraccion : atracciones) {
							if (atraccion.getNombre().equals(atributos[i])) {
								atraccionesGratis.add(atraccion);
				            }
						}
					}
					PromocionAxB promo = new PromocionAxB(atributos[1], atributos[2], atraccionesEnPromocion, atraccionesGratis);
					promocion.add(promo);
					break;
				}
				default:
					throw new IllegalArgumentException("Valor incorrecto");
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return promocion;
	}

	public void guardarVisitas(String nombre, Usuario usuario) {
		FileWriter file = null;
		PrintWriter printerWriter = null;
		int nro = 0;
		double totalTiempo = 0;
		double totalPagar = 0;
		try {
			file = new FileWriter(path+"/" + nombre + ".out");
			printerWriter = new PrintWriter(file);
			printerWriter.println("---Resumen compra del usuario: " + usuario.getNombre() + "---");
			printerWriter.println(usuario);
			printerWriter.println("\n-----------------\n");
			printerWriter.println("Atracciones Elegidas:\n");
			for (Ofertable ofertable : usuario.getOfertablesElegidos()) {
				nro++;
				printerWriter.println((nro) + "-" + ofertable);
				totalTiempo += ofertable.getTiempo();
				totalPagar += ofertable.getPrecio();
			}
			printerWriter.println("-----------------\n");
			printerWriter.println("Total a pagar:" + totalPagar);
			printerWriter.println("Total de tiempo:" + totalTiempo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}