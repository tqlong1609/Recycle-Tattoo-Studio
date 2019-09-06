package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import vn.ts5.tattoo.R;

// mapping activity search
public class SearchActivity extends BaseActivity {

    @BindView(R.id.edit_email)
    private EditText edtEmail;

    @BindView(R.id.edt_phone)
    private EditText edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();

    }

    @OnClick(R.id.btn_search)
    public void onClickSearch(View view){

    }
}
