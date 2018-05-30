package com.wmy.modulelottery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wmy.lib_common.base.BaseActionBarActivity;
import com.wmy.modulelottery.mian.LotteryContract;
import com.wmy.modulelottery.mian.LotteryPresenter;
import com.wmy.modulelottery.mian.LotteryView;

@Route(path = "/lotter/openPrize")
public class LotteryOpenPrizeActivity extends BaseActionBarActivity {

    private LotteryView mView;
    private LotteryContract.Presenter mPresenter;

    @Override
    protected int setTitleId() {
        return R.string.app_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new LotteryView(this);
        setContentView(mView);
        mPresenter = new LotteryPresenter(mView);
        mPresenter.start();
    }


}
