package com.example.calculator_task2_rgb;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        LinearLayout linearLayout = task2();
//
//        setContentView(linearLayout);
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

    private LinearLayout task2() {
        LinearLayout linearLayout = new LinearLayout(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setId(ViewGroup.generateViewId());

        int[] buttonIds1 = new int[4];
        buttonIds1[0] = ViewGroup.generateViewId();
        buttonIds1[1] = ViewGroup.generateViewId();
        buttonIds1[2] = ViewGroup.generateViewId();
        buttonIds1[3] = ViewGroup.generateViewId();

        int[] buttonIds2 = new int[4];
        buttonIds2[0] = ViewGroup.generateViewId();
        buttonIds2[1] = ViewGroup.generateViewId();
        buttonIds2[2] = ViewGroup.generateViewId();
        buttonIds2[3] = ViewGroup.generateViewId();

        linearLayout.addView(getLinearLayout(ViewGroup.generateViewId(), ViewGroup.generateViewId(),
                buttonIds1, "#c4ffab"));
        linearLayout.addView(getLinearLayout(ViewGroup.generateViewId(), ViewGroup.generateViewId(),
                buttonIds2, "#ffabab"));

        return linearLayout;
    }

    private LinearLayout getLinearLayout(int id, int gridId, int[] buttonIds, String background) {
        LinearLayout linearLayout = new LinearLayout(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0);
        layoutParams.weight = 1;

        linearLayout.setId(id);
        linearLayout.setBackgroundColor(Color.parseColor(background));
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(Gravity.CENTER);

        linearLayout.addView(getGridLayout(gridId, buttonIds));

        return linearLayout;
    }

    private GridLayout getGridLayout(int id, int[] buttonIds) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setId(id);
        gridLayout.setColumnCount(2);
        gridLayout.setRowCount(2);
        gridLayout.setLayoutParams(layoutParams);

        gridLayout.addView(getButton(buttonIds[0], 0, 0, "1"));
        gridLayout.addView(getButton(buttonIds[1], 0, 1, "2"));
        gridLayout.addView(getButton(buttonIds[2], 1, 0, "3"));
        gridLayout.addView(getButton(buttonIds[3], 1, 1, "4"));

        return gridLayout;
    }

    private Button getButton(int id, int layoutRow, int layoutColumn, String text) {
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.rowSpec = GridLayout.spec(layoutRow);
        layoutParams.columnSpec = GridLayout.spec(layoutColumn);

        Button button = new Button(this);
        button.setId(id);
        button.setText(text);
        button.setLayoutParams(layoutParams);

        return button;
    }
}