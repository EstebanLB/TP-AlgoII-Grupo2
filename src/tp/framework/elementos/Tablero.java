package tp.framework.elementos;

public class Tablero
{

	private  Ficha[][]matriz = new Ficha [0][0];

	public void posicionar(Ficha ficha, int x, int y)
	{
		ficha.mover(x, y);
		matriz [x][y]= ficha;
		
	}
	
}
