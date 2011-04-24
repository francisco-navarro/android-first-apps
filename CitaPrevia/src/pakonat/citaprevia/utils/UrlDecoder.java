package pakonat.citaprevia.utils;

public class UrlDecoder {
	
	
	public static String decodificar(String ruta){
		  String resultado=ruta;
		  
		  resultado=resultado.replaceAll("&aacute;", "á");
		  resultado=resultado.replaceAll("&eacute;", "é");
		  resultado=resultado.replaceAll("&iacute;", "í");
		  resultado=resultado.replaceAll("&oacute;", "ó");
		  resultado=resultado.replaceAll("&uacute;", "ú");
		  
		  return resultado;
	}

}
