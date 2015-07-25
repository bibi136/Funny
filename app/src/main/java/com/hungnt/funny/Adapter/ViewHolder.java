package com.hungnt.funny.Adapter;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HungNT on 19/July/2015.
 */
public class ViewHolder {

    private TextView title;
    private TextView description;
    private TextView downloaded;
    private TextView timeUpload;
    private ImageView img_picture;

    public void setTitle(TextView title) {
        this.title = title;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public void setDownloaded(TextView downloaded) {
        this.downloaded = downloaded;
    }

    public void setTimeUpload(TextView timeUpload) {
        this.timeUpload = timeUpload;
    }

    public void setImg_picture(ImageView img_picture) {
        this.img_picture = img_picture;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getDownloaded() {
        return downloaded;
    }

    public TextView getTimeUpload() {
        return timeUpload;
    }

    public ImageView getImg_picture() {
        return img_picture;
    }
}
