package tp.framework.elementos;

public abstract class Tablero
{
	//aca no me deja usar abstract para una matriz
	private Ficha[][]matriz = new Ficha [0][0];

	public void posicionar(Ficha ficha, int x, int y)
	{
		ficha.mover(x, y);
		matriz [x][y]= ficha;
		
	}
	
}
