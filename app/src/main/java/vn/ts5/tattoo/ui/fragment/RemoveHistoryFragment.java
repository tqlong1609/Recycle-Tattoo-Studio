package vn.ts5.tattoo.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import vn.ts5.tattoo.R;

public class RemoveHistoryFragment extends DialogFragment {

    private Dialog mDialog;
    private Button mBtnCancel;
    private Button mBtnConfirm;
    private OnCallBackDialog mListener;

    public interface OnCallBackDialog{
        void confirmRemove(Boolean isRemove);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mDialog = new Dialog(getActivity());
        mDialog.setContentView(R.layout.dialog_remove);

        mListener = (OnCallBackDialog) getActivity();

        setupViews();

        mBtnCancel.setOnClickListener((v) -> mListener.confirmRemove(false));
        mBtnConfirm.setOnClickListener((v) -> mListener.confirmRemove(true));

        return mDialog;
    }

    private void setupViews() {
        mBtnCancel = mDialog.findViewById(R.id.btn_cancel);
        mBtnConfirm = mDialog.findViewById(R.id.btn_confirm);
    }
}
