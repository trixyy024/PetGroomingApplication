package com.project.petgroomingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.petgroomingapp.R;
import com.project.petgroomingapp.customer.bookNow;

import java.util.List;


public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ProductViewHolder> {



    private List<Services> servicesList;
    private Context context;

    public ServicesAdapter(List<Services> servicesList, Context context) { // Add context as a parameter
        this.servicesList = servicesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.services_list, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Services services = servicesList.get(position);
        holder.servicesDescription.setText(services.getName());
        holder.sPrice.setText(services.getPrice());
        holder.servicesImage.setImageResource(services.getImageResource());

        holder.btnBookNow.setOnClickListener(v -> {
            // Handle Buy Now button click
            Intent intent = new Intent(context, bookNow.class); // Use context here
            intent.putExtra("service_name", services.getName());
            intent.putExtra("service_price", services.getPrice());
            context.startActivity(intent);
            // Start the activity

            Toast.makeText(v.getContext(), "Book now: " + services.getName(), Toast.LENGTH_SHORT).show();

        });
    }

    @Override
    public int getItemCount() {
        return servicesList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView servicesDescription;
        public TextView sPrice;
        public ImageView servicesImage;
        public Button btnBookNow;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            servicesDescription = itemView.findViewById(R.id.serviceDescription);
            sPrice = itemView.findViewById(R.id.sPrice);
            servicesImage = itemView.findViewById(R.id.servicesImage);
            btnBookNow = itemView.findViewById(R.id.btnBookNow);
        }
    }
}
