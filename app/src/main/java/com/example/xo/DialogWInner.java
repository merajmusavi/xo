package com.example.xo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogWInner extends DialogFragment {
    Callback callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callback = (Callback) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dailog_winner,null,false);
        alertdialog.setView(view);
        Button continue_game = view.findViewById(R.id.continue_game);
        Button reset_game = view.findViewById(R.id.reset_game);
        continue_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.OnContinueClicked();
                dismiss();
            }
        });
        reset_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onResetClicked();
                dismiss();
            }
        });
        return alertdialog.create();

    }
    public interface Callback{
         void OnContinueClicked();
         void onResetClicked();

    }
}
