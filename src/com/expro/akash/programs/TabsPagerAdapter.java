
package com.expro.akash.programs;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	private int totalTabs;

	public TabsPagerAdapter(FragmentManager fm, int totalTabs) {
		super(fm);
		this.totalTabs = totalTabs;
	}

	
	/*
	 * fragment to tab class conection
	 * 
	 * */
	@Override
	public ListFragment getItem(int index) {
		Bundle data = new Bundle();
		/**ExampleFragment frag = new ExampleFragment();
		Bundle args = new Bundle();
		args.putInt("index", index);
		frag.setArguments(args);
		return frag*/
		
		switch (index ) {

		case 0:
		Applet a0 = new Applet();
		data.putInt("current_page", index+1);
		a0.setArguments(data);
		return a0;

		case 1:
		Array a1 = new Array();
		data.putInt("current_page", index+1);
		a1.setArguments(data);
		return a1;

		case 2:
		ArrayList a2 = new ArrayList();
		data.putInt("current_page", index+1);
		a2.setArguments(data);
		return a2;

		case 3:
		AWT a3 = new AWT();
		data.putInt("current_page", index+1);
		a3.setArguments(data);
		return a3;

		case 4:
		AWTButton a4 = new AWTButton();
		data.putInt("current_page", index+1);
		a4.setArguments(data);
		return a4;

		case 5:
		AWTCheckBox a5 =new AWTCheckBox();
		data.putInt("current_page", index+1);
		a5.setArguments(data);
		return a5;

		case 6:
		AWTCheckBoxGroup a6 = new AWTCheckBoxGroup();
		data.putInt("current_page", index+1);
		a6.setArguments(data);
		return a6;

		case 7:
		AWTChoice a7 = new AWTChoice();
		data.putInt("current_page", index+1);
		a7.setArguments(data);
		return a7;
		
		case 8:
		AWTColor a8 = new AWTColor();
		data.putInt("current_page", index+1);
		a8.setArguments(data);
		return a8;

		case 9:
		AWTFont a9 = new AWTFont();
		data.putInt("current_page", index+1);
		a9.setArguments(data);
		return a9;

		case 10:
		AWTLabel a10 = new AWTLabel();
		data.putInt("current_page", index+1);
		a10.setArguments(data);
		return a10;

		case 11:
		AWTList a11 =new AWTList();
		data.putInt("current_page", index+1);
		a11.setArguments(data);
		return a11;

		case 12:
		Constructor a12 = new Constructor();
		data.putInt("current_page", index+1);
		a12.setArguments(data);
		return a12;

		case 13:
		DataTypes a13 = new DataTypes();
		data.putInt("current_page", index+1);
		a13.setArguments(data);
		return a13;

		case 14:
		Date a14 = new Date();
		data.putInt("current_page", index+1);
		a14.setArguments(data);
		return a14;

		case 15:
		EventHandaling a15 = new EventHandaling ();
		data.putInt("current_page", index+1);
		a15.setArguments(data);
		return a15;

		case 16:
		ExceptionHandaling a16 =new ExceptionHandaling();
		data.putInt("current_page", index+1);
		a16.setArguments(data);
		return a16;

		case 17:
		FileIO a17 = new FileIO();
		data.putInt("current_page", index+1);
		a17.setArguments(data);
		return a17;

		case 18:
		Formulae a18 = new Formulae();
		data.putInt("current_page", index+1);
		a18.setArguments(data);
		return a18;

		case 19:
		Fundamentals a19 = new Fundamentals();
		data.putInt("current_page", index+1);
		a19.setArguments(data);
		return a19;

		case 20:
		IFElse a20 = new IFElse();
		data.putInt("current_page", index+1);
		a20.setArguments(data);
		return a20;

		case 21:
		Interface a21 = new Interface();
		data.putInt("current_page", index+1);
		a21.setArguments(data);
		return a21;

		case 22:
		Loop a22 =new Loop();
		data.putInt("current_page", index+1);
		a22.setArguments(data);
		return a22;
		
		case 23:
		Math a23 =new Math();
		data.putInt("current_page", index+1);
		a23.setArguments(data);
		return a23;

		case 24:
		Operators a24 = new Operators();
		data.putInt("current_page", index+1);
		a24.setArguments(data);
		return a24;

		case 25:
		Pattern a25 = new Pattern();
		data.putInt("current_page", index+1);
		a25.setArguments(data);
		return a25;

		case 26:
		Runtime a26 = new Runtime();
		data.putInt("current_page", index+1);
		a26.setArguments(data);
		return a26;

		case 27:
		Search a27 = new Search();
		data.putInt("current_page", index+1);
		a27.setArguments(data);
		return a27;

		case 28:
		Sort a28 =new Sort();
		data.putInt("current_page", index+1);
		a28.setArguments(data);
		return a28;

		case 29:
		String1 a29 = new String1();
		data.putInt("current_page", index+1);
		a29.setArguments(data);
		return a29;

		case 30:
		StringBuffer a30 = new StringBuffer();
		data.putInt("current_page", index+1);
		a30.setArguments(data);
		return a30;

		case 31:
		StringTokenizer a31 = new StringTokenizer();
		data.putInt("current_page", index+1);
		a31.setArguments(data);
		return a31;

		case 32:
		SWING a32 = new SWING();
		data.putInt("current_page", index+1);
		a32.setArguments(data);
		return a32;

		case 33:
		SwingJLabel a33 = new SwingJLabel();
		data.putInt("current_page", index+1);
		a33.setArguments(data);
		return a33;

		case 34:
		SwingJTextField a34 =new SwingJTextField();
		data.putInt("current_page", index+1);
		a34.setArguments(data);
		return a34;

		case 35:
		Switch a35 = new  Switch();
		data.putInt("current_page", index+1);
		a35.setArguments(data);
		return a35;

		case 36:
		System a36 = new System();
		data.putInt("current_page", index+1);
		a36.setArguments(data);
		return a36;

		case 37:
		Thread a37 = new Thread();
		data.putInt("current_page", index+1);
		a37.setArguments(data);
		return a37;

		case 38:
		Vector a38 = new Vector();
		data.putInt("current_page", index+1);
		a38.setArguments(data);
		return a38;

		case 39:
		WrapperClass a39 = new WrapperClass();
		data.putInt("current_page", index+1);
		a39.setArguments(data);
		return a39;
		}
	return null;
	}
	@Override
	public int getCount() {
	return totalTabs;
	}
}