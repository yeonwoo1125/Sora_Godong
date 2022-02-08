package mirim.msg.sora_godong;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//db와 관련된 작업을 하는 클래스
public class DbHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "calendar_db";

    //생성자
    public DbHelper(@Nullable Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    //table 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE calendar(today_date VARCHAR(20) NOT NULL, question TEXT NOT NULL, today_diary TEXT, PRIMARY KEY(today_date))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS calendar");
        onCreate(db);
    }
}
