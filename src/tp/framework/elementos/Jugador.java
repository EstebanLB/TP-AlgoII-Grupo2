package tp.framework.elementos;

import java.util.ArrayList;

import tp.framework.juego.Juego;

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

	public boolean mover()
	{
		
		x = 0;
		y = 0;
		ficha = fichas.get(1);
		if (juego.validarMovimiento(ficha, x, y)) {
			//asignacion de ubicacion->T
			tablero.posicionar(ficha, x, y);
			return true;
		} else {
			// mensaje no es posible mover ->F
			return false;
		}
	}
}
