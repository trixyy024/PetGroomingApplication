package com.project.petgroomingapp.customer;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.petgroomingapp.R;
import com.project.petgroomingapp.customer.accountFragment_customer;
import com.project.petgroomingapp.customer.homeFragment_customer;
import com.project.petgroomingapp.customer.messagesFragment_customer;
import com.project.petgroomingapp.customer.paymentFragment_customer;

public class Customer_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_dashboard);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
              loadFragment(new homeFragment_customer(), false);
            } else if (itemId == R.id.payment) {
               loadFragment(new paymentFragment_customer(), false);
            } else if (itemId == R.id.messages) {
               loadFragment(new messagesFragment_customer(), false);
            } else {
               loadFragment(new accountFragment_customer(), false);
            }

            return true;
        });

        // Load the default fragment
        loadFragment(new homeFragment_customer(), true);
    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frameLayout, fragment);
        } else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }

        fragmentTransaction.commit();
    }
}
