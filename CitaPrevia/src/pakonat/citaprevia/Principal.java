package pakonat.citaprevia;

import pakonat.citaprevia.main.Almacenamiento;
import pakonat.citaprevia.main.Engine;
import pakonat.citaprevia.utils.ActividadMenu;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends ActividadMenu {
	
	public static Intent intentLogin;
	public static Engine engine;
	private static EditText cip ;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        intentLogin= new Intent(this,Login.class);
        engine = new Engine();
        
        Button boton = (Button)findViewById(R.id.button1);
        cip = (EditText) findViewById(R.id.editCIP);
        
        Almacenamiento almacenamiento=new Almacenamiento(this.getApplicationContext());        
        cip.setText(almacenamiento.leer());
        
        boton.setOnClickListener(new OnClickListener() {			
        	
        	
			public void onClick(View v) {
				
				startActivity(Principal.intentLogin);
				
			}
		});
    }

	public static String getCIP() {		
		return cip.getText().toString();
	}


    
    
}