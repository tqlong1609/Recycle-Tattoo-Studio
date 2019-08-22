package vn.ts5.tattoo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.ts5.tattoo.R;

public class SpinnerCumtomAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> values;
    private int mLayout;

    public SpinnerCumtomAdapter(Context mContext, ArrayList<String> values, int mLayout) {
        this.mContext = mContext;
        this.values = values;
        this.mLayout = mLayout;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.custom_spinner_items,null);
        TextView textView = view.findViewById(R.id.txt_spn_custom);
        textView.setText(values.get(i));
        return view;
    }
}
