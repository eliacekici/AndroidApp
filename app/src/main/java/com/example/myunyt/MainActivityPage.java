package com.example.myunyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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

    private TextView dateTextView;
    private TextView welcomeTextView;
    private FrameLayout academicCalendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);

        dateTextView = findViewById(R.id.dateTextView);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        LinearLayout transportationButton = findViewById(R.id.transportationButton);
        academicCalendarButton = findViewById(R.id.academicCalendarButton);

        String currentDate = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault()).format(new Date());
        dateTextView.setText(currentDate);

        String studentName = "Elia";
        welcomeTextView.setText("Welcome Back, " + studentName);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        academicCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityPage.this, AcademicCalendarActivity.class);
                startActivity(intent);
            }
        });

        transportationButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityPage.this, TransportationActivity.class);
            startActivity(intent);

        });

        FrameLayout voteButton = findViewById(R.id.voteButton);
        voteButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityPage.this, VoteActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }
}