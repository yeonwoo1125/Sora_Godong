package mirim.msg.sora_godong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.text.SimpleDateFormat;
import java.util.Date;

//db와 관련된 작업을 하는 클래스
public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "calendar_db";
    private final String TABLE_NAME = "calendar";

    //생성자
    public DbHelper(@Nullable Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    //table 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE calendar(today_date VARCHAR(20) NOT NULL, question TEXT, answer TEXT, today_diary TEXT, PRIMARY KEY(today_date))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insertDiary(SQLiteDatabase db, String content, String todayDate){
        ContentValues contentValues = new ContentValues();
        contentValues.put("today_date",todayDate);
        contentValues.put("today_diary",content);

        db.insert(TABLE_NAME,null, contentValues);
    }

    //db에 저장된 날짜 확인
    public String selectDate(SQLiteDatabase db, String selectDate){
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE today_date = "+selectDate;
        Cursor cursor = db.rawQuery(sql, null);
        String date="";
        while(cursor.moveToNext()){
            date = cursor.getString(0);
        }
        cursor.close();

        return date;
    }

    //테스트 후 대답과 질문 가져오는 메서드 합칠 예정
    //질문 가져오는 메서드
    public String getQuestion(SQLiteDatabase db, String selectDate){
        String sql = "SELECT question FROM "+TABLE_NAME+" WHERE today_date = "+selectDate;
        Cursor cursor = db.rawQuery(sql, null);
        String question="";
        while(cursor.moveToNext()){
            question = cursor.getString(0);
        }
        cursor.close();

        return question;
    }

    //대답 가져오는 메서드
    public String getAnswer(SQLiteDatabase db, String selectDate){
        String sql = "SELECT answer FROM "+TABLE_NAME+" WHERE today_date = "+selectDate;
        Cursor cursor = db.rawQuery(sql, null);
        String answer="";
        while(cursor.moveToNext()){
            answer = cursor.getString(0);
        }
        cursor.close();

        return answer;
    }
    //질문 저장하는 메서드
    public void insertAsk(SQLiteDatabase db, String question){
        ContentValues contentValues = new ContentValues();
        contentValues.put("question",question);

        db.insert(TABLE_NAME,null, contentValues);
    }
    //답변 저장하는 메서드
    public void insertReAsk(SQLiteDatabase db, String answer){
        ContentValues contentValues = new ContentValues();
        contentValues.put("answer",answer);

        db.insert(TABLE_NAME,null, contentValues);
    }
    //
//    public String selectDiary(SQLiteDatabase db, String selectDiary){
//        String sql = "SELECT * FROM TABLE_NAME WHERE today_date = selectDiary";
//        Cursor c = db.rawQuery(sql, null);
//        String diary="";
//        while(c.moveToNext()) {
//            diary = c.getString(0);
//        }
//        c.close();
//        return diary;
//    }
}
