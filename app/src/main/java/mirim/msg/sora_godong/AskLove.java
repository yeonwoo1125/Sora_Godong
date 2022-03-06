package mirim.msg.sora_godong;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AskLove extends AppCompatActivity {

    Button answer;
    SQLiteDatabase db;
    DbHelper dbHelper;
    EditText inputAsk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_love);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("사랑운보살님 안녕하세요");

        dbHelper = new DbHelper(this,4);
        db = dbHelper.getWritableDatabase();

        answer =    findViewById(R.id.btn_answer);
        inputAsk = findViewById(R.id.input_ask);

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = inputAsk.toString();
                dbHelper.insertAsk(db, question);
                Log.d("ask", ""+question);

//                Intent intent = new Intent(getApplicationContext(), AskAnswer.class);
//                startActivity(intent);
//                finish();
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
