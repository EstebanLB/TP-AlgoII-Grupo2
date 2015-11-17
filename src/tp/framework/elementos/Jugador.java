package tp.framework.elementos;

import tp.framework.juego.Juego;
import java.util.Scanner;

public class Jugador
{
	private Juego juego = null;
	private int x,y = -1;
	private Ficha ficha = null;
	private char valor = ' ';
	private String nombre = null;
	
	
	
	public Jugador(char v, String n){
		valor = v;
		nombre = n;
		ficha = new Ficha(valor);
	}
	public char getValor(){
		return valor;
	}
	public String getNombre()
	{
		return nombre;
	}
	
	public Ficha getFicha(){
		return ficha;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setJuego(Juego j){
		juego = j;
	}

	@SuppressWarnings("resource")
	public boolean mover()
	{
		System.out.println( "Elija un casillero del 1 al "+juego.getFilas() );
		System.out.print( "Columna:" );
		java.util.Scanner scanner = new Scanner(System.in);
		y = scanner.nextInt()-1;
		System.out.println( "Elija un casillero del 1 al "+juego.getColumnas() );
		System.out.print( "Fila:" );
		x = scanner.nextInt()-1;
		
		ficha = new Ficha(valor);
		if (juego.validarMovimiento(ficha, x, y)) 		{
			juego.posicionar(ficha, x, y);
			System.out.println( "Ficha posicionada en la ubicación ("+(x+1) +","+(y+1) +")" );
			return true;
		} else {
			System.out.println( "Movimiento no válido, intente nuevamente");
			return false;
		}
	}
}
