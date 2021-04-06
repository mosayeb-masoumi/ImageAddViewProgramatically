package com.example.imageprogramatically;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    LinearLayout linearLayout_parent;

    LinearLayout[] LinLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        List<String> list = new ArrayList<>();
        list.add("https://images.financialexpress.com/2020/06/Google.jpg");
        list.add("https://images.financialexpress.com/2020/06/Google.jpg");


        for (int i = 0; i < 3; i++) {

            linearLayout_parent = findViewById(R.id.linearLayout_parent);
            final LinearLayout LinLayout = new LinearLayout(this);
            LinLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//            LinLayout.setPadding(10,0,10,0);
            LinLayout.setOrientation(LinearLayout.HORIZONTAL);

            linearLayout_parent.addView(LinLayout);

            for (int j = 0; j < list.size(); j++) {


                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = displayMetrics.widthPixels;
                int originalWidth= width/2;


                final ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(originalWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
                imageView.setPadding(10,10,10,10);
                // Add ImageView to LinearLayout
                if (LinLayout != null) {
                    LinLayout.addView(imageView);
                }

                Glide.with(this)
                        .load(list.get(j))
                        .transform(new FitCenter(), new RoundedCorners(15))
                        .into(imageView);


            }
        }
    }
}