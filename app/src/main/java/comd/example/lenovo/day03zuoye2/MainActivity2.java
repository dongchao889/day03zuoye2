package comd.example.lenovo.day03zuoye2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mVp;
    /**
     * 返回
     */
    private Button mBt;

    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EventBus.getDefault().register(this);
        initView();
    }
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getFragment(ArrayList<Fragment> fragments) {
        list = fragments;

    }
    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), list);
        mVp.setAdapter(adapter);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 200);
        mVp.setCurrentItem(id);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
