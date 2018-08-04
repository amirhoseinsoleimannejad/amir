package com.example.jalil.mashap.Otherclass;

/**
 * Created by amhso on 21/03/2018.
 */

public class Seller {

    private String id;
    private String nameseller;
    private Product [] p;


    public Seller(String id,String nameseller,Product []p){
        this.id=id;
        this.nameseller=nameseller;
        this.p=p;
    }

    public String getNameseller(){
        return nameseller;
    }



    public Product [] getP(){
        return p;
    }


    public String getId(){
        return this.id;
    }


}
