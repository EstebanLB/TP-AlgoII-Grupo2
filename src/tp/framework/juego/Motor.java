package tp.framework.juego;

import tp.framework.elementos.Jugador;
import tp.framework.elementos.Tablero;

import tp.framework.juego.config.MotorConfig;

public class Motor
{
	public static void main(String[] args)
	{
		
		Juego juego = MotorConfig.obtenerJuego();
		
		Tablero tablero = new Tablero();
		juego.setTablero(tablero);
		
		Jugador jug1 = new Jugador();
		jug1.setJuego(juego);
		
		Jugador jug2 = new Jugador();
		jug2.setJuego(juego);
		
		jug1.setFichas(juego.getFichas());
		jug2.setFichas(juego.getFichas());
		
		while( !juego.estaTerminado() )
		{

			while( !jug1.mover() );
			
			if( !juego.estaTerminado() )
			{
				while( !jug2.mover() );
			}
		}		
	}
}
