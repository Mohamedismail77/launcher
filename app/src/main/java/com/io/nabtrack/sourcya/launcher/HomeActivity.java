package com.io.nabtrack.sourcya.launcher;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by m-ismail on 01/02/18.
 */

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ProgressBar progressBar = findViewById(R.id.loading);

        new CountDownTimer(3000,5) {
            @Override
            public void onTick(long millisUntilFinished) {

                progressBar.setProgress((int) (3000-millisUntilFinished));

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(HomeActivity.this, AppsListActivity.class));

            }
        }.start();
    }



    @Override
    public void onBackPressed() {
        
    }

    @Override
    protected void onResume() {
        startActivity(new Intent(HomeActivity.this, AppsListActivity.class));
        super.onResume();

    }
}
