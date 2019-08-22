package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.ui.adapter.SpinnerCumtomAdapter;

public class RegisterActivity extends AppCompatActivity {

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
    }

    private void addListSex() {
        mListSex.add("Men");
        mListSex.add("Lady");
    }

    private void addListMonth() {
        mListMonth.add("Month");
        mListMonth.add("1");
        mListMonth.add("2");
        mListMonth.add("3");
        mListMonth.add("4");
        mListMonth.add("5");
        mListMonth.add("6");
        mListMonth.add("7");
        mListMonth.add("8");
        mListMonth.add("9");
        mListMonth.add("10");
        mListMonth.add("11");
        mListMonth.add("12");
    }

    private void addListDate() {
        mListDate.add("Date");
        mListDate.add("1");
        mListDate.add("2");
        mListDate.add("3");
        mListDate.add("4");
        mListDate.add("5");
        mListDate.add("6");
        mListDate.add("7");
        mListDate.add("8");
        mListDate.add("9");
        mListDate.add("10");
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
        mSpnDate    = findViewById(R.id.spn_date);
        mSpnMonth   = findViewById(R.id.spn_month);
        mSpnSex     = findViewById(R.id.spn_sex);

        mListDate = new ArrayList<>();
        mListMonth = new ArrayList<>();
        mListSex = new ArrayList<>();
    }
}
