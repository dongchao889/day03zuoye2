package comd.example.lenovo.day03zuoye2.persenter;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye2.CallBack;
import comd.example.lenovo.day03zuoye2.bean.FuliBean;
import comd.example.lenovo.day03zuoye2.model.DataModel;
import comd.example.lenovo.day03zuoye2.view.DataView;

/**
 * Created by lenovo on 2019/9/20.
 */

public class DataPer implements CallBack{
    private DataView dataView;
    private DataModel dataModel;

    public DataPer(DataView dataView) {
        this.dataView = dataView;
        this.dataModel=new DataModel();
    }

    @Override
    public void sussecc(ArrayList<FuliBean.ResultsBean> list) {
        dataView.addData(list);
    }

    @Override
    public void Fuil(String str) {
        dataView.showToast(str);
    }

    public void getData() {
        dataModel.getData(this);
    }
}
