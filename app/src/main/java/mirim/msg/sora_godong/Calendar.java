package mirim.msg.sora_godong;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;


public class Calendar extends AppCompatActivity{


    //캘린더 커스텀을 위해 깃허브 라이브러리를 사용
    MaterialCalendarView calendarView;

    private DbHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        calendarView = (MaterialCalendarView) findViewById(R.id.calendar);

        //날짜 선택 시 다이어리 페이지 열림
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
        @Override
        public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
            Intent intent = new Intent(getApplicationContext(), Diary.class);
            startActivity(intent);
            }
        });

    }
}
