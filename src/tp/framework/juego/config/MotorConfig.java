package tp.framework.juego.config;

import tp.framework.juego.Juego;
import tp.framework.elementos.tablero;
import java.lang.reflect.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder; 

public class MotorConfig
{
	private Juego juego = null;
	private static String columnas ="";
	private static String filas ="";
	private static String nombre ="";
	private static String clase ="";
	
	private static void leerConfig()
	{
	    //Se crea un SAXBuilder para poder parsear el archivo
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "DEMO.xml" );
	    try 
	    {
	        //Se crea el documento a traves del archivo
	        Document document = (Document) builder.build( xmlFile );
	 
	        //Se obtiene la raiz 'motorJuego'
	        Element rootNode = document.getRootElement();
	 
	        //Se obtiene la lista de hijos de la raiz 'juego'
	        List list = rootNode.getChildren( "juego" );

            //Se obtiene el elemento 'tabla'
            Element tabla = (Element) list.get(0);
 
            //Se obtiene el atributo 'nombre' que esta en el tag 'nombre'
            nombre = tabla.getAttributeValue("nombre");

            clase = tabla.getAttributeValue("clase");
            
            columnas = tabla.getAttributeValue("columnas");
            filas = tabla.getAttributeValue("filas");
            
            //System.out.println( "\t"+nombreJuego+"\t\t"+nombreClase+"\t\t");

	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	    }
	}

	public static Juego obtenerJuego() 
	{
		leerConfig();
		if ( nombre.length() == 0)
			return null;
		try
		{
			Class clase = Class.forName(clase);			
			Juego juegoNuevo  = (Juego)clase.newInstance();
			juegoNuevo.setNombre(nombre);
			juegoNuevo.armarTablero( Integer.parseInt(filas), Integer.parseInt(columnas) );
			juegoNuevo.setFilas(Integer.parseInt(filas));
			juegoNuevo.setColumnas(Integer.parseInt(columnas));
			return juegoNuevo;
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
