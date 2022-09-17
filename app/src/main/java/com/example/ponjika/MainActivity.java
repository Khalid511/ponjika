package com.example.ponjika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    CalendarView calendarview;
    Button eventButton;
    EditText event_name, event_description;
    TimePicker event_time;
    CardView view_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);
        calendarview= findViewById(R.id.calendarView);
        eventButton = findViewById(R.id.event_button);
        event_name = findViewById(R.id.event_name);
        event_description = findViewById(R.id.event_description);
        event_time = findViewById(R.id.event_time);
        view_card = findViewById(R.id.card_view);

        calendarview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date =  "Clicked date\n"+String.valueOf(dayOfMonth) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
                textview.setText(date);
                eventButton.setVisibility(view.VISIBLE);
                eventButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                          view_card.setVisibility(view.VISIBLE);
//                        event_name.setVisibility(view.VISIBLE);
//                        event_description.setVisibility(view.VISIBLE);
//                        event_time.setVisibility(view.VISIBLE);
                          event_time.setIs24HourView(true);
                    }
                });

            }
        });
    }
}