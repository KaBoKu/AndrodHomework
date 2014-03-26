package com.example.lekarz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endactivity);
		Button button = (Button) findViewById(R.id.Endbutton1);

		Button button2 = (Button) findViewById(R.id.Endbutton2);
		
		TextView summary = (TextView)findViewById(R.id.EndtextView1);
		
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		final SharedPreferences.Editor editor = sharedPreferences.edit();
		
		String medic = sharedPreferences.getString("Medic", null);
		String from = sharedPreferences.getString("From", "brak");
		String to = sharedPreferences.getString("To", "brak");
		String comment = sharedPreferences.getString("Comment", "brak");
		String firstTime = "Pierwszy raz: ";
		if (sharedPreferences.getBoolean("FirstTime", false))
			firstTime = firstTime + "tak";
		else
			firstTime = firstTime + "nie";
		
		String summaryEnd =  "Lekarz: "+medic+"\n"+"Od: "+from+"\n"+
		"Do: "+to+"\n"+"Komentarz: "+comment+"\n"+firstTime;
		
		summary.setText(summaryEnd);
		
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				editor.clear();
				editor.commit();
				startActivity(intent);
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Wysy³am :P", 3000)
						.show();
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
