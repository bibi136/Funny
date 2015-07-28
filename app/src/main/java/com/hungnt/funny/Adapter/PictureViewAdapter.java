package com.hungnt.funny.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hungnt.funny.Activity.ViewPictureActivity;
import com.hungnt.funny.Object.NewsObj;
import com.hungnt.funny.Tools.TouchImageView;

import java.util.ArrayList;

/**
 * Created by HungNT on 26/July/2015.
 */
public class PictureViewAdapter extends PagerAdapter {

//    Context context;
    private ArrayList<NewsObj> listNews;

    public PictureViewAdapter(ArrayList<NewsObj> listNews) {
//        this.context = context;
        this.listNews = listNews;
    }

    @Override
    public int getCount() {
        return listNews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TouchImageView view = new TouchImageView(container.getContext());
        view.setImageResource(listNews.get(position).getPicture());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPictureActivity.changeVisible();
            }
        });
        container.addView(view, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
