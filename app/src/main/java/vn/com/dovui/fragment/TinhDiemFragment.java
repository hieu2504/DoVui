package vn.com.dovui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.com.dovui.sqlite.QLDiemDAO;
import vn.com.dovui.R;
import vn.com.dovui.activity.HomeActivity;
import vn.com.dovui.model.QLDiem;


public class TinhDiemFragment extends Fragment {


    private View rootView;
    private TextView tv_diem, tv_tongdiem;
    private EditText edt_name;
    private Button btn_tinhDiem;
    private QLDiem qlDiem;
    private List<QLDiem> qlDiemList;
    private QLDiemDAO qlDiemDAO;

    private CMoiFragment.CmoiFragmentListener mListtenner;

    public TinhDiemFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_tinh_diem, container, false);
        initView();

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "UVNBanhMi.TTF");
        tv_diem.setTypeface(typeface);
        tv_tongdiem.setTypeface(typeface);
        tv_tongdiem.setText(String.valueOf(CMoiFragment.diem));
        edt_name.setTypeface(typeface);
        btn_tinhDiem.setTypeface(typeface);
        btn_tinhDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_name.getText().toString().trim();
                if (name.equals("")) {
                    Toast.makeText(getActivity(), "Hãy nhập tên của bạn vào !", Toast.LENGTH_SHORT).show();
                } else {
                    qlDiem.setName(name);
                    qlDiem.setSothutu(qlDiemList.size() + 1);
                    qlDiem.setDiem(Integer.parseInt(tv_tongdiem.getText().toString()));

                    long result = qlDiemDAO.insertDiem(qlDiem);
                    if (result > 0) {
                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);
                        getActivity().finish();

                    } else {
                        Toast.makeText(getActivity(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("ontack", "onActach");
        if (context instanceof CMoiFragment.CmoiFragmentListener) {
            mListtenner = (CMoiFragment.CmoiFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private void initView() {
        tv_diem = rootView.findViewById(R.id.tv_diem_TDFragment);
        tv_tongdiem = rootView.findViewById(R.id.tv_tongdiem_TDFragment);
        edt_name = rootView.findViewById(R.id.edt_name);
        btn_tinhDiem = rootView.findViewById(R.id.btn_tinhDiem);
        qlDiem = new QLDiem();
        qlDiemDAO = new QLDiemDAO(getActivity());
        qlDiemList = qlDiemDAO.getAll();

    }


}
