package com.example.testkk;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class GoGreen extends Activity implements OnClickListener {
	
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
		      super.onCreate(savedInstanceState);
		      setContentView(R.layout.gogreen);
		      View exhibitsButton = findViewById(R.id.aboutExhibit);
		      exhibitsButton.setOnClickListener(this);
		      View funFactsButton = findViewById(R.id.funFacts);
		      funFactsButton.setOnClickListener(this);
	   }

	   @Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			switch (v.getId()) {		      
			    case R.id.aboutExhibit:
			         Intent i = new Intent(getApplicationContext(), AboutExhibitContents.class);
			         startActivity(i);
			         break;
			    case R.id.funFacts:
			    	 startActivity(new Intent(this, FunFactsContents.class));
			    	 break;
		    }
			
	   }
}

