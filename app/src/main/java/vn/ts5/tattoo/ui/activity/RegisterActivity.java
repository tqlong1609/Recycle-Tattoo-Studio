package vn.ts5.tattoo.ui.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import vn.ts5.tattoo.R;
import vn.ts5.tattoo.ui.adapter.SpinnerCumtomAdapter;
import vn.ts5.tattoo.utils.ValidateUtil;

// mapping
public class RegisterActivity extends BaseActivity {

    @BindView(R.id.edt_name)
    private EditText mEditEmail;

    @BindView(R.id.spn_date)
    private Spinner mSpnDate;

    @BindView(R.id.spn_month)
    private Spinner mSpnMonth;

    @BindView(R.id.spn_sex)
    private Spinner mSpnSex;

    @BindView(R.id.edt_phone)
    private EditText edtPhone;

    @BindView(R.id.edt_email)
    private EditText edtEmail;

    @OnClick(R.id.btn_next)
    public void onClickNext(View view){
        // todo: click next button
    }

    private ArrayList<String> mListDate;
    private ArrayList<String> mListMonth;
    private ArrayList<String> mListSex;

    private SpinnerCumtomAdapter spinnerCumtomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        setupArrayList();

        addListDate();
        addListMonth();
        addListSex();

        setupSpinnerAdapter(mListDate);
        mSpnDate.setAdapter(spinnerCumtomAdapter);

        setupSpinnerAdapter(mListMonth);
        mSpnMonth.setAdapter(spinnerCumtomAdapter);

        setupSpinnerAdapter(mListSex);
        mSpnSex.setAdapter(spinnerCumtomAdapter);

    }

    private void clickButtonConfirmAdd() {
        if(validation()) {
            // todo: add success
        }
    }

    // check input values
    private boolean validation() {
        String email = mEditEmail.getText().toString();
        if(!ValidateUtil.isValidEmail(email)){
            Toast.makeText(getApplicationContext(),"Please enter correct format email",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void addListSex() {
        mListSex.add("Male");
        mListSex.add("Female");
    }

    private void addListMonth() {
        mListMonth.add("Month");
        for (int i = 1; i < 13; i++) {
            mListMonth.add(String.valueOf(i));
        }
    }

    private void addListDate() {
        mListDate.add("Date");
        for (int i = 1; i < 32 ; i++) {
            mListDate.add(String.valueOf(i));
        }
    }

    private void setupSpinnerAdapter(ArrayList<String> mList) {
        spinnerCumtomAdapter = new SpinnerCumtomAdapter(
                getApplicationContext(),mList,R.layout.custom_spinner_items){
            @Override
            public boolean isEnabled(int position) {
                if(position == 0 && mList != mListSex){
                    return false;
                }
                else {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position,convertView,parent);
                TextView textView = view.findViewById(R.id.txt_spn_custom);
                if(position == 0 && mList != mListSex){
                    textView.setTextColor(Color.GRAY);
                }
                else {
                    textView.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
    }

    private void setupArrayList() {
        mListDate   = new ArrayList<>();
        mListMonth  = new ArrayList<>();
        mListSex    = new ArrayList<>();
    }
}
