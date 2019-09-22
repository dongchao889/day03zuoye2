package comd.example.lenovo.day03zuoye2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye2.bean.FuliBean;

/**
 * Created by lenovo on 2019/9/20.
 */

public class MyRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<FuliBean.ResultsBean> list;
    private Context context;

    public MyRecAdapter(ArrayList<FuliBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new MyHoldel1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyHoldel1 holdel1= (MyHoldel1) holder;
        Glide.with(context).load(list.get(position).getUrl()).into(holdel1.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclick!=null){
                    onclick.onclick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHoldel1 extends RecyclerView.ViewHolder {
        private ImageView iv;
        public MyHoldel1(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.item_iv);
        }
    }
    public interface Onclick{
        void onclick(int position);
    }
    private Onclick onclick;

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }
}
