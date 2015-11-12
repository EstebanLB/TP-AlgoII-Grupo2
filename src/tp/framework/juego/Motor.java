package tp.framework.juego;

import java.lang.RuntimeException;
import tp.framework.elementos.Jugador;
import tp.framework.juego.config.MotorConfig;

public class Motor
{
	public static void main(String[] args)
	{
		try
		{
		Juego juego = MotorConfig.obtenerJuego();
		
		//if para elejir valor de ficha y jugador		
		char valor1;
		Jugador jug1 = new Jugador(valor1);
		jug1.setJuego(juego);
		
		char valor2;
		Jugador jug2 = new Jugador(valor2);
		jug2.setJuego(juego);
		
		juego.setJugadores(jug1,jug2);
		
		//jug1.setTablero(tablero);
		//jug2.setTablero(tablero);
		
		//jug1.setFichas(juego.getFichas('X'));
		//jug2.setFichas(juego.getFichas('O'));
		
		String siguienteJugador = "Jugador 1";
		juego.inicializar();
		juego.mostrarTablero();
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
		System.out.println( "Juego Terminado. Ganó el" +siguienteJugador);
		
	}
		catch(RuntimeException ex)
		{
		}

	}
}
