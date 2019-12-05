package vn.com.dovui.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.com.dovui.R;
import vn.com.dovui.activity.ChoiMoiActivity;
import vn.com.dovui.model.Check;
import vn.com.dovui.model.QLCauhoi;
import vn.com.dovui.sqlite.QLCauHoiDAO;


public class CMoiFragment extends Fragment {

    public CMoiFragment() {

    }

    public static int diem = 0;
    public static int dongu = 3;
    public static int cauhoi=0;
    private CmoiFragmentListener mListtenner;
    private View rootview;
    private TextView tv_ch;
    private QLCauHoiDAO qlCauHoiDAO;
    private List<QLCauhoi> qlCauhoiList;
    private TextView tv_A, tv_B, tv_C, tv_D, tv_Diem, tv_Dongu,tv_cauhoi,tv_DongHo;
    private QLCauhoi qlCauhoi;
    private ImageView img_MuiGoi,img_GoiYYY;
    private int code;
    private AlertDialog alertDialog;
    private CountDownTimer w;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_cmoi, container, false);

        initView();
       code = (int) Math.floor(((Math.random() * (qlCauhoiList.size()-1)) + 0));
       cauhoi++;
       tv_cauhoi.setText(cauhoi+"/30");

       // hiệu ứng cho mũi tên gợi ý
       ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(img_MuiGoi,"translationX",-img_MuiGoi.getWidth(),50f);
        // thời gian chạy
        objectAnimator.setDuration(500);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();

        for (int i = 0; i < ChoiMoiActivity.checkList.size(); i++) {
            if (code == ChoiMoiActivity.checkList.get(i).xyz) {
                code = (int) Math.floor(((Math.random() * (qlCauhoiList.size()-1)) + 0));
                i=0;
            }
        }

        Check check = new Check();
        check.xyz = code;
        ChoiMoiActivity.checkList.add(check);
        if(ChoiMoiActivity.checkList.size()==qlCauhoiList.size()){
            ChoiMoiActivity.checkList=new ArrayList<>();
        }
                tv_ch.setText(qlCauhoiList.get(code).getCauhoi());
                tv_A.setText(qlCauhoiList.get(code).getAn_A());
                tv_B.setText(qlCauhoiList.get(code).getAn_B());
                tv_C.setText(qlCauhoiList.get(code).getAn_C());
                tv_D.setText(qlCauhoiList.get(code).getAn_D());
                tv_Diem.setText(String.valueOf(diem));
                tv_Dongu.setText(String.valueOf(dongu));



        // check A
        tv_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_A.getText().equals(qlCauhoiList.get(code).getDap_an())) {
                    mListtenner.onClickDung();
                } else {
                    mListtenner.onClickSai();
                    dongu -= 1;
                    tinhdiem();
                }
                if(tv_cauhoi.getText().toString().equals("30/30")){
                    mListtenner.onClickTinhDiem();
                }
                SaiFragment.sai=0;
                resetTime();
            }
        });

        //Check B
        tv_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_B.getText().equals(qlCauhoiList.get(code).getDap_an())) {
                    mListtenner.onClickDung();
                } else {
                    mListtenner.onClickSai();
                    dongu -= 1;
                    tinhdiem();
                }
                if(tv_cauhoi.getText().toString().equals("30/30")){
                    mListtenner.onClickTinhDiem();
                }
                SaiFragment.sai=0;
                resetTime();
            }
        });

        //Check C
        tv_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_C.getText().equals(qlCauhoiList.get(code).getDap_an())) {
                    mListtenner.onClickDung();
                } else {
                    mListtenner.onClickSai();
                    dongu -= 1;
                    tinhdiem();
                }
                if(tv_cauhoi.getText().toString().equals("30/30")){
                    mListtenner.onClickTinhDiem();
                }
                SaiFragment.sai=0;
                resetTime();
            }
        });

        //Check D
        tv_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_D.getText().equals(qlCauhoiList.get(code).getDap_an())) {
                    mListtenner.onClickDung();
                } else {
                    mListtenner.onClickSai();
                    dongu -= 1;
                    tinhdiem();
                }
                if(tv_cauhoi.getText().toString().equals("30/30")){
                    mListtenner.onClickTinhDiem();
                }
                SaiFragment.sai=0;
                resetTime();
            }
        });
        img_GoiYYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diem<20){
                    Toast.makeText(getActivity(), "Bạn không đủ điểm", Toast.LENGTH_SHORT).show();
                }else {
                    diem-=20;
                    tv_Diem.setText(String.valueOf(diem));
                    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

                    final View dialog= LayoutInflater.from(getActivity()).inflate(R.layout.dialog,null);

                    builder.setView(dialog);
                    FrameLayout frameLayout=dialog.findViewById(R.id.frameLayout123);
                    frameLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            alertDialog.dismiss();
                        }
                    });
                    TextView textView=dialog.findViewById(R.id.tv_GoiY);
                    textView.setText(qlCauhoiList.get(code).getDap_an());

                    builder.create();
                    alertDialog=builder.show();
                }


            }
        });



        // Dong ho đếm ngược
         w=new CountDownTimer(16000,1000) {
            @Override
            public void onTick(long l) {
                tv_DongHo.setText(""+l/1000);
            }
            @Override
            public void onFinish() {
                if(tv_cauhoi.getText().toString().equals("30/30")){
                    mListtenner.onClickTinhDiem();
                }else {
                    SaiFragment.sai=1;
                    mListtenner.onClickSai();
                }



            }
        }.start();

        return rootview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("ontack", "onActach");
        if (context instanceof CmoiFragmentListener) {
            mListtenner = (CmoiFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    // hủy interface khi fragment bị gỡ khỏi activity
    @Override
    public void onDetach() {
        super.onDetach();
        mListtenner = null;
    }

    public void initView() {
        tv_ch = rootview.findViewById(R.id.tv_ch);
        qlCauHoiDAO = new QLCauHoiDAO(getActivity());
        qlCauhoiList = qlCauHoiDAO.getAll();
        tv_A = rootview.findViewById(R.id.tv_A);
        tv_B = rootview.findViewById(R.id.tv_B);
        tv_C = rootview.findViewById(R.id.tv_C);
        tv_D = rootview.findViewById(R.id.tv_D);
        tv_Diem = rootview.findViewById(R.id.tv_Diem);
        tv_Dongu = rootview.findViewById(R.id.tv_Dongu);
        tv_cauhoi=rootview.findViewById(R.id.tv_Cauhoi);
        img_MuiGoi=rootview.findViewById(R.id.img_MuiGoi);
        img_GoiYYY=rootview.findViewById(R.id.img_GoiYYY);
        tv_DongHo=rootview.findViewById(R.id.tv_Time);


    }

    public void tinhdiem() {
        if (dongu == -1) {
            mListtenner.onClickTinhDiem();
        }

    }

    public interface CmoiFragmentListener {
        void onClickDung();

        void onClickSai();

        void onClickCmoi();

        void onClickTinhDiem();
    }

    public void resetTime(){
        w.cancel();
    }


}
