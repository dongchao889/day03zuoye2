package comd.example.lenovo.day03zuoye2;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye2.bean.FuliBean;

/**
 * Created by lenovo on 2019/9/20.
 */

public interface CallBack {
    void sussecc(ArrayList<FuliBean.ResultsBean> list);
    void Fuil(String str);
}
