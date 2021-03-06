package mirim.msg.sora_godong;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AskAnswer extends AppCompatActivity {
//    1번작업
    Button btn_go_calendar;
    Button btn_go_ask;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_answer);

        String[] answer = {
                "해봐", "하지마", "할라고?", "흠.그냥 그러네",
                "맞아", "아니야", "정말?", "거짓말",
                "이미 알고 있으면서", "답정너", "싫은데", "좋아",
                "진실을 말해", "과연..?", "멋진걸", "그럴리가",

                "와우", "ㅋㅋㅋㅋ", "망해", "너야말로",
                "틀렸어", "오른쪽 주머니", "주위를 봐", "집가고싶다",
                "무엇이든", "자니?", "뭐해~", "웃겨부러",
                "글쎄", "답답하다", "오늘은 집콕", "일단 나가"
        };

        int r = (int)(Math.random()*32);
        TextView aw = findViewById(R.id.bosal_answer);
        aw.setText(answer[r]);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("보살님께서 내리신 답변입니다!");
        home = findViewById(R.id.home);
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

        btn_go_ask = findViewById(R.id.btn_go_ask);

        btn_go_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskReAnswer.class);
                startActivity(intent);
                finish();
            }
        });
        LinearLayout linear1, linear2, linear3;
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);

        linear1.setOnClickListener(linearListner);
        linear2.setOnClickListener(linearListner);
        linear3.setOnClickListener(linearListner);
    }
    View.OnClickListener linearListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.linear1:
                    intent = new Intent(getApplicationContext(), AskMain.class);
                    startActivity(intent);
                    break;
                case R.id.linear2:
                    intent = new Intent(getApplicationContext(), Calendar.class);
                    startActivity(intent);
                    break;
                case R.id.linear3:
                    intent = new Intent(getApplicationContext(), Luck.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
