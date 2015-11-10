package com.example.ingerikahumada.etnoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class Traductor extends Fragment {
    Hashtable<String,String> dirWE, dirEW;
    EditText edtText;
    Spinner spinner,spinner2;
    Button btnSwapLanguage, btnTranslate;
    TextView txtViewTranslate;
    ArrayList<String> words;
    public Traductor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_traductor, container, false);
        dirEW=new Hashtable<>();
        words=new ArrayList<>();
        edtText=(EditText)view.findViewById(R.id.edit_text);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 =(Spinner) view.findViewById(R.id.spinner2);
        btnTranslate=(Button)view.findViewById(R.id.button_translate);
        txtViewTranslate= (TextView)view.findViewById(R.id.text_view);

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
                getActivity(), R.array.from_language, R.layout.dropdown_item);

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
                getActivity(),R.array.to_language,R.layout.dropdown_item);
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

        // Inflate the layout for this fragment
        return view;
    }

    public String[] splitText(String text){
        String [] eachWord=text.split(" ");
        return eachWord;
    }

    public void readFile(Hashtable h) throws IOException {
        InputStream isr=this.getResources().openRawResource(R.raw.dictionary2);
        BufferedReader reader=new BufferedReader(new InputStreamReader(isr));
        String line = null;
        while ((line = reader.readLine()) != null) {
            Log.d("A", line);
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
                words.add("'"+str+"'");
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

    public String getTxtTranslate(){
        return txtViewTranslate.getText().toString();
    }

}
