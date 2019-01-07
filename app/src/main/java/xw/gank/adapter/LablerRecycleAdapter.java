package xw.gank.adapter;

import android.widget.TextView;

import com.xw.gank.R;

import java.util.List;
/**
 * Created by Administrator on 2018/5/29.
 */

public class LablerRecycleAdapter extends BaseRecycleAdapter<String> {
    public LablerRecycleAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        TextView title = (TextView) holder.getView(R.id.lableitem_textview);
        String s = datas.get(position);
        title.setText(""+s);
    }

    @Override
    public int getLayoutId() {
        return R.layout.lable_itemlayout;
    }
}
