package mirim.msg.sora_godong;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class AskStudy extends AppCompatActivity {

    Button answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_study);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("학업운보살님 안녕하세요");
        
        answer = findViewById(R.id.btn_answer);

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskAnswer.class);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                Intent intent = new Intent(getApplicationContext(), AskMain.class);
                startActivity(intent);
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
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
