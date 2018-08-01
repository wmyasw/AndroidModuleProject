package com.wmy.lib_common.widget.gallery;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.wmy.lib_common.R;
import com.wmy.lib_common.utils.LogUtils;

import java.util.Timer;
import java.util.TimerTask;


/**
 * 图片走廊（类似走马灯效果 循环播放）
 *
 * @author wangmingyu
 */
public class IMGGallery extends Gallery implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "IMGGallery";
    /**
     * 圆点容器
     */
    private ViewGroup indicator_container;
    /**
     * 存储上一个选择项的Index
     */
    private int preSelImgIndex = 0;

    private onFlingListener flingListener;

    /**
     * 展示类型
     */
    private GalleryHelper.GalleryType galleryType;
    /**
     * 这里的数值，限制了每次滚动的最大长度，图片宽度为480PX。这里设置600效果好一些。 这个值越大，滚动的长度就越大。
     * 也就是会出现一次滚动跨多个Image。这里限制长度后，每次滚动只能跨一个Image
     */
    private static final int timerAnimation = 1;
    private final Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case timerAnimation:
                    int position = getSelectedItemPosition();
                    if (position >= (getCount() - 1)) {
                        LogUtils.e(TAG," onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, null); " + onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, null));
                        onScroll(null, null, -1*(100), 0);
//                        onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, null);

                    } else {
                        onScroll(null, null, (100), 0);
                        LogUtils.e(TAG," onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null); " + onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null));
//                        onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
                    }
                    break;

                default:
                    break;
            }
        }

        ;
    };

    private void scheduleDismissOnScreenControls() {
//		mHandler.removeCallbacks(mDismissOnScreenControlRunner);
//		mHandler.postDelayed(mDismissOnScreenControlRunner, 2000);
    }

    private Timer timer;
//    private final TimerTask task = new TimerTask() {
//        public void run() {
//            mHandler.sendEmptyMessage(timerAnimation);
//        }
//    };

    public IMGGallery(Context paramContext) {
        super(paramContext);
//		timer.schedule(task, 5000, 5000);
    }

    public IMGGallery(Context paramContext, boolean isTimer) {
        super(paramContext);

    }

    public void startTimer(long time) {
        this.requestDisallowInterceptTouchEvent(true);
        if (timer != null) {
            timer.cancel();  //将原任务从队列中移除
        } else {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    mHandler.sendEmptyMessage(timerAnimation);
                }
            }, time, time);
        }

    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public IMGGallery(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
//		timer.schedule(task, 5000, 5000);

    }

    public IMGGallery(Context paramContext, AttributeSet paramAttributeSet,
                      int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
//		timer.schedule(task, 5000, 5000);

    }

    private boolean isScrollingLeft(MotionEvent paramMotionEvent1,
                                    MotionEvent paramMotionEvent2) {

        float f2 = paramMotionEvent2.getX();
        float f1 = paramMotionEvent1.getX();
//		Log.i("msg isScrollingLeft", "f2:" + f2);
//		Log.i("msg isScrollingLeft", "f1:" + f1);
        if (f2 > f1)
            return true;
        return false;
    }

    public boolean onFling(MotionEvent paramMotionEvent1,
                           MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        int keyCode;
        if (isScrollingLeft(paramMotionEvent1, paramMotionEvent2)) {
            keyCode = KeyEvent.KEYCODE_DPAD_LEFT;
        } else {
            keyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
        }
        if (this.flingListener != null) {
            this.flingListener.onFlingHandle(paramMotionEvent1,paramMotionEvent2,paramFloat1,paramFloat2);
            //return true;
        }
        Log.i("msg onFling", "keyCode:" + keyCode);
        return onKeyDown(keyCode, null);
    }

    public void destroy() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        initTextOrPoint(position);
    }

    public void initTextOrPoint(int position) {
        if (galleryType == null) return;
        switch (galleryType.getCode()) {
            case 0:
                InitFocusIndicatorContainerText(position);
                break;
            case 1:
                initPoint(position);
                break;
            case 2:
                initText(position);
                break;
        }
    }

    /**
     * 有背景 圆角 的text
     */
    private void InitFocusIndicatorContainerText(int position) {
        if (indicator_container == null) return;
        position = position % getAdapter().getCount();
        if (getAdapter().getCount() > 1) {
            // 修改上一次选中项的背景
            TextView preSelImg = (TextView) indicator_container.getChildAt(0);
            if (preSelImg != null) {
                preSelImg.setTextSize(14);
                preSelImg.setTextColor(Color.WHITE);
                preSelImg.setPadding(48, 10, 48, 10);
                preSelImg.setBackgroundResource(R.drawable.text_radius_black);
                preSelImg.setAlpha(0.8f);
                preSelImg.setText((position + 1) + "/" + getAdapter().getCount());
            }

        }
    }

    private void initText(int position) {
        if (indicator_container == null) return;
        position = position % getAdapter().getCount();
        if (getAdapter().getCount() > 1) {
            // 修改上一次选中项的背景
            TextView preSelImg = (TextView) indicator_container.getChildAt(0);
            if (preSelImg != null) {
                preSelImg.setTextSize(14);
                preSelImg.setTextColor(Color.WHITE);
                preSelImg.setText((position + 1) + "/" + getAdapter().getCount());
            }
            indicator_container.requestLayout();
        }
    }

    private void initPoint(int position) {
        if (indicator_container == null) return;
        position = position % getAdapter().getCount();
        LogUtils.e(TAG," onItemSelected " + position);
        if (getAdapter().getCount() > 1) {
            ImageView preSelImg = indicator_container
                    .findViewById(preSelImgIndex);
            LogUtils.e(TAG," preSelImg " + preSelImg);
            if (preSelImg != null)
                preSelImg.setImageResource(R.mipmap.home_img_indicator_unfocus);
            // 修改当前选中项的背景
            ImageView curSelImg = indicator_container.findViewById(position);
//                            .findViewById(position);
            if (curSelImg != null)
                curSelImg.setImageResource(R.mipmap.home_img_indicator_focus);
            preSelImgIndex = position;
        }
    }

    public void setIndicator_container(ViewGroup indicator_container) {
        this.indicator_container = indicator_container;
        GalleryHelper.getInstace().init(galleryType, getContext(), getAdapter().getCount(), indicator_container);
    }

    public GalleryHelper.GalleryType getGalleryType() {
        return galleryType;
    }

    public void setGalleryType(GalleryHelper.GalleryType galleryType) {
        this.galleryType = galleryType;

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void setOnFlingListener(onFlingListener flingListener) {
        this.flingListener = flingListener;
    }

    public interface onFlingListener {

        public void onFlingHandle(MotionEvent paramMotionEvent1,
                                  MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
    }
}
