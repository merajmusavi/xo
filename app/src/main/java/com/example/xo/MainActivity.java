package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private int xOrO = 0;
// 2 is empty state
public int[] state = {2,2,2,2,2,2,2,2,2};
private final int[][] winP = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{2,5,8},{0,3,6}};





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
        for (int[] winPosition : winP) {
            if (state[winPosition[0]]==state[winPosition[1]] && state[winPosition[0]]==state[winPosition[2]] && state[winPosition[0]]!=2){
                Toast.makeText(this, "WIN", Toast.LENGTH_SHORT).show();
            }
        }
     
     }
}