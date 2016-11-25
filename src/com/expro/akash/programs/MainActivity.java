
package com.expro.akash.programs;

import java.util.HashMap;
import java.util.LinkedHashMap;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;

public class MainActivity extends FragmentActivity implements
		TabContentFactory, TabHost.OnTabChangeListener,
		ViewPager.OnPageChangeListener, OnItemClickListener {

	public static final String TAG = "DrawerTab";

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerListView;
	private ActionBarDrawerToggle mDrawerToggle;
	private ViewPager mViewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar mActionBar;
	private TabHost mTabHost;

	private HorizontalScrollView mHorizontalTabScrollView;

	private HashMap<String, Tab> mTabMap;

	private int mScrollToX;

	private ListAdapter mArrayNavigationDrawerAdapter;

	public static class Tab {
		int index;
		String title;

		Tab(int index, String title) {
			this.index = index;
			this.title = title;
		}

		@Override
		public String toString() {
			return title;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		createStubTab();

		mActionBar = getActionBar();

		mHorizontalTabScrollView = (HorizontalScrollView) findViewById(R.id.hscroll_tab_host);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerListView = (ListView) findViewById(R.id.left_drawer);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		mActionBar.setHomeButtonEnabled(true);
		mActionBar.setDisplayHomeAsUpEnabled(true);

		mDrawerToggle = createDrawerToggleListener();

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();

		for (String tag : mTabMap.keySet()) {
			Tab tab = mTabMap.get(tag);
			TabHost.TabSpec spec = mTabHost.newTabSpec(tag);
			spec.setContent(this);
			spec.setIndicator(tab.title);
			mTabHost.addTab(spec);
		}

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager(),
				mTabMap.size());
		mViewPager.setAdapter(mAdapter);

		mTabHost.setOnTabChangedListener(this);
		mViewPager.setOnPageChangeListener(this);

		mHorizontalTabScrollView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_UP:
					v.performClick();
					break;
				}
				return true;
			}
		});

		mArrayNavigationDrawerAdapter = new ArrayAdapter<Tab>(this,
				android.R.layout.simple_list_item_1, mTabMap.values().toArray(
						new Tab[0]));
		mDrawerListView.setAdapter(mArrayNavigationDrawerAdapter);
		mDrawerListView.setOnItemClickListener(this);
	}
/*
 * 
 * tab activity to the navigation drawer class conection
 * */
	private void createStubTab() {
		mTabMap = new LinkedHashMap<String, Tab>();
		//mTabMap.put("0", new Tab(0, "All"));
		mTabMap.put("0", new Tab(0, "Applet"));
		mTabMap.put("1", new Tab(1, "Array"));
		mTabMap.put("2", new Tab(2, "Array List"));
		mTabMap.put("3", new Tab(3, "AWT"));
		mTabMap.put("4", new Tab(4, "AWT Button"));
		mTabMap.put("5", new Tab(5, "AWT CheackBox"));
		mTabMap.put("6", new Tab(6, "AWT CheckBoxGorup"));
		mTabMap.put("7", new Tab(7, "AWT Choice"));
		mTabMap.put("8", new Tab(8, "AWT Color"));
		mTabMap.put("9", new Tab(9, "AWT Font"));
		mTabMap.put("10", new Tab(10, "AWT Label"));
		mTabMap.put("11", new Tab(11, "AWT List"));
		mTabMap.put("12", new Tab(12, "Constructor"));
		mTabMap.put("13", new Tab(13, "Data Types"));
		mTabMap.put("14", new Tab(14, "Date"));
		mTabMap.put("15", new Tab(15, "Event Handaling"));
		mTabMap.put("16", new Tab(16, "Exception Handaling"));
		mTabMap.put("17", new Tab(17, "File IO"));
		mTabMap.put("18", new Tab(18, "Formulae"));
		mTabMap.put("19", new Tab(19, "Fundamentals"));
		mTabMap.put("20", new Tab(20, "IF Else"));
		mTabMap.put("21", new Tab(21, "Interface"));
		mTabMap.put("22", new Tab(22, "Loop"));
		mTabMap.put("23", new Tab(23, "Math"));
		mTabMap.put("24", new Tab(24, "Operators"));
		mTabMap.put("25", new Tab(25, "Pattern"));
		mTabMap.put("26", new Tab(26, "Runtime"));
		mTabMap.put("27", new Tab(27, "Search"));
		mTabMap.put("28", new Tab(28, "Sort"));
		mTabMap.put("29", new Tab(29, "String"));
		mTabMap.put("30", new Tab(30, "StringBuffer"));
		mTabMap.put("31", new Tab(31, "String Tokenizer"));
		mTabMap.put("32", new Tab(32, "SWING"));
		mTabMap.put("33", new Tab(33, "Swing JLabel"));
		mTabMap.put("34", new Tab(34, "Swing JTextField"));
		mTabMap.put("35", new Tab(35, "Switch"));
		mTabMap.put("36", new Tab(36, "System"));
		mTabMap.put("37", new Tab(37, "Thread"));
		mTabMap.put("38", new Tab(38, "Vector"));
		mTabMap.put("39", new Tab(39, "WrapperClass"));
	}

		private ActionBarDrawerToggle createDrawerToggleListener() {
		return new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				mActionBar.setTitle(getString(R.string.app_name));
				super.onDrawerClosed(view);
			}

			public void onDrawerOpened(View drawerView) {
				// Set the title on the action when drawer open
				mActionBar.setTitle("All");
				super.onDrawerOpened(drawerView);
			}
		};
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			if (mDrawerLayout.isDrawerOpen(mDrawerListView)) {
				mDrawerLayout.closeDrawer(mDrawerListView);
			} else {
				mDrawerLayout.openDrawer(mDrawerListView);
			}
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public View createTabContent(String tag) {
		// Stub empty View
		return new View(this);
	}

	@Override
	public void onTabChanged(String tabId) {
		Tab tab = mTabMap.get(tabId);
		selectTab(tab);
	}

	@Override
	public void onPageSelected(int position) {
		mTabHost.setCurrentTab(position);
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@TargetApi(13)
	private void centerTabHorizontalScroll() {
		final View currentTabView = mTabHost.getCurrentTabView();
		// int currentTabIndex = mTabHost.getCurrentTab();
		int widthX = getDisplayPxWidth();

		if ((currentTabView.getLeft() + currentTabView.getWidth()) > widthX) {
			mScrollToX = currentTabView.getLeft();

		} else if (currentTabView.getLeft() < (currentTabView.getWidth() + 10)) {
			// maybe margin
			mScrollToX = 0;
		}
		if (mHorizontalTabScrollView != null) {
			mHorizontalTabScrollView.postDelayed(new Runnable() {
				@Override
				public void run() {
					if (mHorizontalTabScrollView != null) {
						mHorizontalTabScrollView.scrollTo(mScrollToX, 0);
					}
				}
			}, 100);
		}

	}

	@TargetApi(13)
	@SuppressWarnings("deprecation")
	private int getDisplayPxWidth() {
		Display display = getWindowManager().getDefaultDisplay();
		if (android.os.Build.VERSION.SDK_INT >= 13) {
			Point size = new Point();
			display.getSize(size);
			return size.x;
		} else {
			return display.getWidth();
		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Tab tab = (Tab) mArrayNavigationDrawerAdapter.getItem(position);
		selectTab(tab);
		
	}

	private void selectTab(Tab tab) {
		mViewPager.setCurrentItem(tab.index);
		if (mDrawerLayout.isDrawerOpen(mDrawerListView)) {
			mDrawerLayout.closeDrawer(mDrawerListView);
		}

		centerTabHorizontalScroll();
	}

}


/*
 *
 * 
 * List fragment class start
 * 
 * 
 * 
 * */

class Applet extends ListFragment {
	Activity activity=getActivity();
	public static final String ARG_PLANET_NUMBER = "planet_number";
	String myfriends_list[] = new String[]{
            "Applet",
            "Applet Life Cycle",
            "Draw All",
            "Draw Arc",
            "Draw Line",
            "Draw Oval & Circle",
            "Draw Polygon",
            "Draw Rectangle & Square",
            "Fill Arc",
            "Fill Oval & Circle",
            "Fill Polygon",
            "Fill Rectangle Square",
            "Draw Rounded Corner Rectangle Square",
            "Draw Smiley",
            "Draw String",
            "Draw Dots Random Locations",            
            "Draw HappyFace",
            "Get Applet Document URL",
            "Get Applet Information",
            "Get Background Color",
            "Get Foreground Color",
            "Resize Applet Window",
            "Number Counter",
            "Set Background Color",
            "Set Foreground Color",
            "Set Status Message",
            "3D Rectangle Square",
   
    		};
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);
        int i = getArguments().getInt(ARG_PLANET_NUMBER);
      //  String planet = getResources().getStringArray(R.array.planets_array)[i];
        
        return super.onCreateView(inflater, container, savedInstanceState);
        
    }
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show01.j=1;
	Intent intent0=new Intent(v.getContext(),Show01.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show01.j=2;
	Intent intent1=new Intent(v.getContext(),Show01.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show01.j=3;
	Intent intent2=new Intent(v.getContext(),Show01.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show01.j=4;
	Intent intent3=new Intent(v.getContext(),Show01.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show01.j=5;
	Intent intent4=new Intent(v.getContext(),Show01.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show01.j=6;
	Intent intent5=new Intent(v.getContext(),Show01.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show01.j=7;
	Intent intent6=new Intent(v.getContext(),Show01.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show01.j=8;
	Intent intent7=new Intent(v.getContext(),Show01.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show01.j=9;
	Intent intent8=new Intent(v.getContext(),Show01.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show01.j=10;
	Intent intent9=new Intent(v.getContext(),Show01.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show01.j=11;
	Intent intent10=new Intent(v.getContext(),Show01.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show01.j=12;
	Intent intent11=new Intent(v.getContext(),Show01.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show01.j=13;
	Intent intent12=new Intent(v.getContext(),Show01.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show01.j=14;
	Intent intent13=new Intent(v.getContext(),Show01.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show01.j=15;
	Intent intent14=new Intent(v.getContext(),Show01.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show01.j=16;
	Intent intent15=new Intent(v.getContext(),Show01.class);
	intent15.putExtra("He",data);
	startActivity(intent15);       
	break;
	
	case 16:
	Show01.j=17;
	Intent intent16=new Intent(v.getContext(),Show01.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show01.j=18;
	Intent intent17=new Intent(v.getContext(),Show01.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;
	
	case 18:
	Show01.j=19;
	Intent intent18=new Intent(v.getContext(),Show01.class);
	intent18.putExtra("He",data);
	startActivity(intent18);
    break;
	
	case 19:
	Show01.j=20;
	Intent intent19=new Intent(v.getContext(),Show01.class);
	intent19.putExtra("He",data);
	startActivity(intent19);
    break;
	
	case 20:
	Show01.j=21;
	Intent intent20=new Intent(v.getContext(),Show01.class);
	intent20.putExtra("He",data);
	startActivity(intent20);
    break;
	
	case 21:
	Show01.j=22;
	Intent intent21=new Intent(v.getContext(),Show01.class);
	intent21.putExtra("He",data);
	startActivity(intent21);
    break;
	
	case 22:
	Show01.j=23;
	Intent intent22=new Intent(v.getContext(),Show01.class);
	intent22.putExtra("He",data);
	startActivity(intent22);
    break;
	
	case 23:
	Show01.j=24;
	Intent intent23=new Intent(v.getContext(),Show01.class);
	intent23.putExtra("He",data);
	startActivity(intent23);
    break;
	
	case 24:
	Show01.j=25;
	Intent intent24=new Intent(v.getContext(),Show01.class);
	intent24.putExtra("He",data);
	startActivity(intent24);
    break;
	
	case 25:
	Show01.j=26;
	Intent intent25=new Intent(v.getContext(),Show01.class);
	intent25.putExtra("He",data);
	startActivity(intent25);
    break;
	
	case 26:
	Show01.j=27;
	Intent intent26=new Intent(v.getContext(),Show01.class);
	intent26.putExtra("He",data);
	startActivity(intent26);
    break;
    
	case 27:
	Show01.j=28;
	Intent intent27=new Intent(v.getContext(),Show01.class);
	intent27.putExtra("He",data);
	startActivity(intent27);
	break;

		}
	}
		
}

class Array extends ListFragment {
	Activity activity=getActivity();
	public static final String ARG_PLANET_NUMBER = "planet_number";
	String myfriends_list[] = new String[]{
            "Array 1D",
            "Array 2D",
            "Array 1D To 2D",
            "Array",
            "Compare Two Java Boolean Arrays",
            "Compare Two Java Byte Arrays",
            "Compare Two Java Char Arrays",
            "Compare Two Java Float Arrays",
            "Compare Two Java Int Arrays",
            "Compare Two Java Long Arrays",
            "Compare Two Java Short Arrays",
            "Create List From Java Object Array",
            "Largest And Smallest Number In Array"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);
        int i = getArguments().getInt(ARG_PLANET_NUMBER);
      //  String planet = getResources().getStringArray(R.array.planets_array)[i];
        
        return super.onCreateView(inflater, container, savedInstanceState);
        

    }
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show02.j=1;
	Intent intent0=new Intent(v.getContext(),Show02.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show02.j=2;
	Intent intent1=new Intent(v.getContext(),Show02.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show02.j=3;
	Intent intent2=new Intent(v.getContext(),Show02.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show02.j=4;
	Intent intent3=new Intent(v.getContext(),Show02.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show02.j=5;
	Intent intent4=new Intent(v.getContext(),Show02.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show02.j=6;
	Intent intent5=new Intent(v.getContext(),Show02.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show02.j=7;
	Intent intent6=new Intent(v.getContext(),Show02.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show02.j=8;
	Intent intent7=new Intent(v.getContext(),Show02.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show02.j=9;
	Intent intent8=new Intent(v.getContext(),Show02.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show02.j=10;
	Intent intent9=new Intent(v.getContext(),Show02.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show02.j=11;
	Intent intent10=new Intent(v.getContext(),Show02.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show02.j=12;
	Intent intent11=new Intent(v.getContext(),Show02.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show02.j=13;
	Intent intent12=new Intent(v.getContext(),Show02.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show02.j=14;
	Intent intent13=new Intent(v.getContext(),Show02.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;

		 }
	}

}

class ArrayList extends ListFragment{

	String myfriends_list[] = new String[]{
            "Add Element To Specified Index",
            "Append All Elements Of Other Collection To ArrayList",
            "ArrayList",
            "Copy All Elements Of ArrayList To Object Array",
            "Get Size Of ArrayList And Loop Through Elements",
            "Get Sub List Of ArrayList",
            "Insert All Elements Of Other Collection To Specified Index ArrayList",
            "Iterate Through Elements ArrayList Using Iterator",
            "Iterate Through Elements ArrayList Using ListIterator",
            "Remove All Elements From ArrayList",
            "Remove Element From Specified Index Of ArrayList",
            "Replace Element At Specified Index ArrayList",
            "Search Element ArrayList",
            "Search Element ArrayList",
            "Sort Elements ArrayList"        
	};
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show03.j=1;
	Intent intent0=new Intent(v.getContext(),Show03.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show03.j=2;
	Intent intent1=new Intent(v.getContext(),Show03.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show03.j=3;
	Intent intent2=new Intent(v.getContext(),Show03.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show03.j=4;
	Intent intent3=new Intent(v.getContext(),Show03.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show03.j=5;
	Intent intent4=new Intent(v.getContext(),Show03.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show03.j=6;
	Intent intent5=new Intent(v.getContext(),Show03.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show03.j=7;
	Intent intent6=new Intent(v.getContext(),Show03.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show03.j=8;
	Intent intent7=new Intent(v.getContext(),Show03.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show03.j=9;
	Intent intent8=new Intent(v.getContext(),Show03.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show03.j=10;
	Intent intent9=new Intent(v.getContext(),Show03.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show03.j=11;
	Intent intent10=new Intent(v.getContext(),Show03.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show03.j=12;
	Intent intent11=new Intent(v.getContext(),Show03.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show03.j=13;
	Intent intent12=new Intent(v.getContext(),Show03.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show03.j=14;
	Intent intent13=new Intent(v.getContext(),Show03.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show03.j=15;
	Intent intent14=new Intent(v.getContext(),Show03.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;

	
		}
	}
 
}
class AWT extends ListFragment{

	String myfriends_list[] = new String[]{
            "Button ",
            "CheckBox ",
            "CheckBoxGroup",
            "List",
            "Choice",
            "Label ",
            "ScrollBar",
            "TextArea",
            "TextField",
            "Dialog",
            "FileDialog",
            "MenuBar ",
            "MenuBar 2",
            "Set Status Message",
            "Flow Layout",
            "Border Layout",
            "Grid Layout",
            "Card Layout",
            "Create Frame Window"
    
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show04.j=1;
	Intent intent0=new Intent(v.getContext(),Show04.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show04.j=2;
	Intent intent1=new Intent(v.getContext(),Show04.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show04.j=3;
	Intent intent2=new Intent(v.getContext(),Show04.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show04.j=4;
	Intent intent3=new Intent(v.getContext(),Show04.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show04.j=5;
	Intent intent4=new Intent(v.getContext(),Show04.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show04.j=6;
	Intent intent5=new Intent(v.getContext(),Show04.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show04.j=7;
	Intent intent6=new Intent(v.getContext(),Show04.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show04.j=8;
	Intent intent7=new Intent(v.getContext(),Show04.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show04.j=9;
	Intent intent8=new Intent(v.getContext(),Show04.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show04.j=10;
	Intent intent9=new Intent(v.getContext(),Show04.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show04.j=11;
	Intent intent10=new Intent(v.getContext(),Show04.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show04.j=12;
	Intent intent11=new Intent(v.getContext(),Show04.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show04.j=13;
	Intent intent12=new Intent(v.getContext(),Show04.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show04.j=14;
	Intent intent13=new Intent(v.getContext(),Show04.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show04.j=15;
	Intent intent14=new Intent(v.getContext(),Show04.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show04.j=16;
	Intent intent15=new Intent(v.getContext(),Show04.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
             
	break;
	
	case 16:
	Show04.j=17;
	Intent intent16=new Intent(v.getContext(),Show04.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show04.j=18;
	Intent intent17=new Intent(v.getContext(),Show04.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;
	
	case 18:
	Show04.j=19;
	Intent intent18=new Intent(v.getContext(),Show04.class);
	intent18.putExtra("He",data);
	startActivity(intent18);
    break;
	
	case 19:
	Show04.j=20;
	Intent intent19=new Intent(v.getContext(),Show04.class);
	intent19.putExtra("He",data);
	startActivity(intent19);
    break;
		}
	}
 
}


class AWTButton extends ListFragment{

	String myfriends_list[] = new String[]{
            "Create Button",
            "Remove Button",
            "Change Button Background Color",
            "Change Button Foreground Color",
            "Change Button Font",
            "Determine If Button Is Enabled",
            "Determine If Button Is Visible",
            "Disable Button",
            "Hide Button",
            "Set Action Command For Button"
 
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show05.j=1;
	Intent intent0=new Intent(v.getContext(),Show05.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show05.j=2;
	Intent intent1=new Intent(v.getContext(),Show05.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show05.j=3;
	Intent intent2=new Intent(v.getContext(),Show05.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show05.j=4;
	Intent intent3=new Intent(v.getContext(),Show05.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show05.j=5;
	Intent intent4=new Intent(v.getContext(),Show05.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show05.j=6;
	Intent intent5=new Intent(v.getContext(),Show05.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show05.j=7;
	Intent intent6=new Intent(v.getContext(),Show05.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show05.j=8;
	Intent intent7=new Intent(v.getContext(),Show05.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show05.j=9;
	Intent intent8=new Intent(v.getContext(),Show05.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show05.j=10;
	Intent intent9=new Intent(v.getContext(),Show05.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show05.j=11;
	Intent intent10=new Intent(v.getContext(),Show05.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;	
		}
	}
 
}

class AWTCheckBox extends ListFragment{

	String myfriends_list[] = new String[]{
            "Create Checkbox",
            "Remove Checkbox",
            "Change Checkbox Background Color",
            "Change Checkbox Foreground Color",
            "Change Checkbox Font",
            "Determine If Checkbox Is Enabled",
            "Determine If Checkbox Is Visible",
            "Disable Checkbox",
            "Hide Checkbox",
            "Create Checked Checkbox",
            "Get Checkbox State",
            "Handle Checkbox Event"
			};
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
switch (position) {
	
	case 0:
	Show06.j=1;
	Intent intent0=new Intent(v.getContext(),Show06.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show06.j=2;
	Intent intent1=new Intent(v.getContext(),Show06.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show06.j=3;
	Intent intent2=new Intent(v.getContext(),Show06.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show06.j=4;
	Intent intent3=new Intent(v.getContext(),Show06.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show06.j=5;
	Intent intent4=new Intent(v.getContext(),Show06.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show06.j=6;
	Intent intent5=new Intent(v.getContext(),Show06.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show06.j=7;
	Intent intent6=new Intent(v.getContext(),Show06.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show06.j=8;
	Intent intent7=new Intent(v.getContext(),Show06.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show06.j=9;
	Intent intent8=new Intent(v.getContext(),Show06.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show06.j=10;
	Intent intent9=new Intent(v.getContext(),Show06.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show06.j=11;
	Intent intent10=new Intent(v.getContext(),Show06.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show06.j=12;
	Intent intent11=new Intent(v.getContext(),Show06.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show06.j=13;
	Intent intent12=new Intent(v.getContext(),Show06.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
		}
	}
 
}

class AWTCheckBoxGroup extends ListFragment{

	String myfriends_list[] = new String[]{
            "Create RadioButtons Using CheckboxGroup",
            "Set Selected RadioButton",
            "Get Selected RadioButton"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

	switch (position) {
	
	case 0:
	Show07.j=1;
	Intent intent0=new Intent(v.getContext(),Show07.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show07.j=2;
	Intent intent1=new Intent(v.getContext(),Show07.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show07.j=3;
	Intent intent2=new Intent(v.getContext(),Show07.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show07.j=4;
	Intent intent3=new Intent(v.getContext(),Show07.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
		}
	}
 
}

class AWTChoice extends ListFragment{

	String myfriends_list[] = new String[]{
            "Create Choice",
            "Remove Particular Item From Choice",
            "Remove All Items From Choice",
            "Insert Item At Specified Index In Choice",
            "Select Particular Item Of Choice",
            "Count Number Of Items Of Choice",
            "Get Particular Item Of Choice",
            "Get Selected Item Of Choice",
            "Disable Choice"
	};
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show08.j=1;
	Intent intent0=new Intent(v.getContext(),Show08.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show08.j=2;
	Intent intent1=new Intent(v.getContext(),Show08.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show08.j=3;
	Intent intent2=new Intent(v.getContext(),Show08.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show08.j=4;
	Intent intent3=new Intent(v.getContext(),Show08.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show08.j=5;
	Intent intent4=new Intent(v.getContext(),Show08.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show08.j=6;
	Intent intent5=new Intent(v.getContext(),Show08.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show08.j=7;
	Intent intent6=new Intent(v.getContext(),Show08.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show08.j=8;
	Intent intent7=new Intent(v.getContext(),Show08.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show08.j=9;
	Intent intent8=new Intent(v.getContext(),Show08.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show08.j=10;
	Intent intent9=new Intent(v.getContext(),Show08.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
		}
	}
 
}

class AWTColor extends ListFragment{

	String myfriends_list[] = new String[]{
            "Color",
            "Applet In Different Colors",
            "Create Custom Color Using HSB",
            "Create Custom Color Using RGB",
            "Convert HSB To RGB Color",
            "Convert RGB To HSB Color",
            "Get Brighter Version Of Current Color",
            "Get Darker Version Of Current Color",
            "Get RGB Components From Color",
            "Set Drawing Mode To XOR",
            "Get Alpha Component Of Color",
            "Get Transparency Mode Of Color",
            "Set Graphics Color"
            
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show09.j=1;
	Intent intent0=new Intent(v.getContext(),Show09.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show09.j=2;
	Intent intent1=new Intent(v.getContext(),Show09.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show09.j=3;
	Intent intent2=new Intent(v.getContext(),Show09.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show09.j=4;
	Intent intent3=new Intent(v.getContext(),Show09.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show09.j=5;
	Intent intent4=new Intent(v.getContext(),Show09.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show09.j=6;
	Intent intent5=new Intent(v.getContext(),Show09.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show09.j=7;
	Intent intent6=new Intent(v.getContext(),Show09.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show09.j=8;
	Intent intent7=new Intent(v.getContext(),Show09.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show09.j=9;
	Intent intent8=new Intent(v.getContext(),Show09.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show09.j=10;
	Intent intent9=new Intent(v.getContext(),Show09.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show09.j=11;
	Intent intent10=new Intent(v.getContext(),Show09.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show09.j=12;
	Intent intent11=new Intent(v.getContext(),Show09.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show09.j=13;
	Intent intent12=new Intent(v.getContext(),Show09.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show09.j=14;
	Intent intent13=new Intent(v.getContext(),Show09.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;

	
		}
	}
 
}

class AWTFont extends ListFragment{

	String myfriends_list[] = new String[]{
            "Font",
            "Create Bold Font",
            "Create Italic Font",
            "Create Bold & Italic Font",
            "Get Font Information",
            "Get Available Font Family Names"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show10.j=1;
	Intent intent0=new Intent(v.getContext(),Show10.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show10.j=2;
	Intent intent1=new Intent(v.getContext(),Show10.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show10.j=3;
	Intent intent2=new Intent(v.getContext(),Show10.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show10.j=4;
	Intent intent3=new Intent(v.getContext(),Show10.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show10.j=5;
	Intent intent4=new Intent(v.getContext(),Show10.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show10.j=6;
	Intent intent5=new Intent(v.getContext(),Show10.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show10.j=7;
	Intent intent6=new Intent(v.getContext(),Show10.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;

	
		}
	}
 
}

class AWTLabel extends ListFragment{

	String myfriends_list[] = new String[]{
            "Create Label",
            "Create Label With Text Alignment",
            "Change Text Font Of Label",
            "Change Background Color Of Label",
            "Change Foreground Color Of Label",
            "Determine If Label Is Enabled",
            "Determine If Label Is Visible",
            "Disable Label",
            "Hide Label",
            "Remove Label"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show11.j=1;
	Intent intent0=new Intent(v.getContext(),Show11.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show11.j=2;
	Intent intent1=new Intent(v.getContext(),Show11.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show11.j=3;
	Intent intent2=new Intent(v.getContext(),Show11.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show11.j=4;
	Intent intent3=new Intent(v.getContext(),Show11.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show11.j=5;
	Intent intent4=new Intent(v.getContext(),Show11.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show11.j=6;
	Intent intent5=new Intent(v.getContext(),Show11.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show11.j=7;
	Intent intent6=new Intent(v.getContext(),Show11.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show11.j=8;
	Intent intent7=new Intent(v.getContext(),Show11.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show11.j=9;
	Intent intent8=new Intent(v.getContext(),Show11.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show11.j=10;
	Intent intent9=new Intent(v.getContext(),Show11.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show11.j=11;
	Intent intent10=new Intent(v.getContext(),Show11.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;

	
		}
	}
 
}


class AWTList extends ListFragment{

	String myfriends_list[] = new String[]{
            "Create List",
            "Create Multi Select List",
            "Insert Item To List At Specified Index",
            "Make Item Of List Visible",
            "Deselect Item From List",
            "Determine If Index Is Selected List",
            "Determine Multiple Selection Mode Of List",
            "Get All Items From List",
            "Get Item Count Of List",
            "Get Item From List",
            "Get Number Of Visible Rows Of List",
            "Get Selected Index From Single Select List",
            "Get Selected Indexes From Multi Select List",
            "Get Selected Item From Single Select List",
            "Get Selected Items From Multi Select List",
            "Select Item From List",
            "Set Multiple Selection Mode For List",
            "Replace Item Of List",
            "Disable List",
            "Remove Single Item From List",
            "Remove AlI Items From List"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show12.j=1;
	Intent intent0=new Intent(v.getContext(),Show12.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show12.j=2;
	Intent intent1=new Intent(v.getContext(),Show12.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show12.j=3;
	Intent intent2=new Intent(v.getContext(),Show12.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show12.j=4;
	Intent intent3=new Intent(v.getContext(),Show12.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show12.j=5;
	Intent intent4=new Intent(v.getContext(),Show12.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show12.j=6;
	Intent intent5=new Intent(v.getContext(),Show12.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show12.j=7;
	Intent intent6=new Intent(v.getContext(),Show12.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show12.j=8;
	Intent intent7=new Intent(v.getContext(),Show12.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show12.j=9;
	Intent intent8=new Intent(v.getContext(),Show12.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show12.j=10;
	Intent intent9=new Intent(v.getContext(),Show12.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show12.j=11;
	Intent intent10=new Intent(v.getContext(),Show12.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show12.j=12;
	Intent intent11=new Intent(v.getContext(),Show12.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show12.j=13;
	Intent intent12=new Intent(v.getContext(),Show12.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show12.j=14;
	Intent intent13=new Intent(v.getContext(),Show12.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show12.j=15;
	Intent intent14=new Intent(v.getContext(),Show12.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show12.j=16;
	Intent intent15=new Intent(v.getContext(),Show12.class);
	intent15.putExtra("He",data);
	startActivity(intent15);   
	break;
	
	case 16:
	Show12.j=17;
	Intent intent16=new Intent(v.getContext(),Show12.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show12.j=18;
	Intent intent17=new Intent(v.getContext(),Show12.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;
	
	case 18:
	Show12.j=19;
	Intent intent18=new Intent(v.getContext(),Show12.class);
	intent18.putExtra("He",data);
	startActivity(intent18);
    break;
	
	case 19:
	Show12.j=20;
	Intent intent19=new Intent(v.getContext(),Show12.class);
	intent19.putExtra("He",data);
	startActivity(intent19);
    break;
	
	case 20:
	Show12.j=21;
	Intent intent20=new Intent(v.getContext(),Show12.class);
	intent20.putExtra("He",data);
	startActivity(intent20);
    break;
	
	case 21:
	Show12.j=22;
	Intent intent21=new Intent(v.getContext(),Show12.class);
	intent21.putExtra("He",data);
	startActivity(intent21);
    break;

	
		}
	}
 
}


class Constructor extends ListFragment{

	String myfriends_list[] = new String[]{
            "Constructor",
            "Constructor Overloading",
            "Default Constructor",
            "Parameterized Constructor"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show13.j=1;
	Intent intent0=new Intent(v.getContext(),Show13.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show13.j=2;
	Intent intent1=new Intent(v.getContext(),Show13.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show13.j=3;
	Intent intent2=new Intent(v.getContext(),Show13.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show13.j=4;
	Intent intent3=new Intent(v.getContext(),Show13.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show13.j=5;
	Intent intent4=new Intent(v.getContext(),Show13.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;	
		}
	}
}



class DataTypes extends ListFragment{

	String myfriends_list[] = new String[]{
            "Byte",
            "Boolean",
            "Character",
            "Integer",
            "Float",
            "Short",
            "Long",
            "Double"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show14.j=1;
	Intent intent0=new Intent(v.getContext(),Show14.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show14.j=2;
	Intent intent1=new Intent(v.getContext(),Show14.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show14.j=3;
	Intent intent2=new Intent(v.getContext(),Show14.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show14.j=4;
	Intent intent3=new Intent(v.getContext(),Show14.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show14.j=5;
	Intent intent4=new Intent(v.getContext(),Show14.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show14.j=6;
	Intent intent5=new Intent(v.getContext(),Show14.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show14.j=7;
	Intent intent6=new Intent(v.getContext(),Show14.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show14.j=8;
	Intent intent7=new Intent(v.getContext(),Show14.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show14.j=9;
	Intent intent8=new Intent(v.getContext(),Show14.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;

	}
	}
 
}


class Date extends ListFragment{

	String myfriends_list[] = new String[]{
            "DateClass",
            "Create Date From Specific Time",
            "Convert Date Into Milliseconds",
            "Compare Two Date Objects BeforeMethod",
            "Compare Two Date Objects AfterMethod",
            "Compare Two Date Objects ComareToMethod",
            "Add AM PM Time",
            "Convert DateFormat"
	};
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show15.j=1;
	Intent intent0=new Intent(v.getContext(),Show15.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show15.j=2;
	Intent intent1=new Intent(v.getContext(),Show15.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show15.j=3;
	Intent intent2=new Intent(v.getContext(),Show15.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show15.j=4;
	Intent intent3=new Intent(v.getContext(),Show15.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show15.j=5;
	Intent intent4=new Intent(v.getContext(),Show15.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show15.j=6;
	Intent intent5=new Intent(v.getContext(),Show15.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show15.j=7;
	Intent intent6=new Intent(v.getContext(),Show15.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show15.j=8;
	Intent intent7=new Intent(v.getContext(),Show15.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show15.j=9;
	Intent intent8=new Intent(v.getContext(),Show15.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
		}
	}
 
}


class EventHandaling extends ListFragment{

	String myfriends_list[] = new String[]{
            "Event Handaling With Button1",
            "Event Handaling With Button2",
            "Event Handaling With Button3",
            "Event Handaling With Button4",
            "Event Handaling With Button5",
            "Event Handaling With Button6",
            "Event Handaling With Button7",
            "Event Handaling With CheckBox",
            "Event Handaling With Frame",
            "Event Handaling With Label",
            "Event Handaling With Label2",
            "Event Handaling With MenuBar",
            "MouseListener",
            "MouseListener2",
            "MouseMotionListener"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show16.j=1;
	Intent intent0=new Intent(v.getContext(),Show16.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show16.j=2;
	Intent intent1=new Intent(v.getContext(),Show16.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show16.j=3;
	Intent intent2=new Intent(v.getContext(),Show16.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show16.j=4;
	Intent intent3=new Intent(v.getContext(),Show16.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show16.j=5;
	Intent intent4=new Intent(v.getContext(),Show16.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
	break;
	
	case 5:
	Show16.j=6;
	Intent intent5=new Intent(v.getContext(),Show16.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show16.j=7;
	Intent intent6=new Intent(v.getContext(),Show16.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show16.j=8;
	Intent intent7=new Intent(v.getContext(),Show16.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show16.j=9;
	Intent intent8=new Intent(v.getContext(),Show16.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show16.j=10;
	Intent intent9=new Intent(v.getContext(),Show16.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show16.j=11;
	Intent intent10=new Intent(v.getContext(),Show16.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show16.j=12;
	Intent intent11=new Intent(v.getContext(),Show16.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show16.j=13;
	Intent intent12=new Intent(v.getContext(),Show16.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show16.j=14;
	Intent intent13=new Intent(v.getContext(),Show16.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show16.j=15;
	Intent intent14=new Intent(v.getContext(),Show16.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show16.j=16;
	Intent intent15=new Intent(v.getContext(),Show16.class);
	intent15.putExtra("He",data);
	startActivity(intent15);   
	break;


}
	}
 
}

class ExceptionHandaling extends ListFragment{

	String myfriends_list[] = new String[]{
            "Error",
            "Try Catch",
            "Try Catch Finally",
            "Multiple Try Catch",
            "Throw Exception"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show17.j=1;
	Intent intent0=new Intent(v.getContext(),Show17.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show17.j=2;
	Intent intent1=new Intent(v.getContext(),Show17.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show17.j=3;
	Intent intent2=new Intent(v.getContext(),Show17.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show17.j=4;
	Intent intent3=new Intent(v.getContext(),Show17.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show17.j=5;
	Intent intent4=new Intent(v.getContext(),Show17.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show17.j=6;
	Intent intent5=new Intent(v.getContext(),Show17.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	}
	}
 
}


class FileIO extends ListFragment{

	String myfriends_list[] = new String[]{
            "AllFileOperations",
            "Characters Reading From File",
            "Characters Writing To File",
            "File Copy 1",
            "File Copy 2",
            "File Copy 3",
            "FileInputStream Class",
            "FileOutputStream Class",
            "FileReader Class",
            "FileWriter Class",
            "ScannerClass 1",
            "ScannerClass 2",
            "SetFilePermissions",
            "OpenNotepad",
            "Calculator"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show18.j=1;
	Intent intent0=new Intent(v.getContext(),Show18.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show18.j=2;
	Intent intent1=new Intent(v.getContext(),Show18.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show18.j=3;
	Intent intent2=new Intent(v.getContext(),Show18.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show18.j=4;
	Intent intent3=new Intent(v.getContext(),Show18.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show18.j=5;
	Intent intent4=new Intent(v.getContext(),Show18.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show18.j=6;
	Intent intent5=new Intent(v.getContext(),Show18.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show18.j=7;
	Intent intent6=new Intent(v.getContext(),Show18.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show18.j=8;
	Intent intent7=new Intent(v.getContext(),Show18.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show18.j=9;
	Intent intent8=new Intent(v.getContext(),Show18.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show18.j=10;
	Intent intent9=new Intent(v.getContext(),Show18.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show18.j=11;
	Intent intent10=new Intent(v.getContext(),Show18.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show18.j=12;
	Intent intent11=new Intent(v.getContext(),Show18.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show18.j=13;
	Intent intent12=new Intent(v.getContext(),Show18.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show18.j=14;
	Intent intent13=new Intent(v.getContext(),Show18.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show18.j=15;
	Intent intent14=new Intent(v.getContext(),Show18.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show18.j=16;
	Intent intent15=new Intent(v.getContext(),Show18.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;


	
		}
	}
 
}

class Formulae extends ListFragment{

	String myfriends_list[] = new String[]{
            "Hello World",
            "Class",
            "Circle Area",
            "Circle Perimeter",
            "Rectangle Area",
            "Rectangle Perimeter",
            "List Even Numbers",
            "List Odd Numbers",
            "List Even Odd Number",
            "Armstrong Number",
            "Reverse Number",
            "Palindrome Number Logic 1",
            "Palindrome Number Logic 2",
            "Prime Numbers Logic 1",
            "Prime Numbers Logic 2",
            "Compare Two Numbers",
            "Fibonacci Series Logic 1",
            "Fibonacci Series Logic 2",
            "Factorial",
            "Factorial Using Recursion",
            "Find Largest & Smallest Number",
            "Fahrenheit",
            "Leap Year",
            "Swap Numbers Logic 1",
            "Swap Numbers Logic 2",
            "Swap Numbers Without Using Third Variable Logic 1",
            "Swap Numbers Without Using Third Variable Logic 2",
            "Multiplication Table"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show19.j=1;
	Intent intent0=new Intent(v.getContext(),Show19.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show19.j=2;
	Intent intent1=new Intent(v.getContext(),Show19.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show19.j=3;
	Intent intent2=new Intent(v.getContext(),Show19.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show19.j=4;
	Intent intent3=new Intent(v.getContext(),Show19.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show19.j=5;
	Intent intent4=new Intent(v.getContext(),Show19.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show19.j=6;
	Intent intent5=new Intent(v.getContext(),Show19.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show19.j=7;
	Intent intent6=new Intent(v.getContext(),Show19.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show19.j=8;
	Intent intent7=new Intent(v.getContext(),Show19.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show19.j=9;
	Intent intent8=new Intent(v.getContext(),Show19.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show19.j=10;
	Intent intent9=new Intent(v.getContext(),Show19.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show19.j=11;
	Intent intent10=new Intent(v.getContext(),Show19.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show19.j=12;
	Intent intent11=new Intent(v.getContext(),Show19.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show19.j=13;
	Intent intent12=new Intent(v.getContext(),Show19.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show19.j=14;
	Intent intent13=new Intent(v.getContext(),Show19.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show19.j=15;
	Intent intent14=new Intent(v.getContext(),Show19.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show19.j=16;
	Intent intent15=new Intent(v.getContext(),Show19.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;
	
	case 16:
	Show19.j=17;
	Intent intent16=new Intent(v.getContext(),Show19.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show19.j=18;
	Intent intent17=new Intent(v.getContext(),Show19.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;
	
	case 18:
	Show19.j=19;
	Intent intent18=new Intent(v.getContext(),Show19.class);
	intent18.putExtra("He",data);
	startActivity(intent18);
    break;
	
	case 19:
	Show19.j=20;
	Intent intent19=new Intent(v.getContext(),Show19.class);
	intent19.putExtra("He",data);
	startActivity(intent19);
    break;
	
	case 20:
	Show19.j=21;
	Intent intent20=new Intent(v.getContext(),Show19.class);
	intent20.putExtra("He",data);
	startActivity(intent20);
    break;
	
	case 21:
	Show19.j=22;
	Intent intent21=new Intent(v.getContext(),Show19.class);
	intent21.putExtra("He",data);
	startActivity(intent21);
    break;
	
	case 22:
	Show19.j=23;
	Intent intent22=new Intent(v.getContext(),Show19.class);
	intent22.putExtra("He",data);
	startActivity(intent22);
    break;
	
	case 23:
	Show19.j=24;
	Intent intent23=new Intent(v.getContext(),Show19.class);
	intent23.putExtra("He",data);
	startActivity(intent23);
    break;
	
	case 24:
	Show19.j=25;
	Intent intent24=new Intent(v.getContext(),Show19.class);
	intent24.putExtra("He",data);
	startActivity(intent24);
    break;
	
	case 25:
	Show19.j=26;
	Intent intent25=new Intent(v.getContext(),Show19.class);
	intent25.putExtra("He",data);
	startActivity(intent25);
    break;
	
	case 26:
	Show19.j=27;
	Intent intent26=new Intent(v.getContext(),Show19.class);
	intent26.putExtra("He",data);
	startActivity(intent26);
    break;
    
	case 27:
	Show19.j=28;
	Intent intent27=new Intent(v.getContext(),Show19.class);
	intent27.putExtra("He",data);
	startActivity(intent27);
	    break;
		
	case 28:
	Show19.j=29;
	Intent intent28=new Intent(v.getContext(),Show19.class);
	intent28.putExtra("He",data);
	startActivity(intent28);
	break;
	
		}
	}
 
}


class Fundamentals extends ListFragment{

	String myfriends_list[] = new String[]{
            "Abstarct Class",
            "Method Overloading",
            "Method Overriding",
            "Nesting Method",
            "Static Method",
            "Static Variable",
            "Final Method",
            "Final Variable",
            "Type Casting",
            "Garbage Collection",
            "Run Object Finalization",
            "Find Ranges"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show20.j=1;
	Intent intent0=new Intent(v.getContext(),Show20.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show20.j=2;
	Intent intent1=new Intent(v.getContext(),Show20.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show20.j=3;
	Intent intent2=new Intent(v.getContext(),Show20.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show20.j=4;
	Intent intent3=new Intent(v.getContext(),Show20.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show20.j=5;
	Intent intent4=new Intent(v.getContext(),Show20.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show20.j=6;
	Intent intent5=new Intent(v.getContext(),Show20.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show20.j=7;
	Intent intent6=new Intent(v.getContext(),Show20.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show20.j=8;
	Intent intent7=new Intent(v.getContext(),Show20.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show20.j=9;
	Intent intent8=new Intent(v.getContext(),Show20.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show20.j=10;
	Intent intent9=new Intent(v.getContext(),Show20.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show20.j=11;
	Intent intent10=new Intent(v.getContext(),Show20.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show20.j=12;
	Intent intent11=new Intent(v.getContext(),Show20.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show20.j=13;
	Intent intent12=new Intent(v.getContext(),Show20.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
		}
	}
 
}


class IFElse extends ListFragment{

	String myfriends_list[] = new String[]{
            "If",
            "If Else",
            "If Else If",
            "Nested If Else"
            
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show21.j=1;
	Intent intent0=new Intent(v.getContext(),Show21.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show21.j=2;
	Intent intent1=new Intent(v.getContext(),Show21.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show21.j=3;
	Intent intent2=new Intent(v.getContext(),Show21.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show21.j=4;
	Intent intent3=new Intent(v.getContext(),Show21.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show21.j=5;
	Intent intent4=new Intent(v.getContext(),Show21.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
		}
	}
 
}


class Interface extends ListFragment{

	String myfriends_list[] = new String[]{
            "Interface",
            "Implement Interface",
            "Extending Interface"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show22.j=1;
	Intent intent0=new Intent(v.getContext(),Show22.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show22.j=2;
	Intent intent1=new Intent(v.getContext(),Show22.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show22.j=3;
	Intent intent2=new Intent(v.getContext(),Show22.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show22.j=4;
	Intent intent3=new Intent(v.getContext(),Show22.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
		}
	}
 
}


class Loop extends ListFragment{

	String myfriends_list[] = new String[]{
            "While Loop",
            "Do While Loop",
            "For Loop",
            "Infinite For Loop",
            "Enhanced For Loop Strings",
            "Enhanced For Loop IntegerArray",
            "Declare Multiple Variables In For Loop"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show23.j=1;
	Intent intent0=new Intent(v.getContext(),Show23.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show23.j=2;
	Intent intent1=new Intent(v.getContext(),Show23.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show23.j=3;
	Intent intent2=new Intent(v.getContext(),Show23.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show23.j=4;
	Intent intent3=new Intent(v.getContext(),Show23.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show23.j=5;
	Intent intent4=new Intent(v.getContext(),Show23.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show23.j=6;
	Intent intent5=new Intent(v.getContext(),Show23.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show23.j=7;
	Intent intent6=new Intent(v.getContext(),Show23.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show23.j=8;
	Intent intent7=new Intent(v.getContext(),Show23.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
		}
	}
 
}


class Math extends ListFragment{

	String myfriends_list[] = new String[]{
            "Find Power",
            "Find Square Root",
            "Find Absolute Value",
            "Find Ceiling Value",
            "Find Floor Value",
            "Find Exponential Value",
            "Find Natural Logarithm Value",
            "Generate Random Numbers",
            "Find Minimum Of Two Numbers",
            "Find Maximum Of Two Numbers"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show24.j=1;
	Intent intent0=new Intent(v.getContext(),Show24.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show24.j=2;
	Intent intent1=new Intent(v.getContext(),Show24.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show24.j=3;
	Intent intent2=new Intent(v.getContext(),Show24.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show24.j=4;
	Intent intent3=new Intent(v.getContext(),Show24.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show24.j=5;
	Intent intent4=new Intent(v.getContext(),Show24.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show24.j=6;
	Intent intent5=new Intent(v.getContext(),Show24.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show24.j=7;
	Intent intent6=new Intent(v.getContext(),Show24.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show24.j=8;
	Intent intent7=new Intent(v.getContext(),Show24.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show24.j=9;
	Intent intent8=new Intent(v.getContext(),Show24.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show24.j=10;
	Intent intent9=new Intent(v.getContext(),Show24.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show24.j=11;
	Intent intent10=new Intent(v.getContext(),Show24.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
		}
	}
 
}

class Operators extends ListFragment{

	String myfriends_list[] = new String[]{
            "Arithmetic Operator",
            "Addition Operator",
            "Multiplication Operator",
            "Division Operator",
            "Assignment Operator",
            "Subtraction Operator",
            "Conditional Operator",
            "Logical Operator",
            "Modulus Operator",
            "InstanceOf Operator Object",
            "InstanceOf Operator Variable",
            "Continue Statement",
            "Break Statement",
            "Break Continue Statement",
            "Continue Statement With Label",
            "Break Statement With Label",
            "Increment And Decrement Operators"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show25.j=1;
	Intent intent0=new Intent(v.getContext(),Show25.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show25.j=2;
	Intent intent1=new Intent(v.getContext(),Show25.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show25.j=3;
	Intent intent2=new Intent(v.getContext(),Show25.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show25.j=4;
	Intent intent3=new Intent(v.getContext(),Show25.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show25.j=5;
	Intent intent4=new Intent(v.getContext(),Show25.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show25.j=6;
	Intent intent5=new Intent(v.getContext(),Show25.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show25.j=7;
	Intent intent6=new Intent(v.getContext(),Show25.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show25.j=8;
	Intent intent7=new Intent(v.getContext(),Show25.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show25.j=9;
	Intent intent8=new Intent(v.getContext(),Show25.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show25.j=10;
	Intent intent9=new Intent(v.getContext(),Show25.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show25.j=11;
	Intent intent10=new Intent(v.getContext(),Show25.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show25.j=12;
	Intent intent11=new Intent(v.getContext(),Show25.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show25.j=13;
	Intent intent12=new Intent(v.getContext(),Show25.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show25.j=14;
	Intent intent13=new Intent(v.getContext(),Show25.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show25.j=15;
	Intent intent14=new Intent(v.getContext(),Show25.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show25.j=16;
	Intent intent15=new Intent(v.getContext(),Show25.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;
	
	case 16:
	Show25.j=17;
	Intent intent16=new Intent(v.getContext(),Show25.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show25.j=18;
	Intent intent17=new Intent(v.getContext(),Show25.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;
	
		}
	}
 
}



class Pattern extends ListFragment{

	String myfriends_list[] = new String[]{
			"Print Alphabet",
            "Pyramid For Given Number",
            "Number Pyramid 1",
            "Number Pyramid 2",
            "Star Pyramid 1",
            "Star Pyramid 2",
            "Star Pyramid 3",
            "Star Pyramid 4",
            "Star Pyramid 5",
            "Star Pyramid 6"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show26.j=1;
	Intent intent0=new Intent(v.getContext(),Show26.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show26.j=2;
	Intent intent1=new Intent(v.getContext(),Show26.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show26.j=3;
	Intent intent2=new Intent(v.getContext(),Show26.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show26.j=4;
	Intent intent3=new Intent(v.getContext(),Show26.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show26.j=5;
	Intent intent4=new Intent(v.getContext(),Show26.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show26.j=6;
	Intent intent5=new Intent(v.getContext(),Show26.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show26.j=7;
	Intent intent6=new Intent(v.getContext(),Show26.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show26.j=8;
	Intent intent7=new Intent(v.getContext(),Show26.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show26.j=9;
	Intent intent8=new Intent(v.getContext(),Show26.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show26.j=10;
	Intent intent9=new Intent(v.getContext(),Show26.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show26.j=11;
	Intent intent10=new Intent(v.getContext(),Show26.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;

	
		}
	}
 
}


class Runtime extends ListFragment{

	String myfriends_list[] = new String[]{
			"Get Available Processors",
            "Get Java Runtime",
            "Get Free Memory JVM",
            "Suggest JVM Run Garbage Collector",
            "Suggest JVM Run Object Finalization",
            "Terminate JVM"
            
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show27.j=1;
	Intent intent0=new Intent(v.getContext(),Show27.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show27.j=2;
	Intent intent1=new Intent(v.getContext(),Show27.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show27.j=3;
	Intent intent2=new Intent(v.getContext(),Show27.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show27.j=4;
	Intent intent3=new Intent(v.getContext(),Show27.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show27.j=5;
	Intent intent4=new Intent(v.getContext(),Show27.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show27.j=6;
	Intent intent5=new Intent(v.getContext(),Show27.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show27.j=7;
	Intent intent6=new Intent(v.getContext(),Show27.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
		}
	}
 
}


class Search extends ListFragment{

	String myfriends_list[] = new String[]{
			"Binary Search",
            "Linear Search"
            
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show28.j=1;
	Intent intent0=new Intent(v.getContext(),Show28.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show28.j=2;
	Intent intent1=new Intent(v.getContext(),Show28.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show28.j=3;
	Intent intent2=new Intent(v.getContext(),Show28.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
		}
	}
 
}


class Sort extends ListFragment{

	String myfriends_list[] = new String[]{
			"Bubble Sort 1",
            "Bubble Sort 2",
            "Sort Byte Array",
            "Sort Char Array",
            "Sort Int Array",
            "Sort Float Array",
            "Sort Short Array",
            "Sort Long Array",
            "Sort Double Array"
		};
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show29.j=1;
	Intent intent0=new Intent(v.getContext(),Show29.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show29.j=2;
	Intent intent1=new Intent(v.getContext(),Show29.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show29.j=3;
	Intent intent2=new Intent(v.getContext(),Show29.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show29.j=4;
	Intent intent3=new Intent(v.getContext(),Show29.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show29.j=5;
	Intent intent4=new Intent(v.getContext(),Show29.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show29.j=6;
	Intent intent5=new Intent(v.getContext(),Show29.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show29.j=7;
	Intent intent6=new Intent(v.getContext(),Show29.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show29.j=8;
	Intent intent7=new Intent(v.getContext(),Show29.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show29.j=9;
	Intent intent8=new Intent(v.getContext(),Show29.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show29.j=10;
	Intent intent9=new Intent(v.getContext(),Show29.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
		}
	}
 
}


class String1 extends ListFragment{

	String myfriends_list[] = new String[]{
			"String",
            "Substring",
            "String CharAt",
            "String Compare",
            "String Concat",
            "String endsWith",
            "String Intern Method",
            "String isEmpty",
            "String Length",
            "String Replace",
            "String Reverse",
            "String startsWith",
            "String Trim",
            "String valueOf",
            "String LowerCase",
            "String UpperCase",
            "String Contains Array",
            "String Contains String",
            "String Array",
            "String Array Length",
            "String Array Contains",
            "String Array To List",
            "String Array To String",
            "Sort String Array",
            "String To ArrayList",
            "ArrayList To String Array",
            "Reverse String Array",
            "String Split",
            "Search String Using IndexOf",
            "String To Date",
            "Date To String",
            "String To String Array",
            "Char Array To String",
            "Check If String Contains Valid Number",
            "Convert Int Array To String",
            "Convert String To Character Array"			        
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show30.j=1;
	Intent intent0=new Intent(v.getContext(),Show30.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show30.j=2;
	Intent intent1=new Intent(v.getContext(),Show30.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show30.j=3;
	Intent intent2=new Intent(v.getContext(),Show30.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show30.j=4;
	Intent intent3=new Intent(v.getContext(),Show30.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show30.j=5;
	Intent intent4=new Intent(v.getContext(),Show30.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show30.j=6;
	Intent intent5=new Intent(v.getContext(),Show30.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show30.j=7;
	Intent intent6=new Intent(v.getContext(),Show30.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show30.j=8;
	Intent intent7=new Intent(v.getContext(),Show30.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show30.j=9;
	Intent intent8=new Intent(v.getContext(),Show30.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show30.j=10;
	Intent intent9=new Intent(v.getContext(),Show30.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show30.j=11;
	Intent intent10=new Intent(v.getContext(),Show30.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show30.j=12;
	Intent intent11=new Intent(v.getContext(),Show30.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show30.j=13;
	Intent intent12=new Intent(v.getContext(),Show30.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show30.j=14;
	Intent intent13=new Intent(v.getContext(),Show30.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show30.j=15;
	Intent intent14=new Intent(v.getContext(),Show30.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show30.j=16;
	Intent intent15=new Intent(v.getContext(),Show30.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;
	
	case 16:
	Show30.j=17;
	Intent intent16=new Intent(v.getContext(),Show30.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show30.j=18;
	Intent intent17=new Intent(v.getContext(),Show30.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;
	
	case 18:
	Show30.j=19;
	Intent intent18=new Intent(v.getContext(),Show30.class);
	intent18.putExtra("He",data);
	startActivity(intent18);
    break;
	
	case 19:
	Show30.j=20;
	Intent intent19=new Intent(v.getContext(),Show30.class);
	intent19.putExtra("He",data);
	startActivity(intent19);
    break;
	
	case 20:
	Show30.j=21;
	Intent intent20=new Intent(v.getContext(),Show30.class);
	intent20.putExtra("He",data);
	startActivity(intent20);
    break;
	
	case 21:
	Show30.j=22;
	Intent intent21=new Intent(v.getContext(),Show30.class);
	intent21.putExtra("He",data);
	startActivity(intent21);
    break;
	
	case 22:
	Show30.j=23;
	Intent intent22=new Intent(v.getContext(),Show30.class);
	intent22.putExtra("He",data);
	startActivity(intent22);
    break;
	
	case 23:
	Show30.j=24;
	Intent intent23=new Intent(v.getContext(),Show30.class);
	intent23.putExtra("He",data);
	startActivity(intent23);
    break;
	
	case 24:
	Show30.j=25;
	Intent intent24=new Intent(v.getContext(),Show30.class);
	intent24.putExtra("He",data);
	startActivity(intent24);
    break;
	
	case 25:
	Show30.j=26;
	Intent intent25=new Intent(v.getContext(),Show30.class);
	intent25.putExtra("He",data);
	startActivity(intent25);
    break;
	
	case 26:
	Show30.j=27;
	Intent intent26=new Intent(v.getContext(),Show30.class);
	intent26.putExtra("He",data);
	startActivity(intent26);
    break;
    
	case 27:
	Show30.j=28;
	Intent intent27=new Intent(v.getContext(),Show30.class);
	intent27.putExtra("He",data);
	startActivity(intent27);
	break;
		
	case 28:
	Show30.j=29;
	Intent intent28=new Intent(v.getContext(),Show30.class);
	intent28.putExtra("He",data);
	startActivity(intent28);
	break;
		
	case 29:
	Show30.j=30;
	Intent intent29=new Intent(v.getContext(),Show30.class);
	intent29.putExtra("He",data);
	startActivity(intent29);
	break;
		
	case 30:
	Show30.j=31;
	Intent intent30=new Intent(v.getContext(),Show30.class);
	intent30.putExtra("He",data);
	startActivity(intent30);
	break;
		
	case 31:
	Show30.j=32;
	Intent intent31=new Intent(v.getContext(),Show30.class);
	intent31.putExtra("He",data);
	startActivity(intent31);
	break;
		
	case 32:
	Show30.j=33;
	Intent intent32=new Intent(v.getContext(),Show30.class);
	intent32.putExtra("He",data);
	startActivity(intent32);
	break;
		
	case 33:
	Show30.j=34;
	Intent intent33=new Intent(v.getContext(),Show30.class);
	intent33.putExtra("He",data);
	startActivity(intent33);
	break;
		
	case 34:
	Show30.j=35;
	Intent intent34=new Intent(v.getContext(),Show30.class);
	intent34.putExtra("He",data);
	startActivity(intent34);
	break;
		
	case 35:
	Show30.j=36;
	Intent intent35=new Intent(v.getContext(),Show30.class);
	intent35.putExtra("He",data);
	startActivity(intent35);
	break;
		
	case 36:
	Show30.j=37;
	Intent intent36=new Intent(v.getContext(),Show30.class);
	intent36.putExtra("He",data);
	startActivity(intent36);
	break;
	
		}
	}
 
}


class StringBuffer extends ListFragment{

	String myfriends_list[] = new String[]{
			"StringBuffer",
			"StringBuffer Length",
			"StringBuffer Replace",
			"StringBuffer Reset",
			"StringBuffer Reverse",
			"StringBuffer setLength",
			"StringBuffer SubString",
			"StringBuffer Append New Line",
			"StringBuffer Trim",
			"StringBuffer toString",
			"StringBuffer Insert Method",
			"StringBuffer Append Method",
			"StringBuffer Delete Remove Character",
			"StringBuffer To Byte Array",
			"StringBuffer To File",
			"StringBuffer To InputStream"			
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show31.j=1;
	Intent intent0=new Intent(v.getContext(),Show31.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show31.j=2;
	Intent intent1=new Intent(v.getContext(),Show31.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show31.j=3;
	Intent intent2=new Intent(v.getContext(),Show31.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show31.j=4;
	Intent intent3=new Intent(v.getContext(),Show31.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show31.j=5;
	Intent intent4=new Intent(v.getContext(),Show31.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show31.j=6;
	Intent intent5=new Intent(v.getContext(),Show31.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show31.j=7;
	Intent intent6=new Intent(v.getContext(),Show31.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show31.j=8;
	Intent intent7=new Intent(v.getContext(),Show31.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show31.j=9;
	Intent intent8=new Intent(v.getContext(),Show31.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show31.j=10;
	Intent intent9=new Intent(v.getContext(),Show31.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show31.j=11;
	Intent intent10=new Intent(v.getContext(),Show31.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show31.j=12;
	Intent intent11=new Intent(v.getContext(),Show31.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show31.j=13;
	Intent intent12=new Intent(v.getContext(),Show31.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show31.j=14;
	Intent intent13=new Intent(v.getContext(),Show31.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show31.j=15;
	Intent intent14=new Intent(v.getContext(),Show31.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show31.j=16;
	Intent intent15=new Intent(v.getContext(),Show31.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;
	
	case 16:
	Show31.j=17;
	Intent intent16=new Intent(v.getContext(),Show31.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
    
    
		}
	}
 
}

class StringTokenizer extends ListFragment{

	String myfriends_list[] = new String[]{
			"StringTokenizer",
            "StringTokenizer Count Tokens",
            "StringTokenizer Specify Delimiter",
            "StringTokenizer Return Delimiters As Tokens",
            "StringTokenizer Return Tokens As Objects"
			
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show32.j=1;
	Intent intent0=new Intent(v.getContext(),Show32.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show32.j=2;
	Intent intent1=new Intent(v.getContext(),Show32.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show32.j=3;
	Intent intent2=new Intent(v.getContext(),Show32.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show32.j=4;
	Intent intent3=new Intent(v.getContext(),Show32.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show32.j=5;
	Intent intent4=new Intent(v.getContext(),Show32.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show32.j=6;
	Intent intent5=new Intent(v.getContext(),Show32.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;

	
		}
	}
 
}


class SWING extends ListFragment{

	String myfriends_list[] = new String[]{
			"JButton",
            "JCheckBox",
            "JComboBox",
            "JDialog",
            "Jlabel",
            "JList",
            "JPanal",
            "JRadioButton",
            "JScrollBar",
            "JTextField",
            "JTextArea",
            "JToggleButton",
            "JTable",
            "JTabbedPane",
            "JTree",
            "JToolTip",
            "JSeparator",
            "JScrollPane",
            "ImageIcon",
            "JProgressBar",
            "JFileChooser",
            "JPasswordField",
            "JColorChooser",
            "JControls",
            "Swing FlowLayout",
            "Swing GridLayout",
            "Swing CardLayout",
            "Swing BorderLayout",
            "Swing BoxLayout",
            "JFrame"
			  
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show33.j=1;
	Intent intent0=new Intent(v.getContext(),Show33.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show33.j=2;
	Intent intent1=new Intent(v.getContext(),Show33.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show33.j=3;
	Intent intent2=new Intent(v.getContext(),Show33.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show33.j=4;
	Intent intent3=new Intent(v.getContext(),Show33.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show33.j=5;
	Intent intent4=new Intent(v.getContext(),Show33.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show33.j=6;
	Intent intent5=new Intent(v.getContext(),Show33.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show33.j=7;
	Intent intent6=new Intent(v.getContext(),Show33.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show33.j=8;
	Intent intent7=new Intent(v.getContext(),Show33.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show33.j=9;
	Intent intent8=new Intent(v.getContext(),Show33.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show33.j=10;
	Intent intent9=new Intent(v.getContext(),Show33.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show33.j=11;
	Intent intent10=new Intent(v.getContext(),Show33.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show33.j=12;
	Intent intent11=new Intent(v.getContext(),Show33.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show33.j=13;
	Intent intent12=new Intent(v.getContext(),Show33.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show33.j=14;
	Intent intent13=new Intent(v.getContext(),Show33.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show33.j=15;
	Intent intent14=new Intent(v.getContext(),Show33.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show33.j=16;
	Intent intent15=new Intent(v.getContext(),Show33.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;
	
	case 16:
	Show33.j=17;
	Intent intent16=new Intent(v.getContext(),Show33.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show33.j=18;
	Intent intent17=new Intent(v.getContext(),Show33.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;
	
	case 18:
	Show33.j=19;
	Intent intent18=new Intent(v.getContext(),Show33.class);
	intent18.putExtra("He",data);
	startActivity(intent18);
    break;
	
	case 19:
	Show33.j=20;
	Intent intent19=new Intent(v.getContext(),Show33.class);
	intent19.putExtra("He",data);
	startActivity(intent19);
    break;
	
	case 20:
	Show33.j=21;
	Intent intent20=new Intent(v.getContext(),Show33.class);
	intent20.putExtra("He",data);
	startActivity(intent20);
    break;
	
	case 21:
	Show33.j=22;
	Intent intent21=new Intent(v.getContext(),Show33.class);
	intent21.putExtra("He",data);
	startActivity(intent21);
    break;
	
	case 22:
	Show33.j=23;
	Intent intent22=new Intent(v.getContext(),Show33.class);
	intent22.putExtra("He",data);
	startActivity(intent22);
    break;
	
	case 23:
	Show33.j=24;
	Intent intent23=new Intent(v.getContext(),Show33.class);
	intent23.putExtra("He",data);
	startActivity(intent23);
    break;
	
	case 24:
	Show33.j=25;
	Intent intent24=new Intent(v.getContext(),Show33.class);
	intent24.putExtra("He",data);
	startActivity(intent24);
    break;
	
	case 25:
	Show33.j=26;
	Intent intent25=new Intent(v.getContext(),Show33.class);
	intent25.putExtra("He",data);
	startActivity(intent25);
    break;
	
	case 26:
	Show33.j=27;
	Intent intent26=new Intent(v.getContext(),Show33.class);
	intent26.putExtra("He",data);
	startActivity(intent26);
    break;
    
	case 27:
	Show33.j=28;
	Intent intent27=new Intent(v.getContext(),Show33.class);
	intent27.putExtra("He",data);
	startActivity(intent27);
	    break;
		
	case 28:
	Show33.j=29;
	Intent intent28=new Intent(v.getContext(),Show33.class);
	intent28.putExtra("He",data);
	startActivity(intent28);
	break;
		
	case 29:
	Show33.j=30;
	Intent intent29=new Intent(v.getContext(),Show33.class);
	intent29.putExtra("He",data);
	startActivity(intent29);
	break;
		
	case 30:
	Show33.j=31;
	Intent intent30=new Intent(v.getContext(),Show33.class);
	intent30.putExtra("He",data);
	startActivity(intent30);
	break;

	
		}
	}
 
}


class SwingJLabel extends ListFragment{

	String myfriends_list[] = new String[]{
			"Align Icon JLabel",
            "Show Or Hide JLabel",
            "Set Tooltip JLabel",
            "Set Icon For JLabel",
            "Check JLabel is Visible Or Enabled",
            "Disable JLabel",
            "Get Horizontal Alignment JLabel",
            "Get Or Set Gap Between JLabel Icon And Text",
            "Get Text JLabel",
            "Get Tooltip JLabel ",
            "Get X Add Y Coordinates JLabel",
            "Disabled JLabel Icon",
            "Set Background Color JLabel",
            "Set Font JLabel",
            "Set Foreground Color JLabel",
            "Set JLabel Border"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show34.j=1;
	Intent intent0=new Intent(v.getContext(),Show34.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show34.j=2;
	Intent intent1=new Intent(v.getContext(),Show34.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show34.j=3;
	Intent intent2=new Intent(v.getContext(),Show34.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show34.j=4;
	Intent intent3=new Intent(v.getContext(),Show34.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show34.j=5;
	Intent intent4=new Intent(v.getContext(),Show34.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show34.j=6;
	Intent intent5=new Intent(v.getContext(),Show34.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show34.j=7;
	Intent intent6=new Intent(v.getContext(),Show34.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show34.j=8;
	Intent intent7=new Intent(v.getContext(),Show34.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show34.j=9;
	Intent intent8=new Intent(v.getContext(),Show34.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show34.j=10;
	Intent intent9=new Intent(v.getContext(),Show34.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show34.j=11;
	Intent intent10=new Intent(v.getContext(),Show34.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show34.j=12;
	Intent intent11=new Intent(v.getContext(),Show34.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show34.j=13;
	Intent intent12=new Intent(v.getContext(),Show34.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show34.j=14;
	Intent intent13=new Intent(v.getContext(),Show34.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show34.j=15;
	Intent intent14=new Intent(v.getContext(),Show34.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show34.j=16;
	Intent intent15=new Intent(v.getContext(),Show34.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;
	
	case 16:
	Show34.j=17;
	Intent intent16=new Intent(v.getContext(),Show34.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;

	
		}
	}
 
}


class SwingJTextField extends ListFragment{

	String myfriends_list[] = new String[]{
			"Create JTextField",
            "Create Read Only JTextField",
            "Change Font JTextField",
            "Disable Enable JTextField",
            "Get X And Y Coordinates JTextField",
            "Show Hide JTextField",
            "JTextField Columns",
            "Set Background Color JTextField",
            "Set Foreground Color JTextField",
            "Set JTextField Border",
            "Set ToolTip JTextField"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show35.j=1;
	Intent intent0=new Intent(v.getContext(),Show35.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show35.j=2;
	Intent intent1=new Intent(v.getContext(),Show35.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show35.j=3;
	Intent intent2=new Intent(v.getContext(),Show35.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show35.j=4;
	Intent intent3=new Intent(v.getContext(),Show35.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show35.j=5;
	Intent intent4=new Intent(v.getContext(),Show35.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show35.j=6;
	Intent intent5=new Intent(v.getContext(),Show35.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show35.j=7;
	Intent intent6=new Intent(v.getContext(),Show35.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show35.j=8;
	Intent intent7=new Intent(v.getContext(),Show35.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show35.j=9;
	Intent intent8=new Intent(v.getContext(),Show35.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show35.j=10;
	Intent intent9=new Intent(v.getContext(),Show35.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show35.j=11;
	Intent intent10=new Intent(v.getContext(),Show35.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show35.j=12;
	Intent intent11=new Intent(v.getContext(),Show35.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
    
		}
	}
 
}


class Switch extends ListFragment{

	String myfriends_list[] = new String[]{
			"Switch Statement",
            "Nested Switch",
            "Free Flowing Switch Statement"
            
	};
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show36.j=1;
	Intent intent0=new Intent(v.getContext(),Show36.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show36.j=2;
	Intent intent1=new Intent(v.getContext(),Show36.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show36.j=3;
	Intent intent2=new Intent(v.getContext(),Show36.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show36.j=4;
	Intent intent3=new Intent(v.getContext(),Show36.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;

		}
	}
 
}

class System extends ListFragment{

	String myfriends_list[] = new String[]{
			"Get System Time",
            "Get DateTime",
            "Get System Properties",
            "Get Classpath",
            "Get File Separator",
            "Get JavaVersion",
            "Determine Operating System"
			
			      
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show37.j=1;
	Intent intent0=new Intent(v.getContext(),Show37.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show37.j=2;
	Intent intent1=new Intent(v.getContext(),Show37.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show37.j=3;
	Intent intent2=new Intent(v.getContext(),Show37.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show37.j=4;
	Intent intent3=new Intent(v.getContext(),Show37.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show37.j=5;
	Intent intent4=new Intent(v.getContext(),Show37.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show37.j=6;
	Intent intent5=new Intent(v.getContext(),Show37.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show37.j=7;
	Intent intent6=new Intent(v.getContext(),Show37.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show37.j=8;
	Intent intent7=new Intent(v.getContext(),Show37.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;

	
		}
	}
 
}
class Thread extends ListFragment{

	String myfriends_list[] = new String[]{
			"Implement Thread Runnable Interface",
            "Extend Thread",
            "Current Thread",
            "Pause Thread",
            "Set Thread Name",
            "Get Current Thread",
            "Thread Methods",
            "Thread Synchronization"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show38.j=1;
	Intent intent0=new Intent(v.getContext(),Show38.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show38.j=2;
	Intent intent1=new Intent(v.getContext(),Show38.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show38.j=3;
	Intent intent2=new Intent(v.getContext(),Show38.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show38.j=4;
	Intent intent3=new Intent(v.getContext(),Show38.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show38.j=5;
	Intent intent4=new Intent(v.getContext(),Show38.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show38.j=6;
	Intent intent5=new Intent(v.getContext(),Show38.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show38.j=7;
	Intent intent6=new Intent(v.getContext(),Show38.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show38.j=8;
	Intent intent7=new Intent(v.getContext(),Show38.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show38.j=9;
	Intent intent8=new Intent(v.getContext(),Show38.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;

	}

	}
 
}

class Vector extends ListFragment{

	String myfriends_list[] = new String[]{
			"Simple Vector",
            "Add Element Specified Index Vector",
            "Append All Elements Of Other Collection To Vector",
            "Copy All Elements Of Java Vector To An Object Array",
            "Get Size Of Vector & Loop Through Elements",
            "Get Sub List Of Vector",
            "Set Size Of Vector",
            "Replace An Element At Specified Index Of Vector",
            "Insert Elements Of Collection To Specified Index Of Vector",
            "Sort Elements Of Vector",
            "Search An Element Of Vector From Specific Index",
            "Search An Element Of Vector",
            "Iterate Through Elements Vector Using Iterator",
            "Iterate Through Elements Vector Using ListIterator",
            "Remove An Element From Specified Index Of Vector",
            "Remove Specified Element From Vector",
            "Remove All Elements From Vector"
	
	};    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();
	
switch (position) {
	
	case 0:
	Show39.j=1;
	Intent intent0=new Intent(v.getContext(),Show39.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show39.j=2;
	Intent intent1=new Intent(v.getContext(),Show39.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show39.j=3;
	Intent intent2=new Intent(v.getContext(),Show39.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show39.j=4;
	Intent intent3=new Intent(v.getContext(),Show39.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show39.j=5;
	Intent intent4=new Intent(v.getContext(),Show39.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show39.j=6;
	Intent intent5=new Intent(v.getContext(),Show39.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show39.j=7;
	Intent intent6=new Intent(v.getContext(),Show39.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show39.j=8;
	Intent intent7=new Intent(v.getContext(),Show39.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show39.j=9;
	Intent intent8=new Intent(v.getContext(),Show39.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show39.j=10;
	Intent intent9=new Intent(v.getContext(),Show39.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show39.j=11;
	Intent intent10=new Intent(v.getContext(),Show39.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show39.j=12;
	Intent intent11=new Intent(v.getContext(),Show39.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show39.j=13;
	Intent intent12=new Intent(v.getContext(),Show39.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show39.j=14;
	Intent intent13=new Intent(v.getContext(),Show39.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show39.j=15;
	Intent intent14=new Intent(v.getContext(),Show39.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show39.j=16;
	Intent intent15=new Intent(v.getContext(),Show39.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;
	
	case 16:
	Show39.j=17;
	Intent intent16=new Intent(v.getContext(),Show39.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show39.j=18;
	Intent intent17=new Intent(v.getContext(),Show39.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;

	
		}
	}
 
}
class WrapperClass extends ListFragment{

	String myfriends_list[] = new String[]{
			"Boolean",
            "Convert Boolean Object Boolean Primitive",
            "Convert Boolean Object String Object",
            "Convert Boolean Primitive Boolean Object",
            "Convert String Object Boolean Object",
            "Byte",
            "Convert Byte Object String Object",
            "Convert Byte To Byte Object",
            "Convert Byte To Numeric Primitive Data Types",
            "Convert String To Byte",
            "Convert String To Primitive Byte",
            "Double",
            "Convert Double Object To String Object",
            "Convert Double To Double Object",
            "Convert Double To Numeric Primitive Data Types",
            "Convert String To Double",
            "Double Compare",
            "Double isInfinite",
            "Double isNaN Method",
            "Convert Float Object To String  Object",
            "Convert Float Primitive Value To Float Object",
            "Convert Float To Numeric Primitive Data Types",
            "Convert String To Float Object",
            "Float Compare",
            "Float isInfinite Method",
            "Float isNaN Method",
            "Float Wrapper Class",
            "Convert Binary Number To Decimal Number",
            "Convert Decimal Integer To Binary Number",
            "Convert Decimal Integer To Hhexadecimal Number",
            "Convert Decimal Integer To Octal Number",
            "Convert Hexadecimal Number To Decimal Number",
            "Convert Integer To String Object",
            "Convert Int To Integer Object",
            "Convert String To Int",
            "Convert String To Integer Object"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     
      /** Creating array adapter to set data in listview */
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1, myfriends_list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    
    
	@Override
public void onListItemClick(ListView l,View v,int position,long id)
{
	super.onListItemClick(l, v, position, id);
	Bundle data = new Bundle();

switch (position) {
	
	case 0:
	Show40.j=1;
	Intent intent0=new Intent(v.getContext(),Show40.class);
	intent0.putExtra("He",data);
	startActivity(intent0);
	break;
	
	case 1:
	Show40.j=2;
	Intent intent1=new Intent(v.getContext(),Show40.class);
	intent1.putExtra("He",data);
	startActivity(intent1);
    break;
	
	case 2:
	Show40.j=3;
	Intent intent2=new Intent(v.getContext(),Show40.class);
	intent2.putExtra("He",data);
	startActivity(intent2);
    break;
	
	case 3:
	Show40.j=4;
	Intent intent3=new Intent(v.getContext(),Show40.class);
	intent3.putExtra("He",data);
	startActivity(intent3);
    break;
	
	case 4:
	Show40.j=5;
	Intent intent4=new Intent(v.getContext(),Show40.class);
	intent4.putExtra("He",data);
	startActivity(intent4);
    break;
	
	case 5:
	Show40.j=6;
	Intent intent5=new Intent(v.getContext(),Show40.class);
	intent5.putExtra("He",data);
	startActivity(intent5);
    break;
	
	case 6:
	Show40.j=7;
	Intent intent6=new Intent(v.getContext(),Show40.class);
	intent6.putExtra("He",data);
	startActivity(intent6);
    break;
	
	case 7:
	Show40.j=8;
	Intent intent7=new Intent(v.getContext(),Show40.class);
	intent7.putExtra("He",data);
	startActivity(intent7);
    break;
	
	case 8:
	Show40.j=9;
	Intent intent8=new Intent(v.getContext(),Show40.class);
	intent8.putExtra("He",data);
	startActivity(intent8);
    break;
	
	case 9:
	Show40.j=10;
	Intent intent9=new Intent(v.getContext(),Show40.class);
	intent9.putExtra("He",data);
	startActivity(intent9);
    break;
	
	case 10:
	Show40.j=11;
	Intent intent10=new Intent(v.getContext(),Show40.class);
	intent10.putExtra("He",data);
	startActivity(intent10);
    break;
	
	case 11:
	Show40.j=12;
	Intent intent11=new Intent(v.getContext(),Show40.class);
	intent11.putExtra("He",data);
	startActivity(intent11);
    break;
	
	case 12:
	Show40.j=13;
	Intent intent12=new Intent(v.getContext(),Show40.class);
	intent12.putExtra("He",data);
	startActivity(intent12);
    break;
	
	case 13:
	Show40.j=14;
	Intent intent13=new Intent(v.getContext(),Show40.class);
	intent13.putExtra("He",data);
	startActivity(intent13);
    break;
	
	case 14:
	Show40.j=15;
	Intent intent14=new Intent(v.getContext(),Show40.class);
	intent14.putExtra("He",data);
	startActivity(intent14);
    break;
	
	case 15:
	Show40.j=16;
	Intent intent15=new Intent(v.getContext(),Show40.class);
	intent15.putExtra("He",data);
	startActivity(intent15);
    break;
	
	case 16:
	Show40.j=17;
	Intent intent16=new Intent(v.getContext(),Show40.class);
	intent16.putExtra("He",data);
	startActivity(intent16);
    break;
	
	case 17:
	Show40.j=18;
	Intent intent17=new Intent(v.getContext(),Show40.class);
	intent17.putExtra("He",data);
	startActivity(intent17);
    break;
	
	case 18:
	Show40.j=19;
	Intent intent18=new Intent(v.getContext(),Show40.class);
	intent18.putExtra("He",data);
	startActivity(intent18);
    break;
	
	case 19:
	Show40.j=20;
	Intent intent19=new Intent(v.getContext(),Show40.class);
	intent19.putExtra("He",data);
	startActivity(intent19);
    break;
	
	case 20:
	Show40.j=21;
	Intent intent20=new Intent(v.getContext(),Show40.class);
	intent20.putExtra("He",data);
	startActivity(intent20);
    break;
	
	case 21:
	Show40.j=22;
	Intent intent21=new Intent(v.getContext(),Show40.class);
	intent21.putExtra("He",data);
	startActivity(intent21);
    break;
	
	case 22:
	Show40.j=23;
	Intent intent22=new Intent(v.getContext(),Show40.class);
	intent22.putExtra("He",data);
	startActivity(intent22);
    break;
	
	case 23:
	Show40.j=24;
	Intent intent23=new Intent(v.getContext(),Show40.class);
	intent23.putExtra("He",data);
	startActivity(intent23);
    break;
	
	case 24:
	Show40.j=25;
	Intent intent24=new Intent(v.getContext(),Show40.class);
	intent24.putExtra("He",data);
	startActivity(intent24);
    break;
	
	case 25:
	Show40.j=26;
	Intent intent25=new Intent(v.getContext(),Show40.class);
	intent25.putExtra("He",data);
	startActivity(intent25);
    break;
	
	case 26:
	Show40.j=27;
	Intent intent26=new Intent(v.getContext(),Show40.class);
	intent26.putExtra("He",data);
	startActivity(intent26);
    break;
    
	case 27:
	Show40.j=28;
	Intent intent27=new Intent(v.getContext(),Show40.class);
	intent27.putExtra("He",data);
	startActivity(intent27);
	    break;
		
	case 28:
	Show40.j=29;
	Intent intent28=new Intent(v.getContext(),Show40.class);
	intent28.putExtra("He",data);
	startActivity(intent28);
	break;
		
	case 29:
	Show40.j=30;
	Intent intent29=new Intent(v.getContext(),Show40.class);
	intent29.putExtra("He",data);
	startActivity(intent29);
	break;
		
	case 30:
	Show40.j=31;
	Intent intent30=new Intent(v.getContext(),Show40.class);
	intent30.putExtra("He",data);
	startActivity(intent30);
	break;
		
	case 31:
	Show40.j=32;
	Intent intent31=new Intent(v.getContext(),Show40.class);
	intent31.putExtra("He",data);
	startActivity(intent31);
	break;
		
	case 32:
	Show40.j=33;
	Intent intent32=new Intent(v.getContext(),Show40.class);
	intent32.putExtra("He",data);
	startActivity(intent32);
	break;
		
	case 33:
	Show40.j=34;
	Intent intent33=new Intent(v.getContext(),Show40.class);
	intent33.putExtra("He",data);
	startActivity(intent33);
	break;
		
	case 34:
	Show40.j=35;
	Intent intent34=new Intent(v.getContext(),Show40.class);
	intent34.putExtra("He",data);
	startActivity(intent34);
	break;
		
	case 35:
	Show40.j=36;
	Intent intent35=new Intent(v.getContext(),Show40.class);
	intent35.putExtra("He",data);
	startActivity(intent35);
	break;
		
	case 36:
	Show40.j=37;
	Intent intent36=new Intent(v.getContext(),Show40.class);
	intent36.putExtra("He",data);
	startActivity(intent36);
	break;	
	
		}
	}
 
}