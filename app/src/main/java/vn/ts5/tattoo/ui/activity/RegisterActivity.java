package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.ui.adapter.SpinnerCumtomAdapter;
import vn.ts5.tattoo.utils.ValidateUtil;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEditEmail;
    private ImageButton mIbConfirmAdd;

    private Spinner mSpnDate;
    private Spinner mSpnMonth;
    private Spinner mSpnSex;

    private ArrayList<String> mListDate;
    private ArrayList<String> mListMonth;
    private ArrayList<String> mListSex;

    private SpinnerCumtomAdapter spinnerCumtomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupViews();

        addListDate();
        addListMonth();
        addListSex();

        setupSpinnerAdapter(mListDate);
        mSpnDate.setAdapter(spinnerCumtomAdapter);

        setupSpinnerAdapter(mListMonth);
        mSpnMonth.setAdapter(spinnerCumtomAdapter);

        setupSpinnerAdapter(mListSex);
        mSpnSex.setAdapter(spinnerCumtomAdapter);

        mIbConfirmAdd.setOnClickListener((v) -> clickButtonConfirmAdd());
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
        mListSex.add("Men");
        mListSex.add("Lady");
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

    private void setupViews() {
        mEditEmail      = findViewById(R.id.edit_email);
        mIbConfirmAdd   = findViewById(R.id.ib_confirm_add);
        mSpnDate        = findViewById(R.id.spn_date);
        mSpnMonth       = findViewById(R.id.spn_month);
        mSpnSex         = findViewById(R.id.spn_sex);

        mListDate   = new ArrayList<>();
        mListMonth  = new ArrayList<>();
        mListSex    = new ArrayList<>();
    }
}
