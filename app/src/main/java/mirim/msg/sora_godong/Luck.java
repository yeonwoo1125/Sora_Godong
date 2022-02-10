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
        sqlDB.execSQL("delete from luckTB where testDate = '2022-02-11'");

        Cursor cursor = sqlDB.rawQuery("SELECT * FROM luckTB where testDate = '" + getTime + "';", null);

        luck_anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.luck_anim);

        if(cursor.getCount() == 1){
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
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btn.startAnimation(luck_anim);
                    Intent intent = new Intent(getApplicationContext(), LuckAnswer.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}