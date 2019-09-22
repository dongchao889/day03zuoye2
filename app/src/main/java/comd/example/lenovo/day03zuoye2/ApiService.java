package comd.example.lenovo.day03zuoye2;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye2.bean.FuliBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2019/9/20.
 */

public interface ApiService {
        String uri="http://gank.io/api/";
        @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<FuliBean> getjson();
}
