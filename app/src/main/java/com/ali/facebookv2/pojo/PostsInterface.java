package com.ali.facebookv2.pojo;

import com.ali.facebookv2.data.PostsModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {
    @GET("posts")
    public Observable<ArrayList<PostsModel>> getPosts();

}
