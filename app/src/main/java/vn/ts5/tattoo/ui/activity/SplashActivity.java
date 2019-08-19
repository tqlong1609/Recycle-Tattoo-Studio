package vn.ts5.tattoo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


import vn.ts5.tattoo.R;

public class SplashActivity extends AppCompatActivity {

    private final int SECOND_DELAY = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(()-> changeToRegisterActivity(), SECOND_DELAY);
    }

    private void changeToRegisterActivity() {
        startActivity(new Intent(SplashActivity.this,RegisterActivity.class));
        finish();
    }
}