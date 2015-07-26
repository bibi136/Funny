package com.hungnt.funny.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hungnt.funny.Adapter.PictureViewAdapter;
import com.hungnt.funny.Object.NewsObj;
import com.hungnt.funny.R;


public class ViewPictureActivity extends Activity {

    private TextView tvTitle;
    private TextView tvDownloaded;
//    private ImageView img_picture;
    private ImageView img_back;
    private ViewPager viewPagerPicure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);

        img_back = (ImageView) findViewById(R.id.img_back);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDownloaded = (TextView) findViewById(R.id.tv_downloaded);
//        img_picture = (ImageView) findViewById(R.id.img_picture);
        viewPagerPicure = (ViewPager) findViewById(R.id.viewpagerPicture);

        //get position
        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_NEWS, 0);

        NewsObj news;
        news = MainActivity.listNews.get(position);

        tvTitle.setText(news.getTitle());
        tvDownloaded.setText(news.getDownloaded() + " Downloaded");
//        img_picture.setImageResource(news.getPicture());

        //set adapter
        PictureViewAdapter adapter = new PictureViewAdapter(ViewPictureActivity.this, MainActivity.listNews);
        viewPagerPicure.setAdapter(adapter);

        //setOnclick button Back
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewPagerPicure.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                NewsObj news = MainActivity.listNews.get(position);
                tvTitle.setText(news.getTitle());
                tvDownloaded.setText(news.getDownloaded() + " Downloaded");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
