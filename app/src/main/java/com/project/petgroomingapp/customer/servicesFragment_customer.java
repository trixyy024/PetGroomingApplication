package com.project.petgroomingapp.customer;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.petgroomingapp.R;
import com.project.petgroomingapp.adapter.Services;
import com.project.petgroomingapp.adapter.ServicesAdapter;

import java.util.ArrayList;
import java.util.List;

public class servicesFragment_customer extends Fragment {

    private RecyclerView recyclerView;
    //private ServicesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Button btnBoknow;

    public servicesFragment_customer(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services_customer, container, false);

        // Set up the RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Create a list of products
        List<Services> servicesList = new ArrayList<>();
        servicesList.add(new Services("Product 1", "$10.00", R.drawable.dogcatdashboard));
        servicesList.add(new Services("Product 2", "$20.00", R.drawable.dogcatdashboard));

        Context context = getContext(); // or this if in an Activity

        ServicesAdapter adapter = new ServicesAdapter(servicesList, context);
        recyclerView.setAdapter(adapter);




        return view;
    }
}
