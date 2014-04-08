package com.example.daysofweek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

import com.example.daysofweek.R.id;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.Toast;

public class ComputeActivity extends Activity {

	TextView date1;
	TextView date2;
	TextView date3;
	TextView date4;
	TextView date5;
	Button compute;
	LinkedList<String> dataList;
	HashMap<String, LinkedList<String>> dataMap;
	List textVList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compiute_activity);
		dataMap = new HashMap<String, LinkedList<String>>();
		this.setTitle(getIntent().getExtras().getString("login"));

		Button back = (Button) findViewById(R.id.button2);
		compute = (Button) findViewById(R.id.button1);

		date1 = (TextView) findViewById(R.id.dateText1);
		date2 = (TextView) findViewById(R.id.dateText2);
		date3 = (TextView) findViewById(R.id.dateText3);
		date4 = (TextView) findViewById(R.id.dateText4);
		date5 = (TextView) findViewById(R.id.dateText5);
		textVList = new ArrayList<TextView>();

		textVList.add(date1);
		textVList.add(date2);
		textVList.add(date3);
		textVList.add(date4);
		textVList.add(date5);

		FileInputStream fin;
		Bundle bundle = getIntent().getExtras();
		bundle.get("login");

		final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
		datePicker.init(datePicker.getYear(), datePicker.getMonth(),
				datePicker.getDayOfMonth(), new OnDateChangedListener() {

					@Override
					public void onDateChanged(DatePicker arg0, int arg1,
							int arg2, int arg3) {
						// TODO Auto-generated method stub
						compute.setEnabled(true);
					}
				});

		dataList = new LinkedList<String>();

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intent);
				finish();
			}
		});

		compute.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar date = Calendar.getInstance();
				date.set(datePicker.getYear(), datePicker.getMonth(),
						datePicker.getDayOfMonth());

				Locale locale = new Locale("pl", "PL");
				SimpleDateFormat sf = new SimpleDateFormat(
						"yyyy-dd-MM : EEEEEEEE", Locale.getDefault());

				if (dataList.size() == 5) {
					dataList.remove(0);
					dataList.addFirst(sf.format(date.getTime()));
					((TextView) textVList.get(4)).setText("Wielkoœæ "
							+ dataList.size());
				} else
					dataList.addFirst(sf.format(date.getTime()));

				for (int i = 0; i < dataList.size(); ++i) {

					((TextView) textVList.get(i)).setText(

					(String) dataList.get(i));
				}
				Bundle bundle = getIntent().getExtras();
				;
				dataMap.put((String) bundle.get("login"), dataList);
				compute.setEnabled(false);
			}
		});
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putBoolean("enabled", compute.isEnabled());
		savedInstanceState.putString("date1", date1.getText().toString());
		savedInstanceState.putString("date2", date2.getText().toString());
		savedInstanceState.putString("date3", date3.getText().toString());
		savedInstanceState.putString("date4", date4.getText().toString());
		savedInstanceState.putString("date5", date5.getText().toString());

		savedInstanceState.putSerializable("StateOfDataList", dataList);

		if (dataList.size() > 0 && dataList.get(0) != null)
			savedInstanceState.putString("dataList0", dataList.get(0));

		if (dataList.size() > 1 && dataList.get(1) != null)
			savedInstanceState.putString("dataList1", dataList.get(1));
		if (dataList.size() > 2 && dataList.get(2) != null)
			savedInstanceState.putString("dataList2", dataList.get(2));
		if (dataList.size() > 3 && dataList.get(3) != null)
			savedInstanceState.putString("dataList3", dataList.get(3));
		if (dataList.size() > 4 && dataList.get(4) != null)
			savedInstanceState.putString("dataList4", dataList.get(4)); // etc.
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState); // Restore UI state
		// from the savedInstanceState. // This bundle has also been passed to
		// onCreate.
		if (savedInstanceState != null) {
			compute.setEnabled(savedInstanceState.getBoolean("enabled"));
			date1.setText(savedInstanceState.getString("date1"));
			date2.setText(savedInstanceState.getString("date2"));
			date3.setText(savedInstanceState.getString("date3"));
			date4.setText(savedInstanceState.getString("date4"));
			date5.setText(savedInstanceState.getString("date5"));
			dataList = (LinkedList<String>) savedInstanceState
					.getSerializable("StateOfDataList"); //
			// dataList.addAll(collection);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();

		try {
			storePoints(dataMap);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onResume() {
		super.onResume();

		try {
			dataMap = getStoredPoints();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		date1 = (TextView) findViewById(R.id.dateText1);
		date2 = (TextView) findViewById(R.id.dateText2);
		date3 = (TextView) findViewById(R.id.dateText3);
		date4 = (TextView) findViewById(R.id.dateText4);
		date5 = (TextView) findViewById(R.id.dateText5);

		if (dataMap != null) {
			getIntent().getExtras().get("login");
			if (dataMap.get(getIntent().getExtras().get("login")) != null) {
				Toast.makeText(this, "Witaj ponownie", 3000).show();
				dataList = dataMap.get(getIntent().getExtras().get("login"));
				date1.setText(getIntent().getExtras().get("login").toString());
				if (dataList != null)
					date2.setText("Nie ma nula");
				if (dataList.size() > 0 && dataList.get(0) != null)
					date1.setText(dataList.get(0));
				if (dataList.size() > 1 && dataList.get(1) != null)
					date2.setText(dataList.get(1));
				if (dataList.size() > 2 && dataList.get(2) != null)
					date3.setText(dataList.get(2));
				if (dataList.size() > 3 && dataList.get(3) != null)
					date4.setText(dataList.get(3));
				if (dataList.size() > 4 && dataList.get(4) != null)
					date5.setText(dataList.get(4));
			}
		}
	}

	private void storePoints(HashMap<String, LinkedList<String>> list)
			throws IOException {
		FileOutputStream fos = openFileOutput("mapaDat", Context.MODE_PRIVATE);
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(list);
		os.close();

	}

	@SuppressWarnings("unchecked")
	private HashMap<String, LinkedList<String>> getStoredPoints()
			throws IOException, ClassNotFoundException {
		HashMap<String, LinkedList<String>> storedList = new HashMap<String, LinkedList<String>>();
		FileInputStream fis = openFileInput("mapaDat");
		ObjectInputStream is = new ObjectInputStream(fis);

		storedList = (HashMap<String, LinkedList<String>>) is.readObject();
		is.close();
		return storedList;
	}
}
