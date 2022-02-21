package mirim.msg.sora_godong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AskMoney extends AppCompatActivity {

    Button answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_money);

        answer = findViewById(R.id.btn_answer);

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskAnswer.class);
                startActivity(intent);
                finish();
            }
        });
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
