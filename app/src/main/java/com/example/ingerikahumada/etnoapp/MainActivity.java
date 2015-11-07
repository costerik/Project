package com.example.ingerikahumada.etnoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    Hashtable<String,String> dirWE, dirEW;
    EditText edtText;
    Spinner spinner,spinner2;
    Button btnSwapLanguage, btnTranslate;
    TextView txtViewTranslate;
    ArrayList<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dirEW=new Hashtable<>();
        words=new ArrayList<>();
        edtText=(EditText)findViewById(R.id.edit_text);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 =(Spinner) findViewById(R.id.spinner2);
        btnTranslate=(Button)findViewById(R.id.button_translate);
        txtViewTranslate= (TextView)findViewById(R.id.text_view);

        //Change the icon
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.logo);
        ab.setTitle("");
        //



        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtViewTranslate.setText(translate(edtText.getText().toString(),words));
                /*String wordObtained = fromTo(dirEW, edtText.getText().toString());
                if (wordObtained != "") {
                    txtViewTranslate.setText(wordObtained);
                } else {
                    txtViewTranslate.setText("Lo sentimos, estamos en proceso!!!");
                }*/
            }
        });
        //


        // Create an Adapter that holds a list of language
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.from_language, R.layout.dropdown_item);

        // Set the Adapter for the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                // Display a Toast message indicating the currently selected
                // item
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Create an Adapter for Spinner2
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(
                this,R.array.to_language,R.layout.dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        try {
            readFile(dirEW);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void onResume(){
        super.onResume();
    }

    /*public void readFile()throws IOException {
        InputStream isr=this.getResources().openRawResource(R.raw.dictionary);
        BufferedReader br=new BufferedReader(new InputStreamReader(isr));
        String line=br.readLine();
        while(line!=null){
            Log.i("PALABRA", line);
            String[] fields=line.split(";");
            dirWE.put(fields[0],fields[1]);
            line=br.readLine();
        }
        br.close();
    }*/

    public String[] splitText(String text){
        String [] eachWord=text.split(" ");
        return eachWord;
    }

    public void readFile(Hashtable h) throws IOException{
        InputStream isr=this.getResources().openRawResource(R.raw.dictionary2);
        BufferedReader reader=new BufferedReader(new InputStreamReader(isr));
        String line = null;
        while ((line = reader.readLine()) != null) {
            Log.d("A",line);
            String [] str=line.split(";");
            //System.out.println(line);
            //System.out.println(str[0]+"->"+str[1]);
            h.put(str[0],str[1]);
        }
    }

    public ArrayList<String> wordTranslate(Hashtable<String,String> hash, String []wordsTypes){
        ArrayList<String> words=new ArrayList<String>();
        for(String str:wordsTypes){
            if(hash.get(str)!=null){
                words.add(hash.get(str));
            }else{
                words.add("(->"+str+"<-)");
            }
        }
        return words;
    }

    public String translate(String text,ArrayList words){
        String[] argsWords=splitText(text);

        words=wordTranslate(dirEW,argsWords);
        String result="";
        for(int i=0;i<words.size();i++){
            result+=words.get(i)+" ";
        }
        return result;
    }
}
