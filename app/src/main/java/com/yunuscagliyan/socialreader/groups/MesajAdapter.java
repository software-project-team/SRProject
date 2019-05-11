package com.yunuscagliyan.socialreader.groups;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yunuscagliyan.socialreader.R;

import java.util.List;


public class MesajAdapter extends RecyclerView.Adapter<MesajAdapter.ViewHolder> {

        Context context;
        List<MesajModel> list;
        Activity activity;
        String grup;
        Boolean state;
        int view_send =1 , view_received=2;

    public MesajAdapter(Context context, List<MesajModel> list, Activity activity, String grup) {
        this.context = context;
        this.list = list;
        this.activity = activity;
        this.grup = grup;
        state = false;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View view ;
       if(viewType == view_send) {
              view = LayoutInflater.from(context).inflate(R.layout.send_layout,viewGroup,false);
        return new ViewHolder(view);
    }else{
           view = LayoutInflater.from(context).inflate(R.layout.received_layout,viewGroup,false);
           return new ViewHolder(view);
       }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder Holder, final int position) {
    Holder.textView.setText(list.get(position).getText().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{


        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

                textView=itemView.findViewById(R.id.received_textview);


        }
    }

}
