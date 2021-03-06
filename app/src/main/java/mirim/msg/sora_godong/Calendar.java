package mirim.msg.sora_godong;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.SimpleDateFormat;


public class Calendar extends AppCompatActivity{


    //캘린더 커스텀을 위해 깃허브 라이브러리를 사용
    MaterialCalendarView calendarView;
    SQLiteDatabase db;
    DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        LinearLayout linear1,linear2,linear3;
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);

        linear1.setOnClickListener(linearListner);
        linear2.setOnClickListener(linearListner);
        linear3.setOnClickListener(linearListner);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("나만의 캘린더에 저장해봐!");

        dbHelper = new DbHelper(this,4);
        db = dbHelper.getWritableDatabase();

        calendarView = (MaterialCalendarView) findViewById(R.id.calendar);

        //날짜 선택 시 다이어리 페이지 열림
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                Intent intent = new Intent(getApplicationContext(), Diary.class);
                intent.putExtra("date",getToday_date());
                startActivity(intent);
            }
        });

    }

    View.OnClickListener linearListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch(v.getId()) {
                case R.id.linear1:
                    intent = new Intent(getApplicationContext(),AskMain.class);
                    startActivity(intent);
                    break;
                case R.id.linear2:
                    intent = new Intent(getApplicationContext(),Calendar.class);
                    startActivity(intent);
                    break;
                case R.id.linear3:
                    intent = new Intent(getApplicationContext(),Luck.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    //캘린더의 날짜를 받아옴(yyyyMMdd)
    public String getToday_date() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(calendarView.getSelectedDate().getDate());
    }
}
