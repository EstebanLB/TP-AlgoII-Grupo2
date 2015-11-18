package tp.juegos;

import tp.framework.elementos.Ficha;
import tp.framework.elementos.Jugador;
import tp.framework.juego.Juego;

public class Tateti extends Juego
{

	public Tateti()
	{

	}

	public void inicializar()
	{
		for(int f=0; f<filas; f++)
		{
			for(int c=0; c<columnas; c++)
			{
				tablero[f][c]=new Ficha(' ');
			}
		}
	}

	public void mostrarTablero()
	{
		for(int f=0; f<filas; f++)
		{
			System.out.println(" "+tablero[f][0].getValor()+" | "+tablero[f][1].getValor()+" | "+tablero[f][2].getValor());
			if(f==0||f==1) System.out.println("---"+"+"+"---"+"+"+"---");
		}
	}

	public boolean validarMovimiento(Ficha ficha, int fila, int columna)
	{
		if((fila>=0)&&(fila<filas)&&(columna>=0)&&(columna<columnas)&&(tablero[fila][columna].getValor()==' '))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean estaTerminado(Jugador jugador)
	{
		Ficha ficha=jugador.getFicha();
		boolean fin=false;
		int fila;
		int columna;
		for(fila=0; fila<3; fila++)
		{
			for(columna=0; columna<3; columna++)
			{
				if(tablero[fila][columna].getValor()==ficha.getValor())
				{
					fin=true;
					continue;
				}
				else
				{
					fin=false;
					break;
				}
			}
			if(fin==true) break;
		}
		if(fin==false)
		{
			for(columna=0; columna<3; columna++)
			{
				for(fila=0; fila<3; fila++)
				{
					if(tablero[fila][columna].getValor()==ficha.getValor())
					{
						fin=true;
						continue;
					}
					else
					{
						fin=false;
						break;
					}
				}
				if(fin==true) break;
			}
		}
		if(fin==false)
		{
			if(tablero[0][0].getValor()==ficha.getValor()&&tablero[1][1].getValor()==ficha.getValor()&&tablero[2][2].getValor()==ficha.getValor()) fin=true;
			if(tablero[0][2].getValor()==ficha.getValor()&&tablero[1][1].getValor()==ficha.getValor()&&tablero[2][0].getValor()==ficha.getValor()) fin=true;
		}
		return fin;
	}

	public boolean estaEmpatado(int c)
	{
		boolean bool=(c==filas*columnas);
		return bool;
	}
}
