package com.example.smklabusta.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.smklabusta.R;

public class Adapter extends PagerAdapter {
    Context context;
    CardView card1,card2,card3,card4;

    private int[] images = new int[]{R.drawable.labusta, R.drawable.labusta2};



    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view == object;
    }

    @NonNull

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageview = new ImageView(context);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setImageResource(images[position]);
        container.addView(imageview,0);
        return imageview;
    }

    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull  Object object) {
        container.removeView((ImageView)object);
    }
}
