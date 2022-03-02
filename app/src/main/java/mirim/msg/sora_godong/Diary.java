package mirim.msg.sora_godong;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;


public class Diary extends AppCompatActivity {

    Button btnSave;
    EditText todayDiary;
    TextView todayDate;

    SQLiteDatabase db;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        dbHelper = new DbHelper(this,4);
        db = dbHelper.getWritableDatabase();

        btnSave = findViewById(R.id.btnSave);
        todayDiary = findViewById(R.id.today_diary);
        todayDate = findViewById(R.id.today_date);

        Intent intent=getIntent();
        String date = intent.getStringExtra("date");
        todayDate.setText(date);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = todayDiary.getText().toString();
                dbHelper.insertDiary(db, content, date);
                Log.d("diary", ""+content);
            }
        });
    }
}
