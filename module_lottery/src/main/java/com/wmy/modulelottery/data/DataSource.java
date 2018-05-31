package com.wmy.modulelottery.data;


import com.wmy.modulelottery.bean.LotteryBean;
import com.wmy.modulelottery.mian.LotteryPresenter;

import java.util.List;

public interface DataSource<T>{

    interface LoadLotteryCallback<T> {

        void onDataLoaded(List<T> lotteryBeanList);

        void onDataNotAvailable();
    }

    void getLotterys(int size, int page, LoadLotteryCallback callback);

    void getLotteryOpenPrizeData(LoadLotteryCallback callback);
}
