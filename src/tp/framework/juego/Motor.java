package tp.framework.juego;

import java.lang.RuntimeException;
import java.util.Scanner;

import tp.framework.elementos.Jugador;
import tp.framework.juego.config.MotorConfig;

public class Motor
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Jugador jug1 = null;
		Jugador jug2 = null;
		
		try		{
		Juego juego = MotorConfig.obtenerJuego();
		
		System.out.println( "Nueva partida de " +juego.getNombre() );
		
		for (int i=1; i<3; ++i){
			System.out.println( "Introduzca el nombre del Jugador "+i );
			java.util.Scanner scanner = new Scanner(System.in);
			String nombre = scanner.next();
			System.out.println( "Elija ficha para Jugador "+i );
			char valor = scanner.next().charAt(0);
				if (i==1){
					jug1 = new Jugador(valor, nombre);
					jug1.setJuego(juego);
				}	else	{
					jug2 = new Jugador(valor, nombre);
					jug2.setJuego(juego);
				}
		}
		while (jug1.getValor() == jug2.getValor()){
			System.out.println( "Elija una ficha diferente a la del Jugador 1" );
			System.out.println( "Elija ficha para Jugador 2");
			java.util.Scanner scanner = new Scanner(System.in);
			char valor = scanner.next().charAt(0);
			jug2.setValor(valor);
		}
				
		juego.setJugadores(jug1,jug2);
		Jugador anteriorJugador = jug2;
		Jugador jugadorJugando  = jug1;
		Jugador jugAux = null;
		
		juego.inicializar();
		juego.mostrarTablero();
		int cont = 0;
				
		while( !juego.estaTerminado(anteriorJugador) && !juego.estaEmpatado(cont) )	{
			System.out.println( "Turno de " +jugadorJugando.getNombre() +"(" +jugadorJugando.getValor() +")" );
			while( !jugadorJugando.mover() );
			cont++;
			juego.mostrarTablero();
			jugAux = jugadorJugando;
			jugadorJugando = anteriorJugador;
			anteriorJugador = jugAux;
					
		}
		if ( juego.estaEmpatado(cont) )	{
			System.out.println( "Juego terminado en empate" );
		}	else	{
			System.out.println( "Juego terminado. Ganó " +anteriorJugador.getNombre());
		}
				
	}
		catch(RuntimeException ex){
		}

	}
}
