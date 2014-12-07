package com.angbeny.rti1live;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends Activity {
	private ProgressBar progress;
	private int mProgressStatus = 0;
	private WebView webview;
	private boolean progressState = false;

    private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setOrientation();
		ActionBar ab = getActionBar(); 
		ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#81a3d0"));    
		          ab.setBackgroundDrawable(colorDrawable);
				
		 webview = (WebView)findViewById(R.id.webView);
		final WebSettings settings = webview.getSettings();
		settings.setDefaultTextEncodingName("utf-8");
		settings.setJavaScriptEnabled(true);
		settings.setLoadsImagesAutomatically(true);
		settings.setAllowFileAccess(true);
		settings.setPluginState(PluginState.ON);
		webview.setWebChromeClient(new MyWebViewClient());
		progress = (ProgressBar) findViewById(R.id.progressbar);
       
      
		webview.loadUrl("file:///android_asset/www/index.html");
		//myClickHandler();
		
	}

	protected void setOrientation() {
	    int current = getRequestedOrientation();
	    // only switch the orientation if not in portrait
	    if ( current != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT ) {
	        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
	    }
	}
	 private class MyWebViewClient extends WebChromeClient { 
	        @Override
	        public void onProgressChanged(WebView view, int newProgress) {          
	            MainActivity.this.setValue(newProgress);
	            super.onProgressChanged(view, newProgress);
	            
	        }
	 }
	 @SuppressWarnings("static-access")
	public void setValue(int mprogress) {
		 mProgressStatus = mprogress;

	       // Start lengthy operation in a background thread
	        new Thread(new Runnable() {
	            public void run() {
	                while (mProgressStatus < 100) {
	                    mProgressStatus = doWork();

	                    // Update the progress bar
	                    mHandler.post(new Runnable() {
	                        public void run() {
	                            progress.setProgress(mProgressStatus);
	                        }
	                    });
	                }
	                
	            }

	 		private int doWork() {
	 			// TODO Auto-generated method stub
	 			return webview.getProgress();
	 		}
	        }).start();
	        if(mProgressStatus ==100){
          	   progress.setVisibility(progress.GONE);
          	   progressState = true;
          	   
             }
	        while(progressState){
     			Toast.makeText(getBaseContext(), "Appuyer sur play maintenant", Toast.LENGTH_LONG).show();
     			progressState = false;
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
		if (id == R.id.action_credit) {
			startActivity(new Intent(MainActivity.this, Credit.class));
		}
		return super.onOptionsItemSelected(item);
	}
	
}