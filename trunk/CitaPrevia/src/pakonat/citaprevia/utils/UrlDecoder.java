package pakonat.citaprevia.utils;

public class UrlDecoder {
	
	
	public static String decodificar(String ruta){
		  String resultado=ruta;
		  
		  resultado=resultado.replaceAll("&aacute;", "�");
		  resultado=resultado.replaceAll("&eacute;", "�");
		  resultado=resultado.replaceAll("&iacute;", "�");
		  resultado=resultado.replaceAll("&oacute;", "�");
		  resultado=resultado.replaceAll("&uacute;", "�");
		  
		  return resultado;
	}

}
