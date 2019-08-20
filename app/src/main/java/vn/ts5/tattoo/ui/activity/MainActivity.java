package vn.ts5.tattoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.data.model.History;
import vn.ts5.tattoo.ui.adapter.HistoryAdapter;

// todo: add values into arraylist
// todo: progress event click edit recycle view

public class MainActivity extends AppCompatActivity implements HistoryAdapter.OnCallBack {

    private RecyclerView mRcvHistory;
    private HistoryAdapter mHistoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        mRcvHistory = findViewById(R.id.rcv_history);
        mRcvHistory.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRcvHistory.setLayoutManager(layoutManager);

        ArrayList<History> historyArrayList = addValuesIntoArrayList();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        mRcvHistory.addItemDecoration(dividerItemDecoration);
        mRcvHistory.setItemAnimator(new DefaultItemAnimator());

        mHistoryAdapter = new HistoryAdapter(historyArrayList,this);
        mRcvHistory.setAdapter(mHistoryAdapter);
    }

    // todo: add values into arraylist
    private ArrayList<History> addValuesIntoArrayList() {
        return null;
    }

    // todo: progress event click edit recycle view
    // position: index of item need to edit
    @Override
    public void onItemsClicked(int position) {

    }
}
