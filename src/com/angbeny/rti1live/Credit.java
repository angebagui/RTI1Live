package com.angbeny.rti1live;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class Credit extends Activity {
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.credit);
		setOrientation();

		ActionBar ab = getActionBar(); 
		ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#81a3d0"));    
		          ab.setBackgroundDrawable(colorDrawable);
				
	}
	protected void setOrientation() {
	    int current = getRequestedOrientation();
	    // only switch the orientation if not in portrait
	    if ( current != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT ) {
	        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
	    }
	}

}
