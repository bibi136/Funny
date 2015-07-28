package com.hungnt.funny.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.hungnt.funny.Adapter.PictureViewAdapter;
import com.hungnt.funny.Animations.DepthPageTransformer;
import com.hungnt.funny.Dialogs.ShareTweetDialog;
import com.hungnt.funny.Object.NewsObj;
import com.hungnt.funny.R;


public class ViewPictureActivity extends Activity {

    private TextView tvTitle;
    private TextView tvDownloaded;
    //    private ImageView img_picture;
    private ImageView img_back;
    private ViewPager viewPagerPicure;
    public static View layoutTitle, layoutBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);

        img_back = (ImageView) findViewById(R.id.img_back);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDownloaded = (TextView) findViewById(R.id.tv_downloaded);
        viewPagerPicure = (ViewPager) findViewById(R.id.viewpagerPicture);
        layoutBottom = findViewById(R.id.layoutBottom);
        layoutTitle = findViewById(R.id.layoutTitle);

        //Set Animation for ViewPager
        viewPagerPicure.setPageTransformer(true,new DepthPageTransformer());

        //get position
        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_NEWS, 0);

        NewsObj news = MainActivity.listNews.get(position);

        tvTitle.setText(news.getTitle());
        tvDownloaded.setText(news.getDownloaded() + " Downloaded");

        //set adapter
        PictureViewAdapter adapter = new PictureViewAdapter(MainActivity.listNews);
        viewPagerPicure.setAdapter(adapter);
        viewPagerPicure.setCurrentItem(position);

        //setOnclick button Back
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //setOnclick button Share
        findViewById(R.id.btTweet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareTweetDialog dialog = new ShareTweetDialog();
                dialog.show(getFragmentManager(), "sharetw");
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

    public static void changeVisible() {

        if (layoutTitle.getVisibility() == View.GONE) {
            layoutTitle.setAlpha(0f);
            layoutTitle.setVisibility(View.VISIBLE);
            layoutTitle.animate()
                    .alpha(1f)
                    .setDuration(500)
                    .setListener(null);
            layoutBottom.setAlpha(0f);
            layoutBottom.setVisibility(View.VISIBLE);
            layoutBottom.animate()
                    .alpha(1f)
                    .setDuration(500)
                    .setListener(null);

        } else {
            layoutTitle.animate()
                    .alpha(0f)
                    .setDuration(500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            layoutTitle.setVisibility(View.GONE);
                        }
                    });
            layoutBottom.animate()
                    .alpha(0f)
                    .setDuration(500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            layoutBottom.setVisibility(View.GONE);
                        }
                    });
        }
    }


}
