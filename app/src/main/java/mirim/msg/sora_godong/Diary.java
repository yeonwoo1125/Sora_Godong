package mirim.msg.sora_godong;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Diary extends AppCompatActivity {


    MaterialCalendarView calendarView;
    //Button btnSave;
    //EditText editText;
    TextView answer;
    //String fileName;
    //DbHelper dbHelper;
    //String sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);


        calendarView = (MaterialCalendarView) findViewById(R.id.calendar);


        //btnSave = (Button) findViewById(R.id.btnSave);
        //editText = (EditText) findViewById(R.id.todayDiary);
        answer = (TextView) findViewById(R.id.answer);

        //SQLiteDatabase db = dbHelper.getWritableDatabase();


            //선택된 날짜를 받아와 answer 부분에 넣어줌 / 테스트용, 달이 1씩 작게 나옴
            Intent intent = getIntent();
            answer.setText(intent.getStringExtra("date"));




        //String str = readDiary(fileName);
        //editText.setText(str);
        //btnSave.setEnabled(true);

        //btnSave.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //if(btnSave.getText().toString().equals("새로저장")){
                    //SQLiteDatabase db = dbHelper.getWritableDatabase();
                    //db.execSQL("insert into today_diary values('"+fileName+"','"+editText.getText().toString()+"')");
                    //db.close();
                    //Toast.makeText(Diary.this,"DB에 저장", Toast.LENGTH_SHORT).show();

    }

}


        //});
    //}
    //public String readDiary(String fName) {
        //String strDiary = null;
        //SQLiteDatabase db = dbHelper.getReadableDatabase();
        //db.execSQL("select * from today_diary where today_date = '"+fName+"',");
        //Cursor cursor = db.rawQuery(sql, null);
        //if(String.valueOf(cursor) == null) {
            //editText.setHint("일기가 없습니다.");
            //btnSave.setText("새로저장");
        //} else {
            //strDiary = cursor.getString(1);
            //btnSave.setText("수정하기");
        //}
        //cursor.close();
        //db.close();
        //return strDiary;
    //}
//}
