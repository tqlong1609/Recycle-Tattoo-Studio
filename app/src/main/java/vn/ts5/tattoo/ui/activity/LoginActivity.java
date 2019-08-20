package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import vn.ts5.tattoo.R;

public class LoginActivity extends AppCompatActivity {

    private Button mBtnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupViews();
        mBtnSignIn.setOnClickListener((v) -> clickButtonSignIn());
    }

    private void clickButtonSignIn() {
        openMainActivity();
    }

    // open MainActivity class
    private void openMainActivity() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        overridePendingTransition(R.anim.open_translate,R.anim.close_translate);
    }

    private void setupViews(){
        mBtnSignIn = findViewById(R.id.btn_sign_in);
    }
}
