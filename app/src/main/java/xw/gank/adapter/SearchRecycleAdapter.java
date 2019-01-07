package xw.gank.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cy.cyflowlayoutlibrary.FlowLayout;
import com.cy.cyflowlayoutlibrary.FlowLayoutAdapter;
import com.xw.gank.R;

import java.util.List;

import xw.gank.activity.GankMoveActivity;
import xw.gank.config.Config;
import xw.gank.info.AboutAndroidBean;

public class SearchRecycleAdapter extends BaseQuickAdapter<AboutAndroidBean.DataBean, BaseViewHolder> {

    public SearchRecycleAdapter(Context context, @Nullable List<AboutAndroidBean.DataBean> data) {
        super(R.layout.seach_recycle_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AboutAndroidBean.DataBean item) {
        FlowLayout flowLayout = helper.getView(R.id.flowlayout);
        TextView title = helper.getView(R.id.seach_item_title);
        title.setText("" + item.getName());
        List<AboutAndroidBean.DataBean.ChildrenBean> children = item.getChildren();

        FlowLayoutAdapter<AboutAndroidBean.DataBean.ChildrenBean> flowLayoutAdapter = new FlowLayoutAdapter<AboutAndroidBean.DataBean.ChildrenBean>(children) {
            @Override
            public void bindDataToView(ViewHolder holder, int position, AboutAndroidBean.DataBean.ChildrenBean bean) {
                holder.setText(R.id.seach_tv, bean.getName());
            }

            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(int position, AboutAndroidBean.DataBean.ChildrenBean bean) {
                String name = bean.getName();
                Intent intent = new Intent(mContext,GankMoveActivity.class);
                intent.putExtra("type",""+name);
                intent.setFlags(Config.FLAG);
                mContext.startActivity(intent);
            }

            @Override
            public int getItemLayoutID(int position, AboutAndroidBean.DataBean.ChildrenBean bean) {
                return R.layout.item_tv;
            }
        };
        flowLayout.setAdapter(flowLayoutAdapter);
    }
}
