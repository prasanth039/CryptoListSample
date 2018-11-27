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
import com.prasanth.cryptolist.adapter.CryptoListAdapter;
import com.prasanth.cryptolist.datamodel.CryptoSet;
import com.prasanth.cryptolist.viewmodel.CryptoListViewModel;

public class CryptoListActivity extends AppCompatActivity {

    private CryptoListViewModel viewModel;
    private RecyclerView recyclerView;
    private CryptoListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_list);
        initViewModel();
        initList();
    }

    private void initList() {
        recyclerView = findViewById(R.id.apps_view);
        adapter = new CryptoListAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(CryptoListViewModel.class);
        viewModel.getCryptoList().observe(this, new Observer<CryptoSet>() {
            @Override
            public void onChanged(@Nullable CryptoSet cryptoSet) {
                adapter.setCryptoSet(cryptoSet);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
