package vn.ts5.tattoo.ui.activity;

import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import vn.ts5.tattoo.R;
import vn.ts5.tattoo.data.model.History;
import vn.ts5.tattoo.ui.adapter.HistoryAdapter;
import vn.ts5.tattoo.ui.dialog.DlgRemoveHistoryFragment;

// mapping
public class MainActivity extends BaseActivity implements HistoryAdapter.OnCallBack, DlgRemoveHistoryFragment.OnCallBackDialog {

    public static final int NOT_COMPLETE = 0;
    public static final int COMPLETE = 1;

    @BindView(R.id.rcv_history)
    private RecyclerView mRcvHistory;

    @OnClick(R.id.ibt_add)
    public void onClickIbtAdd(View view){
        // todo: click image button add
    }

    private HistoryAdapter mHistoryAdapter;
    private DlgRemoveHistoryFragment dlgRemoveHistoryFragment;
    private ArrayList<History> historyArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadValuesRecyclerView();

        //mBtnCreateNew.setOnClickListener((v) -> startActivity(new Intent(MainActivity.this,AddActivity.class)));
    }

    private void loadValuesRecyclerView() {
        mRcvHistory.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRcvHistory.setLayoutManager(layoutManager);

        historyArrayList = addValuesIntoArrayList();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        mRcvHistory.addItemDecoration(dividerItemDecoration);
        mRcvHistory.setItemAnimator(new DefaultItemAnimator());

        mHistoryAdapter = new HistoryAdapter(historyArrayList,this);
        mRcvHistory.setAdapter(mHistoryAdapter);
    }


    private ArrayList<History> addValuesIntoArrayList() {
        ArrayList<History> historyArrayList = new ArrayList<>();
        historyArrayList.add(
                new History("id_1","date_1","name_1",COMPLETE,2,2000,3000,5000,2000));
        historyArrayList.add(
                new History("id_2","date_2","name_2",NOT_COMPLETE,0,3000,4000,5000,4000));
        historyArrayList.add(
                new History("id_3","date_3","name_3",NOT_COMPLETE,1,4000,5000,5000,2000));
        historyArrayList.add(
                new History("id_4","date_4","name_4",COMPLETE,3,5000,3000,5000,2000));
        historyArrayList.add(
                new History("id_5","date_5","name_5",NOT_COMPLETE,4,6000,5000,5000,5000));
        historyArrayList.add(
                new History("id_6","date_6","name_6",COMPLETE,5,7000,3000,5000,2000));
        return historyArrayList;
    }

    @Override
    public void onEdit(History history) {
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        intent.putExtra("dataHistory", history);
        startActivity(intent);
    }

    @Override
    public void onRemove(History history) {
        dlgRemoveHistoryFragment = new DlgRemoveHistoryFragment(history);
        dlgRemoveHistoryFragment.show(getSupportFragmentManager(),"dialog");
    }

    @Override
    public String checkStatus(int status, TextView txtStatus) {
        int yellowOrange = ResourcesCompat.getColor(getResources(),R.color.colorYellowOrange,null);
        int green = ResourcesCompat.getColor(getResources(),R.color.green,null);
        switch (status)
        {
            case MainActivity.COMPLETE:
                txtStatus.setTextColor(green);
                return "Hoàn thành";
            case MainActivity.NOT_COMPLETE:
                txtStatus.setTextColor(yellowOrange);
                return "Chưa hoàn thành";
        }
        return "Error";
    }

    @Override
    public void confirmRemove(Boolean isRemove, History history) {
        if(isRemove){
            historyArrayList.remove(history);
            mHistoryAdapter.notifyDataSetChanged();
            dlgRemoveHistoryFragment.dismiss();
            Toast.makeText(MainActivity.this,"Remove success",Toast.LENGTH_SHORT).show();
        }
        else{
            dlgRemoveHistoryFragment.dismiss();
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_out,R.anim.right_out);
    }
}
