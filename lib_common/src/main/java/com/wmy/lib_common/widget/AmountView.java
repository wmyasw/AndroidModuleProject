package com.wmy.lib_common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wmy.lib_common.R;


/**
 * @author wmy
 * @Description:  自定义组件：购买数量，带减少增加按钮
 * @FileName: AmountView
 * @Date 2017/8/23/023 17:43
 */
public class AmountView extends LinearLayout implements View.OnClickListener, TextWatcher {

    private static final String TAG = "AmountView";
    private int amount = 1; //购买数量
    private int goods_storage = 50; //商品库存
    private int minNumber=1;
    private OnAmountChangeListener mListener;
    private TextView etAmount;
    private Button btnDecrease;
    private Button btnIncrease;

    public AmountView(Context context) {
        this(context, null);
    }

    public AmountView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_amount, this);
        etAmount = (TextView) findViewById(R.id.etAmount);
        btnDecrease = (Button) findViewById(R.id.btnDecrease);
        btnIncrease = (Button) findViewById(R.id.btnIncrease);
        if(amount<=minNumber){
            btnDecrease.setEnabled(false);
        }
        if(goods_storage<=amount){
            btnIncrease.setEnabled(false);
        }
        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
        etAmount.addTextChangedListener(this);

        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.AmountView);
        int btnWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnWidth, LayoutParams.WRAP_CONTENT);
        int tvWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvWidth, 80);
        int tvTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvTextSize, 0);
        int btnTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnTextSize, 0);
        obtainStyledAttributes.recycle();

        LayoutParams btnParams = new LayoutParams(btnWidth, LayoutParams.MATCH_PARENT);
        btnDecrease.setLayoutParams(btnParams);
        btnIncrease.setLayoutParams(btnParams);
        if (btnTextSize != 0) {
            btnDecrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
            btnIncrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
        }

        LayoutParams textParams = new LayoutParams(tvWidth, LayoutParams.MATCH_PARENT);
        etAmount.setLayoutParams(textParams);
        if (tvTextSize != 0) {
            etAmount.setTextSize(tvTextSize);
        }
    }

    public void setOnAmountChangeListener(OnAmountChangeListener onAmountChangeListener) {
        this.mListener = onAmountChangeListener;
    }

    public void setGoods_storage(int goods_storage) {
        this.goods_storage = goods_storage;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnDecrease) {
            btnIncrease.setEnabled(true);
            if (amount > minNumber) {
                amount--;
                etAmount.setText(amount + "");
                if(amount==minNumber){
                    btnDecrease.setEnabled(false);
                }
            }else {
                btnDecrease.setEnabled(false);
            }
        } else if (i == R.id.btnIncrease) {
            btnDecrease.setEnabled(true);
            if (amount < goods_storage) {
                amount++;
                etAmount.setText(amount + "");
                if(amount==goods_storage){
                    btnIncrease.setEnabled(false);
                }
            }else {
                btnIncrease.setEnabled(false);
            }
        }

        etAmount.clearFocus();

        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
    }

    public void setText(Object s){
        if (s.toString().isEmpty())
            return;
        amount = Integer.valueOf(s.toString());
        if (amount > goods_storage) {
            etAmount.setText(goods_storage + "");
            return;
        }else {
            etAmount.setText(amount + "");
        }

        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
        invalidate();
    }
    public void setBtnEnabled(boolean isEnabled){
        btnIncrease.setEnabled(isEnabled);
        btnIncrease.setEnabled(isEnabled);
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    public int getAmount(){
        return amount;
    }
    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().isEmpty())
            return;
        amount = Integer.valueOf(s.toString());
        if (amount > goods_storage) {
            etAmount.setText(goods_storage + "");
            return;
        }

        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
    }


    public interface OnAmountChangeListener {
        void onAmountChange(View view, int amount);
    }
    public void setMinNumber(int min){
        minNumber=min;
    }

}