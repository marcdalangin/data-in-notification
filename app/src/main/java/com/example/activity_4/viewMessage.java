package com.example.activity_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class viewMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        TextView textView_senderName = findViewById(R.id.textView_senderName);
        TextView textView_course = findViewById(R.id.textView_course);
        TextView textView_message = findViewById(R.id.textView_message);

        Intent i = getIntent();
        String name = i.getStringExtra("full_name");
        String course = i.getStringExtra("enrolled_course");
        String message = i.getStringExtra("message");

        textView_senderName.setText(name);
        textView_course.setText(course);
        textView_message.setText(message);

    }
}