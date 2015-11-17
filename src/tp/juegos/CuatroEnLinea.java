package tp.juegos;

import java.util.Scanner;

import tp.framework.elementos.Ficha;
import tp.framework.elementos.Jugador;
import tp.framework.juego.Juego;

public class CuatroEnLinea extends Juego
{

	boolean empate=false;

	public CuatroEnLinea()
	{
	};

	@Override
	public void inicializar()
	{
		int i;
		int j;
		for(i=0; i<filas; i++)
		{
			for(j=0; j<columnas; j++)
			{
				Ficha fichaNueva=new Ficha(' ');
				tablero[i][j]=fichaNueva;
			}
		}
	}

	public void mostrarTablero()
	{
		int i;
		int j;
		for(i=0; i<filas; i++)
		{
			for(j=0; j<columnas; j++)
			{
				System.out.print("|"+tablero[i][j].getValor());
			}
			System.out.print("|");
			System.out.println();
		}
	}

	@Override
	public boolean validarMovimiento(Ficha ficha, int x, int y)	{
		if ((x>=0) && (x<columnas) && (y>=0) && (y<filas) && (tablero[0][y].getValor() == ' ')){
			return true;
		}	else {
			return false;
		}
	}
	
	public void posicionar(Ficha ficha, int x, int y) {
		for(int i=filas-1; i>=0; i--)
		{
			if(tablero[i][y].getValor()==' ')
			{
				ficha.mover(i, y);
				tablero[i][y] = ficha;
				break;
			}
		}
	}
	
		/*
		boolean estaLibre=true;
		// Valida que este dentro del tablero
		estaLibre=(x==0);
		if(estaLibre==true) estaLibre=(0<=y&&y<columnas);
		// Valida si esta ocupada la casilla
		if(estaLibre==true) estaLibre=(tablero[0][y].getValor()==' ');
		if(estaLibre==true) this.m_ubicarFicha(ficha,y);
		return estaLibre;
	}*/

	public void m_ubicarFicha(Ficha ficha, int y)
	{
		for(int i=filas-1; i>=0; i--)
		{
			if(tablero[i][y].getValor()==' ')
			{
				tablero[i][y].setValor(ficha.getValor());
				break;
			}
		}
	}

	public boolean m_finalizado(Ficha tablero[][], char valorFicha)
	{
		boolean fin=false;
		String fila="";
		String subCadena="";
		for(int l=0; l<4; l++)
		{
			subCadena=subCadena+valorFicha;
		}

		// Recorro filas
		int k=0;
		int l=0;
		for(int i=filas-1; i>=0; i--)
		{
			fila="";
			for(int j=0; j<columnas; j++)
			{
				fila=fila+tablero[i][j].getValor();
			}
			fin=fila.contains(subCadena);
			if(fin==true) break;
		}
		if(fin==true) return fin;

		// Recorro columnas
		for(int j=0; j<columnas; j++)
		{
			fila="";
			for(int i=filas-1; i>=0; i--)
			{
				fila=fila+tablero[i][j].getValor();
			}
			fin=fila.contains(subCadena);
			if(fin==true) break;
		}
		if(fin==true) return fin;

		// Diagonales '\' recorriendo la primera fila de izq a der
		for(int i=0; i<columnas; i++)
		{
			k=0;
			l=i;
			fila="";
			while(k<filas&&l<columnas&&k>=0&&l>=0)
			{
				fila=fila+tablero[k][l].getValor();
				k++;
				l++;
			}
			fin=fila.contains(subCadena);
			if(fin==true) break;
			if(fila.length()<=4) break;
		}
		if(fin==true) return fin;

		// Diagonales '\' recorriendo la primera columna de arr a abj
		for(int i=1; i<filas; i++)
		{
			k=i;
			l=0;
			fila="";
			while(k<filas&&l<columnas&&k>=0&&l>=0)
			{
				fila=fila+tablero[k][l].getValor();
				k++;
				l++;
			}
			fin=fila.contains(subCadena);
			if(fin==true) break;
			if(fila.length()<=4) break;
		}
		if(fin==true) return fin;

		// Diagonales '/' recorriendo la primera fila de der a izq
		for(int i=0; i<columnas; i++)
		{
			k=0;
			l=columnas-1-i;
			fila="";
			while(k<filas&&l<columnas&&k>=0&&l>=0)
			{
				fila=fila+tablero[k][l].getValor();
				k++;
				l--;
			}
			fin=fila.contains(subCadena);
			if(fin==true) break;
			if(fila.length()<=4) break;
		}
		if(fin==true) return fin;

		// Diagonales '/' recorriendo la primera columna
		for(int i=1; i<filas; i++)
		{
			k=i;
			l=columnas-1;
			fila="";
			while(k<filas&&l<columnas&&k>=0&&l>=0)
			{
				fila=fila+tablero[k][l].getValor();
				k++;
				l--;
			}
			fin=fila.contains(subCadena);
			if(fin==true) break;
			if(fila.length()<=4) break;
		}
		if(fin==true) return fin;
		return fin;
	}

	public boolean m_tablero_completo()
	{
		boolean fin=true;
		int i;
		int j;
		for(i=0; i<6; i++)
		{
			for(j=0; j<7; j++)
			{
				if(tablero[i][j].getValor()==' ')
				{
					fin=false;
				}
				if(fin==false) break;
			}
			if(fin==false) break;
		}
		return fin;
	}

	@Override
	public boolean estaTerminado(Jugador jugador)
	{
		boolean fin=false;
		fin=this.m_finalizado(tablero,jugador.getValor());
		return fin;
	}

	@Override
	public boolean estaEmpatado(int c)
	{
		boolean bool=(c==filas*columnas);
		return bool;
	}
/*
	@Override
	@SuppressWarnings("resource")
	public boolean mover(Jugador jugador)
	{
		System.out.println("Elija una columna del 1 al "+getColumnas());
		int x=0;
		java.util.Scanner scanner=new Scanner(System.in);
		int y=scanner.nextInt()-1;

		Ficha ficha=new Ficha(jugador.getValor());
		if(validarMovimiento(ficha,x,y))
		{
			//posicionar(ficha,x,y);
			System.out.println("Ficha posicionada en la columna ("+(y+1)+")");
			return true;
		}
		else
		{
			System.out.println("Movimiento no válido, intente nuevamente");
			return false;
		}
	}*/

}
