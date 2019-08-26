package vn.ts5.tattoo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import android.widget.Toast;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.utils.ValidateUtil;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.edt_email)
    EditText etEmail;

    @BindView(R.id.edt_phone)
    EditText etPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }
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

    @OnClick(R.id.btn_sign_in)
    public void onClickSignIn(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        overridePendingTransition(R.anim.left_in, R.anim.right_in);
//        if (validation()) {
//            openMainActivity();
//        }
    }
}
