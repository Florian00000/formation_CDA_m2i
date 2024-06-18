package org.example.exercice7.model;

public class Image {

    private String imgName;
    private String urlImg;

    public Image(String imgName, String urlImg) {
        this.imgName = imgName;
        this.urlImg = urlImg;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
