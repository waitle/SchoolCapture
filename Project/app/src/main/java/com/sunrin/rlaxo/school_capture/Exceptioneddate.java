package com.sunrin.rlaxo.school_capture;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Exceptioneddate extends AppCompatActivity {

    ListView list;
    ExceptionDB exceptionDB;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exceptioneddate);

        list = findViewById(R.id.modifieddate);
        exceptionDB = new ExceptionDB(this);
        selectDB();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                cursor.moveToPosition(position);
                String str = cursor.getString(cursor.getColumnIndex("name"));
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void selectDB(){
        db = exceptionDB.getWritableDatabase();
        sql = "SELECT * FROM EXCEPTIONDATE;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            startManagingCursor(cursor);
            DatelistAdapter dbAdapter = new DatelistAdapter(this, cursor);
            list.setAdapter(dbAdapter);
        }
    }
    
}
