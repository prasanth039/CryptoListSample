package com.prasanth.cryptolist.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prasanth.cryptolist.R;
import com.prasanth.cryptolist.datamodel.Post;

import java.util.List;

public class PostsListAdapter extends
        RecyclerView.Adapter<PostsListAdapter.PostViewHolder> {

    private List<Post> postList;

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_list_item, viewGroup, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        postViewHolder.postTextVew.setText(postList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        if (postList != null) {
            return postList.size();
        }
        return 0;
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView postTextVew;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postTextVew = itemView.findViewById(R.id.post_item);
        }
    }
}
