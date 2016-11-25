package com.expro.akash.programs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class Show40 extends Activity  {

	
	WebView webview;
	 static 	int j =1;
		int k1;
	

	public void onCreate(Bundle b0)
	{
		super.onCreate(b0);
		setContentView(R.layout.show);
		 webview = (WebView) findViewById(R.id.webView1);
		 
			webview.loadUrl("file:///android_asset/WrapperClass/01.html");
			
			Button arrow = (Button) findViewById(R.id.button2);
			Button arrow2 = (Button) findViewById(R.id.button1);
			
arrow.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(j == 1) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/01.html");
			j = 2;
		}else if (j == 2) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/02.html");
			j = 3;
		}else if (j == 3) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/03.html");
			j = 4;
		}else if (j == 4) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/04.html");
			j = 5;
		}else if (j == 5) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/05.html");
			j = 6;
		}else if(j==6) {
			webview.loadUrl("file:///android_asset/WrapperClass/06.html");
			j = 7;
		}else if (j == 7) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/07.html");
			j = 8;
		}else if (j == 8) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/08.html");
			j = 9;
		}else if (j == 9) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/09.html");
			j = 10;
		}else if (j == 10) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/10.html");
			j = 11;
		}else if (j == 11) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/11.html");
			j = 12;
		}else if (j == 12) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/12.html");
			j = 13;
		}else if (j == 13) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/13.html");
			j = 14;
		}else if (j == 14) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/14.html");
			j = 15;
		}else if (j == 15) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/15.html");
			j = 16;
		}else if (j == 16) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/16.html");
			j = 17;
		}else if (j == 17) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/17.html");
			j = 18;
		}else if (j == 18) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/18.html");
			j = 19;
		}else if (j == 19) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/19.html");
			j = 20;
		}else if (j == 20) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/20.html");
			j = 21;
		}else if (j == 21) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/21.html");
			j = 22;
		}else if (j == 22) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/22.html");
			j = 23;
		}else if (j == 23) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/23.html");
			j = 24;
		}else if (j == 24) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/24.html");
			j = 25;
		}else if (j == 25) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/25.html");
			j = 26;
		}else if (j == 26) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/26.html");
			j = 27;
		}else if (j == 27) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/27.html");
			j = 28;
		}else if (j == 28) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/28.html");
			j = 29;
		}else if (j == 29) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/29.html");
			j = 30;
		}else if (j == 30) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/30.html");
			j = 31;
		}else if (j == 31) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/31.html");
			j = 32;
		}else if (j == 32) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/32.html");
			j = 33;
		}else if (j == 33) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/33.html");
			j = 34;
		}else if (j == 34) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/34.html");
			j = 35;
		}else if (j == 35) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/35.html");
			j = 36;
		}else if (j == 36) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/36.html");
			j = 1;
		}
		}
		});
	
		arrow2.setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
		// TODO Auto-generated method stub
		if (j == 36) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/36.html");
			j = 35;
		}else if (j == 35) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/35.html");
			j = 34;
		}else if (j == 34) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/34.html");
			j = 33;
		}else if (j == 33) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/33.html");
			j = 32;
		}else if (j == 32) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/32.html");
			j = 31;
		}else if (j == 31) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/31.html");
			j = 30;
		}else if (j == 30) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/30.html");
			j = 29;
		}else if (j == 29) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/29.html");
			j = 28;
		}else if (j == 28) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/28.html");
			j = 27;
		}else if (j == 27) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/27.html");
			j = 26;
		}else if (j == 26) {
			//tx.setText(R.string.arr);
			webview.loadUrl("file:///android_asset/WrapperClass/26.html");
			j = 25;
		}else if (j == 25) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/25.html");
			j = 24;
		}else if (j == 24) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/24.html");
			j = 23 ;
		}else if (j == 23) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/23.html");
			j = 22;
		}else if (j == 22) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/22.html");
			j = 21;
		}else if (j == 21) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/21.html");
			j = 20;
		}else if (j == 20) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/20.html");
			j = 19;
		}else if (j == 19) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/19.html");
			j = 18;
		}else if (j == 18) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/18.html");
			j = 17;
		}else if (j == 17) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/17.html");
			j = 16;
		}else if (j == 16) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/16.html");
			j = 15;
		}else if (j == 15) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/15.html");
			j = 14;
		}else if (j == 14) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/14.html");
			j = 13;
		}else if (j == 13) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/13.html");
			j = 12;
		}else if (j == 12) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/12.html");
			j = 11;
		}else if (j == 11) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/11.html");
			j = 10;
		}else if (j == 10) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/10.html");
			j = 9;
		}else if (j == 9) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/09.html");
			j = 8;
		}else if (j == 8) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/08.html");
			j = 7;
		}else if (j == 7) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/07.html");
			j = 6;
		}else if (j == 6) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/06.html");
			j = 5;
		}else if (j == 5) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/05.html");
			j = 4;
		}else if (j == 4) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/04.html");
			j = 3;
		}else if (j == 3) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/03.html");
			j = 2;
		}else if (j == 2) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/02.html");
			j = 1;
		}else if (j == 1) {
			//tx.setText(R.string.arr1);
			webview.loadUrl("file:///android_asset/WrapperClass/01.html");
			j = 36;
		}
		}
		});
}

		public void setArguments(Bundle data) {
		// TODO Auto-generated method stub		
}
}

