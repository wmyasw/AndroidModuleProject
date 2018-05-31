package com.wmy.modulelottery.frament;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmy.lib_common.base.BaseFragment;
import com.wmy.modulelottery.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TowFragment extends BaseFragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GirlsFragment.
     */
    public static TowFragment newInstance() {
        return new TowFragment();
    }


    public TowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_open_prize, container, false);
    }


}
