package it.mmo.locachat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
	
	private final Handler jsHAndler = new Handler();
	private LocationManager locmgr = null;
	private JSIface jsi;
	WebView wview;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		wview = (WebView) this.findViewById(R.id.webView2);
		WebSettings s = wview.getSettings();
		s.setJavaScriptEnabled(true);
//		s.setAllowContentAccess(true);
		s.setLoadsImagesAutomatically(true);
		s.setAllowFileAccess(true);
		locmgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locmgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,10,onLocationChange);
        location = locmgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        jsi = JSIface.getInstance(jsHAndler, wview);
		wview.addJavascriptInterface(jsi, "android");
		wview.loadUrl(getString(R.string.url_index_html));
		jsi.setCenter(location.getLongitude(), location.getLatitude());
		
	}
	
	Location location = null;

	LocationListener onLocationChange = new LocationListener() {
		public void onLocationChanged(Location loc) {
			location = loc;
			JSIface.getInstance().setCenter(location.getLongitude(), location.getLatitude());
		}

		public void onProviderDisabled(String provider) {
			// required for interface, not used
		}

		public void onProviderEnabled(String provider) {
			// required for interface, not used
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			// required for interface, not used
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
        locmgr.removeUpdates(onLocationChange);
	}
	
    @Override
    public void onResume() {
        super.onResume();
        locmgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,10000.0f,onLocationChange);
    }

	
}
