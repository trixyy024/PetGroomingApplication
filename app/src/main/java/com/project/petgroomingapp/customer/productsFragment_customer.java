package com.project.petgroomingapp.customer;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.petgroomingapp.R;
import com.project.petgroomingapp.adapter.Product;
import com.project.petgroomingapp.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class productsFragment_customer extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public productsFragment_customer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products_customer, container, false);

        // Set up the RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Create a list of products
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Product 1", "$10.00", R.drawable.dogcatdashboard));
        productList.add(new Product("Product 2", "$20.00", R.drawable.dogcatdashboard));
        // Add more products as needed

        // Set up the adapter
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
