package com.example.limaadmin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TertinggiUserAdapter extends RecyclerView.Adapter<TertinggiUserAdapter.TertinggiUserViewHolder> {
    private Context mContext;
    private ArrayList<TertinggiUserItem> mTertinggiUserList;

    public TertinggiUserAdapter(Context context, ArrayList<TertinggiUserItem> tertinggiUserList){
        mContext = context;
        mTertinggiUserList = tertinggiUserList;
    }

    @NonNull
    @Override
    public TertinggiUserAdapter.TertinggiUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.tertinggi_user_item, parent, false);
        return new TertinggiUserAdapter.TertinggiUserViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull TertinggiUserAdapter.TertinggiUserViewHolder holder, int position) {
        TertinggiUserItem currentItem = mTertinggiUserList.get(position);

        String kelompok = currentItem.getKelompok();
        String nama = currentItem.getNama();
        String sprint = currentItem.getSprint();
        String jam_mulai = currentItem.getJamMulai();
        String jam_akhir = currentItem.getJamAkhir();
        String nilai = currentItem.getNilai();

        holder.mTextViewKel.setText(kelompok);
        holder.mTextViewNama.setText(nama);
        holder.mTextViewSprint.setText(sprint);
        holder.mTextViewJamMulai.setText(jam_mulai);
        holder.mTextViewJamAkhir.setText(jam_akhir);
        holder.mTextViewNilai.setText(nilai);
    }

    @Override
    public int getItemCount() {
        return mTertinggiUserList.size();
    }

    public class TertinggiUserViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewKel;
        public TextView mTextViewNama;
        public TextView mTextViewSprint;
        public TextView mTextViewJamMulai;
        public TextView mTextViewJamAkhir;
        public TextView mTextViewNilai;

        public TertinggiUserViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewKel = itemView.findViewById(R.id.textViewKel);
            mTextViewNama = itemView.findViewById(R.id.textViewNama);
            mTextViewSprint = itemView.findViewById(R.id.textViewSprint);
            mTextViewJamMulai = itemView.findViewById(R.id.textViewJamMulai);
            mTextViewJamAkhir = itemView.findViewById(R.id.textViewJamAkhir);
            mTextViewNilai = itemView.findViewById(R.id.textViewNilai);


        }
    }
}
