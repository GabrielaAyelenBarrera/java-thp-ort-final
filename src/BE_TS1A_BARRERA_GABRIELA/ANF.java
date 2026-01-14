package BE_TS1A_BARRERA_GABRIELA;

import java.util.ArrayList;

public class ANF {

	private ArrayList<Partido> partidos;
	private ArrayList<Jugador> plantilla;
	private Posicion posicion;
	private Convocado convocado;

	public ANF() {
		this.partidos = new ArrayList<>();
		this.plantilla = new ArrayList<>();
	}

	public void agregarJugador(String nombre, int puntaje, boolean lesionado, Posicion posicion) {
		if (this.buscarJugador(nombre) == null) {
			this.plantilla.add(new Jugador(nombre, puntaje, lesionado, posicion));
		} else {
			System.out.println("El jugador " + nombre + " ya se encuentra registrado.");
		}
	}

	private Convocado buscarConvocado(ArrayList<Convocado> registro, Jugador jugador) {
		int i = 0;
		Convocado encontrado = null;

		while (i < registro.size() && !registro.get(i).esDe(jugador)) {
			i++;
		}

		if (i < registro.size()) {
			encontrado = registro.get(i);
		}

		return encontrado;
	}

	private void sumarEnRegistro(ArrayList<Convocado> registro, Jugador jugador) {
		Convocado c;

		c = buscarConvocado(registro, jugador);

		if (c == null) {
			registro.add(new Convocado(jugador, 1));
		} else {
			c.sumarConvocatoria();
		}
	}

	public ArrayList<Convocado> generarRegistroConvocados() {
		ArrayList<Convocado> registro = new ArrayList<>();
		Partido p;
		Jugador j;
		int indicePartido = 0;
		int iJugador;

		while (indicePartido < partidos.size()) {
			p = partidos.get(indicePartido);

			if (p != null && p.hayPreseleccion()) {
				iJugador = 0;
				while (iJugador < p.cantidadPreseleccionados()) {
					j = p.obtenerPreseleccionado(iJugador);

					if (j != null) {
						sumarEnRegistro(registro, j);
					}

					iJugador++;
				}
			}

			indicePartido++;
		}

		return registro;
	}

	public void mostrarRegistroConvocados() {
		ArrayList<Convocado> registro = generarRegistroConvocados();
		int i;
		Convocado c;
		System.out.println("REGISTRO DE CONVOCATORIAS");

		if (registro.isEmpty()) {
			System.out.println("No hubo jugadores convocados.");
		} else {
			i = 0;
			while (i < registro.size()) {
				c = registro.get(i);
				System.out.println(c.getJugador().getNombre() + " - " + c.getCantidadConvocatorias());
				i++;
			}
		}
	}

	private int obtenerMaximaConvocatoria(ArrayList<Convocado> registro) {
		int max = 0;
		int i = 0;
		int cant;

		while (i < registro.size()) {
			cant = registro.get(i).getCantidadConvocatorias();

			if (cant > max) {
				max = cant;
			}
			i++;
		}

		return max;
	}

	private ArrayList<Convocado> filtrarMasConvocados(ArrayList<Convocado> registro, int max) {
		ArrayList<Convocado> resultado = new ArrayList<>();
		int i = 0;
		Convocado c;

		while (i < registro.size()) {
			c = registro.get(i);

			if (c.getCantidadConvocatorias() == max) {
				resultado.add(c);
			}

			i++;
		}

		return resultado;
	}

	public void mostrarReporteJugadoresMasConvocados() {
		ArrayList<Convocado> registro = generarRegistroConvocados();
		int max;
		ArrayList<Convocado> masConvocados = new ArrayList<>();
		int i;
		Convocado c;
		Jugador j;
		System.out.println("=========================== JUGADORES MAS CONVOCADOS ===========================");

		if (registro.isEmpty()) {
			System.out.println("Cantidad máxima de convocatorias: 0");
			System.out.println("Jugadores:");
			System.out.println("- No hay convocatorias registradas.");
		} else {
			max = obtenerMaximaConvocatoria(registro);
			masConvocados = filtrarMasConvocados(registro, max);

			System.out.println("Cantidad máxima de convocatorias: " + max);
			System.out.println("Jugadores:");

			i = 0;
			while (i < masConvocados.size()) {
				c = masConvocados.get(i);
				j = c.getJugador();

				System.out.println("- " + j.getNombre() + " | Condición física: " + j.getPuntaje());

				i++;
			}
		}
	}

	public void cargarJugadores(Posicion posicion, int cantidad, int puntaje, boolean lesionado) {
		int i = 1;

		while (i <= cantidad) {
			this.agregarJugador(posicion + " " + i, puntaje, lesionado, posicion);
			i++;
		}
	}

	private Jugador buscarJugador(String nombre) {
		int i = 0;
		Jugador encontrado = null;

		while (i < this.plantilla.size() && !this.plantilla.get(i).esMismoNombre(nombre)) {
			i++;
		}

		if (i < this.plantilla.size()) {
			encontrado = this.plantilla.get(i);
		}

		return encontrado;
	}

	public void gestionarPartido(String fecha, String rival, int cantDefensa, int cantMediocampo, int cantDelantera,
			int condicionMinima) {
		final int DEFENSORES_DEFAULT = 8;
		final int MEDIOS_DEFAULT = 8;
		final int DELANTEROS_DEFAULT = 4;
		Partido partido;
		boolean cuposValidos;

		cuposValidos = this.esCuposValidos(cantDefensa, cantMediocampo, cantDelantera);

		if (!cuposValidos) {
			cantDefensa = DEFENSORES_DEFAULT;
			cantMediocampo = MEDIOS_DEFAULT;
			cantDelantera = DELANTEROS_DEFAULT;
		}
		condicionMinima = validarCondicion(condicionMinima);
		partido = this.buscarPartido(fecha);

		if (partido != null) {
			this.partidos.remove(partido);
		}
		partido = new Partido(fecha, rival, condicionMinima, cantDefensa, cantMediocampo, cantDelantera);
		this.partidos.add(partido);
		partido.setEquipoPreseleccionado(this.armarPreseleccion(partido));
	}

	private boolean esCuposValidos(int def, int med, int del) {
		final int CANT_JUGADORES_CAMPO = 20;
		boolean sumaOK;
		boolean rangosOK;

		sumaOK = (def + med + del == CANT_JUGADORES_CAMPO);
		rangosOK = esRangoValido(def, CANT_JUGADORES_CAMPO) && esRangoValido(med, CANT_JUGADORES_CAMPO)
				&& esRangoValido(del, CANT_JUGADORES_CAMPO);
		return sumaOK && rangosOK;
	}

	private boolean esRangoValido(int cantidad, int tope) {
		return (cantidad >= 0 && cantidad <= tope);
	}

	private int validarCondicion(int condicionMinima) {
		final int COND_FISICA_MAX = 100;

		if (!this.esRangoValido(condicionMinima, COND_FISICA_MAX)) {
			condicionMinima = 0;
		}
		return condicionMinima;
	}

	private ArrayList<Jugador> armarPreseleccion(Partido p) {
		ArrayList<Jugador> listaPreseleccion = new ArrayList<>();

		listaPreseleccion = this.filtrar(Posicion.ARQUERO, Partido.ARQUEROS_DEFAULT, p.getCondicionMinima());

		if (listaPreseleccion.size() == Partido.ARQUEROS_DEFAULT) {
			listaPreseleccion.addAll(this.filtrar(Posicion.DEFENSOR, p.getCantDefensa(), p.getCondicionMinima()));
			listaPreseleccion
					.addAll(this.filtrar(Posicion.MEDIOCAMPISTA, p.getCantMediocampo(), p.getCondicionMinima()));
			listaPreseleccion.addAll(this.filtrar(Posicion.DELANTERO, p.getCantDelantera(), p.getCondicionMinima()));
			if (listaPreseleccion.size() != Partido.CANT_JUGADORES) {
				listaPreseleccion.clear();
			}
		} else {
			listaPreseleccion.clear();
		}

		return listaPreseleccion;

	}

	private ArrayList<Jugador> filtrar(Posicion posicion, int cantidad, int condicionMinima) {
		ArrayList<Jugador> listaFiltrada = new ArrayList<>();
		int i = 0;
		while (i < this.plantilla.size() && cantidad > 0) {
			if (this.plantilla.get(i).esElegible(posicion, condicionMinima)) {
				cantidad--;
				listaFiltrada.add(this.plantilla.get(i));
			}
			i++;
		}
		return listaFiltrada;
	}

	private Partido buscarPartido(String fecha) {
		int i = 0;
		Partido encontrado = null;
		while (i < this.partidos.size() && !this.partidos.get(i).mismaFecha(fecha)) {
			i++;
		}
		if (i < this.partidos.size()) {
			encontrado = this.partidos.get(i);
		}
		return encontrado;
	}

	public void mostrarPreseleccion(String fecha) {
		Partido partido = this.buscarPartido(fecha);

		if (partido == null) {
			System.out.println("No se encontro el partido para la fecha " + fecha);
		} else {
			System.out.println(partido);
		}
	}

}