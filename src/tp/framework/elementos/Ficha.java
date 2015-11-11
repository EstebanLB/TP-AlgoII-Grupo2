package tp.framework.elementos;

public abstract class Ficha
{
	private int coordF;
	private int coordC;
	private boolean posicionada;
	private char valor;
	public void mover(int f, int c)
	{
		coordF = f;
		coordC = c;
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