package com.example.activity_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View v){
        String welcome = "Click notification to show confession";
        EditText editText_fullName = findViewById(R.id.editText_fullName);
        EditText editText_course = findViewById(R.id.editText_course);
        EditText editText_message = findViewById(R.id.editText_message );

        String fullName = editText_fullName.getText().toString();
        String course = editText_course.getText().toString();
        String message = editText_message.getText().toString();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("You have a new notification!");
        builder.setContentText(welcome);
        builder.setSmallIcon(R.drawable.baseline_emoji_objects_24);
        builder.setAutoCancel(true);

        Intent i = new Intent(this, viewMessage.class );
        i.putExtra("full_name", fullName);
        i.putExtra("enrolled_course", course);
        i.putExtra("message", message);

        PendingIntent pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        NotificationManager n = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        n.notify(0, builder.build());
    }
}