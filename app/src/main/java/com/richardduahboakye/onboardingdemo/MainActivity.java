package com.richardduahboakye.onboardingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.richardduahboakye.onboardingdemo.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    View viewBlack, viewWhite;
    LinearLayout dotsLayout;
    Button SignInButton, SignUpButton, skipButton;
    MaterialCardView nextCardView;
    ViewPagerAdapter viewPagerAdapter;
    int currentPosition;
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);


        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        dotsLayout = findViewById(R.id.dots_layout);
        SignInButton = findViewById(R.id.sign_in);
        SignUpButton = findViewById(R.id.sign_up);
        skipButton = findViewById(R.id.skip);
        nextCardView = findViewById(R.id.next_cardView);
        viewBlack = findViewById(R.id.view_black);
        viewWhite = findViewById(R.id.view_white);

        viewPager = findViewById(R.id.view_pager);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);



        viewPager.addOnPageChangeListener(changeListener);

        addDots(0);

    }

    private void addDots(int position) {

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i ++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226; "));
            dots[i].setTextColor(getResources().getColor(R.color.black));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {

            dots[position].setTextColor(getResources().getColor(R.color.blue1));
        }



    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

             currentPosition = position;

             addDots(position);


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    public void skip(View view) {

        if (currentPosition == 0) {
            viewPager.setCurrentItem(currentPosition + 3);

        }else if (currentPosition == 1) {
            viewPager.setCurrentItem(currentPosition +2);
        }else if (currentPosition == 2) {
            viewPager.setCurrentItem(currentPosition +1);
        }
    }

    public void next(View view) {

        viewPager.setCurrentItem(currentPosition +1);
    }
}