package vn.com.dovui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.com.dovui.fragment.TinhDiemFragment;
import vn.com.dovui.fragment.CMoiFragment;
import vn.com.dovui.fragment.DungFragment;
import vn.com.dovui.R;
import vn.com.dovui.fragment.SaiFragment;

public class ChoiMoiActivity extends AppCompatActivity implements CMoiFragment.CmoiFragmentListener {

    private Fragment fragment;
    private ImageView img_back;
    private long backPressedTime;
    DungFragment dungFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_moi);

        img_back=findViewById(R.id.img_back_luatchoi);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChoiMoiActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        fragment = new CMoiFragment();
        loadFragment(fragment);


    }



    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // không cho back activity
    @Override
    public void onBackPressed() {
        if (backPressedTime + 1 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    public void onClickDung() {
        //Toast.makeText(this,"bbbb",Toast.LENGTH_SHORT).show();

        dungFragment=new DungFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, dungFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    public void onClickSai(){
        fragment = new SaiFragment();
        loadFragment(fragment);
    }
    public void onClickCmoi() {
        //Toast.makeText(this,"bbbb",Toast.LENGTH_SHORT).show();

        fragment = new CMoiFragment();
        loadFragment(fragment);


    }

    public void onClickTinhDiem() {
        //Toast.makeText(this,"bbbb",Toast.LENGTH_SHORT).show();

        fragment = new TinhDiemFragment();
        loadFragment(fragment);


    }
}
