package com.example.viktorina_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Finish extends AppCompatActivity {

    private long timeBackPressed;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);
        AppCompatButton button_start = findViewById(R.id.button_finish_back);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Finish.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    // Start BackEnd clicked

    @Override
    public void onBackPressed() {
        try{
            Intent intent = new Intent(Finish.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //End BackEnd clicked
}