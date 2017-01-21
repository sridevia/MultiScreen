package com.example.sridevi.multiscreen.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sridevi.multiscreen.Adapters.wordAdapter;
import com.example.sridevi.multiscreen.ModelClasses.word;
import com.example.sridevi.multiscreen.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Sridevi on 12/14/2016.
 */
public class MembersActivity extends Activity {

    public ListView listview;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        words.add(new word("MOTHER","mother",R.drawable.family_mother));
        words.add(new word("FATHER","father",R.drawable.family_father));
        words.add(new word("BROTHER","brother",R.drawable.family_younger_brother));
        words.add(new word("SISTER","sister",R.drawable.family_younger_sister));

        wordAdapter adapter = new wordAdapter(this,words);

        listview = (ListView)findViewById(R.id.list_item);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
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
