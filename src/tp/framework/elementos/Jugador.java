package tp.framework.elementos;

import tp.framework.juego.Juego;
import java.util.Scanner;

public class Jugador
{
	private Juego juego = null;
	private int x,y = -1;
	private Ficha ficha = null;
	private char valor = ' ';
	
	public Jugador(char v){
		valor = v;
	}
	
	public void setJuego(Juego j){
		juego = j;
	}

	public boolean mover()
	{
		System.out.println( "Elija el casillero" );
		System.out.print( "Fila:" );
		java.util.Scanner scanner = new Scanner(System.in);
		y = scanner.nextInt();
		System.out.print( "Columna:" );
		x = scanner.nextInt();
		
		ficha = new Ficha(valor);
		if (juego.validarMovimiento(ficha, x, y)) 
		{
			juego.posicionar(ficha, x, y);
			System.out.println( "Ficha posicionada en la ubicación (" + +x + "," + +y + ")" );
			//fichas.remove(1);
			return true;
		} else {
			System.out.println( "Movimiento no válido, intente nuevamente" );
			return false;
		}
	}
}
