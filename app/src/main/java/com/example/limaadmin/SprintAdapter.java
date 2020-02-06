package com.example.limaadmin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SprintAdapter extends RecyclerView.Adapter<SprintAdapter.SprintViewHolder> {
    private Context mContext;
    private ArrayList<SprintItem> mSprintList;

    public SprintAdapter(Context context, ArrayList<SprintItem> sprintList){
        mContext = context;
        mSprintList = sprintList;
    }

    @NonNull
    @Override
    public SprintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.sprint_item, parent, false);
        return new SprintViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SprintViewHolder holder, int position) {
        SprintItem currentItem = mSprintList.get(position);

        final String sprint = currentItem.getSprint();
        String tanggal = currentItem.getTanggal();
        String kelompok = currentItem.getKelompok();

        holder.mTextViewSprint.setText(sprint);
        holder.mTextViewTanggal.setText(tanggal);
        holder.mTextViewKelompok.setText(kelompok);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TertinggiUser.class);
                intent.putExtra("sprint", sprint);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSprintList.size();
    }

    public class SprintViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewSprint;
        public TextView mTextViewTanggal;
        public TextView mTextViewKelompok;
        public Button parentLayout;

        public SprintViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewSprint = itemView.findViewById(R.id.textViewSprint);
            mTextViewTanggal = itemView.findViewById(R.id.textViewTanggal);
            mTextViewKelompok = itemView.findViewById(R.id.textViewKelompok);
            parentLayout = itemView.findViewById(R.id.buttonDetails);
        }
    }
}