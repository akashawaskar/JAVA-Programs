package com.expro.akash.programs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class Show10 extends Activity
{
	WebView webview;

static 	int j =1;
	int k1;


public void onCreate(Bundle b0)
{
	super.onCreate(b0);
	setContentView(R.layout.show);
	 webview = (WebView) findViewById(R.id.webView1);
	 
		webview.loadUrl("file:///android_asset/AWTFont/01.html");
		
		Button arrow = (Button) findViewById(R.id.button2);
		Button arrow2 = (Button) findViewById(R.id.button1);
		
arrow.setOnClickListener(new OnClickListener() {
			
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(j == 1) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/AWTFont/01.html");
			j = 2;
		}else if (j == 2) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/02.html");
			j = 3;
		}else if (j == 3) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/03.html");
			j = 4;
		}else if (j == 4) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/04.html");
			j = 5;
		}else if (j == 5) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/05.html");
			j = 6;
		}else if(j==6) {
			webview.loadUrl("file:///android_asset/AWTFont/06.html");
			j = 1;
		}
		}
		});
	
		arrow2.setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
		// TODO Auto-generated method stub
		if (j == 6) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/06.html");
			j = 5;
		}else if (j == 5) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/05.html");
			j = 4;
		}else if (j == 4) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/04.html");
			j = 3;
		}else if (j == 3) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/03.html");
			j = 2;
		}else if (j == 2) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/02.html");
			j = 1;
		}else if (j == 1) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTFont/01.html");
			j = 6;
		}
		}
		});
}

		public void setArguments(Bundle data) {
		// TODO Auto-generated method stub		
}
}


