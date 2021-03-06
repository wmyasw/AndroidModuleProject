package com.wmy.modulelottery.mian;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wmy.modulelottery.R;
import com.wmy.modulelottery.bean.LotteryBean;
import com.wmy.modulelottery.mian.LotteryAdapter;
import com.wmy.modulelottery.mian.LotteryContract;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmy
 * @Description: 彩票列表
 * @FileName: LotteryView
 * @Date 2018/5/30/030 20:31
 */
public class LotteryView extends FrameLayout implements LotteryContract.View<LotteryBean>, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener {

    private LotteryContract.Presenter mPresenter;
    private boolean mActive;

    private EasyRecyclerView mGirlsRecyclerView;
    private ViewStub mNetworkErrorLayout;
    private View networkErrorView;
    private LotteryAdapter mAdapter;
    private ArrayList<LotteryBean> mData;
    private int page = 1;
    private int size = 20;
    private int type=0;//默认为彩票列表
    public LotteryView(Context context) {
        this(context,0);
    }
    public LotteryView(Context context,int type) {
        super(context);
        this.type=type;
        initView();
    }

    public LotteryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView() {
        inflate(getContext(), R.layout.view_lottery_content, this);
        mNetworkErrorLayout = (ViewStub) findViewById(R.id.network_error_layout);
        mGirlsRecyclerView = (EasyRecyclerView) findViewById(R.id.lottery_recycler_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mGirlsRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new LotteryAdapter(getContext(),type);
        mGirlsRecyclerView.setAdapterWithProgress(mAdapter);
        //添加分割线
        mGirlsRecyclerView.addItemDecoration(
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mGirlsRecyclerView.setRefreshingColor(
                ContextCompat.getColor(getContext(), R.color.colorPrimary),
                ContextCompat.getColor(getContext(), android.R.color.holo_blue_light),
                ContextCompat.getColor(getContext(), android.R.color.holo_green_light)
        );
        mAdapter.setMore(R.layout.layout_load_more, this);
        mAdapter.setNoMore(R.layout.layout_load_no_more);
        mAdapter.setError(R.layout.layout_load_error);
        mAdapter.setOnMyItemClickListener(new LotteryAdapter.OnMyItemClickListener() {
            @Override
            public void onItemClick(int position, BaseViewHolder holder) {
//                Intent intent = new Intent(Utils.getActivity(LotteryView.this), GirlActivity.class);
//                intent.putParcelableArrayListExtra(Constants.INTENT_GIRLS, mData);
//                intent.putExtra(Constants.INTENT_INDEX, position);
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeScaleUpAnimation(holder.itemView, holder.itemView.getWidth() / 2, holder.itemView.getHeight() / 2, 0, 0);
//                Utils.getActivity(GirlsView.this).startActivity(intent, options.toBundle());
            }
        });

        mGirlsRecyclerView.setRefreshListener(this);

        mData = new ArrayList<>();
        mActive = true;
    }


    //是否加载完毕 （同resume 但只调用一次）
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mActive = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mActive = false;
    }

    @Override
    public void setPresenter(LotteryContract.Presenter presenter) {

        this.mPresenter = presenter;
    }

    @Override
    public boolean isActive() {
        return mActive;
    }


    /**
     * 通知观察者（view）更新数据
     * @param data
     */
    @Override
    public void refresh(List<LotteryBean> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.clear();
        mAdapter.addAll(data);
    }

    /**
     * 加载数据
     * @param data
     */
    @Override
    public void load(List<LotteryBean> data) {
        mData.addAll(data);
        mAdapter.addAll(data);
    }

    /**
     * 显示错误
     */
    @Override
    public void showError() {
        mGirlsRecyclerView.showError();

        if (networkErrorView != null) {
            networkErrorView.setVisibility(View.VISIBLE);
            return;
        }

        networkErrorView = mNetworkErrorLayout.inflate();
    }

    /**
     *
     */
    @Override
    public void showNormal() {
        if (networkErrorView != null) {
            networkErrorView.setVisibility(View.GONE);
        }
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadMore() {
        if (mData.size() % size == 0) {
            page++;
            mPresenter.getData(size, page, false);
        }
    }

    /**
     * 刷新数据
     */
    @Override
    public void onRefresh() {
        mPresenter.getData(size, page, true);
        page = 1;
    }

}
