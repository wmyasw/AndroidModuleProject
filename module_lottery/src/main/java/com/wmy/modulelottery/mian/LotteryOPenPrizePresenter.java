package com.wmy.modulelottery.mian;

import com.wmy.modulelottery.bean.LotteryBean;
import com.wmy.modulelottery.data.DataSource;
import com.wmy.modulelottery.data.LotteryDataSource;

import java.util.List;

/**
 * @author wmy
 * @Description: 获取彩票开奖结果信息
 * @FileName: LotteryOPenPrizePresenter
 * @Date 2018/6/8/008 10:32
 */
public class LotteryOPenPrizePresenter implements LotteryContract.Presenter {

    private LotteryContract.View mView;
    private DataSource mDataSource;

    public LotteryOPenPrizePresenter(LotteryContract.View view) {
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
        mDataSource.getLotteryOpenPrizeData(new DataSource.LoadLotteryCallback<LotteryBean>(){

            /**
             * 通知观察者更新数据
             * @param lotteryBeanList
             */
            @Override
            public void onDataLoaded(List<LotteryBean> lotteryBeanList) {
                if (isRefresh) {
                    mView.refresh(lotteryBeanList);
                } else {
                    mView.load(lotteryBeanList);
                }
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }
}
