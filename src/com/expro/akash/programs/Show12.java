package com.expro.akash.programs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class Show12 extends Activity  {

	 WebView webview;
	 static 	int j =1;
		int k1;
	
	
	public void onCreate(Bundle b0)
	{
		super.onCreate(b0);
		setContentView(R.layout.show);
		 webview = (WebView) findViewById(R.id.webView1);
		 
			webview.loadUrl("file:///android_asset/AWTList/01.html");
			
			Button arrow = (Button) findViewById(R.id.button2);
			Button arrow2 = (Button) findViewById(R.id.button1);
			
arrow.setOnClickListener(new OnClickListener() {
				
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(j == 1) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/AWTList/01.html");
			j = 2;
		}else if (j == 2) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/02.html");
			j = 3;
		}else if (j == 3) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/03.html");
			j = 4;
		}else if (j == 4) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/04.html");
			j = 5;
		}else if (j == 5) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/05.html");
			j = 6;
		}else if(j==6) {
			webview.loadUrl("file:///android_asset/AWTList/06.html");
			j = 7;
		}else if (j == 7) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/07.html");
			j = 8;
		}else if (j == 8) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/08.html");
			j = 9;
		}else if (j == 9) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/09.html");
			j = 10;
		}else if (j == 10) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/10.html");
			j = 11;
		}else if (j == 11) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/11.html");
			j = 12;
		}else if (j == 12) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/12.html");
			j = 13;
		}else if (j == 13) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/13.html");
			j = 14;
		}else if (j == 14) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/14.html");
			j = 15;
		}else if (j == 15) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/15.html");
			j = 16;
		}else if (j == 16) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/16.html");
			j = 17;
		}else if (j == 17) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/17.html");
			j = 18;
		}else if (j == 18) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/18.html");
			j = 19;
		}else if (j == 19) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/19.html");
			j = 20;
		}else if (j == 20) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/20.html");
			j = 21;
		}else if (j == 21) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/21.html");
			j = 1;
		}
		}
		});
	
		arrow2.setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
		// TODO Auto-generated method stub
		if (j == 21) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/21.html");
			j = 20;
		}else if (j == 20) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/20.html");
			j = 19;
		}else if (j == 19) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/19.html");
			j = 18;
		}else if (j == 18) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/18.html");
			j = 17;
		}else if (j == 17) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/17.html");
			j = 16;
		}else if (j == 16) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/16.html");
			j = 15;
		}else if (j == 15) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/15.html");
			j = 14;
		}else if (j == 14) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/14.html");
			j = 13;
		}else if (j == 13) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/13.html");
			j = 12;
		}else if (j == 12) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/12.html");
			j = 11;
		}else if (j == 11) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/11.html");
			j = 10;
		}else if (j == 10) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/10.html");
			j = 9;
		}else if (j == 9) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/09.html");
			j = 8;
		}else if (j == 8) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/08.html");
			j = 7;
		}else if (j == 7) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/07.html");
			j = 6;
		}else if (j == 6) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/06.html");
			j = 5;
		}else if (j == 5) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/05.html");
			j = 4;
		}else if (j == 4) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/04.html");
			j = 3;
		}else if (j == 3) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/03.html");
			j = 2;
		}else if (j == 2) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/02.html");
			j = 1;
		}else if (j == 1) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/AWTList/01.html");
			j = 21;
		}
		}
		});
}

		public void setArguments(Bundle data) {
		// TODO Auto-generated method stub		
}
}
