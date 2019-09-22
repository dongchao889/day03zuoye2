package comd.example.lenovo.day03zuoye2.model;

import java.util.ArrayList;
import java.util.List;

import comd.example.lenovo.day03zuoye2.ApiService;
import comd.example.lenovo.day03zuoye2.CallBack;
import comd.example.lenovo.day03zuoye2.bean.FuliBean;
import comd.example.lenovo.day03zuoye2.persenter.DataPer;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2019/9/20.
 */

public class DataModel {
    public void getData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<FuliBean> observable = retrofit.create(ApiService.class).getjson();
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        ArrayList<FuliBean.ResultsBean> beanList = (ArrayList<FuliBean.ResultsBean>) fuliBean.getResults();
                        callBack.Fuil(beanList.toString());
                        callBack.sussecc(beanList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.Fuil(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
