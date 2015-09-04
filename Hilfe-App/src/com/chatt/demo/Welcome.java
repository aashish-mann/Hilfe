package com.chatt.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chatt.demo.custom.CustomActivity;
import com.chatt.demo.utils.Utils;

public class Welcome extends CustomActivity{

	private String username;
	private String password;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		Intent intent=getIntent();
		username=intent.getStringExtra("username");
		password=intent.getStringExtra("password");
	//	Toast.makeText(getApplicationContext(), "Welcome "+username, Toast.LENGTH_LONG).show();
		TextView textView=(TextView)findViewById(R.id.textView1);
		textView.setText("Hi "+username);
		setTouchNClick(R.id.buttonConsumer);
		setTouchNClick(R.id.buttonProducer);
	
	}
	public void onClick(View v)
	{
		
		super.onClick(v);
		if (v.getId() == R.id.buttonConsumer)
		{

			if(username.startsWith("customer")){
				Intent intent=new Intent(getApplicationContext(), CustomerHome.class);
				intent.putExtra("username", username);
				intent.putExtra("password", password);
				startActivityForResult(intent, 1);
			}else{
				Utils.showDialog(
						Welcome.this,
						"Sorry you are not registered as Consumer");
			}
			
		}
		else{
			if(username.startsWith("producer")){
			Intent intent=new Intent(getApplicationContext(), ProducerHome.class);
			intent.putExtra("username", username);
			intent.putExtra("password", password);
			startActivityForResult(intent, 1);
			}
			else{
				Utils.showDialog(
						Welcome.this,
						"Sorry you are not registered as Producer");
			}
		}
	}
}
