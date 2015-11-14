package tp.framework.juego;

import java.lang.RuntimeException;
import java.util.Scanner;

import tp.framework.elementos.Jugador;
import tp.framework.juego.config.MotorConfig;

public class Motor
{
	public static void main(String[] args)
	{
		try
		{
		Juego juego = MotorConfig.obtenerJuego();
		
		System.out.println( "Nueva partida de " +juego.getNombre() );
		
		System.out.println( "Introduzca el nombre del jugador1" );
		@SuppressWarnings("resource")
		java.util.Scanner scanner = new Scanner(System.in);
		String nombre = scanner.next();
		System.out.println( "Elija ficha para jugador1" );
		char valor = scanner.next().charAt(0);
		Jugador jug1 = new Jugador(valor, nombre);
		jug1.setJuego(juego);
		
		System.out.println( "Introduzca el nombre del jugador2" );
		nombre = scanner.next();
		System.out.println( "Elija ficha para jugador2" );
		valor = scanner.next().charAt(0);
		Jugador jug2 = new Jugador(valor, nombre);
		jug2.setJuego(juego);
		
		juego.setJugadores(jug1,jug2);
		
		String siguienteJugador = jug1.getNombre();
		juego.inicializar();
		juego.mostrarTablero();
		int cont = 0;
				
		while( !juego.estaTerminado(jug2) || !juego.estaEmpatado(cont) )	{
			siguienteJugador = jug1.getNombre();
			System.out.println( "Turno de " +siguienteJugador );
			while( !jug1.mover() );
			cont++;
			if( !juego.estaTerminado(jug1) || !juego.estaEmpatado(cont)){
				siguienteJugador = jug2.getNombre();
				System.out.println( "Turno de " +siguienteJugador );
				while( !jug2.mover() );
				cont++;
			}
		}
		if ( juego.estaEmpatado(cont) )		{
			System.out.println( "Juego terminado en empate" );
		}	else	{
			System.out.println( "Juego terminado. Ganó " +siguienteJugador);
		}
				
	}
		catch(RuntimeException ex)
		{
		}

	}
}
