package com.example.ponjika;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class Popupwindow {




    public void showPopupwindow(View view) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_card_window_time, null);

        //specify height and width
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        int width = LinearLayout.LayoutParams.MATCH_PARENT;

        //not display inactive item inside window
        boolean focusable = true;

        //create window
         PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
         popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}
