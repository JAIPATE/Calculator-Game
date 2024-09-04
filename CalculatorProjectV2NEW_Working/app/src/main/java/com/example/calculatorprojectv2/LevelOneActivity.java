package com.example.calculatorprojectv2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class LevelOneActivity extends AppCompatActivity implements View.OnClickListener{
    TextView display, goalDisplay, buttonClickCounter, constraintDisplay, levelDisplay, lblPoints, lblTime; //add a TextView for the number that the use has to reach
    Button bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight, bNine, bAdd, bSub, bMulti, bDiv, cButton, bZero,bclear, buttonStore, buttonBuyTime, buttonBuyButton, buttonChangeNum, backButton2, calculateButton, btnTimer;
    ImageView imgTime, imgBuyButton, imgChangeNum;
    private int clickCounter = 0;
    private String displayLabel = "";
    private int level = 1;
    boolean done;
    int points = 0;
    private int time = 22*level;
    int goalTime;
    private boolean addTime = false;
    boolean pausetimer = false;

    private double goalOne = 64.0;
    private double goalTwo = 55.0;
    private double goalThree = 169.0;
    private double goalFour = 267.0;
    private double goalFive = 12.0;

    private boolean goalOneA = false;
    private boolean goalTwoA = false;
    private boolean goalThreeA = false;
    private boolean goalFourA = false;
    private boolean goalFiveA = false;

    private int goalOneClick = 3;
    private int goalTwoClick = 4;
    private int goalThreeClick = 5;
    private int goalFourClick = 6;
    private int goalFiveClick = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        bZero = (Button) findViewById(R.id.buttonZero);
        bOne = (Button) findViewById(R.id.buttonOne);
        bTwo = (Button) findViewById(R.id.buttonTwo);
        bThree = (Button) findViewById(R.id.buttonThree);
        bFour = (Button) findViewById(R.id.buttonFour);
        bFive = (Button) findViewById(R.id.buttonFive);
        bSix = (Button) findViewById(R.id.buttonSix);
        bSeven = (Button) findViewById(R.id.buttonSeven);
        bEight = (Button) findViewById(R.id.buttonEight);
        bNine = (Button) findViewById(R.id.buttonNine);
        bclear = (Button) findViewById(R.id.buttonclear);
        bAdd = (Button) findViewById(R.id.additionButton);
        bSub = (Button) findViewById(R.id.subtractionButton);
        bMulti = (Button) findViewById(R.id.multiplicationButton);
        bDiv = (Button) findViewById(R.id.divisionButton);
        btnTimer = (Button) findViewById(R.id.btnTimer);
        lblTime = (TextView) findViewById(R.id.lblTime);
        lblPoints = (TextView) findViewById(R.id.lblPoints);
        buttonBuyButton=findViewById(R.id.buttonBuyAButton);
        buttonBuyTime=findViewById(R.id.buttonBuyTime);
        buttonStore=findViewById(R.id.buttonStore);
        buttonChangeNum=findViewById(R.id.buttonChangeNum);
        backButton2=findViewById(R.id.backButton2);
        calculateButton=findViewById(R.id.calculateButton);
        imgBuyButton=findViewById(R.id.imgBuyButton);
        imgChangeNum=findViewById(R.id.imgChangeNum);
        imgTime=findViewById(R.id.imgTime);

        //^^ The numerical calculator buttons
        bZero.setOnClickListener(this);
        bOne.setOnClickListener(this);
        bTwo.setOnClickListener(this);
        bThree.setOnClickListener(this);
        bFour.setOnClickListener(this);
        bFive.setOnClickListener(this);
        bSix.setOnClickListener(this);
        bSeven.setOnClickListener(this);
        bEight.setOnClickListener(this);
        bNine.setOnClickListener(this);
        bAdd.setOnClickListener(this);
        bSub.setOnClickListener(this);
        bMulti.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        calculateButton.setOnClickListener(this);
        //^^ For the Click Listener for the Button

        display = (TextView) findViewById(R.id.display);
        goalDisplay = (TextView) findViewById((R.id.goalDisplay));
        buttonClickCounter = (TextView) findViewById(R.id.buttonClickCounter);
        constraintDisplay = (TextView) findViewById(R.id.constraintDisplay);
        levelDisplay = (TextView) findViewById(R.id.levelLabel);
        //^^ Sets the Displays

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCounter = 0;
                display.setText(" ");
            }
        });


        buttonStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bAdd.setVisibility(View.INVISIBLE);
                bDiv.setVisibility(View.INVISIBLE);
                bEight.setVisibility(View.INVISIBLE);
                bOne.setVisibility(View.INVISIBLE);
                bTwo.setVisibility(View.INVISIBLE);
                bThree.setVisibility(View.INVISIBLE);
                bFour.setVisibility(View.INVISIBLE);
                bFive.setVisibility(View.INVISIBLE);
                bSix.setVisibility(View.INVISIBLE);
                bSeven.setVisibility(View.INVISIBLE);
                bNine.setVisibility(View.INVISIBLE);
                bMulti.setVisibility(View.INVISIBLE);
                bSub.setVisibility(View.INVISIBLE);
                bZero.setVisibility(View.INVISIBLE);
                buttonChangeNum.setVisibility(View.VISIBLE);
                buttonBuyTime.setVisibility(View.VISIBLE);
                buttonBuyButton.setVisibility(View.VISIBLE);
                buttonStore.setVisibility(View.INVISIBLE);
                backButton2.setVisibility(View.VISIBLE);
                calculateButton.setVisibility(View.INVISIBLE);
                imgBuyButton.setVisibility(View.VISIBLE);
                imgTime.setVisibility(View.VISIBLE);
                imgChangeNum.setVisibility(View.VISIBLE);
                pausetimer = true;
            }
        });

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bAdd.setVisibility(View.VISIBLE);
                bDiv.setVisibility(View.VISIBLE);
                bEight.setVisibility(View.VISIBLE);
                bOne.setVisibility(View.VISIBLE);
                bTwo.setVisibility(View.VISIBLE);
                bThree.setVisibility(View.VISIBLE);
                bFour.setVisibility(View.VISIBLE);
                bFive.setVisibility(View.VISIBLE);
                bSix.setVisibility(View.VISIBLE);
                bSeven.setVisibility(View.VISIBLE);
                bNine.setVisibility(View.VISIBLE);
                bMulti.setVisibility(View.VISIBLE);
                bSub.setVisibility(View.VISIBLE);
                bZero.setVisibility(View.VISIBLE);
                buttonChangeNum.setVisibility(View.INVISIBLE);
                buttonBuyTime.setVisibility(View.INVISIBLE);
                buttonBuyButton.setVisibility(View.INVISIBLE);
                buttonStore.setVisibility(View.VISIBLE);
                backButton2.setVisibility(View.INVISIBLE);
                calculateButton.setVisibility(View.VISIBLE);
                imgBuyButton.setVisibility(View.INVISIBLE);
                imgTime.setVisibility(View.INVISIBLE);
                imgChangeNum.setVisibility(View.INVISIBLE);

            }

        });


        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer();
                done = false;
                pausetimer = false;
                goalDisplay.setVisibility(View.VISIBLE);
                btnTimer.setVisibility(View.INVISIBLE);
                buttonBuyTime.setVisibility(View.INVISIBLE);
            }
        });

        buttonBuyTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(points>=5) {
                    goalTime += 10;
                    points-=5;
                    lblPoints.setText("Points: " + points);
                }
                else{
                    lblPoints.setText("Not enough points");
                }
            }

        });

        buttonChangeNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(points>=15) {
                    if (level == 1) {
                        goalOne = (int) (Math.random() * 100) + 1;
                        goalDisplay.setText("Goal: " + goalOne);
                    } else if (level == 2) {
                        goalTwo = (int) (Math.random() * 200) + 1;
                        goalDisplay.setText("Goal: " + goalTwo);

                    } else if (level == 3) {
                        goalThree = (int) (Math.random() * 300) + 1;
                        goalDisplay.setText("Goal: " + goalThree);
                    } else if (level == 4) {
                        goalFour = (int) (Math.random() * 400) + 1;
                        goalDisplay.setText("Goal: " + goalFour);
                    }
                    points-=15;
                    lblPoints.setText("Points: " + points);
                }
                else{
                    lblPoints.setText("Not enough points");
                }
            }
        });

        buttonBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(points > 10){
                    bOne.setVisibility(View.VISIBLE);
                    bTwo.setVisibility(View.VISIBLE);
                    bThree.setVisibility(View.VISIBLE);
                    bFour.setVisibility(View.VISIBLE);
                    bFive.setVisibility(View.VISIBLE);
                    bSix.setVisibility(View.VISIBLE);
                    bSeven.setVisibility(View.VISIBLE);
                    bEight.setVisibility(View.VISIBLE);
                    bNine.setVisibility(View.VISIBLE);
                    points-=10;
                    lblPoints.setText("Points: " + points);
                }
            }
        });

        goalOneRun();
    }

    public void randombuttonhide(){
        int randomnumber = (int) (Math.random() * 9) + 1;
        if (randomnumber == 1) {
            bOne.setVisibility(View.INVISIBLE);
        } else if (randomnumber == 2) {
            bTwo.setVisibility(View.INVISIBLE);
        } else if (randomnumber == 3) {
            bThree.setVisibility(View.INVISIBLE);
        } else if (randomnumber == 4) {
            bFour.setVisibility(View.INVISIBLE);
        } else if (randomnumber == 5) {
            bFive.setVisibility(View.INVISIBLE);
        } else if (randomnumber == 6) {
            bSix.setVisibility(View.INVISIBLE);
        } else if (randomnumber == 7) {
            bSeven.setVisibility(View.INVISIBLE);
        } else if (randomnumber == 8) {
            bEight.setVisibility(View.INVISIBLE);
        } else if (randomnumber == 9) {
            bNine.setVisibility(View.INVISIBLE);
        }
    }

    public void unhidebutton(){ // only use this for the easy mode.
        bOne.setVisibility(View.VISIBLE);
        bTwo.setVisibility(View.VISIBLE);
        bThree.setVisibility(View.VISIBLE);
        bFour.setVisibility(View.VISIBLE);
        bFive.setVisibility(View.VISIBLE);
        bSix.setVisibility(View.VISIBLE);
        bSeven.setVisibility(View.VISIBLE);
        bEight.setVisibility(View.VISIBLE);
        bNine.setVisibility(View.VISIBLE);
    }



    private void goalOneRun(){
        clickCounter = 0;
        goalDisplay.setText("Goal: " + goalOne);
        constraintDisplay.setText("Three Buttons");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        goalDisplay.setVisibility(View.INVISIBLE);
        randombuttonhide();
        done = true;
        btnTimer.setVisibility(View.VISIBLE);
    }

    private void goalTwoRun(){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalTwo);
        constraintDisplay.setText("Four Buttons");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        level++;
        levelDisplay.setText("Level: " + level);
        randombuttonhide();
        done = true;
        btnTimer.setVisibility(View.VISIBLE);
        points+= 5;
        lblPoints.setText("Points: " + points);
    }

    private void goalThreeRun(){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalThree);
        constraintDisplay.setText("5 Buttons");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        level++;
        levelDisplay.setText("Level: " + level);
        randombuttonhide();
        done = true;
        btnTimer.setVisibility(View.VISIBLE);
        points+= 5;
        lblPoints.setText("Points: " + points);
    }

    private void goalFourRun(){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalFour);
        constraintDisplay.setText("Use Addition with 5 Button Presses");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        level++;
        levelDisplay.setText("Level: " + level);
        randombuttonhide();
        done = true;
        btnTimer.setVisibility(View.VISIBLE);
        points+= 5;
        lblPoints.setText("Points: " + points);
    }

    private void goalFiveRun(){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalFive);
        constraintDisplay.setText("3 Buttons");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        level++;
        levelDisplay.setText("Level: " + level);
        randombuttonhide();
        done = true;
        btnTimer.setVisibility(View.VISIBLE);
        points+= 5;
        lblPoints.setText("Points: " + points);
    }

    private void finishScreen(){
        display.setText("You Beat the Game!");
        constraintDisplay.setVisibility(View.GONE);
        goalDisplay.setVisibility(View.GONE);
        buttonClickCounter.setVisibility(View.GONE);
        levelDisplay.setVisibility(View.GONE);

        bOne.setVisibility(View.GONE);
        bTwo.setVisibility(View.GONE);
        bThree.setVisibility(View.GONE);
        bFour.setVisibility(View.GONE);
        bFive.setVisibility(View.GONE);
        bSix.setVisibility(View.GONE);
        bSeven.setVisibility(View.GONE);
        bEight.setVisibility(View.GONE);
        bNine.setVisibility(View.GONE);
        bAdd.setVisibility(View.GONE);
        bSub.setVisibility(View.GONE);
        bMulti.setVisibility(View.GONE);
        bDiv.setVisibility(View.GONE);
        cButton.setVisibility(View.GONE);
    }

    private void gameOver(){
        display.setText("Game Over!");
        constraintDisplay.setVisibility(View.GONE);
        goalDisplay.setVisibility(View.GONE);
        buttonClickCounter.setVisibility(View.GONE);
        levelDisplay.setVisibility(View.GONE);

        bOne.setVisibility(View.GONE);
        bTwo.setVisibility(View.GONE);
        bThree.setVisibility(View.GONE);
        bFour.setVisibility(View.GONE);
        bFive.setVisibility(View.GONE);
        bSix.setVisibility(View.GONE);
        bSeven.setVisibility(View.GONE);
        bEight.setVisibility(View.GONE);
        bNine.setVisibility(View.GONE);
        bAdd.setVisibility(View.GONE);
        bSub.setVisibility(View.GONE);
        bMulti.setVisibility(View.GONE);
        bDiv.setVisibility(View.GONE);
        cButton.setVisibility(View.GONE);
    }

    public void timer() {
        time-=2;
        goalTime = time;
        new CountDownTimer(time * 1000L, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                lblTime.setText("Time: " + goalTime);
                goalTime -= 1;
                if (addTime) {
                    time += 10;
                }
                if (pausetimer) {
                    cancel();
                }
            }

            public void onFinish() {
                if (!done) {
                    gameOver();
                }
                addTime = false;
            }
        }.start();
    }

    @Override
    public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence keystrokeOver = "Too many Button Presses!";
        CharSequence sillyGoose = "I said Addition you silly goose :)";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, keystrokeOver, duration);
        Toast fgd = Toast.makeText(context, sillyGoose, duration);

        Context contextTwo = getApplicationContext();
        CharSequence textOver = "Goal Overshot!";
        CharSequence textUnder = "Goal Undershot!";
        int durationTwo = Toast.LENGTH_SHORT;

        Toast underShot = Toast.makeText(contextTwo, textUnder, durationTwo);
        Toast overShot = Toast.makeText(contextTwo, textOver, durationTwo);

        switch (view.getId()){
            case R.id.buttonOne:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("1");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonTwo:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("2");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonThree:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("3");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonFour:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("4");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonFive:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("5");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonSix:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("6");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonSeven:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("7");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonEight:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("8");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonNine:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("9");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }
                break;
            case R.id.buttonZero:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("0");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }
                break;

            case R.id.additionButton:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("+");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.subtractionButton:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("-");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    fgd.show();
                    displayLabel = "";
                    display.setText(displayLabel);
                    clickCounter = 0;
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.multiplicationButton:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("×");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    fgd.show();
                    displayLabel = "";
                    display.setText(displayLabel);
                    clickCounter = 0;
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }
                break;
            case R.id.divisionButton:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("÷");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    fgd.show();
                    displayLabel = "";
                    display.setText(displayLabel);
                    clickCounter = 0;
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.calculateButton:
                String expEval = display.getText().toString();

                expEval = expEval.replaceAll("×", "*");
                expEval = expEval.replaceAll("÷", "/");

                Expression exp = new Expression(expEval);

                String resultS = String.valueOf(exp.calculate());
                double result = Double.parseDouble(resultS);

                if (!goalOneA){
                    if (result == goalOne){
                        goalOneA = true;
                        pausetimer = true;
                        lblTime.setText("Time: " + 0);
                        unhidebutton();
                        goalTwoRun();
                    } else {
                        if (result > goalOne){
                            overShot.show();
                        } else {
                            underShot.show();
                        }

                        displayLabel = "";
                        clickCounter = 0;
                    }

                    display.setText(displayLabel);
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalTwoA){
                    if (result == goalTwo){
                        goalTwoA = true;
                        pausetimer = true;
                        lblTime.setText("Time: " + 0);
                        unhidebutton();
                        goalThreeRun();
                    } else {
                        if (result > goalTwo){
                            overShot.show();
                        } else {
                            underShot.show();
                        }

                        displayLabel = "";
                        clickCounter = 0;
                    }

                    display.setText(displayLabel);
                    buttonClickCounter.setText("Button clicks: " + clickCounter);
                } else if (!goalThreeA){
                    if (result == goalThree){
                        goalThreeA = true;
                        pausetimer = true;
                        unhidebutton();
                        lblTime.setText("Time: " + 0);
                        goalFourRun();
                    } else {
                        if (result > goalThree){
                            overShot.show();
                        } else {
                            underShot.show();
                        }

                        displayLabel = "";
                        clickCounter = 0;
                    }

                    display.setText(displayLabel);
                    buttonClickCounter.setText("Button clicks: " + clickCounter);
                } else if (!goalFourA){
                    if (result == goalFour){
                        goalFourA = true;
                        pausetimer = true;
                        unhidebutton();
                        lblTime.setText("Time: " + 0);
                        goalFiveRun();
                    } else {
                        if (result > goalFour){
                            overShot.show();
                        } else {
                            underShot.show();
                        }

                        displayLabel = "";
                        clickCounter = 0;
                    }

                    display.setText(displayLabel);
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalFiveA){
                    if (result == goalFive){
                        goalFiveA = true;
                        pausetimer = true;
                        unhidebutton();
                        lblTime.setText("Time: " + 0);
                        finishScreen();
                    } else {
                        if (result > goalFive){
                            overShot.show();
                        } else {
                            underShot.show();
                        }
                    }
                }

                break;
        }
    }


//    private double goalSix = 1000;
//    private double goalSeven = 1000;
//    private double goalEight = 1000;
//    private double goalNine = 1000;
//    private double goalTen = 1000;
//    private double goalEleven = 1000;
//
//    private boolean goalSixA = false;
//    private boolean goalSevenA = false;
//    private boolean goalEightA = false;
//    private boolean goalNineA = false;
//    private boolean goalTenA = false;
//    private boolean goalElevenA = false;
//
//    private int goalSixClick = 7;
//    private int goalSevenClick = 7;
//    private int goalEightClick = 7;
//    private int goalNineClick = 7;
//    private int goalTenClick = 7;
//    private int goalElevenClick = 7;
//
//    private void goalSixRun(){
//        clickCounter = 0;
//        displayLabel = "";
//        goalDisplay.setText("Goal: " + goalSix);
//        constraintDisplay.setText("Use Addition and Multiplication with 7 Buttons");
//        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//        randombuttonhide();
//        done = true;
//        btnTimer.setVisibility(View.VISIBLE);
//    }
//
//    private void goalSevenRun(){
//        clickCounter = 0;
//        displayLabel = "";
//        goalDisplay.setText("Goal: " + goalSeven);
//        constraintDisplay.setText("8 Buttons");
//        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//        randombuttonhide();
//        level++;
//        levelDisplay.setText("Level: " + level);
//        done = true;
//        btnTimer.setVisibility(View.VISIBLE);
//        points+= 7;
//        lblPoints.setText("Points: " + points);
//    }
//    private void goalEightRun(){
//        clickCounter = 0;
//        displayLabel = "";
//        goalDisplay.setText("Goal: " + goalEight);
//        constraintDisplay.setText("Use Addition and Division with 9 Buttons");
//        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//        randombuttonhide();
//        level++;
//        levelDisplay.setText("Level: " + level);
//        done = true;
//        btnTimer.setVisibility(View.VISIBLE);
//        points+= 7;
//        lblPoints.setText("Points: " + points);
//    }
//    private void goalNineRun(){
//        clickCounter = 0;
//        displayLabel = "";
//        goalDisplay.setText("Goal: " + goalNine);
//        constraintDisplay.setText("Use Division and then Subtraction with 10 Buttons");
//        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//        randombuttonhide();
//        level++;
//        levelDisplay.setText("Level: " + level);
//        done = true;
//        btnTimer.setVisibility(View.VISIBLE);
//        points+= 7;
//        lblPoints.setText("Points: " + points);
//    }
//    private void goalTenRun(){
//        clickCounter = 0;
//        displayLabel = "";
//        goalDisplay.setText("Goal: " + goalTen);
//        constraintDisplay.setText("Use Addition and Multiplication with 11 Buttons");
//        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//        randombuttonhide();
//        level++;
//        levelDisplay.setText("Level: " + level);
//        done = true;
//        btnTimer.setVisibility(View.VISIBLE);
//        points+= 7;
//        lblPoints.setText("Points: " + points);
//    }
//    private void goalElevenRun(){
//        clickCounter = 0;
//        displayLabel = "";
//        goalDisplay.setText("Goal: " + goalEleven);
//        constraintDisplay.setText("Use Addition and Multiplication and Division and Subtraction with 15 Buttons");
//        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//        randombuttonhide();
//        level++;
//        levelDisplay.setText("Level: " + level);
//        done = true;
//        btnTimer.setVisibility(View.VISIBLE);
//        points+= 7;
//        lblPoints.setText("Points: " + points);
//    }
//
//
//    public void onClick1(View view) {
//        Context context = getApplicationContext();
//        CharSequence keystrokeOver = "Too many Button Presses!";
//        CharSequence sillyGoose = "I said Addition you silly goose :)";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, keystrokeOver, duration);
//        Toast fgd = Toast.makeText(context, sillyGoose, duration);
//
//        Context contextTwo = getApplicationContext();
//        CharSequence textOver = "Goal Overshot!";
//        CharSequence textUnder = "Goal Undershot!";
//        int durationTwo = Toast.LENGTH_SHORT;
//
//        Toast underShot = Toast.makeText(contextTwo, textUnder, durationTwo);
//        Toast overShot = Toast.makeText(contextTwo, textOver, durationTwo);
//
//        switch (view.getId()) {
//            case R.id.buttonOne:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("1");
//                display.setText(displayLabel);
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.buttonTwo:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("2");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.buttonThree:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("3");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.buttonFour:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("4");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.buttonFive:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("5");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.buttonSix:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("6");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.buttonSeven:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("7");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.buttonEight:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("8");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.buttonNine:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("9");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.additionButton:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("+");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.subtractionButton:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("-");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.multiplicationButton:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("×");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.divisionButton:
//                clickCounter++;
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                displayLabel = displayLabel.concat("÷");
//                display.setText(displayLabel);
//
//                if (!goalSixA) {
//                    if (clickCounter > goalSixClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }else if (!goalSevenA) {
//                    if (clickCounter > goalSevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalEightA) {
//                    if (clickCounter > goalEightClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalNineA) {
//                    if (clickCounter > goalNineClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalTenA) {
//                    if (clickCounter > goalTenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                } else if (!goalElevenA) {
//                    if (clickCounter > goalElevenClick) {
//                        toast.show();
//                        displayLabel = "";
//                        display.setText(displayLabel);
//                        clickCounter = 0;
//                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                    }
//                }
//
//                break;
//            case R.id.calculateButton:
//                String expEval = display.getText().toString();
//
//                expEval = expEval.replaceAll("×", "*");
//                expEval = expEval.replaceAll("÷", "/");
//
//                Expression exp = new Expression(expEval);
//
//                String resultS = String.valueOf(exp.calculate());
//                double result = Double.parseDouble(resultS);
//
//                display.setText(displayLabel);
//                buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                if (!goalSixA){
//                    if (result == goalSix){
//                        goalSixA = true;
    //                    pausetimer = true;
    //                    lblTime.setText("Time: " + 0);

//                        goalSevenRun();
//                    } else {
//                        if (result > goalSix){
//                            overShot.show();
//                        } else {
//                            underShot.show();
//                        }
//                        displayLabel = "";
//                        clickCounter = 0;
//                    }
//                    display.setText(displayLabel);
//                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                } else if (!goalSevenA){
//                    if (result == goalSeven){
//                        goalSevenA = true;
    //                    pausetimer = true;
    //                    lblTime.setText("Time: " + 0);
//                        goalEightRun();
//                    } else {
//                        if (result > goalSeven){
//                            overShot.show();
//                        } else {
//                            underShot.show();
//                        }
//                        displayLabel = "";
//                        clickCounter = 0;
//                    }
//                    display.setText(displayLabel);
//                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                } else if (!goalEightA){
//                    if (result == goalEight){
//                        goalEightA = true;
    //                    pausetimer = true;
    //                    lblTime.setText("Time: " + 0);
//                        goalNineRun();
//                    } else {
//                        if (result > goalEight){
//                            overShot.show();
//                        } else {
//                            underShot.show();
//                        }
//                        displayLabel = "";
//                        clickCounter = 0;
//                    }
//                    display.setText(displayLabel);
//                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                } else if (!goalNineA){
//                    if (result == goalNine){
//                        goalNineA = true;
    //                    pausetimer = true;
    //                    lblTime.setText("Time: " + 0);
//                        goalTenRun();
//                    } else {
//                        if (result > goalNine){
//                            overShot.show();
//                        } else {
//                            underShot.show();
//                        }
//                        displayLabel = "";
//                        clickCounter = 0;
//                    }
//                    display.setText(displayLabel);
//                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                } else if (!goalTenA){
//                    if (result == goalTen){
//                        goalTenA = true;
    //                    pausetimer = true;
    //                    lblTime.setText("Time: " + 0);
//                        goalElevenRun();
//                    } else {
//                        if (result > goalTen){
//                            overShot.show();
//                        } else {
//                            underShot.show();
//                        }
//                        displayLabel = "";
//                        clickCounter = 0;
//                    }
//                    display.setText(displayLabel);
//                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
//                } else if (!goalElevenA) {
//                    if (result == goalEleven) {
//                        goalElevenA = true;
    //                    pausetimer = true;
    //                    lblTime.setText("Time: " + 0);
//                        finishScreen();
//                    } else {
//                        if (result > goalEleven) {
//                            overShot.show();
//                        } else {
//                            underShot.show();
//                        }
//                    }
//                }
//
//
//                break;
//        }
//    }
}
