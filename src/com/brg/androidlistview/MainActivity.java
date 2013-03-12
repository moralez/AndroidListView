package com.brg.androidlistview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// storing string resources into Array
        String[] fruits = getResources().getStringArray(R.array.fruits);
 
        final ListView list = this.getListView();
        
        // Binding resources Array to ListAdapter
        list.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, fruits));
        
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				CheckableTextView textView = (CheckableTextView)view;
				// selected item
	            String fruit = textView.getText().toString();
	            
	            // Launching new Activity on selecting single List Item
	            Intent in = new Intent(getApplicationContext(), SelectedItemActivity.class);
	            
	            // sending data to new activity
	            in.putExtra("fruit", fruit);
//	            startActivity(i);
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
