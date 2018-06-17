package com.sunrin.rlaxo.school_capture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button timetableinput[][] = new Button[9][6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timetableinput[0][0] = findViewById(R.id.x0y0);
        timetableinput[0][1] = findViewById(R.id.x0y1);
        timetableinput[0][2] = findViewById(R.id.x0y2);
        timetableinput[0][3] = findViewById(R.id.x0y3);
        timetableinput[0][4] = findViewById(R.id.x0y4);
        timetableinput[0][5] = findViewById(R.id.x0y5);

        timetableinput[1][0] = findViewById(R.id.x1y0);
        timetableinput[1][1] = findViewById(R.id.x1y1);
        timetableinput[1][2] = findViewById(R.id.x1y2);
        timetableinput[1][3] = findViewById(R.id.x1y3);
        timetableinput[1][4] = findViewById(R.id.x1y4);
        timetableinput[1][5] = findViewById(R.id.x1y5);

        timetableinput[2][0] = findViewById(R.id.x2y0);
        timetableinput[2][1] = findViewById(R.id.x2y1);
        timetableinput[2][2] = findViewById(R.id.x2y2);
        timetableinput[2][3] = findViewById(R.id.x2y3);
        timetableinput[2][4] = findViewById(R.id.x2y4);
        timetableinput[2][5] = findViewById(R.id.x2y5);

        timetableinput[3][0] = findViewById(R.id.x3y0);
        timetableinput[3][1] = findViewById(R.id.x3y1);
        timetableinput[3][2] = findViewById(R.id.x3y2);
        timetableinput[3][3] = findViewById(R.id.x3y3);
        timetableinput[3][4] = findViewById(R.id.x3y4);
        timetableinput[3][5] = findViewById(R.id.x3y5);

        timetableinput[4][0] = findViewById(R.id.x4y0);
        timetableinput[4][1] = findViewById(R.id.x4y1);
        timetableinput[4][2] = findViewById(R.id.x4y2);
        timetableinput[4][3] = findViewById(R.id.x4y3);
        timetableinput[4][4] = findViewById(R.id.x4y4);
        timetableinput[4][5] = findViewById(R.id.x4y5);

        timetableinput[5][0] = findViewById(R.id.x5y0);
        timetableinput[5][1] = findViewById(R.id.x5y1);
        timetableinput[5][2] = findViewById(R.id.x5y2);
        timetableinput[5][3] = findViewById(R.id.x5y3);
        timetableinput[5][4] = findViewById(R.id.x5y4);
        timetableinput[5][5] = findViewById(R.id.x5y5);

        timetableinput[6][0] = findViewById(R.id.x6y0);
        timetableinput[6][1] = findViewById(R.id.x6y1);
        timetableinput[6][2] = findViewById(R.id.x6y2);
        timetableinput[6][3] = findViewById(R.id.x6y3);
        timetableinput[6][4] = findViewById(R.id.x6y4);
        timetableinput[6][5] = findViewById(R.id.x6y5);

        timetableinput[7][0] = findViewById(R.id.x7y0);
        timetableinput[7][1] = findViewById(R.id.x7y1);
        timetableinput[7][2] = findViewById(R.id.x7y2);
        timetableinput[7][3] = findViewById(R.id.x7y3);
        timetableinput[7][4] = findViewById(R.id.x7y4);
        timetableinput[7][5] = findViewById(R.id.x7y5);

        timetableinput[8][0] = findViewById(R.id.x8y0);
        timetableinput[8][1] = findViewById(R.id.x8y1);
        timetableinput[8][2] = findViewById(R.id.x8y2);
        timetableinput[8][3] = findViewById(R.id.x8y3);
        timetableinput[8][4] = findViewById(R.id.x8y4);
        timetableinput[8][5] = findViewById(R.id.x8y5);

        for (int i=0; i <= 8; i++) {
            for (int j=0; j <= 5; j++) {
                if (i == 0 || j == 0)
                    continue;
                timetableinput[i][j].setOnClickListener(this);
                //시간표DB에서 불러와 버튼 텍스트 설정
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.timetable_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exceptiontable:
                Intent setintent = new Intent(getApplicationContext(), ExceptionHandler.class);
                startActivity(setintent);
                return true;
            case R.id.showexceptioned:
                Intent getintent = new Intent(getApplicationContext(), Exceptioneddate.class);
                startActivity(getintent);
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onClick(View v) {
        //리스트어댑터에 과목DB반영
        //다이얼로그에 리스트어댑터호출
        //다이얼로그 활성화
        //시간표DB에 과목입력
        //해당 버튼에
        Button tempo = findViewById(v.getId());
        Toast.makeText(this, Integer.toString(tempo.getId()), Toast.LENGTH_SHORT).show();
    }
}
