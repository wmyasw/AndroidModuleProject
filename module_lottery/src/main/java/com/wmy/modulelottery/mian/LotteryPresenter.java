package com.wmy.modulelottery.mian;

import com.wmy.modulelottery.bean.LotteryBean;
import com.wmy.modulelottery.data.DataSource;
import com.wmy.modulelottery.data.LotteryDataSource;

import java.util.List;
/**
 * @author wmy
 * @Description: 获取彩票接口数据（当前支持的彩票列表）
 * @FileName: LotteryPresenter
 * @Date 2018/6/8/008 10:31
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
//                mView.showNormal();
                mView.showError();
            }
        });
    }
}
