package com.example.testkk;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Set up click listeners for all the buttons
        View aboutButton = findViewById(R.id.aboutUsButton);
        aboutButton.setOnClickListener(this);
        View goGreenButton = findViewById(R.id.goGreenButton);
        goGreenButton.setOnClickListener(this);
        View interactiveMapButton = findViewById(R.id.interactiveMapButton);
        interactiveMapButton.setOnClickListener(this);
        View gameButton = findViewById(R.id.gameButton);
        gameButton.setOnClickListener(this);
        /*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        */
        
        
    }
    @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {		      
		    case R.id.aboutUsButton:
		         Intent i = new Intent(getApplicationContext(), AboutUs.class);
		         startActivity(i);
		         break;		         
		    case R.id.goGreenButton:
		    	startActivity(new Intent(this, GoGreen.class));
		    	break;
		    case R.id.interactiveMapButton:
		    	startActivity(new Intent(this, InteractiveMapContents.class));
		    	break;
		    case R.id.gameButton:
		    	startActivity(new Intent(this, Recycle.class));
		    	break;
	    }
		
}

		

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
