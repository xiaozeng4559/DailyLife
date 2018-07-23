package bigzeng.com.dailylife.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import bigzeng.com.dailylife.MainActivity;
import bigzeng.com.dailylife.R;
import bigzeng.com.dailylife.adapter.GuidancePagerAdaper;
import bigzeng.com.dailylife.base.BaseActivity;
import bigzeng.com.dailylife.utils.SharePre_key;
import bigzeng.com.dailylife.utils.SharedPreferencesHelper;

public class GuidanceActivity extends BaseActivity {
    String tag = "GuidanceActivity";
    private ViewPager mViewPager;
    int pic[] = {R.mipmap.guidance_pic_1, R.mipmap.guidance_pic_2, R.mipmap.guidance_pic_3};
    private Button bt_join;
    private SharedPreferencesHelper helper;
    private ImageView iv_welcome;


    @Override
    protected int initLayout() {
        return R.layout.activity_guidance;
    }

    @Override
    protected void findViews() {
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        bt_join = (Button) findViewById(R.id.bt_join);
        iv_welcome = (ImageView) findViewById(R.id.iv_welcome);
    }

    @Override
    protected void init() {

        helper = new SharedPreferencesHelper(GuidanceActivity.this, SharePre_key.SHAREPRE_FILE_NAME);

        boolean firstJoin = (boolean) helper.getSharedPreference(SharePre_key.FIRST_JOIN_KEY, true);
        if (firstJoin) {
            GuidancePagerAdaper adaper = new GuidancePagerAdaper(pic, GuidanceActivity.this);
            mViewPager.setAdapter(adaper);
        } else {
            iv_welcome.setVisibility(View.VISIBLE);
            ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(iv_welcome,"alpha",0.3f,1.0f);
            objectAnimator.setDuration(1000);
            objectAnimator.start();
            objectAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    Intent intent = new Intent(GuidanceActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });

        }

    }

    @Override
    protected void initEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    bt_join.setVisibility(View.VISIBLE);
                } else {
                    bt_join.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bt_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.put(SharePre_key.FIRST_JOIN_KEY, false);
                Intent intent = new Intent(GuidanceActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(helper!=null){
            helper=null;
        }
        Log.d(tag,"onDestroy");
    }
}
