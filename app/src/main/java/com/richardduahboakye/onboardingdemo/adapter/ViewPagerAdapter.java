package com.richardduahboakye.onboardingdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.richardduahboakye.onboardingdemo.R;


public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;


    //    parameterized constructor for context
    public ViewPagerAdapter(Context context) {

        this.context = context;
    }


    //    init and define values of arrays\ of viewpager item views
    int[] images = {R.drawable.car_sharing_service, R.drawable.onboarding1, R.drawable.pngwing, R.drawable.pngwing_1};

    int[] headings = {R.string.heading, R.string.heading1, R.string.heading2, R.string.heading3};

    int[] desc = {R.string.desc, R.string.desc1, R.string.desc2, R.string.desc3};

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

//        inflate viewpager_layout on container
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewpager_layout, container, false);


//        set the hooks or initiate items in viewpager_layout
        ImageView imageView = view.findViewById(R.id.slider_imageView);
        TextView title = view.findViewById(R.id.slider_heading);
        TextView description = view.findViewById(R.id.slider_description);


//        set view items to their specified arrays and positions of items
        imageView.setImageResource(images[position]);
        title.setText(headings[position]);
        description.setText(desc[position]);

        //add view containing viewpager_layout to container which is to contain views
        container.addView(view);


        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout) object);

    }

}
