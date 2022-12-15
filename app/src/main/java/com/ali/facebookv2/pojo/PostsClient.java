package com.ali.facebookv2.pojo;

import com.ali.facebookv2.data.PostsModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private PostsInterface postsInterface;
    private static PostsClient instance;

    public PostsClient() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        postsInterface=retrofit.create(PostsInterface.class);
    }

    public static PostsClient getInstance() {
        if(null==instance){
            instance=new PostsClient();
        }
        return instance;
    }

    public Observable<ArrayList<PostsModel>> getPosts(){
       return postsInterface.getPosts();
    }
}
