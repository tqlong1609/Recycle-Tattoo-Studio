package vn.ts5.tattoo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.data.model.History;

/**
 * Created by Nani on 2019-08-19.
 */
// todo: mapping view
// todo: set values

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<History> mListHistorys;
    private OnCallBack mListener;

    public interface OnCallBack{
        void onItemsClicked(History history);
        void onRemove(History history);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDate;
        TextView txtName;
        TextView txtPrice;
        TextView txtDeposit;
        TextView txtPayment;
        TextView Balance;
        TextView txtStatus;
        ImageView imgRate;
        Button btnEdit;
        Button btnRemove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // mapping
//            txtData = itemView.findViewById();
//            txtName = itemView.findViewById();
//            txtPrice = itemView.findViewById();
//            txtName = itemView.findViewById();
//            txtDeposit = itemView.findViewById();
//            txtPayment = itemView.findViewById();
//            Balance = itemView.findViewById();
//            txtStatus = itemView.findViewById();
//            imgRate = itemView.findViewById();
//            btnEdit = itemView.findViewById();
//            btnRemove = itemView.findViewById();

        }
    }

    public HistoryAdapter(ArrayList<History> mListHistorys, OnCallBack mListener) {
        this.mListHistorys = mListHistorys;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.views_history,parent,false);
        return new ViewHolder(view);
    }

    // todo: set values
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = mListHistorys.get(position);
        if(history != null){

            holder.txtDate.setText(history.getDate());
            holder.txtName.setText(history.getName());
            holder.txtPrice.setText(String.valueOf(history.getPrice()));
            holder.txtDeposit.setText(String.valueOf(history.getDeposit()));
            //holder.txtPayment.setText(history.getPayment());
            holder.Balance.setText(mListHistorys.get(position).getName());
            holder.txtStatus.setText(mListHistorys.get(position).getName());

            holder.btnRemove.setOnClickListener((v) -> mListener.onRemove(history));
            holder.btnEdit.setOnClickListener((v) -> mListener.onItemsClicked(history));
        }

    }

    private void clickButtonRemove() {

    }

    @Override
    public int getItemCount() {
        return mListHistorys.size();
    }

    // todo: mapping view

}
