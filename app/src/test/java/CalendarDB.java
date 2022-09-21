import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CalendarDB extends SQLiteOpenHelper {

    public CalendarDB(Context context) {
        super(context, "eventdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table eventDetails(Date TEXT, Time TEXT primary key, event_name TEXT, Description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists eventDetails");
    }

    public boolean insertEvent(String date, String time, String eventName, String eventDescription) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(); //put content in db
        contentValues.put("Date", date);
        contentValues.put("Time", time);
        contentValues.put("event_name", eventName);
        contentValues.put("Description", eventDescription);
        long results = db.insert("eventDetails", null, contentValues);
        if(results<0)
            return false;
        return true;
    }

    public Cursor getData(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from eventDetails where Date=date", null);
        return cursor;
    }
}
