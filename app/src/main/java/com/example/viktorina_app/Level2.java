package com.example.viktorina_app;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    private Dialog dialog;
    private int numLeft;
    private int numRight;
    private final Random random = new Random();
    private final Array array = new Array();
    public int counter = 0; // counter for true answers

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

        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4,  R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20
        };

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // init animation
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);

        // show the dialog
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // hide the title
        dialog.setContentView(R.layout.preview_dialog); // set view of the dialog
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // set transparent background
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT); // set transparent background
        dialog.setCancelable(false);
        ImageView previewImage = dialog.findViewById(R.id.preview_img);
        previewImage.setImageResource(R.drawable.preview_img_two);

        TextView description = dialog.findViewById(R.id.text_description);
        description.setText(R.string.level_two);

        //начало обработки нажатия кнопок диалога
        TextView button_close = dialog.findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                обработка нажатия кнопки закрытия диалога Начало
                try{
                    Intent intent = new Intent(Level2.this, GameLevels.class);// создаем наеменение
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
                    Intent intent = new Intent(Level2.this, GameLevels.class);
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


        // set on TouchListener for image left
        image_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    image_right.setEnabled(false); // block the right image
                    if (numLeft > numRight) {
                        image_left.setImageResource(R.drawable.img_true);
                    }else{
                        image_left.setImageResource(R.drawable.img_false);
                    }
                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (numLeft > numRight){
                        if (counter < 20) {
                            counter = counter + 1;
                        }

                        for (int i = 0; i < 20; i++){
                            TextView textView = findViewById(progress[i]);
                            textView.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < counter; i++){
                            TextView textView = findViewById(progress[i]);
                            textView.setBackgroundResource(R.drawable.style_points_green);
                        }


                    }else{
                        if (counter > 0){
                            if (counter == 1){
                                counter = 0;
                            }else{
                                counter = counter - 2;
                            }
                        }

                        for (int i = 0; i < 19; i++){
                            TextView textView = findViewById(progress[i]);
                            textView.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < counter; i++){
                            TextView textView = findViewById(progress[i]);
                            textView.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }

                    if (counter == 20){
                        // EXIT FROM LEVEL 1
                    }else{
                        numLeft = random.nextInt(10); //get left number
                        image_left.setImageResource(array.images1[numLeft]); // set left image
                        image_left.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]);// set left text

                        numRight = random.nextInt(10); // generate right number
                        while(numLeft == numRight){ // start loop with precondition
                            numRight = random.nextInt(10); // generate right number
                        }
                        image_right.setImageResource(array.images1[numRight]); // set right image
                        image_right.startAnimation(a);
                        text_right.setText(array.texts1[numRight]); // set right text

                        image_right.setEnabled(true);
                    }

                }
                return true;
            }
        });


        // set on TouchListener for image right
        image_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    image_left.setEnabled(false); // block the right image
                    if (numLeft < numRight) {
                        image_right.setImageResource(R.drawable.img_true);
                    }else{
                        image_right.setImageResource(R.drawable.img_false);
                    }
                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (numLeft < numRight){
                        if (counter < 20) {
                            counter = counter + 1;
                        }

                        for (int i = 0; i < 20; i++){
                            TextView textView = findViewById(progress[i]);
                            textView.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < counter; i++){
                            TextView textView = findViewById(progress[i]);
                            textView.setBackgroundResource(R.drawable.style_points_green);
                        }


                    }else{
                        if (counter > 0){
                            if (counter == 1){
                                counter = 0;
                            }else{
                                counter = counter - 2;
                            }
                        }

                        for (int i = 0; i < 19; i++){
                            TextView textView = findViewById(progress[i]);
                            textView.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < counter; i++){
                            TextView textView = findViewById(progress[i]);
                            textView.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }

                    if (counter == 20){
                        // EXIT FROM LEVEL 1
                    }else{
                        numLeft = random.nextInt(10); //get left number
                        image_left.setImageResource(array.images1[numLeft]); // set left image
                        image_left.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]);// set left text

                        numRight = random.nextInt(10); // generate right number
                        while(numLeft == numRight){ // start loop with precondition
                            numRight = random.nextInt(10); // generate right number
                        }
                        image_right.setImageResource(array.images1[numRight]); // set right image
                        image_right.startAnimation(a);
                        text_right.setText(array.texts1[numRight]); // set right text

                        image_left.setEnabled(true);
                    }

                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level2.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}