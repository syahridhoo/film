package com.example.aplikasiwisatatalabricked;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aplikasiwisatatalabricked.model.WisataItem;

import java.util.ArrayList;

public class AdapterListWisata extends RecyclerView.Adapter<AdapterListWisata.ViewHolder> {
    private ArrayList<WisataItem> mWisataData;
    private Context mContext;

    public AdapterListWisata(ArrayList<WisataItem> mWisataData, Context mContext) {
        this.mWisataData = mWisataData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.itemlist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.namaWisata.setText(mWisataData.get(position).getNama());
        Glide.with(mContext)
                .load(mWisataData
                .get(position)
                .getGambarUrl())
                .into(holder.gambarWisata);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("namaWisata", mWisataData.get(position).getNama());
                intent.putExtra("kategori", mWisataData.get(position).getKategori());
                intent.putExtra("gambarWisata", mWisataData.get(position).getGambarUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWisataData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView namaWisata;
        private ImageView gambarWisata;
        private LinearLayout item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaWisata = itemView.findViewById(R.id.namaWisata);
            gambarWisata = itemView.findViewById(R.id.gambarWisata);
            item = itemView.findViewById(R.id.list_item);
        }
    }
}