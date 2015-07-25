package com.hungnt.funny.Object;

/**
 * Created by HungNT on 19/July/2015.
 */
public class NewsObj {


    private String title;
    private String description;
    private String downloaded;
    private String timeUpload;
    private int picture;

    public NewsObj(String title, String description, String downloaded, String timeUpload, int picture) {
        this.title = title;
        this.description = description;
        this.downloaded = downloaded;
        this.timeUpload = timeUpload;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDownloaded() {
        return downloaded;
    }

    public String getTimeUpload() {
        return timeUpload;
    }

    public int getPicture() {
        return picture;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDownloaded(String downloaded) {
        this.downloaded = downloaded;
    }

}

