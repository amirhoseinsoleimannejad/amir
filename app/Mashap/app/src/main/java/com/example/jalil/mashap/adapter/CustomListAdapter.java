package com.example.jalil.mashap.adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amhso.meshope.Otherclass.Product;
import com.example.amhso.meshope.R;

public class CustomListAdapter extends ArrayAdapter<Product> {

    private final Activity context;
    private final Product[] itemname;

    public CustomListAdapter(Activity context, Product[] itemname) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position].getNameprodct());

        extratxt.setText("Description "+itemname[position].getNameprodct());
        return rowView;

    };
}
