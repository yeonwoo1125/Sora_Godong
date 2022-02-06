package mirim.msg.sora_godong;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Diary extends AppCompatActivity {

    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        answer = (TextView) findViewById(R.id.answer);

        //선택된 날짜를 받아와 answer 부분에 넣어줌 / 테스트용, 달이 1씩 작게 나옴
        Intent intent=getIntent();
        answer.setText(intent.getStringExtra("date"));
    }
}
