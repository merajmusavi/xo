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
private final int[] winP1 = {0,1,2};
private final int[] winP2 = {3,4,5};
private final int[] winP3 = {6,7,8};
private final int[] winP4 = {0,4,8};
private final int[] winP5 = {2,4,6};
private final int[] winP6 = {0,3,6};
private final int[] winP7 = {2,5,8};
private final int[] winP8 = {0,3,6};


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
     }else if (state[winP2[0]]==state[winP2[1]] && state[winP2[0]]==state[winP2[2]] && state[3]!=2){
         Toast.makeText(this, "win", Toast.LENGTH_SHORT).show();
     }else if (state[winP3[0]]==state[winP3[1]]&& state[winP3[0]]==state[winP3[2]] && state[6]!=2){
         Toast.makeText(this, "win", Toast.LENGTH_SHORT).show();
     }else if (state[winP4[0]]==state[winP4[1]] && state[winP4[0]]==state[winP4[2]] && state[4]!=2){
         Toast.makeText(this, "win", Toast.LENGTH_SHORT).show();
     }else if (state[winP5[0]]==state[winP5[1]] && state[winP5[0]]==state[winP5[2]] && state[4]!=2){
         Toast.makeText(this, "win", Toast.LENGTH_SHORT).show();
     }else if(state[winP6[0]]==state[winP6[1]] && state[winP6[0]]==state[winP6[2]] && state[3]!=2){
         Toast.makeText(this, "win", Toast.LENGTH_SHORT).show();
     }else if (state[winP7[0]]==state[winP7[1]] && state[winP7[0]]==state[winP7[2]] && state[5]!=2){
         Toast.makeText(this, "win", Toast.LENGTH_SHORT).show();
     }else if (state[winP8[0]]==state[winP8[1]] && state[winP8[0]]==state[winP8[2]] && state[3]!=2){
            Toast.makeText(this, "win", Toast.LENGTH_SHORT).show();
     }
     
     }
}