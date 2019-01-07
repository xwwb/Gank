package xw.gank.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xw.gank.R;


/**
 * Created by Administrator on 2018\1\31 0031.
 * 导航栏
 */

public class TitleBuilder {
    private TextView right_textview;
    private RelativeLayout titleBar;
    private TextView text;
    private ImageView leftIco;
    private ImageView rightIco;
    private LinearLayout left_linearlayout;
    private final View status_bar;

    /**
     * 构造方法：用于获取对象
     */
    public TitleBuilder(Activity context) {
        View titleView = context.findViewById(R.id.title_bar);
        status_bar = context.findViewById(R.id.status_bar);
        text = titleView.findViewById(R.id.title_text);
        titleBar = titleView.findViewById(R.id.title_bar);
        leftIco = titleView.findViewById(R.id.title_leftIco);
        rightIco = titleView.findViewById(R.id.title_rightIco);
        right_textview = titleView.findViewById(R.id.right_textview);
        left_linearlayout = titleView.findViewById(R.id.title_left_linearlayout);
    }

    /*
      设定与状态栏与导航栏颜色一样
     */
    public TitleBuilder setStatusBarBackground(int color) {
        status_bar.setVisibility(View.VISIBLE);
        status_bar.setBackgroundColor(color);
        return this;
    }

    /*
      设定标题栏文字颜色
     */
    public TitleBuilder setTitleTextColor(int color) {
        text.setTextColor(color);
        return this;
    }

    /*
   设定右边TextView文字颜色
  */
    public TitleBuilder setRightTitleTextColor(int color) {
        right_textview.setVisibility(color > 0 ? View.VISIBLE : View.GONE);
        right_textview.setTextColor(color);
        return this;
    }

    /*
设定右边TextView文字颜色
*/
    public TitleBuilder setRightTitleTextTitle(String title, int color) {

        right_textview.setVisibility(View.VISIBLE);
        right_textview.setTextColor(color);
        right_textview.setText("" + title);
        return this;
    }

    /**
     * 用于设置标题栏文字
     */
    public TitleBuilder setTitleText(String titleText) {
        if (!TextUtils.isEmpty(titleText)) {
            text.setText(titleText);
        }
        return this;
    }

    /**
     * 用于设置标题栏颜色
     */
    public TitleBuilder setTitleColor(int color) {
        titleBar.setBackgroundColor(color);
        return this;
    }

    /**
     * 用于设置标题栏左边要显示的图片
     */
    public TitleBuilder setLeftIco(int resId) {
        leftIco.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        leftIco.setImageResource(resId);
        return this;
    }

    /**
     * 用于设置标题栏右边要显示的图片
     */
    public TitleBuilder setRightIco(int resId) {
        rightIco.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        rightIco.setImageResource(resId);
        return this;
    }

    /**
     * 用于设置标题栏左边图片的单击事件
     */
    public TitleBuilder setLeftIcoListening(View.OnClickListener listener) {
        if (left_linearlayout.getVisibility() == View.VISIBLE) {
            left_linearlayout.setOnClickListener(listener);
        }
        return this;
    }

    /**
     * 用于设置标题栏右边图片的单击事件
     */
    public TitleBuilder setRightIcoListening(View.OnClickListener listener) {
        if (rightIco.getVisibility() == View.VISIBLE) {
            rightIco.setOnClickListener(listener);
        }
        return this;
    }

    /**
     * 用于设置标题栏右边TextView的单击事件
     */
    public TitleBuilder setRightTextViewListening(View.OnClickListener listener) {
        if (right_textview.getVisibility() == View.VISIBLE) {
            right_textview.setOnClickListener(listener);
        }
        return this;
    }

    public ImageView getRightImage() {
        return rightIco;
    }
}