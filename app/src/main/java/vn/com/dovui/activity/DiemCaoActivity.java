package vn.com.dovui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import vn.com.dovui.DiemAdapter;
import vn.com.dovui.R;
import vn.com.dovui.model.QLDiem;
import vn.com.dovui.sqlite.QLDiemDAO;

public class DiemCaoActivity extends AppCompatActivity {

    private long backPressedTime;
    private RecyclerView rcView;
    private List<QLDiem> qlDiemList;
    private DiemAdapter diemAdapter;
    private QLDiemDAO qlDiemDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_cao);

        rcView=findViewById(R.id.rcView);
        qlDiemDAO=new QLDiemDAO(this);
        qlDiemList=qlDiemDAO.diemCao();
        diemAdapter=new DiemAdapter(this,qlDiemList);


        rcView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcView.setLayoutManager(linearLayoutManager);
        rcView.setAdapter(diemAdapter);


    }

    public void back_home(View view) {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_cmoi,
                R.anim.slide_out_cmoi);
        finish();
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
}
