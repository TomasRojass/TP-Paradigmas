package usuario;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private String preferencia;

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, String preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
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
	
}
