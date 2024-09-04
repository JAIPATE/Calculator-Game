package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button mainButton, nextButton, htpButton, settingsButton, backButton, btnHard;
    TextView instructionsLabel, txtSysVolume;
    ToggleButton tglLevel;
    Boolean themeState;
    ConstraintLayout constraintMain, constraintStart;
    SeekBar volumeControl;
    AudioManager mAudio;
    ImageView imgCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Animation animationIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
//        Animation animationOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        //^^Fade in and Fade out animation through XML files

        mainButton = (Button) findViewById(R.id.mainButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        htpButton = (Button) findViewById(R.id.htpButton);
        tglLevel=findViewById(R.id.tglLevel);
        backButton=findViewById(R.id.backButton);
        btnHard = findViewById(R.id.btnHard);
//        tglTheme=findViewById(R.id.tglTheme);
        constraintMain=findViewById(R.id.constraintMain);
        constraintStart=findViewById(R.id.constraintStart);
        mAudio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        SeekBar volumeControl=(SeekBar)findViewById(R.id.volumeControl);
        imgCalc=findViewById(R.id.imgCalc);
        txtSysVolume=findViewById(R.id.txtSysVolume);

        initControls(volumeControl, AudioManager.STREAM_MUSIC);
        instructionsLabel = (TextView) findViewById(R.id.instructionLabel);


        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhardmode();
            }
        });


        final int[] stage = {0};

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openLevelOne();
            }
        });

        htpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.music);
                music.start();
                instructionsLabel.setVisibility(View.VISIBLE);
                htpButton.setVisibility(View.INVISIBLE);
                mainButton.setVisibility(View.INVISIBLE);
                tglLevel.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.VISIBLE);
                settingsButton.setVisibility(View.INVISIBLE);
                imgCalc.setVisibility(View.INVISIBLE);


            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                instructionsLabel.setVisibility(View.INVISIBLE);
                htpButton.setVisibility(View.INVISIBLE);
                mainButton.setVisibility(View.INVISIBLE);
                tglLevel.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.VISIBLE);
                settingsButton.setVisibility(View.INVISIBLE);
                volumeControl.setVisibility(View.VISIBLE);
                imgCalc.setVisibility(View.INVISIBLE);
                txtSysVolume.setVisibility(View.VISIBLE);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                instructionsLabel.setVisibility(View.INVISIBLE);
                htpButton.setVisibility(View.VISIBLE);
                mainButton.setVisibility(View.VISIBLE);
                tglLevel.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.INVISIBLE);
                settingsButton.setVisibility(View.VISIBLE);
                volumeControl.setVisibility(View.INVISIBLE);
                imgCalc.setVisibility(View.VISIBLE);
                txtSysVolume.setVisibility(View.INVISIBLE);
            }
        });

//        tglTheme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                themeState = tglTheme.isChecked();
//                if(themeState){
//                    constraintMain.setBackgroundColor(Color.BLACK);
//                    constraintStart.setBackgroundColor(Color.BLACK);
//                }
//                if(!themeState){
//                    constraintMain.setBackgroundColor(Color.WHITE);
//                    constraintStart.setBackgroundColor(Color.WHITE);
//                }
//            }
//        });


    }

    protected AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
    protected AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

    private void initControls (SeekBar seek, final int stream)
    {

        seek.setMax(mAudio.getStreamMaxVolume(stream));
        seek.setProgress(mAudio.getStreamVolume(stream));
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser)
            {
                mAudio.setStreamVolume(stream, progress, AudioManager.FLAG_PLAY_SOUND);
            }
            public void onStartTrackingTouch(SeekBar bar) {
            }
            public void onStopTrackingTouch(SeekBar bar) {
            }
        });
    }

    private void fadeAnimation(TextView input){
        input.startAnimation(fadeIn);
        input.startAnimation(fadeOut);
        fadeIn.setDuration(1000);
        fadeOut.setDuration(1000);
        fadeIn.setFillAfter(true);
        fadeOut.setFillAfter(true);
        fadeOut.setStartOffset(4200 + fadeIn.getStartOffset());
    }
    //^^ Fade animation (play around with later)

    public void openLevelOne(){
        Intent intent = new Intent(this, LevelOneActivity.class);
        startActivity(intent);
    }
    public void openhardmode(){
        Intent intent = new Intent(this, Hardlevel.class);
        startActivity(intent);
    }

}
