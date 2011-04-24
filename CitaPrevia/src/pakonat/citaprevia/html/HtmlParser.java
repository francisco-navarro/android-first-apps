package pakonat.citaprevia.html;

import java.util.ArrayList;

import pakonat.citaprevia.utils.Constants;



public class HtmlParser {
	
	private final String OPTION="<option";
	
	String[] html;
	
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
					lista.add(opcion);
			}
		}
		
		
		return lista.toArray(new String[0]);
	}

}
