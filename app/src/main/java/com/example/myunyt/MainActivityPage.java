package com.example.myunyt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

public class MainActivityPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);

        TextView dateTextView = findViewById(R.id.dateTextView);
        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        LinearLayout transportationButton = findViewById(R.id.transportationButton);
        FrameLayout academicCalendarButton = findViewById(R.id.academicCalendarButton);
        FrameLayout voteButton = findViewById(R.id.voteButton);

        String currentDate = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault()).format(new Date());
        dateTextView.setText(currentDate);

        String studentName = "Elia";
        welcomeTextView.setText("Welcome Back, " + studentName);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        academicCalendarButton.setOnClickListener(v ->
                startActivity(new Intent(this, AcademicCalendarActivity.class)));

        transportationButton.setOnClickListener(v ->
                startActivity(new Intent(this, TransportationActivity.class)));

        voteButton.setOnClickListener(v ->
                startActivity(new Intent(this, FacultySelectionActivity.class)));
    }
}
