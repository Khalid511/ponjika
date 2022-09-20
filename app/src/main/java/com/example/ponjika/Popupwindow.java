package com.example.ponjika;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TimePicker;

public class Popupwindow {

    Button buttonOk, buttonCancel;
    TimePicker selectTime;

    public void showPopupwindow(View view, Button reminder) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_card_window_time, null);

        //specify height and width
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;

        //not display inactive item inside window
        boolean focusable = true;

        //create window
         PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
         popupWindow.showAtLocation(view, Gravity.TOP, 0, 0);

         //set click operation on two buttons- Ok, Cancel
         buttonOk = (Button) popupView.findViewById(R.id.ok_button);
         buttonCancel = (Button) popupView.findViewById(R.id.cancel_button);
         selectTime = (TimePicker) popupView.findViewById(R.id.select_time);

         String hour = selectTime.getCurrentHour().toString();
         String minute = selectTime.getCurrentMinute().toString();

         buttonOk.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 reminder.setText("reminder time - "+hour+":"+minute);
                 reminder.setTextSize(11);
                 popupWindow.dismiss();
             }
         });
         buttonCancel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 popupWindow.dismiss();
             }
         });

//        popupView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                popupWindow.dismiss();
//                return true;
//            }
//        });
    }
}
