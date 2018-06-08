package debug;




import com.orhanobut.logger.Logger;
import com.wmy.lib_common.base.BaseApplication;
import com.wmy.lib_common.http.DataType;
import com.wmy.lib_common.http.OnResultListener;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/15 20:11
 * @version V1.2.0
 * @name NewsApplication
 */
public class LotteryApplication extends BaseApplication {

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
    }

}
