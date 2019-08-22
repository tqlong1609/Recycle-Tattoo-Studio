package vn.ts5.tattoo.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import vn.ts5.tattoo.R;

public class NotificateSuccessFragment extends DialogFragment {

    private Dialog mDialog;
    private ImageButton ib_mBtnExit;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mDialog = new Dialog(getActivity());
        mDialog.setContentView(R.layout.dialog_notificate_success);
        ib_mBtnExit = mDialog.findViewById(R.id.ib_exit);
        ib_mBtnExit.setOnClickListener((v) -> this.dismiss());
        return mDialog;
    }
}
