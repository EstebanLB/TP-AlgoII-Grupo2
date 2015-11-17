package tp.framework.juego;

import java.lang.RuntimeException;
import java.util.Scanner;
import java.lang.reflect.*;

import tp.framework.elementos.Jugador;
import tp.framework.juego.config.MotorConfig;

public class Motor
{
	public static void main(String[] args)
	{
		Jugador jug1 = null;
		Jugador jug2 = null;
		
		try		{
		Juego juego = MotorConfig.obtenerJuego();
		
		System.out.println( "Nueva partida de " +juego.getNombre() );
		
		for (int i=1; i<3; ++i){
			System.out.println( "Introduzca el nombre del jugador"+i );
			@SuppressWarnings("resource")
			java.util.Scanner scanner = new Scanner(System.in);
			String nombre = scanner.next();
			System.out.println( "Elija ficha para jugador"+i );
			char valor = scanner.next().charAt(0);
				if (i==1){
					jug1 = new Jugador(valor, nombre);
					jug1.setJuego(juego);
				}	else	{
					jug2 = new Jugador(valor, nombre);
					jug2.setJuego(juego);
				}
		}
		
		juego.setJugadores(jug1,jug2);
		Jugador siguienteJugador = jug1;
		juego.inicializar();
		juego.mostrarTablero();
		int cont = 0;
				
		while( !juego.estaTerminado(jug2) && !juego.estaEmpatado(cont) )	{
			siguienteJugador = jug1;
			System.out.println( "Turno de " +siguienteJugador.getNombre() +"(" +siguienteJugador.getValor() +")" );
			while( !jug1.mover() );
			cont++;
			juego.mostrarTablero();
			if( !juego.estaTerminado(jug1) && !juego.estaEmpatado(cont)){
				siguienteJugador = jug2;
				System.out.println( "Turno de " +siguienteJugador.getNombre() +"(" +siguienteJugador.getValor()+")"  );
				while( !jug2.mover() );
				cont++;
				juego.mostrarTablero();
			}	else	{
				if ( juego.estaEmpatado(cont) )		{
					System.out.println( "Juego terminado en empate" );
				}	else	{
					System.out.println( "Juego terminado. Ganó " +siguienteJugador.getNombre());
				}
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
