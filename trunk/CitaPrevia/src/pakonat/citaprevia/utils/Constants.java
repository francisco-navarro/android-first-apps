package pakonat.citaprevia.utils;

import java.io.File;

public class Constants {
	
	//CONSTANTES GENERALES DE LA APLICACION
	public static String THIS_YEAR="2011";
	public static String APP_RUTA_ALMACENAMIENTO=".CitaPrevia"+File.separator;
	public static String APP_FICHERO_ALMACENAMIENTO="settingsCitaPrevia.txt";
	
	
	//HTML_CONSTANTS
	public static final String HTML_OPTION="<option";
	public static final String HTML_P="<p>";
	public static final String HTML_BR="<br>";
	public static final String HTML_SPAN="<span";
	public static final String HTML_LEGEND="<legend>";	
	public static final String HTML_FIELDSET_CLOSE="</fieldset>";	
	
	
	//CONSTANTES URL
	public static final String RUTA_ENTRADA="https://sescam.jccm.es/web1/sHome.do";
	public static final String RUTA_LOGIN="https://sescam.jccm.es/web1/CitaPreviaInitial.do?Aceptar=Aceptar&cip=##CIP##&operacion=citaPre";
	
	//nueva	
	public static final String RUTA_NUEVA_CITA="https://sescam.jccm.es/web1/CitaPrevia.do?operacion=DE";
	public static final String RUTA_NUEVA_CITA_DIA="https://sescam.jccm.es/web1/CitaPrevia1.do?fecha=##DIA##&operacion=datos";//https://sescam.jccm.es/web1/CitaPrevia1.do?fecha=vie%2015%2F04%2F2011&operacion=datos
	public static final String RUTA_NUEVA_CITA_HORA="https://sescam.jccm.es/web1/CitaPrevia2.do?hora=##HORA##&operacion=Aceptar";	
	public static final String RUTA_NUEVA_CITA_TERMINAR="https://sescam.jccm.es/web1/CitaPrevia3.do?operacion=Terminar&telefono=";
	
	//anulacion
	public static final String RUTA_CANCELAR_CITA="https://sescam.jccm.es/web1/CitaPrevia.do?operacion=listaCita";
	public static final String RUTA_ELIMINAR_CITA="https://sescam.jccm.es/web1/CitaPreviaL.do?cita=##ID_CITA##&operacion=listaCita";

}
