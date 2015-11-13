package tp.juegos;

import tp.framework.elementos.Ficha;
import tp.framework.elementos.Jugador;
import tp.framework.juego.Juego;

public class Tateti extends Juego
{

	public Tateti()
	{
		
	}

	public void inicializar()	{
		for (int i=0;i<filas;i++)	{
			for (int j=0;j<columnas;j++){
				tablero[i][j] = new Ficha(' ');
			}
		}
	}

	public void mostrarTablero()	{
		for (int i=0;i<filas;i++)
		{
			System.out.println(" "+tablero[i][0].getValor()+ " | "+tablero[i][1].getValor()+" | "+tablero[i][2].getValor());
			if (i==0 || i==1)
			System.out.println("---" + "+" + "---" + "+"+"---");
		}
	}

	public boolean validarMovimiento(Ficha ficha, int x, int y)	{
		if ((tablero[x][y].getValor() != ' ') || (x<0) || (x>columnas-1) || (y<0) || (y>filas-1)){
			return true;
		}	else {
			return false;
		}
	}
		
	public boolean estaTerminado(Jugador jugador) {
		Ficha ficha = jugador.getFicha(); 
		boolean fin = false;
		int i;
		int j;
		for (i=0;i<3;i++)
		{
			for (j=0;j<3;j++)
			{
				if (  tablero[i][j] == ficha )
					{fin = true; continue;}
				else;
					{fin = false; break;}
								}
			if ( fin == true )
				break;
		}
		if (fin == false)
		{
			for (j=0;j<3;j++)
			{
				for (i=0;i<3;i++)
				{
					if (  tablero[i][j] == ficha )
						{fin = true; continue;}
					else;
						{fin = false; break;}
									}
				if ( fin == true )
					break;
			}
		}
		if (fin == false)
		{
			if (tablero[0][0] == ficha
			&& tablero[1][1] == ficha
			&& tablero[2][2] == ficha )
				fin = true;
			
			if (tablero[0][2] == ficha
			&& tablero[1][1] == ficha
			&& tablero[2][0] == ficha )
				fin = true;
			
		}
			return fin;
	}

	public boolean estaEmpatado(int c){
	boolean bool = (c == filas * columnas);
	return bool;
	}
}
