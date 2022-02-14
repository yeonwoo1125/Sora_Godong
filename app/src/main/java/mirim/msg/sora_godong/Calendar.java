package mirim.msg.sora_godong;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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


public class Calendar extends AppCompatActivity{

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



        //날짜가 선택된 경우 실행하는 리스너
        //Diary 페이지를 보여줌
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {


        @Override
        public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
            Intent intent = new Intent(getApplicationContext(), Diary.class);

            startActivity(intent);
            }
        });
    }
          
        public String getToday_date() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            return simpleDateFormat.format((Date) calendarView.getSelectedDate().getDate()).toString();
        }
}
