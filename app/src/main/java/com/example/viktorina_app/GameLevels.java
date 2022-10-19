package com.example.viktorina_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);

        SharedPreferences save = getSharedPreferences("SAVE", MODE_PRIVATE);
        final int level = save.getInt("LEVEL", 1);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AppCompatButton button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch(Exception e){

                }
            }
        });

        // Button level 1 start
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level >= 1) {
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        startActivity(intent);
                    }else{
                        // empty
                    }
                }catch (Exception e){
                    //empty
                }
            }
        });
        //button Level 1 end

        // Button level 2 start
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level >= 2) {
                        Intent intent = new Intent(GameLevels.this, Level2.class);
                        startActivity(intent);
                    }else{
                        //empty
                    }
                }catch (Exception e){
                    //empty
                }
            }
        });
        //button Level 2 end

        // Button level 3 start
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level >= 3) {
                        Intent intent = new Intent(GameLevels.this, Level3.class);
                        startActivity(intent);
                    }else{
                        //empty
                    }
                }catch (Exception e){
                    //empty
                }
            }
        });
        //button Level 3 end


        // Button level 4 start
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (level >= 4) {
                        Intent intent = new Intent(GameLevels.this, Level4.class);
                        startActivity(intent);
                    }else{
                        //empty
                    }
                }catch (Exception e){
                    //empty
                }
            }
        });
        //button Level 4 end



        final int[] x = {
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
                R.id.textView9,
                R.id.textView10,
                R.id.textView11,
                R.id.textView12,
                R.id.textView13,
                R.id.textView14,
                R.id.textView15,
                R.id.textView16,
                R.id.textView17,
                R.id.textView18,
                R.id.textView19,
                R.id.textView20,
                R.id.textView21,
                R.id.textView22,
                R.id.textView23,
                R.id.textView24,
                R.id.textView25,
                R.id.textView26,
                R.id.textView27,
                R.id.textView28,
                R.id.textView29,
                R.id.textView30,

        };

        for (int i = 1; i < level; i++){
            TextView textView = findViewById(x[i]);
            textView.setText(String.valueOf(i + 1));
        }

    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        }catch(Exception e){

        }
    }
}