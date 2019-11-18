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


public class SaiFragment extends Fragment {

    private CMoiFragment.CmoiFragmentListener mListtenner;

    private View rootView;
    private Button btn_sai;
    public SaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_sai, container, false);
        initView();

        btn_sai.setOnClickListener(new View.OnClickListener() {
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
        btn_sai=rootView.findViewById(R.id.btn_lai_SaiFragmet);
    }

}
