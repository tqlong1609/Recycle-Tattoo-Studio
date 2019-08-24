package vn.ts5.tattoo.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import vn.ts5.tattoo.R;
import vn.ts5.tattoo.data.model.History;

public class DlgRemoveHistoryFragment extends DialogFragment {

    private Dialog mDialog;
    private Button mBtnCancel;
    private Button mBtnConfirm;
    private ImageButton mIbExit;
    private History history;
    private OnCallBackDialog mListener;

    public interface OnCallBackDialog{
        void confirmRemove(Boolean isRemove, History history);
    }

    public DlgRemoveHistoryFragment(History history) {
        this.history = history;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mDialog = new Dialog(getActivity());
        mDialog.setContentView(R.layout.dialog_remove);

        mListener = (OnCallBackDialog) getActivity();

        setupViews();

        mBtnCancel.setOnClickListener((v) -> mListener.confirmRemove(false,history));
        mBtnConfirm.setOnClickListener((v) -> mListener.confirmRemove(true,history));
        mIbExit.setOnClickListener((v) -> mListener.confirmRemove(false,history));

        return mDialog;
    }

    private void setupViews() {
        mBtnCancel  = mDialog.findViewById(R.id.btn_cancel);
        mBtnConfirm = mDialog.findViewById(R.id.btn_confirm);
        mIbExit     = mDialog.findViewById(R.id.ib_exit);
    }
}
