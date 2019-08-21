package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import vn.ts5.tattoo.R;

public class AddActivity extends AppCompatActivity {

    private Button mBtnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setupViews();

        mBtnConfirm.setOnClickListener((v) -> startActivity(
                new Intent(AddActivity.this,RatingActivity.class)));

    }

    private void setupViews() {
        mBtnConfirm = findViewById(R.id.btn_confirm);
    }
}
