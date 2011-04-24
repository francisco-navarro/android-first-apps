package pakonat.citaprevia.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;

public class PakoNetUtils {
	
	//private static final String HTTP_USER="user";
	//private static final String HTTP_PASS="pass";
	
	private static String cookie;
	//Metodos de conexion al https
	
	public static StringBuffer nuevaConexionHttps(String rutaUrl,String referer){
		
		try{
			StringBuffer entrada = new StringBuffer();
			
			
			URL url = new URL(rutaUrl);
			URLConnection con = url.openConnection();
			con.setRequestProperty("Connection", 	"keep-alive");
			if(referer!=null)
				con.setRequestProperty("Referer", referer);			
			if(cookie!=null)
				con.setRequestProperty("Cookie", cookie);
			
			 for (int i=0; ; i++) {
			        String headerName = con.getHeaderFieldKey(i);
			        String headerValue = con.getHeaderField(i);

			        if (headerName == null && headerValue == null) {
			            // No more headers
			            break;
			        }
			        if ("Set-Cookie".equalsIgnoreCase(headerName)) {
			        	cookie=headerValue.split(";")[0];
			        }
			 }

			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));

			String linea;
			while ((linea = in.readLine()) != null) {
				try{
					entrada.append(linea.replaceAll("<", "\n<"));
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			return entrada;
			
		}catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	      
		
	}
	
	
	public static Authenticator getAuthenticator(Authenticator au){
		//Este es un metodo que nos apoyamos para usar una conexion https
		/*if(au!=null)
			return au;
		
		au = new Authenticator() {
	         @Override
	         protected PasswordAuthentication
	            getPasswordAuthentication() {
	            return new PasswordAuthentication
	               (HTTP_USER, HTTP_PASS.toCharArray());
	         }
	      };
	      Authenticator.setDefault(au);
	      
	      return au;*/return null;
	}
}
