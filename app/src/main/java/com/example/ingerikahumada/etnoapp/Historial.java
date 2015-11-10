package com.example.ingerikahumada.etnoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Historial extends Fragment {
    private ListView lista;
    private ArrayList<String> list;
    private HistoryDAO mHistoryDAO;
    public Historial() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_historial, container, false);
        lista=(ListView)view.findViewById(R.id.lista_historial);
        mHistoryDAO=new HistoryDAO(getContext());
        mostrarElems();
        return view;
    }

    public void mostrarElems(){
        list=mHistoryDAO.getData();
        Log.i("Obtaining Data", "" + list.size());
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, android.R.id.text1,list);
        lista.setAdapter(adapter);
    }
}
