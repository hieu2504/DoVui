package vn.com.dovui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {


private long backPressedTime;
private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DoVuiSqlite doVuiSqlite=new DoVuiSqlite(this);
        doVuiSqlite.createDataBase();


        img=findViewById(R.id.img_xoay);
        Animation hh = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.img_xoay);
        img.startAnimation(hh);
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime+1>System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
        }

        backPressedTime=System.currentTimeMillis();
    }
}
