package com.wmy.modulelottery.frament;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmy.lib_common.base.BaseFragment;
import com.wmy.modulelottery.R;
import com.wmy.modulelottery.mian.LotteryContract;
import com.wmy.modulelottery.mian.LotteryPresenter;
import com.wmy.modulelottery.mian.LotteryView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends BaseFragment {
    private LotteryView mView;
    private LotteryContract.Presenter mPresenter;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GirlsFragment.
     */
    public static OneFragment newInstance() {
        return new OneFragment();
    }


    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = new LotteryView(getContext());
//        setContentView(mView);
        mPresenter = new LotteryPresenter(mView);
        mPresenter.start();
        return mView;
    }


}
