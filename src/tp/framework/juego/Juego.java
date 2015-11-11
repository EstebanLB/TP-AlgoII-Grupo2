package tp.framework.juego;

import java.util.ArrayList;

import tp.framework.elementos.Ficha;
import tp.framework.elementos.Jugador;

public abstract class Juego {
	protected Ficha tablero[][] = null;
	private String nombre = null;
	public Ficha[][] getTablero() {
		return tablero;
	}

	public void setTablero(Ficha[][] tablero) {
		this.tablero = tablero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private Jugador jugador1 = null;
	private Jugador jugador2 = null;
	
	public void setJugadores(Jugador j1, Jugador j2) {
		jugador1 = j1;
		jugador2 = j2;
	}

	public void posicionar(Ficha ficha, int x, int y) {
		ficha.mover(x, y);
		tablero[x][y] = ficha;
	}

	public abstract ArrayList<Ficha> getFichas();

	public abstract boolean estaTerminado();

	public abstract boolean estaTerminado(Ficha ficha);

	public abstract boolean validarMovimiento(Ficha ficha, int x, int y);

	public void setearTablero(int x, int y) {
		this.tablero = new Ficha[x][y];
	}
	public abstract void mostrarTablero();
	public abstract void inicializar();
}
