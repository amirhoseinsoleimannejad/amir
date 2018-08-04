package com.example.amhso.meshope.Otherclass;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.amhso.meshope.AllproductjalilActivity;
import com.example.amhso.meshope.R;
import com.example.amhso.meshope.adapter.MyPagerAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class SellerAdapter extends ArrayAdapter<Seller> {

    private Context mContext;
    private List<Seller> listnameseller = new ArrayList<>();


    public SellerAdapter(@NonNull Context context, @LayoutRes ArrayList<Seller> list) {
        super(context, 0 ,list);
        mContext = context;
        listnameseller = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        MyWrapper wrapper = null;



        if(listItem == null){

            listItem = LayoutInflater.from(mContext).inflate(R.layout.listviewseller,parent,false);
            wrapper = new MyWrapper (listItem);
            listItem.setTag(wrapper);

        }
        else{
            wrapper = (MyWrapper) listItem.getTag();
        }





//            com.jude.rollviewpager.RollPagerView mRollViewPager=(com.jude.rollviewpager.RollPagerView) listItem.findViewById(R.id.baner);
            wrapper.getPagerbaner().setAdapter(new TestLoopAdapter(wrapper.getPagerbaner()));






        String getnameseller = listnameseller.get(position).getNameseller();

//        TextView name = (TextView) listItem.findViewById(R.id.nameseller);
        wrapper.getName().setText(getnameseller);



//       PagerContainer mContainer = (PagerContainer) listItem.findViewById(R.id.pager_container);


        ViewPager pager = wrapper.getPC().getViewPager();
//        ViewPager pager = (ViewPager)G.activity.findViewById(R.id.viewpager);
        PagerAdapter adapter = new MyPagerAdapter(listnameseller.get(position).getP());
        pager.setAdapter(adapter);

        pager.setOffscreenPageLimit(adapter.getCount());

//        pager.setPadding(10,10,10,10);



//        TextView allproduct = (TextView) listItem.findViewById(R.id.allproductseller);
//        allproduct.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                Log.i("ppppp", "ppppppppppppppppppppppp"+position2);
//                Intent i = new Intent(G.activity, AllproductActivity.class);
//                i.putExtra("id_seller", listnameseller.get(position2).getId());
//                G.activity.startActivity(i);
//                G.activity.overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);
//
//            }
//        });


        wrapper.getButton().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                View parentRow = (View) v.getParent().getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);


                Log.i("ppppp", "ppppppppppppppppppppppp"+position);
                Intent i = new Intent(G.activity, AllproductjalilActivity.class);
                i.putExtra("id_seller", listnameseller.get(position).getId());
                G.activity.startActivity(i);
                G.activity.overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);
            }
        });



        pager.setClipChildren(false);






        return listItem;
    }


    private class NullAdapter extends LoopPagerAdapter {
        private int[] imgs = {


        };

        public NullAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }



    private class TestLoopAdapter extends LoopPagerAdapter {
        private int[] imgs = {
                R.drawable.slide1,
                R.drawable.slide2,
                R.drawable.slide3,

        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }





    class MyWrapper
    {
        private View base;
        private TextView allproduct;
        private TextView name;
        com.jude.rollviewpager.RollPagerView mRollViewPager;
        private PagerContainer pc;
        public MyWrapper(View base)
        {
            this.base = base;
        }

        public TextView getButton()
        {
            if (allproduct == null)
            {
                allproduct = (TextView) base.findViewById(R.id.allproductseller);
            }
            return (allproduct);
        }

        public com.jude.rollviewpager.RollPagerView getPagerbaner()
        {
            if (mRollViewPager == null)
            {
                mRollViewPager = (com.jude.rollviewpager.RollPagerView) base.findViewById(R.id.baner);
            }
            return (mRollViewPager);
        }


        public TextView getName(){

            if(name == null){
                 name = (TextView) base.findViewById(R.id.nameseller);
            }

            return name;
        }



        public PagerContainer getPC(){


            if(pc == null){
                pc =(PagerContainer) base.findViewById(R.id.pager_container);
            }

            return pc;



        }
    }


}





