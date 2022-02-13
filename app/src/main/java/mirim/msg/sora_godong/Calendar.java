package mirim.msg.sora_godong;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Calendar extends AppCompatActivity{


    //캘린더 커스텀을 위해 깃허브 라이브러리를 사용
    MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        calendarView = (MaterialCalendarView) findViewById(R.id.calendar);

        public String getToday_date() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format((Date) calendarView.getSelectedDate().getDate());
        }


        //날짜가 선택된 경우 실행하는 리스너
        //Diary 페이지를 보여줌
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {


        @Override
        public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
            Intent intent = new Intent(getApplicationContext(), Diary.class);
            int year = widget.getSelectedDate().getYear();
            int month = widget.getSelectedDate().getMonth();
            int day = widget.getSelectedDate().getDay();

            String Today_date = year + "-" + month+1 + "-" + day;
            Toast.makeText(getApplicationContext(), Today_date, Toast.LENGTH_SHORT).show();
            //선택한 날짜를 Diary 페이지로 넘김
            intent.putExtra("date", calendarView.getSelectedDate().toString());
            startActivity(intent);
            }
        });

        //유저의 질문을 받아 question에 적용하는 메서드

        //보살의 답을 받아 answer에 적용하는 메서드
    }
}
