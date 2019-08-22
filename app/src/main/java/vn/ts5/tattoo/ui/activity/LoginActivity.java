package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.utils.ValidateUtil;

public class LoginActivity extends AppCompatActivity {

    private Button mBtnSignIn;
    private EditText etEmail;
    private EditText etPhone;
    private TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
        mBtnSignIn.setOnClickListener((v) -> clickButtonSignIn());
        txtRegister.setOnClickListener((v) -> startActivity(
                new Intent(LoginActivity.this,RegisterActivity.class)));
    }

    private void clickButtonSignIn() {
        if(validation()) {
            openMainActivity();
        }
    }

    // check input values
    private boolean validation() {
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(phone)){
            Toast.makeText(getApplicationContext(),"Please enter complete full",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!ValidateUtil.isValidEmail(email)){
            Toast.makeText(getApplicationContext(),"Please enter correct format email",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // open MainActivity class
    private void openMainActivity() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        overridePendingTransition(R.anim.left_in,R.anim.right_in);
    }

    private void setupViews(){
        etEmail     = findViewById(R.id.edt_email);
        etPhone     = findViewById(R.id.edit_phone);
        mBtnSignIn  = findViewById(R.id.btn_sign_in);
        txtRegister = findViewById(R.id.txt_register);
        txtRegister.setPaintFlags(txtRegister.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }
}
