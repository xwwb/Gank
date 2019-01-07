package xw.gank.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xw.gank.R;
import com.xw.library.utils.utils.Utils;

import java.util.List;

import xw.gank.info.MoviesBean;

/**
 * Created by Administrator on 2018/4/27.
 */

public class MoveRecycleViewAdapter extends BaseRecycleAdapter<MoviesBean.SubjectsBean> {
    private OnItemClickListern onItemClickListern;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setOnItemClickListern(OnItemClickListern onItemClickListern) {
        this.onItemClickListern = onItemClickListern;
    }

    public MoveRecycleViewAdapter(List<MoviesBean.SubjectsBean> datas) {
        super(datas);
    }


    @Override
    protected void bindData(BaseViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListern!=null){
                    onItemClickListern.OnClickListern(position);
                }

            }
        });
        ImageView imageView = (ImageView) holder.getView(R.id.image);
        TextView textView = (TextView) holder.getView(R.id.text);

        MoviesBean.SubjectsBean subjectsBean = datas.get(position);
        String large = subjectsBean.getImages().getSmall();

       // String small = subjectsBean.getDirectors().get(0).getAvatars().getLarge();
        String original_title = subjectsBean.getOriginal_title();

        Utils.setPicassoImage(context,large,imageView,R.mipmap.plachold);
        textView.setText(""+original_title);


    }

    @Override
    public int getLayoutId() {
        return R.layout.recycleview_item;

    }
    public interface OnItemClickListern {
        void OnClickListern(int position);
    }
}
