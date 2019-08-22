package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.utils.FormatMoneyUtil;

public class EditActivity extends AppCompatActivity {

    private EditText mEditPrice;
    private EditText mEditDeposit;
    private EditText mEditPayment;
    private EditText mEditBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setupViews();
        formatEditMoney();
    }

    private void formatEditMoney() {
        mEditPrice.addTextChangedListener(FormatMoneyUtil.onTextChangedListener(mEditPrice));
        mEditDeposit.addTextChangedListener(FormatMoneyUtil.onTextChangedListener(mEditDeposit));
        mEditPayment.addTextChangedListener(FormatMoneyUtil.onTextChangedListener(mEditPayment));
        mEditBalance.addTextChangedListener(FormatMoneyUtil.onTextChangedListener(mEditBalance));
    }

    private void setupViews() {
        mEditPrice      = findViewById(R.id.edit_price);
        mEditDeposit    = findViewById(R.id.edit_deposit);
        mEditPayment    = findViewById(R.id.edit_payment);
        mEditBalance    = findViewById(R.id.edit_balance);
    }
}
