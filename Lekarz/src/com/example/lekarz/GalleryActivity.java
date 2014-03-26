package com.example.lekarz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends Activity{
    ImageView selectedImage; 
    private Integer[] mImageIds = {
               R.drawable.przychodnia1,
               R.drawable.przychodnia2,
               R.drawable.przychodnia3,
               R.drawable.przychodnia4,
               R.drawable.przychodnia5,
       };
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.galleryactivity);
     
            Gallery gallery = (Gallery) findViewById(R.id.gallery1);
       selectedImage=(ImageView)findViewById(R.id.imageView1);
       gallery.setSpacing(1);
       gallery.setAdapter(new GalleryImageAdapter(this));

        // clicklistener for Gallery
       gallery.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			// TODO Auto-generated method stub
			Toast.makeText(GalleryActivity.this, "Your selected position = " + position, Toast.LENGTH_SHORT).show();
            // show the selected Image
            selectedImage.setImageResource(mImageIds[position]);
		}
       });
   }
}
