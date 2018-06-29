package example.com.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29 0029.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    private List<String> data = new ArrayList<>();
    private SmartRefreshLayout smartRefreshLayout;
    private RecyclerView recyclerView;
    private DataAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        smartRefreshLayout = findViewById(R.id.srl);
        recyclerView = findViewById(R.id.recyclerview);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataAdapter(R.layout.item, data);
        recyclerView.setAdapter(adapter);
//        smartRefreshLayout.autoRefresh();//自动刷新
//        smartRefreshLayout.setEnableAutoLoadMore(true);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                            smartRefreshLayout.finishRefresh();
                            smartRefreshLayout.setNoMoreData(false);

                    }
                }, 2000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (adapter.getItemCount() > 30) {
                            Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                            smartRefreshLayout.finishLoadMoreWithNoMoreData();//将不会再次触发加载更多事件
                        } else {
//                            mAdapter.loadMore(initData());
                            smartRefreshLayout.finishLoadMore();
                            smartRefreshLayout.setNoMoreData(false);
                        }

                    }
                }, 2000);
            }
        });



    }

    private void initData() {
        for (int i = 0; i < 31; i++) {
            data.add("第" + i + "条数据");
        }
    }
}
