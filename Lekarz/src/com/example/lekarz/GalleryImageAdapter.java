package com.example.lekarz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryImageAdapter extends BaseAdapter
{
    private Context mContext;

    private Integer[] mImageIds = {
    		 R.drawable.przychodnia1,
             R.drawable.przychodnia2,
             R.drawable.przychodnia3,
             R.drawable.przychodnia4,
             R.drawable.przychodnia5,
    };

    public GalleryImageAdapter(Context context)
    {
        mContext = context;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup)
    {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);

        i.setImageResource(mImageIds[index]);
        i.setLayoutParams(new Gallery.LayoutParams(200, 200));
   
        i.setScaleType(ImageView.ScaleType.FIT_XY);

        return i;
    }
}