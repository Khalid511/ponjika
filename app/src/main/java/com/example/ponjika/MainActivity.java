package com.example.ponjika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    CalendarView calendarview;
    Button eventButton, time_reminder, buttonOk, buttonCancel, submitButton, showEvent;
    EditText event_name, event_description;
    CardView view_card;
    CalendarDB db;

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
        time_reminder = findViewById(R.id.reminder_time);
        view_card = findViewById(R.id.card_view);
        buttonOk = findViewById(R.id.ok_button);
        buttonCancel = findViewById(R.id.cancel_button);
        submitButton = findViewById(R.id.submit_button);
        showEvent = findViewById(R.id.show_event);
        db = new CalendarDB(this);
        //calendarview.setSelectedWeekBackgroundColor(Color.BLUE);
        //calendarview.setWeekSeparatorLineColor(Color.BLACK);
        calendarview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date =  "Clicked date\n"+String.valueOf(dayOfMonth) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
                String Date = String.valueOf(dayOfMonth) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
                textview.setText(date);
                eventButton.setVisibility(view.VISIBLE);
                showEvent.setVisibility(view.VISIBLE);
                eventButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                          view_card.setVisibility(view.VISIBLE);
//                        event_name.setVisibility(view.VISIBLE);
//                        event_description.setVisibility(view.VISIBLE);
//                        event_time.setVisibility(view.VISIBL
                          time_reminder.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                  Popupwindow window = new Popupwindow();
                                  window.showPopupwindow(v, time_reminder);

                              }
                          });
                        submitButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //String date = Date;
                                String time = time_reminder.getText().toString();
                                String eventName = event_name.getText().toString();
                                String eventDescription = event_description.getText().toString();
                                boolean insertData = db.insertEvent(Date, time, eventName, eventDescription);
                                if(insertData==true)
                                    Toast.makeText(MainActivity.this, "New event is added", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(MainActivity.this, "Error to add New event", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                });

//                showEvent.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Cursor result = db.getData(Date);
//
//                    }
//                });
            }
        });
    }
}