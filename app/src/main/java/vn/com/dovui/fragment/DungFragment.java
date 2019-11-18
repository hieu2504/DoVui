package vn.com.dovui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.com.dovui.R;


public class DungFragment extends Fragment {

    private CMoiFragment.CmoiFragmentListener mListtenner;
    private Button btn_tiep;
    public DungFragment() {
        // Required empty public constructor
    }

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_dung, container, false);
        initView();


        CMoiFragment.diem+=10;
        btn_tiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListtenner.onClickCmoi();
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("ontack","onActach");
        if (context instanceof CMoiFragment.CmoiFragmentListener) {
            mListtenner = (CMoiFragment.CmoiFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private void initView(){
       btn_tiep=rootView.findViewById(R.id.btn_tiep_DungFragmet);
    }


}
