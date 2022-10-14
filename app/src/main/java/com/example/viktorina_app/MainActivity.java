package com.example.viktorina_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long timeBackPressed;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton button_start = findViewById(R.id.buttonStart);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this, GameLevels.class);
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
        if (timeBackPressed + 2000 > System.currentTimeMillis()){
            toast.cancel();
            finish();
        }else{
            toast = Toast.makeText(getBaseContext(), "Кликните еще раз, чтобы выйти", Toast.LENGTH_LONG);
            toast.show();
        }

            timeBackPressed = System.currentTimeMillis();

    }

    //End BackEnd clicked
}