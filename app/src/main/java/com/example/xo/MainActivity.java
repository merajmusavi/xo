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
private final int[] winP1 = {0,1,2};
private final int[] winP2 = {3,4,5};
private final int[] winP3 = {6,7,8};

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
     if (state[winP1[0]]==state[winP1[1]] && state[winP1[0]]==state[winP1[2]] && state[0]!=2){
         Toast.makeText(this,"win",Toast.LENGTH_SHORT).show();
     }
     }
}