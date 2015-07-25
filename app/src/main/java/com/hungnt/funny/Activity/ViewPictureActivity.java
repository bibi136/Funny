package com.hungnt.funny.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hungnt.funny.Object.NewsObj;
import com.hungnt.funny.R;


public class ViewPictureActivity extends Activity {
    
    private TextView tvTitle;
    private TextView tvDownloaded;
    private ImageView img_picture;
    private ImageView img_back;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);

        img_back = (ImageView) findViewById(R.id.img_back);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDownloaded = (TextView) findViewById(R.id.tv_downloaded);
        img_picture = (ImageView) findViewById(R.id.img_picture);

        Intent intent = getIntent();

        int position = intent.getIntExtra(MainActivity.EXTRA_NEWS,0);

        NewsObj news = MainActivity.listNews.get(position);

        tvTitle.setText(news.getTitle());
        tvDownloaded.setText(news.getDownloaded()+" Downloaded");
        img_picture.setImageResource(news.getPicture());

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
