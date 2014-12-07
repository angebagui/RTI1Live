package com.angbeny.rti1live;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;

public class DetecterConnectionInternet extends Service {
	private Context mContext;
	public DetecterConnectionInternet (Context context){
		this.mContext = context;
	}
	public boolean isConnection(){
		ConnectivityManager cM = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if(cM != null){
			NetworkInfo[] info = cM.getAllNetworkInfo();
			if(info !=null){
				for(int i=0; i <info.length; i++){
					if(info[i].getState() == NetworkInfo.State.CONNECTED){
						return true;
					}
				}
			}

		}
		return false;
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
