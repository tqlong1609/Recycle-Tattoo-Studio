package vn.ts5.tattoo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import vn.ts5.tattoo.R;
import vn.ts5.tattoo.data.model.History;
import vn.ts5.tattoo.ui.activity.RatingActivity;

/**
 * Created by Nani on 2019-08-19.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<History> mListHistorys;
    private OnCallBack mListener;

    public interface OnCallBack{
        void onEdit(History history);
        void onRemove(History history);
        String checkStatus(int status, TextView txtStatus);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_date)
        private TextView txtDate;

        @BindView(R.id.txt_name)
        private TextView txtName;

        @BindView(R.id.txt_price)
        private TextView txtPrice;

        @BindView(R.id.txt_deposit)
        private TextView txtDeposit;

        @BindView(R.id.txt_payment)
        private TextView txtPayment;

        @BindView(R.id.txt_paid)
        private TextView txtPaid;

        @BindView(R.id.txt_rest)
        private TextView txtRest;

        @BindView(R.id.txt_status)
        private TextView txtStatus;

        List<ImageView> listImgStar;

        @BindView(R.id.ibt_edit)
        private ImageButton btnEdit;

        ImageButton btnRemove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listImgStar = new ArrayList<>();

            mappingListImageStar();

        }

        private void mappingListImageStar() {
            for (int id : RatingActivity.LIST_ID_IMG_STAR)
            {
                ImageView imageView = itemView.findViewById(id);
                listImgStar.add(imageView);
            }
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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = mListHistorys.get(position);
        if(history != null){
            holder.txtDate.setText(history.getDate());
            holder.txtName.setText(history.getName());
            holder.txtPrice.setText(String.valueOf(history.getPrice()));
            holder.txtDeposit.setText(String.valueOf(history.getDeposit()));
            holder.txtPayment.setText(String.valueOf(history.getPayment()));
            holder.txtBalance.setText(String.valueOf(history.getBalance()));
            holder.txtStatus.setText(mListener.checkStatus(history.getStatus(),holder.txtStatus));

            setStar(history.getRate(),holder);

            holder.btnRemove.setOnClickListener((v) -> mListener.onRemove(history));
            holder.btnEdit.setOnClickListener((v) -> mListener.onEdit(history));
        }

    }

    // set count of star into image view
    private void setStar(int rate, ViewHolder holder) {

        // set star yellow
        for (int i = 0; i < rate; i++) {
            holder.listImgStar.get(i).setImageResource(R.drawable.ic_star_yellow);
        }

        // set star white
        for (int j= rate; j < holder.listImgStar.size(); j++) {
            holder.listImgStar.get(j).setImageResource(R.drawable.ic_star_white);
        }

    }

    @Override
    public int getItemCount() {
        return mListHistorys.size();
    }

}
