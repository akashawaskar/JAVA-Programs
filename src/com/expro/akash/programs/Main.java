package com.expro.akash.programs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	public void java(View v)
	{
		Intent intent=new Intent(Main.this,MainActivity.class);
		startActivity(intent);
	}
	public void ref(View v)
	{
		Intent intent=new Intent(Main.this,Reference.class);
		startActivity(intent);
	}
}