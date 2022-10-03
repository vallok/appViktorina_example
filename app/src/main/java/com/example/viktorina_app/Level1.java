package com.example.viktorina_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    private Dialog dialog;
    private int numLeft;
    private int numRight;
    private Random random = new Random();
    private Array array = new Array();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView text_level = findViewById(R.id.levels);
        text_level.setText(R.string.level1);

        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);

        final ImageView image_left = findViewById(R.id.img_left);
        image_left.setClipToOutline(true);

        final ImageView image_right = findViewById(R.id.img_right);
        image_right.setClipToOutline(true);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // show the dialog
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // hide the title
        dialog.setContentView(R.layout.preview_dialog); // set view of the dialog
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // set transparent background
        dialog.setCancelable(false);
        //начало обработки нажатия кнопок диалога
        TextView button_close = dialog.findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                обработка нажатия кнопки закрытия диалога Начало
                try{
                    Intent intent = new Intent(Level1.this, GameLevels.class);// создаем наеменение
                    startActivity(intent);// запускаем намерение
                    finish(); //закрываем окноп с уровнем

                }catch (Exception e){

                }
                dialog.dismiss(); // закрываем диалог
//                обработка нажатия кнопки закрития диалога конец
            }
        });

        Button button_continue = dialog.findViewById(R.id.button_continue);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); // close dialog
            }
        });
        //конец обрботки нажатия кнопок диалога
        dialog.show();

        // Click on Back button - start
        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        // Click on Back button - end
        numLeft = random.nextInt(10); //get left number
        image_left.setImageResource(array.images1[numLeft]); // set left image
        text_left.setText(array.texts1[numLeft]);// set left text

        numRight = random.nextInt(10); // generate right number
        while(numLeft == numRight){ // start loop with precondition
            numRight = random.nextInt(10); // generate right number
        }
        image_right.setImageResource(array.images1[numRight]); // set right image
        text_right.setText(array.texts1[numRight]); // set right text

    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}