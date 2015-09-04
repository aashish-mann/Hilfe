package com.chatt.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chatt.demo.custom.CustomActivity;

public class CustomerHome extends CustomActivity{

	private String username;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customer_home);
		
		Intent intent=getIntent();
		username=intent.getStringExtra("username");
		Toast.makeText(getApplicationContext(), "Welcome "+username, Toast.LENGTH_LONG).show();
		TextView textView=(TextView)findViewById(R.id.textView1);
		textView.setText("Hi "+username);
		
		setTouchNClick(R.id.buttonServices);
	
		
	}
	public void onClick(View v)
	{
		
		super.onClick(v);
		if (v.getId() == R.id.buttonServices)
		{

			Intent intent=new Intent(getApplicationContext(), CustomerServices.class);
			intent.putExtra("username", username);
			startActivityForResult(intent, 1);			
		}else{
			Intent intent=new Intent(getApplicationContext(), CustomerHappyOffers.class);
			intent.putExtra("username", username);
			startActivityForResult(intent, 1);
		}
			
		
	}
}
