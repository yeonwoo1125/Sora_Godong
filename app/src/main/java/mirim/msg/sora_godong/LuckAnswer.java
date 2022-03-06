package mirim.msg.sora_godong;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LuckAnswer extends AppCompatActivity{
    myDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luckanswer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("당신의 오늘 운세입니다!");

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String getTime = sdf.format(date);
        String[] ret = getTime.split("-");

        String[] luckTotalAnswer = {
                "기쁜 소식이 있을 것 같아요. 노력에 대한 결과가 숫자로 나타날 거예요. 미용이나 옷에 대한 투자는 행운을 불러 올 거예요.",
                "걸림돌이 없어져 문제가 원활하게 해결되고 심신이 편안할 것 같아요. 건강 유지를 위한 운동을 시작하길 추천드려요.",
                "대인 관계가 좋아질 것 같아요. 주변에서 당신의 요청 사항을 잘 들어줄 것 같아요. 감사의 표현을 잊지 마세요.",
                "작은 쇼핑도 좋은 기분 전환이 돼요. 처음 방문하는 샵에서 기쁜 서비스를 받을 것 같아요. 인터넷 쇼핑도 좋아요.",
                "커리어를 업그레이드할 기회가 생길 것 같아요. 이직을 생각해 보는 것도 괜찮아요. 당신에게 맞는 천직을 찾을 수 있어요.",
                "새로운 목표를 찾아보세요. 너무 어려운 것보다 할 수 있는 것부터 차근차근 시작해 보세요.",
                "운의 흐름이 좋은 날이 아니에요. 이것저것 하려 하지 말고 지켜보는 것이 좋아요. 혼자서 무리하면 안 돼요.",
                "남을 너무 우선시해서 후회하게 될 수 있어요. 자신도 모르는 사이에 스트레스가 쌓일 것 같아요. 본인이 즐길 수 있는 시간을 확보하세요.",
                "불안감이 증가하기 쉬운 날이에요. 일어나지 않는 문제에 대한 걱정으로 인해 운세도 다운될 수 있어요. 복고풍 패션이 운기를 반전 시킬 수 있어요.",
                "여러 사람에게 신경을 쓰면 피곤해요. 자신만의 공간에서 자기 자신을 위한 시간을 가지세요.",
                "신뢰 관계를 망가뜨리지 않도록 주의하세요. 작은 약속도 확실히 지키는 것이 좋아요.",
                "계획대로 진행이 되지 않아 힘이 빠질 수 있어요. 우울해 하지 말고 잠시 쉬어가세요. 에너지를 재충전한 뒤 다시 시작하세요.",
                "당신의 재능과 매력이 꽃필 것 같아요. 어른의 조언을 귀담아 들으세요. 해외 뉴스를 눈 여겨 보세요.",
                "개성 있는 모습을 보여주세요. 당신의 아이디어가 인정받을 수 있어요. 특이하다는 이야기는 칭찬으로 받아들이세요.",
                "쇼핑에서는 실용성을 중요시 하세요. 디자인을 중요시하면 금방 질릴 수 있어요. 선물을 선택할 때는 시간을 들여서 신중히 하세요.",
                "힘든 사람에게 상담을 해주세요. 당신의 미소와 상냥한 말투가 기분을 좋게 해줄 거예요.",
                "결정하기 힘든 문제를 결정할 수 있어요. 당신을 응원해 주는 동료가 나타날 것 같아요. 나쁜 것은 확실히 잘라내고 가야 해요.",
                "다소 부정적인 생각을 가지는 경향이 있어요. 긍정적인 마인드로 주변 사람을 따뜻하게 응원해 주세요.",
                "비밀이나 거짓말이 발각되기 쉬운 날이에요. 친구와의 신뢰 관계에 금이 생길 수 있어요. 사과할 때는 성의 있는 모습을 보이세요.",
                "기회를 놓쳐서 후회하는 사건이 생길 수 있어요. 너무 신중하게 행동하는 것이 마이너스 요소가 될 수 있어요.",
                "다소 혼란스러운 하루가 될 것 같아요. 갑작스럽게 일정이 변경될 수 있어요. 평소보다 빨리 행동하세요.",
                "불안한 요소를 그대로 두면 문제가 심각해질 수 있어요. 당신이 의심 받을 수 있어요. 솔직한 마음으로 토론을 하는 것이 최선의 방법이에요.",
                "타인의 목소리에 귀를 기울이지 않아 고립되어 버릴 우려가 있어요. 억지 부리면 안 돼요. 주위의 이야기를 존중해 주세요.",
                "창의력이 개화할 것 같아요. 창작 의욕이 솟으면 무언가 제작을 해보세요. SNS를 통해 당신의 능력을 보여주세요. 칭찬 받을 수 있어요.",
                "불편한 관계를 개선할 수 있을 것 같아요. 마음을 솔직하게 전하세요. 응어리가 풀리고 정이 깊어질 수 있어요.",
                "중요한 업무를 맡게 될 것 같아요. 실력을 발휘할 수 있는 기회예요. 사랑은 적극적인 어필이 성취의 열쇠예요.",
                "해외에 관한 뉴스에 행운이 있어요. 외국의 문화나 언어 공부를 해보세요. 쇼핑은 수입품을 취급하는 가게가 숨은 명소예요.",
                "당신에 대한 평가가 급상승 할 것 같아요. 정교한 업무 수행으로 인정을 받을 수 있어요. 앞으로 나서서 적극적으로 움직여도 좋아요.",
                "동기 부여가 넘치는 하루예요. 겁먹지 말고 과감하게 도전해도 좋아요. 처음 경험하는 분야에서 새로운 재능을 발견할 거예요.",
                "당신의 센스가 주목 받을 수 있어요. 참신한 아이템으로 멋지게 꾸며 보세요. 새로운 매력이 발산될 거예요."

        };
        double randDouble1 = Math.random();
        int randInt1 = (int)(randDouble1 * luckTotalAnswer.length);

        String[] stars = {
                "⭐", "⭐⭐", "⭐⭐⭐", "⭐⭐⭐⭐", "⭐⭐⭐⭐⭐"
        };
        String[] luckAnswer = new String[4];
        for(int i = 0; i < luckAnswer.length; i++){
            double randDouble2 = Math.random();
            int randInt2 = (int)(randDouble2 * stars.length);
            luckAnswer[i] = stars[randInt2];
        }

        String[] luckColor = {
                "검정색", "주황색", "노란색", "베이지색",
                "빨간색", "회색", "핑크색", "초록색",
                "남색", "금색", "하늘색", "보라색",
                "갈색", "은색", "흰색", "연두색"
        };
        double randDouble3 = Math.random();
        int randInt3 = (int)(randDouble3 * luckColor.length);

        TextView text1 = findViewById(R.id.text1);
        text1.setText(ret[1] + "월 " + ret[2] + "일 미니 운세");

        TextView text2 = findViewById(R.id.text2);
        text2.setText(luckTotalAnswer[randInt1]);

        TextView text3 = findViewById(R.id.text3);
        text3.setText("금전운  " + luckAnswer[0]);

        TextView text4 = findViewById(R.id.text4);
        text4.setText("연애운  " + luckAnswer[1]);

        TextView text5 = findViewById(R.id.text5);
        text5.setText("학업운  " + luckAnswer[2]);

        TextView text6 = findViewById(R.id.text6);
        text6.setText("건강운  " + luckAnswer[3]);

        TextView text7 = findViewById(R.id.text7);
        text7.setText(ret[1] + "월 " + ret[2] + "일 행운의 색");

        TextView text8 = findViewById(R.id.text8);
        text8.setText(luckColor[randInt3]);

        myDBHelper = new myDBHelper(this);

        try{
            sqlDB = myDBHelper.getWritableDatabase();
            // 운세 결과 디비에 저장
            sqlDB.execSQL("INSERT INTO luckTB VALUES ('" + getTime + "', '" + luckTotalAnswer[randInt1] + "' , '" + luckAnswer[0] + "' , '" + luckAnswer[1] + "', '" + luckAnswer[2] + "', '" + luckAnswer[3] + "', '" + luckColor[randInt3] + "');");
            sqlDB.close();
        }catch (Exception e){ // 예외가 발생하면
            finish(); // 액티비티(LuckAnswer) 종료
        }

        LinearLayout linear1, linear2, linear3;
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);

        linear1.setOnClickListener(linearListner);
        linear2.setOnClickListener(linearListner);
        linear3.setOnClickListener(linearListner);

    }

    static class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE luckTB (testDate DATE PRIMARY KEY, luckTotal VARCHAR, moneyAnswer VARCHAR, loveAnswer VARCHAR, studyAnswer VARCHAR, healthAnswer VARCHAR, color VARCHAR);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS luckTB");
            onCreate(db);

        }
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                Intent intent = new Intent(getApplicationContext(), Luck.class);
                startActivity(intent);
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}