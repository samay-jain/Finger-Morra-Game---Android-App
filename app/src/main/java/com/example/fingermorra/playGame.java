package com.example.fingermorra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class playGame extends AppCompatActivity {

    ImageView plonefin, pltwofin, comfinger;
    TextView plpoints, compoints, sumShow,roundShower;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        int rounds = Integer.parseInt(getIntent().getStringExtra("rounds"));
        int temp = rounds;
        int[] count = {0};
        plonefin = findViewById(R.id.onefinger);
        pltwofin = findViewById(R.id.twofinger);
        comfinger = findViewById(R.id.setComputerChoice);
        plpoints = findViewById(R.id.setPlayersPoints);
        compoints = findViewById(R.id.setComputerPoints);
        sumShow = findViewById(R.id.sum);
        roundShower = findViewById(R.id.roundShower);
        plonefin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count[0] += 1;
                int com = computersChoice();
                if (com == 1)
                    comfinger.setImageResource(R.drawable.one_finger);
                else
                    comfinger.setImageResource(R.drawable.two_fingers);
                int sum = 1 + com;
                boolean b = evenOddCal(sum);
                int score = getScore(b);
                score += sum;
                if (b == true) {
                    sumShow.setText("Sum of Fingers is Even, your score is incremented by "+sum+" points");
                    plpoints.setText("" + score);
                } else {
                    sumShow.setText("Sum of Fingers is Odd, Computer's score is incremented by "+sum+" points");
                    compoints.setText("" + score);
                }
                count[0]=checkWinner(count[0],rounds);
            }
        });
        pltwofin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count[0] += 1;
                int com = computersChoice();
                if (com == 1)
                    comfinger.setImageResource(R.drawable.one_finger);
                else
                    comfinger.setImageResource(R.drawable.two_fingers);
                int sum = 2 + com;
                boolean b = evenOddCal(sum);
                int score = getScore(b);
                score += sum;
                if (b == true) {
                    sumShow.setText("Sum of Fingers is Even, your score is incremented by "+sum+" points");
                    plpoints.setText("" + score);
                } else {
                    sumShow.setText("Sum of Fingers is Odd, Computer's score is incremented by "+sum+" points");
                    compoints.setText("" + score);
                }
                count[0]=checkWinner(count[0],rounds);
            }
        });
    }

    private int  checkWinner(int count,int rounds)
    {
        roundShower.setText("Round - "+(count+1));
        if(count==rounds)
        {
            int player = getScore(true);
            int computer = getScore(false);
            if (player > computer)
            {
                sumShow.setText("You have won the match!");
                winDialog dialogbox = new winDialog(playGame.this, "You" + " won the match with a lead of "+(player-computer), playGame.this);
                dialogbox.setCancelable(false);
                dialogbox.show();
                setAllBefore();
            }
            else if (computer > player)
            {
                sumShow.setText("You lost the match!");
                winDialog dialogbox = new winDialog(playGame.this, "You" + " lost the match, Computer won with a lead of "+(computer-player), playGame.this);
                dialogbox.setCancelable(false);
                dialogbox.show();
                setAllBefore();
            }
            else
            {
                sumShow.setText("It's a Tie!");
                winDialog dialogbox = new winDialog(playGame.this, "It's a" + " tie you both have scored "+player, playGame.this);
                dialogbox.setCancelable(false);
                dialogbox.show();
                setAllBefore();
            }
            return 0;
        }
        return count;
    }

    private void setAllBefore()
    {
        plpoints.setText("0");
        compoints.setText("0");
        sumShow.setText("Let's Start the Game");
        roundShower.setText("Round  - 1");
    }

    private int getScore(boolean b)
    {
        String str="";
        if(b)
        {
            str = plpoints.getText().toString();
        }
        else
        {
            str = compoints.getText().toString();
        }
        return Integer.parseInt(str);
    }
    private static int computersChoice()
    {
        Random random = new Random();
        int arr[] = {1,2};
        int comchoice = random.nextInt(2);
        return arr[comchoice];
    }
    private static boolean evenOddCal(int sum)
    {
        if(sum%2==0)
            return true;
        else
            return false;
    }
}