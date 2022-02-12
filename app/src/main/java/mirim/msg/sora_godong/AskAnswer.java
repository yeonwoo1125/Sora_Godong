package mirim.msg.sora_godong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AskAnswer extends AppCompatActivity {
//    1번작업
    Button btn_go_calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_answer);

//        2번째 작업
        btn_go_calendar = findViewById(R.id.btn_go_calendar);

//        3번째 작업
        btn_go_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
