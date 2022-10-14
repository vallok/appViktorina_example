package com.example.viktorina_app;

import android.annotation.SuppressLint;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3 extends AppCompatActivity {

    private Dialog dialog;
    private Dialog dialogEnd;
    private int numLeft;
    private int numRight;
    private final Random random = new Random();
    private final Array array = new Array();
    public int counter = 0; // counter for true answers

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        ImageView bg = findViewById(R.id.imageView2);
        bg.setImageResource(R.drawable.level3);


        TextView text_level = findViewById(R.id.levels);
        text_level.setTextColor(R.color.black95);
        text_level.setText(R.string.level3);

        final TextView text_left = findViewById(R.id.text_left);
        text_left.setTextColor(R.color.black95);
        final TextView text_right = findViewById(R.id.text_right);
        text_right.setTextColor(R.color.black95);

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
        final Animation a = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);

        // show the dialog
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // hide the title
        dialog.setContentView(R.layout.preview_dialog); // set view of the dialog
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // set transparent background
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT); // set transparent background
        dialog.setCancelable(false);
        ImageView previewImage = dialog.findViewById(R.id.preview_img);
        previewImage.setImageResource(R.drawable.preview_img3);

        LinearLayout layout = dialog.findViewById(R.id.dialog_fon);
        layout.setBackgroundResource(R.drawable.dialog_bg3);

        TextView description = dialog.findViewById(R.id.text_description);
        description.setText(R.string.level_three);

        //начало обработки нажатия кнопок диалога
        TextView button_close = dialog.findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                обработка нажатия кнопки закрытия диалога Начало
                try{
                    Intent intent = new Intent(Level3.this, GameLevels.class);// создаем наеменение
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

        // ______________________________________

        // show the dialog
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // hide the title
        dialogEnd.setContentView(R.layout.dialog_level_one_end); // set view of the dialog
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // set transparent background
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);
        //начало обработки нажатия кнопок диалога
        TextView button_close2 = dialogEnd.findViewById(R.id.button_close);
        button_close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                обработка нажатия кнопки закрытия диалога Начало
                try{
                    Intent intent = new Intent(Level3.this, GameLevels.class);// создаем наеменение
                    startActivity(intent);// запускаем намерение
                    finish(); //закрываем окноп с уровнем

                }catch (Exception e){

                }
                dialogEnd.dismiss(); // закрываем диалог
//                обработка нажатия кнопки закрития диалога конец
            }
        });

        Button button_continue2 = dialogEnd.findViewById(R.id.button_continue);
        button_continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Level3.this, Level3.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    // nothing to do
                }
                dialogEnd.dismiss(); // close dialog
            }
        });

        TextView textDescriptionEnd = dialogEnd.findViewById(R.id.text_description);
        textDescriptionEnd.setText(R.string.level_two_end);
        // ____________________________________


        // Click on Back button - start
        Button button_back = findViewById(R.id.button_back);
        button_back.setBackgroundResource(R.drawable.button_black95_press_white);
        button_back.setTextColor(R.color.black95);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        // Click on Back button - end
        numLeft = random.nextInt(21); //get left number
        image_left.setImageResource(array.images3[numLeft]); // set left image
        text_left.setText(array.texts3[numLeft]);// set left text

        numRight = random.nextInt(21); // generate right number
        while(numLeft == numRight){ // start loop with precondition
            numRight = random.nextInt(21); // generate right number
        }
        image_right.setImageResource(array.images3[numRight]); // set right image
        text_right.setText(array.texts3[numRight]); // set right text


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
                        // EXIT FROM LEVEL 2
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(21); //get left number
                        image_left.setImageResource(array.images3[numLeft]); // set left image
                        image_left.startAnimation(a);
                        text_left.setText(array.texts3[numLeft]);// set left text

                        numRight = random.nextInt(21); // generate right number
                        while(numLeft == numRight){ // start loop with precondition
                            numRight = random.nextInt(21); // generate right number
                        }
                        image_right.setImageResource(array.images3[numRight]); // set right image
                        image_right.startAnimation(a);
                        text_right.setText(array.texts3[numRight]); // set right text

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
                        // EXIT FROM LEVEL 2
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(21); //get left number
                        image_left.setImageResource(array.images3[numLeft]); // set left image
                        image_left.startAnimation(a);
                        text_left.setText(array.texts3[numLeft]);// set left text

                        numRight = random.nextInt(21); // generate right number
                        while(numLeft == numRight){ // start loop with precondition
                            numRight = random.nextInt(21); // generate right number
                        }
                        image_right.setImageResource(array.images3[numRight]); // set right image
                        image_right.startAnimation(a);
                        text_right.setText(array.texts3[numRight]); // set right text

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
            Intent intent = new Intent(Level3.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}