package com.itheima.phonerecorder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button btn =(Button) findViewById(R.id.btn_call);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	public void start(View v) {
		
		Intent service = new Intent(getApplicationContext(),RecordService.class);
		startService(service);
	}

	public void stop(View v) {

	}

}
