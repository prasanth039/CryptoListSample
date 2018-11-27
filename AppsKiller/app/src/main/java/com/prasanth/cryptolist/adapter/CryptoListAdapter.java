package com.prasanth.cryptolist.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prasanth.cryptolist.R;
import com.prasanth.cryptolist.datamodel.CryptoCurrency;
import com.prasanth.cryptolist.datamodel.CryptoSet;

import java.util.LinkedList;

public class CryptoListAdapter extends RecyclerView.Adapter<CryptoListAdapter.AppViewHolder> {

    private static final String TAG = CryptoListAdapter.class.getSimpleName();

    private CryptoSet cryptoSet;

    public void setCryptoSet(CryptoSet cryptoSet) {
        this.cryptoSet = cryptoSet;
    }

    @NonNull
    @Override
    public CryptoListAdapter.AppViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
                                                              int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.app_list_row, viewGroup, false);
        return new AppViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoListAdapter.AppViewHolder appViewHolder,
                                 int i) {
        appViewHolder.bind(new LinkedList<>(cryptoSet.getData().values()).get(i));
    }

    @Override
    public int getItemCount() {
        return cryptoSet == null ? 0 : cryptoSet.getData().size();
    }

    class AppViewHolder extends RecyclerView.ViewHolder {

        private TextView appTextView;
        private ImageView appImageView;
        private TextView currentValue;

        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
            appImageView = itemView.findViewById(R.id.app_icon_view);
            appTextView = itemView.findViewById(R.id.app_name_view);
            currentValue = itemView.findViewById(R.id.app_price);
        }

        public void bind(CryptoCurrency info) {
            appTextView.setText(info.getName());
            //currentValue.setText(Long.toString(new LinkedList<>(info.getQuotes().values()).get(0).getPrice()));
        }
    }
}
