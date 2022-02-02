package mirim.msg.sora_godong;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        calendarView = (CalendarView) findViewById(R.id.calendar);
        textView = (TextView) findViewById(R.id.textView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                month+=1;
                textView.setText(year+"년 "+month+"월 "+day+"일");
            }
        });
    }

}
