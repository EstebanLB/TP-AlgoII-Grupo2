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
		Jugador jug1=null;
		Jugador jug2=null;
		int fin = 0;
		try
		{
			Juego juego=MotorConfig.obtenerJuego();

			System.out.println("Nueva partida de "+juego.getNombre());

			for(int i=1; i<3; ++i)
			{
				System.out.println("Introduzca el nombre del Jugador "+i);
				java.util.Scanner scanner=new Scanner(System.in);
				String nombre=scanner.next();
				System.out.println("Elija ficha para Jugador "+i);
				char valor=scanner.next().charAt(0);
				if(i==1)
				{
					jug1=new Jugador(valor,nombre);
					jug1.setJuego(juego);
				}
				else
				{
					jug2=new Jugador(valor,nombre);
					jug2.setJuego(juego);
				}
				while(jug1!=null&&jug2!=null&&jug1.getValor()==jug2.getValor())
				{
					System.out.println("Ficha ya seleccionada");
					System.out.println("Elija ficha para Jugador "+i);
					scanner=new Scanner(System.in);
					valor=scanner.next().charAt(0);
					jug2.setValor(valor);
				}
			}

			juego.setJugadores(jug1,jug2);
			Jugador anteriorJugador=jug2;
			Jugador jugadorJugando=jug1;
			Jugador jugAux=null;

			juego.inicializar();
			juego.mostrarTablero();
			int cont=0;

			while(fin == 0)
			{
				System.out.println("Turno de "+jugadorJugando.getNombre()+"("+jugadorJugando.getValor()+")");
				while(!jugadorJugando.mover())
					;
				cont++;
				juego.mostrarTablero();
				jugAux=jugadorJugando;
				jugadorJugando=anteriorJugador;
				anteriorJugador=jugAux;
				if (juego.estaTerminado(anteriorJugador))
				  fin = 1;
				else
				{
					if (juego.estaEmpatado(cont))
					fin = 2;
				}
			}
			if(fin == 1)
			{
				System.out.println("Juego terminado. Ganó "+anteriorJugador.getNombre());
			}
			else
			{
				System.out.println("Juego terminado en empate");
			}
		}
		catch(RuntimeException ex)
		{
		}
	}
}
