package com.example.myunyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

import com.example.myunyt.LocationFragment;
import com.example.myunyt.InformationFragment;

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
        LinearLayout informationButton = findViewById(R.id.informationButton);
        LinearLayout locationButton = findViewById(R.id.locationButton);
        FrameLayout container = findViewById(R.id.fragment_container);

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

        informationButton.setOnClickListener(v -> {
            toggleFragment(new InformationFragment());
        });

        locationButton.setOnClickListener(v -> {
            toggleFragment(new LocationFragment());
        });

    }

    private void toggleFragment(Fragment fragment) {
        FrameLayout container = findViewById(R.id.fragment_container);
        ScrollView scrollView = findViewById(R.id.mainScrollView);

        if (container.getVisibility() == View.VISIBLE) {
            container.setVisibility(View.GONE);
            getSupportFragmentManager().popBackStack();
        } else {
            container.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();

            scrollView.post(() -> scrollView.smoothScrollTo(0, container.getTop()));
        }
    }

    @Override
    public void onBackPressed() {
        FrameLayout container = findViewById(R.id.fragment_container);
        if (container.getVisibility() == View.VISIBLE) {
            container.setVisibility(View.GONE);
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
