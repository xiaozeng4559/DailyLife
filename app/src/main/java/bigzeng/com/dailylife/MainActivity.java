package bigzeng.com.dailylife;

import android.Manifest;
import android.util.Log;
import android.widget.Toast;

import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

import bigzeng.com.dailylife.base.BaseActivity;
import bigzeng.com.dailylife.bean.GetRequestInterface;
import bigzeng.com.dailylife.bean.WeatherInfoBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity {
    String tag = "MainActivity";

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void init() {
        MPermissions.requestPermissions(MainActivity.this, 1000, Manifest.permission.CALL_PHONE);
    }

    @Override
    protected void initEvent() {
        /*CustomPhoneStateListener customPhoneStateListener = new CustomPhoneStateListener(this);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            telephonyManager.listen(customPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }*/
    }

    @Override
    protected void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequestInterface getRequestInterface = retrofit.create(GetRequestInterface.class);
        Call<WeatherInfoBean> weather = getRequestInterface.getWeather("weatherApi?city=深圳");
        weather.enqueue(new Callback<WeatherInfoBean>() {
            @Override
            public void onResponse(Call<WeatherInfoBean> call, Response<WeatherInfoBean> response) {
                Log.e(tag, response.toString());
                WeatherInfoBean body = response.body();
                Log.e(tag, "数据-----" + body.getData().getGanmao());
            }

            @Override
            public void onFailure(Call<WeatherInfoBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(1000)
    public void requestCallSuccess() {
        Toast.makeText(this, "电话权限成功", Toast.LENGTH_SHORT).show();
    }

    @PermissionDenied(1000)
    public void requestCallFailed() {
        Toast.makeText(this, "电话权限失败", Toast.LENGTH_SHORT).show();
    }
}
