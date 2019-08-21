package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.utils.ValidateUtil;

public class LoginActivity extends AppCompatActivity {

    private Button mBtnSignIn;
    private EditText etEmail;
    private EditText etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.edt_email);

        setupViews();
        mBtnSignIn.setOnClickListener((v) -> clickButtonSignIn());
    }

    private void clickButtonSignIn() {
        //if(validation())
        openMainActivity();
    }

    private boolean validation() {
        String email = etEmail.getText().toString();
        if(TextUtils.isEmpty(email)){
            //TODO: show messege error
            return false;
        }
        if(!ValidateUtil.isValidEmail(email)){

        }
        return true;
    }

    // open MainActivity class
    private void openMainActivity() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        overridePendingTransition(R.anim.left_in,R.anim.right_in);
    }

    private void setupViews(){
        mBtnSignIn = findViewById(R.id.btn_sign_in);
    }
}
