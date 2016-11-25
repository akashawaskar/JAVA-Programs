
package com.expro.akash.programs;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.widget.SimpleAdapter;

public class ListDrawerAdapter extends SimpleAdapter {

	public ListDrawerAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from,int[] to) 
	{ 
		super(context, data, resource, from, to);
	}
}
