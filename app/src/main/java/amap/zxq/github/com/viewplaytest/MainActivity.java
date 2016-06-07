package amap.zxq.github.com.viewplaytest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.zxq.viewplay.PointsView;
import com.github.zxq.viewplay.SlidOnChangeListener;
import com.github.zxq.viewplay.SlidingPlayView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SlidingPlayView mSlidingPlayView;
    private PointsView mPointsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("广告轮播");

        mPointsView = (PointsView) findViewById(R.id.mPointsView);
        mSlidingPlayView = (SlidingPlayView) findViewById(R.id.mSlidingPlayView);
        initPlayView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initPlayView(){
        int[] drawableIds = {R.drawable.banner1,R.drawable.banner2,R.drawable.banner3};
        List<View> list = new ArrayList<>();
        mPointsView.setCount(drawableIds.length);
        for(int i = 0;i < drawableIds.length;i++){
            ImageView img = new ImageView(this);
            img.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            img.setAdjustViewBounds(true);
            img.setImageResource(drawableIds[i]);
            list.add(img);
        }
        mSlidingPlayView.addViews(list);
        mSlidingPlayView.startPlay();
        mSlidingPlayView.setOnPageChangeListener(new SlidOnChangeListener() {
            @Override
            public void onChange(int position) {
                mPointsView.doChangePage(position);
            }
        });
    }
}
