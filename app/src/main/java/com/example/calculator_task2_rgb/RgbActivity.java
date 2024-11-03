package com.example.calculator_task2_rgb;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RgbActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgb);
    }

    public void onCheckboxClicked(View view) {
        CheckBox checkBoxRed = findViewById(R.id.checkbox_rgb_red);
        CheckBox checkBoxGreen = findViewById(R.id.checkbox_rgb_green);
        CheckBox checkBoxBlue = findViewById(R.id.checkbox_rgb_blue);

        ConstraintLayout constraintLayout = findViewById(R.id.constraint_parent);

        int red = checkBoxRed.isChecked() ? 255 : 0;
        int green = checkBoxGreen.isChecked() ? 255 : 0;
        int blue = checkBoxBlue.isChecked() ? 255 : 0;;

        constraintLayout.setBackgroundColor(Color.rgb(red, green, blue));
    }
}
