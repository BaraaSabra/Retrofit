package com.example.retrofit;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServier {

  @GET("Video/videosList?category_id=1")

  Call<Videos> getVideos();
  @FormUrlEncoded
  @POST("Auth/login")
    Call <LoginResponse> LoginResponse(@Field("os") String os,
    @Field("version")String version
    , @Field("os_version")String os_version,
    @Field("device_token")String device_token,
   @Field("device_id") String device_id,
   @Field("username")String username,
 @Field("password")String password,
@Field("user_type")String user_type);


  @DELETE("Auth/logout")
    Call <Void> logout();
    class Retrofitclass{
      static   String  BasrUrl="https://stgapiphp7.ireadarabic.com/en/";
        public static ApiServier getRetrofitInstance(){
            Retrofit retrofit=new Retrofit.Builder().baseUrl(BasrUrl).addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiServier.class);
        }
    }
}
