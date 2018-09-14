package com.wmy.module_main;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lzy.imagepicker.loader.ImageLoader;

import cn.levey.bannerlib.impl.RxBannerLoaderInterface;

public class GlideImageLoader1 implements RxBannerLoaderInterface {

//    @Override
//    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
//        Glide.with(activity).load(path).into(imageView);
//    }
//
//    @Override
//    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
//        Glide.with(activity).load(path).into(imageView);
//    }
//
//    @Override
//    public void clearMemoryCache() {
//
//    }

    @Override
    public void show(Context context, Object o, View view) {
        Glide.with(context).load(o).into((ImageView) view);
    }

    @Override
    public View create(Context context) {
        return new ImageView(context);
    }

    //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
//    @Override
//    public ImageView createImageView(Context context) {
//        //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
//        SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
//        return simpleDraweeView;
//    }
}