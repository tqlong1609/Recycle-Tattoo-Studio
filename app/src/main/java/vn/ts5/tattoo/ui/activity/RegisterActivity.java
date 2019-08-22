package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.ui.adapter.HistoryAdapter;
import vn.ts5.tattoo.ui.adapter.SpinnerCumtomAdapter;

public class RegisterActivity extends AppCompatActivity {

    private Spinner mSpnBirthday;
    private ArrayList<String> mListDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupViews();
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
        SpinnerCumtomAdapter spinnerCumtomAdapter = new SpinnerCumtomAdapter(
                getApplicationContext(),mListDate,R.layout.custom_spinner_items);
        mSpnBirthday.setAdapter(spinnerCumtomAdapter);
    }

    private void setupViews() {
        mSpnBirthday = findViewById(R.id.spn_birthday);
        mListDate = new ArrayList<>();
    }
}
