package com.hungnt.funny.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hungnt.funny.Object.NewsObj;
import com.hungnt.funny.R;

import java.util.ArrayList;

/**
 * Created by HungNT on 26/July/2015.
 */
public class PictureViewAdapter extends PagerAdapter{

    Context context;
    private ArrayList<NewsObj> listNews;

    public PictureViewAdapter(Context context, ArrayList<NewsObj> listNews) {
        this.context = context;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_viewpager_picture,container,false);
        ImageView imgPicture = (ImageView) view.findViewById(R.id.imgPictures);
        imgPicture.setImageResource(listNews.get(position).getPicture());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
