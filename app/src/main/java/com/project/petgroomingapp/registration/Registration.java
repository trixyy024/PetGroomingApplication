package com.project.petgroomingapp.registration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.project.petgroomingapp.Login;
import com.project.petgroomingapp.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Registration extends AppCompatActivity {

   /** private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "GoogleSignIn";

    public GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
**/
    Button googleContinue;
    TextView textViewLogin;
    Spinner userSpinner;
    Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textViewLogin = findViewById(R.id.btnLogin);
        userSpinner = findViewById(R.id.userSpinnerSignup);
        signupBtn = findViewById(R.id.btnSignUp);
        googleContinue = findViewById(R.id.continue_google);

        signupBtn.setOnClickListener(v -> {
            String selectedUserTypeSignup = userSpinner.getSelectedItem().toString();
            switch (selectedUserTypeSignup) {
                case "Admin":
                    // Handle Admin sign up
                    break;
                case "Groomer":
                    // Handle Groomer sign up
                    break;
                case "Customer":
                    Intent intent = new Intent(Registration.this, RegisteringAccount.class);
                    startActivity(intent);
                    break;
            }
        });
/**
        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign-In options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Initialize GoogleSignInClient
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Set the Google Sign-In button click listener
        googleContinue.setOnClickListener(v -> signIn());

        textViewLogin.setOnClickListener(v -> {
            Intent intent = new Intent(Registration.this, Login.class);
            startActivity(intent);
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check which request we're responding to
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign-In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign-In failed
                Log.w(TAG, "Google sign in failed", e);
                Toast.makeText(this, "Google sign in failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign-in success, update UI with signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign-in fails, display a message to the user
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(Registration.this, "Authentication Failed.", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            // User is signed in
            String welcome = "Welcome, " + user.getDisplayName() + "!";
            Toast.makeText(this, welcome, Toast.LENGTH_LONG).show();
        } else {
            // User is signed out
            Toast.makeText(this, "Please sign in to continue", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if the user is already signed in and update the UI accordingly
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);**/
    }
}
