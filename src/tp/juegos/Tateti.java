package tp.juegos;

import tp.framework.elementos.Ficha;
import tp.framework.juego.Juego;

public class Tateti extends Juego
{

	public Tateti()
	{
		
	}

	@Override
	public void inicializar()	{
		// poner caracteres en blanco para cada casillero

	}

	public void mostrarTablero()	{
		int i;
		for (i=0;i<3;i++)
		{
			System.out.println(" "+tablero[i][0]+ " | "+tablero[i][1]+" | "+tablero[i][2]);
			if (i==0 || i==1)
			System.out.println("---" + "+" + "---" + "+"+"---");
		}
	}

	@Override
	public boolean validarMovimiento(Ficha ficha, int x, int y)	{
		boolean flagOcupado = (tablero[x][y].getValor() == ' ');
		if ( x < 0 || x > 2 || y < 0 || y > 2 );
		
		//return ( x < 0 || x > 2 || y < 0 || y > 2 ) || flagOcupado;
	}
	public boolean estaTerminado() {
		
	}
	public boolean m_finalizado(char tablero[][], char ficha)
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

	@Override
	public boolean estaTerminado()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
