package BE_TS1A_BARRERA_GABRIELA;


public class Test {

	public static void main(String[] args) {		
      
        ANF anf = new ANF();

		// Carga de jugadores
        anf.cargarJugadores(Posicion.ARQUERO, 3, 90, false);
        anf.cargarJugadores(Posicion.DEFENSOR, 15, 90, false);
        anf.cargarJugadores(Posicion.MEDIOCAMPISTA, 15, 90, false);
        anf.cargarJugadores(Posicion.DELANTERO, 15, 90, false);

		// Crear un partido
		anf.gestionarPartido("20250101", "Brasil", 8, 8, 4, 70);
		anf.mostrarPreseleccion("20250101");

		anf.gestionarPartido("20250201", "Argelia", 8, 8, 4, 70);
		anf.mostrarPreseleccion("20250201");

		anf.gestionarPartido("20250301", "Inglaterra", 8, 8, 4, 70);
		anf.mostrarPreseleccion("20250301");
		
	    // Reporte
		anf.mostrarReporteJugadoresMasConvocados();

	}


}
