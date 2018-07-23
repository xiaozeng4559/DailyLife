package bigzeng.com.dailylife.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/8/3.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(setLayout(),container,false);
        findViews(view);
        init();
        initEvent();
        loadData();
        return view;
    }
    /**
     * 设置activity对应的布局
     * @return
     */

    protected abstract int setLayout();

    /**
     * 初始化控件
     */

    protected abstract void findViews(View view);
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


