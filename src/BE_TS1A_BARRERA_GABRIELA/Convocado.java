package BE_TS1A_BARRERA_GABRIELA;

public class Convocado {

	private Jugador jugador;
	private int cantidadConvocatorias;

	public Convocado(Jugador jugador, int cantidadConvocatorias) {
		this.jugador = jugador;
		this.cantidadConvocatorias = cantidadConvocatorias;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public int getCantidadConvocatorias() {
		return cantidadConvocatorias;
	}

	public void sumarConvocatoria() {
		cantidadConvocatorias++;
	}

	public boolean esDe(Jugador otro) {
		return this.jugador == otro;
	}
}