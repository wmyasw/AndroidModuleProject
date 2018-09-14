package com.wmy.module_main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.wmy.lib_common.base.BaseActivity;
import com.wmy.lib_common.base.ViewManager;
import com.wmy.lib_common.utils.LogUtils;
import com.wmy.lib_common.utils.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import cn.levey.bannerlib.RxBanner;
import cn.levey.bannerlib.data.RxBannerConfig;
import cn.levey.bannerlib.impl.RxBannerLoaderInterface;
import liang.lollipop.rvbannerlib.BannerUtil4J;
import liang.lollipop.rvbannerlib.banner.Orientation;
import tv.danmaku.ijk.media.player.IMediaPlayer;


/**
 * @author wmy
 * @Description: 通过module路由器 定位不同module 下的activity
 * @FileName: MainActivity
 * @Date 2018/6/8/008 10:42
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private long mExitTime = 0;
    RecyclerView recycler;
    IjkPlayerManager player;
    //    PlayerView ad_place_2;
//    StandardGSYVideoPlayer videoPlayer;
//    IjkPlayerManager manager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//
        initPlayer();
    }


    private void initPlayer() {
        player = new IjkPlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(IjkPlayerManager.SCALETYPE_16_9);
        player.playInFullScreen(true);
        player.setPlayerStateListener(new IjkPlayerManager.PlayerStateListener() {
            @Override
            public void onComplete() {
                LogUtils.d("onComplete");
            }

            @Override
            public void onError() {
                LogUtils.d("onError");
            }

            @Override
            public void onLoading() {
                LogUtils.d("onLoading");
            }

            @Override
            public void onPlay() {
                LogUtils.d("onPlay");
            }
        });
        player.onComplete(new IjkPlayerManager.OnCompleteListener() {
            @Override
            public void onComplete(IMediaPlayer mediaPlayer) {
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        });
        player.play("http://test-cdn.yesincarapi.com/lkmotion/boss/凌动智行高德版0714.mp4");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.news_button) {
            //跳转到NewsCenterActivity
//            ARouter.getInstance().build( "/lotter/openPrize").navigation();
            ARouter.getInstance().build("/lotter/list").navigation();
        } else if (view.getId() == R.id.girls_button) {
            //跳转到LotterActivity
//            ARouter.getInstance().build("/lotter/list").navigation();
            ARouter.getInstance().build("/settings/setting").navigation();
        } else if (view.getId() == R.id.fragment_button) {
            startActivity(new Intent(this, TestActivity.class));
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShortToast(getString(R.string.app_exit_hint));
                mExitTime = System.currentTimeMillis();
            } else {
                ViewManager.getInstance().exitApp(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initView() {
//        mBanner = (Banner) findViewById(R.id.banner);
        findViewById(R.id.news_button).setOnClickListener(this);
        findViewById(R.id.girls_button).setOnClickListener(this);
        findViewById(R.id.fragment_button).setOnClickListener(this);

//        //设置banner样式
//        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
//        //设置图片加载器
//        mBanner.setImageLoader(new GlideImageLoader());
//        //设置图片集合
//        mBanner.setImages(setImageList());
//        //设置banner动画效果
//        mBanner.setBannerAnimation(Transformer.Default);
//        //设置标题集合（当banner样式有显示title时）
////        mBanner.setBannerTitles(titles);
//        //设置自动轮播，默认为true
//        mBanner.isAutoPlay(true);
//        //设置轮播时间
//        mBanner.setDelayTime(5000);
//        //设置指示器位置（当banner模式中有指示器时）
//        mBanner.setIndicatorGravity(BannerConfig.CENTER);
//        //banner设置方法全部调用完毕时最后调用
//        mBanner.start();
    }

    private List setImageList() {
        List list = new ArrayList<>();
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534223711619&di=93fbe01fd85c4916c55372e6a61f7ea6&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F9358d109b3de9c82533bd5466081800a18d84398.jpg");
//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534223711619&di=fa4083fb26680a368b11432350ad8be6&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8601a18b87d6277fb82be3f124381f30e924fc3a.jpg");
//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534223711619&di=2124b848e73ea496e8ce7a560304a18a&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F38dbb6fd5266d016ea8d45e59b2bd40734fa3563.jpg");

        return list;
    }

    private void initBanner() {
        recycler = findViewById(R.id.recycler);
        ArrayList list = new ArrayList();
        Bean bean = new Bean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534223711619&di=93fbe01fd85c4916c55372e6a61f7ea6&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F9358d109b3de9c82533bd5466081800a18d84398.jpg");
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        TestAdapter adapter = new TestAdapter(list, getLayoutInflater());
        //完整参数设置
        BannerUtil4J.with(recycler)//关联一个RecyclerView
                .attachAdapter(adapter)//传入RecyclerView的Adapter
                .setOrientation(Orientation.HORIZONTAL)//设置方向
                .setSecondaryExposedWeight(0.4f)//设置两侧露出比例
                .setSecondaryExposed( 0 )//设置两侧露出距离，当距离为0时,上一行比例生效
                .setAutoNextDelayed( 5000 )//设置自动翻页的间隔时间，单位ms
                .setPagerMode( true )//设置是否单页模式，一次只能翻一页
//                .setScaleGap( float )//设置最小缩放比例
                .isAutoNext( true )//设置是否开启自动翻页
                .init();//执行初始化

    }

    class TestAdapter extends RecyclerView.Adapter<TestHolder> {

        private ArrayList<Bean> data;
        private LayoutInflater layoutInflater;

        public TestAdapter(ArrayList<Bean> data, LayoutInflater layoutInflater) {
            this.data = data;
            this.layoutInflater = layoutInflater;
        }

        @Override
        public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TestHolder(layoutInflater.inflate(R.layout.layout_item, parent, false));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onBindViewHolder(TestHolder holder, int position) {
            holder.onBind(data.get(position));
        }


    }

    class Bean {

        String url;

        public Bean(String url) {
            this.url = url;
        }
    }

    class TestHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        ImageView imageView;
        View view;

        public TestHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void onBind(Bean bean) {
            onBind(bean.url);
        }

        public void onBind(String text) {
            Glide.with(view.getContext()).load(text).into(imageView);

        }

    }
}
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(player!=null){
//            player.start();
//            LogUtils.e("MainActivity","onStart");
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        player.pause();
//        LogUtils.e("MainActivity","onPause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        player.stop();
//        LogUtils.e("MainActivity","onStop");
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        player.onDestroy();
//        LogUtils.e("MainActivity","onDestroy");
//    }
//
//    @Override
//    public void onComplete() {
//        LogUtils.e("MainActivity","1111111111111");
//        player.release(true);
//    }
//
//    @Override
//    public void onError() {
//        LogUtils.e("MainActivity","22222");
//    }
//
//    @Override
//    public void onLoading() {
//        LogUtils.e("MainActivity","onLoading...");
//    }
//
//    @Override
//    public void onPlay() {
//        LogUtils.e("MainActivity","onPlay...");
//    }
//}
