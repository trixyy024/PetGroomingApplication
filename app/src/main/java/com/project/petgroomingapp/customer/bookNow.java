package com.project.petgroomingapp.customer;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.project.petgroomingapp.R;

import java.util.Calendar;
import java.util.Locale;

public class bookNow extends AppCompatActivity {
    private EditText datePickerEditText;
    private EditText timePickerEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_now);

        datePickerEditText = findViewById(R.id.datePickerEditText);
        datePickerEditText.setOnClickListener(view -> showDatePickerDialog());
        timePickerEditText = findViewById(R.id.timePickerEditText);
        timePickerEditText.setOnClickListener(view -> showTimePickerDialog());
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                R.style.CustomDatePickerDialog, // Apply custom style
                (view, year1, month1, dayOfMonth) -> {
                    // Increment month1 by 1 since month starts from 0
                    String selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                    datePickerEditText.setText(selectedDate);
                },
                year,
                month,
                day
        );
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        boolean is24HourFormat = false;

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                R.style.CustomTimePickerDialog, // Apply custom style
                (view, hourOfDay, minuteOfHour) -> {
                    // Convert 24-hour time to 12-hour time
                    String amPm = hourOfDay >= 12 ? "PM" : "AM";
                    int hourIn12Format = hourOfDay % 12;
                    if (hourIn12Format == 0) {
                        hourIn12Format = 12; // Handle midnight as 12:xx AM
                    }

                    // Format the selected time
                    String selectedTime = String.format(
                            Locale.getDefault(), "%02d:%02d %s", hourIn12Format, minuteOfHour, amPm
                    );
                    timePickerEditText.setText(selectedTime);
                },
                hour,
                minute,
                is24HourFormat
        );
        timePickerDialog.show();
    }
}