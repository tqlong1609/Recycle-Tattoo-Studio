package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.ui.dialog.NotificateSuccessFragment;

public class RatingActivity extends AppCompatActivity {


    private Button mBtnFinish;

    public static final int[] LIST_ID_IMG_STAR = {R.id.img_star_1, R.id.img_star_2,
            R.id.img_star_3, R.id.img_star_4, R.id.img_star_5 };

    private ArrayList<ImageView> mImgArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        setupViews();

        setStarWhiteBegin();

        ratingStar();

        mBtnFinish.setOnClickListener((v) -> new NotificateSuccessFragment().show(
                getSupportFragmentManager(),"dialog_success"));
    }

    private void setStarWhiteBegin() {
        // set star white
        for (int j= 0; j < mImgArrayList.size(); j++) {
            mImgArrayList.get(j).setImageResource(R.drawable.ic_star_white);
        }
    }

    private void ratingStar() {
        mImgArrayList.get(0).setOnClickListener((v) -> checkStar(1));
        mImgArrayList.get(1).setOnClickListener((v) -> checkStar(2));
        mImgArrayList.get(2).setOnClickListener((v) -> checkStar(3));
        mImgArrayList.get(3).setOnClickListener((v) -> checkStar(4));
        mImgArrayList.get(4).setOnClickListener((v) -> checkStar(5));
    }

    /**
     * function check count star when click
     * @param numStar: number star
     */
    private void checkStar(int numStar) {

        // set star yellow
        for (int i = 0; i < numStar; i++) {
            mImgArrayList.get(i).setImageResource(R.drawable.ic_star_yellow);
        }

        // set star white
        for (int j= numStar; j < mImgArrayList.size(); j++) {
            mImgArrayList.get(j).setImageResource(R.drawable.ic_star_white);
        }
    }

    private void setupViews() {
        mBtnFinish = findViewById(R.id.btn_finish);

        mImgArrayList = new ArrayList<>();

        for(int i : LIST_ID_IMG_STAR)
        {
            ImageView imageView = findViewById(i);
            mImgArrayList.add(imageView);
        }

    }
}
