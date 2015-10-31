package tp.framework.juego;

import tp.framework.elementos.Jugador;
import tp.framework.elementos.Tablero;

import tp.framework.juego.config.MotorConfig;

public class Motor
{
	public static void main(String[] args)
	{
		
		Juego juego = MotorConfig.obtenerJuego();
		Tablero tablero = MotorConfig.obtenerTablero();
		
		juego.setTablero(tablero);
		
		Jugador jug1 = new Jugador();
		jug1.setJuego(juego);
		
		Jugador jug2 = new Jugador();
		jug2.setJuego(juego);
		
		juego.setJugadores(jug1,jug2);
		jug1.setTablero(tablero);
		jug2.setTablero(tablero);
		
		//Revisar esto
		jug1.setFichas(juego.getFichas());
		jug2.setFichas(juego.getFichas());
		
		String siguienteJugador = "Jugador 1";
		while( !juego.estaTerminado() )
		{
			System.out.println( "Turno del Jugador 1" );
			siguienteJugador = "Jugador 1";
			while( !jug1.mover() );
			
			if( !juego.estaTerminado() )
			{
				System.out.println( "Turno del Jugador 2" );
				siguienteJugador = "Jugador 2";
				while( !jug2.mover() );
			}
		}
		if ( juego.estaEmpatado() )
		{
			System.out.println( "Juego terminado en empate" );
		}
		else
		{
			System.out.println( "Juego terminado. Ganó el" +siguienteJugador);
		}
		
	}
}
