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

    public LotteryAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LotteryViewHolder(parent);
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
