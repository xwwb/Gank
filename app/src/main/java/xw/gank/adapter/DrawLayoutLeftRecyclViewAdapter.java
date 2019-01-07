package xw.gank.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class DrawLayoutLeftRecyclViewAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public DrawLayoutLeftRecyclViewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
