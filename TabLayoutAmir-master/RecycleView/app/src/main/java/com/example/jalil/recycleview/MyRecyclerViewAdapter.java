package com.example.jalil.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private  List<Item> jalil;
    private List<Integer> mViewColors;
    private List<String> mAnimals;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<Integer> colors, List<Item> animals) {
        this.mInflater = LayoutInflater.from(context);
        this.mViewColors = colors;
        this.jalil = animals;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        int color = mViewColors.get(position);
        String animal = jalil.get(position).getuName();
        String anima2 = jalil.get(position).getuMessage();
        String anima3=  jalil.get(position).getuTime();
        int anim5=jalil.get(position).getuAvatar();

        holder.aAvatar.setImageResource(anim5);
        holder.aName.setText(animal);
        holder.aMessage.setText(anima2);
        holder.aTime.setText(anima3);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return jalil.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View myView;


        ImageView aAvatar;
        TextView aName;
         TextView aMessage;
        TextView aTime;

        ViewHolder(View itemView) {
            super(itemView);
            aAvatar =(ImageView) itemView.findViewById(R.id.img_avatar);
            aName =(TextView) itemView.findViewById(R.id.txt_name);
            aMessage =(TextView) itemView.findViewById(R.id.txt_message);
            aTime =(TextView) itemView.findViewById(R.id.txt_time);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mAnimals.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
