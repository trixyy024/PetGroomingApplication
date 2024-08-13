package com.project.petgroomingapp.adapter;

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
import com.project.petgroomingapp.adapter.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice());
        holder.productImage.setImageResource(product.getImageResource());

        holder.btnAddToCart.setOnClickListener(v -> {
            // Handle Add to Cart button click
            Toast.makeText(v.getContext(), "Added to Cart: " + product.getName(), Toast.LENGTH_SHORT).show();
        });

        holder.btnBuyNow.setOnClickListener(v -> {
            // Handle Buy Now button click
            Toast.makeText(v.getContext(), "Buy Now: " + product.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView productName;
        public TextView productPrice;
        public ImageView productImage;
        public Button btnAddToCart;
        public Button btnBuyNow;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
            btnBuyNow = itemView.findViewById(R.id.btnBuyNow);
        }
    }
}
