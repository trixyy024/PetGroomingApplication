package com.project.petgroomingapp.customer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.project.petgroomingapp.R;

import androidx.recyclerview.widget.RecyclerView;

public class homeFragment_customer extends Fragment {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private RecyclerView recyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_customer_dashboard, container, false);

        androidx.appcompat.widget.Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new MyFragmentStateAdapter(this));

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Products");
                    break;
                case 1:
                    tab.setText("Services");
                    break;
            }
        }).attach();

        return view;
    }
    private class MyFragmentStateAdapter extends FragmentStateAdapter {
        public MyFragmentStateAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new productsFragment_customer();
                case 1:
                    return new servicesFragment_customer();
                default:
                    throw new IllegalArgumentException("Invalid position: " + position);
            }
        }
        @Override
        public int getItemCount() {
            return 2;
        }
    }
}