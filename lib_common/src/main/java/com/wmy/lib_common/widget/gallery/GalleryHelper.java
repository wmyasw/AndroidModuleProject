package com.wmy.lib_common.widget.gallery;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.wmy.lib_common.R;

import java.util.List;

public  class GalleryHelper {

    public  enum GalleryType {
        TEXT(0,"带背景的文字"), POSITION(1,"原点"), NOBG_TEXT(2,"无背景");
        private int code;
        private String msg;

        //为了更好的返回代号和说明，必须呀重写构造方法
        private GalleryType(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }


        // 根据value返回枚举类型,主要在switch中使用
        public static GalleryType getByValue(int value) {
            for (GalleryType code : values()) {
                if (code.getCode() == value) {
                    return code;
                }
            }
            return null;
        }
    }

    private GalleryHelper() {
    }

    public static GalleryHelper getInstace() {
        return GalleryHolder.instace;
    }

    private static class GalleryHolder {
        private static final GalleryHelper instace = new GalleryHelper();
    }

    public void initGallery() {

    }

    public void init(GalleryType type, Context context,
                     List imgList, ViewGroup view) {
        switch (type) {
            case TEXT:
                InitFocusIndicatorContainerText(context, imgList.size(), view);
                break;
            case POSITION:
                InitFocusIndicatorContainer(context, imgList.size(), view);
                break;
            case NOBG_TEXT:
                InitFocusIndicatorContainerTextNoBg(context, imgList.size(), view);
                break;
        }
    }
    public void init(GalleryType type, Context context,
                    int count, ViewGroup view) {
        switch (type) {
            case TEXT:
                InitFocusIndicatorContainerText(context, count, view);
                break;
            case POSITION:
                InitFocusIndicatorContainer(context, count, view);
                break;
            case NOBG_TEXT:
                InitFocusIndicatorContainerTextNoBg(context, count, view);
                break;
        }
    }
    /**
     * 设置gallery 选中 图片
     *
     * @param context
     * @param count
     * @param view
     * @author wangmingyu
     * @2014-9-29@下午4:26:03 void
     */
    public void InitFocusIndicatorContainer(Context context,
                                            int count, ViewGroup view) {
        view.removeAllViews();
        if (count >=1) {
            for (int i = 0; i <count; i++) {
                ImageView localImageView = new ImageView(context);
                localImageView.setId(i);
                ImageView.ScaleType localScaleType = ImageView.ScaleType.FIT_XY;
                localImageView.setScaleType(localScaleType);
                // 设置位置
                LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(
                        32, 32);
                localImageView.setLayoutParams(localLayoutParams);
                localImageView.setPadding(5, 5, 5, 5);// 设置边距
                localImageView.setImageResource(R.mipmap.home_img_indicator_unfocus);// 图片素材
//				localImageView.setBackgroundColor(Color.rgb(122,177,147));
                view.addView(localImageView); // 添加资源
            }
        }
    }

    /**
     * 有背景 圆角 的text
     *
     * @param context
     * @param count
     * @param view
     */
    public void InitFocusIndicatorContainerText(Context context,
                                                int count, ViewGroup view) {
        view.removeAllViews();
        if (count>=1) {
            TextView textView = new TextView(context);
            textView.setPadding(48, 10, 48, 10);
            textView.setBackgroundResource(R.drawable.text_radius_black);
            textView.setAlpha(0.8f);
            view.addView(textView); // 添加资源
        }
    }

    /**
     * 无背景
     *
     * @param context
     * @param count
     * @param view
     */
    public void InitFocusIndicatorContainerTextNoBg(Context context,
                                                    int count, ViewGroup view) {
        view.removeAllViews();
        if (count >=1) {
            TextView textView = new TextView(context);
            textView.setPadding(48, 10, 48, 10);
            textView.setAlpha(0.8f);
            textView.setTextSize(12f);
            view.addView(textView); // 添加资源
        }
    }
}
