package com.brg.androidlistview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class SelectedItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_item);
        
        TextView txtProduct = (TextView) findViewById(R.id.fruit_selected);
 
        Intent i = getIntent();
        
        // getting attached intent data
        String fruit = i.getStringExtra("fruit");
        
        // displaying selected product name
        txtProduct.setText(fruit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selected_item, menu);
		return true;
	}

}
