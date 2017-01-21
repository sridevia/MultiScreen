package com.example.sridevi.multiscreen.Activities;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sridevi.multiscreen.Adapters.wordAdapter;
import com.example.sridevi.multiscreen.ModelClasses.word;
import com.example.sridevi.multiscreen.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Sridevi on 12/14/2016.
 */

public class NumbersActivity extends AppCompatActivity {

    public ListView listview;
    TextToSpeech t1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.US);
                }
            }
        });

        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("ONE", "one", R.drawable.number_one));
        words.add(new word("TWO", "two", R.drawable.number_two));
        words.add(new word("THREE", "three", R.drawable.number_three));
        words.add(new word("FOUR", "four", R.drawable.number_four));
        words.add(new word("FIVE", "five", R.drawable.number_five));
        words.add(new word("SIX", "six", R.drawable.number_six));
        words.add(new word("SEVEN", "seven", R.drawable.number_seven));
        words.add(new word("SEVEN", "seven", R.drawable.number_eight));
        words.add(new word("NINE", "nine", R.drawable.number_nine));
        words.add(new word("TEN", "ten", R.drawable.number_ten));

        wordAdapter adapter = new wordAdapter(this, words);

        listview = (ListView) findViewById(R.id.list_item);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(NumbersActivity.this,"List itme clicked",Toast.LENGTH_SHORT).show();
                word word = words.get(i);
                String tospeak = word.getMsmallletters();
                t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}
