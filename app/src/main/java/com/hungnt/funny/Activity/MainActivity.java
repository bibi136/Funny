package com.hungnt.funny.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.hungnt.funny.Adapter.PictureAdapterGrid;
import com.hungnt.funny.Adapter.PictureAdapterList;
import com.hungnt.funny.Object.NewsObj;
import com.hungnt.funny.R;

import java.util.ArrayList;


public class MainActivity extends Activity {

    public static final String EXTRA_NEWS = "com.hungnt.funny.news";

    private RadioGroup rg_new;
    private RadioGroup rg_grid;

    private GridView gv_picture;
    private ImageView img_menu;

    private TextView tv_time;

    public static ArrayList<NewsObj> listNews = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_grid = (RadioGroup) findViewById(R.id.rg_grid);
        rg_new = (RadioGroup) findViewById(R.id.rg_hotest);
        gv_picture = (GridView) findViewById(R.id.grid_show);
        img_menu = (ImageView) findViewById(R.id.img_menu);
        tv_time = (TextView) findViewById(R.id.tv_time);

        createNews();

        final PictureAdapterList pictureAdapterList = new PictureAdapterList(this.getBaseContext(),listNews);
        final PictureAdapterGrid pictureAdapterGrid = new PictureAdapterGrid(this.getBaseContext(),listNews);

        gv_picture.setAdapter(pictureAdapterList);

        rg_grid.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.rd_btn_list){
                gv_picture.setNumColumns(1);
                gv_picture.setAdapter(pictureAdapterList);
            }
            else{
                gv_picture.setNumColumns(3);
                gv_picture.setAdapter(pictureAdapterGrid);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        gv_picture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ViewPictureActivity.class);
                intent.putExtra(EXTRA_NEWS,position);
                startActivity(intent);
            }
        });
    }

    private void createNews() {
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_1));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_2));
        listNews.add(new NewsObj("Cảnh sát giao thông","Bạn có muốn được em này dừng xe lại kiểm tra không?","2323","11:55 PM,23/2/2014",R.drawable.img_4));
        listNews.add(new NewsObj("Quyến rũ Midu","Cùng ngắm Midu xinh xắn bên hoa Hồ Tây nào!","233","11:55 PM,23/2/2014",R.drawable.img_midu_full));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_6));
        listNews.add(new NewsObj("So pretty!!!","Dau xuan nam moi cung cau nguyen cung em nao","432","11:55 PM,23/2/2014",R.drawable.img_cat));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_dog));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_dog2));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","5454","11:55 PM,23/2/2014",R.drawable.img_monkey));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_6));
        listNews.add(new NewsObj("Dog","My dog so fun!!!","2323","11:44 PM,5/7/2016",R.drawable.img_dog));
        listNews.add(new NewsObj("Quyến rũ Midu","Cùng ngắm Midu xinh xắn bên hoa Hồ Tây nào!","232","11:55 PM,23/2/2014",R.drawable.img_midu_full));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_2));
        listNews.add(new NewsObj("DUDE? OMG","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_1));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","655","11:55 PM,23/2/2014",R.drawable.img_2));
        listNews.add(new NewsObj("Quyến rũ Midu","Cùng ngắm Midu xinh xắn bên hoa Hồ Tây nào!","2323","11:55 PM,23/2/2014",R.drawable.img_midu_full));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","8787","11:55 PM,23/2/2014",R.drawable.img_5));
        listNews.add(new NewsObj("Cảnh sát giao thông","Bạn có muốn được em này dừng xe lại kiểm tra không?","65","11:55 PM,23/2/2014",R.drawable.img_6));
        listNews.add(new NewsObj("Quyến rũ Midu","Cùng ngắm Midu xinh xắn bên hoa Hồ Tây nào!","2323","11:55 PM,23/2/2014",R.drawable.img_midu_full));
        listNews.add(new NewsObj("Dog","My dog so fun!!!","909","11:55 PM,23/2/2014",R.drawable.img_2));
        listNews.add(new NewsObj("Cung cau nguyen nao","Dau xuan nam moi cung cau nguyen cung em nao","2323","11:55 PM,23/2/2014",R.drawable.img_5));
    }


}
