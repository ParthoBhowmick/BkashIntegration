package com.example.bkath;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.asksira.loopingviewpager.LoopingPagerAdapter;
import com.asksira.loopingviewpager.LoopingViewPager;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerDemo extends AppCompatActivity {

    private LoopingViewPager pager = null;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        ArrayList<Integer> itemList = new ArrayList<>();


        itemList.add(R.drawable.jadroo);
        itemList.add(R.drawable.home);
        itemList.add(R.drawable.gsk);
        itemList.add(R.drawable.cbl);
        itemList.add(R.drawable.uni);
        itemList.add(R.drawable.harvest);
        itemList.add(R.drawable.multi);


        pager = findViewById(R.id.pager);
        pager.setAdapter(new SampleAdapter(this, itemList, true));
        //pager.setOffscreenPageLimit(6);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                Log.d("cur page", "onPageScrolled: " + position);

                if(position==6) {
                    counter++;
                    if(counter>3) pager.setCurrentItem(1);
                }
                if(position==0) {
                    counter = 0;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class SampleAdapter extends LoopingPagerAdapter<Integer> {

        public SampleAdapter(Context context, List<Integer> itemList, boolean isInfinite) {
            super(context, itemList, isInfinite);
        }

        //This method will be triggered if the item View has not been inflated before.
        @Override
        protected View inflateView(int viewType, ViewGroup container, int listPosition) {
            return LayoutInflater.from(context).inflate(R.layout.single_page, container, false);
        }

        //Bind your data with your item View here.
        //Below is just an example in the demo app.
        //You can assume convertView will not be null here.
        //You may also consider using a ViewHolder pattern.
        @Override
        protected void bindView(View convertView, final int listPosition, int viewType) {
            final ImageView img = convertView.findViewById(R.id.sample_img);

            Glide.with(context).load(getResources().getDrawable(itemList.get(listPosition))).into(img);

            //img.setImageDrawable(getResources().getDrawable(itemList.get(listPosition)));
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ViewPagerDemo.this, listPosition+"", Toast.LENGTH_LONG)
                            .show();
                }
            });
//            Glide.with(context).load(itemList.get(listPosition)).transition(DrawableTransitionOptions.withCrossFade()).fitCenter()
//                    .format(DecodeFormat.PREFER_RGB_565).into(img);
        }

        @Override
        public float getPageWidth(int position) {
            return 0.4f;
        }


    }

//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            View page=
//                    getLayoutInflater().inflate(R.layout.single_page, container, false);
//            TextView tv=page.findViewById(R.id.text);
//            int blue=position * 25;
//
//            final String msg=
//                    String.format(getString(R.string.item), position + 1);
//
//            tv.setText(msg);
//            tv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(ViewPagerDemo.this, msg, Toast.LENGTH_LONG)
//                            .show();
//                }
//            });
//
//            page.setBackgroundColor(Color.argb(255, 150, 0, blue));
//            container.addView(page);
//
//            return(page);
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position,
//                                Object object) {
//            container.removeView((View)object);
//        }
//
//        @Override
//        public int getCount() {
//            return(9);
//        }
//

//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return(view == object);
//        }
//    }

}
