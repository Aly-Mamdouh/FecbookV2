package com.ali.facebookv2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.ali.facebookv2.R;
import com.ali.facebookv2.data.PostsModel;
import com.ali.facebookv2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PostsViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel=new ViewModelProvider(this).get(PostsViewModel.class);
        viewModel.getPosts();
        PostsAdapter adapter=new PostsAdapter();
        binding.mainRv.setLayoutManager(new LinearLayoutManager(this));
        binding.mainRv.setAdapter(adapter);
        viewModel.liveData.observe(this, new Observer<ArrayList<PostsModel>>() {
            @Override
            public void onChanged(ArrayList<PostsModel> postsModels) {
                adapter.setList(postsModels);
            }
        });
    }
}