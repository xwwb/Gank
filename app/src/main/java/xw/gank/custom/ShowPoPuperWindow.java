package xw.gank.custom;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.flyco.animation.BounceEnter.BounceTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.entity.DialogMenuItem;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.MaterialDialog;
import com.flyco.dialog.widget.NormalListDialog;

import java.util.ArrayList;

import com.xw.gank.R;

/**
 * Created by skysoft on 2018/9/27.
 */

public class ShowPoPuperWindow {

    private static BounceTopEnter mBasIn;
    private static SlideBottomExit mBasOut;

    public static void showPoPuperWindow(String[] stringItems, final Context context, final OnClickListern onClickListern) {

        final ActionSheetDialog dialog = new ActionSheetDialog(context, stringItems, null);
        dialog.isTitleShow(false).show();
        dialog.itemHeight(45);
        dialog.itemTextSize(17);
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (onClickListern != null) {
                    dialog.dismiss();
                    onClickListern.onClickListern(position);
                }
            }
        });
    }

    public static void showMaterialDialog(Context context, int number) {
        mBasIn = new BounceTopEnter();
        mBasOut = new SlideBottomExit();
        final MaterialDialog dialog = new MaterialDialog(context);
        dialog.btnNum(number);
        dialog.content("嗨！这是一个 MaterialDialogDefault. 它非常方便使用，你只需将它实例化，这个美观的对话框便会自动地显示出来它简洁小巧，完全遵照 Google 2014 年发布的 Material Design 风格，希望你能喜欢它！^ ^").btnText("取消", "确定")
                .showAnim(mBasIn)//
                .dismissAnim(mBasOut)//
                .show();
        dialog.setOnBtnClickL(new OnBtnClickL() {
            @Override
            public void onBtnClick() {
                dialog.dismiss();
            }
        }, new OnBtnClickL() {
            @Override
            public void onBtnClick() {

                dialog.dismiss();
            }
        });

    }

    public static void showIosNoTitleDialog(final Context context) {
        final String[] stringItems = {"版本更新", "帮助与反馈", "退出QQ"};
        final ActionSheetDialog dialog = new ActionSheetDialog(context, stringItems, null);
        dialog.isTitleShow(false).show();
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
                Toast.makeText(context, "" + stringItems[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    public static void showIosDialog(final Context context) {
        final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
        final ActionSheetDialog dialog = new ActionSheetDialog(context, stringItems, null);
        dialog.title("选择群消息提醒方式\r\n(该群在电脑的设置:接收消息并提醒)")
                .titleTextSize_SP(14.5f)
                .show();
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
                Toast.makeText(context, "" + stringItems[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    public static void NormalListDialogTwo(final Context context) {
        final String[] mStringItems = {"收藏", "下载", "分享", "删除", "歌手", "专辑", "收藏", "下载", "分享", "删除", "歌手", "专辑"};
        final NormalListDialog dialog = new NormalListDialog(context, mStringItems);
        dialog.title("请选择")
                .isTitleShow(true)//true or false
                .itemPressColor(Color.parseColor("#85D3EF"))
                .itemTextColor(Color.parseColor("#303030"))
                .itemTextSize(15)
                .cornerRadius(2)
                .widthScale(0.75f)
                // .heightScale(0.85f)
                .layoutAnimation(null).show();
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
                Toast.makeText(context, "" + mStringItems[position], Toast.LENGTH_SHORT).show();
            }
        });


    }

    public static void NormalListDialog(final Context context) {
        mBasIn = new BounceTopEnter();
        mBasOut = new SlideBottomExit();
        final ArrayList<DialogMenuItem> mMenuItems = new ArrayList<>();
        mMenuItems.add(new DialogMenuItem("收藏", R.mipmap.ic_launcher));
        mMenuItems.add(new DialogMenuItem("下载", R.mipmap.ic_launcher));
        mMenuItems.add(new DialogMenuItem("分享", R.mipmap.ic_launcher));
        mMenuItems.add(new DialogMenuItem("删除", R.mipmap.ic_launcher));
        mMenuItems.add(new DialogMenuItem("歌手", R.mipmap.ic_launcher));
        mMenuItems.add(new DialogMenuItem("专辑", R.mipmap.ic_launcher));
        mMenuItems.add(new DialogMenuItem("删除", R.mipmap.ic_launcher));
        mMenuItems.add(new DialogMenuItem("歌手", R.mipmap.ic_launcher));
        final NormalListDialog dialog = new NormalListDialog(context, mMenuItems);
        dialog.title("请选择")
                .showAnim(mBasIn)
                .dismissAnim(mBasOut)
                .titleTextSize_SP(16)
                 .titleBgColor(Color.parseColor("#409ED7"))
                .itemPressColor(Color.parseColor("#85D3EF"))
                .itemTextColor(Color.parseColor("#303030"))
                .itemTextSize(14)
                .cornerRadius(4)
                .widthScale(0.8f)
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialog.dismiss();
                Toast.makeText(context, "" + mMenuItems.get(i).mOperName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public interface onButtonClickListern {
        void cancle();

        void confirm();

    }

    public interface OnClickListern {
        void onClickListern(int position);
    }
}
