# ViewPlayTest
广告轮播
###XML布局
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context="amap.zxq.github.com.viewplaytest.MainActivity"
    tools:showIn="@layout/activity_main">
    <-- 广告轮播图片  -->
    <com.github.zxq.viewplay.SlidingPlayView
        android:id="@+id/mSlidingPlayView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
    <-- 轮播页下面的点 -->
    <com.github.zxq.viewplay.PointsView
        android:id="@+id/mPointsView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</RelativeLayout>
```
###代码实现
```java
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
    }

    private void initPlayView(){
        int[] drawableIds = {R.drawable.banner1,R.drawable.banner2,R.drawable.banner3};
        List<View> list = new ArrayList<>();
        //设置点 的个数
        mPointsView.setCount(drawableIds.length);
        for(int i = 0;i < drawableIds.length;i++){
            ImageView img = new ImageView(this);
            img.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            img.setAdjustViewBounds(true);
            img.setImageResource(drawableIds[i]);
            list.add(img);
        }
        //将View添加至SlidingPlayView
        mSlidingPlayView.addViews(list);
        //页面切换间隔时间
        mSlidingPlayView.setSleepTime(3 * 1000);
        //开始轮播
        mSlidingPlayView.startPlay();
        //SlidngPlayView页面切换监听
        mSlidingPlayView.setOnPageChangeListener(new SlidOnChangeListener() {
            @Override
            public void onChange(int position) {
                //PointsView 第Position高亮显示
                mPointsView.doChangePage(position);
            }
        });
    }
}
```
