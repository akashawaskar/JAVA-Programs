package com.expro.akash.programs;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends Activity{
	 private static final long DELAY = 3000;
	    private boolean scheduled = false;
	    private Timer splashTimer;

	    @Override
	    protected void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        setContentView(R.layout.splach);

	        splashTimer = new Timer();
	        splashTimer.schedule(new TimerTask()
	        {
	            @Override
	            public void run()
	            {
	                SplashActivity.this.finish();
	                startActivity(new Intent(SplashActivity.this, Main.class));
	            }
	         }, DELAY);
	       scheduled = true;
	    }

	    @Override
	    protected void onDestroy()
	    {
	        super.onDestroy();
	        if (scheduled)
	            splashTimer.cancel();
	        splashTimer.purge();
	    }

}
