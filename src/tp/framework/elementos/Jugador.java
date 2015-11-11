package tp.framework.elementos;

import java.util.ArrayList;
import tp.framework.juego.Juego;
import java.util.Scanner;

public class Jugador
{
	private ArrayList<Ficha> fichas = null;
	private Juego juego = null;
	private Tablero tablero = null;
	private int x,y = -1;
	private Ficha ficha = null;
	
	public void setFichas(ArrayList<Ficha> fichas)
	{
		this.fichas = fichas;
	}

	public void setJuego(Juego juego)
	{
		this.juego = juego;
	}

	/*public void setTablero(Tablero tablero)
	{
		this.tablero = tablero;
	}*/

	public boolean mover()
	{
		System.out.println( "Elija el casillero" );
		System.out.print( "Fila:" );
		java.util.Scanner scanner = new Scanner(System.in);
		y = scanner.nextInt();
		System.out.print( "Columna:" );
		x = scanner.nextInt();
		ficha = fichas.get(1);
		if (juego.validarMovimiento(ficha, x, y)) 
		{
			juego.posicionar(ficha, x, y);
			System.out.println( "Ficha posicionada en la ubicación (" + +x + "," + +y + ")" );
			fichas.remove(1);
			return true;
		} else {
			System.out.println( "Movimiento no válido, intente nuevamente" );
			return false;
		}
	}
}
