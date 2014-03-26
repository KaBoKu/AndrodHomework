package com.example.lekarz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorViewActivity extends Activity{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorview);
        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
        Button button = (Button)findViewById(R.id.DoctorViewbutton1);
        TextView nameTextView = (TextView)findViewById(R.id.DoctorViewtextView2);
        TextView surnameTextView = (TextView) findViewById(R.id.DoctorViewtextView4);
        
        final SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(this);
        
        
        
        
        Bundle extras = getIntent().getExtras();
        
        String string = extras.get("doctor").toString();
        nameTextView.setText(string);
        if(string.equals("Stomatolog")){
        	String tmp = preferences.getString(string, null);
        	String arrrayString []= tmp.split(" ");
        	nameTextView.setText(arrrayString[0]);
        	surnameTextView.setText(arrrayString[1]);
        	imageView.setImageResource(R.drawable.stomatolog);
        }
        if(string.equals("Kardiolog")){
        	String tmp = preferences.getString(string, null);
        	String arrrayString []= tmp.split(" ");
        	nameTextView.setText(arrrayString[0]);
        	surnameTextView.setText(arrrayString[1]);
        	imageView.setImageResource(R.drawable.kardiolog);
        }
        if(string.equals("Lekarz rodzinny")){
        	String tmp = preferences.getString(string, null);
        	String arrrayString []= tmp.split(" ");
        	nameTextView.setText(arrrayString[0]);
        	surnameTextView.setText(arrrayString[1]);
        	imageView.setImageResource(R.drawable.doge);
        }
        if(string.equals("Anestezjolog")){
        	String tmp = preferences.getString(string, null);
        	String arrrayString []= tmp.split(" ");
        	nameTextView.setText(arrrayString[0]);
        	surnameTextView.setText(arrrayString[1]);
        	imageView.setImageResource(R.drawable.anestezjolog);
        }
        button.setOnClickListener(new OnClickListener() {
        	
       
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				finish();
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
public class TestImages extends Activity {
    /** Called when the activity is first created. */
/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView image = (ImageView) findViewById(R.id.test_image);
        Bitmap bMap = BitmapFactory.decodeFile("/sdcard/test2.png");
        image.setImageBitmap(bMap);
    }
}




InputStream bitmap=null;

try {
    bitmap=getAssets().open("logo.png");
    Bitmap bit=BitmapFactory.decodeStream(bitmap);
    img.setImageBitmap(bit);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if(bitmap!=null)
    bitmap.close();
}
*/