package bigzeng.com.dailylife.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by admin on 2018/7/18.
 */

public class GuidancePagerAdaper extends PagerAdapter{
    int pic[];
    Context context;

    public GuidancePagerAdaper(int[] pic, Context context) {
        this.pic = pic;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pic.length;
    }

    /**
     * 判断是否同一个数据（图片）
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     * 需要返回View
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(pic[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    /**
     * 回收移除的视图
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }
}
