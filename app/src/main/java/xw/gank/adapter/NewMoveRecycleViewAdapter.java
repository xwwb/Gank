package xw.gank.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xw.gank.R;

import java.util.List;

import xw.gank.custom.ImageViewRoundOval;
import xw.gank.info.MoviesBean;

/**
 * Created by Administrator on 2018/4/27.
 */

public class NewMoveRecycleViewAdapter extends BaseQuickAdapter<MoviesBean.SubjectsBean,BaseViewHolder> {

    private Context context;

    public NewMoveRecycleViewAdapter(Context context, @Nullable List<MoviesBean.SubjectsBean> data) {
        super(R.layout.recycleview_item, data);
        this.context=context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, MoviesBean.SubjectsBean item) {
        ImageViewRoundOval imageView = (ImageViewRoundOval) holder.getView(R.id.image);
        imageView.setType(ImageViewRoundOval.TYPE_ROUND);
        imageView.setRoundRadius(8);
        TextView textView = holder.getView(R.id.text);
        TextView year = holder.getView(R.id.year);
        TextView zhuyan = holder.getView(R.id.zhuyan);
        TextView zhuti = holder.getView(R.id.zhuti_text);
        TextView daoyan = holder.getView(R.id.dao_yan);
        List<String> genres = item.getGenres();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i <genres.size() ; i++) {
            String s = genres.get(i);
            if (i==0){
                stringBuffer.append(s);

            }else {
                stringBuffer.append("&").append(s);
            }
        }
        zhuti.setText(String.format("主题:%s", stringBuffer.toString()));
        StringBuilder stringBuffer1 = new StringBuilder();
        List<MoviesBean.SubjectsBean.CastsBean> casts = item.getCasts();
        for (int i = 0; i < casts.size(); i++) {
            MoviesBean.SubjectsBean.CastsBean castsBean = casts.get(i);
            String name = castsBean.getName();
            if (i==0){
                stringBuffer1.append(name);
            }else {
                stringBuffer1.append("&").append(name);
            }
        }
        zhuyan.setText(String.format("主演:%s", stringBuffer1.toString()));
        // MoviesBean.SubjectsBean subjectsBean = datas.get(position);
        String year1 = item.getYear();
        year.setText(String.format("年份:%s", year1));
        List<MoviesBean.SubjectsBean.DirectorsBean> directors = item.getDirectors();
        String name = directors.get(0).getName();
        daoyan.setText(String.format("导演:%s", name));

        String large = item.getImages().getSmall();

       // String small = subjectsBean.getDirectors().get(0).getAvatars().getLarge();
        String original_title = item.getOriginal_title();
        Glide.with(context).load(large).placeholder(R.mipmap.img_default_movie).error(R.mipmap.ic_load_fail).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        //Utils.setPicassoImage(context,large,imageView,R.mipmap.plachold);
        textView.setText(String.format("%s", original_title));
    }
//
//    public void setOnItemClickListern(OnItemClickListern onItemClickListern) {
//        this.onItemClickListern = onItemClickListern;
//    }
//
//    public NewMoveRecycleViewAdapter(List<MoviesBean.SubjectsBean> datas) {
//        super(datas);
//    }
//
//
//    @Override
//    protected void bindData(BaseViewHolder holder, final int position) {
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onItemClickListern!=null){
//                    onItemClickListern.OnClickListern(position);
//                }
//
//            }
//        });
//        ImageView imageView = (ImageView) holder.getView(R.id.image);
//        TextView textView = (TextView) holder.getView(R.id.text);
//
//        MoviesBean.SubjectsBean subjectsBean = datas.get(position);
//        String large = subjectsBean.getImages().getSmall();
//
//       // String small = subjectsBean.getDirectors().get(0).getAvatars().getLarge();
//        String original_title = subjectsBean.getOriginal_title();
//
//        Utils.setPicassoImage(context,large,imageView,R.mipmap.plachold);
//        textView.setText(""+original_title);
//
//
//    }
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.recycleview_item;
//
//    }
//    public interface OnItemClickListern {
//        void OnClickListern(int position);
//    }
}
