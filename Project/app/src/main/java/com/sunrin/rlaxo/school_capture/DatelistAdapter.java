package com.sunrin.rlaxo.school_capture;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class DatelistAdapter extends CursorAdapter {
    public DatelistAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final TextView start = view.findViewById(R.id.startitem);
        final TextView end = view.findViewById(R.id.enditem);
        final TextView hipen = view.findViewById(R.id.hipen);
        final TextView count = view.findViewById(R.id.countitem);
        final TextView time = view.findViewById(R.id.timeitem);
        hipen.setVisibility(View.INVISIBLE);
        end.setVisibility(View.INVISIBLE);

        //start.setText(intTOstring(cursor.getInt(cursor.getColumnIndex("date"))));
        start.setText(cursor.getString(cursor.getColumnIndex("dates")));
        time.setText(cursor.getString(cursor.getColumnIndex("classtime")) + "분 수업  ");
        count.setText(cursor.getString(cursor.getColumnIndex("count")) + "교시");

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.datelistitem, parent, false);
        return v;
    }
    public String intTOstring(int date) {
        String y, m = null, d = null;
        int yearcount = 0;


        for (int i = 0; i <= date; i++) {
            if ((0 == (i % 4) && 0 != (i % 100)) || 0 == i % 400)
                date-=1;
            if (date / 365 == 0) {
                yearcount += 1;
                date-=365;
            }
            if (date < 365)
                break;

        }
        y = Integer.toString(yearcount);

        int defind = 0;
        for (int i = 0; i <= 11; i++) {
            if (date < 31) {
                m = Integer.toString(1);
                break;
            }
            if (i == 1) {
                if ((0 == (Integer.parseInt(y) % 4) && 0 != (Integer.parseInt(y) % 100)) || 0 == Integer.parseInt(y) % 400) {
                    date -= 31;
                    defind = 29;
                } else {
                    date -= 31;
                    defind = 28;
                }
            } else if (i == 2) {
                if ((0 == (Integer.parseInt(y) % 4) && 0 != (Integer.parseInt(y) % 100)) || 0 == Integer.parseInt(y) % 400) {
                    date -= 29;
                    defind = 31;
                } else {
                    date -= 28;
                    defind = 31;
                }

            } else if (i == 3) {
                date -= 31;
                defind = 30;

            } else if (i == 4) {
                date -= 30;
                defind = 31;

            } else if (i == 5) {
                date -= 31;
                defind = 30;

            } else if (i == 6) {
                date -= 30;
                defind = 31;

            } else if (i == 7) {
                date -= 31;
                defind = 31;

            } else if (i == 8) {
                date -= 31;
                defind = 30;

            } else if (i == 9) {
                date -= 30;
                defind = 31;

            } else if (i == 10) {
                date -= 30;
                defind = 31;

            } else if (i == 11) {
                date -= 30;
                defind = 31;

            }
            if (date < defind) {
                m = Integer.toString(i + 1);
                d = Integer.toString(date);
                break;
            }
        }
        return y + "-" + m + "-" + d;
    }

}
