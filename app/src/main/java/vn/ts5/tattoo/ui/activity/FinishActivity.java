package vn.ts5.tattoo.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.io.IOException;

import butterknife.BindView;
import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import vn.ts5.tattoo.R;

public class FinishActivity extends BaseActivity {

    private static final String TAG = "FinishActivity";
    @BindView(R.id.gif_rating)
    GifImageView gif_rating;
    @BindView(R.id.btn_next)
    Button btnNext;

    GifDrawable gifDrawable = null;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        initView();
        btnNext.setVisibility(View.GONE);
        animation = AnimationUtils.loadAnimation(this, R.anim.btn_scale_up);

        try {
            gifDrawable = new GifDrawable(getResources(), R.drawable.rating_5_stars);
            gifDrawable.addAnimationListener(loopNumber -> {
                Log.d(TAG, " onAnimationCompleted:" + loopNumber);
                showBtnNext();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        gif_rating.setImageDrawable(gifDrawable);
    }
    private void showBtnNext(){
        gifDrawable.stop();
        btnNext.setVisibility(View.VISIBLE);
        btnNext.setAnimation(animation);
    }
}
