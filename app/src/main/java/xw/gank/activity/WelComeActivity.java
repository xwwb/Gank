package xw.gank.activity;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.xw.gank.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

public class WelComeActivity extends MyBaseActivity {


    @BindView(R.id.welcome_image)
    ImageView welcomeImage;

    @Override
    protected void initView() {
        context = this;
    }

    @Override
    protected void setListern() {

    }

    @Override
    protected void initData() {
        getRandomImage();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
              //  startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(WelComeActivity.this).toBundle());
                finish();
            }
        }, 1500);

    }

    private void getRandomImage() {
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.mipmap.image_one);
        imageList.add(R.mipmap.image_two);
        imageList.add(R.mipmap.image_three);
        imageList.add(R.mipmap.image_four);
        imageList.add(R.mipmap.image_five);
        imageList.add(R.mipmap.image_six);
        imageList.add(R.mipmap.image_seven);
        imageList.add(R.mipmap.image_eight);

        boolean r[] = new boolean[imageList.size()];
        Random random = new Random();
        int m = 1; //要随机取的元素个数
        if (1 > imageList.size())
            return;
        int n = 0;
        while (true) {
            int temp = random.nextInt(imageList.size());
            if (!r[temp]) {
                if (n == m)   //取到足量随机数后退出循环
                    break;
                n++;
                Integer integer = imageList.get(temp);
                welcomeImage.setImageResource(integer);
                Log.i("=====随机", "得到的第" + n + "个随机数为：" + temp + "===name");

                r[temp] = true;
            }
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_wel_come;
    }
}
