package BE_TS1A_BARRERA_GABRIELA;

import java.util.ArrayList;

public class Partido {

	public static final int ARQUEROS_DEFAULT = 3;
	public static final int CANT_JUGADORES = 23;
	private String fecha;
	private String rival;
	private int condicionMinima;
	private int cantDefensa;
	private int cantMediocampo;
	private int cantDelantera;
	private ArrayList<Jugador> equipoPreseleccionado;

	public Partido(String fecha, String rival, int condicionMinima, int cantDefensa, int cantMediocampo,
			int cantDelantero) {
		this.fecha = fecha;
		this.rival = rival;
		this.condicionMinima = condicionMinima;
		this.cantDefensa = cantDefensa;
		this.cantMediocampo = cantMediocampo;
		this.cantDelantera = cantDelantero;
		this.equipoPreseleccionado = new ArrayList<>();
	}

	public boolean mismaFecha(String fecha) {
		return this.fecha.equals(fecha);
	}

	public void setEquipoPreseleccionado(ArrayList<Jugador> equipoPreseleccionado) {
		this.equipoPreseleccionado = equipoPreseleccionado;
	}

	public int getCondicionMinima() {
		return condicionMinima;
	}

	public int getCantDefensa() {
		return cantDefensa;
	}

	public int getCantMediocampo() {
		return cantMediocampo;
	}

	public int getCantDelantera() {
		return cantDelantera;
	}

	private String obtenerEquipoPreseleccionado() {
		String equipo = "";
		for (Posicion posicion : Posicion.values()) {
			equipo += "\n" + posicion + ": " + this.obneterInfoJugador(posicion);
		}
		return equipo;

	}

	public int cantidadPreseleccionados() {
		return this.equipoPreseleccionado.size();
	}

	public Jugador obtenerPreseleccionado(int indice) {
		Jugador jugador = null;

		if (indice >= 0 && indice < this.equipoPreseleccionado.size()) {
			jugador = this.equipoPreseleccionado.get(indice);
		}

		return jugador;
	}

	public boolean hayPreseleccion() {
		return this.equipoPreseleccionado != null && !this.equipoPreseleccionado.isEmpty();
	}

	private String obneterInfoJugador(Posicion posicion) {
		String mensaje = "";

		int i = 0;
		while (i < equipoPreseleccionado.size()) {
			Jugador jugador = equipoPreseleccionado.get(i);

			if (jugador.esMismaPosicion(posicion)) {
				mensaje += "\n" + jugador.getNombre();
			}

			i++;
		}

		return mensaje;
	}

	@Override
	public String toString() {
		return "Partido [fecha=" + fecha + ", rival=" + rival + ", condicionMinima=" + condicionMinima
				+ ", cantDefensa=" + cantDefensa + ", cantMediocampo=" + cantMediocampo + ", cantDelantera="
				+ cantDelantera + "]";
	}

}