package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Videos {
    ArrayList<VediosData> VediosData;

    public ArrayList<VediosData> getUserDataArrayList() {
        return VediosData;
    }

    public void setUserDataArrayList(ArrayList<VediosData> VediosData) {
        this.VediosData = VediosData;
    }

  public class VediosData {
@SerializedName("discription")
        String discription;
@SerializedName("video_cover_image")
        String video_cover_image;
@SerializedName("video_status")
        String video_status;

        public String getDiscription() {
            return discription;
        }

        public void setDiscription(String discription) {
            this.discription = discription;
        }

        public String getVideo_cover_image() {
            return video_cover_image;
        }

        public void setVideo_cover_image(String video_cover_image) {
            this.video_cover_image = video_cover_image;
        }

        public String getVideo_status() {
            return video_status;
        }

        public void setVideo_status(String video_status) {
            this.video_status = video_status;
        }


  }
}
