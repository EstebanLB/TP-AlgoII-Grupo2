package tp.framework.elementos;

public abstract class Ficha
{
	private int coordF;
	private int coordC;
	private boolean posicionada;
	
	public abstract boolean mover(int f, int c);
	
}
