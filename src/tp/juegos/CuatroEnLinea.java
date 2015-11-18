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
		int f;
		int c;
		for(f=0; f<filas; f++)
		{
			for(c=0; c<columnas; c++)
			{
				Ficha fichaNueva=new Ficha(' ');
				tablero[f][c]=fichaNueva;
			}
		}
	}

	public void mostrarTablero()
	{
		int f;
		int c;
		for(f=0; f<filas; f++)
		{
			for(c=0; c<columnas; c++)
			{
				System.out.print("|"+tablero[f][c].getValor());
			}
			System.out.print("|");
			System.out.println();
		}
	}

	@Override
	public boolean validarMovimiento(Ficha ficha, int fila, int columna)
	{
		if((fila>=0)&&(fila<filas)&&(columna>=0)&&(columna<columnas)&&(tablero[0][columna].getValor()==' '))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void posicionar(Ficha ficha, int fila, int columna)
	{
		for(int f=filas-1; f>=0; f--)
		{
			if(tablero[f][columna].getValor()==' ')
			{
				ficha.mover(f,columna);
				tablero[f][columna]=ficha;
				break;
			}
		}
	}

	public boolean m_finalizado(Ficha tablero[][], char valorFicha)
	{
		boolean fin=false;
		String lineaStr="";
		String subCadena="";
		for(int l=0; l<4; l++)
		{
			subCadena=subCadena+valorFicha;
		}

		// Recorro filas
		int fAux=0;
		int cAux=0;
		for(int f=filas-1; f>=0; f--)
		{
			lineaStr="";
			for(int c=0; c<columnas; c++)
			{
				lineaStr=lineaStr+tablero[f][c].getValor();
			}
			fin=lineaStr.contains(subCadena);
			if(fin==true) break;
		}
		if(fin==true) return fin;

		// Recorro columnas
		for(int c=0; c<columnas; c++)
		{
			lineaStr="";
			for(int f=filas-1; f>=0; f--)
			{
				lineaStr=lineaStr+tablero[f][c].getValor();
			}
			fin=lineaStr.contains(subCadena);
			if(fin==true) break;
		}
		if(fin==true) return fin;

		// Diagonales '\' recorriendo la primera fila de izq a der
		for(int c=0; c<columnas; c++)
		{
			fAux=0;
			cAux=c;
			lineaStr="";
			while(fAux<filas&&cAux<columnas&&fAux>=0&&cAux>=0)
			{
				lineaStr=lineaStr+tablero[fAux][cAux].getValor();
				fAux++;
				cAux++;
			}
			fin=lineaStr.contains(subCadena);
			if(fin==true) break;
			if(lineaStr.length()<=4) break;
		}
		if(fin==true) return fin;

		// Diagonales '\' recorriendo la primera columna de arr a abj
		for(int f=1; f<filas; f++)
		{
			fAux=f;
			cAux=0;
			lineaStr="";
			while(fAux<filas&&cAux<columnas&&fAux>=0&&cAux>=0)
			{
				lineaStr=lineaStr+tablero[fAux][cAux].getValor();
				fAux++;
				cAux++;
			}
			fin=lineaStr.contains(subCadena);
			if(fin==true) break;
			if(lineaStr.length()<=4) break;
		}
		if(fin==true) return fin;

		// Diagonales '/' recorriendo la primera fila de der a izq
		for(int c=0; c<columnas; c++)
		{
			fAux=0;
			cAux=columnas-1-c;
			lineaStr="";
			while(fAux<filas&&cAux<columnas&&fAux>=0&&cAux>=0)
			{
				lineaStr=lineaStr+tablero[fAux][cAux].getValor();
				fAux++;
				cAux--;
			}
			fin=lineaStr.contains(subCadena);
			if(fin==true) break;
			if(lineaStr.length()<=4) break;
		}
		if(fin==true) return fin;

		// Diagonales '/' recorriendo la primera columna
		for(int f=1; f<filas; f++)
		{
			fAux=f;
			cAux=columnas-1;
			lineaStr="";
			while(fAux<filas&&cAux<columnas&&fAux>=0&&cAux>=0)
			{
				lineaStr=lineaStr+tablero[fAux][cAux].getValor();
				fAux++;
				cAux--;
			}
			fin=lineaStr.contains(subCadena);
			if(fin==true) break;
			if(lineaStr.length()<=4) break;
		}
		if(fin==true) return fin;
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
}
