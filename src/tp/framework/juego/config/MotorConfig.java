package tp.framework.juego.config;

import tp.framework.juego.Juego;
import tp.framework.elementos.Tablero;
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

	public static Juego obtenerJuego() throws ClassNotFoundException
	{
		leerConfig();
		if ( nombre.length() == 0)
			return null;
		try
		{
			Class Clase = Class.forName(clase);			
			Juego juegoNuevo  = (Juego)Clase.newInstance();
			juegoNuevo.setNombre(nombre);
			juegoNuevo.setearTablero( (int)Integer.parseInt(filas,10), (int)Integer.parseInt(columnas,10));
			return juegoNuevo;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public static Tablero obtenerTablero()
	{
		return null;
	}

}
