package vn.ts5.tattoo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;


import vn.ts5.tattoo.R;

public class SplashActivity extends AppCompatActivity {

    private final int SECOND_DELAY = 1000 * 3; //3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(() -> changeToRegisterActivity(), SECOND_DELAY);
    }

    private void changeToRegisterActivity() {
        startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
        finish();
    }
}
