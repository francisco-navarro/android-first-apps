package pakonat.citaprevia.html.beans;

import java.io.Serializable;

public class InfoCita implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String hora;
	private String dia;
	private String msg;
	private Integer id;
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
