package vn.com.dovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import vn.com.dovui.fragment.CMoiFragment;
import vn.com.dovui.R;
import vn.com.dovui.sqlite.DoVuiSqlite;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onStop() {
        super.onStop();

        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
            mediaPlayer.start();
    }

    private long backPressedTime;
    private ImageView img,img_sould;
    private MediaPlayer mediaPlayer;
    public static int nhac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        img_sould=findViewById(R.id.img_sould);

        // khởi tạo database
        DoVuiSqlite doVuiSqlite = new DoVuiSqlite(this);
        doVuiSqlite.createDataBase();
        if(nhac==0){
            playnhac();
        }
        if(nhac==0){
            img_sould.setImageResource(R.drawable.amthanh);
        }else {
            img_sould.setImageResource(R.drawable.tatam);
        }


        img_sould.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if(mediaPlayer.isPlaying() == true || nhac==0){
                        img_sould.setImageResource(R.drawable.tatam);
                        mediaPlayer.pause();
                        nhac=1;
                    }else {
                        img_sould.setImageResource(R.drawable.amthanh);
                        playnhac();
                        nhac=0;
                    }
                }catch (Exception e){
                    img_sould.setImageResource(R.drawable.amthanh);
                    playnhac();
                    nhac=0;
                }


            }
        });


        //Nhac uri
//        String url = "https://vnno-vn-6-tf-mp3-s1-zmp3.zadn.vn/5f2dd512dc5635086c47/3346812420700865921?authen=exp=1573652367~acl=/5f2dd512dc5635086c47/*~hmac=7a05b070c06d9a41ef832994bc2b3de8&filename=A-Distant-Shade-of-Green-Kevin-Kern.mp3"; // your URL here
//
//        MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//
//        Uri uri=Uri.parse(url);
//
//        try {
//            mediaPlayer.setDataSource(this, uri);
//            mediaPlayer.prepare();
//            mediaPlayer.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(this,"Lỗi phát nhạc",Toast.LENGTH_SHORT).show();
//        }

        img = findViewById(R.id.img_xoay);
        Animation hh = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.img_xoay);
        img.startAnimation(hh);
    }

    // không cho back lại activity trc
    @Override
    public void onBackPressed() {
        if (backPressedTime + 1 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
        }

        backPressedTime = System.currentTimeMillis();
    }

    //btn Thoát
    public void btn_Thoat(View view) {
        finish();
    }

    public void btn_luatchoi(View view) {
        Intent intent = new Intent(this, LuatChoiActivity.class);
        startActivity(intent);
        finish();
    }

    public void playnhac() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(HomeActivity.this, R.raw.nhacnen);

        }
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    public void btn_choiMoi(View view) {
        Intent intent = new Intent(this, ChoiMoiActivity.class);
        CMoiFragment.diem=0;
        CMoiFragment.dongu=3;
        startActivity(intent);
        finish();
    }

    public void btn_diemCao(View view) {
        Intent intent = new Intent(this, DiemCaoActivity.class);
        startActivity(intent);
        finish();
    }
}
