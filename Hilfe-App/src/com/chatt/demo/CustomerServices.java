package com.chatt.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.chatt.demo.custom.CustomActivity;
import com.google.android.maps.Overlay.Snappable;

public class CustomerServices extends CustomActivity implements OnItemSelectedListener{

	private String username;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customer_services);

		Intent intent=getIntent();
		username=intent.getStringExtra("username");
		Toast.makeText(getApplicationContext(), "Welcome to customer services", Toast.LENGTH_LONG).show();
		
		Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
		
		String[] items = new String[]{"Food", "Electrician", "Painter","Plumber"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);
		dropdown.setOnItemSelectedListener(this);
		
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		 switch (position) {
		 
         case 0:
     		Toast.makeText(getApplicationContext(), "Food", Toast.LENGTH_SHORT).show();
     		Spinner type=(Spinner)findViewById(R.id.typeOfFood);
     		String[] types = new String[]{"Veg", "Non-Veg", "Both"};
     		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
     		type.setAdapter(adapter);
            break;
         case 1:
        	 Toast.makeText(getApplicationContext(), "Electrician", Toast.LENGTH_SHORT).show();
             break;
         case 2:
             // Whatever you want to happen when the thrid item gets selected
             break;

     }
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
