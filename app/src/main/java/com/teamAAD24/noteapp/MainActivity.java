package com.teamAAD24.noteapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.transitionseverywhere.ChangeText;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.transitionseverywhere.extra.Scale;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private Button saveBtn, nextBtn, newJBtn;
    private TextView title;
    private ViewGroup newEntry, saveTo, container, dialogView, colorContainer;
    private CheckBox chooseColor;
    private ImageView homePG, itemsPG, wifi;
    AnimationDrawable wifiAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.parent_container);

        mFab = findViewById(R.id.floatingActionButton);

        dialogView = findViewById(R.id.dialog_view);
        newEntry = findViewById(R.id.new_entry);
        saveTo = findViewById(R.id.save_to);
        saveBtn = findViewById(R.id.save);
        nextBtn = findViewById(R.id.next);
        colorContainer = findViewById(R.id.color_container);
        newJBtn = findViewById(R.id.new_journal);
        chooseColor = findViewById(R.id.choose_color);
        title = findViewById(R.id.dialog_title);
        itemsPG = findViewById(R.id.items_page);
        homePG = findViewById(R.id.home_page);
        wifi = findViewById(R.id.image);

        updateUI();

        }

        @Override
        public void onWindowFocusChanged(boolean hasFocus) {
            super.onWindowFocusChanged(hasFocus);
            wifiAnimation.start();
        }

    /**
     * @author babu-appDev
     * Floating Action button to dialog
     */
    private void updateUI(){

        wifi.setBackgroundResource(R.drawable.animation);
        wifiAnimation = (AnimationDrawable) wifi.getBackground();

        final TransitionSet set = new TransitionSet();
        set.addTransition(new Slide(Gravity.BOTTOM))
                .addTransition(new Fade())
                .addTransition(new Scale())
                .setInterpolator(new FastOutSlowInInterpolator());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionManager.beginDelayedTransition(container, set);
                homePG.setVisibility(View.VISIBLE);
                wifi.setVisibility(View.GONE);
            }
        }, 2000);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(container, set);
                dialogView.setVisibility(View.VISIBLE);
            }
        });

        homePG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(container);
                homePG.setVisibility(View.GONE);
                itemsPG.setVisibility(View.VISIBLE);
            }
        });

        itemsPG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView.setVisibility(View.VISIBLE);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(container);
                visible = !visible;
                changeViews(visible);
            }
        });

        chooseColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                TransitionManager.beginDelayedTransition(container);
                colorContainer.setVisibility(b? View.GONE : View.VISIBLE);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(container, set);
                dialogView.setVisibility(View.GONE);
                changeViews(false);
            }
        });
    }

    private void changeViews(final boolean visible) {
        saveBtn.setVisibility(visible? View.VISIBLE : View.GONE);
        newEntry.setVisibility(visible? View.GONE : View.VISIBLE);
        saveTo.setVisibility(visible? View.VISIBLE : View.GONE);
        newJBtn.setVisibility(visible? View.VISIBLE : View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionManager.beginDelayedTransition(container,
                        new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
                nextBtn.setText(visible ? "BACK" : "NEXT");
                title.setText(visible? "Save to..." : "New Entry");
            }
        }, 800);
    }

}
