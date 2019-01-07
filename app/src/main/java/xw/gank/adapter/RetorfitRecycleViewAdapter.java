package xw.gank.adapter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.xw.gank.R;

import java.util.List;

import xw.gank.custom.RatioImageView;
import xw.gank.info.GirlItemData;

/**
 * Created by Administrator on 2018/4/27.
 */

public class RetorfitRecycleViewAdapter extends BaseQuickAdapter<GirlItemData, BaseViewHolder> {

    private Context context;
    List<GirlItemData> data;

    public RetorfitRecycleViewAdapter(Context context, List<GirlItemData> data) {
        super(R.layout.retrofit_recycleview_item, data);
        this.context = context;
    }

    @NonNull
    @Override
    public List<GirlItemData> getData() {
        return data;
    }

    public void setData(List<GirlItemData> data) {
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, GirlItemData item) {
        RatioImageView photoIv = helper.itemView.findViewById(R.id.photo_iv);
        String url = item.getUrl();
        photoIv.setOriginalSize(item.getWidth(), item.getHeight());
        //Glide.with(context).load(url).placeholder(R.mipmap.img_default_meizi).error(R.mipmap.ic_load_fail).diskCacheStrategy(DiskCacheStrategy.ALL).into(photoIv);

                Picasso.with(context).load(url)
                .placeholder(R.mipmap.img_default_meizi)
                .error(R.mipmap.ic_load_fail).into(photoIv);

    }
}
