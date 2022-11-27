package com.example.fingermorra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class winDialog extends Dialog
{
    private final String message;
    private final playGame play;
    public winDialog(@NonNull Context context, String message, playGame play) {
        super(context);
        this.message=message;
        this.play=play;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_win_dialog);
        final TextView showwinner = findViewById(R.id.showwinner);
        final Button playagain = findViewById(R.id.startagain);
        showwinner.setText(message);
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}