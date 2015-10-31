package tp.framework.juego;
import java.util.ArrayList;

import tp.framework.elementos.Ficha;
import tp.framework.elementos.Jugador;
import tp.framework.elementos.Tablero;

public abstract class Juego
{
	private Tablero tablero = null;
	private Jugador jugador1 = null;
	private Jugador jugador2 = null;
	
	public void setTablero(Tablero t)
	{
		tablero = t;
	}
	public void setJugadores(Jugador j1, Jugador j2) 
	{
		jugador1 = j1;
		jugador2 = j2;
	}

	public abstract ArrayList<Ficha> getFichas();

	public abstract boolean estaTerminado();

	public boolean validarMovimiento(Ficha ficha, int x, int y)
	{
			return false;
	}
	public boolean estaEmpatado()
	
	{
		// TODO Auto-generated method stub
		return false;
	}

}
