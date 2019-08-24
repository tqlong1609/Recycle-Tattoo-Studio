package vn.ts5.tattoo.ui.activity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import pl.droidsonroids.gif.GifImageView;
import vn.ts5.tattoo.R;
import vn.ts5.tattoo.ui.dialog.DlgSuccessFragment;

public class FinishActivity extends BaseActivity {

    @BindView(R.id.gif_rating)
    GifImageView gif_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        initView();
    }
}
