package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogWInner.Callback{
private int xOrO = 0;
// 2 is empty state
public int[] state = {2,2,2,2,2,2,2,2,2};
private final int[][] winP = {{0,1,2},{3,4,5},{6,7,8},{1,4,7},{0,4,8},{2,4,6},{0,3,6},{2,5,8},{0,3,6}};
TextView x,o;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = findViewById(R.id.txtXSCORE);
        o = findViewById(R.id.TxtOscore);

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

              DialogWInner dialogWInner = new DialogWInner();
              dialogWInner.show(getSupportFragmentManager(),null);
            }
        }
     
     }
     public void resetGame(){
         ConstraintLayout container = findViewById(R.id.container);
         for (int i = 0; i < container.getChildCount(); i++) {
             if (container.getChildAt(i) instanceof ImageView){
                 ImageView imageView = (ImageView) container.getChildAt(i);
                 if(imageView.getTag()!=null){
                   imageView.setImageDrawable(null);
                 }
             }
         }
     }
     public void resetPos(){
         for (int i = 0; i < state.length; i++) {
             state[i] = 2 ;
         }
     }

    @Override
    public void OnContinueClicked() {
        resetGame();
        resetPos();
        ScoreBoard();

     }

    @Override
    public void onResetClicked() {
    resetPos();
    resetGame();
    x.setText("0");
    o.setText("0");
    }
    public void ScoreBoard(){
        if (xOrO==0){
            int scoreO = Integer.parseInt(o.getText().toString());
            scoreO++;
            o.setText(scoreO+"");
            Toast.makeText(this, "winner o", Toast.LENGTH_SHORT).show();
        }else{
            int scoreX = Integer.parseInt(x.getText().toString());
            scoreX++;
            x.setText(scoreX+"");
            Toast.makeText(this, "winner x", Toast.LENGTH_SHORT).show();
        }
    }
}