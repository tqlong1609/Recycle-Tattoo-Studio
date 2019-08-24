package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import vn.ts5.tattoo.R;
import vn.ts5.tattoo.utils.FormatMoneyUtil;

public class AddActivity extends AppCompatActivity {

    private Button mBtnConfirm;
    private ImageView mIvBackground;
    private EditText mEditPrice;
    private EditText mEditDeposit;
    private EditText mEditPayment;
    private EditText mEditBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setupViews();

        formatEditMoney();

        mBtnConfirm.setOnClickListener((v) -> startActivity(
                new Intent(AddActivity.this,RatingActivity.class)));
    }

    private void formatEditMoney() {
        mEditPrice.addTextChangedListener(FormatMoneyUtil.onTextChangedListener(mEditPrice));
        mEditDeposit.addTextChangedListener(FormatMoneyUtil.onTextChangedListener(mEditDeposit));
        mEditPayment.addTextChangedListener(FormatMoneyUtil.onTextChangedListener(mEditPayment));
        mEditBalance.addTextChangedListener(FormatMoneyUtil.onTextChangedListener(mEditBalance));
    }


    private void setupViews() {
        mBtnConfirm = findViewById(R.id.btn_confirm);

        mIvBackground = findViewById(R.id.iv_background);
        mBtnConfirm     = findViewById(R.id.btn_confirm);
        mEditPrice      = findViewById(R.id.edit_price);
        mEditDeposit    = findViewById(R.id.edit_deposit);
        mEditPayment    = findViewById(R.id.edit_payment);
        mEditBalance    = findViewById(R.id.edit_balance);
    }


}
