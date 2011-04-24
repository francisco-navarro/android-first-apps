package pakonat.citaprevia.utils;

import java.util.ArrayList;

import pakonat.citaprevia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActividadMenu extends Activity{
	
	private static ArrayList<Activity> listaActividades;
	static{
		listaActividades=new ArrayList<Activity>();
	}
	
	public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 listaActividades.add(this);
	}

	//--FUNCIONES DEL MENU
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuInflater preparamenu = getMenuInflater();
    	preparamenu.inflate(R.menu.menu, menu);
    	return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.menuSalir:
			
			for(Activity act:listaActividades)
				act.finish();
			return true;
			
		case R.id.menuPreferencias:
			return true;			
			
		}
		
		return false;
	}
    
    
}
