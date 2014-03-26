package com.example.lekarz;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		Button button3 = (Button) findViewById(R.id.button3);
		final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		final CheckBox checkBox = (CheckBox) findViewById(R.id.chkIos);
		final SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		final SharedPreferences.Editor editor = preferences.edit();
		
		
		
		
		editor.putString("Stomatolog", "Krzysztof Miejski");
		editor.putString("Kardiolog", "Adrian Kêpa");
		editor.putString("Anestezjolog", "Maciej Saski");
		editor.putString("Lekarz rodzinny", "Piese³ Piesejski");
		
		editor.commit();
		
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						DataActivity.class);

				editor.putString("Medic", spinner.getSelectedItem().toString());
				editor.putBoolean("FirstTime", checkBox.isChecked());
				editor.commit();

				startActivity(intent);
				overridePendingTransition(R.anim.activityanimationin,
						R.anim.activityanimationout);

			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						DoctorViewActivity.class);
				intent.putExtra("doctor", spinner.getSelectedItem().toString());
				startActivity(intent);

			}
		});
		
		
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
