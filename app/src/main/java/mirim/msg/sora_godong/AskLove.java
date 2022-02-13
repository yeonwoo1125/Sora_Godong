package mirim.msg.sora_godong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AskLove extends AppCompatActivity {

    Button answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_love);

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
}
