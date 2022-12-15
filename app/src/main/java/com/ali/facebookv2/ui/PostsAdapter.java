package com.ali.facebookv2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ali.facebookv2.data.PostsModel;
import com.ali.facebookv2.databinding.PostsLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private ArrayList<PostsModel> models=new ArrayList<>();

    public PostsAdapter() {
    }

    public PostsAdapter(ArrayList<PostsModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostsLayoutBinding binding=PostsLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(models.get(position).getTitle()!=null){

            holder.layoutBinding.postsTitle.setText(models.get(position).getTitle());
            holder.layoutBinding.postsBody.setText(models.get(position).getBody());
            holder.layoutBinding.postsId.setText(models.get(position).getUserId()+"");
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void  setList(ArrayList<PostsModel> list){
        this.models=list;
        notifyDataSetChanged();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        PostsLayoutBinding layoutBinding;
        public ViewHolder(@NonNull PostsLayoutBinding binding) {
            super(binding.getRoot());
            layoutBinding=binding;
        }
    }
}
