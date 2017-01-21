package com.example.sridevi.multiscreen.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.sridevi.multiscreen.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public Button numbersbutton;
    public Button colorsbutton;
    public Button membersbutton;
    public Button phrasesbutton;
    TextToSpeech t1;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getActionBar().setDisplayHomeAsUpEnabled(true);

        numbersbutton = (Button) findViewById(R.id.numbersid);
        colorsbutton = (Button) findViewById(R.id.colorsid);
        membersbutton = (Button) findViewById(R.id.membersid);
        phrasesbutton= (Button) findViewById(R.id.phrasesid);


        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.US);
                }
            }
        });

       numbersbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent numbersintent = new Intent(getApplication(), NumbersActivity.class);
               startActivity(numbersintent);

           }
       });

        colorsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsintent = new Intent(getApplication(),ColorsActivity.class);
                startActivity(colorsintent);

            }
        });

        membersbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent membersintent = new Intent(getApplication(),MembersActivity.class);
                startActivity(membersintent);

            }
        });

        phrasesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesintent = new Intent(getApplication(),PhrasesActivity.class);
                startActivity(phrasesintent);

            }
        });

    }
}
