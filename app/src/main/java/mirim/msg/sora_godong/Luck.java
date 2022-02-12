package mirim.msg.sora_godong;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Luck extends AppCompatActivity {
    LuckAnswer.myDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
    Animation luck_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        myDBHelper = new LuckAnswer.myDBHelper(this);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String getTime = sdf.format(date);

        sqlDB = myDBHelper.getReadableDatabase();

        // 디비에서 현재 날짜 검색 후 Cursor로 변환
        Cursor cursor = sqlDB.rawQuery("SELECT * FROM luckTB where testDate = '" + getTime + "';", null);

        luck_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.luck_anim);

        if(cursor.getCount() == 1){ // cursor 개수가 1개인지 확인(오늘 운세 확인을 했는지 확인)
            setContentView(R.layout.activity_luckanswer);
            String[] ret = getTime.split("-");

            TextView text1 = findViewById(R.id.text1);
            text1.setText(ret[1] + "월 " + ret[2] + "일 미니 운세");

            cursor.moveToFirst();

            TextView text2 = findViewById(R.id.text2);
            text2.setText(cursor.getString(1));

            TextView text3 = findViewById(R.id.text3);
            text3.setText("금전운  " + cursor.getString(2));

            TextView text4 = findViewById(R.id.text4);
            text4.setText("연애운  " + cursor.getString(3));

            TextView text5 = findViewById(R.id.text5);
            text5.setText("학업운  " + cursor.getString(4));

            TextView text6 = findViewById(R.id.text6);
            text6.setText("건강운  " + cursor.getString(5));

            TextView text7 = findViewById(R.id.text7);
            text7.setText(ret[1] + "월 " + ret[2] + "일 행운의 색");

            TextView text8 = findViewById(R.id.text8);
            text8.setText(cursor.getString(6));
        }else{
            setContentView(R.layout.activity_luck);
            Button btn;
            btn = findViewById(R.id.btn);
            ImageView imageView = findViewById(R.id.image);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.startAnimation(luck_anim);
                    btn.setVisibility(View.INVISIBLE); // 버튼 안 보이게 하기
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() { // 일정 시간 후 안에 코드 실행
                        @Override public void run() {
                            Intent intent = new Intent(getApplicationContext(), LuckAnswer.class);
                            startActivity(intent); // 인텐트(LuckAnswer) 실행
                            finish(); // 액티비티(Luck) 종료
                        }
                    },5850); // 5.85초 딜레이
                }
            });
        }
    }
}