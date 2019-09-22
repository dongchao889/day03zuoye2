package comd.example.lenovo.day03zuoye2;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye2.bean.FuliBean;


/**
 * A simple {@link Fragment} subclass.
 */
public class BannerFragment extends Fragment {


    private View view;
    private ViewPager mVp;
    private ArrayList<FuliBean.ResultsBean> list;
    private ImageView mItem2Iv;
    private TextView mItem2Tv;
    private String img;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Glide.with(getContext()).load(img).into(mItem2Iv);
            super.handleMessage(msg);
        }
    };

    public BannerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_banner, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mItem2Iv = (ImageView) view.findViewById(R.id.item2_iv);
        mItem2Tv = (TextView) view.findViewById(R.id.item2_tv);
        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        int count = bundle.getInt("count");
        img = bundle.getString("img");
        int cid = bundle.getInt("cid");
        mItem2Tv.setText((cid+1)+"/"+count);
        handler.sendEmptyMessage(1);
    }
}
