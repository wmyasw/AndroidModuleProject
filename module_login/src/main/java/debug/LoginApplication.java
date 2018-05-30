package debug;




import com.orhanobut.logger.Logger;
import com.wmy.lib_common.base.BaseApplication;
import com.wmy.lib_common.http.DataType;
import com.wmy.lib_common.http.OnResultListener;
import com.wmy.module_login.Constants;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/15 20:11
 * @version V1.2.0
 * @name NewsApplication
 */
public class LoginApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        login();
    }


    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {
//        HttpClient client = new HttpClient.Builder()
//                .baseUrl(Constants.LOGIN_URL)
//                .url("20170419")
//                .bodyType(DataType.JSON_OBJECT, String.class)
//                .build();
//        client.get(new OnResultListener<String>() {
//
//            @Override
//            public void onSuccess(String result) {
//                Logger.e(result.toString());
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                Logger.e(message);
//            }
//
//            @Override
//            public void onFailure(String message) {
//                Logger.e(message);
//            }
//        });
    }

}
