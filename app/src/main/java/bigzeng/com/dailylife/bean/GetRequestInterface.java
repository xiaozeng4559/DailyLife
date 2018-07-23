package bigzeng.com.dailylife.bean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by admin on 2018/7/19.
 */

public interface GetRequestInterface  {
    @GET
    Call<WeatherInfoBean>getWeather(@Url String url);
}
