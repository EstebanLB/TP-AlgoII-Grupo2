package tp.framework.elementos;

public class Ficha
{
	private int coordF;
	private int coordC;
	private boolean posicionada;
	private char valor;
	
	public Ficha(char valor){
		this.valor = valor;
		coordF = -1;
		coordC = -1;
		posicionada = false;
	}
	
	public void mover(int fila, int columna)
	{
		coordF = fila;
		coordC = columna;
		posicionada = true;
	}
	public char getValor()
	{
		return valor;
	}
	public void setValor(char valor)
	{
		this.valor = valor;
	}
	
}