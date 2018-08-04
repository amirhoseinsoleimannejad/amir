package com.example.amhso.meshope.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amhso.meshope.AllproductjalilActivity;
import com.example.amhso.meshope.DetailproductActivity;
import com.example.amhso.meshope.Otherclass.G;
import com.example.amhso.meshope.Otherclass.Product;
import com.example.amhso.meshope.R;

/**
 * Created by amhso on 19/03/2018.
 */

 public class MyPagerAdapter extends PagerAdapter {

     Product product[];
     LayoutInflater inflater;


     public MyPagerAdapter(Product product[]){
         this.product=product;
     }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        inflater = (LayoutInflater) G.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.product_pageview, container, false);



       TextView name_product = (TextView) itemView.findViewById(R.id.name_product);

       name_product.setText(product[position].getNameprodct());

        ImageView image_product = (ImageView) itemView.findViewById(R.id.image_product);
        image_product.setImageResource(R.drawable.tshert);


        TextView someTextView = (TextView) itemView.findViewById(R.id.price);
        someTextView.setText("$29,500");
        someTextView.setPaintFlags(someTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        TextView detail = (TextView) itemView.findViewById(R.id.detail);
        detail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(G.activity, AllproductjalilActivity.class);
                i.putExtra("id_product", product[position].getId());
                G.activity.overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);
                G.activity.startActivity(i);
            }
        });





        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return product.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}