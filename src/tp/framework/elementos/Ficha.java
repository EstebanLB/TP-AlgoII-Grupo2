package tp.framework.elementos;

public abstract class Ficha
{
	private int coordF;
	private int coordC;
	private boolean posicionada;
	
	public void mover(int f, int c)
	{
		coordF = f;
		coordC = c;
		posicionada = true;
	}
	
}
