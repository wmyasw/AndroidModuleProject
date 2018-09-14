//package com.wmy.lib_common.glide;
//
//import android.content.Context;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.GlideBuilder;
//import com.bumptech.glide.load.DecodeFormat;
//import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
//import com.bumptech.glide.load.engine.cache.LruResourceCache;
//import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
//import com.bumptech.glide.load.model.GlideUrl;
//import com.bumptech.glide.module.GlideModule;
//import com.wmy.lib_common.base.BaseApplication;
//import com.wmy.lib_common.http.HttpsUtils;
//import com.wmy.lib_common.http.okhttp.HTTPSUtils;
//
//import java.io.InputStream;
//
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.SSLSession;
//
//import okhttp3.OkHttpClient;
//
///**
// * A {@link GlideModule} implementation to replace Glide's default
// * {@link java.net.HttpURLConnection} based {@link com.bumptech.glide.load.model.ModelLoader} with an OkHttp based
// * {@link com.bumptech.glide.load.model.ModelLoader}.
// * <p>
// * <p>
// * If you're using gradle, you can include this module simply by depending on the aar, the module will be merged
// * in by manifest merger. For other build systems or for more more information, see
// * {@link GlideModule}.
// * </p>
// */
//public class OkHttpGlideModule implements GlideModule {
//
//    @Override
//    public void applyOptions(Context context, GlideBuilder builder) {
//        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
//
//        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
//        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
//        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
//
//        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
//        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);
//
//        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
//        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));
//    }
//
//    @Override
//    public void registerComponents(Context context, Glide glide) {
////        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(context, "", "", "");
////        OkHttpClient okHttpClient = new OkHttpClient.Builder()
////                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
////                .hostnameVerifier(new HostnameVerifier() {
////                    @Override
////                    public boolean verify(String hostname, SSLSession session) {
////                        return true;
////                    }
////                })
////                .build();
////        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
////        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new HTTPSUtils(context).getInstance()));
//    }
//}
