package com.project.petgroomingapp.customer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.project.petgroomingapp.R;

public class services_list extends AppCompatActivity {

    Button booknow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.services_list);

        booknow = findViewById(R.id.btnBookNow);

        booknow.setOnClickListener(v -> {
            Intent intent = new Intent(services_list.this, bookNow.class);
        });
    }
}