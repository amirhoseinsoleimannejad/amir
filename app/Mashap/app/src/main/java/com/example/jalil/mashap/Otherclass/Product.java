package com.example.jalil.mashap.Otherclass;

import android.support.annotation.Nullable;

/**
 * Created by amhso on 21/03/2018.
 */

public class Product {

    private String id;
    private String nameprodct;
    private String image;
    private String price;

    public Product(String id, String nameprodct, @Nullable String price,String image){
        this.id=id;
        this.nameprodct=nameprodct;
        this.image=image;
        this.price=price;
    }

    public String getImage(){
        return this.image;
    }

    public String getNameprodct(){
        return this.nameprodct;
    }

    public String getId(){
        return this.id;
    }
}
