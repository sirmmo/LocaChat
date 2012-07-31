package it.mmo.locachat;

import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;

public class JSIface {
	Handler jsHandler;
	WebView wview;
	private static JSIface instance;

	private static boolean initialized = false;

	public static JSIface getInstance(){
		if (initialized)
			return instance;
		else 
			return null;
	}

	public static JSIface getInstance(Handler handler, WebView view) {
		if (instance == null) {
			instance = new JSIface(handler, view);
			initialized = true;
		}
		return instance;
	}

	private JSIface(Handler handler, WebView view) {
		jsHandler = handler;
		wview = view;
	}

	public void getPeople() {
		// send location via jabber
		// get people with positions and friend/guy status
		// show stuff on map
	}

	public void dirUser(String user) {
		// send ls to user
		// get data about thumbs and filenames
		// show data to user
	}

	public void addFriend(String user) {
		// send friend request
		// get response
	}



	public void setCenter(double longitude, double latitude) {
		final double lon = longitude;
		final double lat = latitude;
		jsHandler.postDelayed(new Runnable(){
			public void run(){
				Log.d("js", "setting location");
				wview.loadUrl("javascript:$.setCenter("+lon+", "+lat+");");
			}
		}, 7000);
		
	}


}
