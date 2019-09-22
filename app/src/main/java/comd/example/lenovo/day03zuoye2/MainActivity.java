package comd.example.lenovo.day03zuoye2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye2.bean.FuliBean;
import comd.example.lenovo.day03zuoye2.persenter.DataPer;
import comd.example.lenovo.day03zuoye2.view.DataView;

public class MainActivity extends AppCompatActivity implements DataView{

    private RecyclerView mRe;
    private ArrayList<FuliBean.ResultsBean> list;
    private MyRecAdapter adapter;
    private DataPer dataPer;
    private String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataPer = new DataPer(this);
        initView();
    }

    private void initView() {
        mRe = (RecyclerView) findViewById(R.id.re);
        mRe.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        adapter = new MyRecAdapter(list, this);
        mRe.setAdapter(adapter);
        dataPer.getData();
        adapter.setOnclick(new MyRecAdapter.Onclick() {
            @Override
            public void onclick(int position) {
                ArrayList<Fragment> fragments = new ArrayList<>();
                for (int i = 0; i <list.size() ; i++) {
                    BannerFragment fragment = new BannerFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("img",list.get(i).getUrl());
                    bundle.putInt("position",position);
                    bundle.putInt("count",list.size());
                    bundle.putInt("cid",i);
                    fragment.setArguments(bundle);
                    fragments.add(fragment);
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                EventBus.getDefault().postSticky(fragments);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void addData(ArrayList<FuliBean.ResultsBean> li) {
    list.addAll(li);
    adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.i(TAG, "showToast: "+str);
    }
}
