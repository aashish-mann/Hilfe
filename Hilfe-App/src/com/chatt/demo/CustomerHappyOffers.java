package com.chatt.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.chatt.demo.custom.CustomActivity;

public class CustomerHappyOffers extends CustomActivity{

	private String username;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customer_services);

		Intent intent=getIntent();
		username=intent.getStringExtra("username");
		Toast.makeText(getApplicationContext(), "Welcome to customer activity page", Toast.LENGTH_LONG).show();
		setTouchNClick(R.id.buttonServices);
	
		
	}
}
