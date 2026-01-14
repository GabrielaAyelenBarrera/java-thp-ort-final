package BE_TS1A_BARRERA_GABRIELA;

public class Jugador {

	private String nombre;
	private int puntaje;
	private boolean lesionado;
	private Posicion posicion;

	public Jugador(String nombre, int puntaje, boolean lesionado, Posicion posicion) {
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.lesionado = lesionado;
		this.posicion = posicion;
	}

	public boolean esElegible(Posicion posicion, int condicionMinima) {
		return this.posicion.equals(posicion) && !this.lesionado && this.puntaje >= condicionMinima;
	}

	public boolean esMismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}

	public boolean esMismaPosicion(Posicion posicion) {
		return this.posicion.equals(posicion);
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getPuntaje() {
		return this.puntaje;
	}
}