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
		Jugador jug1 = new Jugador();
		jug1.setJuego(juego);
		
		Jugador jug2 = new Jugador();
		jug2.setJuego(juego);
		
		juego.setJugadores(jug1,jug2);
		//jug1.setTablero(tablero);
		//jug2.setTablero(tablero);
		
		//Revisar esto
		jug1.setFichas(juego.getFichas());
		jug2.setFichas(juego.getFichas());
		
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
		catch(ClassNotFoundException ex)
		{
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}
}
