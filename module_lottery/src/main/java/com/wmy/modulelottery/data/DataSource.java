package com.wmy.modulelottery.data;


import java.util.List;
/**
 * @author wmy
 * @Description: 定义数据接口
 * @FileName: DataSource
 * @Date 2018/6/8/008 10:37
 */
public interface DataSource<T>{

    interface LoadLotteryCallback<T> {

        void onDataLoaded(List<T> lotteryBeanList);

        void onDataNotAvailable();
    }

    void getLotterys(int size, int page, LoadLotteryCallback callback);

    void getLotteryOpenPrizeData(LoadLotteryCallback callback);
}
