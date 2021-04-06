package com.example.imageprogramatically;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


       List<String> list = new ArrayList<>();
       list.add("https://images.financialexpress.com/2020/06/Google.jpg");
       list.add("https://images.financialexpress.com/2020/06/Google.jpg");
       list.add("https://images.financialexpress.com/2020/06/Google.jpg");


        for (int i = 0; i < list.size() ; i++) {
           linearLayout = findViewById(R.id.rootContainer);
            final ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
            // Add ImageView to LinearLayout
            if (linearLayout != null) {
                linearLayout.addView(imageView);
            }

            Glide.with(this)
                    .load(list.get(i))
                    .transform(new FitCenter(),new RoundedCorners(15))
                    .into(imageView);

        }





//        final ImageView imageView = new ImageView(this);
//        imageView.setLayoutParams(new LinearLayout.LayoutParams(160, 160)); // value is in pixels
//
//        final Integer imgResId = R.drawable.ic_launcher_background;
//        final Integer[] resId = {imgResId};
//        imageView.setImageResource(imgResId);
//
//        Button button = findViewById(R.id.button);
//        if (button != null) {
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    resId[0] = (resId[0] == R.drawable.ic_launcher_background) ? R.mipmap.ic_launcher : R.drawable.ic_launcher_background;
//                    imageView.setImageResource(resId[0]);
//                }
//            });
//        }

//        LinearLayout linearLayout = findViewById(R.id.rootContainer);
//        // Add ImageView to LinearLayout
//        if (linearLayout != null) {
//            linearLayout.addView(imageView);
//        }

    }
}