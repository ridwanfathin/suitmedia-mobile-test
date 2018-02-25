package com.example.redion.suitmedia_test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.redion.suitmedia_test.adapter.PeopleAdapter;
import com.example.redion.suitmedia_test.model.people.DataPeople;
import com.example.redion.suitmedia_test.model.people.ResponsePeople;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GuestFragment OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GuestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuestFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    PeopleAdapter mAdapter;

    //Declare Object People
    ResponsePeople dataPeople;
    List<DataPeople> listPeople=new ArrayList<>();

    //Declare Activity Context
    Context mContext = this.getActivity();
    
    public static GuestFragment newInstance() {
        return new GuestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guest, container, false);
        getActivity().setTitle("Guest");
        setHasOptionsMenu(true);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PeopleAdapter();
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


}