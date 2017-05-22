package com.project.sonnguyen.alden;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class RightOrRonActivity extends AppCompatActivity {
    //Button btnStop;
    ImageView btnRight,btnRon;
    TextView txtText,txtScore;
    LinearLayout lnColorDisplay;
    ArrayList<RightOrRon> rightOrRonArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_right_or_ron);
        btnRight = (ImageView) findViewById(R.id.acti_rightron_btnRight);
        btnRon = (ImageView) findViewById(R.id.acti_rightron_btnRon);
        //btnStop = (Button) findViewById(R.id.acti_rightron_btnStop);
        txtScore = (TextView) findViewById(R.id.acti_rightron_txt_score);
        txtText = (TextView) findViewById(R.id.acti_rightron_text);
        final Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Skranji-Bold.ttf");
        txtText.setTypeface(typeface);
        txtScore.setTypeface(typeface);
        lnColorDisplay = (LinearLayout) findViewById(R.id.acti_rightron_linear_color);
        rightOrRonArrayList = new ArrayList<>();
        initToList();
        final int[] score = {0};
        txtScore.setText("" + score[0]);
        //begin
        final boolean[] answer = {StarGame()};
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer[0]&& rightOrRonArrayList.size()!=0){
                    //dung
                    answer[0] = StarGame();
                    score[0]++;
                    txtScore.setText("" + score[0]);
                }

                else {
                    //ket thuc
                    final Dialog dialog = new Dialog(RightOrRonActivity.this,R.style.DialogCustomTheme);
                    dialog.setContentView(R.layout.dialog_game_over);
                    dialog.setTitle("");
                    TextView txtscore = (TextView)dialog.findViewById(R.id.dialog_score_txt_score);
                    txtscore.setTypeface(typeface);
                    txtscore.setText("Score : "+score[0]);
                    ImageView btnClose = (ImageView) dialog.findViewById(R.id.dialog_score_back_btn);
                    ImageView btnAgain = (ImageView)dialog.findViewById(R.id.dialog_score_again_btn);
                    btnClose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            finish();
                        }
                    });
                    btnAgain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            reload();
                        }
                    });
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                }

            }
        });
        btnRon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answer[0]){
                    answer[0] = StarGame();
                    score[0]++;
                    txtScore.setText("" + score[0]);
                }
                else{
                    //ket thuc
                    final Dialog dialog = new Dialog(RightOrRonActivity.this,R.style.DialogCustomTheme);
                    dialog.setContentView(R.layout.dialog_game_over);
                    dialog.setTitle("");
                    TextView txtscore = (TextView)dialog.findViewById(R.id.dialog_score_txt_score);
                    txtscore.setTypeface(typeface);
                    txtscore.setText("Score : "+score[0]);
                    ImageView btnClose = (ImageView) dialog.findViewById(R.id.dialog_score_back_btn);
                    ImageView btnAgain = (ImageView)dialog.findViewById(R.id.dialog_score_again_btn);
                    btnClose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            finish();
                        }
                    });
                    btnAgain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            reload();
                        }
                    });
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                }

            }
        });

//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    private void reload() {

            Intent intent = getIntent();
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();
            overridePendingTransition(0, 0);
            startActivity(intent);

    }

    private boolean StarGame() {
        Random rand = new Random();
        int ran = rand.nextInt(rightOrRonArrayList.size());
        final RightOrRon ques = rightOrRonArrayList.get(ran);
        if(ques.getColor()==android.R.color.black)
            txtText.setTextColor(getResources().getColor(android.R.color.white));
        else
            txtText.setTextColor(getResources().getColor(android.R.color.black));

        rightOrRonArrayList.remove(ques);
        txtText.setText(ques.getText());
        lnColorDisplay.setBackgroundResource(ques.getColor());
        return ques.isAnswer();
    }

    private void initToList() {
        rightOrRonArrayList.add( new RightOrRon(android.R.color.black,"BLACK",true));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.white,"WHITE",true));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.darker_gray,"GRAY",true));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_orange_light,"ORANGE",true));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_blue_bright,"BRIGHT",true));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_green_light,"GREEN",true));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_blue_light,"BLUE",true));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_red_light,"RED",true));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_purple,"PURPLE",true));
        //ron
        rightOrRonArrayList.add( new RightOrRon(android.R.color.black,"WHITE",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.black,"GRAY",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.black,"ORANGE",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.black,"GREEN",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.black,"RED",false));
        //
        rightOrRonArrayList.add( new RightOrRon(android.R.color.white,"RED",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.white,"GRAY",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.white,"GREEN",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.white,"PURPLE",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.white,"BLUE",false));
        //
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_blue_light,"PURPLE",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_blue_light,"GREEN",false));
        rightOrRonArrayList.add( new RightOrRon(android.R.color.holo_blue_light,"GRAY",false));






    }
}
