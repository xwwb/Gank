package xw.gank.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xw.gank.R;

import java.util.List;

import xw.gank.info.GankModel;

public class OtherGankRecycleViewAdapter extends BaseMultiItemQuickAdapter<GankModel.ResultsBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private Context context;
    int flage;

    public OtherGankRecycleViewAdapter(List<GankModel.ResultsBean> data, Context context, int flage) {
        super(data);
        this.context = context;
        this.flage = flage;
        addItemType(GankModel.TEXT, R.layout.other_gank_item_layout);
        addItemType(GankModel.IMG, R.layout.other_gank_item_no_image_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankModel.ResultsBean item) {
        String timer;
        switch (helper.getItemViewType()) {
            case GankModel.TEXT:
                ImageView imageView = helper.getView(R.id.gank_item_image);
                TextView descTextView = helper.getView(R.id.gank_item_desc);
                TextView authorTextView = helper.getView(R.id.gank_item_author);
                TextView timerTextView = helper.getView(R.id.gank_item_timer);
                String imageUrl;
                String s = item.toString();
                Log.i("====s", "" + s);
                if (null != item.getImages()) {
                    List<String> images = item.getImages();
                    if (images.size() != 0) {
                        imageUrl = images.get(0);
                        imageView.setVisibility(View.VISIBLE);
                        Glide.with(context).load(imageUrl).placeholder(R.mipmap.ic_loading).error(R.mipmap.ic_load_fail).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                    }
                } else {
//            imageView.setVisibility(View.GONE);
//            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
//            layoutParams.height=300;
//            cardView.setLayoutParams(layoutParams);
                }
                String desc = item.getDesc();
                descTextView.setText("" + desc);
                authorTextView.setText("" + item.getWho());

                if (flage == 2) {
                    timer = item.getPublishedAt();
                    timerTextView.setText("" + timer.substring(0, 10));
                } else {
                    timer = item.getCreatedAt();
                    timerTextView.setText("" + timer.substring(0, 10));
                }
                //timerTextView.setText("" + item.getCreatedAt().substring(0, 10));
                //     Picasso.with(context).load(imageUrl).into(imageView);
                break;
            case GankModel.IMG:
                TextView desc_TextView = helper.getView(R.id.gank_item_desc);
                TextView author_TextView = helper.getView(R.id.gank_item_author);
                TextView timer_TextView = helper.getView(R.id.gank_item_timer);
                desc_TextView.setText("" + item.getDesc());
                author_TextView.setText("" + item.getWho());

                if (flage == 2) {
                    timer = item.getPublishedAt();
                } else {
                    timer = item.getCreatedAt();
                    timer_TextView.setText("" + timer.substring(0, 10));
                }

                break;

        }
    }
}
