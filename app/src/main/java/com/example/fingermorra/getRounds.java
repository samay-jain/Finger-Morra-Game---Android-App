package com.example.fingermorra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class getRounds extends AppCompatActivity {

    private MaterialButton playgame;
    private EditText getRounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_rounds);

        playgame = findViewById(R.id.playGame);
        getRounds = findViewById(R.id.getround);
        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = getRounds.getText().toString();
                if(num.isEmpty())
                {
                    Toast.makeText(com.example.fingermorra.getRounds.this, "Please Enter a valid Number!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int rounds = Integer.parseInt(num);
                    if(rounds>0)
                    {
                        String str = rounds+"";
                        Intent intent = new Intent(com.example.fingermorra.getRounds.this,playGame.class);
                        intent.putExtra("rounds",str);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(com.example.fingermorra.getRounds.this, "Play atleast one round!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}