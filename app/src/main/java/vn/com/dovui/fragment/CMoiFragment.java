package vn.com.dovui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.com.dovui.R;
import vn.com.dovui.model.QLCauhoi;
import vn.com.dovui.sqlite.QLCauHoiDAO;


public class CMoiFragment extends Fragment {

    public CMoiFragment() {

    }
    public static int diem=0;
    public static int dongu=3;
    private CmoiFragmentListener mListtenner;
    private View rootview;
    private TextView tv_ch;
    private QLCauHoiDAO qlCauHoiDAO;
    private List<QLCauhoi> qlCauhoiList;
    private TextView tv_A,tv_B,tv_C,tv_D,tv_Diem,tv_Dongu;
    private QLCauhoi qlCauhoi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview= inflater.inflate(R.layout.fragment_cmoi, container, false);

        initView();

        final int code = (int) Math.floor(((Math.random() * 104) + 0));


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
                if (tv_A.getText().equals(qlCauhoiList.get(code).getDap_an())){
                    mListtenner.onClickDung();
                }else {
                    mListtenner.onClickSai();
                    dongu-=1;
                    tinhdiem();
                }
            }
        });

        //Check B
        tv_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_B.getText().equals(qlCauhoiList.get(code).getDap_an())){
                    mListtenner.onClickDung();
                }else {
                    mListtenner.onClickSai();
                    dongu-=1;
                    tinhdiem();
                }
            }
        });

        //Check C
        tv_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_C.getText().equals(qlCauhoiList.get(code).getDap_an())){
                    mListtenner.onClickDung();
                }else {
                    mListtenner.onClickSai();
                    dongu-=1;
                    tinhdiem();
                }
            }
        });

        //Check D
        tv_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_D.getText().equals(qlCauhoiList.get(code).getDap_an())){
                    mListtenner.onClickDung();
                }else {
                    mListtenner.onClickSai();
                    dongu-=1;
                    tinhdiem();
                }
            }
        });


        return rootview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("ontack","onActach");
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

    public void initView(){
        tv_ch=rootview.findViewById(R.id.tv_ch);
        qlCauHoiDAO=new QLCauHoiDAO(getActivity());
        qlCauhoiList=qlCauHoiDAO.getAll();
        tv_A=rootview.findViewById(R.id.tv_A);
        tv_B=rootview.findViewById(R.id.tv_B);
        tv_C=rootview.findViewById(R.id.tv_C);
        tv_D=rootview.findViewById(R.id.tv_D);
        tv_Diem=rootview.findViewById(R.id.tv_Diem);
        tv_Dongu=rootview.findViewById(R.id.tv_Dongu);




    }

    public void tinhdiem(){
        if(dongu==-1){
            mListtenner.onClickTinhDiem();
        }

    }

    public  interface CmoiFragmentListener{
        void onClickDung();
        void onClickSai();
        void onClickCmoi();
        void onClickTinhDiem();
    }


}
