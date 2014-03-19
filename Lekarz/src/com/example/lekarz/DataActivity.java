package com.example.lekarz;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DataActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dataactivity);
		Button button = (Button) findViewById(R.id.Databutton1);
		
		final EditText editText1 = (EditText) findViewById(R.id.DataeditText1);
		final EditText editText2 = (EditText) findViewById(R.id.DataeditText2);
		int mYear, mMonth, mDay;

		Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		editText1.setText(new StringBuilder().append(mDay).append("/")
				.append(mMonth + 1).append("/").append(mYear));

		final SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(this);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						CommentActivity.class);

				SharedPreferences.Editor editor = preferences.edit();

				editor.putString("From", editText1.getText().toString());
				editor.putString("To", editText2.getText().toString());
				editor.commit();

				startActivity(intent);
				overridePendingTransition(R.anim.activityanimationin,R.anim.activityanimationout);
			}
		});
		
		
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.activityanimationin,
				R.anim.activityanimationout);
	}
}


/*
package com.example.lekarz;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DataActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endactivity);
		Button button = (Button) findViewById(R.id.button1);
		
		final EditText editText1 = (EditText) findViewById(R.id.);
		final EditText editText2 = (EditText) findViewById(R.id.editText1);
		int mYear, mMonth, mDay;

		Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		editText1.setText(new StringBuilder().append(mDay).append("/")
				.append(mMonth + 1).append("/").append(mYear));

		final SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(this);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						CommentActivity.class);

				SharedPreferences.Editor editor = preferences.edit();

				editor.putString("From", editText1.getText().toString());
				editor.putString("To", editText2.getText().toString());
				editor.commit();

				startActivity(intent);
				overridePendingTransition(R.anim.activityanimationin,R.anim.activityanimationout);
			}
		});
		
		
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.activityanimationin,
				R.anim.activityanimationout);
	}
}
*/