package com.wmy.module_main;

import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import com.wmy.module_main.circular.CircularRevealView;
import com.wmy.module_main.circular.FabAnimationUtils;

public class TestActivity extends AppCompatActivity {

    CircularRevealView revealView;
    View selectedView;
    FloatingActionButton fabPower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        revealView=findViewById(R.id.reveal);
        setSupportActionBar(toolbar);

        fabPower = (FloatingActionButton) findViewById(R.id.fab);
        fabPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPowerMenu(view);
            }
        });
    }


    private void launchPowerMenu(View v) {
        final int color = getPrimaryColor();
        final Point p = getLocationInView(revealView, v);

        revealView.reveal(p.x, p.y, color, v.getHeight() / 2, 370, null);
         selectedView = v;

        FabAnimationUtils.scaleOut(fabPower, new FabAnimationUtils.ScaleCallback() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
//                fabPower.setImageResource(R.drawable.ic_launcher);
                FabAnimationUtils.scaleIn(fabPower);
            }
        });
//
//        handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showPowerDialog();
//            }
//        }, 160);
    }
    private Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }

    private int getPrimaryColor() {
        TypedValue typedValue = new TypedValue();
        TypedArray a = obtainStyledAttributes(typedValue.data, new int[]{R.attr.colorPrimary});
        int color = a.getColor(0, 0);
        a.recycle();

        return color;
    }

//    private int getBackgroundColor() {
//        TypedValue typedValue = new TypedValue();
//        TypedArray a = obtainStyledAttributes(typedValue.data, new int[]{R.attr.windowBackground});
//        int color = a.getColor(0, 0);
//        a.recycle();
//
//        return color;
//    }
}
