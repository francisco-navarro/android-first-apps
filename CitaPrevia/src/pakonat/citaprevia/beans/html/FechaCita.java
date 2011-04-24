package pakonat.citaprevia.beans.html;

import java.util.ArrayList;

import pakonat.citaprevia.utils.Constants;

public class FechaCita implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> lista;
	private String informacionCita;
	
	
	public FechaCita () {
		lista = new ArrayList<String>();
		informacionCita="";
	}
	
	public ArrayList<String> getLista(){
		return lista;
	}
	
	public String getInformacionCita() {
		return informacionCita;
	}

	public void setInformacionCita(String info) {
		String[] arrayInfo =info.split(">");
		if(arrayInfo.length>1)
			informacionCita +="\n"+arrayInfo[1];
	}

	
	public void add(String opt){
		String[] cadena = opt.split("\"");
		for(String subCadena:cadena)
			if(subCadena.contains(Constants.THIS_YEAR)){
				lista.add(subCadena);
				break;
			}
	}
	
	public String toString(){
		String result ="[FechaCita: (";
		
		for(String f:lista)
			result+=f+",";
		
		return result+")]";
	}
}
