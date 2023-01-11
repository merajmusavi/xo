package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private int xOrO = 0;
// 2 is empty state
private int[] state = {2,2,2,2,2,2,2,2,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onImageClick(View view){
     ImageView imageView = (ImageView) view;
     int tag_save = Integer.parseInt(imageView.getTag().toString());
     state[tag_save] = xOrO;
     imageView.setTranslationY(-1500);
     if (xOrO==0){
         imageView.setImageResource(R.drawable.x);
          xOrO = 1;
     }else{
         imageView.setImageResource(R.drawable.oo);
         xOrO = 0;

     }
     imageView.animate().translationYBy(1500).rotation(3600).setDuration(400);
     }
}