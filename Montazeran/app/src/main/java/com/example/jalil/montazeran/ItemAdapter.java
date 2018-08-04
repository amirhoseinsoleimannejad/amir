package com.example.jalil.montazeran;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{
    List<Item>itemList;

    public ItemAdapter(List<Item> itemList, Context mContext) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    Context mContext;



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View aView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_item,parent,false);
        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Item aItem=itemList.get(position);
        holder.aAvatar.setImageResource(aItem.getuAvatar());
        holder.aName.setText(aItem.getuName());
        holder.aMessage.setText(aItem.getuMessage());
        holder.aTime.setText(aItem.getuTime());
        holder.aItem.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Item: "+ position, Toast.LENGTH_SHORT).show() ; }
        }) ;

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }






    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar;
        public TextView aName;
        public TextView aMessage;
        public TextView aTime;

        public LinearLayout aItem;
        public MyViewHolder(View itemView) {
            super(itemView);

            aAvatar =(ImageView) itemView.findViewById(R.id.img_avatar);
            aName =(TextView) itemView.findViewById(R.id.txt_name);
            aMessage =(TextView) itemView.findViewById(R.id.txt_message);
            aTime =(TextView) itemView.findViewById(R.id.txt_time);
            aItem= itemView.findViewById(R.id.item_layout);
        }

    }}