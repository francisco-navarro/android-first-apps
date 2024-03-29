package pakonat.citaprevia.html;

import java.util.ArrayList;

import pakonat.citaprevia.utils.Constants;



public class HtmlParser {
	
	private final String OPTION="<option";
	private final String FORM="<form";
	private final String _FORM="</form";
	private final String TABLE="<table";
	private final String TR="<tr";
	private final String _TR="</tr";
	private final String TD="<td";
	private final String _TD="</td";
	private final String CHECK="<input type=\"checkbox\" name=\"cita\" value=\"";
	
	String[] html;

	private static final String REGEX_ELIMINA_HTML="\\<[A-z =\"0-9:/]*>";
	
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
		
		s=s.replaceAll("&aacute;", "�");
		s=s.replaceAll("&eacute;", "�");
		s=s.replaceAll("&iacute;", "�");
		s=s.replaceAll("&oacute;", "�");
		s=s.replaceAll("&uacute;", "�");
		
		return s;
	}
	
	public  String[] extraerFormulario(){
		ArrayList<String> lista=new ArrayList<String>();

		for(int i=0;i<html.length;i++){
			if(html[i].startsWith(FORM)){
				String linea="";

				for(;i<html.length;i++){
					html[i]=html[i].replaceAll("\t", "");
					if(html[i].startsWith(TR)){

						linea="";
					}else if(html[i].startsWith(TR)){
						
					}else if(html[i].startsWith(TD)){
						for(;i<html.length;i++){
							html[i]=html[i].replaceAll("\t", "").replaceAll("  ", "");
							if(html[i].startsWith(CHECK)){
								linea+=";"+html[i].replaceAll(CHECK, "").split("\"")[0];
							}
							linea+=html[i].replaceAll(REGEX_ELIMINA_HTML,"");
							if(html[i].startsWith(_TR)){
								linea=linea.replaceAll("  ",";");
								lista.add(linea);
								break;
							}
						}
						
					}else if(html[i].startsWith(_FORM)){							
						break;
					}				
				}
			}


		}
		return  lista.toArray(new String[0]);
	}

}
