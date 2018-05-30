package com.wmy.modulelottery.data;


import com.wmy.modulelottery.bean.LotteryBean;
import com.wmy.modulelottery.mian.LotteryPresenter;

import java.util.List;

public interface DataSource {

    interface LoadLotteryCallback {

        void onGirlsLoaded(List<LotteryBean> lotteryBeanList);

        void onDataNotAvailable();
    }

    void getLotterys(int size, int page, LoadLotteryCallback callback);

}
