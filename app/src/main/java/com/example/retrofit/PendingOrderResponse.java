package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PendingOrderResponse {
    @SerializedName("data")
    ArrayList<Data> dataArrayList;

    public PendingOrderResponse() {
    }

    public ArrayList<Data> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    public class Data {
        @SerializedName("details")
        String details;
        @SerializedName("phone")
        String phone;
        ArrayList<photo_order> photo_orderArrayList;

        public Data() {
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public ArrayList<photo_order> getPhoto_orderArrayList() {
            return photo_orderArrayList;
        }

        public void setPhoto_orderArrayList(ArrayList<photo_order> photo_orderArrayList) {
            this.photo_orderArrayList = photo_orderArrayList;
        }

        public class photo_order {

            @SerializedName("photo")
            String photo;

            public photo_order() {
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

    }
}
