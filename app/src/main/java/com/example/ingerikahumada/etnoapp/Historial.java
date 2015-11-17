package com.example.ingerikahumada.etnoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Historial extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ListView lista;
    private ArrayList<String> list;
    private HistoryDAO mHistoryDAO;
    public Historial() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHistoryDAO=new HistoryDAO(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_historial, container, false);
        mRecyclerView=(RecyclerView)view.findViewById(R.id.my_recycle_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mostrarElems();

        return view;
    }

    public void mostrarElems(){
        list= mHistoryDAO.getData();
        Log.i("Obtaining Data", "" + list.size());

        mAdapter=new HistorialAdapter(list);

        mRecyclerView.setAdapter(mAdapter);
    }
}
