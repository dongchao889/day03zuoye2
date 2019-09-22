package comd.example.lenovo.day03zuoye2.view;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye2.bean.FuliBean;

/**
 * Created by lenovo on 2019/9/20.
 */

public interface DataView {
    void addData(ArrayList<FuliBean.ResultsBean> li);
    void showToast(String str);
}
