package pakonat.citaprevia.html;

import java.util.ArrayList;

import pakonat.citaprevia.utils.Constants;



public class HtmlParser {
	
	private final String OPTION="<option";
	
	String[] html;

	private static final String REGEX_ELIMINA_HTML="\\<[A-z =\"0-9:]*>";
	
	public HtmlParser(String[] entrada){
		this.html=entrada;
	}
	
	public String[] getOptions(){
		
		ArrayList<String> lista = new ArrayList<String>();
		
		for(String s:html){
			if(s.contains(OPTION)){
				int start=s.indexOf(">")+1;
				int end=s.length();
				String opcion=s.substring(start,end);
				if(!opcion.contains("-"))
					//lista.add(opcion);
					lista.add(s.replaceAll(REGEX_ELIMINA_HTML,""));
				
			}
		}
		
		
		return lista.toArray(new String[0]);
	}
	
	public String linea(int i){
		return html[i];
	}
	
	public String textoLinea(int i){
		return html[i].replaceAll(REGEX_ELIMINA_HTML,"");
	}
	
	public static String procesaHtml(String s){
		
		s=s.replaceAll("&aacute;", "á");
		s=s.replaceAll("&eacute;", "é");
		s=s.replaceAll("&iacute;", "í");
		s=s.replaceAll("&oacute;", "ó");
		s=s.replaceAll("&uacute;", "ú");
		
		return s;
	}

}
