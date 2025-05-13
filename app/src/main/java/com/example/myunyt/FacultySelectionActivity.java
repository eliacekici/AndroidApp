package com.example.myunyt;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FacultySelectionActivity extends AppCompatActivity {

    public static final String FACULTY_ECONOMY = "Economy and Business";
    public static final String FACULTY_LAW = "Law and Social Sciences";
    public static final String FACULTY_ENGINEERING = "Engineering and Architecture";
    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculties);

        dbHelper = new DatabaseHelper(this);

        findViewById(R.id.facultyEconomy).setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfessorsActivity.class);
            intent.putExtra("FACULTY", "Economy and Business");
            startActivity(intent);
        });

        findViewById(R.id.facultyLaw).setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfessorsActivity.class);
            intent.putExtra("FACULTY", "Law and Social Sciences");
            startActivity(intent);
        });

        findViewById(R.id.facultyEngineering).setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfessorsActivity.class);
            intent.putExtra("FACULTY", "Engineering and Architecture");
            startActivity(intent);
        });

        findViewById(R.id.backButton).setOnClickListener(v -> finish());
    }
}