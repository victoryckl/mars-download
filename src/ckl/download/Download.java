package ckl.download;

import ckl.utils.HttpDownloader;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Download extends Activity {
	protected static final String TAG = "Download";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		init();
	}
	
	private void init() {
		HttpDownloader.initStrictMode();
		findViewById(R.id.downloadTxt).setOnClickListener(mClickListener);
		findViewById(R.id.downloadMp3).setOnClickListener(mClickListener);
	}
	
	private OnClickListener mClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			int id = v.getId();
			HttpDownloader httpDownloader = new HttpDownloader();
			switch (id) {
			case R.id.downloadTxt:
				String text = httpDownloader.download("http://192.168.1.100:8080/mp3/a1.lrc");
				Log.i(TAG, "text = " + text);
				break;
			case R.id.downloadMp3:
				int result = httpDownloader.downFile("http://192.168.1.100:8080/mp3/a1.mp3",
						"voa/", "a1.mp3");
				Log.i(TAG, "result = " + result);
				break;
			}
		}
	};

	
}
