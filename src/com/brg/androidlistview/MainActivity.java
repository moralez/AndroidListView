package com.brg.androidlistview;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity { 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// storing string resources into Array
        final String[] fruits = getResources().getStringArray(R.array.fruits);
 
        final ListView list = this.getListView();
        
        // Binding resources Array to ListAdapter
        list.setAdapter(new ArrayAdapter<String>(this, R.layout.list_checkable_relative, 0, fruits) {
        	@Override
        	public View getView(int position, View convertView, ViewGroup parent) {
        		View itemView = null;
        		
        		if (convertView == null) {
        			LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    itemView = inflater.inflate(R.layout.list_checkable_relative, null);
				}
        		
        		// Set the text of the row
                TextView txtId = (TextView) itemView.findViewById(R.id.textView1);
                txtId.setText(fruits[position]);
                
        		return itemView;
        	}
        });
        
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				CheckableRelativeLayout layout = (CheckableRelativeLayout)view;
				TextView textView = (TextView)layout.findViewById(R.id.textView1);
				
				// selected item
	            String fruit = textView.getText().toString();
	            
	            // Launching new Activity on selecting single List Item
	            Intent in = new Intent(getApplicationContext(), SelectedItemActivity.class);
	            
	            // sending data to new activity
	            in.putExtra("fruit", fruit);
//	            startActivity(i);
	            
	            Log.d("JMO", "item clicked");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
