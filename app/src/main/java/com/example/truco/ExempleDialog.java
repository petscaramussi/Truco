package com.example.truco;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class ExempleDialog extends AppCompatDialogFragment {

    private EditText name;
    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);


        builder.setView(view)
                .setTitle("Mudar Nome")
                .setNegativeButton("cancelar" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nomeTv = name.getText().toString();
                        listener.applyTexts(nomeTv);
                    }
                });
        name = view.findViewById(R.id.editName);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (ExampleDialogListener) context;
    }

    public interface ExampleDialogListener{
        void applyTexts(String name);
    }

}
