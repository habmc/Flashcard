package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.cancel_button).setVisibility(View.INVISIBLE);
                findViewById(R.id.add_button).setVisibility(View.VISIBLE);
                finish();
            }
        });

        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                TextView question = findViewById(R.id.question_textview);
                TextView answer =  findViewById(R.id.answer_textview);
                data.putExtra("question", question.getText().toString()); // puts one string into the Intent, with the key as 'question'
                data.putExtra("answer", answer.getText().toString()); // puts another string into the Intent, with the key as 'answer'
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes this activity and pass data to the original activity that launched this activity
            }
        });
    }
}
