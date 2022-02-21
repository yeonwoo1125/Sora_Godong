package mirim.msg.sora_godong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AskMain extends AppCompatActivity {

    ImageView food, study, love, money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_main);

        food = findViewById(R.id.ask_food);
        study = findViewById(R.id.ask_study);
        love = findViewById(R.id.ask_love);
        money = findViewById(R.id.ask_money);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskFood.class);
                startActivity(intent);
                finish();
            }
        });
        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskStudy.class);
                startActivity(intent);
                finish();
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskLove.class);
                startActivity(intent);
                finish();
            }
        });
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskMoney.class);
                startActivity(intent);
                finish();
            }
        });

    }
}