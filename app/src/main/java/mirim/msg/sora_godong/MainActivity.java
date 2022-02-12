package mirim.msg.sora_godong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn, btn_luck,btn_ask;
        btn = (Button) findViewById(R.id.btn);
        btn_luck = findViewById(R.id.btn_luck);
        btn_ask = findViewById(R.id.btn_ask);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Calendar.class);
                startActivity(intent);
            }
        });
        btn_luck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Luck.class);
                startActivity(intent);
            }
        });
        btn_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskAnswer.class);
                startActivity(intent);
            }
        });
    }
}