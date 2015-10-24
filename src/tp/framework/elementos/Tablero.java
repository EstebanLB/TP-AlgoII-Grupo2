package tp.framework.elementos;

import java.util.ArrayList;

public class Tablero
{

	private Ficha matriz [][] = new Ficha [0][0];
//	private ArrayList<ArrayList<Ficha>> matriz = NULL;

	public void posicionar(Ficha ficha, int x, int y)
	{
		ficha.mover(x, y);
		matriz [x][y]= ficha;
	}
	
}
