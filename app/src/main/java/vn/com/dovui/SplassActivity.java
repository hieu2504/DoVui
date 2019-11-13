package vn.com.dovui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplassActivity extends AppCompatActivity {

private ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splass);

      final Intent intent =new Intent(SplassActivity.this,HomeActivity.class);
        img=findViewById(R.id.img_logo);
        Animation hh = AnimationUtils.loadAnimation(SplassActivity.this, R.anim.splass_logo);
        img.startAnimation(hh);



        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                HomeActivity.nhac=0;
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in,
                        R.anim.slide_out);
                finish();
            }
        },2800);





        // chỉ chạy animation đc lần đầu, những lần sau bị về mặc định
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    Thread.sleep(2800);
//
//
//                }catch (Exception e){
//
//                }finally {
//
//
//
//                }
//
//            }
//        });
//        thread.start();
    }




}
