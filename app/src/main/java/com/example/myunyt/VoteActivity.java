package com.example.myunyt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class VoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        // Set up back button
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // Get professors data (in a real app, this would come from a database/API)
        List<Professor> professors = getProfessorData();

        // Get reference to the container
        LinearLayout container = findViewById(R.id.professorsContainer);

        // Inflate and add a rating card for each professor
        LayoutInflater inflater = LayoutInflater.from(this);
        for (Professor professor : professors) {
            View cardView = inflater.inflate(R.layout.professor_rating_card, container, false);

            // Set professor data
            ImageView imageView = cardView.findViewById(R.id.professorImage);
            TextView nameView = cardView.findViewById(R.id.professorName);
            TextView courseView = cardView.findViewById(R.id.professorCourse);

            imageView.setImageResource(professor.getImageResId());
            nameView.setText(professor.getName());
            courseView.setText(professor.getCourse());

            // Store professor ID in the card's tag (for submission)
            cardView.setTag(professor.getId());

            container.addView(cardView);
        }

        // Set up submit button
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(v -> submitRatings(container, professors));
    }

    private List<Professor> getProfessorData() {
        // In a real app, this would come from a database or API
        List<Professor> professors = new ArrayList<>();
        professors.add(new Professor("1", "Esmeralda Bushi", "Calculus II", R.drawable.professor1));
        professors.add(new Professor("2", "Tahsin Ugurlu", "System Analysis And Design", R.drawable.professor2));
        professors.add(new Professor("3", "Kristi Gorea", "Mobile Application Development", R.drawable.professor3));
        return professors;
    }

    private void submitRatings(LinearLayout container, List<Professor> professors) {
        List<ProfessorRating> ratings = new ArrayList<>();

        // Collect ratings from all cards
        for (int i = 0; i < container.getChildCount(); i++) {
            View cardView = container.getChildAt(i);

            RatingBar ratingBar = cardView.findViewById(R.id.professorRating);
            EditText commentView = cardView.findViewById(R.id.professorComment);

            String professorId = (String) cardView.getTag();
            int rating = (int) ratingBar.getRating();
            String comment = commentView.getText().toString().trim();

            ratings.add(new ProfessorRating(professorId, rating, comment));
        }

        // Validate ratings (ensure all are rated)
        for (ProfessorRating rating : ratings) {
            if (rating.getRating() == 0) {
                Toast.makeText(this, "Please rate all professors", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Submit ratings (in a real app, this would go to a server)
        Toast.makeText(this, "Ratings submitted successfully!", Toast.LENGTH_SHORT).show();
        finish();
    }
}