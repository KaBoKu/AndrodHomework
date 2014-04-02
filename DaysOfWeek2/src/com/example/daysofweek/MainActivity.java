package com.example.daysofweek;

import java.util.LinkedList;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	SharedPreferences preferences;
	Editor editor;

	Button nextButton;
	EditText loginEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nextButton = (Button) findViewById(R.id.button1);
		loginEditText = (EditText) findViewById(R.id.editText1);
		
		preferences = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());

		editor = preferences.edit();

		
		
		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (loginEditText.getText().toString().matches("[a-zA-Z0-9]+")) {

					Intent intent = new Intent(getApplicationContext(),
							ComputeActivity.class);
					intent.putExtra("login", loginEditText.getText().toString());
					startActivity(intent);
				} else {
					Animation shake = AnimationUtils.loadAnimation(
							getApplicationContext(), R.anim.shake);
					loginEditText.startAnimation(shake);
					loginEditText.setError(getString(R.string.bad_login));
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		if (savedInstanceState != null)
			savedInstanceState.putString("loginValue", loginEditText.getText()
					.toString());
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		if (savedInstanceState != null)
			loginEditText.setText(savedInstanceState.getString("loginValue",
					"brak"));
	}*/
}
