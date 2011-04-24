package pakonat.citaprevia;

import pakonat.citaprevia.utils.ActividadMenu;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Login extends ActividadMenu {
	
	
	public static final int ACCION_NUEVA=1;
	public static final int ACCION_CANCELA=2;
	
	private static RadioGroup grupo ;
	public static Intent intent_cancela;
	public static Intent intent_nueva;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        //Creamos los intent
        intent_cancela=new Intent(this,CancelarCita.class);
        intent_nueva=new Intent(this,NuevaCita.class);
        
        realizaLogin();
        
        grupo=(RadioGroup) findViewById(R.id.radioGroup);
        
        addEventoBoton();
    }
    
   

	private void realizaLogin() {
    	
    	TextView textoNombre= (TextView)findViewById(R.id.TextNombre);         	
    	
        //Ponemos el nombre que sacamos de la web: Bienvenido...
        textoNombre.setText(Principal.engine.doLogin(Principal.getCIP(),this.getApplicationContext()));
	}
	
	 private void addEventoBoton() {
		 Button boton=(Button) findViewById(R.id.botonLoginOk);
		 boton.setOnClickListener(new OnClickListener() {			
			public void onClick(View arg0) {
				int opcion=getOpcion();
				if(opcion==ACCION_CANCELA)
					startActivity(intent_cancela);
				else if (opcion==ACCION_NUEVA)
					startActivity(intent_nueva);
			}
		});
	 }

	public int getOpcion(){

    	if(grupo==null)
    		return -1;
    	
    	int id=grupo.getCheckedRadioButtonId();
    	if(id==R.id.radioPedirCita)
    		return ACCION_NUEVA;
    	else if(id==R.id.radioAnularCita)
    		return ACCION_CANCELA;
    	
    	return -1;
    }

}