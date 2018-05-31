package com.wmy.modulelottery.mian;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wmy.modulelottery.R;
import com.wmy.modulelottery.bean.LotteryBean;

public class LotteryAdapter extends RecyclerArrayAdapter<LotteryBean> {

    public OnMyItemClickListener mOnItemClickListener;
    public int type=0;
    public LotteryAdapter(Context context) {
        this(context,0);
    }
    public LotteryAdapter(Context context,int type) {
        super(context);
        this.type=type;
    }
    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        if(type==0) {
            return new LotteryViewHolder(parent);
        }else {
            return new LotteryOpenPrizeViewHolder(parent);
        }
    }


    @Override
    public void OnBindViewHolder(final BaseViewHolder holder, final int position) {
        super.OnBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, holder);
                }
            }
        });
    }
    private class  LotteryOpenPrizeViewHolder extends BaseViewHolder<LotteryBean> {

        private TextView ex,code,time,timelog;
        private  LotteryOpenPrizeViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_lotter_open_prize);
            ex = $(R.id.tv_ex);
            code = $(R.id.tv_code);
            time = $(R.id.tv_time);
            timelog = $(R.id.tv_open_number);

        }

        @Override
        public void setData(LotteryBean data) {
            super.setData(data);
            ex.setText(data.getName()+"");
            code.setText(data.getOpenCode()+"");
            time.setText(getContext().getString(R.string.open_time,data.getTime()));
            timelog.setText(getContext().getString(R.string.open_number,data.getExpect())+"");
//            Glide.with(getContext())
//                    .load(data.getUrl())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .into(image);
        }
    }
    private class  LotteryViewHolder extends BaseViewHolder<LotteryBean> {

        private TextView ex,code,time,timelog;
        private  LotteryViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_lotter);
            ex = $(R.id.tv_ex);
            code = $(R.id.tv_code);
            time = $(R.id.tv_time);
            timelog = $(R.id.tv_l);

        }

        @Override
        public void setData(LotteryBean data) {
            super.setData(data);
            ex.setText(data.getExpect());
            code.setText(data.getDescr());
            time.setText(data.getNotes());
            timelog.setText(data.getCode());
//            Glide.with(getContext())
//                    .load(data.getUrl())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .into(image);
        }
    }

    public interface OnMyItemClickListener {
        void onItemClick(int position, BaseViewHolder holder);
    }

    public void setOnMyItemClickListener(OnMyItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
