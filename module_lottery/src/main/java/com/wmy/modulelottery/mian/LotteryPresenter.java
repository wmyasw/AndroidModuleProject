package com.wmy.modulelottery.mian;

import com.wmy.modulelottery.bean.LotteryBean;
import com.wmy.modulelottery.data.DataSource;
import com.wmy.modulelottery.data.LotteryDataSource;

import java.util.List;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/22 20:33
 * @version V1.2.0
 * @name GirlsPresenter
 */
public class LotteryPresenter implements LotteryContract.Presenter {

    private LotteryContract.View mView;
    private DataSource mDataSource;

    public LotteryPresenter(LotteryContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mDataSource = new LotteryDataSource();
    }

    @Override
    public void start() {
        getData(20, 1, true);
    }

    @Override
    public void getData(int page, int size, boolean isRefresh) {
        mDataSource.getLotterys(size, page, new DataSource.LoadLotteryCallback<LotteryBean>() {
            @Override
            public void onGirlsLoaded(List<LotteryBean> lotteryBeanList) {
                if (isRefresh) {
                    mView.refresh(lotteryBeanList);
                } else {
                    mView.load(lotteryBeanList);
                }
                mView.showNormal();
            }


            @Override
            public void onDataNotAvailable() {

            }
        });
    }
}
