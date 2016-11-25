package com.expro.akash.programs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Reference extends Activity{
	   @Override
	    protected void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        setContentView(R.layout.ref);
	    }
}
