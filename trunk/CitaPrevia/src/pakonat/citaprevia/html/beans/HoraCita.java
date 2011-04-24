package pakonat.citaprevia.html.beans;

import java.io.Serializable;

public class HoraCita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;
	private java.util.ArrayList<String> horas;
	
	public HoraCita(){
		msg="";
		horas=new java.util.ArrayList<String>();
	}
	
	public void addHora(String h){
		horas.add(h);
	}
	public void addHoras(String[] s){
		for(String s1:s)
			horas.add(s1);
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String[] getHoras() {
		return horas.toArray(new String[0]);
	}
	
	
}
