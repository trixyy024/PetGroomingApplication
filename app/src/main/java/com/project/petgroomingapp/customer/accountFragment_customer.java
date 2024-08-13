package com.project.petgroomingapp.customer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.project.petgroomingapp.R;
import com.project.petgroomingapp.Utils.AndroidUtils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class accountFragment_customer extends Fragment {


    private TextView editInfoButton;
    private TextView addPetButton;
    private TextView editTagButton;
    private ImageView profilePic;
    private ActivityResultLauncher<Intent> imagePickLauncher;
    private Uri selectedImageUri;

    public accountFragment_customer() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imagePickLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null && data.getData() != null) {
                            selectedImageUri = data.getData();
                            AndroidUtils.setProfilePic(getContext(),selectedImageUri,profilePic);



                        }
                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_customer, container, false);

        profilePic = view.findViewById(R.id.profilePic);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        editInfoButton = view.findViewById(R.id.btnEditInfo);
        addPetButton = view.findViewById(R.id.btnAddpet);
        editTagButton = view.findViewById(R.id.btnEditTag);

        setupToolbar(toolbar);
        setupListeners();

        return view;
    }

    private void setupToolbar(Toolbar toolbar) {
        // Customize the toolbar here if needed
    }

    private void setupListeners() {

        editInfoButton.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Edit info clicked", Toast.LENGTH_SHORT).show();
        });

        addPetButton.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Pet Added", Toast.LENGTH_SHORT).show();
        });

        editTagButton.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Tag edited", Toast.LENGTH_SHORT).show();
        });

        profilePic.setOnClickListener((v)->{
            ImagePicker.with(this).cropSquare().compress(512).maxResultSize(512,512)
                    .createIntent(new Function1<Intent, Unit>() {
                        @Override
                        public Unit invoke(Intent intent) {

                            imagePickLauncher.launch(intent);
                            return null;
                        }
                    });
        });
    }
}
