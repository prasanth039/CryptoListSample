package com.prasanth.cryptolist.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prasanth.cryptolist.R;
import com.prasanth.cryptolist.adapter.PostsListAdapter;
import com.prasanth.cryptolist.datamodel.Post;
import com.prasanth.cryptolist.viewmodel.PostsListViewModel;

import java.util.List;


public class LocalActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostsListAdapter adapter;
    private PostsListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        initList();
        initViewModel();
    }

    private void initList() {
        recyclerView = findViewById(R.id.posts_view);
        adapter = new PostsListAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(LocalActivity.this).get(PostsListViewModel.class);
        viewModel.getPosts().observe(this, new Observer<List<Post>>() {
                    @Override
                    public void onChanged(@Nullable List<Post> posts) {
                        adapter.setPostList(posts);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }
}
