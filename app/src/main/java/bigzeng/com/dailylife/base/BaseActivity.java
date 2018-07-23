package bigzeng.com.dailylife.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 2018/4/26.
 */

public abstract class BaseActivity extends AppCompatActivity {
    String tag="BaseActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* Window window = getWindow();
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);*/
        //设置布局
        setContentView(initLayout());
        //初始化控件
        findViews();
        //设置数据
        init();
        initEvent();
        loadData();
    }

    /**
     * 添加布局
     * @return
     */
    protected abstract int initLayout();

    /**
     * 初始化控件
     */

    protected abstract void findViews();
    /**
     * 初始化出了控件以外的其他数据成员
     */

    protected abstract void init();
    /**
     * 初始化各种事件响应
     */
    protected abstract void initEvent();


    /**
     * 访问网络数据呈现到界面上
     */
    protected abstract void loadData();
}
