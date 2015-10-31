package TATETI.src;

import java.util.Scanner;
import java.lang.String;

public class TATETI
{
    

	public static void main(String[] args)
	{	
		char[][] Tablero = new char[3][3];
		TATETI.m_inicializar( Tablero );
		char ficha = 'O';
		int x = 0;
		int y = 0;
		String mov;
		String[] posiciones;
	    boolean fin = false;
		
		java.util.Scanner scanner = new Scanner(System.in);
		
		while (fin != true)
		{
			TATETI.m_mostrar_tablero( Tablero );
			System.out.println( "Elija el casillero (y,x) " + ficha );
			mov = scanner.nextLine();
			posiciones = mov.split(",");;
			x = Integer.parseInt(posiciones[0]);
			y = Integer.parseInt(posiciones[1]);
			if ( x < 0 || x > 2 || y < 0 || y > 2 )
				continue;
			if (Tablero[x][y] == ' ' )
			{
				Tablero[x][y] = ficha;
				fin = TATETI.m_finalizado( Tablero, ficha);
				if (fin == true)
					continue;
				if ( ficha == 'O' )
				   {ficha = 'X'; continue;}
				else;
				   {ficha = 'O'; continue;}
			}
		}
		TATETI.m_mostrar_tablero( Tablero );
		System.out.println( "GANADOR " + ficha);
		scanner.close();
	}
	public static void m_inicializar(char tablero[][])
	{
		int i;
		int j;
		for (i=0;i<3;i++)
		{
			for (j=0;j<3;j++)
			{
				tablero[i][j] = ' ';
			}
		}
	}
	public static void m_mostrar_tablero(char tablero[][])
	{
		int i;
		for (i=0;i<3;i++)
		{
			System.out.println(" "+tablero[i][0]+ " | "+tablero[i][1]+" | "+tablero[i][2]);
			if (i==0 || i==1)
			System.out.println("---" + "+" + "---" + "+"+"---");
		}
	}
	public static boolean m_finalizado(char tablero[][], char ficha)
	{
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
}
