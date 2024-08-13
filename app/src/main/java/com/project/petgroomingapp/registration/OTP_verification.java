
package com.project.petgroomingapp.registration;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.petgroomingapp.R;
import com.project.petgroomingapp.Utils.AndroidUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OTP_verification extends AppCompatActivity {

 String phoneNumber;
 Long timeoutSeconds = 60L;
 String verificationCode;
 PhoneAuthProvider.ForceResendingToken resendingToken;


 Button verify;
 ProgressBar progressBar;
 TextView resentOtpTextView;
 FirebaseAuth mAuth = FirebaseAuth.getInstance();
 EditText code1, code2, code3, code4, code5, code6;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_otp_verification);

  TextView textMobile = findViewById(R.id.textMobile);

  // Retrieve the phone number from the Intent
  phoneNumber = getIntent().getStringExtra("phone");  // Use getStringExtra directly

  // Check if the phone number is not null and set it to the TextView
  if (phoneNumber != null) {
   textMobile.setText(String.format(phoneNumber));
  } else {
   textMobile.setText("Phone number not available");
  }

  code1 = findViewById(R.id.code1);
  code2 = findViewById(R.id.code2);
  code3 = findViewById(R.id.code3);
  code4 = findViewById(R.id.code4);
  code5 = findViewById(R.id.code5);
  code6 = findViewById(R.id.code6);


  verify = findViewById(R.id.verifyBtn);
  progressBar = findViewById(R.id.progressBar);
  resentOtpTextView = findViewById(R.id.resendOtp);
  setUpOTPCodes();

  phoneNumber = getIntent().getExtras().getString("phone");
  sendOtp(phoneNumber, false);

 }
 void sendOtp(String phoneNumber, boolean isResend){
  setInProgress(true);
  PhoneAuthOptions.Builder builder =
          PhoneAuthOptions.newBuilder(mAuth)
                  .setPhoneNumber(phoneNumber)
                  .setTimeout(timeoutSeconds, TimeUnit.SECONDS)
                  .setActivity(this)
                  .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                   @Override
                   public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    signIn(phoneAuthCredential);
                    setInProgress(false);
                   }

                   @Override
                   public void onVerificationFailed(@NonNull FirebaseException e) {
                    Log.e("OTP_verification", "Verification failed: " + e.getMessage());

                    AndroidUtils.showToast(getApplicationContext(), "OTP Verification failed");
                    setInProgress(false);
                   }

                   @Override
                   public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    verificationCode = s;
                    resendingToken = forceResendingToken;
                    AndroidUtils.showToast(getApplicationContext(), "OTP sent successfully");
                    setInProgress(false);
                   }



                  });

  if(isResend){
   PhoneAuthProvider.verifyPhoneNumber(builder.setForceResendingToken(resendingToken).build());
  }else{
   PhoneAuthProvider.verifyPhoneNumber(builder.build());

  }
 }
 void setInProgress(boolean inProgress){
  if (!inProgress) {
   progressBar.setVisibility(View.GONE);
  } else {
   progressBar.setVisibility(View.GONE);
  }
 }


 void signIn(PhoneAuthCredential phoneAuthCredential){
  //login and go to next activity
 }

 // Initialize ProgressBar here


  void setUpOTPCodes() {
  code1.addTextChangedListener(new TextWatcher() {
   @Override
   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
   }

   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
    if (!s.toString().trim().isEmpty()) {
     code2.requestFocus();
    }
   }

   @Override
   public void afterTextChanged(Editable s) {
   }
  });

  code2.addTextChangedListener(new TextWatcher() {
   @Override
   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
   }

   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
    if (!s.toString().trim().isEmpty()) {
     code3.requestFocus();
    }
   }

   @Override
   public void afterTextChanged(Editable s) {
   }
  });

  code3.addTextChangedListener(new TextWatcher() {
   @Override
   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
   }

   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
    if (!s.toString().trim().isEmpty()) {
     code4.requestFocus();
    }
   }

   @Override
   public void afterTextChanged(Editable s) {
   }
  });

  code4.addTextChangedListener(new TextWatcher() {
   @Override
   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
   }

   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
    if (!s.toString().trim().isEmpty()) {
     code5.requestFocus();
    }
   }

   @Override
   public void afterTextChanged(Editable s) {
   }
  });

  code5.addTextChangedListener(new TextWatcher() {
   @Override
   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
   }

   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
    if (!s.toString().trim().isEmpty()) {
     code6.requestFocus();
    }
   }

   @Override
   public void afterTextChanged(Editable s) {
   }
  });


 }}
