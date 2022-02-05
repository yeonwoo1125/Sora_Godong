package mirim.msg.sora_godong;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;
    TextView textView;
    EditText editText;
    Button btnSave;

    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (CalendarView) findViewById(R.id.calendar);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.edtText);
        btnSave = (Button) findViewById(R.id.btnSave);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                month += 1;
                textView.setText(year + "년 " + month + "월 " + day + "일");
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                saveDiary(fileName);
                String str=editText.getText().toString();
                textView.setText(str);
                btnSave.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void saveDiary(String fileName) {
        FileOutputStream fos = null;

        try {
            fos=openFileOutput(fileName,Context.MODE_WORLD_WRITEABLE);
            String content = editText.getText().toString();
            fos.write((content).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
