package com.hungnt.funny.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hungnt.funny.Object.NewsObj;
import com.hungnt.funny.R;
import com.hungnt.funny.Tools.ResizeBitmap;

import java.util.ArrayList;

/**
 * Created by HungNT on 19/July/2015.
 */
public class PictureAdapterList extends BaseAdapter {

    private Context context;
    private ArrayList<NewsObj> listNews;


    public PictureAdapterList(Context context, ArrayList<NewsObj> listNews) {
        this.context = context;
        this.listNews = listNews;
    }

    @Override
    public int getCount() {
        return listNews.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder viewHolder;
//        Bitmap bm;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
//            bm = BitmapFactory.decodeResource(context.getResources(),listNews.get(position).getPicture());
//            view = new View(context);
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, parent, false);
            viewHolder.setDescription((TextView) view.findViewById(R.id.tv_description));
            viewHolder.setDownloaded((TextView) view.findViewById(R.id.tv_downloaded));
            viewHolder.setTimeUpload((TextView) view.findViewById(R.id.tv_timeupload));
            viewHolder.setTitle((TextView) view.findViewById(R.id.tv_title));
            viewHolder.setImg_picture((ImageView) view.findViewById(R.id.img_picture));
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

//        bm = BitmapFactory.decodeResource(context.getResources(),listNews.get(position).getPicture());
        viewHolder.getDescription().setText(listNews.get(position).getDescription());
        viewHolder.getTimeUpload().setText(listNews.get(position).getTimeUpload());
        viewHolder.getTitle().setText(listNews.get(position).getTitle());
        viewHolder.getDownloaded().setText(listNews.get(position).getDownloaded());
        viewHolder.getImg_picture().setImageBitmap(
                ResizeBitmap.decodeSampledBitmapFromResource(context.getResources(), listNews.get(position).getPicture(), 100, 100));

        return view;
    }


}
