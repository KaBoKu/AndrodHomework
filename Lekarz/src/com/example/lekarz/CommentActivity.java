package com.example.lekarz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CommentActivity extends Activity{
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.commentactivity);
	        Button button=(Button)findViewById(R.id.Commentbutton1);
	        button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent =	new Intent(getApplicationContext(),EndActivity.class);
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
