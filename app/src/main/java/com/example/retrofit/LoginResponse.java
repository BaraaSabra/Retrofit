package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("data")
    public Data data;
    @SerializedName("token")
  public String token;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse() {
    }




   public class Data {
       @SerializedName("token")
        String token;

       public String getToken() {
           return token;
       }

       public void setToken(String token) {
           this.token = token;
       }
   }
}
