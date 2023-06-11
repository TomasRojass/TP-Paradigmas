package usuario;

import java.util.ArrayList;

import ofertador.Ofertable;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private String preferencia;
	private ArrayList<Ofertable> ofertablesElegidos;

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, String preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
		this.ofertablesElegidos = new ArrayList<Ofertable>();
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public String getPreferencia() {
		return preferencia;
	}
	
	public double consumirPresupuesto(double monto) {
		//TODO: validar que el presupuesto no baje de cero. Ver que hacer cuando el monto es mayor
		presupuesto -= monto;
		return presupuesto;
	}
	
	public double consumirTiempo(double tiempo) {
		//TODO: validar que el tiempo disponible no baje de cero. Ver que hacer cuando el tiempo es mayor
		tiempoDisponible -= tiempo;
		return tiempoDisponible;
	}

	public ArrayList<Ofertable> getOfertablesElegidos() {
		return ofertablesElegidos;
	}
	
	public void elegir(Ofertable ofertable) {
		consumirPresupuesto(ofertable.getPrecio());
		consumirTiempo(ofertable.getTiempo());
		ofertablesElegidos.add(ofertable);
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\n"
				+ "Presupuesto: " + presupuesto + "\n"
				+ "TiempoDisponible: " + tiempoDisponible + "\n"
				+ "Preferencia: " + preferencia;
	}
	
	
}
