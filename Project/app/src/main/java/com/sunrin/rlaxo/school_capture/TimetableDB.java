package com.sunrin.rlaxo.school_capture;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimetableDB extends SQLiteOpenHelper {
    public TimetableDB(Context context) {
        super(context, "timetalbe_table", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TIMETABLE (_id STRING PRIMARY KEY AUTOINCREMENT, " +
                "first INTEGER, second INTEGER, third INTEGER, forth INTEGER, fifth INTEGER, sixth INTEGER, seventh INTEGER, eighth INTEGER);");

        //db.execSQL("INSERT INTO TIMETABLE VALUES('"+ 월 + ', );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void update(String day, int price, int classtime) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행의 가격 정보 수정
        switch (classtime)
        {
            case 1:
                db.execSQL("UPDATE INTO TIMETABLE VALUES('" +  day + "', " + classtime + "');");
                break;
            case 2:
                db.execSQL("UPDATE INTO TIMETABLE VALUES('" +  day + "', " + classtime + "');");
                break;
            case 3:
                db.execSQL("UPDATE INTO TIMETABLE VALUES('" +  day + "', " + classtime + "');");
                break;
            case 4:
                db.execSQL("UPDATE INTO TIMETABLE VALUES('" +  day + "', " + classtime + "');");
                break;
            case 5:
                db.execSQL("UPDATE INTO TIMETABLE VALUES('" +  day + "', " + classtime + "');");
                break;
            case 6:
                db.execSQL("UPDATE INTO TIMETABLE VALUES('" +  day + "', " + classtime + "');");
                break;
            case 7:
                db.execSQL("UPDATE INTO TIMETABLE VALUES('" +  day + "', " + classtime + "');");
                break;
            case 8:
                db.execSQL("UPDATE INTO TIMETABLE VALUES('" +  day + "', " + classtime + "');");
                break;
            default:

                break;



        }

        db.close();
    }


    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM TIMETABLE", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + " : "
                    + cursor.getString(1)
                    + " | "
                    + "\n";
        }

        return result;
    }
}
