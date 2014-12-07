package com.angbeny.rti1live;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

	protected int splashTime=5000;
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.splash);

			
		
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				
					finish();
				Intent intent = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(intent);
				
				
			}
			
		}, splashTime);
	}
}
